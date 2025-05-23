package com.tencent.mobileqq.aio.notification.list;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.base.AIONotificationEvent;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.aio.notification.base.d;
import com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter;
import com.tencent.mobileqq.aio.notification.list.AIONotificationItemView;
import com.tencent.mobileqq.aio.notification.list.c;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015*\u0001\"\u0018\u0000 e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0006fghijkB\u0017\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u0010E\u001a\u00020C\u00a2\u0006\u0004\bc\u0010dJ\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u001c\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010&\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0002H\u0002J\u000e\u0010*\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,J\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\nJ\u0006\u00101\u001a\u00020\nJ\u0006\u00102\u001a\u00020\nJ\u0018\u00106\u001a\u00020\u00032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u0010H\u0016J\u0018\u00109\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0010H\u0016J\u0010\u0010:\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0010H\u0016J\u0010\u0010<\u001a\u00020;2\u0006\u00107\u001a\u00020\u0003H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u00107\u001a\u00020\u0003H\u0016J\b\u0010>\u001a\u00020\nH\u0016R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010DR&\u0010I\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020,0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR \u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010HR\"\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020W0T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010HR\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010KR\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010KR\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010KR\u0016\u0010b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$b;", "Lcom/tencent/mobileqq/aio/notification/list/c$b;", "Lcom/tencent/mobileqq/aio/notification/list/c$a;", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "", "list", "", "u0", "R0", "", "isUpdateRecyclerViewHeight", "L0", "", "type", "B0", "V0", "T0", "removedNotification", "A0", "notificationType", "x0", "updateListAfterRemove", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$Companion$ListStatus;", "status", "Y0", "Q0", "E0", "J0", "K0", "itemData", "com/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$f", "z0", "(Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;)Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$f;", "F0", "I0", "D0", "v0", "H0", "t0", "X0", "", "token", "U0", "y0", "C0", "W0", "w0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "O0", "holder", "position", "N0", "getItemViewType", "Lcom/tencent/mobileqq/aio/notification/list/c$b$a;", "B", BdhLogUtil.LogTag.Tag_Conn, "P", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/aio/notification/list/j;", "Lcom/tencent/mobileqq/aio/notification/list/j;", "viewModel", "", "D", "Ljava/util/Map;", "dataMap", "E", "Ljava/util/List;", "reportedExpandNotification", "Landroid/os/Handler;", UserInfo.SEX_FEMALE, "Landroid/os/Handler;", "handler", "G", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$Companion$ListStatus;", "listStatus", "", "H", "expandStatusMap", "", "I", "itemPositionList", "J", "oldItemDataList", "K", "newItemDataList", "L", "pendingAddNotificationList", "M", "Z", "isClearBtnShowing", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/tencent/mobileqq/aio/notification/list/j;)V", "N", "a", "b", "Companion", "c", "d", "e", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationAdapter extends ListAdapter<a, b> implements c.b, c.a {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Map<Integer, Integer> P;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final j viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, List<IAIONotificationUIModel>> dataMap;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<String> reportedExpandNotification;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Companion.ListStatus listStatus;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, Boolean> expandStatusMap;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Map<a, Float> itemPositionList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private List<a> oldItemDataList;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private List<a> newItemDataList;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private List<IAIONotificationUIModel> pendingAddNotificationList;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isClearBtnShowing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$Companion;", "", "", "", "NOTIFICATION_TYPE_NAME_MAP", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "HEADER_ITEM_DEFAULT_Z_POSITION", UserInfo.SEX_FEMALE, "", "PROCESS_PENDING_LIST_INTERVAL_TIME_MS", "J", "", "TAG", "Ljava/lang/String;", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_NOTIFICATION", "<init>", "()V", "ListStatus", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$Companion$ListStatus;", "", "(Ljava/lang/String;I)V", "STATUS_EXPANDING_LIST", "STATUS_CLOSING_LIST", "STATUS_FOLDING_LIST", "STATUS_UNFOLDING_LIST", "STATUS_NONE", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes11.dex */
        public static final class ListStatus {
            private static final /* synthetic */ ListStatus[] $VALUES;
            static IPatchRedirector $redirector_;
            public static final ListStatus STATUS_CLOSING_LIST;
            public static final ListStatus STATUS_EXPANDING_LIST;
            public static final ListStatus STATUS_FOLDING_LIST;
            public static final ListStatus STATUS_NONE;
            public static final ListStatus STATUS_UNFOLDING_LIST;

            private static final /* synthetic */ ListStatus[] $values() {
                return new ListStatus[]{STATUS_EXPANDING_LIST, STATUS_CLOSING_LIST, STATUS_FOLDING_LIST, STATUS_UNFOLDING_LIST, STATUS_NONE};
            }

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54294);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                    return;
                }
                STATUS_EXPANDING_LIST = new ListStatus("STATUS_EXPANDING_LIST", 0);
                STATUS_CLOSING_LIST = new ListStatus("STATUS_CLOSING_LIST", 1);
                STATUS_FOLDING_LIST = new ListStatus("STATUS_FOLDING_LIST", 2);
                STATUS_UNFOLDING_LIST = new ListStatus("STATUS_UNFOLDING_LIST", 3);
                STATUS_NONE = new ListStatus("STATUS_NONE", 4);
                $VALUES = $values();
            }

            ListStatus(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
                }
            }

            public static ListStatus valueOf(String str) {
                return (ListStatus) Enum.valueOf(ListStatus.class, str);
            }

            public static ListStatus[] values() {
                return (ListStatus[]) $VALUES.clone();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Map<Integer, Integer> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return AIONotificationAdapter.P;
            }
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
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
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "itemData", "", "l", "E", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;)V", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static abstract class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        public a itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            }
        }

        public abstract void l(@NotNull a itemData);

        @NotNull
        public final a m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = this.itemData;
            if (aVar != null) {
                return aVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            return null;
        }

        public final void n(@NotNull a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            } else {
                Intrinsics.checkNotNullParameter(aVar, "<set-?>");
                this.itemData = aVar;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$c;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "itemData", "", "dataList", "", "c", "oldItem", "newItem", "b", "a", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c extends DiffUtil.ItemCallback<a> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final RecyclerView recyclerView;

        public c(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView);
            } else {
                this.recyclerView = recyclerView;
            }
        }

        private final boolean c(a itemData, List<a> dataList) {
            int indexOf = dataList.indexOf(itemData);
            if (indexOf < 0) {
                return false;
            }
            if (indexOf != 0) {
                int i3 = indexOf - 1;
                if (dataList.get(i3).b() == itemData.b() && dataList.get(i3).getDataType() != 1) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull a oldItem, @NotNull a newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            boolean z16 = true;
            if (oldItem.getDataType() == 1 || oldItem.getDataType() != newItem.getDataType() || !Intrinsics.areEqual(oldItem.a(), newItem.a())) {
                z16 = false;
            }
            QLog.i("AIONotificationAdapter", 2, "areContentsTheSame oldItem:" + oldItem + ", newItem:" + newItem + ", result=" + z16);
            return z16;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean areItemsTheSame(@NotNull a oldItem, @NotNull a newItem) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter");
            AIONotificationAdapter aIONotificationAdapter = (AIONotificationAdapter) adapter;
            if (oldItem.b() == newItem.b()) {
                int dataType = oldItem.getDataType();
                z16 = true;
                if (dataType == 1) {
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AIONotificationAdapter", 2, "areItemsTheSame oldItem:" + oldItem + ", newItem:" + newItem + ", result=" + z16);
                }
                return z16;
            }
            z16 = false;
            if (QLog.isColorLevel()) {
            }
            return z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$d;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$b;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a$c;", "itemData", "", "r", "p", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "l", "Lp81/g;", UserInfo.SEX_FEMALE, "Lp81/g;", "viewBinding", "<init>", "(Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter;Lp81/g;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class d extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final p81.g viewBinding;
        final /* synthetic */ AIONotificationAdapter G;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public d(@NotNull AIONotificationAdapter aIONotificationAdapter, p81.g viewBinding) {
            super(r0);
            Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
            this.G = aIONotificationAdapter;
            RelativeLayout root = viewBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIONotificationAdapter, (Object) viewBinding);
            } else {
                this.viewBinding = viewBinding;
            }
        }

        private final void p(final a.c itemData) {
            if (itemData.b() == 3) {
                this.G.isClearBtnShowing = true;
                com.tencent.mobileqq.aio.utils.b.f194119a.p("em_group_one_click_clear");
                TextView textView = this.viewBinding.f425740b;
                final AIONotificationAdapter aIONotificationAdapter = this.G;
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.list.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AIONotificationAdapter.d.q(AIONotificationAdapter.this, itemData, view);
                    }
                });
                return;
            }
            this.G.isClearBtnShowing = false;
            this.viewBinding.f425740b.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(AIONotificationAdapter this$0, a.c itemData, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(itemData, "$itemData");
            this$0.x0(itemData.b());
            com.tencent.mobileqq.aio.utils.b.f194119a.k("em_group_one_click_clear");
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void r(a.c itemData) {
            int i3;
            TextView textView = (TextView) this.viewBinding.getRoot().findViewById(R.id.sjd);
            Integer num = AIONotificationAdapter.INSTANCE.a().get(Integer.valueOf(itemData.b()));
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            textView.setText(this.viewBinding.getRoot().getContext().getString(R.string.ys7, HardCodeUtil.qqStr(i3), String.valueOf(itemData.c())));
            this.viewBinding.getRoot().animate().setInterpolator(null);
        }

        @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.b
        public void l(@NotNull a itemData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) itemData);
                return;
            }
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            n(itemData);
            a.c cVar = (a.c) itemData;
            r(cVar);
            p(cVar);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$e;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$b;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "itemData", "", "l", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView;", "o", "()Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView;", "view", "<init>", "(Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter;Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class e extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final AIONotificationItemView view;
        final /* synthetic */ AIONotificationAdapter G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull AIONotificationAdapter aIONotificationAdapter, AIONotificationItemView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.G = aIONotificationAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIONotificationAdapter, (Object) view);
            } else {
                this.view = view;
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.b
        public void l(@NotNull a itemData) {
            boolean z16;
            Object first;
            List reversed;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) itemData);
                return;
            }
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            n(itemData);
            boolean z17 = itemData instanceof a.b;
            if (z17) {
                ArrayList arrayList = new ArrayList();
                a.b bVar = (a.b) itemData;
                z16 = bVar.e();
                reversed = CollectionsKt___CollectionsKt.reversed(bVar.c());
                arrayList.addAll(reversed);
                if (z16) {
                    CollectionsKt__MutableCollectionsKt.removeLastOrNull(arrayList);
                }
                this.view.q(itemData.b(), arrayList, this.G.J0(), this.G.z0(itemData));
                if (((a.b) itemData).d()) {
                    this.view.d();
                }
            } else {
                if (itemData instanceof a.d) {
                    this.view.p(itemData.b(), ((a.d) itemData).c(), this.G.J0(), this.G.z0(itemData));
                }
                z16 = false;
            }
            if (z16 && z17) {
                AIONotificationItemView aIONotificationItemView = this.view;
                a.b bVar2 = (a.b) itemData;
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) bVar2.c());
                Intrinsics.checkNotNullExpressionValue(first, "itemData.notificationList.first()");
                AIONotificationItemView.f(aIONotificationItemView, (IAIONotificationUIModel) first, false, 2, null);
                bVar2.g(false);
            }
        }

        @NotNull
        public final AIONotificationItemView o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AIONotificationItemView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.view;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$f", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView$a;", "", "type", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView;", "currentView", "oldHeight", "newHeight", "", "b", "c", "d", "a", "e", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class f implements AIONotificationItemView.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f192911a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIONotificationAdapter f192912b;

        f(a aVar, AIONotificationAdapter aIONotificationAdapter) {
            this.f192911a = aVar;
            this.f192912b = aIONotificationAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aIONotificationAdapter);
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationItemView.a
        public void a(@NotNull AIONotificationItemView currentView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) currentView);
            } else {
                Intrinsics.checkNotNullParameter(currentView, "currentView");
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationItemView.a
        public void b(int type, @NotNull AIONotificationItemView currentView, int oldHeight, int newHeight) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(type), currentView, Integer.valueOf(oldHeight), Integer.valueOf(newHeight));
                return;
            }
            Intrinsics.checkNotNullParameter(currentView, "currentView");
            a aVar = this.f192911a;
            if ((aVar instanceof a.b) && ((a.b) aVar).f()) {
                AIONotificationUIUtils.f192828a.a0(currentView, newHeight);
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationItemView.a
        public void c(int type, @NotNull AIONotificationItemView currentView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, type, (Object) currentView);
            } else {
                Intrinsics.checkNotNullParameter(currentView, "currentView");
            }
        }

        @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationItemView.a
        public void d(@NotNull AIONotificationItemView currentView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) currentView);
                return;
            }
            Intrinsics.checkNotNullParameter(currentView, "currentView");
            a aVar = this.f192911a;
            if ((aVar instanceof a.b) && ((a.b) aVar).f()) {
                AIONotificationAdapter.Z0(this.f192912b, true, null, 2, null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationItemView.a
        public void e(int type) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, type);
                return;
            }
            com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) this.f192912b.viewModel.getMContext()).e();
            if (e16 != null) {
                e16.h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent("AIOBubbleMsgItemVM", false, 2, null));
            }
            this.f192912b.B0(this.f192911a.b());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$g", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "onItemRangeInserted", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class g extends RecyclerView.AdapterDataObserver {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationAdapter.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(positionStart), Integer.valueOf(itemCount));
                return;
            }
            super.onItemRangeInserted(positionStart, itemCount);
            AIONotificationAdapter.this.unregisterAdapterDataObserver(this);
            AIONotificationAdapter.this.recyclerView.scrollToPosition(0);
        }
    }

    static {
        Map<Integer, Integer> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54328);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        INSTANCE = new Companion(null);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, Integer.valueOf(R.string.ys9)), TuplesKt.to(2, Integer.valueOf(R.string.ys_)), TuplesKt.to(3, Integer.valueOf(R.string.ys8)));
        P = mapOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIONotificationAdapter(@NotNull RecyclerView recyclerView, @NotNull j viewModel) {
        super(new c(recyclerView));
        Map<Integer, List<IAIONotificationUIModel>> mapOf;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recyclerView, (Object) viewModel);
            return;
        }
        this.recyclerView = recyclerView;
        this.viewModel = viewModel;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new ArrayList()), TuplesKt.to(2, new ArrayList()), TuplesKt.to(3, new ArrayList()));
        this.dataMap = mapOf;
        this.reportedExpandNotification = new ArrayList();
        this.listStatus = Companion.ListStatus.STATUS_NONE;
        this.expandStatusMap = new LinkedHashMap();
        this.itemPositionList = new LinkedHashMap();
        this.oldItemDataList = new ArrayList();
        this.newItemDataList = new ArrayList();
        this.pendingAddNotificationList = new ArrayList();
        Iterator<Integer> it = mapOf.keySet().iterator();
        while (it.hasNext()) {
            this.expandStatusMap.put(Integer.valueOf(it.next().intValue()), Boolean.FALSE);
        }
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final boolean A0(IAIONotificationUIModel removedNotification) {
        View childAt;
        RecyclerView.ViewHolder childViewHolder;
        int childCount = this.recyclerView.getChildCount();
        this.itemPositionList.clear();
        boolean z16 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
            if (layoutManager != null && (childAt = layoutManager.getChildAt(i3)) != null && (childViewHolder = this.recyclerView.getChildViewHolder(childAt)) != null) {
                Intrinsics.checkNotNullExpressionValue(childViewHolder, "getChildViewHolder(view)");
                if (childViewHolder instanceof e) {
                    e eVar = (e) childViewHolder;
                    if (eVar.m().getDataType() == 2 && Intrinsics.areEqual(eVar.m().a(), removedNotification.getToken())) {
                        a m3 = eVar.m();
                        Intrinsics.checkNotNull(m3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.BaseItemData.FoldedNotificationItemData");
                        ((a.b) m3).h(true);
                        AIONotificationItemView.x((AIONotificationItemView) childAt, removedNotification.getToken(), false, 2, null);
                        z16 = true;
                    }
                }
                this.itemPositionList.put(((b) childViewHolder).m(), Float.valueOf(childAt.getY()));
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B0(int type) {
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) this.viewModel.getMContext()).e();
        if (e16 != null) {
            e16.h(AIONotificationEvent.ExpandListEvent.f192821d);
        }
        if (!J0()) {
            registerAdapterDataObserver(new g());
        }
        this.expandStatusMap.put(Integer.valueOf(type), Boolean.TRUE);
        T0();
        Z0(this, false, Companion.ListStatus.STATUS_EXPANDING_LIST, 1, null);
        V0();
    }

    private final int D0() {
        View childAt;
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        if (layoutManager == null || (childAt = layoutManager.getChildAt(0)) == null) {
            return 0;
        }
        return (int) childAt.getY();
    }

    private final int E0() {
        Iterator<Boolean> it = this.expandStatusMap.values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                i3++;
            }
        }
        return i3;
    }

    private final int F0(IAIONotificationUIModel uiModel) {
        d.a aVar = com.tencent.mobileqq.aio.notification.base.d.f192838a.a().get(uiModel.b());
        if (aVar != null) {
            return aVar.e();
        }
        return 3;
    }

    private final int H0(a itemData) {
        List<IAIONotificationUIModel> list = this.dataMap.get(Integer.valueOf(itemData.b()));
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (Intrinsics.areEqual(list.get(i3).getToken(), itemData.a())) {
                    return i3;
                }
            }
        }
        return 0;
    }

    private final int I0() {
        Iterator<List<IAIONotificationUIModel>> it = this.dataMap.values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J0() {
        Iterator<Boolean> it = this.expandStatusMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private final boolean K0(int notificationType) {
        Companion.ListStatus listStatus = this.listStatus;
        if (listStatus != Companion.ListStatus.STATUS_EXPANDING_LIST && listStatus != Companion.ListStatus.STATUS_CLOSING_LIST) {
            RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                while (true) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = this.recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                    if (findViewHolderForAdapterPosition instanceof e) {
                        e eVar = (e) findViewHolderForAdapterPosition;
                        if (eVar.m().getDataType() != 1 && eVar.m().b() == notificationType) {
                            return true;
                        }
                    }
                    if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                        break;
                    }
                    findFirstVisibleItemPosition++;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L0(boolean isUpdateRecyclerViewHeight) {
        float f16;
        Boolean bool;
        boolean z16 = true;
        if (this.listStatus == Companion.ListStatus.STATUS_FOLDING_LIST) {
            for (List<IAIONotificationUIModel> list : this.dataMap.values()) {
                if (!list.isEmpty()) {
                    com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) this.viewModel.getMContext()).e();
                    if (e16 != null) {
                        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
                        Context context = this.recyclerView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "recyclerView.context");
                        float w3 = aIONotificationUIUtils.w(context);
                        Context context2 = this.recyclerView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "recyclerView.context");
                        float B = w3 + aIONotificationUIUtils.B(context2, list.get(0));
                        Context context3 = this.recyclerView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "recyclerView.context");
                        e16.h(new AIONotificationEvent.UpdateContainerSizeEvent((int) (B + aIONotificationUIUtils.A(context3)), 0));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<Integer, List<IAIONotificationUIModel>> entry : this.dataMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            List<IAIONotificationUIModel> value = entry.getValue();
            if (!value.isEmpty() && (bool = this.expandStatusMap.get(Integer.valueOf(intValue))) != null) {
                if (bool.booleanValue()) {
                    linkedHashMap2.put(Integer.valueOf(intValue), value);
                } else {
                    linkedHashMap.put(Integer.valueOf(intValue), value);
                }
            }
        }
        AIONotificationUIUtils aIONotificationUIUtils2 = AIONotificationUIUtils.f192828a;
        Context context4 = this.recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "recyclerView.context");
        float s16 = aIONotificationUIUtils2.s(context4);
        Context context5 = this.recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "recyclerView.context");
        float w16 = s16 + aIONotificationUIUtils2.w(context5);
        float f17 = 0.0f;
        if (J0()) {
            Iterator<List<IAIONotificationUIModel>> it = this.dataMap.values().iterator();
            f16 = 0.0f;
            while (it.hasNext()) {
                if (it.next().size() > 0) {
                    f16 += w16;
                }
            }
        } else {
            f16 = 0.0f;
        }
        AIONotificationUIUtils aIONotificationUIUtils3 = AIONotificationUIUtils.f192828a;
        Context context6 = this.recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "recyclerView.context");
        float j3 = aIONotificationUIUtils3.j(context6, linkedHashMap);
        Context context7 = this.recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "recyclerView.context");
        float i3 = f16 + j3 + aIONotificationUIUtils3.i(context7, linkedHashMap2);
        if (J0()) {
            Context context8 = this.recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context8, "recyclerView.context");
            f17 = aIONotificationUIUtils3.p(context8);
        }
        Context context9 = this.recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context9, "recyclerView.context");
        int i16 = (int) f17;
        float y16 = aIONotificationUIUtils3.y(context9) - i16;
        if (i3 <= y16) {
            z16 = false;
        }
        float min = Math.min(i3, y16);
        if (isUpdateRecyclerViewHeight) {
            com.tencent.mvi.base.route.j e17 = ((com.tencent.aio.api.runtime.a) this.viewModel.getMContext()).e();
            if (e17 != null) {
                e17.h(new AIONotificationEvent.UpdateRecyclerViewHeightEvent((int) min, z16));
                return;
            }
            return;
        }
        com.tencent.mvi.base.route.j e18 = ((com.tencent.aio.api.runtime.a) this.viewModel.getMContext()).e();
        if (e18 != null) {
            e18.h(new AIONotificationEvent.UpdateContainerSizeEvent((int) min, i16));
        }
    }

    static /* synthetic */ void M0(AIONotificationAdapter aIONotificationAdapter, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        aIONotificationAdapter.L0(z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Q0() {
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) this.viewModel.getMContext()).e();
        if (e16 != null) {
            e16.h(AIONotificationEvent.CloseListEvent.f192820d);
        }
        Iterator<Integer> it = this.dataMap.keySet().iterator();
        while (it.hasNext()) {
            this.expandStatusMap.put(Integer.valueOf(it.next().intValue()), Boolean.FALSE);
        }
    }

    private final void R0() {
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.list.a
            @Override // java.lang.Runnable
            public final void run() {
                AIONotificationAdapter.S0(AIONotificationAdapter.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(AIONotificationAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.pendingAddNotificationList.isEmpty()) {
            this$0.t0(this$0.pendingAddNotificationList.remove(0));
            if (!this$0.pendingAddNotificationList.isEmpty()) {
                this$0.R0();
            }
        }
    }

    private final void T0() {
        View childAt;
        RecyclerView.ViewHolder childViewHolder;
        int childCount = this.recyclerView.getChildCount();
        this.itemPositionList.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
            if (layoutManager != null && (childAt = layoutManager.getChildAt(i3)) != null && (childViewHolder = this.recyclerView.getChildViewHolder(childAt)) != null) {
                Intrinsics.checkNotNullExpressionValue(childViewHolder, "getChildViewHolder(view)");
                this.itemPositionList.put(((b) childViewHolder).m(), Float.valueOf(childAt.getY()));
            }
        }
    }

    private final void V0() {
        Iterator<Map.Entry<Integer, List<IAIONotificationUIModel>>> it = this.dataMap.entrySet().iterator();
        while (it.hasNext()) {
            for (IAIONotificationUIModel iAIONotificationUIModel : it.next().getValue()) {
                if (!this.reportedExpandNotification.contains(iAIONotificationUIModel.getToken())) {
                    AIONotificationUIUtils.f192828a.J(true, iAIONotificationUIModel);
                    this.reportedExpandNotification.add(iAIONotificationUIModel.getToken());
                }
            }
        }
    }

    private final void Y0(boolean updateListAfterRemove, Companion.ListStatus status) {
        List list;
        boolean z16;
        this.listStatus = status;
        List<a> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        this.oldItemDataList = currentList;
        ArrayList arrayList = new ArrayList();
        if (this.listStatus == Companion.ListStatus.STATUS_FOLDING_LIST) {
            Iterator<Map.Entry<Integer, List<IAIONotificationUIModel>>> it = this.dataMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Integer, List<IAIONotificationUIModel>> next = it.next();
                int intValue = next.getKey().intValue();
                List<IAIONotificationUIModel> value = next.getValue();
                if (!value.isEmpty()) {
                    arrayList.add(new a.b(intValue, new CopyOnWriteArrayList(value.subList(0, 1)), false, false, true, 8, null));
                    break;
                }
            }
            this.newItemDataList = arrayList;
            L0(true);
            submitList(arrayList);
            return;
        }
        for (Map.Entry<Integer, List<IAIONotificationUIModel>> entry : this.dataMap.entrySet()) {
            int intValue2 = entry.getKey().intValue();
            List<IAIONotificationUIModel> value2 = entry.getValue();
            if (!value2.isEmpty()) {
                if (J0()) {
                    arrayList.add(new a.c(intValue2, value2.size()));
                }
                if (!Intrinsics.areEqual(this.expandStatusMap.get(Integer.valueOf(intValue2)), Boolean.TRUE) && value2.size() != 1) {
                    list = CollectionsKt___CollectionsKt.toList(value2);
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
                    if (K0(intValue2) && !updateListAfterRemove) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    arrayList.add(new a.b(intValue2, copyOnWriteArrayList, z16, false, false, 24, null));
                } else {
                    Iterator<IAIONotificationUIModel> it5 = value2.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(new a.d(intValue2, it5.next()));
                    }
                }
            }
        }
        this.newItemDataList = arrayList;
        if (arrayList.size() == 0) {
            Q0();
        }
        L0(true);
        submitList(arrayList);
    }

    static /* synthetic */ void Z0(AIONotificationAdapter aIONotificationAdapter, boolean z16, Companion.ListStatus listStatus, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            listStatus = Companion.ListStatus.STATUS_NONE;
        }
        aIONotificationAdapter.Y0(z16, listStatus);
    }

    private final void u0(IAIONotificationUIModel uiModel, List<IAIONotificationUIModel> list) {
        int i3;
        int i16;
        d.a aVar = com.tencent.mobileqq.aio.notification.base.d.f192838a.a().get(uiModel.b());
        if (aVar != null) {
            i3 = aVar.c();
        } else {
            i3 = Integer.MAX_VALUE;
        }
        int size = list.size();
        int i17 = 0;
        int i18 = 0;
        while (i17 < size) {
            d.a aVar2 = com.tencent.mobileqq.aio.notification.base.d.f192838a.a().get(list.get(i17).b());
            if (aVar2 != null) {
                i16 = aVar2.c();
            } else {
                i16 = Integer.MAX_VALUE;
            }
            if (i3 <= i16) {
                break;
            }
            i18 = i17 + 1;
            i17 = i18;
        }
        list.add(i18, uiModel);
    }

    private final int v0(int notificationType) {
        int B;
        Context context = this.recyclerView.getContext();
        int i3 = 0;
        for (Map.Entry<Integer, List<IAIONotificationUIModel>> entry : this.dataMap.entrySet()) {
            int intValue = entry.getKey().intValue();
            List<IAIONotificationUIModel> value = entry.getValue();
            AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
            Context context2 = this.recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "recyclerView.context");
            i3 += (int) aIONotificationUIUtils.w(context2);
            if (intValue == notificationType) {
                break;
            }
            if (value.size() > 0) {
                if (Intrinsics.areEqual(this.expandStatusMap.get(Integer.valueOf(intValue)), Boolean.TRUE)) {
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    B = (int) aIONotificationUIUtils.B(context, value.get(0));
                } else {
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    B = ((int) aIONotificationUIUtils.B(context, value.get(0))) + ((int) aIONotificationUIUtils.A(context));
                }
                i3 += B;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x0(int notificationType) {
        boolean J0 = J0();
        List<IAIONotificationUIModel> list = this.dataMap.get(Integer.valueOf(notificationType));
        if (list != null) {
            for (IAIONotificationUIModel iAIONotificationUIModel : list) {
                Function2<IAIONotificationUIModel, Integer, Unit> eventCallback = iAIONotificationUIModel.getEventCallback();
                if (eventCallback != null) {
                    eventCallback.invoke(iAIONotificationUIModel, 100);
                }
                AIONotificationUIUtils.f192828a.K(J0, iAIONotificationUIModel);
            }
            list.clear();
        }
        Z0(this, false, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f z0(a itemData) {
        return new f(itemData, this);
    }

    @Override // com.tencent.mobileqq.aio.notification.list.c.b
    @NotNull
    public c.b.a B(@NotNull b holder) {
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (c.b.a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) holder);
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof d) {
            return new c.b.a(0.0f, 0.0f, 0.0f, -100.0f, 0.0f, 20, null);
        }
        Companion.ListStatus listStatus = this.listStatus;
        if (listStatus == Companion.ListStatus.STATUS_CLOSING_LIST) {
            float v06 = v0(holder.m().b()) - holder.itemView.getY();
            int H0 = H0(holder.m());
            if (holder.m().getDataType() == 1) {
                return new c.b.a(v06, 1.0f, 0.96f, -H0, 0.5f);
            }
            return new c.b.a(v06, 0.5f, 0.96f, -H0, 0.0f, 16, null);
        }
        if (listStatus == Companion.ListStatus.STATUS_FOLDING_LIST) {
            float D0 = D0() - holder.itemView.getY();
            indexOf = CollectionsKt___CollectionsKt.indexOf((Iterable<? extends Integer>) ((Iterable<? extends Object>) this.dataMap.keySet()), Integer.valueOf(holder.m().b()));
            return new c.b.a(D0, 0.5f, 0.96f, -indexOf, 0.0f, 16, null);
        }
        return new c.b.a(com.tencent.qqnt.qbasealbum.ktx.d.b(8), 0.0f, 0.0f, 0.0f, 0.0f, 28, null);
    }

    @Override // com.tencent.mobileqq.aio.notification.list.c.b
    @NotNull
    public c.b.a C(@NotNull b holder) {
        int indexOf;
        IAIONotificationUIModel iAIONotificationUIModel;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (c.b.a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) holder);
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof d) {
            return new c.b.a(0.0f, 0.0f, 0.0f, -100.0f, 0.0f, 20, null);
        }
        int b16 = holder.m().b();
        Companion.ListStatus listStatus = this.listStatus;
        if (listStatus == Companion.ListStatus.STATUS_EXPANDING_LIST) {
            List<IAIONotificationUIModel> list = this.dataMap.get(Integer.valueOf(b16));
            int i3 = 0;
            if (list != null) {
                iAIONotificationUIModel = list.get(0);
            } else {
                iAIONotificationUIModel = null;
            }
            float f16 = 0.0f;
            for (Map.Entry<a, Float> entry : this.itemPositionList.entrySet()) {
                if (iAIONotificationUIModel != null) {
                    str = iAIONotificationUIModel.getToken();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, entry.getKey().a())) {
                    f16 = entry.getValue().floatValue();
                }
            }
            float y16 = f16 - holder.itemView.getY();
            List<IAIONotificationUIModel> list2 = this.dataMap.get(Integer.valueOf(b16));
            if (list2 != null) {
                i3 = list2.size();
            }
            if (i3 > 1) {
                AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
                Intrinsics.checkNotNullExpressionValue(this.recyclerView.getContext(), "recyclerView.context");
                y16 += (int) aIONotificationUIUtils.A(r3);
            }
            return new c.b.a(y16, 0.5f, 0.96f, -H0(holder.m()), 0.0f, 16, null);
        }
        if (listStatus == Companion.ListStatus.STATUS_UNFOLDING_LIST) {
            float D0 = D0() - holder.itemView.getY();
            AIONotificationUIUtils aIONotificationUIUtils2 = AIONotificationUIUtils.f192828a;
            Intrinsics.checkNotNullExpressionValue(this.recyclerView.getContext(), "recyclerView.context");
            float A = D0 + ((int) aIONotificationUIUtils2.A(r4));
            indexOf = CollectionsKt___CollectionsKt.indexOf((Iterable<? extends Integer>) ((Iterable<? extends Object>) this.dataMap.keySet()), Integer.valueOf(holder.m().b()));
            return new c.b.a(A, 0.5f, 0.96f, -indexOf, 0.0f, 16, null);
        }
        return new c.b.a(-com.tencent.qqnt.qbasealbum.ktx.d.b(8), 0.0f, 0.0f, 0.0f, 0.0f, 28, null);
    }

    public final void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (I0() > 1) {
            Z0(this, false, Companion.ListStatus.STATUS_FOLDING_LIST, 1, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        a aVar = getCurrentList().get(position);
        Intrinsics.checkNotNullExpressionValue(aVar, "currentList[position]");
        holder.l(aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (b) iPatchRedirector.redirect((short) 9, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 2) {
            p81.g g16 = p81.g.g(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026, false\n                )");
            return new d(this, g16);
        }
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        AIONotificationItemView aIONotificationItemView = new AIONotificationItemView(context, null);
        aIONotificationItemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        aIONotificationItemView.setClipChildren(false);
        aIONotificationItemView.setClipToPadding(false);
        return new e(this, aIONotificationItemView);
    }

    @Override // com.tencent.mobileqq.aio.notification.list.c.a
    public void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.listStatus == Companion.ListStatus.STATUS_EXPANDING_LIST && E0() == 1) {
            this.recyclerView.scrollToPosition(0);
        }
        M0(this, false, 1, null);
    }

    public final void U0(@NotNull String token) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) token);
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        IAIONotificationUIModel iAIONotificationUIModel = null;
        for (Map.Entry<Integer, List<IAIONotificationUIModel>> entry : this.dataMap.entrySet()) {
            if (iAIONotificationUIModel != null) {
                break;
            }
            Iterator<IAIONotificationUIModel> it = entry.getValue().iterator();
            while (true) {
                if (it.hasNext()) {
                    IAIONotificationUIModel next = it.next();
                    if (Intrinsics.areEqual(next.getToken(), token)) {
                        it.remove();
                        iAIONotificationUIModel = next;
                        break;
                    }
                }
            }
        }
        if (iAIONotificationUIModel != null) {
            AIONotificationUIUtils.f192828a.K(J0(), iAIONotificationUIModel);
            this.reportedExpandNotification.remove(iAIONotificationUIModel.getToken());
            if (!A0(iAIONotificationUIModel)) {
                Z0(this, false, null, 3, null);
            }
        }
    }

    public final void W0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Z0(this, false, Companion.ListStatus.STATUS_UNFOLDING_LIST, 1, null);
        if (!this.pendingAddNotificationList.isEmpty()) {
            R0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r0.contains(r8) == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void X0(@NotNull IAIONotificationUIModel uiModel) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) uiModel);
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        List<IAIONotificationUIModel> list = this.dataMap.get(Integer.valueOf(F0(uiModel)));
        if (list != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            int indexOf = list.indexOf(uiModel);
            list.remove(uiModel);
            list.add(indexOf, uiModel);
            int childCount = this.recyclerView.getChildCount();
            int i3 = 0;
            while (true) {
                e eVar = null;
                if (i3 < childCount) {
                    RecyclerView.ViewHolder childViewHolder = this.recyclerView.getChildViewHolder(this.recyclerView.getChildAt(i3));
                    if (childViewHolder instanceof e) {
                        eVar = (e) childViewHolder;
                    }
                    if (eVar != null && eVar.o().o().contains(uiModel)) {
                        eVar.o().B(uiModel);
                    }
                    i3++;
                } else {
                    Z0(this, false, null, 3, null);
                    return;
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AIONotificationAdapter", 2, "updateNotification: not found, " + uiModel);
            }
            t0(uiModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, position)).intValue();
        }
        if (getCurrentList().get(position).getDataType() != 1) {
            return 1;
        }
        return 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (r0.contains(r4) == true) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t0(@NotNull IAIONotificationUIModel uiModel) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uiModel);
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        if (this.listStatus == Companion.ListStatus.STATUS_FOLDING_LIST) {
            this.pendingAddNotificationList.add(uiModel);
            return;
        }
        List<IAIONotificationUIModel> list = this.dataMap.get(Integer.valueOf(F0(uiModel)));
        if (list != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            X0(uiModel);
            return;
        }
        List<IAIONotificationUIModel> list2 = this.dataMap.get(Integer.valueOf(F0(uiModel)));
        if (list2 != null) {
            u0(uiModel, list2);
        }
        AIONotificationUIUtils.f192828a.J(J0(), uiModel);
        Z0(this, false, null, 3, null);
    }

    public final void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Iterator<Map.Entry<Integer, List<IAIONotificationUIModel>>> it = this.dataMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
        boolean J0 = J0();
        Iterator<Map.Entry<Integer, List<IAIONotificationUIModel>>> it5 = this.dataMap.entrySet().iterator();
        while (it5.hasNext()) {
            Iterator<IAIONotificationUIModel> it6 = it5.next().getValue().iterator();
            while (it6.hasNext()) {
                AIONotificationUIUtils.f192828a.K(J0, it6.next());
            }
        }
        Z0(this, false, null, 3, null);
    }

    public final void y0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (!J0()) {
            return;
        }
        Q0();
        Z0(this, false, Companion.ListStatus.STATUS_CLOSING_LIST, 1, null);
        if (this.isClearBtnShowing) {
            com.tencent.mobileqq.aio.utils.b.f194119a.s("em_group_one_click_clear");
            this.isClearBtnShowing = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \t2\u00020\u0001:\u0004\t\u0006\f\rR\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "", "", "getDataType", "()I", "dataType", "b", "notificationType", "", "a", "()Ljava/lang/String;", "notificationToken", "c", "d", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {
        public static final IPatchRedirector $redirector_ = null;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a$a;", "", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* loaded from: classes11.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f192896a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54266);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f192896a = new Companion();
                }
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u0012\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00028\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a$c;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "()I", "notificationType", "c", "notificationCount", "d", "getDataType", "dataType", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "notificationToken", "<init>", "(II)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes11.dex */
        public static final /* data */ class c implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final int notificationType;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private final int notificationCount;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private final int dataType;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final String notificationToken;

            public c(int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
                    return;
                }
                this.notificationType = i3;
                this.notificationCount = i16;
                this.dataType = 1;
                this.notificationToken = "";
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            @NotNull
            public String a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return this.notificationToken;
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            public int b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return this.notificationType;
            }

            public final int c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return this.notificationCount;
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if (!(other instanceof c)) {
                    return false;
                }
                c cVar = (c) other;
                if (b() == cVar.b() && this.notificationCount == cVar.notificationCount) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            public int getDataType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }
                return this.dataType;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
                }
                return (b() * 31) + this.notificationCount;
            }

            @NotNull
            public String toString() {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                Integer num = AIONotificationAdapter.INSTANCE.a().get(Integer.valueOf(b()));
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    i3 = 0;
                }
                return "[header-" + HardCodeUtil.qqStr(i3) + "]";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0018\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a$d;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "()I", "notificationType", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "c", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "()Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "notification", "d", "getDataType", "dataType", "a", "()Ljava/lang/String;", "notificationToken", "<init>", "(ILcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes11.dex */
        public static final /* data */ class d implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final int notificationType;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final IAIONotificationUIModel notification;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private final int dataType;

            public d(int i3, @NotNull IAIONotificationUIModel notification) {
                Intrinsics.checkNotNullParameter(notification, "notification");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) notification);
                    return;
                }
                this.notificationType = i3;
                this.notification = notification;
                this.dataType = 3;
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            @NotNull
            public String a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this);
                }
                return this.notification.getToken();
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            public int b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return this.notificationType;
            }

            @NotNull
            public final IAIONotificationUIModel c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (IAIONotificationUIModel) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                return this.notification;
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if (!(other instanceof d)) {
                    return false;
                }
                d dVar = (d) other;
                if (b() == dVar.b() && Intrinsics.areEqual(this.notification, dVar.notification)) {
                    return true;
                }
                return false;
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            public int getDataType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                }
                return this.dataType;
            }

            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
                }
                return (b() * 31) + this.notification.hashCode();
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return (String) iPatchRedirector.redirect((short) 6, (Object) this);
                }
                return "[normal-item-" + this.notification + "]";
            }
        }

        static {
            ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(54289), (Class<?>) a.class, "$redirector_");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1);
            } else {
                INSTANCE = Companion.f192896a;
            }
        }

        @NotNull
        String a();

        int b();

        int getDataType();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\b\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\r\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\"\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010!\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b \u0010\fR\u0014\u0010$\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a$b;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationAdapter$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "()I", "notificationType", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "c", "Ljava/util/concurrent/CopyOnWriteArrayList;", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "notificationList", "d", "Z", "e", "()Z", "g", "(Z)V", "isNeedInsertAnimation", "f", tl.h.F, "isNeedUpdateListAfterRemove", "setNeedFadeShadow", "isNeedFadeShadow", "getDataType", "dataType", "a", "()Ljava/lang/String;", "notificationToken", "<init>", "(ILjava/util/concurrent/CopyOnWriteArrayList;ZZZ)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes11.dex */
        public static final /* data */ class b implements a {
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final int notificationType;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final CopyOnWriteArrayList<IAIONotificationUIModel> notificationList;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean isNeedInsertAnimation;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private boolean isNeedUpdateListAfterRemove;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            private boolean isNeedFadeShadow;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata */
            private final int dataType;

            public b(int i3, @NotNull CopyOnWriteArrayList<IAIONotificationUIModel> notificationList, boolean z16, boolean z17, boolean z18) {
                Intrinsics.checkNotNullParameter(notificationList, "notificationList");
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), notificationList, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
                    return;
                }
                this.notificationType = i3;
                this.notificationList = notificationList;
                this.isNeedInsertAnimation = z16;
                this.isNeedUpdateListAfterRemove = z17;
                this.isNeedFadeShadow = z18;
                this.dataType = 2;
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            @NotNull
            public String a() {
                Object firstOrNull;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.notificationList);
                    IAIONotificationUIModel iAIONotificationUIModel = (IAIONotificationUIModel) firstOrNull;
                    if (iAIONotificationUIModel != null) {
                        return iAIONotificationUIModel.getToken();
                    }
                    return "";
                }
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            public int b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                return this.notificationType;
            }

            @NotNull
            public final CopyOnWriteArrayList<IAIONotificationUIModel> c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return this.notificationList;
            }

            public final boolean d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
                }
                return this.isNeedFadeShadow;
            }

            public final boolean e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                }
                return this.isNeedInsertAnimation;
            }

            public boolean equals(@Nullable Object other) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
                }
                if (this == other) {
                    return true;
                }
                if (!(other instanceof b)) {
                    return false;
                }
                b bVar = (b) other;
                if (b() == bVar.b() && Intrinsics.areEqual(this.notificationList, bVar.notificationList) && this.isNeedInsertAnimation == bVar.isNeedInsertAnimation && this.isNeedUpdateListAfterRemove == bVar.isNeedUpdateListAfterRemove && this.isNeedFadeShadow == bVar.isNeedFadeShadow) {
                    return true;
                }
                return false;
            }

            public final boolean f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
                }
                return this.isNeedUpdateListAfterRemove;
            }

            public final void g(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, z16);
                } else {
                    this.isNeedInsertAnimation = z16;
                }
            }

            @Override // com.tencent.mobileqq.aio.notification.list.AIONotificationAdapter.a
            public int getDataType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
                }
                return this.dataType;
            }

            public final void h(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this, z16);
                } else {
                    this.isNeedUpdateListAfterRemove = z16;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                    return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
                }
                int b16 = ((b() * 31) + this.notificationList.hashCode()) * 31;
                boolean z16 = this.isNeedInsertAnimation;
                int i3 = 1;
                int i16 = z16;
                if (z16 != 0) {
                    i16 = 1;
                }
                int i17 = (b16 + i16) * 31;
                boolean z17 = this.isNeedUpdateListAfterRemove;
                int i18 = z17;
                if (z17 != 0) {
                    i18 = 1;
                }
                int i19 = (i17 + i18) * 31;
                boolean z18 = this.isNeedFadeShadow;
                if (!z18) {
                    i3 = z18 ? 1 : 0;
                }
                return i19 + i3;
            }

            @NotNull
            public String toString() {
                Object firstOrNull;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                    try {
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.notificationList);
                        return "[folded-item-" + firstOrNull + "]";
                    } catch (Exception e16) {
                        return "[exception getting folded item: " + e16.getMessage() + "]";
                    }
                }
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }

            public /* synthetic */ b(int i3, CopyOnWriteArrayList copyOnWriteArrayList, boolean z16, boolean z17, boolean z18, int i16, DefaultConstructorMarker defaultConstructorMarker) {
                this(i3, copyOnWriteArrayList, (i16 & 4) != 0 ? true : z16, (i16 & 8) != 0 ? false : z17, (i16 & 16) != 0 ? false : z18);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), copyOnWriteArrayList, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), defaultConstructorMarker);
            }
        }
    }
}
