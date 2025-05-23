package com.tencent.mobileqq.onlinestatus.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.view.u;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilesetting.api.IProfileSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u0002:\u0002\u0081\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020(\u0012\u0006\u00106\u001a\u00020/\u0012\u0006\u0010}\u001a\u00020|\u00a2\u0006\u0004\b~\u0010\u007fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J,\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0003J\"\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\"\u0010\"\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\u0012\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010$H\u0014J\b\u0010'\u001a\u00020\u0003H\u0014R\"\u0010\u000f\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010HR\u0016\u0010J\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0018\u0010R\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010UR\u0018\u0010\\\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010UR\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010UR\u0018\u0010d\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010UR\u0018\u0010f\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010UR\u0014\u0010h\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010QR\"\u0010n\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010H\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bp\u0010qR*\u0010{\u001a\n t*\u0004\u0018\u00010s0s8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010z\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/ConstellationView;", "Lcom/tencent/mobileqq/onlinestatus/view/v;", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg$b;", "", "s0", "p0", "l0", "", "url", "Landroid/widget/ImageView;", "view", "", "B0", "u0", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "okClicked", "onCanceled", "y0", "onBackPressed", "Landroid/view/View;", "q0", "n0", "isSuccess", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "color", "v3", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", ExifInterface.LATITUDE_SOUTH, "show", "", "cardRect", BdhLogUtil.LogTag.Tag_Req, "O", "Lcom/tencent/mobileqq/app/QBaseActivity;", "J", "Lcom/tencent/mobileqq/app/QBaseActivity;", "r0", "()Lcom/tencent/mobileqq/app/QBaseActivity;", "setActivity", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "K", "Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "getOnLineStatusBlurBg", "()Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;", "setOnLineStatusBlurBg", "(Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;)V", "onLineStatusBlurBg", "Lcom/tencent/mobileqq/data/Card;", "L", "Lcom/tencent/mobileqq/data/Card;", "selfProfileCard", "Landroid/graphics/drawable/BitmapDrawable;", "M", "Landroid/graphics/drawable/BitmapDrawable;", "defaultBgDrawable", "N", "Ljava/lang/String;", "constellationStr", "P", "todayConstellationTrend", "Lkc2/e;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkc2/e;", "statusExtInfoObserver", "I", "constellationIndex", "birthdayValue", "T", "Landroid/widget/ImageView;", "viewConstellationIcon", "U", "viewMainBackground", "V", "Landroid/view/View;", "viewNightThemeBg", "Landroid/widget/TextView;", "W", "Landroid/widget/TextView;", "viewConstellationName", "X", "viewConstellationTrend", "Y", "viewMainTitle", "Z", "viewSubTitle", "Landroid/widget/Button;", "a0", "Landroid/widget/Button;", "viewSelectStatus", "b0", "viewSelectConstellation", "c0", "viewChangeConstellation", "d0", "viewConstellationDate", "e0", "contentView", "f0", "getWidthBg", "()I", "setWidthBg", "(I)V", "widthBg", "Lmqq/app/AppRuntime;", "g0", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "h0", "Lcom/tencent/qphone/base/util/BaseApplication;", "getAppContext", "()Lcom/tencent/qphone/base/util/BaseApplication;", "setAppContext", "(Lcom/tencent/qphone/base/util/BaseApplication;)V", "appContext", "Lcom/tencent/mobileqq/onlinestatus/view/v$a;", "dismissCallback", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/onlinestatus/OnLineStatusBlurBg;Lcom/tencent/mobileqq/onlinestatus/view/v$a;)V", "i0", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ConstellationView extends v implements OnLineStatusBlurBg.b {

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private QBaseActivity activity;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private OnLineStatusBlurBg onLineStatusBlurBg;

    /* renamed from: L, reason: from kotlin metadata */
    private Card selfProfileCard;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private BitmapDrawable defaultBgDrawable;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String constellationStr;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private String todayConstellationTrend;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private kc2.e statusExtInfoObserver;

    /* renamed from: R, reason: from kotlin metadata */
    private int constellationIndex;

    /* renamed from: S, reason: from kotlin metadata */
    private int birthdayValue;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private ImageView viewConstellationIcon;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ImageView viewMainBackground;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private View viewNightThemeBg;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private TextView viewConstellationName;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TextView viewConstellationTrend;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private TextView viewMainTitle;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private TextView viewSubTitle;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Button viewSelectStatus;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView viewSelectConstellation;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView viewChangeConstellation;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView viewConstellationDate;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View contentView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int widthBg;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime app;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private BaseApplication appContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/ConstellationView$a;", "", "Lmqq/app/AppRuntime;", "app", "", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.ConstellationView$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@NotNull AppRuntime app) {
            boolean z16;
            ArrayList<Integer> arrayListOf;
            Intrinsics.checkNotNullParameter(app, "app");
            IRuntimeService runtimeService = app.getRuntimeService(IProfileDataService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
            if (((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).getProfileSettingStateFromCard(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION, ((IProfileDataService) runtimeService).getProfileCard(app.getCurrentUin(), true)) == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ConstellationView", 2, "onSelectStatusCallback: called. ", "displaySettingNotPrepared: " + z16);
            }
            if (z16) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Integer.valueOf(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION));
                ((IProfileSettingApi) QRoute.api(IProfileSettingApi.class)).requestProfileSettingState((AppInterface) app, arrayListOf);
            }
            return z16;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/ConstellationView$b", "Lkc2/e;", "", "success", "Landroid/os/Bundle;", "bundle", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends kc2.e {
        b() {
        }

        @Override // kc2.e
        public void a(boolean success, @Nullable Bundle bundle) {
            String str;
            super.a(success, bundle);
            if (QLog.isColorLevel()) {
                QLog.d("ConstellationView", 2, "onGetConstellationTrend: called. ", "bundle: " + bundle);
            }
            ConstellationView constellationView = ConstellationView.this;
            if (bundle == null || (str = bundle.getString("key_today_constellation_trend")) == null) {
                str = "";
            }
            constellationView.todayConstellationTrend = str;
            ConstellationView.this.n0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstellationView(@NotNull QBaseActivity activity, @NotNull OnLineStatusBlurBg onLineStatusBlurBg, @NotNull v.a dismissCallback) {
        super(activity, dismissCallback);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onLineStatusBlurBg, "onLineStatusBlurBg");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        this.activity = activity;
        this.onLineStatusBlurBg = onLineStatusBlurBg;
        AppRuntime appRuntime = activity.getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(appRuntime, "activity.getAppRuntime()");
        this.app = appRuntime;
        this.appContext = BaseApplication.context;
        View q06 = q0();
        q06.findViewById(R.id.root_layout).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConstellationView.w0(ConstellationView.this, view);
            }
        });
        View findViewById = q06.findViewById(R.id.b9w);
        this.D = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConstellationView.x0(view);
            }
        });
        this.contentView = q06;
        s0();
        n0();
        setContentView(q06);
        this.C = q06;
        this.widthBg = Utils.n(296.0f, this.appContext.getResources());
        int n3 = Utils.n(211.0f, this.appContext.getResources());
        float q16 = 12 * com.tencent.mobileqq.utils.ah.q();
        Bitmap j3 = com.tencent.mobileqq.util.j.j(this.appContext.getResources(), R.drawable.k5q, this.widthBg, n3);
        if (j3 != null) {
            this.defaultBgDrawable = new BitmapDrawable(this.appContext.getResources(), BaseImageUtil.getHalfRoundedBitmap(j3, q16, this.widthBg, n3));
        }
        if (Build.VERSION.SDK_INT >= 24) {
            CompletableFuture.runAsync(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.z
                @Override // java.lang.Runnable
                public final void run() {
                    ConstellationView.i0(ConstellationView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(Function0 onCanceled, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onCanceled, "$onCanceled");
        onCanceled.invoke();
    }

    private final boolean B0(String url, ImageView view) {
        boolean z16;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        BitmapDrawable bitmapDrawable = this.defaultBgDrawable;
        obtain.mLoadingDrawable = bitmapDrawable;
        obtain.mFailedDrawable = bitmapDrawable;
        if (view != null) {
            obtain.mRequestWidth = view.getWidth();
            obtain.mRequestHeight = view.getHeight();
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            drawable.setTag(com.tencent.mobileqq.onlinestatus.utils.ah.a(obtain.mRequestWidth, obtain.mRequestHeight, (int) (12 * com.tencent.mobileqq.utils.ah.q())));
            drawable.setDecodeHandler(com.tencent.mobileqq.onlinestatus.utils.ah.f256343c);
            if (view != null) {
                view.setImageDrawable(drawable);
            }
            if (drawable.getStatus() != 2) {
                return true;
            }
            return false;
        }
        if (view != null) {
            view.setImageDrawable(this.defaultBgDrawable);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(ConstellationView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INSTANCE.a(this$0.app);
    }

    private final void l0() {
        boolean z16;
        String string;
        String string2;
        Resources resources = this.appContext.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "appContext.resources");
        if (this.constellationIndex != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            string = resources.getString(R.string.f196994it);
            Intrinsics.checkNotNullExpressionValue(string, "res.getString(com.tencen\u2026nstellation_select_part1)");
            string2 = resources.getString(R.string.f197004iu);
            Intrinsics.checkNotNullExpressionValue(string2, "res.getString(com.tencen\u2026nstellation_select_part2)");
        } else {
            string = resources.getString(R.string.f196974ir);
            Intrinsics.checkNotNullExpressionValue(string, "res.getString(com.tencen\u2026select_no_birthday_part1)");
            string2 = resources.getString(R.string.f196984is);
            Intrinsics.checkNotNullExpressionValue(string2, "res.getString(com.tencen\u2026select_no_birthday_part2)");
        }
        TextView textView = this.viewSelectConstellation;
        if (textView != null) {
            textView.setText(string);
        }
        TextView textView2 = this.viewChangeConstellation;
        if (textView2 != null) {
            textView2.setText(string2);
            textView2.setClickable(true);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConstellationView.m0(ConstellationView.this, view);
                }
            });
            textView2.setOnTouchListener(new u.a());
            if (ThemeImageWrapper.isNightMode()) {
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.mhb, 0);
            } else {
                textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.crl, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(ConstellationView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kc2.a.f412010a.b(this$0.activity, "VAL_FROM_STATUS_MSG_TAB");
        bv.e("0X800AF45", 0, null, null, 14, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(final ConstellationView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y0(this$0.activity, new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.ConstellationView$bindView$4$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                AppRuntime appRuntime;
                if (AppNetConnInfo.isNetSupport()) {
                    kc2.d dVar = kc2.d.f412021a;
                    appRuntime = ConstellationView.this.app;
                    dVar.a(appRuntime, 1040);
                } else {
                    QQToast.makeText(ConstellationView.this.getActivity(), 1, R.string.hpk, 0).show();
                    ConstellationView.this.I.L0(AppRuntime.Status.online, 1040);
                }
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.ConstellationView$bindView$4$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ConstellationView.this.I.L0(AppRuntime.Status.online, 1040);
            }
        });
        this$0.I.G0(AppRuntime.Status.online, 1040L);
        this$0.dismiss();
        bv.e("0X800AF44", 0, null, null, 14, null);
        bv.e("0X8009DE0", 1040, null, null, 12, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p0() {
        OnLineStatusBlurBg.a aVar = new OnLineStatusBlurBg.a();
        QBaseActivity qBaseActivity = this.activity;
        Intrinsics.checkNotNull(qBaseActivity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        aVar.f255313b = qBaseActivity;
        this.onLineStatusBlurBg.i(aVar, this);
    }

    private final void s0() {
        IProfileCardUtil iProfileCardUtil = (IProfileCardUtil) QRoute.api(IProfileCardUtil.class);
        AppRuntime appRuntime = this.app;
        Card initCard = iProfileCardUtil.initCard(appRuntime, appRuntime.getCurrentAccountUin());
        Intrinsics.checkNotNullExpressionValue(initCard, "api(IProfileCardUtil::cl\u2026p, app.currentAccountUin)");
        this.selfProfileCard = initCard;
        Card card = null;
        if (initCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
            initCard = null;
        }
        this.birthdayValue = (int) initCard.lBirthday;
        Card card2 = this.selfProfileCard;
        if (card2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
        } else {
            card = card2;
        }
        int i3 = card.constellation;
        this.constellationIndex = i3;
        this.constellationStr = com.tencent.mobileqq.onlinestatus.bs.u(i3);
        this.statusExtInfoObserver = new b();
    }

    private final boolean u0() {
        IProfileSettingApi iProfileSettingApi = (IProfileSettingApi) QRoute.api(IProfileSettingApi.class);
        Card card = this.selfProfileCard;
        if (card == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selfProfileCard");
            card = null;
        }
        if (iProfileSettingApi.getProfileSettingStateFromCard(IProfileSettingApi.FIELD_PRIVACY_CONSTELLATION, card) != 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(ConstellationView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        this$0.I.L0(AppRuntime.Status.online, 1040);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y0(Activity activity, final Function0<Unit> okClicked, final Function0<Unit> onCanceled) {
        boolean u06 = u0();
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationView", 2, "onProfileVisibleLoaded: called. ", "constellationVisible: " + u06);
        }
        if (!u06) {
            try {
                DialogUtil.createCustomDialog(activity, 230, activity.getResources().getString(R.string.f196954ip), activity.getResources().getString(R.string.f196924im), R.string.f196934in, R.string.f196944io, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ab
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ConstellationView.z0(Function0.this, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.ac
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        ConstellationView.A0(Function0.this, dialogInterface, i3);
                    }
                }).show();
                return;
            } catch (Exception e16) {
                QLog.e("ConstellationView", 1, e16, new Object[0]);
                return;
            }
        }
        okClicked.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(Function0 okClicked, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(okClicked, "$okClicked");
        okClicked.invoke();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v
    protected void O() {
        this.app.unRegistObserver(this.statusExtInfoObserver);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v
    protected void R(@Nullable int[] cardRect) {
        if (cardRect != null) {
            if (this.D.getWidth() != 0 && this.D.getHeight() != 0) {
                cardRect[0] = this.D.getWidth();
                cardRect[1] = this.D.getHeight();
            } else {
                cardRect[0] = this.widthBg;
                cardRect[1] = Utils.n(430.0f, this.D.getResources());
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v
    public void S(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == kc2.a.REQUEST_CODE_BIRTHDAY && data != null) {
            Pair<Integer, String> a16 = ae.a(this.app, data, this.constellationStr);
            if (this.birthdayValue != a16.getFirst().intValue()) {
                QQToast.makeText(BaseApplication.context, 0, R.string.znl, 0).show();
            }
            this.birthdayValue = a16.getFirst().intValue();
            this.constellationStr = a16.getSecond();
            n0();
        }
    }

    public final void n0() {
        boolean z16;
        boolean z17;
        int i3;
        B0(kc2.c.n(this.app), this.viewConstellationIcon);
        if (this.constellationIndex != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            z17 = B0(kc2.c.a(this.app), this.viewMainBackground);
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationView", 2, "bindView: called. ", "bgSuccessLoad: " + z17 + "  hasBirthdaySet: " + z16);
        }
        if (z17) {
            TextView textView = this.viewConstellationName;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.viewConstellationDate;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            ImageView imageView = this.viewConstellationIcon;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView3 = this.viewConstellationTrend;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else {
            TextView textView4 = this.viewConstellationName;
            if (textView4 != null) {
                textView4.setVisibility(4);
            }
            TextView textView5 = this.viewConstellationDate;
            if (textView5 != null) {
                textView5.setVisibility(4);
            }
            ImageView imageView2 = this.viewConstellationIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(4);
            }
            TextView textView6 = this.viewConstellationTrend;
            if (textView6 != null) {
                textView6.setVisibility(4);
            }
            ImageView imageView3 = this.viewMainBackground;
            if (imageView3 != null) {
                imageView3.setImageDrawable(this.defaultBgDrawable);
            }
        }
        try {
            String e16 = kc2.c.e(this.app);
            if (QLog.isColorLevel()) {
                QLog.d("ConstellationView", 2, "bindView: called. ", "constellationStr: " + this.constellationStr + ",  textColorFromSp: " + e16);
            }
            i3 = Color.parseColor(e16);
        } catch (Exception unused) {
            i3 = -16777216;
        }
        TextView textView7 = this.viewConstellationName;
        if (textView7 != null) {
            textView7.setText(this.constellationStr);
            textView7.setTextColor(i3);
        }
        TextView textView8 = this.viewConstellationTrend;
        if (textView8 != null) {
            textView8.setText(this.todayConstellationTrend);
            textView8.setTextColor(i3);
        }
        TextView textView9 = this.viewConstellationDate;
        if (textView9 != null) {
            textView9.setText(kc2.c.f());
            textView9.setTextColor(i3);
        }
        Button button = this.viewSelectStatus;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.view.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ConstellationView.o0(ConstellationView.this, view);
                }
            });
            if (z16) {
                if (kc2.c.p(this.app)) {
                    button.setText(this.app.getApp().getText(R.string.cne));
                    button.setEnabled(false);
                } else {
                    button.setText(this.app.getApp().getText(R.string.f171175cx0));
                    button.setEnabled(true);
                }
            } else {
                button.setText(this.app.getApp().getText(R.string.f171175cx0));
                button.setEnabled(false);
            }
        }
        l0();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        this.I.L0(AppRuntime.Status.online, 1040);
    }

    @NotNull
    public final View q0() {
        View view = View.inflate(BaseApplication.context, R.layout.h4z, null);
        this.viewConstellationName = (TextView) view.findViewById(R.id.u5m);
        this.viewConstellationTrend = (TextView) view.findViewById(R.id.u5w);
        this.viewSelectStatus = (Button) view.findViewById(R.id.f82444gw);
        this.viewSelectConstellation = (TextView) view.findViewById(R.id.f82084fx);
        this.viewChangeConstellation = (TextView) view.findViewById(R.id.f82024fr);
        this.viewConstellationDate = (TextView) view.findViewById(R.id.u5k);
        this.viewConstellationIcon = (ImageView) view.findViewById(R.id.u5l);
        this.viewMainBackground = (ImageView) view.findViewById(R.id.yw7);
        this.viewNightThemeBg = view.findViewById(R.id.zrj);
        this.viewMainTitle = (TextView) view.findViewById(R.id.ywk);
        this.viewSubTitle = (TextView) view.findViewById(R.id.f166931j64);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @NotNull
    /* renamed from: r0, reason: from getter */
    public final QBaseActivity getActivity() {
        return this.activity;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (QQTheme.isNowThemeIsNight()) {
            View view = this.D;
            if (view != null) {
                view.setBackgroundResource(R.drawable.kxv);
            }
            v3(false, null, Color.parseColor("#FF010101"));
            View view2 = this.viewNightThemeBg;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else {
            View view3 = this.D;
            if (view3 != null) {
                view3.setBackgroundResource(R.drawable.qq_status_card_background);
            }
            p0();
            View view4 = this.viewNightThemeBg;
            if (view4 != null) {
                view4.setVisibility(8);
            }
        }
        this.app.registObserver(this.statusExtInfoObserver);
        OnlineStatusExtInfoServlet.b(this.app, this.constellationStr);
        try {
            Y(this.viewMainTitle);
            Y(this.viewSubTitle);
            super.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ConstellationView", 2, "show: called. ", "", e16);
            }
        }
        X(true);
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg.b
    public void v3(boolean isSuccess, @Nullable Bitmap bitmap, int color) {
        View view;
        if (isSuccess && bitmap != null && (view = this.contentView) != null) {
            view.setBackgroundDrawable(new BitmapDrawable(bitmap));
        } else {
            this.contentView.setBackgroundColor(color);
        }
    }
}
