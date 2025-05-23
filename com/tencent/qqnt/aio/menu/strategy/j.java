package com.tencent.qqnt.aio.menu.strategy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.IAIOEmoReplyMenuApi;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.aio.menu.MenuWrapper;
import com.tencent.qqnt.aio.menu.al;
import com.tencent.qqnt.aio.menu.ui.QQCustomMenuExpandableLayout;
import com.tencent.qqnt.aio.menu.ui.QQCustomMenuNoIconLayout;
import com.tencent.qqnt.aio.menu.ui.QQMenuDispatchTouchEventLinearLayout;
import com.tencent.qqnt.aio.menu.w;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.aio.widget.BubblePopupWindow;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 d2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bb\u0010cJ;\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJC\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ0\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002Js\u0010*\u001a\u00020)2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b*\u0010+JV\u00102\u001a\u0004\u0018\u0001012\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u00100\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u001a\u00103\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u00104\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u00106\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010:\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u00022\b\u00108\u001a\u0004\u0018\u0001012\u0006\u00109\u001a\u00020\u0002H\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0002H\u0002J\u0012\u0010=\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u000101H\u0002J\u0010\u0010?\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0002H\u0002J$\u0010@\u001a\u00020\u0002*\u00020)2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020-H\u0002J \u0010D\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020AH\u0016J0\u0010H\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020A2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u0004H\u0016J:\u0010K\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u0004H\u0016Jy\u0010L\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010#\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\bL\u0010MJ\u0014\u0010P\u001a\u00020\u00152\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00150NR\u0016\u0010R\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010QR\u0016\u0010T\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010SR\u0016\u0010U\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010SR\u0016\u0010W\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010]\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010VR\u0018\u0010`\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010Q\u00a8\u0006e"}, d2 = {"Lcom/tencent/qqnt/aio/menu/strategy/j;", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$b;", "Landroid/view/View;", "anchorView", "", "startY", "Landroid/graphics/Rect;", "displayRect", "containerTop", "containerBottom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Landroid/view/View;ILandroid/graphics/Rect;Ljava/lang/Integer;Ljava/lang/Integer;)I", "offsetPadding", "k", "(Landroid/view/View;IILandroid/graphics/Rect;Ljava/lang/Integer;Ljava/lang/Integer;)I", "", "useVisible", "minY", "maxY", "G", "topMargin", "", UserInfo.SEX_FEMALE, "w", "v", "Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;", "popup", "Landroid/content/Context;", "ctx", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", "Lcom/tencent/qqnt/aio/menu/w;", "onMenuActionListener", "ignoreTouchLocation", "source", "showSelectMenu", "Lcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;", "creator", "", "msgUin", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/qqnt/aio/menu/ui/QQCustomMenuExpandableLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;Landroid/content/Context;Lcom/tencent/qqnt/aio/menu/ui/c;Lcom/tencent/qqnt/aio/menu/w;ZLjava/lang/Integer;Landroid/view/View;ZLcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;Ljava/lang/String;I)Lcom/tencent/qqnt/aio/menu/ui/QQCustomMenuExpandableLayout;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "contentMenuLayout", "isSelfMsg", "Landroid/view/ViewGroup;", "p", "o", "y", "", HippyTKDListViewAdapter.X, "archer", "emoReplyLayout", "menuLayout", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "l", "viewGroup", "t", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$c;", "initInfo", "Lcom/tencent/qqnt/aio/menu/MenuWrapper$d;", "d", "Lcom/tencent/qqnt/aio/menu/al;", "selectLocation", "selectMenuBottomPadding", "a", "offsetWidth", "displayWidth", "c", "b", "(Lcom/tencent/qqnt/aio/widget/BubblePopupWindow;Landroid/content/Context;Landroid/view/View;Lcom/tencent/qqnt/aio/menu/ui/c;Lcom/tencent/qqnt/aio/menu/w;ZLjava/lang/Integer;Landroid/view/View;ZLcom/tencent/qqnt/aio/menu/ui/QQCustomMenuNoIconLayout;Ljava/lang/String;I)Landroid/view/View;", "Lkotlin/Function0;", "onAnimationEnd", "B", "Z", "hasEmoMenu", "I", "menuWidth", "menuHeight", "Landroid/view/View;", "menuLayoutWithIndicator", "Landroid/widget/LinearLayout$LayoutParams;", "e", "Landroid/widget/LinearLayout$LayoutParams;", "indicatorLayoutParams", "f", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "g", "Landroid/view/ViewGroup;", "emoMenuLayout", tl.h.F, "<init>", "()V", "i", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class j implements MenuWrapper.b {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    private static final int f351488j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f351489k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f351490l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f351491m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f351492n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean hasEmoMenu;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int menuWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int menuHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View menuLayoutWithIndicator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout.LayoutParams indicatorLayoutParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup emoMenuLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isSelfMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/menu/strategy/j$a;", "", "", "ANIMATION_DURATION", "J", "", "EMO_MENU_MARGIN_ANCHOR", "I", "ICON_MENU_MARGIN_ANCHOR", "MENU_BOTTOM_MARGIN", "MENU_EMO_MARGIN_ICON", "MENU_EMO_REPLY_HEIGHT", "SCALE_DIFF", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.menu.strategy.j$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/menu/strategy/j$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f351501d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f351502e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<List<View>> f351503f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ViewGroup f351504h;

        b(View view, int i3, Ref.ObjectRef<List<View>> objectRef, ViewGroup viewGroup) {
            this.f351501d = view;
            this.f351502e = i3;
            this.f351503f = objectRef;
            this.f351504h = viewGroup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, view, Integer.valueOf(i3), objectRef, viewGroup);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            int lastIndex;
            ViewGroup viewGroup;
            View view;
            ImageView imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            if (QLog.isDevelopLevel() || QQSysFaceSwitcher.f204652a.b()) {
                int i3 = this.f351502e;
                lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.f351503f.element);
                if (i3 == lastIndex) {
                    int childCount = this.f351504h.getChildCount();
                    for (int i16 = 0; i16 < childCount; i16++) {
                        View childAt = this.f351504h.getChildAt(i16);
                        float scaleX = childAt.getScaleX();
                        float scaleY = childAt.getScaleY();
                        int visibility = childAt.getVisibility();
                        Drawable drawable = null;
                        if (childAt instanceof ViewGroup) {
                            viewGroup = (ViewGroup) childAt;
                        } else {
                            viewGroup = null;
                        }
                        if (viewGroup != null) {
                            view = viewGroup.getChildAt(0);
                        } else {
                            view = null;
                        }
                        if (view instanceof ImageView) {
                            imageView = (ImageView) view;
                        } else {
                            imageView = null;
                        }
                        if (imageView != null) {
                            drawable = imageView.getDrawable();
                        }
                        QLog.i("SeparateEmoMenuBubbleSt", 1, "i:" + i16 + ", scaleX:" + scaleX + ", scaleY:" + scaleY + ", visible:" + visibility + ", drawable:" + drawable);
                    }
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                this.f351501d.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/menu/strategy/j$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f351505d;

        c(Function0<Unit> function0) {
            this.f351505d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                this.f351505d.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47701);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        f351488j = l.b(40);
        f351489k = l.b(40);
        f351490l = l.b(48);
        f351491m = l.b(4);
        f351492n = l.b(4);
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void A(View archer, ViewGroup emoReplyLayout, View menuLayout) {
        l(archer);
        t(emoReplyLayout);
        z(menuLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AnimatorSet menuAnimatorSet) {
        Intrinsics.checkNotNullParameter(menuAnimatorSet, "$menuAnimatorSet");
        menuAnimatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(AnimatorSet animatorSet) {
        Intrinsics.checkNotNullParameter(animatorSet, "$animatorSet");
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AnimatorSet emoAnimatorSet) {
        Intrinsics.checkNotNullParameter(emoAnimatorSet, "$emoAnimatorSet");
        emoAnimatorSet.start();
    }

    private final void F(int topMargin) {
        LinearLayout.LayoutParams layoutParams;
        View view = this.menuLayoutWithIndicator;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
            view = null;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof LinearLayout.LayoutParams) {
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.topMargin = topMargin;
            View view3 = this.menuLayoutWithIndicator;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view3 = null;
            }
            view3.setLayoutParams(layoutParams);
        }
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        view4.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view5;
        }
        this.menuHeight = view2.getMeasuredHeight();
    }

    private final int G(View anchorView, int offsetPadding, boolean useVisible, int minY, int maxY) {
        int coerceAtLeast;
        F(w(anchorView, useVisible));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(v(anchorView, offsetPadding) - (this.menuHeight / 2), minY);
        return coerceAtLeast;
    }

    private final View H(QQCustomMenuExpandableLayout qQCustomMenuExpandableLayout, View view, boolean z16, AIOMsgItem aIOMsgItem) {
        LinearLayout linearLayout = new LinearLayout(qQCustomMenuExpandableLayout.getContext());
        linearLayout.setOrientation(1);
        View imageView = new ImageView(linearLayout.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(l.b(10), l.b(6));
        if (z16) {
            layoutParams.gravity = 5;
            layoutParams.rightMargin = (MenuUtils.f351230a.h(view, z16, aIOMsgItem) - layoutParams.width) / 2;
        } else {
            layoutParams.gravity = 3;
            layoutParams.leftMargin = (MenuUtils.f351230a.h(view, z16, aIOMsgItem) - layoutParams.width) / 2;
        }
        this.indicatorLayoutParams = layoutParams;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.o18);
        linearLayout.addView(imageView);
        int i3 = 0;
        qQCustomMenuExpandableLayout.measure(0, 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        int h16 = MenuUtils.f351230a.h(view, z16, aIOMsgItem);
        int measuredWidth = qQCustomMenuExpandableLayout.getMeasuredWidth();
        if (z16) {
            layoutParams2.gravity = 5;
            if (h16 > measuredWidth) {
                i3 = (h16 - measuredWidth) / 2;
            }
            layoutParams2.rightMargin = i3;
        } else {
            layoutParams2.gravity = 3;
            if (h16 > measuredWidth) {
                i3 = (h16 - measuredWidth) / 2;
            }
            layoutParams2.leftMargin = i3;
        }
        qQCustomMenuExpandableLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(qQCustomMenuExpandableLayout);
        return linearLayout;
    }

    private final int k(View anchorView, int startY, int offsetPadding, Rect displayRect, Integer containerTop, Integer containerBottom) {
        int height;
        int i3;
        if (containerBottom != null) {
            height = containerBottom.intValue();
        } else {
            height = anchorView.getRootView().getHeight();
        }
        int i16 = this.menuHeight + startY;
        if (containerTop != null) {
            i3 = RangesKt___RangesKt.coerceAtLeast(containerTop.intValue(), displayRect.top);
        } else {
            i3 = displayRect.top;
        }
        int i17 = i3;
        int i18 = height - f351488j;
        if (startY < i17 && i16 > i18) {
            return G(anchorView, offsetPadding, true, i17, i18);
        }
        if (startY < i17) {
            return G(anchorView, offsetPadding, true, i17, i18);
        }
        if (i16 > i18) {
            return G(anchorView, offsetPadding, false, i17, i18);
        }
        return startY;
    }

    private final void l(View archer) {
        boolean z16;
        float f16;
        archer.setPivotX(archer.getWidth() / 2.0f);
        archer.setPivotY(archer.getHeight() / 2.0f);
        int width = archer.getWidth();
        int height = archer.getHeight();
        int b16 = com.tencent.qqnt.util.view.b.f362999a.b(15);
        if (width >= height) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = (width - b16) / width;
        } else {
            f16 = (height - b16) / height;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(archer, BasicAnimation.KeyPath.SCALE_X, 1.0f, f16, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(archer, BasicAnimation.KeyPath.SCALE_Y, 1.0f, f16, 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    private final int m(View anchorView, int startY, Rect displayRect, Integer containerTop, Integer containerBottom) {
        int height;
        int i3;
        if (containerBottom != null) {
            height = containerBottom.intValue();
        } else {
            height = anchorView.getRootView().getHeight();
        }
        if (containerTop != null) {
            i3 = RangesKt___RangesKt.coerceAtLeast(containerTop.intValue(), displayRect.top);
        } else {
            i3 = displayRect.top;
        }
        int i16 = height - f351488j;
        int i17 = this.menuHeight + startY;
        if ((startY < i3 && i17 > i16) || i17 <= i16) {
            return 0;
        }
        int min = Math.min(i17 - i16, MenuWrapper.INSTANCE.d());
        if (startY - min < i3) {
            return 0;
        }
        return min;
    }

    private final View o(Context context, View source) {
        boolean z16;
        QQBlurViewWrapper qQBlurViewWrapper = new QQBlurViewWrapper(context, null, 0, 6, null);
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, null, -1, new ColorDrawable(context.getColor(R.color.cdl)), Integer.valueOf(R.drawable.jwh));
        aVar.o(true);
        qQBlurViewWrapper.a(aVar);
        qQBlurViewWrapper.setDebugTag("SeparateEmoMenu");
        if (source != null) {
            qQBlurViewWrapper.setBlurSource(source, null, null);
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
        layoutParams.bottomToBottom = R.id.z3q;
        layoutParams.topToTop = R.id.z3q;
        layoutParams.startToStart = R.id.z3q;
        layoutParams.endToEnd = R.id.z3q;
        qQBlurViewWrapper.setLayoutParams(layoutParams);
        ab.d(qQBlurViewWrapper, l.b(24));
        return qQBlurViewWrapper;
    }

    private final ViewGroup p(Context context, View anchorView, AIOMsgItem msgItem, com.tencent.qqnt.aio.menu.ui.c menu, boolean showSelectMenu, View contentMenuLayout, View source, boolean isSelfMsg, w onMenuActionListener) {
        ConstraintLayout constraintLayout = null;
        if (menu == null) {
            return null;
        }
        if (menu.d() > 0 && !showSelectMenu) {
            IAIOEmoReplyMenuApi iAIOEmoReplyMenuApi = (IAIOEmoReplyMenuApi) QRoute.api(IAIOEmoReplyMenuApi.class);
            AIOMsgItem d16 = menu.b(0).d();
            Intrinsics.checkNotNullExpressionValue(d16, "menu.getItem(0).msgItem");
            View separateEmoReplyMenuView = iAIOEmoReplyMenuApi.getSeparateEmoReplyMenuView(context, d16, anchorView, onMenuActionListener);
            if (separateEmoReplyMenuView != null) {
                separateEmoReplyMenuView.setId(R.id.z3q);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                if (isSelfMsg) {
                    layoutParams.endToEnd = 0;
                } else {
                    layoutParams.startToStart = 0;
                }
                layoutParams.topToTop = 0;
                separateEmoReplyMenuView.setLayoutParams(layoutParams);
                constraintLayout = new ConstraintLayout(context);
                ab.d(constraintLayout, l.b(24));
                constraintLayout.setId(View.generateViewId());
                if (!y(menu)) {
                    separateEmoReplyMenuView.setBackgroundResource(R.drawable.jwi);
                } else {
                    separateEmoReplyMenuView.setBackgroundResource(R.color.ajr);
                    constraintLayout.addView(o(context, source));
                }
                constraintLayout.addView(separateEmoReplyMenuView);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                if (isSelfMsg) {
                    layoutParams2.gravity = 5;
                } else {
                    layoutParams2.gravity = 3;
                }
                constraintLayout.setLayoutParams(layoutParams2);
            }
        }
        return constraintLayout;
    }

    private final QQCustomMenuExpandableLayout q(BubblePopupWindow popup, Context ctx, com.tencent.qqnt.aio.menu.ui.c menu, final w onMenuActionListener, boolean ignoreTouchLocation, Integer containerBottom, View source, boolean showSelectMenu, QQCustomMenuNoIconLayout creator, final String msgUin, final int msgType) {
        com.tencent.qqnt.aio.menu.ui.e.b(menu);
        QQCustomMenuExpandableLayout qQCustomMenuExpandableLayout = new QQCustomMenuExpandableLayout(ctx);
        qQCustomMenuExpandableLayout.setViewRadius(12.0f);
        qQCustomMenuExpandableLayout.setPopupWindow(popup, new BubblePopupWindow.f() { // from class: com.tencent.qqnt.aio.menu.strategy.e
            @Override // com.tencent.qqnt.aio.widget.BubblePopupWindow.f
            public final void onMenuNoIconEmptyClick() {
                j.r();
            }
        });
        qQCustomMenuExpandableLayout.setMenu(menu, source);
        qQCustomMenuExpandableLayout.setMenuIconClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.menu.strategy.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.s(msgUin, msgType, this, onMenuActionListener, view);
            }
        });
        qQCustomMenuExpandableLayout.setIgnoreTouchLocation(ignoreTouchLocation);
        qQCustomMenuExpandableLayout.setContainerBottom(containerBottom);
        qQCustomMenuExpandableLayout.G();
        return qQCustomMenuExpandableLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String msgUin, int i3, j this$0, w onMenuActionListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msgUin, "$msgUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "$onMenuActionListener");
        Intrinsics.checkNotNull(view);
        Object tag = view.getTag();
        if (tag instanceof com.tencent.qqnt.aio.menu.ui.d) {
            com.tencent.qqnt.aio.menu.ui.d dVar = (com.tencent.qqnt.aio.menu.ui.d) tag;
            HashMap<String, Object> a16 = MenuWrapper.INSTANCE.a(dVar.d().getMsgRecord(), msgUin, i3);
            String e16 = com.tencent.mobileqq.aio.utils.b.f194119a.e(dVar.c());
            if (TextUtils.isEmpty(e16)) {
                e16 = this$0.n(dVar.c());
            }
            a16.put("aio_longpress_menu_action_item", e16);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_long_menu", a16);
        }
        onMenuActionListener.a(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List, T] */
    private final void t(ViewGroup viewGroup) {
        ?? list;
        float f16;
        ?? reversed;
        if (viewGroup == null) {
            return;
        }
        ViewGroup menuEmotionLayout = (ViewGroup) viewGroup.findViewById(R.id.z3q);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.checkNotNullExpressionValue(menuEmotionLayout, "menuEmotionLayout");
        list = SequencesKt___SequencesKt.toList(ViewGroupKt.getChildren(menuEmotionLayout));
        objectRef.element = list;
        if (this.isSelfMsg) {
            reversed = CollectionsKt___CollectionsKt.reversed((Iterable) list);
            objectRef.element = reversed;
        }
        int i3 = 0;
        for (Object obj : (Iterable) objectRef.element) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            view.setVisibility(4);
            view.setPivotX(view.getMeasuredWidth() / 2.0f);
            view.setPivotY(view.getMeasuredHeight() / 2.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            final AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.addListener(new b(view, i3, objectRef, menuEmotionLayout));
            viewGroup.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.menu.strategy.d
                @Override // java.lang.Runnable
                public final void run() {
                    j.u(animatorSet);
                }
            }, i16 * 30);
            i3 = i16;
        }
        if (this.isSelfMsg) {
            f16 = viewGroup.getMeasuredWidth();
        } else {
            f16 = 0.0f;
        }
        viewGroup.setPivotX(f16);
        viewGroup.setPivotY(viewGroup.getMeasuredHeight() / 2.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewGroup, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(viewGroup, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(viewGroup, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        ofFloat4.setInterpolator(new DecelerateInterpolator());
        ofFloat5.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(200L);
        animatorSet2.playTogether(ofFloat3, ofFloat4, ofFloat5);
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AnimatorSet animatorSet) {
        Intrinsics.checkNotNullParameter(animatorSet, "$animatorSet");
        animatorSet.start();
    }

    private final int v(View anchorView, int offsetPadding) {
        Rect rect = new Rect();
        anchorView.getGlobalVisibleRect(rect);
        int i3 = rect.top - offsetPadding;
        rect.top = i3;
        return i3 + (rect.height() / 2);
    }

    private final int w(View anchorView, boolean useVisible) {
        int coerceAtMost;
        if (!useVisible) {
            return f351489k;
        }
        Rect rect = new Rect();
        anchorView.getGlobalVisibleRect(rect);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(rect.height(), f351489k);
        return coerceAtMost;
    }

    private final int[] x(View anchorView) {
        Activity activity;
        View rootView;
        Window window;
        int[] iArr = new int[2];
        Context context = anchorView.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || (window = activity.getWindow()) == null || (rootView = window.getDecorView()) == null) {
            rootView = anchorView.getRootView();
        }
        rootView.getLocationOnScreen(iArr);
        return iArr;
    }

    private final boolean y(com.tencent.qqnt.aio.menu.ui.c menu) {
        return MenuUtils.f351230a.b(menu);
    }

    private final void z(View view) {
        LinearLayout.LayoutParams layoutParams = this.indicatorLayoutParams;
        LinearLayout.LayoutParams layoutParams2 = null;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorLayoutParams");
            layoutParams = null;
        }
        if (layoutParams.gravity == 3) {
            View view2 = this.menuLayoutWithIndicator;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view2 = null;
            }
            LinearLayout.LayoutParams layoutParams3 = this.indicatorLayoutParams;
            if (layoutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorLayoutParams");
            } else {
                layoutParams2 = layoutParams3;
            }
            view2.setPivotX(layoutParams2.leftMargin);
        } else {
            View view3 = this.menuLayoutWithIndicator;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view3 = null;
            }
            View view4 = this.menuLayoutWithIndicator;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view4 = null;
            }
            float measuredWidth = view4.getMeasuredWidth();
            LinearLayout.LayoutParams layoutParams4 = this.indicatorLayoutParams;
            if (layoutParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorLayoutParams");
            } else {
                layoutParams2 = layoutParams4;
            }
            view3.setPivotX(measuredWidth - layoutParams2.rightMargin);
        }
        view.setPivotY(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.start();
    }

    public final void B(@NotNull Function0<Unit> onAnimationEnd) {
        List list;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onAnimationEnd);
            return;
        }
        Intrinsics.checkNotNullParameter(onAnimationEnd, "onAnimationEnd");
        LinearLayout.LayoutParams layoutParams = this.indicatorLayoutParams;
        View view = null;
        if (layoutParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indicatorLayoutParams");
            layoutParams = null;
        }
        if (layoutParams.gravity == 3) {
            View view2 = this.menuLayoutWithIndicator;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view2 = null;
            }
            LinearLayout.LayoutParams layoutParams2 = this.indicatorLayoutParams;
            if (layoutParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorLayoutParams");
                layoutParams2 = null;
            }
            view2.setPivotX(layoutParams2.leftMargin);
        } else {
            View view3 = this.menuLayoutWithIndicator;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view3 = null;
            }
            View view4 = this.menuLayoutWithIndicator;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view4 = null;
            }
            float measuredWidth = view4.getMeasuredWidth();
            LinearLayout.LayoutParams layoutParams3 = this.indicatorLayoutParams;
            if (layoutParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indicatorLayoutParams");
                layoutParams3 = null;
            }
            view3.setPivotX(measuredWidth - layoutParams3.rightMargin);
        }
        View view5 = this.menuLayoutWithIndicator;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
            view5 = null;
        }
        view5.setPivotY(0.0f);
        View view6 = this.menuLayoutWithIndicator;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
            view6 = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view6, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
        View view7 = this.menuLayoutWithIndicator;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
            view7 = null;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view7, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
        View view8 = this.menuLayoutWithIndicator;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
            view8 = null;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view8, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new c(onAnimationEnd));
        View view9 = this.menuLayoutWithIndicator;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
        } else {
            view = view9;
        }
        view.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.menu.strategy.g
            @Override // java.lang.Runnable
            public final void run() {
                j.C(animatorSet);
            }
        }, 150L);
        ViewGroup viewGroup = this.emoMenuLayout;
        if (viewGroup == null) {
            return;
        }
        View findViewById = viewGroup.findViewById(R.id.z3q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "emoMenuViewGroup.findVie\u2026R.id.menu_emotion_layout)");
        list = SequencesKt___SequencesKt.toList(ViewGroupKt.getChildren((ViewGroup) findViewById));
        if (!this.isSelfMsg) {
            list = CollectionsKt___CollectionsKt.reversed(list);
        }
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view10 = (View) obj;
            view10.setPivotX(view10.getMeasuredWidth() / 2.0f);
            view10.setPivotY(view10.getMeasuredHeight() / 2.0f);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view10, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view10, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
            ofFloat4.setInterpolator(new DecelerateInterpolator());
            ofFloat5.setInterpolator(new DecelerateInterpolator());
            final AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(200L);
            animatorSet2.playTogether(ofFloat4, ofFloat5);
            viewGroup.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.menu.strategy.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.D(animatorSet2);
                }
            }, i3 * 30);
            i3 = i16;
        }
        if (this.isSelfMsg) {
            f16 = viewGroup.getMeasuredWidth();
        } else {
            f16 = 0.0f;
        }
        viewGroup.setPivotX(f16);
        viewGroup.setPivotY(viewGroup.getMeasuredHeight() / 2.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(viewGroup, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(viewGroup, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(viewGroup, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat6.setInterpolator(new DecelerateInterpolator());
        ofFloat7.setInterpolator(new DecelerateInterpolator());
        ofFloat8.setInterpolator(new DecelerateInterpolator());
        final AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setDuration(200L);
        animatorSet3.playTogether(ofFloat6, ofFloat7, ofFloat8);
        viewGroup.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.menu.strategy.i
            @Override // java.lang.Runnable
            public final void run() {
                j.E(animatorSet3);
            }
        }, 150L);
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    @NotNull
    public MenuWrapper.d a(@NotNull View anchorView, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull MenuWrapper.c initInfo, @NotNull al selectLocation, int selectMenuBottomPadding) {
        int i3;
        int d16;
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MenuWrapper.d) iPatchRedirector.redirect((short) 3, this, anchorView, menu, initInfo, selectLocation, Integer.valueOf(selectMenuBottomPadding));
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(initInfo, "initInfo");
        Intrinsics.checkNotNullParameter(selectLocation, "selectLocation");
        AIOMsgItem msgItem = menu.b(0).d();
        boolean isSelf = msgItem.isSelf();
        MenuUtils menuUtils = MenuUtils.f351230a;
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        int[] e16 = menuUtils.e(anchorView, isSelf, msgItem);
        int[] x16 = x(anchorView);
        int[] a16 = menuUtils.a(e16, x16);
        if (isSelf) {
            i3 = (a16[0] + menuUtils.h(anchorView, true, msgItem)) - this.menuWidth;
        } else {
            i3 = a16[0];
        }
        int i16 = i3;
        if (this.hasEmoMenu) {
            d16 = a16[1] - (f351490l + f351491m);
        } else {
            d16 = f351491m + a16[1] + menuUtils.d(anchorView, msgItem);
        }
        int i17 = d16;
        Rect rect = new Rect();
        anchorView.getWindowVisibleDisplayFrame(rect);
        rect.offset(-x16[0], -x16[1]);
        int m3 = m(anchorView, i17, rect, initInfo.b(), initInfo.a());
        int k3 = k(anchorView, i17 - m3, m3, rect, initInfo.b(), initInfo.a());
        if (m3 != 0) {
            Context context = anchorView.getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, new AIOMsgListEvent.SetBottomPaddingIncrement(m3));
            }
        }
        return new MenuWrapper.d(i16, k3, MenuWrapper.ArrowType.IGNORE);
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    @NotNull
    public View b(@Nullable BubblePopupWindow popup, @NotNull Context ctx, @NotNull View anchorView, @Nullable com.tencent.qqnt.aio.menu.ui.c menu, @NotNull w onMenuActionListener, boolean ignoreTouchLocation, @Nullable Integer containerBottom, @Nullable View source, boolean showSelectMenu, @Nullable QQCustomMenuNoIconLayout creator, @NotNull String msgUin, int msgType) {
        com.tencent.qqnt.aio.menu.ui.d b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, this, popup, ctx, anchorView, menu, onMenuActionListener, Boolean.valueOf(ignoreTouchLocation), containerBottom, source, Boolean.valueOf(showSelectMenu), creator, msgUin, Integer.valueOf(msgType));
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(onMenuActionListener, "onMenuActionListener");
        Intrinsics.checkNotNullParameter(msgUin, "msgUin");
        QQMenuDispatchTouchEventLinearLayout qQMenuDispatchTouchEventLinearLayout = new QQMenuDispatchTouchEventLinearLayout(ctx, anchorView, popup);
        this.rootView = qQMenuDispatchTouchEventLinearLayout;
        AIOMsgItem d16 = (menu == null || (b16 = menu.b(0)) == null) ? null : b16.d();
        if (d16 == null) {
            return qQMenuDispatchTouchEventLinearLayout;
        }
        Intrinsics.checkNotNullExpressionValue(d16, "menu?.getItem(0)?.msgItem ?: return@apply");
        boolean isSelf = d16.isSelf();
        this.isSelfMsg = isSelf;
        qQMenuDispatchTouchEventLinearLayout.setOrientation(1);
        AIOMsgItem aIOMsgItem = d16;
        QQCustomMenuExpandableLayout q16 = q(popup, ctx, menu, onMenuActionListener, ignoreTouchLocation, containerBottom, source, showSelectMenu, creator, msgUin, msgType);
        this.menuLayoutWithIndicator = H(q16, anchorView, isSelf, aIOMsgItem);
        Context context = qQMenuDispatchTouchEventLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ViewGroup p16 = p(context, anchorView, aIOMsgItem, menu, showSelectMenu, q16, source, isSelf, onMenuActionListener);
        if (p16 != null) {
            qQMenuDispatchTouchEventLinearLayout.addView(p16);
            View view = this.menuLayoutWithIndicator;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
                view = null;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = MenuUtils.f351230a.d(anchorView, aIOMsgItem) + f351491m + f351492n;
            layoutParams.gravity = isSelf ? 5 : 3;
            view.setLayoutParams(layoutParams);
        } else {
            p16 = null;
        }
        this.emoMenuLayout = p16;
        View view2 = this.menuLayoutWithIndicator;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
            view2 = null;
        }
        qQMenuDispatchTouchEventLinearLayout.addView(view2);
        qQMenuDispatchTouchEventLinearLayout.measure(0, 0);
        this.hasEmoMenu = this.emoMenuLayout != null;
        this.menuWidth = qQMenuDispatchTouchEventLinearLayout.getMeasuredWidth();
        this.menuHeight = qQMenuDispatchTouchEventLinearLayout.getMeasuredHeight();
        ViewGroup viewGroup = this.emoMenuLayout;
        View view3 = this.menuLayoutWithIndicator;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuLayoutWithIndicator");
            view3 = null;
        }
        A(anchorView, viewGroup, view3);
        return qQMenuDispatchTouchEventLinearLayout;
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    public void c(@Nullable BubblePopupWindow popup, @NotNull View anchorView, int x16, int y16, int offsetWidth, int displayWidth) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, popup, anchorView, Integer.valueOf(x16), Integer.valueOf(y16), Integer.valueOf(offsetWidth), Integer.valueOf(displayWidth));
            return;
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        if (popup != null) {
            popup.R(anchorView, x16, y16, offsetWidth, displayWidth);
        }
    }

    @Override // com.tencent.qqnt.aio.menu.MenuWrapper.b
    @NotNull
    public MenuWrapper.d d(@NotNull View anchorView, @NotNull com.tencent.qqnt.aio.menu.ui.c menu, @NotNull MenuWrapper.c initInfo) {
        int i3;
        int d16;
        FragmentActivity fragmentActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MenuWrapper.d) iPatchRedirector.redirect((short) 2, this, anchorView, menu, initInfo);
        }
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(initInfo, "initInfo");
        AIOMsgItem msgItem = menu.b(0).d();
        boolean isSelf = msgItem.isSelf();
        MenuUtils menuUtils = MenuUtils.f351230a;
        Intrinsics.checkNotNullExpressionValue(msgItem, "msgItem");
        int[] e16 = menuUtils.e(anchorView, isSelf, msgItem);
        int[] x16 = x(anchorView);
        int[] a16 = menuUtils.a(e16, x16);
        if (isSelf) {
            i3 = (a16[0] + menuUtils.h(anchorView, true, msgItem)) - this.menuWidth;
        } else {
            i3 = a16[0];
        }
        int i16 = i3;
        if (this.hasEmoMenu) {
            d16 = a16[1] - (f351490l + f351491m);
        } else {
            d16 = f351491m + a16[1] + menuUtils.d(anchorView, msgItem);
        }
        int i17 = d16;
        Rect rect = new Rect();
        anchorView.getWindowVisibleDisplayFrame(rect);
        rect.offset(-x16[0], -x16[1]);
        int m3 = m(anchorView, i17, rect, initInfo.b(), initInfo.a());
        int k3 = k(anchorView, i17 - m3, m3, rect, initInfo.b(), initInfo.a());
        if (m3 != 0) {
            Context context = anchorView.getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            } else {
                fragmentActivity = null;
            }
            if (fragmentActivity != null) {
                com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, new AIOMsgListEvent.SetBottomPaddingIncrement(m3));
            }
        }
        return new MenuWrapper.d(i16, k3, MenuWrapper.ArrowType.IGNORE);
    }

    @NotNull
    public String n(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        return MenuWrapper.b.a.a(this, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r() {
    }
}
