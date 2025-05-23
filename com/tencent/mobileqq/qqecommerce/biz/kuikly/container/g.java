package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\b\u0011\u0018\u0000 \u00032\u00020\u0001:\u0001DB-\u0012\b\u0010F\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010I\u001a\u00020\u0002\u0012\u0006\u0010P\u001a\u00020J\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b{\u0010|J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000bH\u0002J\u001c\u0010\u000f\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002J\u001c\u0010\u0010\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0002J$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\"J&\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020\u0002J\u0010\u0010-\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u0002J\u0006\u0010.\u001a\u00020\u0015J\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u00020\u0015J*\u00106\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u0001022\u0006\u00105\u001a\u0002042\b\b\u0002\u0010,\u001a\u00020\u0002J\u0010\u00108\u001a\u00020\u00152\b\u00107\u001a\u0004\u0018\u00010\u001dJ\u000e\u00109\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010:\u001a\u00020\u0015J\u000e\u0010<\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\bJ \u0010A\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010?J\u0006\u0010B\u001a\u00020\u0005J\u0006\u0010C\u001a\u00020\u0015R\u0016\u0010F\u001a\u0004\u0018\u00010\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\"\u0010P\u001a\u00020J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010QR\u0016\u0010S\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010HR$\u0010Z\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010^R\u0018\u0010a\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010bR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR \u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010fR\u0016\u0010i\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010HR\u0016\u0010j\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010HR\u0016\u0010k\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010HR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020\b0l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010mR\"\u0010r\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010e\u001a\u0004\bh\u0010o\"\u0004\bp\u0010qR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010:R\u001d\u0010z\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\bd\u0010y\u00a8\u0006}"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/g;", "", "", "t", ReportConstant.COSTREPORT_PREFIX, "", "bundleName", "pageName", "", "j", "o", "", "d", "", "param", "g", "l", "u", "Landroid/app/Activity;", "f", "Landroid/widget/ImageView;", "", "P", "Landroid/content/Context;", "ctx", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "delegate", "Landroid/util/Size;", "size", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "e", "p", "Landroid/view/LayoutInflater;", "i", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, HippyTKDListViewAdapter.X, "Landroid/view/View;", "y", "D", UserInfo.SEX_FEMALE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", "w", "needFinishCurrentActivity", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "O", "r", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "B", "newKuiklyView", "H", "G", "I", "type", "c", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "v", tl.h.F, "J", "a", "Landroid/os/Bundle;", "arguments", "b", "Z", "isEmbedScene", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/h;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/h;", "getProvider", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/h;", "K", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/h;)V", "provider", "Landroid/content/Context;", "replaceableContext", "isErrorUrlJumped", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", DomainData.DOMAIN_NAME, "()Landroid/widget/FrameLayout;", "setRootContainer", "(Landroid/widget/FrameLayout;)V", "rootContainer", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "loadingViewContainer", "Landroid/widget/ImageView;", "loadingImageView", "Landroid/view/View;", "errorViewContainer", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "kuiklyRenderView", "k", "Ljava/lang/String;", "Ljava/util/Map;", "params", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "modalMode", "supportCustomBackPressed", "pageOpenSuccess", "", "Ljava/util/List;", "asyncLoaderResultTaskTypes", "()Ljava/lang/String;", "setPagerName", "(Ljava/lang/String;)V", "pagerName", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "getDelegate", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "setDelegate", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;)V", "maxWidthOnSplitMode", "()Ljava/util/Map;", ISchemeApi.KEY_PAGE_DATA, "<init>", "(Landroid/os/Bundle;ZLcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/h;Landroid/content/Context;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {

    /* renamed from: t, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: u */
    private static final Map<String, g> f262873u = new LinkedHashMap();

    /* renamed from: a, reason: from kotlin metadata */
    private final Bundle arguments;

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean isEmbedScene;

    /* renamed from: c, reason: from kotlin metadata */
    private h provider;

    /* renamed from: d, reason: from kotlin metadata */
    private Context replaceableContext;

    /* renamed from: e, reason: from kotlin metadata */
    private boolean isErrorUrlJumped;

    /* renamed from: f, reason: from kotlin metadata */
    private FrameLayout rootContainer;

    /* renamed from: g, reason: from kotlin metadata */
    private LinearLayout loadingViewContainer;

    /* renamed from: h */
    private ImageView loadingImageView;

    /* renamed from: i, reason: from kotlin metadata */
    private View errorViewContainer;

    /* renamed from: j, reason: from kotlin metadata */
    private QQKuiklyRenderView kuiklyRenderView;

    /* renamed from: k, reason: from kotlin metadata */
    private String bundleName;

    /* renamed from: l, reason: from kotlin metadata */
    private final Map<String, Object> params;

    /* renamed from: m */
    private boolean modalMode;

    /* renamed from: n */
    private boolean supportCustomBackPressed;

    /* renamed from: o, reason: from kotlin metadata */
    private boolean pageOpenSuccess;

    /* renamed from: p, reason: from kotlin metadata */
    private final List<Integer> asyncLoaderResultTaskTypes;

    /* renamed from: q */
    private String pagerName;

    /* renamed from: r, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate;

    /* renamed from: s */
    private int maxWidthOnSplitMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/g$a;", "", "", "id", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/g;", "b", "controller", "", "a", "", "ASYNC_LOADER_PENDING_TASK_TYPE_FIRST_SCREEN", "I", "ASYNC_LOADER_PENDING_TASK_TYPE_FIRST_SCREEN_TIMEOUT", "ASYNC_LOADER_PENDING_TASK_TYPE_SHOW_ERROR_VIEW", "ASYNC_LOADER_PENDING_TASK_TYPE_SHOW_LOADING_VIEW", "TAG", "Ljava/lang/String;", "", "sharedAsyncLoaderMap", "Ljava/util/Map;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.g$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String id5, g controller) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(controller, "controller");
            g.f262873u.put(id5, controller);
        }

        public final g b(String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
            return (g) g.f262873u.remove(id5);
        }

        Companion() {
        }
    }

    public g(Bundle bundle, boolean z16, h provider, Context context) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.arguments = bundle;
        this.isEmbedScene = z16;
        this.provider = provider;
        this.replaceableContext = context;
        this.bundleName = "";
        this.params = new LinkedHashMap();
        this.asyncLoaderResultTaskTypes = new ArrayList();
        this.pagerName = "";
    }

    public static final void N(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQKuiklyRenderView qQKuiklyRenderView = this$0.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            g.a.b(qQKuiklyRenderView, this$0.pagerName, this$0.params, null, 4, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void P(ImageView imageView) {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        imageView.startAnimation(rotateAnimation);
    }

    private final Map<String, Object> d() {
        Bundle bundle;
        Bundle bundle2 = this.arguments;
        if (bundle2 != null && (bundle = bundle2.getBundle("launchKuiklyParams")) != null) {
            Set<String> keySet = bundle.keySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String key : keySet) {
                Object obj = bundle.get(key);
                if (obj != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    linkedHashMap.put(key, obj);
                }
            }
            return linkedHashMap;
        }
        return new LinkedHashMap();
    }

    private final QQKuiklyRenderView e(Context ctx, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate, Size size) {
        this.delegate = delegate;
        QQKuiklyRenderView qQKuiklyRenderView = new QQKuiklyRenderView(ctx, delegate, this.isEmbedScene);
        qQKuiklyRenderView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        qQKuiklyRenderView.b(this.pagerName, this.params, size);
        return qQKuiklyRenderView;
    }

    private final Activity f() {
        Activity eh5 = this.provider.eh();
        if (eh5 != null) {
            return eh5;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        return qBaseActivity != null ? qBaseActivity : Foreground.getTopActivity();
    }

    private final String g(Map<String, ? extends Object> param) {
        Object obj = param.get("bundle_name");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    private final LayoutInflater i() {
        Context context = this.replaceableContext;
        if (context != null) {
            LayoutInflater cloneInContext = LayoutInflater.from(context).cloneInContext(context);
            Intrinsics.checkNotNullExpressionValue(cloneInContext, "{\n            LayoutInfl\u2026aceableContext)\n        }");
            return cloneInContext;
        }
        LayoutInflater from = LayoutInflater.from(this.provider.Q3());
        Intrinsics.checkNotNullExpressionValue(from, "{\n            LayoutInfl\u2026ovideContext())\n        }");
        return from;
    }

    private final int j(String bundleName, String pageName) {
        int a16 = com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.a.INSTANCE.a(bundleName, pageName);
        if (a16 > 0) {
            return ViewUtils.dip2px(a16);
        }
        return 0;
    }

    private final String l(Map<String, ? extends Object> param) {
        Object obj = param.get("page_name");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    private final int o() {
        Size c16;
        Activity f16 = f();
        FragmentActivity fragmentActivity = f16 instanceof FragmentActivity ? (FragmentActivity) f16 : null;
        if (fragmentActivity == null || (c16 = com.tencent.mobileqq.pad.m.c(fragmentActivity)) == null) {
            return 0;
        }
        return c16.getWidth();
    }

    private final Context p() {
        Context context = this.replaceableContext;
        return context != null ? context : this.provider.Q3();
    }

    private final boolean s() {
        Bundle bundle;
        Bundle bundle2 = this.arguments;
        return (bundle2 == null || (bundle = bundle2.getBundle("launchKuiklyParams")) == null || true != bundle.getBoolean("is_cover_split_page", false)) ? false : true;
    }

    private final boolean t() {
        Bundle bundle;
        Bundle bundle2 = this.arguments;
        return (bundle2 == null || (bundle = bundle2.getBundle("launchKuiklyParams")) == null || true != bundle.getBoolean("is_load_on_split_mode", false)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean u() {
        Activity f16;
        boolean startsWith$default;
        boolean z16;
        boolean startsWith$default2;
        boolean startsWith$default3;
        Object obj = this.params.get(KuiklyLaunchParams.PARAM_ERROR_URL);
        String str = obj instanceof String ? (String) obj : null;
        QLog.d("QQKuiklyPageController", 1, "jumpErrorUrl errorUrl:" + str + ", isErrorUrlJumped:" + this.isErrorUrlJumped);
        if ((str == null || str.length() == 0) || this.isErrorUrlJumped || (f16 = f()) == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "https://", false, 2, null);
            if (!startsWith$default3) {
                z16 = false;
                if (z16) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "mqqapi://", false, 2, null);
                    if (startsWith$default2) {
                        Intent intent = new Intent(f16, (Class<?>) JumpActivity.class);
                        intent.setData(Uri.parse(str));
                        f16.startActivity(intent);
                        this.isErrorUrlJumped = true;
                        return true;
                    }
                    return false;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("url", str);
                RouteUtils.startActivity(f16, intent2, RouterConstants.UI_ROUTE_BROWSER);
                this.isErrorUrlJumped = true;
                return true;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    public final void A() {
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            qQKuiklyRenderView.onDetach();
        }
    }

    public final boolean B(boolean isSucceed, ErrorReason r36, KuiklyRenderCoreExecuteMode executeMode, boolean needFinishCurrentActivity) {
        Activity eh5;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.d("QQKuiklyPageController", 1, "onPageLoadComplete, isSucceed:" + isSucceed);
        this.pageOpenSuccess = isSucceed;
        if (isSucceed || !u()) {
            return false;
        }
        if (!needFinishCurrentActivity || (eh5 = this.provider.eh()) == null) {
            return true;
        }
        eh5.finish();
        return true;
    }

    public final void D() {
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            qQKuiklyRenderView.onPause();
        }
    }

    public final void F() {
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            qQKuiklyRenderView.onResume();
        }
    }

    public final void G(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Context Q3 = this.provider.Q3();
        if (Q3 == null) {
            return;
        }
        Context context = this.replaceableContext;
        e eVar = context instanceof e ? (e) context : null;
        if (eVar != null) {
            eVar.a(Q3);
        }
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            qQKuiklyRenderView.o0(Q3);
        }
        QQKuiklyRenderView qQKuiklyRenderView2 = this.kuiklyRenderView;
        if (qQKuiklyRenderView2 != null) {
            qQKuiklyRenderView2.setQQKuiklyRenderViewDelegate(delegate);
        }
        this.delegate = delegate;
    }

    public final void H(QQKuiklyRenderView newKuiklyView) {
        this.kuiklyRenderView = newKuiklyView;
    }

    public final void I() {
        Iterator<T> it = this.asyncLoaderResultTaskTypes.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            if (intValue == 1) {
                QLog.i("QQKuiklyPageController", 1, "[runAsyncLoaderPendingTask]: run first screen ui");
                QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
                if (qQKuiklyRenderView != null) {
                    qQKuiklyRenderView.n0();
                }
            } else if (intValue == 2) {
                QLog.i("QQKuiklyPageController", 1, "[runAsyncLoaderPendingTask]: show error ui");
                M(this, false, 1, null);
            } else if (intValue == 3) {
                QLog.i("QQKuiklyPageController", 1, "[runAsyncLoaderPendingTask]: show error ui");
                O();
            } else if (intValue == 4) {
                QLog.i("QQKuiklyPageController", 1, "[runAsyncLoaderPendingTask]: first screen timeout");
                QQKuiklyRenderView qQKuiklyRenderView2 = this.kuiklyRenderView;
                if (qQKuiklyRenderView2 != null) {
                    qQKuiklyRenderView2.n0();
                }
            }
        }
        this.asyncLoaderResultTaskTypes.clear();
    }

    public final void J() {
        String str;
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView == null || this.rootContainer == null) {
            return;
        }
        Intrinsics.checkNotNull(qQKuiklyRenderView);
        ViewGroup.LayoutParams layoutParams = qQKuiklyRenderView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int j3 = j(this.bundleName, this.pagerName);
        if (t() && bz.l()) {
            if (this.maxWidthOnSplitMode <= 0) {
                this.maxWidthOnSplitMode = o();
            }
            int i3 = this.maxWidthOnSplitMode;
            int i16 = i3 > 0 ? i3 : 0;
            QLog.d("QQKuiklyPageController", 1, "setMaxWidthIfNeed function zone width:" + i3);
            j3 = i16;
        }
        int coerceAtMost = j3 > 0 ? RangesKt___RangesKt.coerceAtMost(j3, com.tencent.mobileqq.qqecommerce.biz.kuikly.utils.a.INSTANCE.b()) : -1;
        QLog.d("QQKuiklyPageController", 1, "setMaxWidthIfNeed maxWidthPx:" + j3 + " realWidth:" + coerceAtMost + " renderViewParams.width=" + layoutParams2.width);
        if (layoutParams2.width == coerceAtMost) {
            return;
        }
        FrameLayout frameLayout = this.rootContainer;
        Intrinsics.checkNotNull(frameLayout);
        ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams3).gravity = 1;
        if (!t() || !s()) {
            FrameLayout frameLayout2 = this.rootContainer;
            Intrinsics.checkNotNull(frameLayout2);
            if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                str = "#FF1A1A1A";
            } else {
                str = "#FFFFFFFF";
            }
            frameLayout2.setBackgroundColor(Color.parseColor(str));
        }
        layoutParams2.gravity = 1;
        layoutParams2.width = coerceAtMost;
        QQKuiklyRenderView qQKuiklyRenderView2 = this.kuiklyRenderView;
        Intrinsics.checkNotNull(qQKuiklyRenderView2);
        qQKuiklyRenderView2.setLayoutParams(layoutParams2);
    }

    public final void K(h hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.provider = hVar;
    }

    public final boolean L(boolean needFinishCurrentActivity) {
        String str;
        Activity eh5;
        if (u()) {
            if (!needFinishCurrentActivity || (eh5 = this.provider.eh()) == null) {
                return true;
            }
            eh5.finish();
            return true;
        }
        View view = this.errorViewContainer;
        if (view == null) {
            view = i().inflate(R.layout.cvt, (ViewGroup) this.rootContainer, false);
            this.errorViewContainer = view;
            FrameLayout frameLayout = this.rootContainer;
            if (frameLayout != null) {
                frameLayout.addView(view);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    g.N(g.this, view2);
                }
            });
            TextView textView = (TextView) view.findViewById(R.id.ogf);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R\u2026d.kuikly_error_text_view)");
                if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                    str = "#FFFFFFFF";
                } else {
                    str = "#FF000000";
                }
                textView.setTextColor(Color.parseColor(str));
            }
        }
        view.setVisibility(0);
        return false;
    }

    public final void O() {
        View view = this.loadingViewContainer;
        if (view == null) {
            view = i().inflate(R.layout.cvu, (ViewGroup) this.rootContainer, false);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
            this.loadingViewContainer = (LinearLayout) view;
            this.loadingImageView = (ImageView) view.findViewById(R.id.ogh);
            FrameLayout frameLayout = this.rootContainer;
            if (frameLayout != null) {
                frameLayout.addView(this.loadingViewContainer);
            }
        }
        view.setVisibility(0);
        ImageView imageView = this.loadingImageView;
        if (imageView != null) {
            P(imageView);
        }
    }

    public final void c(int type) {
        this.asyncLoaderResultTaskTypes.add(Integer.valueOf(type));
    }

    public final String h() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.i launchPerformance;
        String a16;
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        return (qQKuiklyRenderView == null || (launchPerformance = qQKuiklyRenderView.getLaunchPerformance()) == null || (a16 = launchPerformance.a()) == null) ? "{}" : a16;
    }

    public final Map<String, Object> k() {
        Map<String, Object> emptyMap;
        Map<String, Object> O;
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null && (O = qQKuiklyRenderView.O()) != null) {
            return O;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    /* renamed from: m, reason: from getter */
    public final String getPagerName() {
        return this.pagerName;
    }

    /* renamed from: n, reason: from getter */
    public final FrameLayout getRootContainer() {
        return this.rootContainer;
    }

    public final void q() {
        View view = this.errorViewContainer;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public final void r() {
        LinearLayout linearLayout = this.loadingViewContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ImageView imageView = this.loadingImageView;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public final void v(int requestCode, int r36, Intent data) {
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            qQKuiklyRenderView.onActivityResult(requestCode, r36, data);
        }
    }

    public final boolean w() {
        Map<String, ? extends Object> emptyMap;
        if (!this.supportCustomBackPressed && (!this.modalMode || this.kuiklyRenderView == null || !this.pageOpenSuccess)) {
            return false;
        }
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            qQKuiklyRenderView.sentEvent("onModalModeBackPressed", emptyMap);
        }
        return true;
    }

    public final void x(Bundle bundle) {
        this.params.clear();
        this.params.putAll(d());
        this.bundleName = g(this.params);
        this.pagerName = l(this.params);
        if (tf2.a.a(this.arguments)) {
            this.modalMode = true;
        }
        if (this.params.containsKey(KuiklyLaunchParams.PARAM_CUSTOM_BACK_PRESSED)) {
            this.supportCustomBackPressed = true;
        }
    }

    public final View y(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate, Bundle r56, Size size) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Context p16 = p();
        if (p16 == null) {
            return null;
        }
        FrameLayout frameLayout2 = new FrameLayout(p16);
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.rootContainer = frameLayout2;
        this.kuiklyRenderView = e(p16, delegate, size);
        J();
        FrameLayout frameLayout3 = this.rootContainer;
        if (frameLayout3 != null) {
            frameLayout3.addView(this.kuiklyRenderView, 0);
        }
        if (t() && (frameLayout = this.rootContainer) != null) {
            frameLayout.setClickable(true);
        }
        return this.rootContainer;
    }

    public final void E() {
        Map<String, ? extends Object> mapOf;
        boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
        QQKuiklyRenderView qQKuiklyRenderView = this.kuiklyRenderView;
        if (qQKuiklyRenderView != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(MiniGamePAHippyBaseFragment.KEY_THEME, Integer.valueOf(isNowThemeIsNight ? 1 : 0)));
            qQKuiklyRenderView.sentEvent(Pager.PAGER_EVENT_THEME_DID_CHANGED, mapOf);
        }
    }

    public static /* synthetic */ boolean C(g gVar, boolean z16, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode, boolean z17, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        return gVar.B(z16, errorReason, kuiklyRenderCoreExecuteMode, z17);
    }

    public static /* synthetic */ boolean M(g gVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return gVar.L(z16);
    }

    public static /* synthetic */ View z(g gVar, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar, Bundle bundle, Size size, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            size = null;
        }
        return gVar.y(hVar, bundle, size);
    }

    public /* synthetic */ g(Bundle bundle, boolean z16, h hVar, Context context, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bundle, z16, hVar, (i3 & 8) != 0 ? null : context);
    }
}
