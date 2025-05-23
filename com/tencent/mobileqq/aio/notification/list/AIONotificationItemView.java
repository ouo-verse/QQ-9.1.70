package com.tencent.mobileqq.aio.notification.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.aio.notification.base.d;
import com.tencent.mobileqq.aio.notification.list.AIONotificationItemView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0003XYZB\u001d\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010!\u001a\u00020 H\u0002J.\u0010)\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$2\u0006\u0010&\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010'J(\u0010+\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010'J\u0014\u0010,\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060$J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007J\u001a\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u00101\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004R\u0016\u00105\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00104R\u0016\u0010\u0018\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u00106R\u0016\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00108R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010:R\u0016\u0010<\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00106R\u001b\u0010@\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010?R \u0010D\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00060E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR \u0010L\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010CR.\u0010P\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060N\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0E0M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010C\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView$c;", "holder", "", "r", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "j", "viewHolder", "t", ReportConstant.COSTREPORT_PREFIX, tl.h.F, "", "needAnim", "k", "", "direction", "Lkotlin/Function0;", "onAnimEnd", "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "type", "y", "isLastNotification", "v", "g", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "id", DomainData.DOMAIN_NAME, "Landroidx/viewbinding/ViewBinding;", "viewBinding", "Landroid/view/View;", "l", "", "initialList", "isExpandDialogState", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView$a;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "notification", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "e", "", "token", "w", "B", "d", "u", "Ljava/lang/String;", "TAG", "I", "f", "Z", "isInitAsFoldMode", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView$a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "notificationUIStartIndex", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "()Landroid/view/View;", "fakeShadow", "", "D", "Ljava/util/Map;", "notificationMap", "", "E", "Ljava/util/List;", "o", "()Ljava/util/List;", "targetList", UserInfo.SEX_FEMALE, "targetViewHolderMap", "", "Ljava/lang/Class;", "G", "recyclerBin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "a", "b", "c", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationItemView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy fakeShadow;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<String, IAIONotificationUIModel> notificationMap;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<IAIONotificationUIModel> targetList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Map<String, c> targetViewHolderMap;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Map<Class<? extends IAIONotificationUIModel>, List<ViewBinding>> recyclerBin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isInitAsFoldMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isExpandDialogState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int notificationUIStartIndex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView$a;", "", "", "type", "Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView;", "currentView", "oldHeight", "newHeight", "", "b", "c", "d", "a", "e", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public interface a {
        void a(@NotNull AIONotificationItemView currentView);

        void b(int type, @NotNull AIONotificationItemView currentView, int oldHeight, int newHeight);

        void c(int type, @NotNull AIONotificationItemView currentView);

        void d(@NotNull AIONotificationItemView currentView);

        void e(int type);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView$b;", "", "", "ADD_ANIM_TRANSLATION_OFFSET", UserInfo.SEX_FEMALE, "", "CONTAINER_COUNT", "I", "DIRECTION_DOWN", "DIRECTION_UP", "FALL_ANIM_TRANSLATION_OFFSET", "MAX_CONTAINER_CHILD_COUNT", "MAX_RECYCLER_BIN_SIZE", "REMOVE_ANIM_TRANSLATION_OFFSET", "SHADOW_SIZE", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.list.AIONotificationItemView$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/AIONotificationItemView$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "a", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "()Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "c", "(Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;)V", "uiModel", "Landroidx/viewbinding/ViewBinding;", "b", "Landroidx/viewbinding/ViewBinding;", "()Landroidx/viewbinding/ViewBinding;", "view", "<init>", "(Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;Landroidx/viewbinding/ViewBinding;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private IAIONotificationUIModel uiModel;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewBinding view;

        public c(@NotNull IAIONotificationUIModel uiModel, @NotNull ViewBinding view) {
            Intrinsics.checkNotNullParameter(uiModel, "uiModel");
            Intrinsics.checkNotNullParameter(view, "view");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uiModel, (Object) view);
            } else {
                this.uiModel = uiModel;
                this.view = view;
            }
        }

        @NotNull
        public final IAIONotificationUIModel a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IAIONotificationUIModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.uiModel;
        }

        @NotNull
        public final ViewBinding b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ViewBinding) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.view;
        }

        public final void c(@NotNull IAIONotificationUIModel iAIONotificationUIModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) iAIONotificationUIModel);
            } else {
                Intrinsics.checkNotNullParameter(iAIONotificationUIModel, "<set-?>");
                this.uiModel = iAIONotificationUIModel;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.uiModel, cVar.uiModel) && Intrinsics.areEqual(this.view, cVar.view)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.uiModel.hashCode() * 31) + this.view.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "ViewHolder(uiModel=" + this.uiModel + ", view=" + this.view + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JR\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/aio/notification/list/AIONotificationItemView$d", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "v", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f192922d;

        d(View view) {
            this.f192922d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@Nullable View v3, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, v3, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(oldLeft), Integer.valueOf(oldTop), Integer.valueOf(oldRight), Integer.valueOf(oldBottom));
                return;
            }
            this.f192922d.removeOnLayoutChangeListener(this);
            this.f192922d.setVisibility(0);
            this.f192922d.setAlpha(0.0f);
            this.f192922d.setScaleX(1.0f);
            this.f192922d.setScaleY(1.0f);
            this.f192922d.setTranslationY(r5.getHeight() * (-0.3f));
            this.f192922d.animate().withLayer().translationY(0.0f).alpha(1.0f).setDuration(200L).setListener(null).start();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54378);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIONotificationItemView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this, (Object) context);
    }

    private final void A(c viewHolder, boolean needAnim) {
        View mRv = viewHolder.b().getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "viewHolder.view.root");
        final View l3 = l(viewHolder.b());
        if (needAnim) {
            mRv.animate().withLayer().translationY(0.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).setListener(null).start();
            if (l3 != null) {
                AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
                ViewPropertyAnimator duration = l3.animate().withLayer().alpha(0.0f).setDuration(200L);
                Intrinsics.checkNotNullExpressionValue(duration, "it.animate()\n           \u2026IUtils.DEFAULT_ANIM_TIME)");
                aIONotificationUIUtils.m(duration, new Function0<Unit>(l3) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationItemView$riseFallingNotification$1$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ View $it;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$it = l3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3);
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
                            this.$it.setVisibility(8);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }).start();
                return;
            }
            return;
        }
        mRv.setTranslationY(0.0f);
        mRv.setScaleX(1.0f);
        mRv.setScaleY(1.0f);
        if (l3 != null) {
            l3.setVisibility(8);
        }
    }

    public static /* synthetic */ void f(AIONotificationItemView aIONotificationItemView, IAIONotificationUIModel iAIONotificationUIModel, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        aIONotificationItemView.e(iAIONotificationUIModel, z16);
    }

    private final void g() {
        int i3;
        a aVar;
        Object first;
        int B;
        int b16;
        Object first2;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i16 = getLayoutParams().height;
        int size = this.targetList.size();
        if (size != 0) {
            if (size != 1) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.targetList);
                AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                int B2 = (int) aIONotificationUIUtils.B(context, (IAIONotificationUIModel) first2);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                B = B2 + ((int) aIONotificationUIUtils.A(context2));
                b16 = ab.b(this);
            } else {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.targetList);
                AIONotificationUIUtils aIONotificationUIUtils2 = AIONotificationUIUtils.f192828a;
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                B = (int) aIONotificationUIUtils2.B(context3, (IAIONotificationUIModel) first);
                b16 = ab.b(this);
            }
            i3 = B + b16;
        } else {
            i3 = -2;
        }
        layoutParams.height = i3;
        setLayoutParams(layoutParams);
        if (i16 != getLayoutParams().height && (aVar = this.callback) != null) {
            aVar.b(this.type, this, i16, layoutParams.height);
        }
    }

    private final void h(c viewHolder) {
        View mRv = viewHolder.b().getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "viewHolder.view.root");
        mRv.setVisibility(4);
        mRv.addOnLayoutChangeListener(new d(mRv));
    }

    private final void i(c viewHolder, int direction, final Function0<Unit> onAnimEnd) {
        View mRv = viewHolder.b().getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "viewHolder.view.root");
        mRv.setAlpha(1.0f);
        mRv.setScaleX(1.0f);
        mRv.setScaleY(1.0f);
        mRv.setTranslationY(0.0f);
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        ViewPropertyAnimator duration = mRv.animate().withLayer().translationY(direction * 0.2f * mRv.getHeight()).alpha(0.0f).setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(duration, "view.animate()\n         \u2026IUtils.DEFAULT_ANIM_TIME)");
        aIONotificationUIUtils.m(duration, new Function0<Unit>(onAnimEnd) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationItemView$animNotificationRemove$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<Unit> $onAnimEnd;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$onAnimEnd = onAnimEnd;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) onAnimEnd);
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
                    this.$onAnimEnd.invoke();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }).start();
    }

    private final c j(IAIONotificationUIModel uiModel, ViewGroup container) {
        ViewBinding viewBinding;
        Object removeFirstOrNull;
        List<ViewBinding> list = this.recyclerBin.get(uiModel.getClass());
        if (list != null) {
            removeFirstOrNull = CollectionsKt__MutableCollectionsKt.removeFirstOrNull(list);
            viewBinding = (ViewBinding) removeFirstOrNull;
        } else {
            viewBinding = null;
        }
        if (viewBinding != null) {
            return new c(uiModel, viewBinding);
        }
        return new c(uiModel, AIONotificationUIUtils.f192828a.k(container, uiModel));
    }

    private final void k(c viewHolder, boolean needAnim) {
        View mRv = viewHolder.b().getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "viewHolder.view.root");
        AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        float B = aIONotificationUIUtils.B(context, viewHolder.a());
        View l3 = l(viewHolder.b());
        if (needAnim) {
            mRv.setScaleX(1.0f);
            mRv.setScaleY(1.0f);
            mRv.setTranslationY(0.0f);
            mRv.animate().withLayer().translationY(B * 0.18f).scaleX(0.96f).scaleY(0.96f).setDuration(200L).setListener(null).start();
            if (l3 != null) {
                l3.setVisibility(0);
                l3.setAlpha(0.0f);
                l3.animate().withLayer().alpha(1.0f).setDuration(200L).setListener(null).start();
                return;
            }
            return;
        }
        mRv.setScaleX(0.96f);
        mRv.setScaleY(0.96f);
        mRv.setTranslationY(B * 0.18f);
        if (l3 != null) {
            l3.setAlpha(1.0f);
        }
        if (l3 != null) {
            l3.setVisibility(0);
        }
    }

    private final View l(ViewBinding viewBinding) {
        return viewBinding.getMRv().findViewById(R.id.sja);
    }

    private final View m() {
        return (View) this.fakeShadow.getValue();
    }

    private final int n(AIONotificationBusiId id5) {
        d.a aVar = com.tencent.mobileqq.aio.notification.base.d.f192838a.a().get(id5);
        if (aVar != null) {
            return aVar.e();
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(c holder) {
        removeView(holder.b().getMRv());
        s(holder);
        a aVar = this.callback;
        if (aVar != null) {
            aVar.d(this);
        }
        g();
    }

    private final void s(c viewHolder) {
        List<ViewBinding> list = this.recyclerBin.get(viewHolder.a().getClass());
        if (list != null) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "recycleViewHolder: " + viewHolder.a());
            }
            View mRv = viewHolder.b().getMRv();
            Intrinsics.checkNotNullExpressionValue(mRv, "viewHolder.view.root");
            mRv.animate().cancel();
            mRv.setAlpha(1.0f);
            mRv.setScaleX(1.0f);
            mRv.setScaleY(1.0f);
            mRv.setTranslationY(0.0f);
            mRv.setTranslationX(0.0f);
            View l3 = l(viewHolder.b());
            if (l3 != null) {
                l3.setAlpha(1.0f);
            }
            if (l3 != null) {
                l3.setVisibility(8);
            }
            list.add(viewHolder.b());
            if (list.size() > 4) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.TAG, 2, "recycleViewHolder: oversize");
                }
                CollectionsKt__MutableCollectionsKt.removeFirst(list);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r8.targetList.size() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void t(c viewHolder) {
        boolean z16;
        if (this.isInitAsFoldMode) {
            z16 = true;
        }
        z16 = false;
        AIONotificationUIUtils.f192828a.F(viewHolder.a(), viewHolder.b(), this.isExpandDialogState, z16, new Function0<Boolean>() { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationItemView$refreshNotificationUI$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationItemView.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                AIONotificationItemView.a aVar;
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                boolean z17 = true;
                if (AIONotificationItemView.this.o().size() > 1) {
                    aVar = AIONotificationItemView.this.callback;
                    if (aVar != null) {
                        i3 = AIONotificationItemView.this.type;
                        aVar.e(i3);
                    }
                } else {
                    z17 = false;
                }
                return Boolean.valueOf(z17);
            }
        });
    }

    private final void v(int type, final c holder, boolean isLastNotification, boolean needAnim) {
        Object lastOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.targetList);
        IAIONotificationUIModel iAIONotificationUIModel = (IAIONotificationUIModel) lastOrNull;
        if (isLastNotification) {
            if (needAnim) {
                i(holder, 1, new Function0<Unit>(holder) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationItemView$removeInMultiNotification$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ AIONotificationItemView.c $holder;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$holder = holder;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationItemView.this, (Object) holder);
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
                            AIONotificationItemView.this.r(this.$holder);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                });
            } else {
                r(holder);
            }
            if (iAIONotificationUIModel != null) {
                c cVar = this.targetViewHolderMap.get(iAIONotificationUIModel.getToken());
                if (cVar != null) {
                    A(cVar, needAnim);
                } else {
                    QLog.e(this.TAG, 2, "animRemoveInMultiNotification: fallingNotification's holder not found");
                }
            }
        } else {
            r(holder);
        }
        if (this.targetList.size() >= 3 && this.targetViewHolderMap.size() < 3) {
            List<IAIONotificationUIModel> list = this.targetList;
            IAIONotificationUIModel iAIONotificationUIModel2 = list.get(list.size() - 3);
            if (this.targetViewHolderMap.containsKey(iAIONotificationUIModel2.getToken())) {
                QLog.e(this.TAG, 2, "animRemoveInMultiNotification: needRecoverNotification is already on screen, " + iAIONotificationUIModel2);
            } else {
                c j3 = j(iAIONotificationUIModel2, this);
                t(j3);
                this.targetViewHolderMap.put(iAIONotificationUIModel2.getToken(), j3);
                addView(j3.b().getMRv(), this.notificationUIStartIndex);
                k(j3, needAnim);
            }
        }
        g();
    }

    public static /* synthetic */ void x(AIONotificationItemView aIONotificationItemView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        aIONotificationItemView.w(str, z16);
    }

    private final void y(int type, final c holder, boolean needAnim) {
        a aVar = this.callback;
        if (aVar != null) {
            aVar.c(type, this);
        }
        if (needAnim) {
            i(holder, -1, new Function0<Unit>(holder) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationItemView$removeOnlyOneNotification$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AIONotificationItemView.c $holder;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$holder = holder;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationItemView.this, (Object) holder);
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
                        AIONotificationItemView.this.r(this.$holder);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            r(holder);
        }
    }

    @UiThread
    public final void B(@NotNull IAIONotificationUIModel uiModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) uiModel);
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        int n3 = n(uiModel.b());
        int i3 = this.type;
        if (n3 != i3) {
            QLog.e(this.TAG, 2, "updateNotification: type not match, targetType=" + n3 + ", type=" + i3);
            return;
        }
        c cVar = this.targetViewHolderMap.get(uiModel.getToken());
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "updateNotification: " + uiModel);
        }
        if (cVar != null) {
            this.notificationMap.put(uiModel.getToken(), uiModel);
            int indexOf = this.targetList.indexOf(uiModel);
            this.targetList.remove(uiModel);
            this.targetList.add(indexOf, uiModel);
            cVar.c(uiModel);
            t(cVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "updateNotification: not found ," + uiModel);
        }
    }

    public final void d() {
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (!Intrinsics.areEqual(m().getParent(), this)) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.targetList);
            IAIONotificationUIModel iAIONotificationUIModel = (IAIONotificationUIModel) lastOrNull;
            if (iAIONotificationUIModel != null) {
                AIONotificationUIUtils aIONotificationUIUtils = AIONotificationUIUtils.f192828a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                float B = aIONotificationUIUtils.B(context, iAIONotificationUIModel);
                if (B > 0.0f) {
                    this.notificationUIStartIndex = 1;
                    m().setTranslationY(B * 0.18f);
                    addView(m(), 0);
                }
            }
        }
    }

    @UiThread
    public final void e(@NotNull IAIONotificationUIModel uiModel, boolean needAnim) {
        IAIONotificationUIModel iAIONotificationUIModel;
        c cVar;
        Object first;
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, uiModel, Boolean.valueOf(needAnim));
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        int n3 = n(uiModel.b());
        if (n3 != this.type) {
            if (QLog.isColorLevel()) {
                QLog.e(this.TAG, 2, "addNotification: type not match, targetType=" + n3 + ", type=" + this.type);
                return;
            }
            return;
        }
        c cVar2 = this.targetViewHolderMap.get(uiModel.getToken());
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addNotification: " + uiModel + ", needAnim=" + needAnim + ", foldMode=" + this.isInitAsFoldMode);
        }
        if (cVar2 != null) {
            t(cVar2);
            return;
        }
        if (!this.targetList.isEmpty()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.targetList);
            iAIONotificationUIModel = (IAIONotificationUIModel) last;
        } else {
            iAIONotificationUIModel = null;
        }
        c j3 = j(uiModel, this);
        int size = this.targetList.size();
        this.targetList.add(uiModel);
        this.targetViewHolderMap.put(uiModel.getToken(), j3);
        this.notificationMap.put(uiModel.getToken(), uiModel);
        if (size == 1) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.targetList);
            c cVar3 = this.targetViewHolderMap.get(((IAIONotificationUIModel) first).getToken());
            if (cVar3 != null) {
                t(cVar3);
            }
        }
        t(j3);
        addView(j3.b().getMRv());
        if (needAnim) {
            h(j3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "addNotification: lastNotificationModel=" + iAIONotificationUIModel);
        }
        if (iAIONotificationUIModel != null && (cVar = this.targetViewHolderMap.get(iAIONotificationUIModel.getToken())) != null) {
            k(cVar, needAnim);
        }
        if (this.targetViewHolderMap.size() > 3) {
            List<IAIONotificationUIModel> list = this.targetList;
            IAIONotificationUIModel iAIONotificationUIModel2 = list.get((list.size() - 3) - 1);
            c cVar4 = this.targetViewHolderMap.get(iAIONotificationUIModel2.getToken());
            if (cVar4 != null) {
                this.targetViewHolderMap.remove(iAIONotificationUIModel2.getToken());
                removeView(cVar4.b().getMRv());
                s(cVar4);
            } else {
                QLog.e(this.TAG, 2, "addNotification: oldestViewHolder is off screen, oldestNotification=" + iAIONotificationUIModel2);
            }
        }
        a aVar = this.callback;
        if (aVar != null) {
            aVar.a(this);
        }
        g();
    }

    @NotNull
    public final List<IAIONotificationUIModel> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.targetList;
    }

    public final void p(int type, @NotNull IAIONotificationUIModel notification, boolean isExpandDialogState, @Nullable a callback) {
        List<? extends IAIONotificationUIModel> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(type), notification, Boolean.valueOf(isExpandDialogState), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.type = type;
        this.callback = callback;
        this.isInitAsFoldMode = false;
        this.isExpandDialogState = isExpandDialogState;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(notification);
        z(listOf);
    }

    public final void q(int type, @NotNull List<? extends IAIONotificationUIModel> initialList, boolean isExpandDialogState, @Nullable a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(type), initialList, Boolean.valueOf(isExpandDialogState), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(initialList, "initialList");
        this.type = type;
        this.callback = callback;
        this.isInitAsFoldMode = true;
        this.isExpandDialogState = isExpandDialogState;
        z(initialList);
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.notificationUIStartIndex = 0;
        if (Intrinsics.areEqual(m().getParent(), this)) {
            removeView(m());
        }
    }

    @UiThread
    public final void w(@NotNull String token, boolean needAnim) {
        Object last;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, token, Boolean.valueOf(needAnim));
            return;
        }
        Intrinsics.checkNotNullParameter(token, "token");
        IAIONotificationUIModel iAIONotificationUIModel = this.notificationMap.get(token);
        if (iAIONotificationUIModel != null) {
            if (QLog.isColorLevel()) {
                QLog.d(this.TAG, 2, "removeNotification: " + iAIONotificationUIModel);
            }
            c cVar = this.targetViewHolderMap.get(iAIONotificationUIModel.getToken());
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.targetList);
            boolean areEqual = Intrinsics.areEqual(last, iAIONotificationUIModel);
            if (this.targetList.size() == 1) {
                z16 = true;
            }
            this.notificationMap.remove(token);
            this.targetList.remove(iAIONotificationUIModel);
            this.targetViewHolderMap.remove(iAIONotificationUIModel.getToken());
            if (cVar != null) {
                if (Intrinsics.areEqual(cVar.b().getMRv().getParent(), this)) {
                    if (z16) {
                        y(this.type, cVar, needAnim);
                        return;
                    } else {
                        v(this.type, cVar, areEqual, needAnim);
                        return;
                    }
                }
                QLog.e(this.TAG, 2, "removeNotification: view's parent not in container, uiModel=" + iAIONotificationUIModel);
                return;
            }
            QLog.e(this.TAG, 2, "removeNotification: view holder not found, uiModel=" + iAIONotificationUIModel);
            return;
        }
        QLog.e(this.TAG, 2, "removeNotification: notification had remove");
    }

    public final void z(@NotNull List<? extends IAIONotificationUIModel> initialList) {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) initialList);
            return;
        }
        Intrinsics.checkNotNullParameter(initialList, "initialList");
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "resetData: start");
        }
        u();
        list = CollectionsKt___CollectionsKt.toList(this.targetList);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w(((IAIONotificationUIModel) it.next()).getToken(), false);
        }
        Iterator<? extends IAIONotificationUIModel> it5 = initialList.iterator();
        while (it5.hasNext()) {
            e(it5.next(), false);
        }
        g();
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "resetData: end");
        }
    }

    public /* synthetic */ AIONotificationItemView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIONotificationItemView(@NotNull final Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Map<Class<? extends IAIONotificationUIModel>, List<ViewBinding>> mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.TAG = "AIONotificationItemView[" + hashCode() + "]";
        this.type = 3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>(context) { // from class: com.tencent.mobileqq.aio.notification.list.AIONotificationItemView$fakeShadow$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                View view = new View(this.$context);
                view.setBackgroundResource(R.drawable.mmc);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                view.setScaleX(0.96f);
                view.setScaleY(0.96f);
                return view;
            }
        });
        this.fakeShadow = lazy;
        setClipChildren(false);
        setClipToPadding(false);
        this.notificationMap = new LinkedHashMap();
        this.targetList = new ArrayList();
        this.targetViewHolderMap = new LinkedHashMap();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(IAIONotificationUIModel.b.class, new ArrayList()), TuplesKt.to(IAIONotificationUIModel.c.class, new ArrayList()));
        this.recyclerBin = mapOf;
    }
}
