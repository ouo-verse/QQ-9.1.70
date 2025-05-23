package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.msg.PokeMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOPokeContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.poke.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.api.IPokeApi;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqnt.aio.adapter.api.IAIOHapticApi;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import com.tencent.state.map.MapItemKt;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.util.BitmapUtil;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bl\u0010mJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012JO\u0010\u001b\u001a\u00020\b2\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00152\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010!\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\"\u001a\u00020\rJ(\u0010)\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u001eJ\u000e\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\u000fJ\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020+J\b\u0010/\u001a\u0004\u0018\u00010.J\u0006\u00100\u001a\u00020\bJ\u001e\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00122\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u001eJ.\u00108\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00122\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u000fJ.\u00109\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00122\u0006\u00103\u001a\u0002022\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u001eJ\u000e\u0010<\u001a\u00020;2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010=\u001a\u00020;2\u0006\u0010:\u001a\u00020\rJ\u0016\u0010B\u001a\u00020\b2\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@R\u001f\u0010H\u001a\n C*\u0004\u0018\u00010\u001e0\u001e8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001f\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\n\u0010L\u001a\u0004\bM\u0010NR\u001f\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\t\u0010L\u001a\u0004\bP\u0010NR\u001f\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b)\u0010L\u001a\u0004\bR\u0010NR\u001f\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\bT\u0010L\u001a\u0004\bU\u0010NR\u0016\u0010X\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010ER\u0016\u0010Z\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ER\u0016\u0010[\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010ER\u0016\u0010\\\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010ER\u0016\u0010]\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010ER\u0016\u0010_\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010^R\u001f\u0010a\u001a\n C*\u0004\u0018\u00010\u001e0\u001e8\u0006\u00a2\u0006\f\n\u0004\b8\u0010E\u001a\u0004\b`\u0010GR\u0017\u0010c\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b9\u0010E\u001a\u0004\bb\u0010GR\u0017\u0010e\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b5\u0010E\u001a\u0004\bd\u0010GR\u0016\u0010f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010JR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010hR\u0018\u0010k\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010j\u00a8\u0006n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/ae;", "", "Landroid/graphics/Bitmap;", "bmp", "Landroid/graphics/drawable/Drawable;", "j", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/CustomFrameAnimationDrawable;", "cus", "", "e", "d", "Landroidx/fragment/app/FragmentActivity;", EventKey.ACT, "", "k", "", "pokeType", "isSend", "Landroid/content/res/Resources;", "r", "u", "", "normalBitmaps", "pressedBitmaps", "index", "drawableResIdNormal", "drawableResIdPressed", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "([Landroid/graphics/Bitmap;[Landroid/graphics/Bitmap;ILandroid/content/res/Resources;II)V", "y", "", "v", "Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOPokeContentComponent$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "Lcom/airbnb/lottie/LottieAnimationView;", "animationView", "Lp81/j;", "binding", "animationResourceId", "animationCategory", "f", "pokeMsgStrength", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "animationStrength", "Lmqq/os/MqqHandler;", "l", HippyTKDListViewAdapter.X, DKConfiguration.Directory.RESOURCES, "Lcom/tencent/mobileqq/aio/msg/PokeMsgItem;", "pokeMsgItem", "touchEffectName", "p", WadlProxyConsts.PARAM_FILENAME, WidgetCacheConstellationData.NUM, DomainData.DOMAIN_NAME, "o", "pointToLeft", "Landroid/view/animation/AnimationSet;", ReportConstant.COSTREPORT_PREFIX, "t", "Landroid/content/Context;", "context", "Landroid/view/animation/Animation;", "animation", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "getPANEL_ICON_COMMON_DIR", "()Ljava/lang/String;", "PANEL_ICON_COMMON_DIR", "c", "I", "targetDensity", "[Landroid/graphics/Bitmap;", "getBitmapSendPresseds", "()[Landroid/graphics/Bitmap;", "bitmapSendPresseds", "getBitmapReceivePressed", "bitmapReceivePressed", "getBitmapSendNormals", "bitmapSendNormals", "g", "getBitmapReceiveNormals", "bitmapReceiveNormals", tl.h.F, "pokeConfigUin", "i", "pokePanelConfigUin", "pokeUniquePokeConfigUin", "pokeTouchEffectConfigUin", "pokeComboTimeConfigUin", "Z", "isPokeTouchEffectInited", "getSDCARD_ROOT", "SDCARD_ROOT", "getPOKE_RES_FILE_PATH", "POKE_RES_FILE_PATH", "getPOKE_RES_REAL_FILE_PATH", "POKE_RES_REAL_FILE_PATH", "touchEffectFlag", "Landroid/os/HandlerThread;", "Landroid/os/HandlerThread;", "mAIOAnimationThread", "Lmqq/os/MqqHandler;", "mAIOAnimationHandler", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ae {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ae f191631a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String PANEL_ICON_COMMON_DIR;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int targetDensity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Bitmap[] bitmapSendPresseds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Bitmap[] bitmapReceivePressed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Bitmap[] bitmapSendNormals;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Bitmap[] bitmapReceiveNormals;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String pokeConfigUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String pokePanelConfigUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String pokeUniquePokeConfigUin;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String pokeTouchEffectConfigUin;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String pokeComboTimeConfigUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean isPokeTouchEffectInited;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static final String SDCARD_ROOT;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String POKE_RES_FILE_PATH;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String POKE_RES_REAL_FILE_PATH;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static int touchEffectFlag;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static HandlerThread mAIOAnimationThread;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static MqqHandler mAIOAnimationHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/poke/ae$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f191650d;

        a(View view) {
            this.f191650d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeUtil", 2, "onAnimationEnd " + animation);
            }
            View view = this.f191650d;
            if (view != null) {
                view.setBackground(null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeUtil", 2, "onAnimationStart " + animation);
            }
            View view = this.f191650d;
            if (view != null) {
                view.setBackgroundResource(R.drawable.qui_msg_list_bg);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50712);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 27)) {
            redirector.redirect((short) 27);
            return;
        }
        f191631a = new ae();
        PANEL_ICON_COMMON_DIR = VFSAssistantUtils.getSDKPrivatePath("Tencent/MobileQQ/poke/");
        targetDensity = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
        bitmapSendPresseds = new Bitmap[6];
        bitmapReceivePressed = new Bitmap[6];
        bitmapSendNormals = new Bitmap[6];
        bitmapReceiveNormals = new Bitmap[6];
        pokeConfigUin = "";
        pokePanelConfigUin = "";
        pokeUniquePokeConfigUin = "";
        pokeTouchEffectConfigUin = "";
        pokeComboTimeConfigUin = "";
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(Environment.getExternalStorageDirectory().getAbsolutePath());
        SDCARD_ROOT = sDKPrivatePath;
        String str = sDKPrivatePath + "/Tencent/MobileQQ/";
        POKE_RES_FILE_PATH = str;
        POKE_RES_REAL_FILE_PATH = str;
    }

    ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final CustomFrameAnimationDrawable d(CustomFrameAnimationDrawable cus) {
        cus.i();
        cus.f(0, 340, R.drawable.f160445cd0);
        for (int i3 = 0; i3 < 6; i3++) {
            cus.f(i3, 40, R.drawable.f160445cd0 + i3);
        }
        for (int i16 = 5; i16 > 0; i16--) {
            cus.f(i16, 30, R.drawable.f160445cd0 + i16);
        }
        for (int i17 = 0; i17 < 6; i17++) {
            cus.f(i17, 40, R.drawable.f160445cd0 + i17);
        }
        for (int i18 = 5; i18 > 0; i18--) {
            cus.f(i18, 30, R.drawable.f160445cd0 + i18);
        }
        cus.f(0, 160, R.drawable.f160445cd0);
        return cus;
    }

    private final void e(CustomFrameAnimationDrawable cus) {
        int i3;
        cus.i();
        String str = af.I3 + "/chuo_caidan/chuo_caidan_";
        int i16 = 0;
        cus.g(0, 340, str + "01.png");
        int i17 = 0;
        int i18 = 0;
        while (i17 < 5) {
            i17++;
            cus.g(i18, 45, str + "0" + i17 + ".png");
            i18++;
        }
        int i19 = 4;
        int i26 = 4;
        while (i26 > 0) {
            cus.g(i18, 30, str + "0" + (i26 + 1) + ".png");
            i26 += -1;
            i18++;
        }
        int i27 = 0;
        while (i27 < 5) {
            i27++;
            cus.g(i18, 45, str + "0" + i27 + ".png");
            i18++;
        }
        while (i19 > 0) {
            cus.g(i18, 30, str + "0" + (i19 + 1) + ".png");
            i19 += -1;
            i18++;
        }
        int i28 = i18 + 1;
        cus.g(i18, 240, str + "01.png");
        while (true) {
            i3 = 8;
            if (i16 >= 8) {
                break;
            }
            i16++;
            cus.g(i28, 30, str + "0" + i16 + ".png");
            i28++;
        }
        while (i3 < 10) {
            i3++;
            cus.g(i28, 150, str + "0" + i3 + ".png");
            i28++;
        }
        for (int i29 = 9; -1 < i29; i29--) {
            if (i29 % 2 == 0) {
                cus.g(i28, 40, str + "0" + (i29 + 1) + ".png");
                i28++;
            }
        }
        cus.g(i28, MapItemKt.ITEM_AVATAR_MIN_WIDTH, str + "01.png");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3) {
        String pokeResRootPath = ((IPokeApi) QRoute.api(IPokeApi.class)).getPokeResRootPath(i3);
        ((IAIOHapticApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOHapticApi.class)).addEffectFromSDCard(String.valueOf(i3), pokeResRootPath + "/" + i3 + IAIOHapticApi.HAPT_FILE_EXTENSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LottieAnimationView animationView, p81.j jVar, String animationCategory, final String vasResourcePath, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(animationView, "$animationView");
        Intrinsics.checkNotNullParameter(animationCategory, "$animationCategory");
        Intrinsics.checkNotNullParameter(vasResourcePath, "$vasResourcePath");
        animationView.setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.ad
            @Override // com.airbnb.lottie.ImageAssetDelegate
            public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                Bitmap i3;
                i3 = ae.i(vasResourcePath, lottieImageAsset);
                return i3;
            }
        });
        if (lottieComposition == null) {
            if (QLog.isColorLevel()) {
                QLog.d(ag.f191651a, 2, "composition is null ,return");
                return;
            }
            return;
        }
        animationView.setComposition(lottieComposition);
        if (jVar != null && Intrinsics.areEqual("bubble", animationCategory)) {
            LottieComposition composition = jVar.f425761d.getComposition();
            Intrinsics.checkNotNull(composition);
            Rect bounds = composition.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "binding.pokeLottieAnimat\u2026mposition()!!.getBounds()");
            ViewGroup.LayoutParams layoutParams = jVar.f425761d.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "binding.pokeLottieAnimationView.getLayoutParams()");
            jVar.f425761d.getLayoutParams().width = (bounds.width() * layoutParams.height) / bounds.height();
            jVar.f425761d.setLayoutParams(layoutParams);
            jVar.f425761d.setVisibility(0);
            jVar.f425762e.clearAnimation();
            jVar.f425762e.setVisibility(8);
            jVar.f425767j.clearAnimation();
            jVar.f425767j.setVisibility(8);
        }
        animationView.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap i(String vasResourcePath, LottieImageAsset lottieImageAsset) {
        Intrinsics.checkNotNullParameter(vasResourcePath, "$vasResourcePath");
        String str = vasResourcePath + "/images/" + lottieImageAsset.getFileName();
        if (!new File(str).exists()) {
            QLog.e(ag.f191651a, 1, "fetchBitmap  bitmapPath is not exists: " + str);
            return null;
        }
        return ((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).getBitmap(str);
    }

    @JvmStatic
    @Nullable
    public static final Drawable j(@NotNull Bitmap bmp) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        try {
            bitmap = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeUtil", 2, "get pokeFriendPokeImage oom" + e16);
            }
            bitmap = null;
        }
        if (QLog.isColorLevel() && bitmap != null) {
            Log.d("test", "convertBmp w=" + bitmap.getWidth());
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        bitmapDrawable.setTargetDensity(targetDensity);
        return bitmapDrawable;
    }

    private final boolean k(FragmentActivity act) {
        FullScreenMsgIntent.GetFullScreenStatus getFullScreenStatus = new FullScreenMsgIntent.GetFullScreenStatus(false);
        com.tencent.qqnt.aio.utils.c.f352293a.a(act, getFullScreenStatus);
        return getFullScreenStatus.a();
    }

    public final void A(@NotNull Context context, @NotNull Animation animation) {
        View view;
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) context, (Object) animation);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (!(context instanceof FragmentActivity)) {
            return;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) context;
        if (k(fragmentActivity)) {
            QLog.i("AIOPokeUtil", 1, "forbidAnimation return");
            return;
        }
        View decorView = fragmentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) decorView).getChildAt(0);
        View view2 = null;
        if (childAt != null) {
            view = childAt.findViewById(R.id.tua);
        } else {
            view = null;
        }
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            view2 = viewGroup.getChildAt(0);
        }
        if (view2 == null) {
            view2 = view;
        }
        if (!QQTheme.isVasTheme()) {
            animation.setAnimationListener(new a(view));
        }
        if (view2 != null) {
            view2.startAnimation(animation);
        }
    }

    public final void f(@NotNull final LottieAnimationView animationView, @Nullable final p81.j binding, final int animationResourceId, @NotNull final String animationCategory) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, animationView, binding, Integer.valueOf(animationResourceId), animationCategory);
            return;
        }
        Intrinsics.checkNotNullParameter(animationView, "animationView");
        Intrinsics.checkNotNullParameter(animationCategory, "animationCategory");
        if (((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).isVasPokeShockSupport()) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.ab
                @Override // java.lang.Runnable
                public final void run() {
                    ae.g(animationResourceId);
                }
            }, null, true);
        }
        final String str = ((IPokeApi) QRoute.api(IPokeApi.class)).getPokeResRootPath(animationResourceId) + "/" + animationCategory + "/";
        try {
            LottieComposition.Factory.fromInputStream(new FileInputStream(new File(str + animationCategory + Sticker.JSON_SUFFIX)), new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.ac
                @Override // com.airbnb.lottie.OnCompositionLoadedListener
                public final void onCompositionLoaded(LottieComposition lottieComposition) {
                    ae.h(LottieAnimationView.this, binding, animationCategory, str, lottieComposition);
                }
            });
        } catch (FileNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PokeItemHelper", 2, "vaspoke, file not found. id: " + animationResourceId + " ,category: " + animationCategory, e16);
            }
        } catch (Exception e17) {
            QLog.e("PokeItemHelper", 2, "vaspoke, exception occur, id: " + animationResourceId + " ,category: " + animationCategory, e17);
        }
    }

    @Nullable
    public final MqqHandler l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (MqqHandler) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (mAIOAnimationHandler == null || mAIOAnimationThread == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("PokeAIOAnimationThread");
            mAIOAnimationThread = baseHandlerThread;
            baseHandlerThread.start();
            HandlerThread handlerThread = mAIOAnimationThread;
            Intrinsics.checkNotNull(handlerThread);
            mAIOAnimationHandler = new MqqHandler(handlerThread.getLooper());
        }
        return mAIOAnimationHandler;
    }

    public final float m(int pokeMsgStrength) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this, pokeMsgStrength)).floatValue();
        }
        if (pokeMsgStrength != 1) {
            if (pokeMsgStrength != 2) {
                if (pokeMsgStrength != 3) {
                    return 1.0f;
                }
                return 2.0f;
            }
            return 1.6f;
        }
        return 1.3f;
    }

    @NotNull
    public final CustomFrameAnimationDrawable n(@NotNull Resources resources, @NotNull PokeMsgItem pokeMsgItem, @NotNull String touchEffectName, @NotNull String fileName, int num) {
        Bitmap bitmap;
        int i3;
        CustomFrameAnimationDrawable customFrameAnimationDrawable;
        int i16;
        CustomFrameAnimationDrawable customFrameAnimationDrawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (CustomFrameAnimationDrawable) iPatchRedirector.redirect((short) 22, this, resources, pokeMsgItem, touchEffectName, fileName, Integer.valueOf(num));
        }
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(pokeMsgItem, "pokeMsgItem");
        Intrinsics.checkNotNullParameter(touchEffectName, "touchEffectName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        Bitmap bitmap2 = null;
        try {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(fileName + "01.png", options);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeUtil", 2, e16.toString());
            }
            bitmap = null;
        }
        CustomFrameAnimationDrawable customFrameAnimationDrawable3 = r7;
        CustomFrameAnimationDrawable customFrameAnimationDrawable4 = new CustomFrameAnimationDrawable(resources, bitmap, l(), pokeMsgItem.frameState, touchEffectName, w());
        customFrameAnimationDrawable3.i();
        if (pokeMsgItem.o2() == 2) {
            i3 = 30;
        } else {
            i3 = 40;
        }
        if (pokeMsgItem.o2() == 4 && pokeMsgItem.r2()) {
            int i17 = 0;
            while (true) {
                if (i17 >= 20) {
                    break;
                }
                int i18 = i17 + 1;
                if (i18 < 10) {
                    customFrameAnimationDrawable2 = customFrameAnimationDrawable3;
                    customFrameAnimationDrawable2.g(i17, i3, fileName + "0" + i18 + ".png");
                } else {
                    customFrameAnimationDrawable2 = customFrameAnimationDrawable3;
                    customFrameAnimationDrawable2.g(i17, i3, fileName + i18 + ".png");
                }
                i17 = i18;
                customFrameAnimationDrawable3 = customFrameAnimationDrawable2;
            }
            customFrameAnimationDrawable = customFrameAnimationDrawable3;
            for (i16 = 20; i16 < num; i16++) {
                customFrameAnimationDrawable.g(i16, i3, fileName + "21.png");
            }
        } else {
            customFrameAnimationDrawable = customFrameAnimationDrawable3;
            int i19 = 0;
            while (i19 < num) {
                int i26 = i19 + 1;
                if (i26 < 10) {
                    customFrameAnimationDrawable.g(i19, i3, fileName + "0" + i26 + ".png");
                } else {
                    customFrameAnimationDrawable.g(i19, i3, fileName + i26 + ".png");
                }
                i19 = i26;
            }
        }
        CustomFrameAnimationDrawable.b bVar = pokeMsgItem.frameState;
        if (bVar.f191488d) {
            try {
                CustomFrameAnimationDrawable.e m3 = customFrameAnimationDrawable.m(bVar.f191487c);
                if (m3 != null) {
                    bitmap2 = BaseImageUtil.decodeFileWithBufferedStream(m3.f191498c, options);
                }
            } catch (NullPointerException e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOPokeUtil", 2, e17, new Object[0]);
                }
            } catch (OutOfMemoryError e18) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOPokeUtil", 2, e18, new Object[0]);
                }
            }
            customFrameAnimationDrawable.q(bitmap2);
        }
        return customFrameAnimationDrawable;
    }

    @NotNull
    public final CustomFrameAnimationDrawable o(@NotNull Resources resources, @NotNull PokeMsgItem pokeMsgItem, @NotNull String fileName, int num, @NotNull String touchEffectName) {
        Bitmap bitmap;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (CustomFrameAnimationDrawable) iPatchRedirector.redirect((short) 23, this, resources, pokeMsgItem, fileName, Integer.valueOf(num), touchEffectName);
        }
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(pokeMsgItem, "pokeMsgItem");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(touchEffectName, "touchEffectName");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inSampleSize = 1;
        options.inMutable = true;
        try {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(fileName + "01.png", options);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeUtil", 2, e16.toString());
            }
            bitmap = null;
        }
        CustomFrameAnimationDrawable customFrameAnimationDrawable = new CustomFrameAnimationDrawable(resources, bitmap, l(), pokeMsgItem.frameState, touchEffectName, w());
        customFrameAnimationDrawable.i();
        if (pokeMsgItem.o2() == 2) {
            i3 = 30;
        } else {
            i3 = 40;
        }
        if (pokeMsgItem.o2() == 4 && pokeMsgItem.r2()) {
            while (true) {
                if (i17 >= 20) {
                    break;
                }
                int i18 = i17 + 1;
                if (i18 < 10) {
                    customFrameAnimationDrawable.g(i17, i3, fileName + "0" + i18 + ".png");
                } else {
                    customFrameAnimationDrawable.g(i17, i3, fileName + i18 + ".png");
                }
                i17 = i18;
            }
            for (i16 = 20; i16 < num; i16++) {
                customFrameAnimationDrawable.g(i16, i3, fileName + "21.png");
            }
        } else {
            while (i17 < num) {
                int i19 = i17 + 1;
                if (i19 < 10) {
                    customFrameAnimationDrawable.g(i17, i3, fileName + "0" + i19 + ".png");
                } else {
                    customFrameAnimationDrawable.g(i17, i3, fileName + i19 + ".png");
                }
                i17 = i19;
            }
        }
        return customFrameAnimationDrawable;
    }

    @NotNull
    public final CustomFrameAnimationDrawable p(@NotNull Resources resources, @NotNull PokeMsgItem pokeMsgItem, @NotNull String touchEffectName) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (CustomFrameAnimationDrawable) iPatchRedirector.redirect((short) 21, this, resources, pokeMsgItem, touchEffectName);
        }
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(pokeMsgItem, "pokeMsgItem");
        Intrinsics.checkNotNullParameter(touchEffectName, "touchEffectName");
        if (pokeMsgItem.r2()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            options.inMutable = true;
            try {
                bitmap = BaseImageUtil.decodeFileWithBufferedStream(af.I3 + "/chuo_caidan/chuo_caidan_01.png", options);
            } catch (OutOfMemoryError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOPokeUtil", 2, e16.toString());
                }
                bitmap = null;
            }
            CustomFrameAnimationDrawable customFrameAnimationDrawable = new CustomFrameAnimationDrawable(resources, bitmap, l(), pokeMsgItem.frameState, touchEffectName, w());
            e(customFrameAnimationDrawable);
            return customFrameAnimationDrawable;
        }
        Bitmap decodeResourceStream = BaseImageUtil.decodeResourceStream(resources, R.drawable.f160445cd0);
        Intrinsics.checkNotNullExpressionValue(decodeResourceStream, "decodeResourceStream(res\u2026ble.chat_item_for_poke01)");
        CustomFrameAnimationDrawable customFrameAnimationDrawable2 = new CustomFrameAnimationDrawable(resources, decodeResourceStream, l(), pokeMsgItem.frameState, touchEffectName, w());
        d(customFrameAnimationDrawable2);
        return customFrameAnimationDrawable2;
    }

    @NotNull
    public final AIOPokeContentComponent.b q(int pokeType, boolean isSend) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AIOPokeContentComponent.b) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(pokeType), Boolean.valueOf(isSend));
        }
        switch (pokeType) {
            case 1:
                str = af.J3 + "/chuo_motion/chuo_motion_";
                i3 = 35;
                break;
            case 2:
                str = af.J3 + "/bixin_motion/bixin_motion_";
                i3 = 67;
                break;
            case 3:
                str = af.J3 + "/zan_motion/zan_motion_";
                i3 = 20;
                break;
            case 4:
                str = af.J3 + "/xinsui_motion/xinsui_motion_";
                i3 = 50;
                break;
            case 5:
                if (isSend) {
                    str = af.J3 + "/666send_motion/666send_motion_";
                } else {
                    str = af.J3 + "/666receive_motion/666receive_motion_";
                }
                i3 = 57;
                break;
            case 6:
                str = PANEL_ICON_COMMON_DIR + "/dazhao_icon/dazhao_icon_";
                break;
            default:
                str = PANEL_ICON_COMMON_DIR + "/chuo_icon/chuo_icon_";
                break;
        }
        return new AIOPokeContentComponent.b(str, i3);
    }

    public final int r(int pokeType, float animationStrength) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(pokeType), Float.valueOf(animationStrength))).intValue();
        }
        switch (pokeType) {
            case 0:
            case 1:
                if (animationStrength != 2.0f) {
                    z16 = false;
                }
                if (z16) {
                    return com.tencent.mobileqq.utils.x.a(animationStrength * 150.0f);
                }
                return com.tencent.mobileqq.utils.x.a(animationStrength * 100.0f);
            case 2:
                return com.tencent.mobileqq.utils.x.a(animationStrength * 280.0f);
            case 3:
                return com.tencent.mobileqq.utils.x.a(animationStrength * 90.0f);
            case 4:
                return com.tencent.mobileqq.utils.x.a(animationStrength * 100.0f);
            case 5:
                return com.tencent.mobileqq.utils.x.a(animationStrength * 230.0f);
            case 6:
                return 0;
            default:
                return com.tencent.mobileqq.utils.x.a(animationStrength * 100.0f);
        }
    }

    @NotNull
    public final AnimationSet s(boolean pointToLeft) {
        int a16;
        int a17;
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (AnimationSet) iPatchRedirector.redirect((short) 24, (Object) this, pointToLeft);
        }
        AnimationSet animationSet = new AnimationSet(false);
        int[] iArr2 = {150, 150, 150, 150};
        if (pointToLeft) {
            a16 = com.tencent.mobileqq.utils.x.a(22.0f);
            a17 = com.tencent.mobileqq.utils.x.a(30.0f);
        } else {
            a16 = com.tencent.mobileqq.utils.x.a(15.0f);
            a17 = com.tencent.mobileqq.utils.x.a(20.0f);
        }
        if (pointToLeft) {
            iArr = new int[]{-a16, a16, -a17, a17};
        } else {
            iArr = new int[]{a16, -a16, a17, -a17};
        }
        long j3 = 350;
        for (int i3 = 0; i3 < 4; i3++) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                            translateAnimation.setDuration(iArr2[i3]);
                            translateAnimation.setStartOffset(j3);
                            translateAnimation.setInterpolator(new DecelerateInterpolator());
                            animationSet.addAnimation(translateAnimation);
                        }
                    } else {
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                        translateAnimation2.setDuration(iArr2[i3]);
                        j3 += 80;
                        translateAnimation2.setStartOffset(j3);
                        translateAnimation2.setInterpolator(new AccelerateInterpolator());
                        animationSet.addAnimation(translateAnimation2);
                    }
                } else {
                    TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                    translateAnimation3.setDuration(iArr2[i3]);
                    translateAnimation3.setStartOffset(j3);
                    translateAnimation3.setInterpolator(new DecelerateInterpolator());
                    animationSet.addAnimation(translateAnimation3);
                }
            } else {
                TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                translateAnimation4.setDuration(iArr2[i3]);
                translateAnimation4.setStartOffset(j3);
                translateAnimation4.setInterpolator(new AccelerateInterpolator());
                animationSet.addAnimation(translateAnimation4);
            }
            j3 += iArr2[i3];
        }
        return animationSet;
    }

    @NotNull
    public final AnimationSet t(boolean pointToLeft) {
        int[] iArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (AnimationSet) iPatchRedirector.redirect((short) 25, (Object) this, pointToLeft);
        }
        AnimationSet s16 = s(pointToLeft);
        int[] iArr2 = {510, 120, 120, 120, 120, 120};
        if (pointToLeft) {
            iArr = new int[]{-160, -10, 240, -120, 70, -50, 30};
        } else {
            iArr = new int[]{160, 10, -240, 120, -70, 50, -30};
        }
        long j3 = 1270;
        for (int i3 = 0; i3 < 6; i3++) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                            translateAnimation.setDuration(iArr2[i3]);
                            translateAnimation.setStartOffset(j3);
                            translateAnimation.setInterpolator(new DecelerateInterpolator());
                            s16.addAnimation(translateAnimation);
                        }
                    } else {
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                        translateAnimation2.setDuration(iArr2[i3]);
                        j3 += 80;
                        translateAnimation2.setStartOffset(j3);
                        translateAnimation2.setInterpolator(new AccelerateInterpolator());
                        s16.addAnimation(translateAnimation2);
                    }
                } else {
                    TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                    translateAnimation3.setDuration(iArr2[i3]);
                    translateAnimation3.setStartOffset(j3);
                    translateAnimation3.setInterpolator(new DecelerateInterpolator());
                    s16.addAnimation(translateAnimation3);
                }
            } else {
                TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, iArr[i3], 0.0f, 0.0f);
                translateAnimation4.setDuration(iArr2[i3]);
                translateAnimation4.setStartOffset(j3);
                translateAnimation4.setInterpolator(new LinearInterpolator());
                s16.addAnimation(translateAnimation4);
            }
            j3 += iArr2[i3];
        }
        return s16;
    }

    @Nullable
    public final Drawable u(int pokeType, boolean isSend, @Nullable Resources r16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(pokeType), Boolean.valueOf(isSend), r16);
        }
        if (pokeType < 0 || pokeType > 6) {
            pokeType = 1;
        }
        if (pokeType == 0) {
            pokeType = 1;
        }
        int i3 = R.drawable.emf;
        int i16 = R.drawable.eme;
        switch (pokeType) {
            case 2:
                i16 = R.drawable.ele;
                i3 = R.drawable.elf;
                break;
            case 3:
                i16 = R.drawable.ela;
                i3 = R.drawable.elb;
                break;
            case 4:
                i16 = R.drawable.elj;
                i3 = R.drawable.elk;
                break;
            case 5:
                if (isSend) {
                    Bitmap[] bitmapArr = bitmapSendNormals;
                    Bitmap[] bitmapArr2 = bitmapSendPresseds;
                    int i17 = pokeType - 1;
                    z(bitmapArr, bitmapArr2, i17, r16, R.drawable.eln, R.drawable.elo);
                    return BitmapUtil.setClickStateHalfAlpha(r16, bitmapArr[i17], bitmapArr2[i17]);
                }
                Bitmap[] bitmapArr3 = bitmapReceiveNormals;
                Bitmap[] bitmapArr4 = bitmapReceivePressed;
                int i18 = pokeType - 1;
                z(bitmapArr3, bitmapArr4, i18, r16, R.drawable.ell, R.drawable.elm);
                return BitmapUtil.setClickStateHalfAlpha(r16, bitmapArr3[i18], bitmapArr4[i18]);
            case 6:
                i16 = R.drawable.elg;
                i3 = R.drawable.elh;
                break;
        }
        int i19 = i3;
        int i26 = pokeType - 1;
        Bitmap[] bitmapArr5 = bitmapSendNormals;
        Bitmap[] bitmapArr6 = bitmapSendPresseds;
        z(bitmapArr5, bitmapArr6, i26, r16, i16, i19);
        if (!isSend) {
            Bitmap bitmap = bitmapArr5[i26];
            if (bitmap != null) {
                Bitmap[] bitmapArr7 = bitmapReceiveNormals;
                if (bitmapArr7[i26] == null) {
                    Intrinsics.checkNotNull(bitmap);
                    bitmapArr7[i26] = y(bitmap);
                }
            }
            Bitmap[] bitmapArr8 = bitmapReceivePressed;
            Bitmap bitmap2 = bitmapArr8[i26];
            if (bitmap2 != null && bitmap2 == null) {
                Intrinsics.checkNotNull(bitmap2);
                bitmapArr8[i26] = y(bitmap2);
            }
        }
        if (isSend) {
            return BitmapUtil.setClickStateHalfAlpha(r16, bitmapArr5[i26], bitmapArr6[i26]);
        }
        return BitmapUtil.setClickStateHalfAlpha(r16, bitmapReceiveNormals[i26], bitmapReceivePressed[i26]);
    }

    @NotNull
    public final String v(int pokeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, pokeType);
        }
        if (pokeType == 1) {
            return "chat_item_for_qqpokenew";
        }
        if (pokeType != 2) {
            if (pokeType != 3) {
                if (pokeType != 4) {
                    if (pokeType != 5) {
                        return "chat_item_for_qqpokenew";
                    }
                    return "chat_item_for_qq666";
                }
                return "chat_item_for_qqheartbroken";
            }
            return "chat_item_for_qqlikenew";
        }
        return "chat_item_for_qqbixin_light";
    }

    public final boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime();
        if (appInterface == null) {
            return false;
        }
        String account = appInterface.getAccount();
        Intrinsics.checkNotNullExpressionValue(account, "app.account");
        if (!isPokeTouchEffectInited || !Intrinsics.areEqual(pokeTouchEffectConfigUin, account)) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(appInterface.getApp());
            if (defaultSharedPreferences.contains(account + "_poke_bar_config_version")) {
                touchEffectFlag = defaultSharedPreferences.getInt(account + "_aio_poke_touch_effect", 0);
            }
            pokeTouchEffectConfigUin = account;
        }
        if (QLog.isColorLevel()) {
            QLog.d("pokeMsg", 2, "touchEffect apply:" + touchEffectFlag);
        }
        isPokeTouchEffectInited = true;
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        if ((bVar.isPublicVersion() || bVar.isGrayVersion()) && touchEffectFlag != 1) {
            return false;
        }
        return true;
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        MqqHandler mqqHandler = mAIOAnimationHandler;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = mAIOAnimationThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        mAIOAnimationThread = null;
        mAIOAnimationHandler = null;
    }

    @Nullable
    public final Bitmap y(@NotNull Bitmap bmp) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this, (Object) bmp);
        }
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        try {
            bitmap = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOPokeUtil", 2, "get pokeFriendPokeImage oom" + e16);
            }
            bitmap = null;
        }
        if (QLog.isColorLevel() && bitmap != null) {
            Log.d("test", "convertBmp w=" + bitmap.getWidth());
        }
        return bitmap;
    }

    public final void z(@NotNull Bitmap[] normalBitmaps, @NotNull Bitmap[] pressedBitmaps, int index, @Nullable Resources r16, int drawableResIdNormal, int drawableResIdPressed) {
        Bitmap decodeResourceStream;
        Bitmap decodeResourceStream2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, normalBitmaps, pressedBitmaps, Integer.valueOf(index), r16, Integer.valueOf(drawableResIdNormal), Integer.valueOf(drawableResIdPressed));
            return;
        }
        Intrinsics.checkNotNullParameter(normalBitmaps, "normalBitmaps");
        Intrinsics.checkNotNullParameter(pressedBitmaps, "pressedBitmaps");
        if (normalBitmaps[index] == null && (decodeResourceStream2 = BaseImageUtil.decodeResourceStream(r16, drawableResIdNormal)) != null) {
            normalBitmaps[index] = decodeResourceStream2;
        }
        if (pressedBitmaps[index] == null && (decodeResourceStream = BaseImageUtil.decodeResourceStream(r16, drawableResIdPressed)) != null) {
            pressedBitmaps[index] = decodeResourceStream;
        }
    }
}
