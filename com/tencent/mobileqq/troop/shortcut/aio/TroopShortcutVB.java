package com.tencent.mobileqq.troop.shortcut.aio;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.appscenter.api.ITroopAppsApi;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.troop.shortcut.aio.ShortcutMenuMessage;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.mobileqq.troop.shortcut.ui.DisableParentInterceptFrameLayout;
import com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM;
import com.tencent.mobileqq.troop.utils.p;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.AppDetail;
import et2.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 h2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J)\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020 H\u0002J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\u001a\u0010(\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0002H\u0016J\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0005R$\u00109\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010@R$\u0010G\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R*\u0010c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0_j\b\u0012\u0004\u0012\u00020\u001a``0^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010b\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB;", "Let2/c;", "", HippyTKDListViewAdapter.X, "isNoResume", "", "I", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;", "detail", "isCustomShortCut", BdhLogUtil.LogTag.Tag_Conn, "(Ljava/lang/Long;Lcom/tencent/qqnt/kernel/nativeinterface/AppDetail;Z)V", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "u", DomainData.DOMAIN_NAME, "B", "Lts2/f;", "bindingNotNull", "v", "w", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "isTroopAppEcho", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ReportConstant.COSTREPORT_PREFIX, "G", "", "r", "Landroid/view/View;", "getView", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutParams", "Let2/c$a;", "callback", "d", "destroy", "Let2/b;", "c", "show", "hide", "pause", "a", "isMsgSelect", "b", "D", "K", "Lts2/f;", "p", "()Lts2/f;", "setBinding", "(Lts2/f;)V", "binding", "Lcom/tencent/aio/api/runtime/a;", "getAioContext", "()Lcom/tencent/aio/api/runtime/a;", "setAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "linearLayoutManager", "Let2/c$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Let2/c$a;", "setParentCallback", "(Let2/c$a;)V", "parentCallback", "Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM;", "e", "Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM;", "vm", "Lcom/tencent/mobileqq/troop/shortcut/adapter/b;", "f", "Lcom/tencent/mobileqq/troop/shortcut/adapter/b;", "shortcutAdapter", "Lcom/tencent/mobileqq/troop/shortcut/action/a;", "g", "Lcom/tencent/mobileqq/troop/shortcut/action/a;", "actionExecutor", "Lcom/tencent/mobileqq/troop/shortcut/custom/a;", tl.h.F, "Lcom/tencent/mobileqq/troop/shortcut/custom/a;", "customTroopShortcutContainer", "i", "Z", "isActive", "()Z", "setActive", "(Z)V", "Landroidx/lifecycle/Observer;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "Landroidx/lifecycle/Observer;", "listObserver", "k", "settingObserver", "<init>", "()V", "l", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShortcutVB implements et2.c {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static final int f298480m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f298481n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ts2.f binding;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayoutManager linearLayoutManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c.a parentCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopShortcutVM vm;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.shortcut.adapter.b shortcutAdapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.shortcut.action.a actionExecutor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.shortcut.custom.a customTroopShortcutContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isActive;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<ArrayList<TroopShortcutInfo>> listObserver;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> settingObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB$a;", "", "", "ELEMENT_ID", "Ljava/lang/String;", "EVENT_CLCK", "EVENT_IMP", "", "ITEM_GAP_PX", "I", "KEY_ICON_MORE", "PG_AIO", "PG_ID", "RECYCLERVIEW_LEFT_GAP", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutVB$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = TroopShortcutVB.f298480m;
            if (parent.getChildAdapterPosition(view) == 0) {
                i3 = TroopShortcutVB.f298481n;
            }
            outRect.left = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB$c", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@Nullable View v3) {
            ViewParent parent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
            } else if (v3 != null && (parent = v3.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@Nullable View v3) {
            ViewParent parent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
            } else if (v3 != null && (parent = v3.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55244);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        INSTANCE = new Companion(null);
        ViewUtils viewUtils = ViewUtils.f352270a;
        f298480m = viewUtils.a(6.0f);
        f298481n = viewUtils.a(16.0f);
    }

    public TroopShortcutVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.actionExecutor = new com.tencent.mobileqq.troop.shortcut.action.a();
        this.customTroopShortcutContainer = new com.tencent.mobileqq.troop.shortcut.custom.a(this);
        this.listObserver = new Observer() { // from class: com.tencent.mobileqq.troop.shortcut.aio.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopShortcutVB.y(TroopShortcutVB.this, (ArrayList) obj);
            }
        };
        this.settingObserver = new Observer() { // from class: com.tencent.mobileqq.troop.shortcut.aio.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopShortcutVB.E(TroopShortcutVB.this, (Boolean) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A(TroopShortcutVB troopShortcutVB, TroopShortcutInfo troopShortcutInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        troopShortcutVB.z(troopShortcutInfo, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutVB", "onThemeChanged");
        ts2.f fVar = this.binding;
        if (fVar == null) {
            return;
        }
        fVar.f437389f.setItemViewCacheSize(Integer.MIN_VALUE);
        fVar.f437389f.getRecycledViewPool().clear();
        RecyclerView.Adapter adapter = fVar.f437389f.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        v(fVar);
    }

    private final void C(Long troopUin, AppDetail detail, boolean isCustomShortCut) {
        ArrayList<TroopShortcutInfo> arrayList;
        boolean z16;
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        AIOParam g16;
        Bundle l3;
        com.tencent.mobileqq.troop.shortcut.adapter.b bVar = this.shortcutAdapter;
        Boolean bool = null;
        if (bVar != null) {
            arrayList = bVar.i0();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVB", "openTroopAppsCapsule " + troopUin + " , " + detail.appId + " data is null");
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (g16 = aVar.g()) != null && (l3 = g16.l()) != null) {
            bool = Boolean.valueOf(l3.getBoolean(ITroopAIVoiceChatApi.PARAMS_KEY_IS_AI_VOICE_CHAT_ACTIVE, false));
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVB", "isAIVoice true " + troopUin + " , " + detail.appId + " ");
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 != null && (e17 = aVar2.e()) != null) {
                e17.h(InputEvent.AIOShortcutBarShow.f188563d);
            }
            com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
            if (aVar3 != null && (e16 = aVar3.e()) != null) {
                e16.h(InputEvent.ExitAIVoiceChatState.f188567d);
            }
            isCustomShortCut = true;
        }
        Iterator<TroopShortcutInfo> it = arrayList.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().c(), detail.appId)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0 && i3 < arrayList.size()) {
            LinearLayoutManager linearLayoutManager = this.linearLayoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPositionWithOffset(i3, 0);
            }
            TroopShortcutInfo troopShortcutInfo = arrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(troopShortcutInfo, "dataList[index]");
            z(troopShortcutInfo, isCustomShortCut);
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVB", troopUin + " detail" + detail.appId + ", " + isCustomShortCut + " index:" + i3);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TroopShortcutVB", "not find " + troopUin + " " + isCustomShortCut + " detail" + detail.appId + " index:" + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(TroopShortcutVB this$0, Boolean bool) {
        boolean z16;
        com.tencent.mobileqq.troop.shortcut.adapter.b bVar;
        ArrayList<TroopShortcutInfo> arrayList;
        MutableLiveData<ArrayList<TroopShortcutInfo>> Q1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.shortcutAdapter == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.D();
        if (z16 && (bVar = this$0.shortcutAdapter) != null) {
            TroopShortcutVM troopShortcutVM = this$0.vm;
            if (troopShortcutVM != null && (Q1 = troopShortcutVM.Q1()) != null) {
                arrayList = Q1.getValue();
            } else {
                arrayList = null;
            }
            if (arrayList == null) {
                return;
            }
            bVar.m0(arrayList);
        }
    }

    private final void F() {
        Context context;
        TroopShortcutVM troopShortcutVM;
        DisableParentInterceptFrameLayout root;
        ts2.f fVar = this.binding;
        if (fVar != null && (root = fVar.getRoot()) != null) {
            context = root.getContext();
        } else {
            context = null;
        }
        if (context != null && (troopShortcutVM = this.vm) != null) {
            ((ITroopAppsApi) QRoute.api(ITroopAppsApi.class)).openNewPage(context, String.valueOf(troopShortcutVM.O1()), 1);
        }
    }

    private final void G(final TroopShortcutInfo item, boolean isTroopAppEcho) {
        DisableParentInterceptFrameLayout root;
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        aVar.a("TroopShortcutVB", "showMenu");
        final com.tencent.aio.api.runtime.a b16 = this.actionExecutor.d().b();
        if (b16 == null) {
            aVar.c("TroopShortcutVB", "showMenu but aio context got null!");
            return;
        }
        if (isTroopAppEcho) {
            ts2.f fVar = this.binding;
            if (fVar != null && (root = fVar.getRoot()) != null) {
                root.post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcut.aio.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopShortcutVB.H(com.tencent.aio.api.runtime.a.this, item, this);
                    }
                });
                return;
            }
            return;
        }
        b16.e().h(new ShortcutMenuMessage.ShowSubmenu(item, this.actionExecutor, r()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(com.tencent.aio.api.runtime.a aioContext, TroopShortcutInfo item, TroopShortcutVB this$0) {
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        aioContext.e().h(new ShortcutMenuMessage.ShowSubmenu(item, this$0.actionExecutor, this$0.r()));
    }

    private final void I(boolean isNoResume) {
        Intent intent;
        Long l3;
        Object obj;
        boolean z16;
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        AIOParam g16;
        Bundle l16;
        Fragment c16;
        FragmentActivity activity;
        if (this.binding != null && this.shortcutAdapter != null) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            h.a aVar2 = null;
            if (aVar != null && (c16 = aVar.c()) != null && (activity = c16.getActivity()) != null) {
                intent = activity.getIntent();
            } else {
                intent = null;
            }
            if (intent != null && intent.hasExtra("key_troop_apps_capsule")) {
                Serializable serializableExtra = intent.getSerializableExtra("key_troop_apps_capsule");
                Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.AppDetail");
                AppDetail appDetail = (AppDetail) serializableExtra;
                boolean booleanExtra = intent.getBooleanExtra("key_troop_apps_open_capsule_switch", false);
                com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
                if (aVar3 != null && (g16 = aVar3.g()) != null && (l16 = g16.l()) != null) {
                    l3 = Long.valueOf(l16.getLong("key_peerUin"));
                } else {
                    l3 = null;
                }
                com.tencent.aio.api.runtime.a aVar4 = this.aioContext;
                if (aVar4 != null && (e17 = aVar4.e()) != null) {
                    obj = e17.k(PanelContainerMsgIntent.GetPanelContainerStateMsgIntent.f116805d);
                } else {
                    obj = null;
                }
                if (obj instanceof h.a) {
                    aVar2 = (h.a) obj;
                }
                if (aVar2 != null) {
                    z16 = aVar2.c();
                } else {
                    z16 = false;
                }
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVB", "troopAppRecovery " + l3 + " ,isPanelShow " + z16);
                boolean z17 = true;
                if (z16) {
                    com.tencent.aio.api.runtime.a aVar5 = this.aioContext;
                    if (aVar5 != null && (e16 = aVar5.e()) != null) {
                        e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("TroopShortcutVB", false));
                    }
                    booleanExtra = true;
                }
                if (isNoResume) {
                    booleanExtra = true;
                }
                intent.removeExtra("key_troop_apps_capsule");
                intent.removeExtra("key_troop_apps_open_capsule_switch");
                if (this.customTroopShortcutContainer.e()) {
                    this.customTroopShortcutContainer.close("topic");
                } else {
                    z17 = booleanExtra;
                }
                C(l3, appDetail, z17);
            }
        }
    }

    static /* synthetic */ void J(TroopShortcutVB troopShortcutVB, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        troopShortcutVB.I(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        Fragment c16;
        Context context;
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        aVar.b("TroopShortcutVB", "create view");
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 != null && (c16 = aVar2.c()) != null && (context = c16.getContext()) != null) {
            ts2.f g16 = ts2.f.g(LayoutInflater.from(context));
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(0);
            this.linearLayoutManager = linearLayoutManager;
            RecyclerView recyclerView = g16.f437389f;
            recyclerView.setLayoutManager(linearLayoutManager);
            com.tencent.mobileqq.troop.shortcut.adapter.b bVar = new com.tencent.mobileqq.troop.shortcut.adapter.b(new Function1<TroopShortcutInfo, Unit>() { // from class: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutVB$createView$2$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopShortcutInfo troopShortcutInfo) {
                    invoke2(troopShortcutInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopShortcutInfo item) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
                    } else {
                        Intrinsics.checkNotNullParameter(item, "item");
                        TroopShortcutVB.A(TroopShortcutVB.this, item, false, 2, null);
                    }
                }
            });
            this.shortcutAdapter = bVar;
            recyclerView.setAdapter(bVar);
            recyclerView.addItemDecoration(new b());
            ImageView imageView = g16.f437386c;
            Intrinsics.checkNotNullExpressionValue(imageView, "bindingNotNull.iconMore");
            TriggerRunnerKt.c(imageView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.shortcut.aio.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopShortcutVB.o(TroopShortcutVB.this, view);
                }
            }, 1, null);
            g16.getRoot().addOnAttachStateChangeListener(new c());
            this.binding = g16;
            v(g16);
            w(g16);
            this.customTroopShortcutContainer.g();
            g16.getRoot().setOnSkinChangedCallback(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutVB$createView$5
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        TroopShortcutVB.this.B();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
            aVar.b("TroopShortcutVB", "create view end");
            return;
        }
        aVar.c("TroopShortcutVB", "create view failed for context is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(TroopShortcutVB this$0, View view) {
        Map mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("qq_pgid", "pg_aio"), TuplesKt.to("qq_eid", "em_group_app_capsule_more"));
        VideoReport.reportEvent("qq_clck", view, mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int r() {
        DisableParentInterceptFrameLayout root;
        int[] iArr = new int[2];
        for (int i3 = 0; i3 < 2; i3++) {
            iArr[i3] = 0;
        }
        ts2.f fVar = this.binding;
        if (fVar != null && (root = fVar.getRoot()) != null) {
            root.getLocationInWindow(iArr);
        }
        return iArr[1];
    }

    private final void s() {
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        aVar.a("TroopShortcutVB", "hideMenu");
        com.tencent.aio.api.runtime.a b16 = this.actionExecutor.d().b();
        if (b16 == null) {
            aVar.c("TroopShortcutVB", "showMenu but aio context got null!");
        } else {
            b16.e().h(ShortcutMenuMessage.HideSubMenu.f298461d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(TroopShortcutVB this$0, com.tencent.aio.api.runtime.a aVar, Fragment it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        if (!this$0.isActive) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TroopShortcutVB", "initData failed for isActive false, impossible");
            return;
        }
        this$0.actionExecutor.f(aVar);
        this$0.u(it, aVar);
        this$0.customTroopShortcutContainer.h(aVar);
    }

    private final void u(Fragment fragment, com.tencent.aio.api.runtime.a aioContext) {
        TroopShortcutVM troopShortcutVM = new TroopShortcutVM();
        this.vm = troopShortcutVM;
        troopShortcutVM.T1(aioContext);
        TroopShortcutVM.Z1(troopShortcutVM, false, null, 3, null);
        troopShortcutVM.Q1().observeForever(this.listObserver);
        troopShortcutVM.U1().observeForever(this.settingObserver);
    }

    private final void v(ts2.f bindingNotNull) {
        int defaultColor = bindingNotNull.getRoot().getContext().getColorStateList(R.color.qui_common_bg_nav_bottom_aio).getDefaultColor();
        int i3 = 0;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{16777215 & defaultColor, defaultColor});
        gradientDrawable.setGradientType(0);
        bindingNotNull.f437388e.setBackground(gradientDrawable);
        View view = bindingNotNull.f437388e;
        if (QQTheme.isVasTheme()) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private final void w(ts2.f bindingNotNull) {
        Map mapOf;
        ImageView imageView = bindingNotNull.f437386c;
        Intrinsics.checkNotNullExpressionValue(imageView, "bindingNotNull.iconMore");
        VideoReport.setElementId(imageView, "em_group_app_capsule_more");
        VideoReport.setElementExposePolicy(imageView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(imageView, ClickPolicy.REPORT_NONE);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("qq_pgid", "pg_aio"), TuplesKt.to("qq_eid", "em_group_app_capsule_more"));
        VideoReport.reportEvent("qq_imp", imageView, mapOf);
    }

    private final boolean x() {
        com.tencent.mvi.base.route.k kVar;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        h.a aVar2 = null;
        if (aVar != null && (e16 = aVar.e()) != null) {
            kVar = e16.k(PanelContainerMsgIntent.GetPanelContainerStateMsgIntent.f116805d);
        } else {
            kVar = null;
        }
        if (kVar instanceof h.a) {
            aVar2 = (h.a) kVar;
        }
        if (aVar2 != null) {
            return aVar2.c();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(TroopShortcutVB this$0, ArrayList list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
        com.tencent.mobileqq.troop.shortcut.adapter.b bVar = this$0.shortcutAdapter;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(list, "list");
            bVar.m0(list);
        }
        this$0.I(true);
    }

    private final void z(TroopShortcutInfo item, boolean isTroopAppEcho) {
        boolean z16 = true;
        if (!item.e().isEmpty()) {
            if (item.h()) {
                s();
                return;
            } else {
                G(item, isTroopAppEcho);
                return;
            }
        }
        TroopShortcutVM troopShortcutVM = this.vm;
        if (troopShortcutVM == null || !troopShortcutVM.W1()) {
            z16 = false;
        }
        if (z16) {
            s();
        }
        TroopShortcutAction a16 = item.a();
        if (a16 != null) {
            this.actionExecutor.c(a16, TroopShortcutVB$onItemClick$1$1.INSTANCE);
        }
    }

    public final void D() {
        int i3;
        boolean z16;
        Boolean bool;
        ConstraintLayout constraintLayout;
        MutableLiveData<Boolean> U1;
        MutableLiveData<ArrayList<TroopShortcutInfo>> Q1;
        ArrayList<TroopShortcutInfo> value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        TroopShortcutVM troopShortcutVM = this.vm;
        int i16 = 0;
        if (troopShortcutVM != null && (Q1 = troopShortcutVM.Q1()) != null && (value = Q1.getValue()) != null) {
            i3 = value.size();
        } else {
            i3 = 0;
        }
        boolean z17 = true;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        TroopShortcutVM troopShortcutVM2 = this.vm;
        if (troopShortcutVM2 == null || (U1 = troopShortcutVM2.U1()) == null || (bool = U1.getValue()) == null) {
            bool = Boolean.FALSE;
        }
        boolean booleanValue = bool.booleanValue();
        boolean e16 = this.customTroopShortcutContainer.e();
        if (QLog.isColorLevel()) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVB", hashCode() + " checkShouldShow:" + z16 + "," + booleanValue + ",isShowingCustomShortcut:" + e16);
        }
        if (!z16 || !booleanValue || e16) {
            z17 = false;
        }
        if (z17) {
            K();
        }
        ts2.f fVar = this.binding;
        if (fVar != null) {
            constraintLayout = fVar.f437387d;
        } else {
            constraintLayout = null;
        }
        if (constraintLayout != null) {
            if (!z17) {
                i16 = 8;
            }
            constraintLayout.setVisibility(i16);
        }
    }

    public final void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            if (this.binding != null) {
                return;
            }
            p.f302196a.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutVB$tryCreateAndAttachView$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopShortcutVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Unit unit;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TroopShortcutVB.this.p() != null) {
                        return;
                    }
                    TroopShortcutVB.this.n();
                    c.a q16 = TroopShortcutVB.this.q();
                    if (q16 != null) {
                        q16.a();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TroopShortcutVB", "resumePanel failed for parentCallback is null, impossible");
                    }
                }
            });
        }
    }

    @Override // et2.c
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            J(this, false, 1, null);
        }
    }

    @Override // et2.c
    public void b(boolean isMsgSelect) {
        ml3.b b16;
        com.tencent.aio.frame.api.e eVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, isMsgSelect);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (b16 = aVar.b()) != null && (eVar = (com.tencent.aio.frame.api.e) b16.b(com.tencent.aio.frame.api.e.class)) != null) {
            eVar.h(!isMsgSelect);
        }
    }

    @Override // et2.c
    @NotNull
    public et2.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (et2.b) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.customTroopShortcutContainer;
    }

    @Override // et2.c
    public void d(@Nullable final com.tencent.aio.api.runtime.a aioContext, @NotNull c.a callback) {
        final Fragment c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aioContext, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.isActive = true;
        this.aioContext = aioContext;
        this.parentCallback = callback;
        if (aioContext != null && (c16 = aioContext.c()) != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcut.aio.i
                @Override // java.lang.Runnable
                public final void run() {
                    TroopShortcutVB.t(TroopShortcutVB.this, aioContext, c16);
                }
            });
        } else {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.c("TroopShortcutVB", "init failed for got null fragment!");
        }
    }

    @Override // et2.c
    public void destroy() {
        DisableParentInterceptFrameLayout root;
        MutableLiveData<Boolean> U1;
        MutableLiveData<ArrayList<TroopShortcutInfo>> Q1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.isActive = false;
        TroopShortcutVM troopShortcutVM = this.vm;
        if (troopShortcutVM != null && (Q1 = troopShortcutVM.Q1()) != null) {
            Q1.removeObserver(this.listObserver);
        }
        TroopShortcutVM troopShortcutVM2 = this.vm;
        if (troopShortcutVM2 != null && (U1 = troopShortcutVM2.U1()) != null) {
            U1.removeObserver(this.settingObserver);
        }
        this.actionExecutor.b();
        TroopShortcutVM troopShortcutVM3 = this.vm;
        if (troopShortcutVM3 != null) {
            troopShortcutVM3.destroy();
        }
        ts2.f fVar = this.binding;
        if (fVar != null && (root = fVar.getRoot()) != null && root.getParent() != null && (root.getParent() instanceof ViewGroup)) {
            ViewParent parent = root.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(root);
        }
    }

    @Override // et2.c
    @NotNull
    public ViewGroup.LayoutParams getLayoutParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // et2.c
    @Nullable
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ts2.f fVar = this.binding;
        if (fVar != null) {
            return fVar.getRoot();
        }
        return null;
    }

    @Override // et2.c
    public void hide() {
        DisableParentInterceptFrameLayout root;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVB", "hide");
        ts2.f fVar = this.binding;
        if (fVar != null && (root = fVar.getRoot()) != null) {
            root.setVisibility(8);
        }
        s();
    }

    @Nullable
    public final ts2.f p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ts2.f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.binding;
    }

    @Override // et2.c
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutVB", "pause");
            s();
        }
    }

    @Nullable
    public final c.a q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (c.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.parentCallback;
    }

    @Override // et2.c
    public void show() {
        ImageView imageView;
        DisableParentInterceptFrameLayout root;
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        ts2.f fVar = this.binding;
        if (fVar != null && (recyclerView = fVar.f437389f) != null && (recycledViewPool = recyclerView.getRecycledViewPool()) != null) {
            recycledViewPool.clear();
        }
        if (!x()) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVB", "show");
            ts2.f fVar2 = this.binding;
            if (fVar2 != null && (root = fVar2.getRoot()) != null) {
                root.setVisibility(0);
            }
            ts2.f fVar3 = this.binding;
            if (fVar3 != null && (imageView = fVar3.f437386c) != null) {
                VideoReport.reportEvent("qq_imp", imageView, null);
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.b("TroopShortcutVB", "show but plus panel is showing, return");
    }
}
