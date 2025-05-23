package com.tencent.mobileqq.guild.setting.qrcode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.main.viewmodel.base.BaseChannelViewModel;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment;
import com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeViewModel;
import com.tencent.mobileqq.guild.setting.qrcode.view.CenterCardHighlightContent;
import com.tencent.mobileqq.guild.setting.qrcode.view.CenterCardHighlightNum;
import com.tencent.mobileqq.guild.setting.qrcode.view.CenterCardHighlightQrCode;
import com.tencent.mobileqq.guild.setting.qrcode.view.GuildQrCodeCenterCard;
import com.tencent.mobileqq.guild.setting.qrcode.view.GuildSelectableTextView;
import com.tencent.mobileqq.guild.setting.qrcode.view.PlatformType;
import com.tencent.mobileqq.guild.setting.qrcode.view.SharePlatformItemData;
import com.tencent.mobileqq.guild.setting.qrcode.view.SharePlatformItemView;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.ar;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mvvm.QLifeCycleFragment;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;
import pr1.VisitorColorPicker;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, scene = QQPermissionConstants.Business.SCENE.QQCHANEL_QRCODE_SAVE_ALBUM)
/* loaded from: classes14.dex */
public class GuildQRCodeFragment extends QPublicBaseFragment implements View.OnClickListener {
    private QRCodeStyle C;
    private View G;
    private LinearLayout H;
    private LinearLayout I;
    private Button J;
    private ImageView K;
    private ImageView L;
    private TextView M;
    private View N;
    private GuildQrCodeCenterCard P;
    private GuildQrCodeCenterCard Q;
    private GuildSelectableTextView R;
    private ScrollView S;
    private com.tencent.mobileqq.mvvm.d T;
    private QQProgressDialog V;
    private QQPermission W;
    private IGProGuildInfo X;
    private Bitmap Y;
    private int Z;

    /* renamed from: a0 */
    private volatile Bitmap f234850a0;

    /* renamed from: b0 */
    private volatile boolean f234851b0;

    /* renamed from: d0 */
    private String f234853d0;

    /* renamed from: i0 */
    private GuildQRCodeViewModel f234858i0;

    /* renamed from: j0 */
    private String f234859j0;

    /* renamed from: k0 */
    private Map<QRCodeStyle, h02.a> f234860k0;
    private final QRCodeStyle[] D = QRCodeStyle.values();
    private final QRCodeStyle E = QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_GUILD_COVER;
    private String F = "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_logo_black.png";
    private WeakReference<GuildQRCodeSettingDialog> U = new WeakReference<>(null);

    /* renamed from: c0 */
    private volatile boolean f234852c0 = false;

    /* renamed from: e0 */
    private final VisitorColorPicker f234854e0 = new VisitorColorPicker();

    /* renamed from: f0 */
    private final ArrayList<SharePlatformItemData> f234855f0 = new ArrayList<>();

    /* renamed from: g0 */
    private final ConcurrentHashMap<QRCodeStyle, Bitmap> f234856g0 = new ConcurrentHashMap<>();

    /* renamed from: h0 */
    private final Object f234857h0 = new Object();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment$5 */
    /* loaded from: classes14.dex */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: d */
        final /* synthetic */ Runnable f234861d;

        /* renamed from: e */
        final /* synthetic */ Drawable f234862e;

        /* renamed from: f */
        final /* synthetic */ h02.b f234863f;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment$5$1 */
        /* loaded from: classes14.dex */
        class AnonymousClass1 implements Runnable {

            /* renamed from: d */
            final /* synthetic */ Bitmap f234864d;

            /* renamed from: e */
            final /* synthetic */ long f234865e;

            /* renamed from: f */
            final /* synthetic */ long f234866f;

            AnonymousClass1(Bitmap bitmap, long j3, long j16) {
                r2 = bitmap;
                r3 = j3;
                r5 = j16;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                if (r3 instanceof BitmapDrawable) {
                    Context requireContext = GuildQRCodeFragment.this.requireContext();
                    AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                    bitmap = ar.f(requireContext, r4, GuildQRCodeFragment.this.P, ((BitmapDrawable) r3).getBitmap(), r2);
                } else {
                    bitmap = null;
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    synchronized (GuildQRCodeFragment.this.f234857h0) {
                        GuildQRCodeFragment.this.f234856g0.put(GuildQRCodeFragment.this.C, bitmap);
                    }
                    r2.run();
                    QLog.d("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache ", GuildQRCodeFragment.this.C, "; uiCost:" + (r3 - r5));
                    return;
                }
                QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache mQRCodeCardCache error; uiCost:" + (r3 - r5));
                r2.run();
            }
        }

        AnonymousClass5(Runnable runnable, Drawable drawable, h02.b bVar) {
            r2 = runnable;
            r3 = drawable;
            r4 = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            GuildQRCodeFragment.this.P.setDrawingCacheEnabled(true);
            GuildQRCodeFragment.this.P.buildDrawingCache();
            Bitmap drawingCache = GuildQRCodeFragment.this.P.getDrawingCache();
            if (drawingCache == null) {
                QLog.w("Guild.share.GuildQRCodeFragment", 1, "getQrCodeShareImg viewCacheBitmap is null");
                GuildQRCodeFragment.this.P.setDrawingCacheEnabled(false);
                GuildQRCodeFragment.this.P.destroyDrawingCache();
                r2.run();
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment.5.1

                /* renamed from: d */
                final /* synthetic */ Bitmap f234864d;

                /* renamed from: e */
                final /* synthetic */ long f234865e;

                /* renamed from: f */
                final /* synthetic */ long f234866f;

                AnonymousClass1(Bitmap drawingCache2, long j3, long currentTimeMillis2) {
                    r2 = drawingCache2;
                    r3 = j3;
                    r5 = currentTimeMillis2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    if (r3 instanceof BitmapDrawable) {
                        Context requireContext = GuildQRCodeFragment.this.requireContext();
                        AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                        bitmap = ar.f(requireContext, r4, GuildQRCodeFragment.this.P, ((BitmapDrawable) r3).getBitmap(), r2);
                    } else {
                        bitmap = null;
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        synchronized (GuildQRCodeFragment.this.f234857h0) {
                            GuildQRCodeFragment.this.f234856g0.put(GuildQRCodeFragment.this.C, bitmap);
                        }
                        r2.run();
                        QLog.d("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache ", GuildQRCodeFragment.this.C, "; uiCost:" + (r3 - r5));
                        return;
                    }
                    QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache mQRCodeCardCache error; uiCost:" + (r3 - r5));
                    r2.run();
                }
            }, 64, null, true);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment$7 */
    /* loaded from: classes14.dex */
    public class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File ji5 = GuildQRCodeFragment.this.ji(false);
            Bitmap bitmap = (Bitmap) GuildQRCodeFragment.this.f234856g0.get(GuildQRCodeFragment.this.C);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (!com.tencent.mobileqq.guild.util.p.d(ji5, bitmap)) {
                    QQToastUtil.showQQToastInUiThread(1, "\u4fdd\u5b58\u56fe\u7247\u5931\u8d25");
                    QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveFileToLocal writeBitmapToFile error");
                    return;
                } else {
                    ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(GuildQRCodeFragment.this.getContext(), ji5.getAbsolutePath());
                    return;
                }
            }
            QQToastUtil.showQQToastInUiThread(1, "\u4fdd\u5b58\u56fe\u7247\u5931\u8d25");
            QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveFileToLocal bitmap get error");
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment$8 */
    /* loaded from: classes14.dex */
    public class AnonymousClass8 implements Runnable {

        /* renamed from: d */
        final /* synthetic */ SharePlatformItemData f234868d;

        AnonymousClass8(SharePlatformItemData sharePlatformItemData) {
            r2 = sharePlatformItemData;
        }

        @Override // java.lang.Runnable
        public void run() {
            File ji5 = GuildQRCodeFragment.this.ji(true);
            Bitmap bitmap = (Bitmap) GuildQRCodeFragment.this.f234856g0.get(GuildQRCodeFragment.this.C);
            if (bitmap != null && !bitmap.isRecycled()) {
                if (!com.tencent.mobileqq.guild.util.p.d(ji5, bitmap)) {
                    QLog.e("Guild.share.GuildQRCodeFragment", 1, "handlePlatformShareClick writeBitmapToFile error");
                    return;
                }
                if (r2.getPlatformType() == PlatformType.QQ_FRIEND) {
                    GuildQRCodeFragment.this.si(ji5);
                    return;
                }
                if (r2.getPlatformType() == PlatformType.QQ_CHANNEL) {
                    GuildQRCodeFragment.this.ri(ji5);
                    return;
                }
                if (r2.getPlatformType() == PlatformType.WE_CHAT) {
                    GuildQRCodeFragment.this.ui(ji5);
                    return;
                } else if (r2.getPlatformType() == PlatformType.WE_CHAT_CIRCLE) {
                    GuildQRCodeFragment.this.vi(ji5);
                    return;
                } else {
                    if (r2.getPlatformType() == PlatformType.QQ_ZONE) {
                        GuildQRCodeFragment.this.ti(ji5);
                        return;
                    }
                    return;
                }
            }
            QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveFileToLocal bitmap get error");
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public enum QRCodeStyle {
        HIGHLIGHT_CONTENT_WITH_OFFICIAL_BG,
        HIGHLIGHT_CONTENT_WITH_GUILD_COVER,
        HIGHLIGHT_QR_CODE_WITH_OFFICIAL_BG,
        HIGHLIGHT_QR_CODE_WITH_GUILD_COVER,
        HIGHLIGHT_NUM_WITH_OFFICIAL_BG,
        HIGHLIGHT_NUM_WITH_GUILD_COVER
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            GuildQRCodeFragment.this.G.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            GuildQRCodeFragment.this.Pi();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b extends GuildPicStateListener {

        /* renamed from: e */
        final /* synthetic */ Resources f234870e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z16, Resources resources) {
            super(z16);
            this.f234870e = resources;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            GuildQRCodeFragment.this.f234851b0 = false;
            if (GuildQRCodeFragment.this.Ei(loadState, option)) {
                GuildQRCodeFragment.this.Zi();
                return;
            }
            GuildQRCodeFragment guildQRCodeFragment = GuildQRCodeFragment.this;
            if (guildQRCodeFragment.Gi(guildQRCodeFragment.C)) {
                GuildQRCodeFragment.this.Wi(new BitmapDrawable(this.f234870e, option.getResultBitMap()));
            } else {
                if (GuildQRCodeFragment.this.Y == null) {
                    Bitmap resultBitMap = option.getResultBitMap();
                    GuildQRCodeFragment.this.Z = GuildBannerPalette.e(resultBitMap);
                    GuildQRCodeFragment.this.Y = ar.e(option.getResultBitMap(), GuildQRCodeFragment.this.G, GuildQRCodeFragment.this.Z);
                }
                GuildQRCodeFragment.this.Wi(new BitmapDrawable(this.f234870e, GuildQRCodeFragment.this.Y));
            }
            GuildQRCodeFragment.this.Vi();
            GuildQRCodeFragment.this.Pi();
            GuildQRCodeFragment guildQRCodeFragment2 = GuildQRCodeFragment.this;
            guildQRCodeFragment2.Xi(guildQRCodeFragment2.f234853d0, option.getResultBitMap());
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c extends GuildPicStateListener {
        c(boolean z16) {
            super(z16);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            if (GuildQRCodeFragment.this.Ei(loadState, option)) {
                return;
            }
            GuildQRCodeFragment.this.f234850a0 = option.getResultBitMap();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class d implements com.tencent.mobileqq.component.qrcode.h {
        d() {
        }

        public /* synthetic */ void e() {
            GuildQRCodeFragment.this.P.mIvQRCode.e(true);
        }

        public /* synthetic */ void f() {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.n
                @Override // java.lang.Runnable
                public final void run() {
                    GuildQRCodeFragment.d.this.e();
                }
            });
        }

        public /* synthetic */ void g() {
            GuildQRCodeFragment.this.Si(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildQRCodeFragment.d.this.f();
                }
            });
        }

        @Override // com.tencent.mobileqq.component.qrcode.h
        public void a() {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.l
                @Override // java.lang.Runnable
                public final void run() {
                    GuildQRCodeFragment.d.this.g();
                }
            }, 250L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class e extends QQPermission.BasePermissionsListener {
        e() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            GuildQRCodeFragment.this.Ri();
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static /* synthetic */ class f {

        /* renamed from: a */
        static final /* synthetic */ int[] f234875a;

        /* renamed from: b */
        static final /* synthetic */ int[] f234876b;

        static {
            int[] iArr = new int[PlatformType.values().length];
            f234876b = iArr;
            try {
                iArr[PlatformType.QQ_ZONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f234876b[PlatformType.WE_CHAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f234876b[PlatformType.QQ_FRIEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f234876b[PlatformType.QQ_CHANNEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f234876b[PlatformType.WE_CHAT_CIRCLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[QRCodeStyle.values().length];
            f234875a = iArr2;
            try {
                iArr2[QRCodeStyle.HIGHLIGHT_CONTENT_WITH_OFFICIAL_BG.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f234875a[QRCodeStyle.HIGHLIGHT_CONTENT_WITH_GUILD_COVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f234875a[QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_OFFICIAL_BG.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f234875a[QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_GUILD_COVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f234875a[QRCodeStyle.HIGHLIGHT_NUM_WITH_OFFICIAL_BG.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f234875a[QRCodeStyle.HIGHLIGHT_NUM_WITH_GUILD_COVER.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class g implements IDynamicParams {

        /* renamed from: a */
        private final WeakReference<GuildQRCodeFragment> f234877a;

        public g(GuildQRCodeFragment guildQRCodeFragment) {
            this.f234877a = new WeakReference<>(guildQRCodeFragment);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            HashMap hashMap = new HashMap();
            GuildQRCodeFragment guildQRCodeFragment = this.f234877a.get();
            if (guildQRCodeFragment != null) {
                IGProGuildInfo iGProGuildInfo = guildQRCodeFragment.X;
                hashMap.put("sgrp_channel_id", iGProGuildInfo.getGuildID());
                hashMap.put("sgrp_user_type", Integer.valueOf(v.d(iGProGuildInfo.isMember(), iGProGuildInfo.getUserType())));
                hashMap.put("sgrp_code_validity", Integer.valueOf(iGProGuildInfo.getQRCodePeriod()));
            }
            return hashMap;
        }
    }

    private void Ai() {
        this.f234860k0 = new HashMap();
        int parseColor = Color.parseColor("#222222");
        int parseColor2 = Color.parseColor("#0D4B7D");
        int d16 = bi.d();
        String coverUrl = this.X.getCoverUrl(d16, (int) (d16 / 2.15f));
        this.f234860k0.put(QRCodeStyle.HIGHLIGHT_CONTENT_WITH_OFFICIAL_BG, new h02.a("https://downv6.qq.com/innovate/guild/qr_code/guild_qr_code_new_bkg_1.png", parseColor, "https://downv6.qq.com/innovate/guild/empty_view/guild_qr_logo_3-2.png"));
        this.f234860k0.put(QRCodeStyle.HIGHLIGHT_CONTENT_WITH_GUILD_COVER, new h02.a(coverUrl, parseColor, "https://downv6.qq.com/innovate/guild/empty_view/guild_qr_logo_3-2.png"));
        this.f234860k0.put(QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_OFFICIAL_BG, new h02.a("https://downv6.qq.com/innovate/guild/qr_code/guild_qr_code_new_bkg_2.png", parseColor2, "https://downv6.qq.com/innovate/guild/empty_view/guild_qr_logo_1-2.png"));
        this.f234860k0.put(QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_GUILD_COVER, new h02.a(coverUrl, parseColor, "https://downv6.qq.com/innovate/guild/empty_view/guild_qr_logo_3-2.png"));
        this.f234860k0.put(QRCodeStyle.HIGHLIGHT_NUM_WITH_OFFICIAL_BG, new h02.a("https://downv6.qq.com/innovate/guild/qr_code/guild_qr_code_new_bkg_3.png", parseColor, "https://downv6.qq.com/innovate/guild/empty_view/guild_qr_logo_3-2.png"));
        this.f234860k0.put(QRCodeStyle.HIGHLIGHT_NUM_WITH_GUILD_COVER, new h02.a(coverUrl, parseColor, "https://downv6.qq.com/innovate/guild/empty_view/guild_qr_logo_3-2.png"));
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.GuildQRCodeFragment", 1, " initThemeMap: " + this.f234860k0);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Bi() {
        this.K = (ImageView) this.G.findViewById(R.id.wk8);
        this.L = (ImageView) this.G.findViewById(R.id.wkr);
        this.M = (TextView) this.G.findViewById(R.id.x2z);
        ScrollView scrollView = (ScrollView) this.G.findViewById(R.id.wzh);
        this.S = scrollView;
        scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.setting.qrcode.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean Ji;
                Ji = GuildQRCodeFragment.Ji(view, motionEvent);
                return Ji;
            }
        });
        FragmentActivity activity = getActivity();
        ImmersiveUtils.clearCoverForStatus(activity.getWindow(), true);
        com.tencent.mobileqq.guild.base.extension.h.c(this);
        ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
        }
    }

    private boolean Ci() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            QQToastUtil.showQQToast(1, R.string.f143560me);
            return false;
        }
        this.f234859j0 = activity.getIntent().getExtras().getString("extra_guild_id");
        com.tencent.mobileqq.mvvm.d ph5 = QLifeCycleFragment.ph(getQBaseActivity());
        this.T = ph5;
        this.C = this.E;
        GuildQRCodeViewModel guildQRCodeViewModel = (GuildQRCodeViewModel) com.tencent.mobileqq.mvvm.h.b(ph5, BaseChannelViewModel.sViewModelFactory).get(GuildQRCodeViewModel.class);
        this.f234858i0 = guildQRCodeViewModel;
        guildQRCodeViewModel.init(this.f234859j0, "pic" + (this.C.ordinal() + 1));
        IGProGuildInfo fetchInfo = this.f234858i0.fetchInfo();
        this.X = fetchInfo;
        if (fetchInfo == null) {
            activity.finish();
            QQToastUtil.showQQToast(1, R.string.f143560me);
            return false;
        }
        this.f234858i0.getUpdateType().observe(this.T, new Observer() { // from class: com.tencent.mobileqq.guild.setting.qrcode.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQRCodeFragment.this.Ki((GuildQRCodeViewModel.b) obj);
            }
        });
        this.f234858i0.getUpdateQrCodeUrl().observe(this.T, new Observer() { // from class: com.tencent.mobileqq.guild.setting.qrcode.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQRCodeFragment.this.aj((String) obj);
            }
        });
        this.f234858i0.getUpdateGuildInfo().observe(this.T, new Observer() { // from class: com.tencent.mobileqq.guild.setting.qrcode.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQRCodeFragment.this.Li((IGProGuildInfo) obj);
            }
        });
        this.f234858i0.getPageState().observe(this.T, new Observer() { // from class: com.tencent.mobileqq.guild.setting.qrcode.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildQRCodeFragment.this.Mi((GuildQRCodeViewModel.PageState) obj);
            }
        });
        return true;
    }

    private boolean Di(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            return false;
        }
        return true;
    }

    public boolean Ei(LoadState loadState, Option option) {
        Bitmap bitmap;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("preloadPic: state = ");
            sb5.append(loadState);
            sb5.append(", bitmap = ");
            if (option != null) {
                bitmap = option.getResultBitMap();
            } else {
                bitmap = null;
            }
            sb5.append(bitmap);
            QLog.i("Guild.share.GuildQRCodeFragment", 2, sb5.toString());
        }
        if (loadState != LoadState.STATE_SUCCESS) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "preloadPic: failed state = " + loadState);
            return true;
        }
        if (option != null && option.getResultBitMap() != null) {
            if (Di(getActivity())) {
                QLog.w("Guild.share.GuildQRCodeFragment", 1, "getActivity().isFinishing()!");
                return true;
            }
            return false;
        }
        QLog.w("Guild.share.GuildQRCodeFragment", 1, "preloadPic: getResultBitMap is null!");
        return true;
    }

    private boolean Fi(QRCodeStyle qRCodeStyle) {
        if (qRCodeStyle != QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_OFFICIAL_BG && qRCodeStyle != QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_GUILD_COVER) {
            return false;
        }
        return true;
    }

    public boolean Gi(QRCodeStyle qRCodeStyle) {
        if (qRCodeStyle != QRCodeStyle.HIGHLIGHT_CONTENT_WITH_OFFICIAL_BG && qRCodeStyle != QRCodeStyle.HIGHLIGHT_NUM_WITH_OFFICIAL_BG && qRCodeStyle != QRCodeStyle.HIGHLIGHT_QR_CODE_WITH_OFFICIAL_BG) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean Ji(View view, MotionEvent motionEvent) {
        return true;
    }

    public /* synthetic */ void Ki(GuildQRCodeViewModel.b bVar) {
        int intValue = bVar.f234881a.intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue == 3) {
                        QQToast.makeText(getContext(), 1, bVar.f234882b, 0).show();
                        return;
                    }
                    return;
                }
            } else {
                QQToast.makeText(getContext(), 1, bVar.f234882b, 0).show();
                if (getActivity() != null) {
                    getActivity().finish();
                    return;
                }
                return;
            }
        }
        this.V.dismiss();
        Yi(true);
    }

    public /* synthetic */ void Li(IGProGuildInfo iGProGuildInfo) {
        fi();
        this.X = iGProGuildInfo;
        GuildQRCodeSettingDialog guildQRCodeSettingDialog = this.U.get();
        if (guildQRCodeSettingDialog == null) {
            return;
        }
        guildQRCodeSettingDialog.rh(this.f234859j0, iGProGuildInfo.getQRCodePeriod());
    }

    public /* synthetic */ void Mi(GuildQRCodeViewModel.PageState pageState) {
        FragmentActivity activity;
        if (pageState == GuildQRCodeViewModel.PageState.END && (activity = getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
            activity.finish();
        }
    }

    public static /* synthetic */ void Oi(int i3) {
        QLog.d("Guild.share.GuildQRCodeFragment", 1, "mIvQRCode.refreshContent: errCode:" + i3);
    }

    public void Pi() {
        u.s(this.F, new c(true));
    }

    private void Qi(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, map);
    }

    public void Ri() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment.7
            AnonymousClass7() {
            }

            @Override // java.lang.Runnable
            public void run() {
                File ji5 = GuildQRCodeFragment.this.ji(false);
                Bitmap bitmap = (Bitmap) GuildQRCodeFragment.this.f234856g0.get(GuildQRCodeFragment.this.C);
                if (bitmap != null && !bitmap.isRecycled()) {
                    if (!com.tencent.mobileqq.guild.util.p.d(ji5, bitmap)) {
                        QQToastUtil.showQQToastInUiThread(1, "\u4fdd\u5b58\u56fe\u7247\u5931\u8d25");
                        QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveFileToLocal writeBitmapToFile error");
                        return;
                    } else {
                        ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(GuildQRCodeFragment.this.getContext(), ji5.getAbsolutePath());
                        return;
                    }
                }
                QQToastUtil.showQQToastInUiThread(1, "\u4fdd\u5b58\u56fe\u7247\u5931\u8d25");
                QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveFileToLocal bitmap get error");
            }
        }, 64, null, true);
    }

    public void Si(final Runnable runnable) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildQRCodeFragment.this.Ni(runnable);
            }
        }, 64, null, true);
    }

    /* renamed from: Ti */
    public void Ni(Runnable runnable) {
        if (Di(getActivity())) {
            QLog.e("Guild.share.GuildQRCodeFragment", 1, this.C, "saveShareImgCache activity error");
            runnable.run();
            return;
        }
        Bitmap bitmap = this.f234856g0.get(this.C);
        if (bitmap != null && !bitmap.isRecycled()) {
            QLog.d("Guild.share.GuildQRCodeFragment", 1, this.C, "saveShareImgCache use cache bitmap");
            runnable.run();
            return;
        }
        h02.b f16 = h02.b.c().g(this.f234850a0).f();
        if (f16.b() == null) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment.5

                /* renamed from: d */
                final /* synthetic */ Runnable f234861d;

                /* renamed from: e */
                final /* synthetic */ Drawable f234862e;

                /* renamed from: f */
                final /* synthetic */ h02.b f234863f;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment$5$1 */
                /* loaded from: classes14.dex */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: d */
                    final /* synthetic */ Bitmap f234864d;

                    /* renamed from: e */
                    final /* synthetic */ long f234865e;

                    /* renamed from: f */
                    final /* synthetic */ long f234866f;

                    AnonymousClass1(Bitmap drawingCache2, long j3, long currentTimeMillis2) {
                        r2 = drawingCache2;
                        r3 = j3;
                        r5 = currentTimeMillis2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap;
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        if (r3 instanceof BitmapDrawable) {
                            Context requireContext = GuildQRCodeFragment.this.requireContext();
                            AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                            bitmap = ar.f(requireContext, r4, GuildQRCodeFragment.this.P, ((BitmapDrawable) r3).getBitmap(), r2);
                        } else {
                            bitmap = null;
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            synchronized (GuildQRCodeFragment.this.f234857h0) {
                                GuildQRCodeFragment.this.f234856g0.put(GuildQRCodeFragment.this.C, bitmap);
                            }
                            r2.run();
                            QLog.d("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache ", GuildQRCodeFragment.this.C, "; uiCost:" + (r3 - r5));
                            return;
                        }
                        QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache mQRCodeCardCache error; uiCost:" + (r3 - r5));
                        r2.run();
                    }
                }

                AnonymousClass5(Runnable runnable2, Drawable drawable, h02.b f162) {
                    r2 = runnable2;
                    r3 = drawable;
                    r4 = f162;
                }

                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    GuildQRCodeFragment.this.P.setDrawingCacheEnabled(true);
                    GuildQRCodeFragment.this.P.buildDrawingCache();
                    Bitmap drawingCache2 = GuildQRCodeFragment.this.P.getDrawingCache();
                    if (drawingCache2 == null) {
                        QLog.w("Guild.share.GuildQRCodeFragment", 1, "getQrCodeShareImg viewCacheBitmap is null");
                        GuildQRCodeFragment.this.P.setDrawingCacheEnabled(false);
                        GuildQRCodeFragment.this.P.destroyDrawingCache();
                        r2.run();
                        return;
                    }
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment.5.1

                        /* renamed from: d */
                        final /* synthetic */ Bitmap f234864d;

                        /* renamed from: e */
                        final /* synthetic */ long f234865e;

                        /* renamed from: f */
                        final /* synthetic */ long f234866f;

                        AnonymousClass1(Bitmap drawingCache22, long j3, long currentTimeMillis22) {
                            r2 = drawingCache22;
                            r3 = j3;
                            r5 = currentTimeMillis22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap2;
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            if (r3 instanceof BitmapDrawable) {
                                Context requireContext = GuildQRCodeFragment.this.requireContext();
                                AnonymousClass5 anonymousClass52 = AnonymousClass5.this;
                                bitmap2 = ar.f(requireContext, r4, GuildQRCodeFragment.this.P, ((BitmapDrawable) r3).getBitmap(), r2);
                            } else {
                                bitmap2 = null;
                            }
                            if (bitmap2 != null && !bitmap2.isRecycled()) {
                                synchronized (GuildQRCodeFragment.this.f234857h0) {
                                    GuildQRCodeFragment.this.f234856g0.put(GuildQRCodeFragment.this.C, bitmap2);
                                }
                                r2.run();
                                QLog.d("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache ", GuildQRCodeFragment.this.C, "; uiCost:" + (r3 - r5));
                                return;
                            }
                            QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveShareImgCache mQRCodeCardCache error; uiCost:" + (r3 - r5));
                            r2.run();
                        }
                    }, 64, null, true);
                }
            });
        }
    }

    public void Ui() {
        int d16;
        int c16;
        if (bi.e()) {
            d16 = bi.c();
            c16 = bi.d();
        } else {
            d16 = bi.d();
            c16 = bi.c();
        }
        int b16 = (c16 - bi.b(44)) - bi.b(70);
        float gi5 = gi(b16, d16);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.GuildQRCodeFragment", 2, "computeScale ", Boolean.valueOf(bi.e()), " ", Integer.valueOf(c16), "-", Integer.valueOf(b16), "-", Integer.valueOf(d16), "-", "-", Float.valueOf(gi5), " ", Integer.valueOf(this.N.getWidth()));
        }
        if (gi5 != 1.0f) {
            this.N.setPivotY(0.0f);
            this.N.setScaleX(gi5);
            this.N.setScaleY(gi5);
        }
    }

    public void Vi() {
        int color;
        if (Di(getActivity())) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "setColor activity is finishing");
            return;
        }
        Resources resources = getResources();
        if (!Gi(this.C) && this.Y != null) {
            this.f234854e0.j(this.Z);
            color = this.f234854e0.i();
        } else {
            color = resources.getColor(R.color.black);
        }
        this.R.setTextColor(color);
        this.R.setAlpha(0.6f);
        this.M.setTextColor(color);
        if (Fi(this.C)) {
            ((TextView) this.P.findViewById(R.id.x3w)).setTextColor(color);
            ((TextView) this.P.findViewById(R.id.x3b)).setTextColor(color);
        }
        if (!Gi(this.C) && !this.f234854e0.getShouldUseDarkForeground()) {
            this.K.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.guild_qr_code_left_back_white, null));
            this.L.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.guild_qrcode_setting_icon_white, null));
            this.F = "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_logo_white.png";
        } else {
            this.K.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.guild_qr_code_left_back_no_night_theme, null));
            this.L.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.guild_qrcode_setting_icon, null));
            this.F = "https://downv6.qq.com/innovate/guild/qr_code/guild_qrcode_logo_black.png";
        }
        for (int i3 = 0; i3 < this.H.getChildCount(); i3++) {
            View childAt = this.H.getChildAt(i3);
            if (childAt instanceof SharePlatformItemView) {
                ((SharePlatformItemView) childAt).b(color);
            }
        }
    }

    public void Wi(Drawable drawable) {
        Window window;
        this.G.setBackground(drawable);
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        QUIImmersiveHelper.u(window, true, true);
    }

    public void Xi(String str, Bitmap bitmap) {
        if (Di(getActivity())) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "setQRCodeImg activity is finishing");
            return;
        }
        HashMap hashMap = new HashMap();
        if (Fi(this.C)) {
            hashMap.put(3, new com.tencent.mobileqq.component.qrcode.d(7, 6, 32.0f, 3.0f));
            hashMap.put(4, new com.tencent.mobileqq.component.qrcode.d(9, 7, 32.0f, 3.0f));
        } else {
            hashMap.put(3, new com.tencent.mobileqq.component.qrcode.d(7, 6, 15.0f, 1.5f));
            hashMap.put(4, new com.tencent.mobileqq.component.qrcode.d(9, 7, 15.0f, 1.5f));
        }
        this.P.mIvQRCode.q();
        this.P.mIvQRCode.e(false);
        this.P.mIvQRCode.setIsAdjustDarkLogo(false);
        this.P.mIvQRCode.setTargetGenerateQRCodeParams(new com.tencent.mobileqq.component.qrcode.e(3, 4, hashMap, ErrorCorrectionLevel.Q));
        this.P.mIvQRCode.m(bitmap, com.tencent.mobileqq.component.qrcode.a.c());
        this.P.mIvQRCode.g(new com.tencent.mobileqq.component.qrcode.i(R.drawable.guild_qrcode_logo, null, null, 0));
        this.P.mIvQRCode.setOnFirstTimeDrawnListener(new d());
        this.P.mIvQRCode.f(str, new com.tencent.mobileqq.component.qrcode.g() { // from class: com.tencent.mobileqq.guild.setting.qrcode.k
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                GuildQRCodeFragment.Oi(i3);
            }
        });
    }

    private void Yi(boolean z16) {
        this.K.setClickable(z16);
        this.L.setClickable(z16);
        this.J.setClickable(z16);
        this.R.setClickable(z16);
        this.G.setClickable(z16);
    }

    public void Zi() {
        QLog.e("Guild.share.GuildQRCodeFragment", 1, "shareBitmapFailedWhenChanging isShareDelay:" + this.f234852c0);
        if (!this.f234852c0) {
            return;
        }
        this.f234852c0 = false;
        ch.d1(1, R.string.f1518218q);
    }

    public void aj(String str) {
        if (Di(getActivity())) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "generateQRCode activity is finishing");
            return;
        }
        if (this.f234858i0.getUpdateType().getValue() == null) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "updateQrCodeUrl mViewModel.getUpdateType().getValue() is null!");
            return;
        }
        if (this.f234858i0.getUpdateType().getValue().f234881a.intValue() == 0) {
            this.f234853d0 = str;
            if (TextUtils.isEmpty(str)) {
                QLog.w("Guild.share.GuildQRCodeFragment", 1, "updateQrCodeUrl mCurQrCodeUrl is null!");
                return;
            } else {
                ki();
                return;
            }
        }
        if (this.f234858i0.getUpdateType().getValue().f234881a.intValue() != 2 || this.f234851b0) {
            return;
        }
        this.f234851b0 = true;
        this.f234853d0 = str;
        QRCodeStyle mi5 = mi();
        this.C = mi5;
        if (!Gi(mi5)) {
            hi();
            ci();
        }
        ki();
    }

    private void ci() {
        if (this.P == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setDuration(100L);
        GuildQrCodeCenterCard guildQrCodeCenterCard = this.Q;
        if (guildQrCodeCenterCard != null) {
            guildQrCodeCenterCard.setAnimation(alphaAnimation);
            this.I.removeView(this.Q);
        }
        this.I.addView(this.P, new LinearLayout.LayoutParams(-1, -2));
        if (this.Q != null) {
            this.P.setAnimation(alphaAnimation2);
            this.Q = null;
        }
    }

    private void di() {
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.G.setOnClickListener(this);
    }

    private void ei(int i3, SharePlatformItemData sharePlatformItemData, SharePlatformItemView sharePlatformItemView) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_share_item", sharePlatformItemData.getPlatformName());
        hashMap.put("sgrp_rank", Integer.valueOf(i3));
        hashMap.put("sgrp_share_source", ni(sharePlatformItemData));
        bt.b(sharePlatformItemView, "em_sgrp_share_item", hashMap);
    }

    private void fi() {
        synchronized (this.f234857h0) {
            this.f234856g0.clear();
        }
    }

    private float gi(int i3, int i16) {
        int b16 = bi.b(MiniReportManager.EventId.SDK_EMBEDDED_SUPPORT_RESULT);
        int b17 = bi.b(400);
        if (i3 >= b16 && i16 >= b17) {
            return 1.0f;
        }
        return Math.min((i16 * 1.0f) / b17, (i3 * 1.0f) / b16);
    }

    private void hi() {
        GuildQrCodeCenterCard guildQrCodeCenterCard = this.P;
        if (guildQrCodeCenterCard != null) {
            this.Q = guildQrCodeCenterCard;
        }
        switch (f.f234875a[this.C.ordinal()]) {
            case 1:
            case 2:
                this.P = new CenterCardHighlightContent(requireContext(), this.f234858i0, this.T);
                break;
            case 3:
            case 4:
                this.P = new CenterCardHighlightQrCode(requireContext(), this.f234858i0, this.T);
                break;
            case 5:
            case 6:
                this.P = new CenterCardHighlightNum(requireContext(), this.f234858i0, this.T);
                break;
        }
        GuildQrCodeCenterCard guildQrCodeCenterCard2 = this.P;
        if (guildQrCodeCenterCard2 != null) {
            guildQrCodeCenterCard2.setOnClickListener(this);
            this.P.setClickable(true);
        }
    }

    private void ii(Resources resources) {
        if (!Gi(this.C) && this.Y != null) {
            this.f234851b0 = false;
            Wi(new BitmapDrawable(resources, this.Y));
            Vi();
            Pi();
            Xi(this.f234853d0, this.Y);
            return;
        }
        u.s(this.f234860k0.get(this.C).a(), new b(true, resources));
    }

    private void initData() {
        Ai();
        if (this.X.getUserType() == 0) {
            this.L.setVisibility(8);
        }
        this.f234855f0.add(new SharePlatformItemData(PlatformType.QQ_FRIEND, R.drawable.guild_share_icon_friend, "QQ\u597d\u53cb"));
        this.f234855f0.add(new SharePlatformItemData(PlatformType.QQ_CHANNEL, R.drawable.guild_share_icon_channel, "\u817e\u8baf\u9891\u9053"));
        this.f234855f0.add(new SharePlatformItemData(PlatformType.WE_CHAT, R.drawable.guild_share_icon_wx, "\u5fae\u4fe1\u597d\u53cb"));
        this.f234855f0.add(new SharePlatformItemData(PlatformType.WE_CHAT_CIRCLE, R.drawable.guild_share_icon_wx_circle, "\u670b\u53cb\u5708"));
        this.f234855f0.add(new SharePlatformItemData(PlatformType.QQ_ZONE, R.drawable.guild_share_icon_qzone, "QQ\u7a7a\u95f4"));
    }

    public File ji(boolean z16) {
        String sDKPrivatePath;
        String l3 = Long.toString(System.currentTimeMillis());
        if (z16) {
            sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("cache/");
        } else {
            sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
        }
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(sDKPrivatePath + "qq_guild_qrcode" + l3 + ".jpg");
        int i3 = 2;
        while (file2.exists() && i3 < Integer.MAX_VALUE) {
            i3++;
            file2 = new File(AppConstants.SDCARD_IMG_SAVE + "qrcode_" + l3 + "(" + i3 + ").jpg");
        }
        return file2;
    }

    private void ki() {
        Wi(li());
        ii(getResources());
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private Drawable li() {
        boolean z16;
        if (this.G.getBackground() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return getResources().getDrawable(R.drawable.npq);
        }
        return this.G.getBackground();
    }

    private QRCodeStyle mi() {
        int length;
        int ordinal = this.C.ordinal();
        if (ordinal > 0) {
            length = ordinal - 1;
        } else {
            length = this.D.length - 1;
        }
        return this.D[length];
    }

    private String ni(SharePlatformItemData sharePlatformItemData) {
        int i3 = f.f234876b[sharePlatformItemData.getPlatformType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            return "other";
                        }
                        return "wechat_moments";
                    }
                    return WadlProxyConsts.CHANNEL;
                }
                return "qq";
            }
            return "wechat_contacts";
        }
        return "qzone";
    }

    public void oi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Object tag = view.getTag();
        if (!(tag instanceof SharePlatformItemData)) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "handleClickPlatformShare data error");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.GuildQRCodeFragment.8

                /* renamed from: d */
                final /* synthetic */ SharePlatformItemData f234868d;

                AnonymousClass8(SharePlatformItemData sharePlatformItemData) {
                    r2 = sharePlatformItemData;
                }

                @Override // java.lang.Runnable
                public void run() {
                    File ji5 = GuildQRCodeFragment.this.ji(true);
                    Bitmap bitmap = (Bitmap) GuildQRCodeFragment.this.f234856g0.get(GuildQRCodeFragment.this.C);
                    if (bitmap != null && !bitmap.isRecycled()) {
                        if (!com.tencent.mobileqq.guild.util.p.d(ji5, bitmap)) {
                            QLog.e("Guild.share.GuildQRCodeFragment", 1, "handlePlatformShareClick writeBitmapToFile error");
                            return;
                        }
                        if (r2.getPlatformType() == PlatformType.QQ_FRIEND) {
                            GuildQRCodeFragment.this.si(ji5);
                            return;
                        }
                        if (r2.getPlatformType() == PlatformType.QQ_CHANNEL) {
                            GuildQRCodeFragment.this.ri(ji5);
                            return;
                        }
                        if (r2.getPlatformType() == PlatformType.WE_CHAT) {
                            GuildQRCodeFragment.this.ui(ji5);
                            return;
                        } else if (r2.getPlatformType() == PlatformType.WE_CHAT_CIRCLE) {
                            GuildQRCodeFragment.this.vi(ji5);
                            return;
                        } else {
                            if (r2.getPlatformType() == PlatformType.QQ_ZONE) {
                                GuildQRCodeFragment.this.ti(ji5);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.e("Guild.share.GuildQRCodeFragment", 1, "saveFileToLocal bitmap get error");
                }
            }, 64, null, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void pi() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_qr_code_type", "pic" + (this.C.ordinal() + 1));
        Qi(this.J, "em_sgrp_qr_save", hashMap);
        if (this.W == null) {
            this.W = QQPermissionFactory.getQQPermission(this);
        }
        QQPermission qQPermission = this.W;
        if (qQPermission == null) {
            QQToastUtil.showQQToast(1, R.string.f155091gk);
        } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            this.W.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new e());
        } else {
            Ri();
        }
    }

    private void qi() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_qr_code_type", "pic" + (this.C.ordinal() + 1));
        Qi(this.L, "em_sgrp_qr_set", hashMap);
        GuildQRCodeSettingDialog guildQRCodeSettingDialog = new GuildQRCodeSettingDialog();
        guildQRCodeSettingDialog.rh(this.X.getGuildID(), this.X.getQRCodePeriod());
        this.U = new WeakReference<>(guildQRCodeSettingDialog);
        com.tencent.mobileqq.guild.base.extension.d.a(guildQRCodeSettingDialog, getParentFragmentManager(), "Guild.share.GuildQRCodeFragment");
    }

    public void ri(File file) {
        if (file != null && getActivity() != null) {
            m02.d.o(getActivity(), file.getAbsolutePath());
        }
    }

    public void si(File file) {
        if (file != null && getActivity() != null) {
            m02.d.m(getActivity(), file.getAbsolutePath(), false);
        }
    }

    public void ti(File file) {
        if (file != null && getActivity() != null) {
            m02.d.u(getActivity(), file.getAbsolutePath());
        }
    }

    public void ui(File file) {
        if (!m02.d.i()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.h
                @Override // java.lang.Runnable
                public final void run() {
                    QQToastUtil.showQQToast(R.string.f156731l0);
                }
            });
            return;
        }
        Bitmap bitmap = this.f234856g0.get(this.C);
        if (file != null && bitmap != null && !bitmap.isRecycled()) {
            m02.d.q(file.getAbsolutePath(), bitmap);
        }
    }

    public void vi(File file) {
        if (!m02.d.i()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.qrcode.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQToastUtil.showQQToast(R.string.f156731l0);
                }
            });
            return;
        }
        Bitmap bitmap = this.f234856g0.get(this.C);
        if (file != null && bitmap != null && !bitmap.isRecycled()) {
            m02.d.r(file.getAbsolutePath(), bitmap);
        }
    }

    private void wi() {
        Qi(this.R, "em_sgrp_qr_change", new HashMap());
        Yi(false);
        this.f234858i0.updateUrlByType("pic" + (mi().ordinal() + 1));
    }

    private void xi() {
        if (Di(getActivity())) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "initContentView activity is finishing");
            return;
        }
        this.J = (Button) this.G.findViewById(R.id.woq);
        this.R = (GuildSelectableTextView) this.G.findViewById(R.id.w1k);
        this.H = (LinearLayout) this.G.findViewById(R.id.wos);
        this.N = this.G.findViewById(R.id.wur);
        this.I = (LinearLayout) this.G.findViewById(R.id.woh);
        hi();
        ci();
        this.G.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.N.post(new com.tencent.mobileqq.guild.setting.qrcode.a(this));
        di();
        zi();
    }

    private void yi() {
        FragmentActivity activity = getActivity();
        if (Di(activity)) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "fragmentActivity isFinishing");
            return;
        }
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(this.G, "pg_sgrp_qr_set");
        VideoReport.setEventDynamicParams(this.G, new g(this));
    }

    private void zi() {
        for (int i3 = 0; i3 < this.f234855f0.size(); i3++) {
            SharePlatformItemData sharePlatformItemData = this.f234855f0.get(i3);
            SharePlatformItemView sharePlatformItemView = new SharePlatformItemView(requireContext());
            sharePlatformItemView.c(sharePlatformItemData);
            sharePlatformItemView.setTag(sharePlatformItemData);
            sharePlatformItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.qrcode.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildQRCodeFragment.this.oi(view);
                }
            });
            this.H.addView(sharePlatformItemView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            ei(i3, sharePlatformItemData, sharePlatformItemView);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        FragmentActivity activity = getActivity();
        if (Di(activity)) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "fragmentActivity isFinishing");
            return;
        }
        if (i3 == 101 && i16 == -1) {
            QQToast.makeText(activity, 2, "\u5df2\u5206\u4eab", 0).show();
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        FragmentActivity activity = getActivity();
        if (Di(activity)) {
            QLog.w("Guild.share.GuildQRCodeFragment", 1, "fragmentActivity isFinishing");
        } else if (view == this.K) {
            activity.finish();
        } else if (view == this.L) {
            qi();
        } else if (view != this.P && view != this.R && view != this.G) {
            if (view == this.J) {
                pi();
            }
        } else {
            wi();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!Di(getActivity())) {
            this.N.post(new com.tencent.mobileqq.guild.setting.qrcode.a(this));
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view;
        this.G = layoutInflater.inflate(R.layout.f168112ev4, viewGroup, false);
        QQProgressDialog qQProgressDialog = new QQProgressDialog(getActivity());
        this.V = qQProgressDialog;
        qQProgressDialog.show();
        Bi();
        if (!Ci()) {
            QLog.e("Guild.share.GuildQRCodeFragment", 1, "initData guildInfo is null");
            view = this.G;
        } else {
            initData();
            xi();
            yi();
            view = this.G;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        QQProgressDialog qQProgressDialog = this.V;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        GuildQRCodeSettingDialog guildQRCodeSettingDialog = this.U.get();
        if (guildQRCodeSettingDialog != null) {
            guildQRCodeSettingDialog.dismissAllowingStateLoss();
        }
        fi();
    }
}
