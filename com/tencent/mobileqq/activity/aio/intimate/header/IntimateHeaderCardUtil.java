package com.tencent.mobileqq.activity.aio.intimate.header;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.freesia.IConfigData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.api.IAIOEmoApi;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bq\u0010rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0007J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020!2\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J\u0019\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0002H\u0007J \u0010)\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0004H\u0002J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\"\u00100\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0007J2\u00105\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u000103H\u0007J\u001a\u00107\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u000103H\u0002J\u0010\u00109\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u0002H\u0007J\u0010\u0010:\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010;\u001a\u00020\u0018H\u0007J\b\u0010<\u001a\u00020\u0018H\u0007J\b\u0010=\u001a\u00020\u0018H\u0007J6\u0010C\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u00042\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010AH\u0007J\u000e\u0010F\u001a\u00020\u00142\u0006\u0010E\u001a\u00020DJ\u000e\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u0016J\u0016\u0010I\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010J\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010K\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010N\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020L2\u0006\u00108\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010O\u001a\u00020\u001b2\u0006\u0010M\u001a\u00020L2\u0006\u0010.\u001a\u00020\u0004R\"\u0010V\u001a\u00020P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0017\u0010[\u001a\u00020W8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010X\u001a\u0004\bY\u0010ZR\u0017\u0010^\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010I\u001a\u0004\b\\\u0010]R\u0017\u0010`\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010I\u001a\u0004\b_\u0010]R\u0017\u0010c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u00105\u001a\u0004\ba\u0010bR#\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020A8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010d\u001a\u0004\be\u0010fR#\u0010l\u001a\n h*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010i\u001a\u0004\bj\u0010kR#\u0010n\u001a\n h*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010i\u001a\u0004\bm\u0010kR#\u0010p\u001a\n h*\u0004\u0018\u00010\u00180\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010i\u001a\u0004\bo\u0010k\u00a8\u0006s"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderCardUtil;", "", "", "type", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "level", "d", "c", "b", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "g", "e", "friendUin", "f", tl.h.F, BdhLogUtil.LogTag.Tag_Conn, "B", "Landroid/graphics/drawable/Drawable;", "D", "Lcom/tencent/mobileqq/data/IntimateInfo;", "intimateInfo", "", "L", "uin", "", "a", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "id", "Lkotlin/Triple;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Pair;", "E", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "(I)Ljava/lang/Integer;", "N", BdhLogUtil.LogTag.Tag_Req, "title", "W", "p", "o", "Landroid/view/View;", "view", "url", "mDefaultDrawable", "X", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "animRootView", "Landroid/widget/ImageView;", "gameView", "I", "intimateType", "K", "friendIntimateType", "O", "M", "u", "v", "t", "eventId", "pagId", "elementId", "", "hashMap", "U", "", "radius", "w", "info", "V", UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "G", "Landroid/content/Context;", "context", "J", "T", "Lcom/tencent/mobileqq/activity/aio/intimate/header/h;", "Lcom/tencent/mobileqq/activity/aio/intimate/header/h;", "getConfigBean", "()Lcom/tencent/mobileqq/activity/aio/intimate/header/h;", "setConfigBean", "(Lcom/tencent/mobileqq/activity/aio/intimate/header/h;)V", "configBean", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "l", "()Landroid/graphics/drawable/GradientDrawable$Orientation;", "HEAD_CARD_GRADIENT_ORIENTATION", "k", "()F", "HEAD_CARD_CORNER_RADIUS", "i", "HEAD_BIG_CARD_CORNER_RADIUS", "j", "()I", "HEAD_CARD_BORDER_WIDTH", "Ljava/util/Map;", "r", "()Ljava/util/Map;", "intimateStandardLabelMap", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Ljava/lang/Boolean;", "isNewHeaderSwitch", ExifInterface.LATITUDE_SOUTH, "isUnbindNewHeaderSwitch", "P", "isNewHeaderAnimationSwitch", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class IntimateHeaderCardUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final IntimateHeaderCardUtil f178990a = new IntimateHeaderCardUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static h configBean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GradientDrawable.Orientation HEAD_CARD_GRADIENT_ORIENTATION;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final float HEAD_CARD_CORNER_RADIUS;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final float HEAD_BIG_CARD_CORNER_RADIUS;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final int HEAD_CARD_BORDER_WIDTH;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, Integer> intimateStandardLabelMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isNewHeaderSwitch;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isUnbindNewHeaderSwitch;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isNewHeaderAnimationSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/header/IntimateHeaderCardUtil$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f179000d;

        a(View view) {
            this.f179000d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f179000d.setBackground(new ColorDrawable(0));
            this.f179000d.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    static {
        Map<Integer, Integer> mapOf;
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config");
        Intrinsics.checkNotNull(loadConfig, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderConfigData");
        configBean = (h) loadConfig;
        HEAD_CARD_GRADIENT_ORIENTATION = GradientDrawable.Orientation.TL_BR;
        HEAD_CARD_CORNER_RADIUS = ViewUtils.dpToPx(12.0f);
        HEAD_BIG_CARD_CORNER_RADIUS = ViewUtils.dpToPx(16.0f);
        HEAD_CARD_BORDER_WIDTH = ViewUtils.dpToPx(1.0f);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, Integer.valueOf(R.drawable.jue)), TuplesKt.to(2, Integer.valueOf(R.drawable.ju7)), TuplesKt.to(3, Integer.valueOf(R.drawable.jud)), TuplesKt.to(26, Integer.valueOf(R.drawable.jui)));
        intimateStandardLabelMap = mapOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil$isNewHeaderSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("SWIPE_LEFT_CHANGE_8992", Boolean.TRUE);
            }
        });
        isNewHeaderSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil$isUnbindNewHeaderSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("SWIPE_LEFT_CHANGE_UN_BIND_908", Boolean.TRUE);
            }
        });
        isUnbindNewHeaderSwitch = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil$isNewHeaderAnimationSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("SWIPE_LEFT_CHANGE_ANIMATION_908", Boolean.TRUE);
            }
        });
        isNewHeaderAnimationSwitch = lazy3;
    }

    IntimateHeaderCardUtil() {
    }

    @JvmStatic
    @Nullable
    public static final String A(int type) {
        return configBean.y().get(String.valueOf(type));
    }

    @JvmStatic
    @Nullable
    public static final String B(int type) {
        boolean z16;
        String str = configBean.z().get(String.valueOf(type));
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return C(type);
        }
        return str;
    }

    @JvmStatic
    @Nullable
    public static final String C(int type) {
        return configBean.A().get(String.valueOf(type));
    }

    @JvmStatic
    @Nullable
    public static final Drawable D(int type) {
        ArrayList<e61.a> a16;
        e61.b bVar = (e61.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101599");
        if (bVar != null && (a16 = bVar.a()) != null) {
            for (e61.a aVar : a16) {
                if (((int) aVar.getId()) == type) {
                    int dpToPx = ViewUtils.dpToPx(24.0f);
                    if (aVar.getEmotionId() > 0) {
                        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
                        Drawable drawable = resImpl.getDrawable(resImpl.getLocalId(aVar.getEmotionId()));
                        drawable.setBounds(new Rect(0, 0, dpToPx, dpToPx));
                        return drawable;
                    }
                    if ((!aVar.d().isEmpty()) && !TextUtils.isEmpty(aVar.getIcon())) {
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestHeight = dpToPx;
                        obtain.mRequestWidth = dpToPx;
                        return URLDrawable.getDrawable(aVar.getIcon(), obtain);
                    }
                }
            }
            return null;
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Pair<Integer, Integer> E(int id5) {
        if (!com.tencent.mobileqq.activity.aio.intimate.e.e(id5)) {
            id5 = 71;
        }
        List<String> list = configBean.o().get(String.valueOf(id5));
        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(Color.parseColor("#6680FF")), Integer.valueOf(Color.parseColor("#90E3FF")));
        if (list != null && list.size() >= 6) {
            String str = list.get(3);
            String str2 = list.get(4);
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                    } catch (Exception unused) {
                        return pair;
                    }
                }
                return new Pair<>(Integer.valueOf(Color.parseColor(str)), Integer.valueOf(Color.parseColor(str2)));
            }
            return pair;
        }
        return pair;
    }

    @JvmStatic
    @NotNull
    public static final String H(int type, int level) {
        String replace$default;
        String replace$default2;
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getUnselectedTabIconUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{level}", String.valueOf(level), false, 4, (Object) null);
        return replace$default2;
    }

    @JvmStatic
    public static final void I(int type, int level, @NotNull View rootView, @NotNull View animRootView, @Nullable ImageView gameView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(animRootView, "animRootView");
        if (QQTheme.isVasTheme()) {
            return;
        }
        Drawable background = rootView.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "rootView.getBackground()");
        animRootView.setVisibility(0);
        animRootView.setBackground(background);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        he0.b.l(alphaAnimation, R.anim.f154987uu);
        alphaAnimation.setAnimationListener(new a(animRootView));
        animRootView.startAnimation(alphaAnimation);
        X(rootView, d(type, level), background);
        if (M(type)) {
            if (gameView != null) {
                gameView.setVisibility(0);
            }
            f178990a.K(type, gameView);
        } else if (gameView != null) {
            gameView.setVisibility(8);
        }
    }

    private final void K(int intimateType, ImageView gameView) {
        if (gameView == null) {
            return;
        }
        String g16 = g(intimateType);
        Drawable drawable = gameView.getDrawable();
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        X(gameView, g16, drawable);
    }

    @JvmStatic
    public static final boolean L(@NotNull IntimateInfo intimateInfo) {
        List<f61.j> partnerInfos;
        Intrinsics.checkNotNullParameter(intimateInfo, "intimateInfo");
        f61.h hVar = intimateInfo.mutualMarkList;
        if (hVar != null && (partnerInfos = hVar.f397927h) != null) {
            Intrinsics.checkNotNullExpressionValue(partnerInfos, "partnerInfos");
            Iterator<T> it = partnerInfos.iterator();
            while (it.hasNext()) {
                if (((f61.j) it.next()).getIsBind()) {
                    return true;
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean M(int type) {
        return configBean.k().contains(String.valueOf(type));
    }

    @JvmStatic
    public static final boolean N(int id5) {
        List<String> n3 = configBean.n();
        if (n3.isEmpty()) {
            return false;
        }
        return n3.contains(String.valueOf(id5));
    }

    @JvmStatic
    public static final boolean O(int friendIntimateType) {
        if (friendIntimateType == 1 || friendIntimateType == 2 || friendIntimateType == 3 || friendIntimateType == 26) {
            return true;
        }
        return false;
    }

    private final Boolean P() {
        return (Boolean) isNewHeaderAnimationSwitch.getValue();
    }

    private final Boolean Q() {
        return (Boolean) isNewHeaderSwitch.getValue();
    }

    @JvmStatic
    public static final boolean R(int id5) {
        List<String> s16 = configBean.s();
        if (s16.isEmpty()) {
            return false;
        }
        return s16.contains(String.valueOf(id5));
    }

    private final Boolean S() {
        return (Boolean) isUnbindNewHeaderSwitch.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0014, code lost:
    
        r4 = kotlin.collections.MapsKt__MapsKt.toMutableMap(r4);
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void U(@NotNull String eventId, @NotNull String pagId, @NotNull String elementId, @Nullable Map<String, ? extends Object> hashMap) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(pagId, "pagId");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        if (hashMap == null || mutableMap == null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(new HashMap());
        }
        mutableMap.put("qq_pgid", pagId);
        mutableMap.put("qq_eid", elementId);
        mutableMap.putAll(j61.d.f409515a.d());
        VideoReport.reportEvent(eventId, mutableMap);
    }

    private final void W(int type, int level, String title) {
        if (TextUtils.isEmpty(title)) {
            return;
        }
        configBean.p().put(type + "_" + level, title);
    }

    @JvmStatic
    public static final void X(@NotNull View view, @NotNull String url, @Nullable Drawable mDefaultDrawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mExtraInfo = new Bundle();
        obtain.mLoadingDrawable = mDefaultDrawable;
        obtain.mFailedDrawable = mDefaultDrawable;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    @JvmStatic
    public static final void a(int type, @NotNull String uin) {
        ArrayList<e61.a> a16;
        Object random;
        Intrinsics.checkNotNullParameter(uin, "uin");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        e61.b bVar = (e61.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101599");
        Contact contact = new Contact(1, uidFromUin, "");
        if (bVar != null && (a16 = bVar.a()) != null) {
            for (e61.a aVar : a16) {
                if (((int) aVar.getId()) == type) {
                    if (aVar.getEmotionId() > 0) {
                        IAIOEmoApi.a.a((IAIOEmoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoApi.class), aVar.getEmotionId(), contact, true, null, 8, null);
                        return;
                    } else {
                        if (!aVar.d().isEmpty()) {
                            IAIOEmoApi iAIOEmoApi = (IAIOEmoApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoApi.class);
                            random = CollectionsKt___CollectionsKt.random(aVar.d(), Random.INSTANCE);
                            IAIOEmoApi.a.b(iAIOEmoApi, (String) random, contact, null, 4, null);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final String b(int type) {
        String replace$default;
        String replace$default2;
        String str;
        String replace$default3;
        if (M(type)) {
            replace$default2 = StringsKt__StringsJVMKt.replace$default(configBean.getGameCardLineBgUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
            if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                str = "1";
            } else {
                str = "0";
            }
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{isNight}", str, false, 4, (Object) null);
            return replace$default3;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getCardLineBgUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        return replace$default;
    }

    @JvmStatic
    @NotNull
    public static final String c(int type, int level) {
        String replace$default;
        String replace$default2;
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getCardTopBigIconUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{level}", String.valueOf(level), false, 4, (Object) null);
        String upgradeIconUrlToVersion2 = ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).upgradeIconUrlToVersion2(replace$default2);
        Intrinsics.checkNotNullExpressionValue(upgradeIconUrlToVersion2, "api(IMutualMarkHelperApi\u2026IconUrlToVersion2(origin)");
        return upgradeIconUrlToVersion2;
    }

    @JvmStatic
    @NotNull
    public static final String d(int type, int level) {
        String replace$default;
        String str;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String str2;
        String replace$default5;
        if (M(type)) {
            replace$default3 = StringsKt__StringsJVMKt.replace$default(configBean.getGameDrawerBgUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
            replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "{level}", String.valueOf(level), false, 4, (Object) null);
            if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            replace$default5 = StringsKt__StringsJVMKt.replace$default(replace$default4, "{isNight}", str2, false, 4, (Object) null);
            return replace$default5;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getDrawerBgUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
            str = "1";
        } else {
            str = "0";
        }
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{isNight}", str, false, 4, (Object) null);
        return replace$default2;
    }

    @JvmStatic
    @NotNull
    public static final String e(int type, int level) {
        String replace$default;
        String replace$default2;
        String str;
        String replace$default3;
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getGameCardRootBgUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{level}", String.valueOf(level), false, 4, (Object) null);
        if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
            str = "1";
        } else {
            str = "0";
        }
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{isNight}", str, false, 4, (Object) null);
        return replace$default3;
    }

    @JvmStatic
    @Nullable
    public static final String f(int type, @NotNull String friendUin) {
        String replace$default;
        String replace$default2;
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        String str = configBean.h().get(String.valueOf(type));
        if (str != null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(str, "{touin}", friendUin, false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{mutualmark_id}", String.valueOf(type), false, 4, (Object) null);
            return replace$default2;
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String g(int type) {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getGameHeaderCharUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        return replace$default;
    }

    @JvmStatic
    @NotNull
    public static final String h(int type) {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getGameShareBgUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        return replace$default;
    }

    @JvmStatic
    @NotNull
    public static final Triple<Integer, Integer, Integer> m(int id5) {
        if (!com.tencent.mobileqq.activity.aio.intimate.e.e(id5)) {
            id5 = 71;
        }
        List<String> list = configBean.o().get(String.valueOf(id5));
        Triple<Integer, Integer, Integer> triple = new Triple<>(Integer.valueOf(Color.parseColor("#6680FF")), Integer.valueOf(Color.parseColor("#90E3FF")), Integer.valueOf(Color.parseColor("#CCFFE6")));
        if (list != null && list.size() >= 6) {
            String str = list.get(0);
            String str2 = list.get(1);
            String str3 = list.get(2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str3)) {
                    try {
                    } catch (Exception unused) {
                        return triple;
                    }
                }
                return new Triple<>(Integer.valueOf(Color.parseColor(str)), Integer.valueOf(Color.parseColor(str2)), Integer.valueOf(Color.parseColor(str3)));
            }
            return triple;
        }
        return triple;
    }

    @JvmStatic
    @Nullable
    public static final Integer n(int id5) {
        int parseColor = Color.parseColor("#42D6F2");
        String str = configBean.q().get(String.valueOf(id5));
        if (str == null) {
            return Integer.valueOf(parseColor);
        }
        if (TextUtils.isEmpty(str)) {
            return Integer.valueOf(parseColor);
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception unused) {
            return Integer.valueOf(parseColor);
        }
    }

    @JvmStatic
    @NotNull
    public static final String o(int type, int level) {
        boolean z16;
        String str = configBean.p().get(type + "_" + level);
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = configBean.p().get(String.valueOf(type));
        }
        if (str == null || str.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            return str;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f229946xt);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.swipe_left_friend)");
        return qqStr;
    }

    @JvmStatic
    @NotNull
    public static final String p(int type, int level) {
        boolean z16;
        String str = configBean.p().get(type + "_" + level);
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str = configBean.p().get(String.valueOf(type));
        }
        if (str == null || str.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            return str;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f229936xs);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.swipe_left_become_friend)");
        return qqStr;
    }

    @JvmStatic
    @Nullable
    public static final String q(int type) {
        return configBean.r().get(String.valueOf(type));
    }

    @JvmStatic
    public static final int s(int id5) {
        if (!com.tencent.mobileqq.activity.aio.intimate.e.e(id5)) {
            id5 = 71;
        }
        List<String> list = configBean.o().get(String.valueOf(id5));
        int parseColor = Color.parseColor("#FFFFFF");
        if (list != null && list.size() >= 6) {
            String str = list.get(5);
            if (TextUtils.isEmpty(str)) {
                return parseColor;
            }
            try {
                return Color.parseColor(str);
            } catch (Exception unused) {
                return parseColor;
            }
        }
        return parseColor;
    }

    @JvmStatic
    public static final boolean t() {
        Boolean isNewHeaderAnimationSwitch2 = f178990a.P();
        Intrinsics.checkNotNullExpressionValue(isNewHeaderAnimationSwitch2, "isNewHeaderAnimationSwitch");
        return isNewHeaderAnimationSwitch2.booleanValue();
    }

    @JvmStatic
    public static final boolean u() {
        Boolean isNewHeaderSwitch2 = f178990a.Q();
        Intrinsics.checkNotNullExpressionValue(isNewHeaderSwitch2, "isNewHeaderSwitch");
        return isNewHeaderSwitch2.booleanValue();
    }

    @JvmStatic
    public static final boolean v() {
        Boolean isUnbindNewHeaderSwitch2 = f178990a.S();
        Intrinsics.checkNotNullExpressionValue(isUnbindNewHeaderSwitch2, "isUnbindNewHeaderSwitch");
        return isUnbindNewHeaderSwitch2.booleanValue();
    }

    @JvmStatic
    @NotNull
    public static final String y(int type) {
        String replace$default;
        String str;
        String replace$default2;
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getSelectedTabBgUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
            str = "1";
        } else {
            str = "0";
        }
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "{isNight}", str, false, 4, (Object) null);
        return replace$default2;
    }

    @JvmStatic
    @NotNull
    public static final String z(int type) {
        String replace$default;
        replace$default = StringsKt__StringsJVMKt.replace$default(configBean.getSelectedTabIconUrl(), "{type}", String.valueOf(type), false, 4, (Object) null);
        return replace$default;
    }

    public final int F(int type, int level) {
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 26) {
                        if (type != 71) {
                            if (type != 81) {
                                if (type == 82) {
                                    return R.drawable.o39;
                                }
                                return 0;
                            }
                            return R.drawable.o38;
                        }
                        return R.drawable.mgx;
                    }
                    if (level != 0) {
                        if (level != 1) {
                            if (level == 2) {
                                return R.drawable.mgq;
                            }
                            return 0;
                        }
                        return R.drawable.mgp;
                    }
                    return R.drawable.mgo;
                }
                if (level != 0) {
                    if (level != 1) {
                        if (level == 2) {
                            return R.drawable.mgw;
                        }
                        return 0;
                    }
                    return R.drawable.mgv;
                }
                return R.drawable.mgu;
            }
            if (level != 0) {
                if (level != 1) {
                    if (level == 2) {
                        return R.drawable.mgt;
                    }
                    return 0;
                }
                return R.drawable.mgs;
            }
            return R.drawable.mgr;
        }
        if (level != 0) {
            if (level != 1) {
                if (level != 2) {
                    return 0;
                }
                return R.drawable.mgn;
            }
            return R.drawable.mgm;
        }
        return R.drawable.mgl;
    }

    public final int G(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 26) {
                        if (type != 71) {
                            if (type != 81) {
                                if (type != 82) {
                                    return 0;
                                }
                                if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                                    return R.drawable.mzi;
                                }
                                return R.drawable.mzh;
                            }
                            if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                                return R.drawable.mzg;
                            }
                            return R.drawable.mzf;
                        }
                        if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                            return R.drawable.mf8;
                        }
                        return R.drawable.mf7;
                    }
                    if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                        return R.drawable.f160889mf2;
                    }
                    return R.drawable.f160888mf1;
                }
                if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                    return R.drawable.mf6;
                }
                return R.drawable.mf5;
            }
            if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
                return R.drawable.f160891mf4;
            }
            return R.drawable.f160890mf3;
        }
        if (com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
            return R.drawable.f160887mf0;
        }
        return R.drawable.mez;
    }

    public final void J(@NotNull Context context, int friendIntimateType, @NotNull String friendUin) {
        boolean contains$default;
        boolean contains$default2;
        String url;
        String url2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        if (com.tencent.mobileqq.activity.aio.intimate.e.e(friendIntimateType)) {
            String url3 = FriendIntimateRelationshipHelper.p();
            if (!TextUtils.isEmpty(url3)) {
                Intrinsics.checkNotNullExpressionValue(url3, "url");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url3, (CharSequence) "frd_uin=", false, 2, (Object) null);
                if (contains$default) {
                    Intrinsics.checkNotNullExpressionValue(url3, "url");
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url3, (CharSequence) "frd_type=", false, 2, (Object) null);
                    if (contains$default2) {
                        Intrinsics.checkNotNullExpressionValue(url3, "url");
                        url = StringsKt__StringsJVMKt.replace$default(url3, "frd_uin=", "frd_uin=" + friendUin, false, 4, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        url2 = StringsKt__StringsJVMKt.replace$default(url, "frd_type=", "frd_type=" + friendIntimateType, false, 4, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(url2, "url");
                        T(context, url2);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (friendIntimateType == 0) {
            String url4 = FriendIntimateRelationshipHelper.b(friendUin);
            Intrinsics.checkNotNullExpressionValue(url4, "url");
            T(context, url4);
        }
    }

    public final void T(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(url) || !w.a(1000L)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        context.startActivity(intent);
    }

    public final void V(@NotNull IntimateInfo info) {
        List<MutualMarkModel> list;
        Intrinsics.checkNotNullParameter(info, "info");
        f61.h hVar = info.mutualMarkList;
        if (hVar != null && (list = hVar.f397922c) != null) {
            for (MutualMarkModel mutualMarkModel : list) {
                int i3 = (int) mutualMarkModel.D;
                long j3 = mutualMarkModel.X;
                if (O(i3) || (j3 & 64) != 0) {
                    List<MutualMarkModel.Graded> list2 = mutualMarkModel.Y;
                    if (list2 != null) {
                        int i16 = 0;
                        for (MutualMarkModel.Graded graded : list2) {
                            int i17 = i16 + 1;
                            if (!O(i3)) {
                                i16 = i17;
                            }
                            String str = graded.f252169e;
                            Intrinsics.checkNotNullExpressionValue(str, "grade.name");
                            W(i3, i16, str);
                            i16 = i17;
                        }
                    }
                }
            }
        }
    }

    public final float i() {
        return HEAD_BIG_CARD_CORNER_RADIUS;
    }

    public final int j() {
        return HEAD_CARD_BORDER_WIDTH;
    }

    public final float k() {
        return HEAD_CARD_CORNER_RADIUS;
    }

    @NotNull
    public final GradientDrawable.Orientation l() {
        return HEAD_CARD_GRADIENT_ORIENTATION;
    }

    @NotNull
    public final Map<Integer, Integer> r() {
        return intimateStandardLabelMap;
    }

    @NotNull
    public final Drawable w(float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(radius);
        gradientDrawable.setColor(ColorStateList.valueOf(Color.parseColor("#B3000000")));
        return gradientDrawable;
    }

    public final int x(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 26) {
                        if (type != 71) {
                            if (type != 81) {
                                if (type != 82) {
                                    return 0;
                                }
                                return R.drawable.mzd;
                            }
                            return R.drawable.mzc;
                        }
                        return R.drawable.mex;
                    }
                    return R.drawable.mev;
                }
                return R.drawable.mew;
            }
            return R.drawable.meu;
        }
        return R.drawable.met;
    }
}
