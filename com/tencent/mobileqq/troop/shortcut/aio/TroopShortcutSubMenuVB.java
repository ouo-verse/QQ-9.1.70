package com.tencent.mobileqq.troop.shortcut.aio;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.troop.api.ITroopAIOAdapterApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.troop.shortcut.aio.ShortcutAioUIState;
import com.tencent.mobileqq.troop.shortcut.aio.a;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutMenu;
import com.tencent.mobileqq.troop.utils.TroopAIOUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.qui.quiblurview.f;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0003J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J)\u0010\u0015\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u00132\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u001c\u0010#\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0016J\u001c\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%\u0018\u000100H\u0016J\u0016\u00103\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u0003020\u000fH\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u00105\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0016R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutSubMenuVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/troop/shortcut/aio/a;", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState;", "", "A1", "g1", "x1", "w1", "i1", "", "m1", "Lcom/tencent/mobileqq/troop/shortcut/aio/ShortcutAioUIState$ShowSubmenu;", "state", "j1", "", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu;", "menuList", "B1", "", "Lcom/tencent/mobileqq/widget/listitem/a;", "l1", "(Ljava/util/List;)[Lcom/tencent/mobileqq/widget/listitem/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View$OnClickListener;", "p1", "Landroid/view/View;", "v", "C1", "Lcom/tencent/mobileqq/widget/listitem/g;", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutSubMenuConfigFactory;", "factory", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu$MenuTemplate;", "template", "h1", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/aio/api/runtime/a;", "context", "E1", Constants.BASE_IN_PLUGIN_ID, "v1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/api/help/b;", "reuseParam", "onReuseView", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "Ljava/lang/Class;", "getObserverStates", "r1", "handleCreateVM", "Lts2/h;", "d", "Lkotlin/Lazy;", "k1", "()Lts2/h;", "binding", "", "e", "Z", "initialized", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "f", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troop/shortcut/action/a;", tl.h.F, "Lcom/tencent/mobileqq/troop/shortcut/action/a;", "executor", "Landroidx/core/view/GestureDetectorCompat;", "i", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShortcutSubMenuVB extends com.tencent.aio.base.mvvm.a<a, ShortcutAioUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private FrameLayout container;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean initialized;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QUIListItemAdapter adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.shortcut.action.a executor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GestureDetectorCompat gestureDetector;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutSubMenuVB$a;", "", "", "ELEMENT", "Ljava/lang/String;", "ELEMENT_ID", "EVENT_CLCK", "EVENT_IMP", "KEY_APPID", "KEY_ORDER_ID", "", "MIN_DISTANCE", "I", "MIN_VELOCITY", "PG_AIO", "PG_ID", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutSubMenuVB$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298477a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55091);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TroopShortcutMenu.MenuTemplate.values().length];
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_TEXT_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_ICON_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_TEXT_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_SINGLE_LINE_ICON_ICON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_TEXT_BTN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_ICON_BTN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_TEXT_ICON.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_TWO_LINE_ICON_ICON.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TroopShortcutMenu.MenuTemplate.TEMPLATE_DEFAULT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f298477a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/shortcut/aio/TroopShortcutSubMenuVB$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "velocityX", "velocityY", "", "onFling", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutSubMenuVB.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
            }
            if (e16 != null) {
                TroopShortcutSubMenuVB troopShortcutSubMenuVB = TroopShortcutSubMenuVB.this;
                if (e26 != null && e26.getY() - e16.getY() > 100.0f && Math.abs(velocityY) > 500.0f) {
                    com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSubmenuVB", "title icon on fling, ShouldHideMenu");
                    troopShortcutSubMenuVB.sendIntent(new a.c());
                }
            }
            return super.onFling(e16, e26, velocityX, velocityY);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55098);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopShortcutSubMenuVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<ts2.h>() { // from class: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutSubMenuVB$binding$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopShortcutSubMenuVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ts2.h invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (ts2.h) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
                    aVar.b("TroopShortcutSubmenuVB", "TroopShortcutSubMenuBinding inflate before");
                    ts2.h g16 = ts2.h.g(LayoutInflater.from(TroopShortcutSubMenuVB.this.getMContext()));
                    aVar.b("TroopShortcutSubmenuVB", "TroopShortcutSubMenuBinding inflate end");
                    return g16;
                }
            });
            this.binding = lazy;
            this.adapter = new QUIListItemAdapter(QUIListItemStyle.FullWidth, false, false, 6, null);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void A1() {
        if (this.initialized) {
            return;
        }
        x1();
        this.initialized = true;
    }

    private final void B1(List<TroopShortcutMenu> menuList) {
        Object firstOrNull;
        TroopShortcutAction a16;
        String a17;
        Map mapOf;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) menuList);
        TroopShortcutMenu troopShortcutMenu = (TroopShortcutMenu) firstOrNull;
        if (troopShortcutMenu != null && (a16 = troopShortcutMenu.a()) != null && (a17 = a16.a()) != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("appid", a17), TuplesKt.to("qq_pgid", "pg_aio"), TuplesKt.to("qq_eid", "em_group_app_capsule_panel"));
            VideoReport.reportEvent("qq_imp", null, mapOf);
        }
    }

    private final void C1(View v3) {
        VideoReport.reportEvent("qq_clck", v3, null);
    }

    private final void D1() {
        com.tencent.aio.api.runtime.a aVar;
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null) {
            if (TroopAIOUtils.f301862a.c(aVar)) {
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "solveBackgroundResource isEnableBlur");
                LinearLayout linearLayout = k1().f437397b;
                com.tencent.mobileqq.troop.shortcut.ui.c cVar = new com.tencent.mobileqq.troop.shortcut.ui.c();
                int color = k1().getRoot().getContext().getColor(R.color.qui_common_fill_light_secondary);
                cVar.a(ViewUtils.dip2px(124.0f), 16777215 & color, color);
                linearLayout.setBackground(cVar);
                return;
            }
            if (QQTheme.isVasTheme()) {
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "solveBackgroundResource isVasTheme");
                LinearLayout linearLayout2 = k1().f437397b;
                linearLayout2.setBackground(linearLayout2.getContext().getDrawable(R.drawable.qui_common_bg_nav_bottom_aio_bg));
                return;
            } else {
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "solveBackgroundResource use default");
                int color2 = k1().getRoot().getContext().getColor(R.color.qui_common_bg_nav_bottom_aio);
                LinearLayout linearLayout3 = k1().f437397b;
                com.tencent.mobileqq.troop.shortcut.ui.c cVar2 = new com.tencent.mobileqq.troop.shortcut.ui.c();
                cVar2.a(ViewUtils.dip2px(124.0f), color2 | (-16777216), k1().getRoot().getContext().getColor(R.color.qui_common_fill_light_secondary));
                linearLayout3.setBackground(cVar2);
                return;
            }
        }
        k1().f437397b.setBackgroundResource(R.drawable.qui_common_bg_nav_bottom_aio_bg);
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d("TroopShortcutSubmenuVB", "solveBackgroundResource but context got null");
    }

    private final void E1(com.tencent.aio.api.runtime.a context) {
        boolean z16;
        QQBlurViewWrapper qQBlurViewWrapper = k1().f437400e;
        Intrinsics.checkNotNullExpressionValue(qQBlurViewWrapper, "binding.troopShortcutMenuBlueView");
        if (!TroopAIOUtils.f301862a.c(context)) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "disable blur");
            qQBlurViewWrapper.setVisibility(8);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "show blur");
        qQBlurViewWrapper.setVisibility(0);
        com.tencent.mobileqq.aio.troop.api.a blurRecyclerView = ((ITroopAIOAdapterApi) QRoute.api(ITroopAIOAdapterApi.class)).getBlurRecyclerView(context);
        qQBlurViewWrapper.setDebugTag("TroopShortcutSubmenuVB");
        f.d dVar = new f.d(null, null, 3, null);
        dVar.d(blurRecyclerView.a());
        qQBlurViewWrapper.setBlurSource(blurRecyclerView.b(), null, dVar);
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        f.a aVar = new f.a(z16, 64.0f, null, getMContext().getColor(R.color.qui_common_bg_nav_bottom_aio), new ColorDrawable(getMContext().getColor(R.color.qui_common_bg_nav_bottom_aio)), Integer.valueOf(R.drawable.qui_common_transparent_bg));
        aVar.o(true);
        qQBlurViewWrapper.a(aVar);
    }

    private final void g1() {
        FrameLayout frameLayout = this.container;
        if (frameLayout == null) {
            return;
        }
        frameLayout.addView(k1().getRoot(), -1, -1);
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> h1(TroopShortcutSubMenuConfigFactory factory, TroopShortcutMenu.MenuTemplate template) {
        switch (b.f298477a[template.ordinal()]) {
            case 1:
                return factory.e();
            case 2:
                return factory.d();
            case 3:
                return factory.f();
            case 4:
                return factory.c();
            case 5:
                return factory.i();
            case 6:
                return factory.g();
            case 7:
                return factory.j();
            case 8:
                return factory.h();
            case 9:
                return factory.a();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void i1() {
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSubmenuVB", "hide");
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        sendIntent(new a.C8772a());
    }

    private final void j1(ShortcutAioUIState.ShowSubmenu state) {
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        aVar.a("TroopShortcutSubmenuVB", "show");
        this.executor = state.b();
        List<TroopShortcutMenu> e16 = state.c().e();
        if (e16.isEmpty()) {
            aVar.a("TroopShortcutSubmenuVB", "show failed for menuList is empty");
            return;
        }
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        com.tencent.mobileqq.widget.listitem.a<?>[] l16 = l1(e16);
        qUIListItemAdapter.t0(new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(l16, l16.length)));
        FrameLayout frameLayout = this.container;
        ViewGroup.LayoutParams layoutParams3 = null;
        if (frameLayout != null) {
            layoutParams = frameLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        } else {
            layoutParams2 = null;
        }
        if (layoutParams2 == null) {
            FrameLayout frameLayout2 = this.container;
            if (frameLayout2 != null) {
                layoutParams3 = frameLayout2.getLayoutParams();
            }
            aVar.a("TroopShortcutSubmenuVB", "show failed for root layoutparams is " + layoutParams3);
            return;
        }
        v1();
        layoutParams2.addRule(14);
        layoutParams2.height = state.a() - m1();
        layoutParams2.width = -1;
        FrameLayout frameLayout3 = this.container;
        if (frameLayout3 != null) {
            frameLayout3.setLayoutParams(layoutParams2);
        }
        FrameLayout frameLayout4 = this.container;
        if (frameLayout4 != null) {
            frameLayout4.setVisibility(0);
        }
        s1();
        sendIntent(new a.b());
        B1(e16);
    }

    private final ts2.h k1() {
        return (ts2.h) this.binding.getValue();
    }

    private final com.tencent.mobileqq.widget.listitem.a<?>[] l1(List<TroopShortcutMenu> menuList) {
        int collectionSizeOrDefault;
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSubmenuVB", "get config list");
        List<TroopShortcutMenu> list = menuList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (TroopShortcutMenu troopShortcutMenu : list) {
            arrayList.add(h1(new TroopShortcutSubMenuConfigFactory(troopShortcutMenu, p1(troopShortcutMenu), n1(troopShortcutMenu)), troopShortcutMenu.f()));
        }
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.tencent.mobileqq.widget.listitem.a[]) array;
    }

    private final int m1() {
        int[] iArr = new int[2];
        for (int i3 = 0; i3 < 2; i3++) {
            iArr[i3] = 0;
        }
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.getLocationInWindow(iArr);
        }
        if (QLog.isDevelopLevel()) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "getRootLocationInWindow result:" + iArr[1]);
        }
        return iArr[1];
    }

    private final com.tencent.mobileqq.widget.listitem.g n1(final TroopShortcutMenu item) {
        return new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troop.shortcut.aio.f
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                TroopShortcutSubMenuVB.o1(TroopShortcutMenu.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(TroopShortcutMenu item, View view) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, "em_group_app_capsule_panel");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("appid", item.a().a()), TuplesKt.to("group_order_id", item.d()), TuplesKt.to("qq_pgid", "pg_aio"), TuplesKt.to("qq_eid", "em_group_app_capsule_panel"));
        VideoReport.setElementParams(view, hashMapOf);
    }

    private final View.OnClickListener p1(final TroopShortcutMenu item) {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.shortcut.aio.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopShortcutSubMenuVB.q1(TroopShortcutSubMenuVB.this, item, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(TroopShortcutSubMenuVB this$0, TroopShortcutMenu item, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        com.tencent.mobileqq.troop.shortcut.action.a aVar = this$0.executor;
        if (aVar != null) {
            z16 = aVar.c(item.a(), TroopShortcutSubMenuVB$getSubMenuClickListener$1$actionSuccess$1.INSTANCE);
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSubmenuVB", "sub menu click action success");
            this$0.i1();
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.C1(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s1() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TroopShortcutSubmenuVB", "resetBackground fail for aioContext is null");
            return;
        }
        E1(aVar);
        D1();
        k1().f437398c.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.troop.shortcut.aio.d
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                TroopShortcutSubMenuVB.u1(TroopShortcutSubMenuVB.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u1(TroopShortcutSubMenuVB this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.k1().f437400e.getVisibility() == 0 && (layoutParams = this$0.k1().f437400e.getLayoutParams()) != null) {
            layoutParams.height = this$0.k1().f437398c.getHeight();
            this$0.k1().f437400e.setLayoutParams(layoutParams);
        }
    }

    private final void v1() {
        if (this.gestureDetector != null) {
            return;
        }
        this.gestureDetector = new GestureDetectorCompat(k1().getRoot().getContext(), new c());
    }

    private final void w1() {
        QUISettingsRecyclerView qUISettingsRecyclerView = k1().f437398c;
        Intrinsics.checkNotNullExpressionValue(qUISettingsRecyclerView, "binding.menuItemList");
        qUISettingsRecyclerView.setAdapter(this.adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(qUISettingsRecyclerView.getContext());
        linearLayoutManager.setOrientation(1);
        qUISettingsRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void x1() {
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        aVar.b("TroopShortcutSubmenuVB", "initView");
        g1();
        w1();
        k1().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.shortcut.aio.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopShortcutSubMenuVB.y1(TroopShortcutSubMenuVB.this, view);
            }
        });
        k1().f437397b.setElevation(ViewUtils.dip2px(4.0f));
        k1().f437399d.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.troop.shortcut.aio.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z16;
                z16 = TroopShortcutSubMenuVB.z1(TroopShortcutSubMenuVB.this, view, motionEvent);
                return z16;
            }
        });
        aVar.b("TroopShortcutSubmenuVB", "initView end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(TroopShortcutSubMenuVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z1(TroopShortcutSubMenuVB this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GestureDetectorCompat gestureDetectorCompat = this$0.gestureDetector;
        if (gestureDetectorCompat != null) {
            return gestureDetectorCompat.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<a, ShortcutAioUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseVM) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new com.tencent.mobileqq.troop.shortcut.vm.a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends ShortcutAioUIState>> getObserverStates() {
        List<Class<? extends ShortcutAioUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{ShortcutAioUIState.ShowSubmenu.class, ShortcutAioUIState.HideSubMenu.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "onCreateView return empty FrameLayout");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105436", false);
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        this.container = frameLayout;
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutSubmenuVB", "onReuseView");
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ShortcutAioUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        aVar.b("TroopShortcutSubmenuVB", "handleUIState");
        super.handleUIState(state);
        A1();
        if (state instanceof ShortcutAioUIState.ShowSubmenu) {
            j1((ShortcutAioUIState.ShowSubmenu) state);
        } else if (state instanceof ShortcutAioUIState.HideSubMenu) {
            i1();
        }
        aVar.b("TroopShortcutSubmenuVB", "handleUIState end");
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void handleCreateVM(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.handleCreateVM(context);
        this.aioContext = context;
    }
}
