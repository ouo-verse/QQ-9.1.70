package com.tencent.mobileqq.activity.aio.intimate.qui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.header.g;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import he0.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 {2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003|}~B\u0011\b\u0016\u0012\u0006\u0010s\u001a\u00020r\u00a2\u0006\u0004\bt\u0010uB\u001b\b\u0016\u0012\u0006\u0010s\u001a\u00020r\u0012\b\u0010w\u001a\u0004\u0018\u00010v\u00a2\u0006\u0004\bt\u0010xB#\b\u0017\u0012\u0006\u0010s\u001a\u00020r\u0012\b\u0010w\u001a\u0004\u0018\u00010v\u0012\u0006\u0010y\u001a\u00020\u0006\u00a2\u0006\u0004\bt\u0010zJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0003J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0002J8\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0003J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u001aH\u0002J.\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00142\u0006\u0010)\u001a\u00020(JN\u00100\u001a\u00020\u00002\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020+0\u000fj\b\u0012\u0004\u0012\u00020+`\u00112\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020+0\u000fj\b\u0012\u0004\u0012\u00020+`\u00112\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020.0\u000fj\b\u0012\u0004\u0012\u00020.`\u0011J\u0010\u00103\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u000101J\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011J\u0012\u00105\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u00108\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u0010\u0010:\u001a\u00020\u00142\u0006\u00109\u001a\u000206H\u0016J\u0006\u0010;\u001a\u00020\u0004R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R&\u0010B\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR&\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010AR$\u0010I\u001a\u0012\u0012\u0004\u0012\u00020.0\u000fj\b\u0012\u0004\u0012\u00020.`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010AR$\u0010J\u001a\u0012\u0012\u0004\u0012\u00020+0\u000fj\b\u0012\u0004\u0012\u00020+`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010AR$\u0010K\u001a\u0012\u0012\u0004\u0012\u00020+0\u000fj\b\u0012\u0004\u0012\u00020+`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010AR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010OR\u0018\u0010S\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\"\u0010[\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010U\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010UR\u0016\u0010^\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010QR\u0016\u0010b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010QR\u0016\u0010d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010]R\u0016\u0010f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010QR\u0016\u0010i\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0016\u0010m\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010]R\u0016\u0010o\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010QR\u0016\u0010q\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010Q\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "", "r", "", "type", "l", "cardResId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "t", "position", "D", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "driverCards", "drivenCard", "", "isExitMode", "k", "y", "u", "view", "", "rate", "B", BdhLogUtil.LogTag.Tag_Conn, "E", "v", "offsetX", "p", "o", com.tencent.luggage.wxa.c8.c.f123400v, "w", "cardCount", "lastStayType", "isCirculate", "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$a;", "processor", HippyTKDListViewAdapter.X, "", "tabUnSelectedUrlList", "tabSelectedUrlList", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "modelList", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$c;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, NodeProps.ON_CLICK, "Landroid/view/MotionEvent;", "event", "onTouch", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "j", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "stackViews", "e", "Ljava/util/ArrayList;", "cardViewList", "f", "Landroid/widget/LinearLayout;", "mTabListView", h.F, "mTabViewList", "i", "mModelList", "mUnSelectedIconUrlList", "mSelectedIconUrlList", "Lcom/tencent/aio/frame/api/a;", "Lcom/tencent/aio/frame/api/a;", "drawerFrameHelper", "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$a;", "alphaCardProcessor", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$c;", "onTabChangeListener", "G", "I", "H", DomainData.DOMAIN_NAME, "()I", "setCurrentCardPosition", "(I)V", "currentCardPosition", "J", "Z", "animationLock", "K", "touchDownX", "L", "touchOffsetX", "M", "touchCurrentIsExit", "N", "touchCurrentMoveRatio", "P", "Landroid/view/View;", "touchDriverView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "touchDrivenView", BdhLogUtil.LogTag.Tag_Req, "isCirculateStack", ExifInterface.LATITUDE_SOUTH, "monitorDownX", "T", "monitorDownY", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "U", "a", "b", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QUICardStackView extends LinearLayout implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<String> mSelectedIconUrlList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.frame.api.a drawerFrameHelper;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private a alphaCardProcessor;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private c onTabChangeListener;

    /* renamed from: G, reason: from kotlin metadata */
    private int lastStayType;

    /* renamed from: H, reason: from kotlin metadata */
    private int currentCardPosition;

    /* renamed from: I, reason: from kotlin metadata */
    private int cardCount;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean animationLock;

    /* renamed from: K, reason: from kotlin metadata */
    private float touchDownX;

    /* renamed from: L, reason: from kotlin metadata */
    private float touchOffsetX;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean touchCurrentIsExit;

    /* renamed from: N, reason: from kotlin metadata */
    private float touchCurrentMoveRatio;

    /* renamed from: P, reason: from kotlin metadata */
    private View touchDriverView;

    /* renamed from: Q, reason: from kotlin metadata */
    private View touchDrivenView;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean isCirculateStack;

    /* renamed from: S, reason: from kotlin metadata */
    private float monitorDownX;

    /* renamed from: T, reason: from kotlin metadata */
    private float monitorDownY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RelativeLayout stackViews;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<View> cardViewList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mTabListView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<View> mTabViewList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<g> mModelList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> mUnSelectedIconUrlList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$a;", "", "Landroid/view/View;", "view", "", com.tencent.luggage.wxa.c8.c.f123400v, "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface a {
        void a(@NotNull View view, float alpha);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$b;", "", "", "count", "", "b", "", "TAG", "Ljava/lang/String;", "hiddenCardAlpha", UserInfo.SEX_FEMALE, "monitorMoveThreshold", "touchMaxOffset", "touchThreshold", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.aio.intimate.qui.QUICardStackView$b, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b(int count) {
            if (count > 1) {
                return 175.0f;
            }
            return 165.0f;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$c;", "", "", "position", "", "onChanged", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface c {
        void onChanged(int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$e", "Landroid/view/animation/TranslateAnimation;", "", "ratio", "Landroid/view/animation/Transformation;", "transformation", "", "applyTransformation", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e extends TranslateAnimation {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f179165d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f179166e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QUICardStackView f179167f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f179168h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(boolean z16, float f16, QUICardStackView qUICardStackView, View view, float f17) {
            super(0.0f, f17, 0.0f, 0.0f);
            this.f179165d = z16;
            this.f179166e = f16;
            this.f179167f = qUICardStackView;
            this.f179168h = view;
        }

        @Override // android.view.animation.TranslateAnimation, android.view.animation.Animation
        protected void applyTransformation(float ratio, @NotNull Transformation transformation) {
            float f16;
            Intrinsics.checkNotNullParameter(transformation, "transformation");
            super.applyTransformation(ratio, transformation);
            if (this.f179165d) {
                float f17 = this.f179166e;
                f16 = f17 + ((1 - f17) * ratio);
            } else {
                float f18 = this.f179166e;
                f16 = f18 - (ratio * f18);
            }
            this.f179167f.B(this.f179168h, f16);
            int indexOf = this.f179167f.cardViewList.indexOf(this.f179168h) + 1;
            if (indexOf < this.f179167f.cardViewList.size()) {
                QUICardStackView qUICardStackView = this.f179167f;
                Object obj = qUICardStackView.cardViewList.get(indexOf);
                Intrinsics.checkNotNullExpressionValue(obj, "cardViewList[indexBehindDriven]");
                qUICardStackView.w((View) obj, f16 * 0.4f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QUICardStackView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(View view, float rate) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = (int) (getResources().getDimensionPixelSize(R.dimen.f158703ms) * rate);
        float f16 = 1 - rate;
        layoutParams2.leftMargin = (int) (getResources().getDimensionPixelSize(R.dimen.c9y) * f16);
        layoutParams2.rightMargin = (int) (getResources().getDimensionPixelSize(R.dimen.c9y) * f16);
        view.setLayoutParams(layoutParams2);
        w(view, (rate * 0.6f) + 0.4f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(View view, float rate) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.f158703ms);
        int i3 = -((int) (x.f(getContext()).b() * rate));
        layoutParams2.leftMargin = i3;
        layoutParams2.rightMargin = -i3;
        view.setLayoutParams(layoutParams2);
        w(view, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(int position) {
        View view;
        View view2;
        if (position >= 0 && position < this.cardViewList.size() && !this.animationLock) {
            ViewGroup.LayoutParams layoutParams = this.cardViewList.get(this.currentCardPosition).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            if (((RelativeLayout.LayoutParams) layoutParams).leftMargin == 0 && position == this.currentCardPosition) {
                return;
            }
            this.animationLock = true;
            ArrayList<View> arrayList = new ArrayList<>();
            int i3 = this.currentCardPosition;
            boolean z16 = false;
            if (position == i3) {
                if (this.touchCurrentIsExit) {
                    view = this.touchDrivenView;
                    View view3 = null;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("touchDrivenView");
                        view = null;
                    }
                    view2 = this.touchDriverView;
                    if (view2 != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("touchDriverView");
                    } else {
                        view3 = view2;
                    }
                    arrayList.add(view3);
                } else {
                    view = this.touchDrivenView;
                    View view32 = null;
                    if (view == null) {
                    }
                    view2 = this.touchDriverView;
                    if (view2 != null) {
                    }
                    arrayList.add(view32);
                }
            } else if (position < i3) {
                View view4 = this.cardViewList.get(i3);
                Intrinsics.checkNotNullExpressionValue(view4, "cardViewList[currentCardPosition]");
                view = view4;
                w(view, 0.4f);
                int i16 = this.currentCardPosition;
                for (int i17 = position; i17 < i16; i17++) {
                    arrayList.add(this.cardViewList.get(i17));
                }
            } else {
                View view5 = this.cardViewList.get(position);
                Intrinsics.checkNotNullExpressionValue(view5, "cardViewList[position]");
                view = view5;
                w(view, 1.0f);
                for (int i18 = this.currentCardPosition; i18 < position; i18++) {
                    arrayList.add(this.cardViewList.get(i18));
                }
                z16 = true;
            }
            int size = this.cardViewList.size();
            for (int indexOf = this.cardViewList.indexOf(view) + 1; indexOf < size; indexOf++) {
                View view6 = this.cardViewList.get(indexOf);
                Intrinsics.checkNotNullExpressionValue(view6, "cardViewList[i]");
                w(view6, 0.0f);
            }
            k(position, arrayList, view, z16);
            E(position);
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void E(int position) {
        Integer num;
        int i3;
        int i16;
        int i17;
        int type;
        int level;
        Drawable drawable;
        Drawable drawable2;
        if (this.isCirculateStack) {
            if (position < 1) {
                position = this.cardCount;
            } else if (position > this.cardCount) {
                position = 1;
            }
        }
        Iterator<View> it = this.mTabViewList.iterator();
        while (it.hasNext()) {
            View next = it.next();
            Object tag = next.getTag();
            if (tag instanceof Integer) {
                num = (Integer) tag;
            } else {
                num = null;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            View behindView = next.findViewById(R.id.xqb);
            if (QQTheme.isVasTheme()) {
                i16 = R.drawable.jub;
            } else {
                i16 = R.drawable.jua;
            }
            View findViewById = next.findViewById(R.id.xqa);
            Intrinsics.checkNotNullExpressionValue(findViewById, "tab.findViewById(R.id.intimate_header_tab_bg)");
            ImageView imageView = (ImageView) findViewById;
            View findViewById2 = next.findViewById(R.id.xqc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "tab.findViewById(R.id.intimate_header_tab_icon)");
            ImageView imageView2 = (ImageView) findViewById2;
            if (this.isCirculateStack) {
                i17 = i3 - 1;
            } else {
                i17 = i3;
            }
            if (i17 >= this.mModelList.size()) {
                type = 0;
            } else {
                type = this.mModelList.get(i17).getType();
            }
            if (i17 >= this.mModelList.size()) {
                level = 0;
            } else {
                level = this.mModelList.get(i17).getLevel();
            }
            String str = "";
            if (position == i3) {
                imageView.setBackgroundResource(0);
                IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
                int G = intimateHeaderCardUtil.G(type);
                if (G != 0) {
                    i16 = G;
                }
                Intrinsics.checkNotNullExpressionValue(behindView, "behindView");
                IntimateHeaderCardUtil.X(behindView, IntimateHeaderCardUtil.y(type), getResources().getDrawable(i16));
                if (i17 < this.mSelectedIconUrlList.size()) {
                    String str2 = this.mSelectedIconUrlList.get(i17);
                    Intrinsics.checkNotNullExpressionValue(str2, "mSelectedIconUrlList[typeIdx]");
                    str = str2;
                }
                int x16 = intimateHeaderCardUtil.x(type);
                if (x16 == 0) {
                    drawable = new ColorDrawable(0);
                } else {
                    drawable = getResources().getDrawable(x16);
                }
                IntimateHeaderCardUtil.X(imageView2, str, drawable);
            } else {
                imageView.setBackgroundResource(R.drawable.juc);
                behindView.setBackgroundResource(i16);
                if (i17 < this.mUnSelectedIconUrlList.size()) {
                    String str3 = this.mUnSelectedIconUrlList.get(i17);
                    Intrinsics.checkNotNullExpressionValue(str3, "mUnSelectedIconUrlList[typeIdx]");
                    str = str3;
                }
                int F = IntimateHeaderCardUtil.f178990a.F(type, level);
                if (F == 0) {
                    drawable2 = new ColorDrawable(0);
                } else {
                    drawable2 = getResources().getDrawable(F);
                }
                IntimateHeaderCardUtil.X(imageView2, str, drawable2);
            }
        }
    }

    private final void k(int position, ArrayList<View> driverCards, View drivenCard, boolean isExitMode) {
        float f16;
        View view = driverCards.get(0);
        Intrinsics.checkNotNullExpressionValue(view, "driverCards[0]");
        View view2 = view;
        driverCards.remove(0);
        w(view2, 1.0f);
        Iterator<T> it = driverCards.iterator();
        while (it.hasNext()) {
            w((View) it.next(), 0.0f);
        }
        float b16 = x.f(getContext()).b();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        float abs = Math.abs(((RelativeLayout.LayoutParams) layoutParams).leftMargin);
        if (isExitMode) {
            f16 = b16 - abs;
        } else {
            f16 = abs;
        }
        float f17 = abs / b16;
        if (isExitMode) {
            f16 = -f16;
        }
        e eVar = new e(isExitMode, f17, this, drivenCard, f16);
        eVar.setAnimationListener(new d(position, this, view2, isExitMode, driverCards));
        b.m(eVar, R.anim.f154978ul, 1.5f);
        view2.startAnimation(eVar);
    }

    private final int l(int type) {
        Iterator<g> it = this.mModelList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            if (it.next().getType() == type) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    private final void o() {
        boolean z16;
        int i3;
        int i16 = 0;
        if (this.touchOffsetX == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (this.touchCurrentIsExit) {
            if (this.touchCurrentMoveRatio > 0.15f) {
                i3 = this.currentCardPosition + 1;
            } else {
                i3 = this.currentCardPosition;
            }
        } else if (this.touchCurrentMoveRatio <= 0.85f) {
            i3 = this.currentCardPosition - 1;
        } else {
            i3 = this.currentCardPosition;
        }
        if (i3 >= 0) {
            i16 = i3;
        }
        D(i16);
    }

    private final void p(float offsetX) {
        boolean z16;
        int i3;
        int i16;
        float f16;
        if (offsetX == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (this.touchCurrentIsExit) {
            i3 = this.currentCardPosition;
        } else {
            i3 = this.currentCardPosition - 1;
        }
        if (i3 >= 0 && i3 < this.cardViewList.size()) {
            if (this.touchCurrentIsExit) {
                i16 = this.currentCardPosition + 1;
            } else {
                i16 = this.currentCardPosition;
            }
            if (i16 >= 0 && i16 < this.cardViewList.size()) {
                View view = this.cardViewList.get(i3);
                Intrinsics.checkNotNullExpressionValue(view, "cardViewList[driverPosition]");
                this.touchDriverView = view;
                View view2 = this.cardViewList.get(i16);
                Intrinsics.checkNotNullExpressionValue(view2, "cardViewList[drivenPosition]");
                this.touchDrivenView = view2;
                if (this.touchCurrentIsExit) {
                    f16 = 1 - ((offsetX + 750.0f) / 750.0f);
                } else {
                    f16 = (750.0f - offsetX) / 750.0f;
                }
                this.touchCurrentMoveRatio = f16;
                View view3 = this.touchDriverView;
                View view4 = null;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("touchDriverView");
                    view3 = null;
                }
                C(view3, this.touchCurrentMoveRatio);
                View view5 = this.touchDrivenView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("touchDrivenView");
                } else {
                    view4 = view5;
                }
                B(view4, this.touchCurrentMoveRatio);
                int i17 = i16 + 1;
                if (i17 < this.cardViewList.size()) {
                    View view6 = this.cardViewList.get(i17);
                    Intrinsics.checkNotNullExpressionValue(view6, "cardViewList[indexBehindDriven]");
                    w(view6, this.touchCurrentMoveRatio * 0.4f);
                }
            }
        }
    }

    private final void q(int cardResId) {
        View inflate = LayoutInflater.from(getContext()).inflate(cardResId, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(INSTANCE.b(this.cardCount), getResources()));
        layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.f158703ms);
        this.stackViews.addView(inflate, layoutParams);
        this.cardViewList.add(inflate);
    }

    private final void r() {
        int l3 = l(this.lastStayType);
        if (l3 < 0) {
            return;
        }
        if (this.isCirculateStack) {
            l3++;
        }
        this.currentCardPosition = l3;
        y();
    }

    private final void s(int cardResId) {
        int i3 = this.isCirculateStack ? this.cardCount + 1 : this.cardCount - 1;
        for (int i16 = 0; i16 < i3; i16++) {
            View defaultCardView = LayoutInflater.from(getContext()).inflate(cardResId, (ViewGroup) null);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(INSTANCE.b(this.cardCount), getResources()));
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.c9y);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.c9y);
            if (i16 < i3 - 1) {
                Intrinsics.checkNotNullExpressionValue(defaultCardView, "defaultCardView");
                w(defaultCardView, 0.0f);
            } else {
                Intrinsics.checkNotNullExpressionValue(defaultCardView, "defaultCardView");
                w(defaultCardView, 0.4f);
            }
            this.stackViews.addView(defaultCardView, layoutParams);
            this.cardViewList.add(defaultCardView);
        }
        q(cardResId);
        View inflate = LayoutInflater.from(getContext()).inflate(cardResId, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(INSTANCE.b(this.cardCount), getResources()));
        int i17 = -x.f(getContext()).b();
        layoutParams2.leftMargin = i17;
        layoutParams2.rightMargin = -i17;
        layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.f158703ms);
        this.stackViews.addView(inflate, layoutParams2);
        this.cardViewList.add(inflate);
        this.currentCardPosition = this.isCirculateStack ? 1 : 0;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void t() {
        int i3;
        int type;
        int level;
        Drawable drawable;
        int i16;
        int type2;
        Drawable drawable2;
        this.mTabListView.removeAllViews();
        int size = this.mModelList.size();
        for (int i17 = 0; i17 < size; i17++) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fcq, (ViewGroup) null);
            View behindView = inflate.findViewById(R.id.xqb);
            View findViewById = inflate.findViewById(R.id.xqa);
            Intrinsics.checkNotNullExpressionValue(findViewById, "tabView.findViewById(R.id.intimate_header_tab_bg)");
            ImageView imageView = (ImageView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.xqc);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "tabView.findViewById(R.i\u2026intimate_header_tab_icon)");
            ImageView imageView2 = (ImageView) findViewById2;
            if (QQTheme.isVasTheme()) {
                i3 = R.drawable.jub;
            } else {
                i3 = R.drawable.jua;
            }
            String str = "";
            if (i17 == (this.isCirculateStack ? this.currentCardPosition - 1 : this.currentCardPosition)) {
                imageView.setBackgroundResource(0);
                if (i17 >= this.mModelList.size()) {
                    type2 = 0;
                } else {
                    type2 = this.mModelList.get(i17).getType();
                }
                IntimateHeaderCardUtil intimateHeaderCardUtil = IntimateHeaderCardUtil.f178990a;
                int G = intimateHeaderCardUtil.G(type2);
                if (G != 0) {
                    i3 = G;
                }
                Intrinsics.checkNotNullExpressionValue(behindView, "behindView");
                IntimateHeaderCardUtil.X(behindView, IntimateHeaderCardUtil.y(type2), getResources().getDrawable(i3));
                if (i17 < this.mSelectedIconUrlList.size()) {
                    String str2 = this.mSelectedIconUrlList.get(i17);
                    Intrinsics.checkNotNullExpressionValue(str2, "mSelectedIconUrlList[i]");
                    str = str2;
                }
                int x16 = intimateHeaderCardUtil.x(type2);
                if (x16 == 0) {
                    drawable2 = new ColorDrawable(0);
                } else {
                    drawable2 = getResources().getDrawable(x16);
                }
                IntimateHeaderCardUtil.X(imageView2, str, drawable2);
            } else {
                imageView.setBackgroundResource(R.drawable.juc);
                behindView.setBackgroundResource(i3);
                if (i17 < this.mUnSelectedIconUrlList.size()) {
                    String str3 = this.mUnSelectedIconUrlList.get(i17);
                    Intrinsics.checkNotNullExpressionValue(str3, "mUnSelectedIconUrlList[i]");
                    str = str3;
                }
                if (i17 >= this.mModelList.size()) {
                    type = 0;
                } else {
                    type = this.mModelList.get(i17).getType();
                }
                if (i17 >= this.mModelList.size()) {
                    level = 0;
                } else {
                    level = this.mModelList.get(i17).getLevel();
                }
                int F = IntimateHeaderCardUtil.f178990a.F(type, level);
                if (F == 0) {
                    drawable = new ColorDrawable(0);
                } else {
                    drawable = getResources().getDrawable(F);
                }
                IntimateHeaderCardUtil.X(imageView2, str, drawable);
            }
            inflate.setOnClickListener(this);
            if (this.isCirculateStack) {
                i16 = i17 + 1;
            } else {
                i16 = i17;
            }
            inflate.setTag(Integer.valueOf(i16));
            this.mTabListView.addView(inflate, new LinearLayout.LayoutParams(BaseAIOUtils.f(70.0f, getResources()), -2));
            this.mTabViewList.add(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        if (!this.isCirculateStack) {
            return;
        }
        int i3 = this.currentCardPosition;
        int i16 = 2;
        int i17 = 0;
        if (i3 == 0) {
            int size = this.cardViewList.size() - 3;
            for (int i18 = 0; i18 < size; i18++) {
                View view = this.cardViewList.get(i18);
                Intrinsics.checkNotNullExpressionValue(view, "cardViewList[i]");
                C(view, 1.0f);
            }
            if (this.cardViewList.size() - 3 >= 0) {
                View view2 = this.cardViewList.get(r0.size() - 3);
                Intrinsics.checkNotNullExpressionValue(view2, "cardViewList[cardViewList.size - 3]");
                B(view2, 1.0f);
            }
            int size2 = this.cardViewList.size() - 2;
            int size3 = this.cardViewList.size();
            while (size2 < size3) {
                int i19 = i17 + 1;
                View view3 = this.cardViewList.get(size2);
                Intrinsics.checkNotNullExpressionValue(view3, "cardViewList[i]");
                B(view3, 0.0f);
                if (i17 > 0) {
                    this.cardViewList.get(size2).setAlpha(0.0f);
                }
                size2++;
                i17 = i19;
            }
            this.currentCardPosition = this.cardViewList.size() - 3;
            return;
        }
        if (i3 > this.cardCount) {
            if (this.cardViewList.size() > 0) {
                View view4 = this.cardViewList.get(0);
                Intrinsics.checkNotNullExpressionValue(view4, "cardViewList[0]");
                C(view4, 1.0f);
            }
            if (this.cardViewList.size() > 1) {
                View view5 = this.cardViewList.get(1);
                Intrinsics.checkNotNullExpressionValue(view5, "cardViewList[1]");
                B(view5, 1.0f);
            }
            int size4 = this.cardViewList.size();
            while (i16 < size4) {
                int i26 = i17 + 1;
                View view6 = this.cardViewList.get(i16);
                Intrinsics.checkNotNullExpressionValue(view6, "cardViewList[i]");
                B(view6, 0.0f);
                if (i17 > 0) {
                    this.cardViewList.get(i16).setAlpha(0.0f);
                }
                i16++;
                i17 = i26;
            }
            this.currentCardPosition = 1;
        }
    }

    private final void v() {
        this.touchDownX = 0.0f;
        this.touchOffsetX = 0.0f;
        this.touchCurrentMoveRatio = 0.0f;
        this.touchCurrentIsExit = true;
        this.monitorDownX = 0.0f;
        this.monitorDownY = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(View view, float alpha) {
        a aVar = this.alphaCardProcessor;
        if (aVar != null) {
            if (aVar != null) {
                aVar.a(view, alpha);
                return;
            }
            return;
        }
        view.setAlpha(alpha);
    }

    private final void y() {
        int i3 = this.currentCardPosition;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            if (i17 < this.cardViewList.size()) {
                View view = this.cardViewList.get(i17);
                Intrinsics.checkNotNullExpressionValue(view, "cardViewList[i]");
                C(view, 1.0f);
            }
        }
        if (this.currentCardPosition < this.cardViewList.size()) {
            View view2 = this.cardViewList.get(this.currentCardPosition);
            Intrinsics.checkNotNullExpressionValue(view2, "cardViewList[currentCardPosition]");
            B(view2, 1.0f);
        }
        int size = this.cardViewList.size() - 2;
        int size2 = this.cardViewList.size();
        while (size < size2) {
            int i18 = i16 + 1;
            View view3 = this.cardViewList.get(size);
            Intrinsics.checkNotNullExpressionValue(view3, "cardViewList[i]");
            B(view3, 0.0f);
            if (i16 > 0) {
                this.cardViewList.get(size).setAlpha(0.0f);
            }
            size++;
            i16 = i18;
        }
    }

    @NotNull
    public final QUICardStackView A(@NotNull ArrayList<String> tabUnSelectedUrlList, @NotNull ArrayList<String> tabSelectedUrlList, @NotNull ArrayList<g> modelList) {
        Intrinsics.checkNotNullParameter(tabUnSelectedUrlList, "tabUnSelectedUrlList");
        Intrinsics.checkNotNullParameter(tabSelectedUrlList, "tabSelectedUrlList");
        Intrinsics.checkNotNullParameter(modelList, "modelList");
        this.mModelList.clear();
        this.mModelList.addAll(modelList);
        this.mUnSelectedIconUrlList.clear();
        this.mUnSelectedIconUrlList.addAll(tabUnSelectedUrlList);
        this.mSelectedIconUrlList.clear();
        this.mSelectedIconUrlList.addAll(tabSelectedUrlList);
        r();
        t();
        return this;
    }

    public final void j() {
        this.onTabChangeListener = null;
        this.alphaCardProcessor = null;
        this.drawerFrameHelper = null;
    }

    @NotNull
    public final ArrayList<View> m() {
        return this.cardViewList;
    }

    /* renamed from: n, reason: from getter */
    public final int getCurrentCardPosition() {
        return this.currentCardPosition;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Object obj;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!this.animationLock) {
            Integer num = null;
            if (v3 != null) {
                obj = v3.getTag();
            } else {
                obj = null;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            }
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            D(i3);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        com.tencent.aio.frame.api.a aVar;
        com.tencent.aio.frame.api.b a16;
        com.tencent.aio.frame.api.a aVar2;
        com.tencent.aio.frame.api.b a17;
        com.tencent.aio.frame.api.b a18;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.cardViewList.size() == 1) {
            return super.onInterceptTouchEvent(ev5);
        }
        if (ev5.getAction() == 0) {
            v();
            this.monitorDownX = ev5.getX();
            this.monitorDownY = ev5.getY();
            com.tencent.aio.frame.api.a aVar3 = this.drawerFrameHelper;
            if (aVar3 != null && (a18 = aVar3.a()) != null) {
                a18.requestDisallowInterceptTouchEvent(true);
            }
        }
        if (ev5.getAction() == 1 && (aVar2 = this.drawerFrameHelper) != null && (a17 = aVar2.a()) != null) {
            a17.requestDisallowInterceptTouchEvent(false);
        }
        if (ev5.getAction() == 3 && (aVar = this.drawerFrameHelper) != null && (a16 = aVar.a()) != null) {
            a16.requestDisallowInterceptTouchEvent(false);
        }
        if (ev5.getAction() == 2) {
            float abs = Math.abs(ev5.getX() - this.monitorDownX);
            float abs2 = Math.abs(ev5.getY() - this.monitorDownY);
            if (((float) Math.sqrt((abs * abs) + (abs2 * abs2))) > 30.0f) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (event == null || this.animationLock) {
            return false;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        o();
                        v();
                    }
                } else {
                    if (this.touchDownX == 0.0f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        this.touchDownX = event.getX();
                    }
                    float x16 = event.getX() - this.touchDownX;
                    this.touchOffsetX = x16;
                    if (x16 == 0.0f) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 || Math.abs(x16) > 750.0f) {
                        return false;
                    }
                    if (this.touchOffsetX < 0.0f) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    this.touchCurrentIsExit = z18;
                    ViewGroup.LayoutParams layoutParams = this.cardViewList.get(this.currentCardPosition).getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    if (((RelativeLayout.LayoutParams) layoutParams).leftMargin == 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if ((z19 && this.currentCardPosition == 0 && !this.touchCurrentIsExit) || (z19 && this.currentCardPosition == this.cardViewList.size() - 1 && this.touchCurrentIsExit)) {
                        return false;
                    }
                    p(this.touchOffsetX);
                }
            } else {
                o();
                v();
            }
        } else {
            v();
            this.touchDownX = event.getX();
        }
        return true;
    }

    public final void setCurrentCardPosition(int i3) {
        this.currentCardPosition = i3;
    }

    @NotNull
    public final QUICardStackView x(int cardResId, int cardCount, int lastStayType, boolean isCirculate, @NotNull a processor) {
        int i3;
        Intrinsics.checkNotNullParameter(processor, "processor");
        this.alphaCardProcessor = processor;
        this.cardCount = cardCount;
        this.lastStayType = lastStayType;
        this.isCirculateStack = isCirculate;
        if (cardCount <= 1) {
            q(cardResId);
        } else {
            s(cardResId);
        }
        CollectionsKt___CollectionsJvmKt.reverse(this.cardViewList);
        LinearLayout linearLayout = this.mTabListView;
        if (cardCount > 1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        return this;
    }

    @NotNull
    public final QUICardStackView z(@Nullable c listener) {
        this.onTabChangeListener = listener;
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QUICardStackView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"InflateParams"})
    public QUICardStackView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cardViewList = new ArrayList<>();
        this.mTabViewList = new ArrayList<>();
        this.mModelList = new ArrayList<>();
        this.mUnSelectedIconUrlList = new ArrayList<>();
        this.mSelectedIconUrlList = new ArrayList<>();
        this.drawerFrameHelper = new com.tencent.aio.frame.api.a(this);
        this.cardCount = 1;
        this.touchCurrentIsExit = true;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hfy, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.f658239z);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qui_card_stack_layout)");
        this.stackViews = (RelativeLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f658139y);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026qui_card_bottom_tab_list)");
        this.mTabListView = (LinearLayout) findViewById2;
        addView(inflate, new LinearLayout.LayoutParams(-1, -1));
        setOnTouchListener(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/aio/intimate/qui/QUICardStackView$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationRepeat", "onAnimationEnd", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f179160d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QUICardStackView f179161e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f179162f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f179163h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ ArrayList<View> f179164i;

        d(int i3, QUICardStackView qUICardStackView, View view, boolean z16, ArrayList<View> arrayList) {
            this.f179160d = i3;
            this.f179161e = qUICardStackView;
            this.f179162f = view;
            this.f179163h = z16;
            this.f179164i = arrayList;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            float f16;
            this.f179162f.clearAnimation();
            QUICardStackView qUICardStackView = this.f179161e;
            View view = this.f179162f;
            if (this.f179163h) {
                f16 = 1.0f;
            } else {
                f16 = 0.0f;
            }
            qUICardStackView.C(view, f16);
            ArrayList<View> arrayList = this.f179164i;
            boolean z16 = this.f179163h;
            QUICardStackView qUICardStackView2 = this.f179161e;
            for (View view2 : arrayList) {
                if (z16) {
                    qUICardStackView2.C(view2, 1.0f);
                } else {
                    qUICardStackView2.B(view2, 0.0f);
                }
            }
            if (this.f179160d + 1 < this.f179161e.cardViewList.size()) {
                QUICardStackView qUICardStackView3 = this.f179161e;
                Object obj = qUICardStackView3.cardViewList.get(this.f179160d + 1);
                Intrinsics.checkNotNullExpressionValue(obj, "cardViewList[position + 1]");
                qUICardStackView3.w((View) obj, 0.4f);
            }
            int size = this.f179161e.cardViewList.size();
            for (int i3 = this.f179160d + 2; i3 < size; i3++) {
                QUICardStackView qUICardStackView4 = this.f179161e;
                Object obj2 = qUICardStackView4.cardViewList.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj2, "cardViewList[i]");
                qUICardStackView4.w((View) obj2, 0.0f);
            }
            this.f179161e.setCurrentCardPosition(this.f179160d);
            this.f179161e.u();
            this.f179161e.animationLock = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            int i3 = this.f179160d;
            if (this.f179161e.isCirculateStack) {
                int i16 = this.f179160d;
                if (i16 <= 0) {
                    i16 = this.f179161e.cardCount;
                }
                i3 = i16 - 1;
                if (i3 >= this.f179161e.cardCount) {
                    i3 -= this.f179161e.cardCount;
                }
            }
            c cVar = this.f179161e.onTabChangeListener;
            if (cVar != null) {
                cVar.onChanged(i3);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }
    }
}
