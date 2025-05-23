package com.tencent.mobileqq.aio.shop;

import a81.e;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.k;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppLoadLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppView;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.shop.AIOShopArkUIState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqshop.publicaccount.AIOShopComponentDelegateQQ;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.j;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQCustomArkDialogUtil;
import defpackage.MsgListUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b6\b\u0016\u0018\u0000 \u0091\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0092\u0001B\u0011\u0012\u0006\u0010S\u001a\u00020P\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J0\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J,\u0010\u001e\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J4\u0010'\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001a2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0002J0\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010/\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020\fH\u0002J \u00100\u001a\u00020\f2\u0006\u0010,\u001a\u00020+2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020\fH\u0002J \u00102\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0006\u00101\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J$\u00106\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\fH\u0002J$\u00109\u001a\u0004\u0018\u00010\u001a2\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\fH\u0002J*\u0010:\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010>\u001a\u00020=2\u0006\u0010<\u001a\u00020;H\u0002J\b\u0010?\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020\u0007H\u0007J\b\u0010A\u001a\u0004\u0018\u00010\u0003J&\u0010B\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010D\u001a\u00020CH\u0016J\b\u0010F\u001a\u00020\fH\u0016J$\u0010G\u001a\u0004\u0018\u00010+2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010H\u001a\u00020\u0005H\u0014J\b\u0010I\u001a\u00020;H\u0016J\u000e\u0010L\u001a\b\u0012\u0004\u0012\u00020K0JH\u0016J\b\u0010N\u001a\u00020MH\u0016J\u0006\u0010O\u001a\u00020\u0007R\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010k\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010o\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010f\u001a\u0004\bm\u0010h\"\u0004\bn\u0010jR$\u0010u\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010|\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R%\u0010\u0080\u0001\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b}\u0010f\u001a\u0004\b~\u0010h\"\u0004\b\u007f\u0010jR+\u0010\u0087\u0001\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R+\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001\u00a8\u0006\u0093\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/AIOShopArkContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/shop/g;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "position", "", "d2", "", "", "payloads", "", "W1", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "M1", "Z1", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppContainer;", "arkAppContainer", "Lcom/tencent/ark/ArkViewImplement$ArkViewInterface;", "viewInterface", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "appLoadLayout", "appContainer", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;", QQCustomArkDialogUtil.APP_VIEW, "preferredHeight", "", "scale", "g2", "arkContainer", "Lcom/tencent/ark/data/ArkAppConfig;", "arkConfig", "", "appName", "i2", "isShowArk", "O1", "Y1", PublicAccountMessageUtilImpl.META_NAME, ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "messageId", "isFromShot", "Q1", "Lcom/tencent/mobileqq/aio/helper/t;", "containerHelper", "R1", "c2", "Landroid/view/View;", "view", "", "V1", "f2", "X1", "P1", "b1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", ExifInterface.LATITUDE_SOUTH, "T1", "U1", "c1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "N1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "I", "mArkWidth", "D", "mArkHeight", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "contentView", "Lqx3/a;", UserInfo.SEX_FEMALE, "Lqx3/a;", "getDelegate", "()Lqx3/a;", "setDelegate", "(Lqx3/a;)V", "delegate", "G", "Landroid/view/View;", "getArkRootView", "()Landroid/view/View;", "setArkRootView", "(Landroid/view/View;)V", "arkRootView", "H", "getShopAdContainer", "setShopAdContainer", "shopAdContainer", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;", "S1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;", "setArkView", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;)V", "arkView", "J", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "getLoadLayout", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "setLoadLayout", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;)V", "loadLayout", "K", "getArkViewLayout", "setArkViewLayout", "arkViewLayout", "L", "Lcom/tencent/ark/data/ArkAppConfig;", "getArkAppConfig", "()Lcom/tencent/ark/data/ArkAppConfig;", "setArkAppConfig", "(Lcom/tencent/ark/data/ArkAppConfig;)V", "arkAppConfig", "M", "Lcom/tencent/qqnt/msg/data/a;", "getMArkMsgModel", "()Lcom/tencent/qqnt/msg/data/a;", "setMArkMsgModel", "(Lcom/tencent/qqnt/msg/data/a;)V", "mArkMsgModel", "<init>", "(Landroid/content/Context;)V", "N", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOShopArkContentComponent extends BaseContentComponent<g> {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final boolean P;
    private static ArrayList Q;

    /* renamed from: C, reason: from kotlin metadata */
    private int mArkWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int mArkHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final RelativeLayout contentView;

    /* renamed from: F, reason: from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/QQShop/Inject_AIO_Shop_Component_Delegate.yml", version = 1)
    @Nullable
    private qx3.a delegate;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View arkRootView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View shopAdContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ArkAppView arkView;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ArkAppLoadLayout loadLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View arkViewLayout;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ArkAppConfig arkAppConfig;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.msg.data.a mArkMsgModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/shop/AIOShopArkContentComponent$a;", "", "", "CONTENT_VIEW_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.shop.AIOShopArkContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/aio/shop/AIOShopArkContentComponent$b", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "state", "errorCode", "", "msg", "", "canRetry", "", "onLoadFailed", "onLoadState", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements ArkViewImplement.LoadCallback {
        static IPatchRedirector $redirector_;
        final /* synthetic */ long C;
        final /* synthetic */ float D;
        final /* synthetic */ String E;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.data.msglist.a f193680d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIOShopArkContentComponent f193681e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f193682f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f193683h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f193684i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ t f193685m;

        b(com.tencent.aio.data.msglist.a aVar, AIOShopArkContentComponent aIOShopArkContentComponent, com.tencent.aio.api.runtime.a aVar2, int i3, String str, t tVar, long j3, float f16, String str2) {
            this.f193680d = aVar;
            this.f193681e = aIOShopArkContentComponent;
            this.f193682f = aVar2;
            this.f193683h = i3;
            this.f193684i = str;
            this.f193685m = tVar;
            this.C = j3;
            this.D = f16;
            this.E = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, aIOShopArkContentComponent, aVar2, Integer.valueOf(i3), str, tVar, Long.valueOf(j3), Float.valueOf(f16), str2);
            }
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        @TargetApi(14)
        public void onLoadFailed(int state, int errorCode, @Nullable String msg2, boolean canRetry) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(state), Integer.valueOf(errorCode), msg2, Boolean.valueOf(canRetry));
                return;
            }
            QLog.d("AIOShopArkContentComponent", 1, "onLoadFailed errorCode=" + errorCode + " ,msg=" + msg2);
            onLoadState(state);
            com.tencent.aio.data.msglist.a aVar = this.f193680d;
            if ((aVar instanceof g) && ((g) aVar).w2()) {
                this.f193681e.d2(this.f193682f, this.f193683h);
            }
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        @TargetApi(14)
        public void onLoadState(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, state);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOShopArkContentComponent", 2, "onLoadFinish state = ", Integer.valueOf(state), " ,appName = ", this.f193684i);
            }
            if (state != 0) {
                this.f193681e.N1();
            }
            if (state == 1) {
                AIOShopArkContentComponent aIOShopArkContentComponent = this.f193681e;
                ArkAppContainer R1 = aIOShopArkContentComponent.R1(this.f193685m, this.C, AIOShopArkContentComponent.K1(aIOShopArkContentComponent).n2());
                if (R1 == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(R1.getContainerRect(), "container.containerRect");
                float f16 = this.D;
                int i3 = (int) ((r0.right - r0.left) * f16);
                int i16 = (int) (f16 * (r0.bottom - r0.top));
                ArkAppView S1 = this.f193681e.S1();
                Intrinsics.checkNotNull(S1);
                ViewGroup.LayoutParams layoutParams = S1.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "arkView!!.layoutParams");
                a81.e g16 = a81.e.INSTANCE.g();
                if (g16 != null) {
                    g16.q(this.C, this.f193684i, this.E, layoutParams.height);
                }
                if (QLog.isColorLevel()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOShopArkContentComponent", 2, "ArkFold.onLoadFinish arkContainer rect(" + i3 + "," + i16 + "), arkView layout rect(" + layoutParams.width + "," + layoutParams.height + "), init mArkWidth=" + this.f193681e.mArkWidth + ",mArkHeight=" + this.f193681e.mArkHeight + ",appName=" + this.f193684i);
                    }
                }
                g K1 = AIOShopArkContentComponent.K1(this.f193681e);
                String d16 = R1.d();
                Intrinsics.checkNotNullExpressionValue(d16, "container.appVersion");
                K1.u2(d16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/aio/shop/AIOShopArkContentComponent$c", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView$b;", "", "onLoadSuccess", "onFirstPaint", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements ArkAppView.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.data.msglist.a f193686a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOShopArkContentComponent f193687b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.aio.api.runtime.a f193688c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f193689d;

        c(com.tencent.aio.data.msglist.a aVar, AIOShopArkContentComponent aIOShopArkContentComponent, com.tencent.aio.api.runtime.a aVar2, int i3) {
            this.f193686a = aVar;
            this.f193687b = aIOShopArkContentComponent;
            this.f193688c = aVar2;
            this.f193689d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, aIOShopArkContentComponent, aVar2, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppView.b
        public void onFirstPaint() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            com.tencent.aio.data.msglist.a aVar = this.f193686a;
            if ((aVar instanceof g) && ((g) aVar).w2()) {
                this.f193687b.d2(this.f193688c, this.f193689d);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppView.b
        public void onLoadSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/shop/AIOShopArkContentComponent$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f193690a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f193691b;

        d(int i3, int i16) {
            this.f193690a = i3;
            this.f193691b = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() - this.f193690a, this.f193691b);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57193);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Q = arrayList;
        arrayList.add(AIOShopComponentDelegateQQ.class);
        INSTANCE = new Companion(null);
        P = true;
    }

    public AIOShopArkContentComponent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.contentView = new RelativeLayout(context);
        X1();
    }

    public static final /* synthetic */ g K1(AIOShopArkContentComponent aIOShopArkContentComponent) {
        return aIOShopArkContentComponent.q1();
    }

    private final void M1(int position, ViewGroup parent, MsgElement element, MsgRecord msgRecord, com.tencent.aio.data.msglist.a msgItem) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        View inflate;
        ViewGroup.LayoutParams layoutParams;
        ArkAppLoadLayout arkAppLoadLayout;
        View view;
        ArkAppView arkAppView;
        ViewGroup.LayoutParams layoutParams2;
        RelativeLayout.LayoutParams layoutParams3;
        long j3;
        t tVar;
        float f16;
        boolean z16;
        Integer num;
        ArkAppContainer arkAppContainer;
        String str6;
        ArkAppContainer arkAppContainer2;
        boolean z17;
        ArkAppContainer arkAppContainer3;
        ArkElement arkElement = element.arkElement;
        if (arkElement != null && !TextUtils.isEmpty(arkElement.bytesData)) {
            com.tencent.qqnt.msg.data.a t26 = q1().t2();
            if (t26 == null) {
                QLog.e("AIOShopArkContentComponent", 1, "element.arkElement.bytesData parse error = " + element.arkElement.bytesData);
                return;
            }
            this.mArkMsgModel = t26;
            String d16 = t26.d();
            if (d16 == null) {
                str = "";
            } else {
                str = d16;
            }
            String e16 = t26.e();
            if (e16 == null) {
                str2 = "";
            } else {
                str2 = e16;
            }
            String m3 = t26.m();
            if (m3 == null) {
                m3 = "";
            }
            String f17 = t26.f();
            if (f17 == null) {
                str3 = "";
            } else {
                str3 = f17;
            }
            String a26 = a2(str, m3, msgRecord);
            String c16 = t26.c();
            if (c16 == null) {
                str4 = "";
            } else {
                str4 = c16;
            }
            String g16 = t26.g();
            if (g16 == null) {
                str5 = "";
            } else {
                str5 = g16;
            }
            boolean Z1 = Z1(msgRecord);
            boolean Y1 = Y1(str, str2, Z1);
            if ((Y1 || !Z1) && this.arkRootView != null) {
                ArkAppView arkAppView2 = this.arkView;
                if (arkAppView2 != null) {
                    arkAppView2.destroyBitmapBuffer();
                }
                ArkAppView arkAppView3 = this.arkView;
                if (arkAppView3 != null) {
                    arkAppView3.releaseViewContext();
                }
                ArkAppView arkAppView4 = this.arkView;
                if (arkAppView4 != null) {
                    arkAppView4.removeAllViews();
                }
                this.contentView.removeView(this.arkRootView);
                this.arkRootView = null;
            }
            if (!Z1) {
                return;
            }
            if (this.arkRootView == null || Y1) {
                if (MsgListUtil.f24918a.u()) {
                    inflate = new a81.g().i(parent.getContext(), this.contentView);
                } else {
                    inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.du_, (ViewGroup) this.contentView, false);
                    this.contentView.addView(inflate);
                }
                this.arkRootView = inflate;
                if (inflate != null) {
                    layoutParams = inflate.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.width = U1();
                }
                View view2 = this.arkRootView;
                if (view2 != null) {
                    arkAppLoadLayout = (ArkAppLoadLayout) view2.findViewById(R.id.eet);
                } else {
                    arkAppLoadLayout = null;
                }
                this.loadLayout = arkAppLoadLayout;
                View view3 = this.arkRootView;
                if (view3 != null) {
                    view = view3.findViewById(R.id.svh);
                } else {
                    view = null;
                }
                this.arkViewLayout = view;
                View view4 = this.arkRootView;
                if (view4 != null) {
                    arkAppView = (ArkAppView) view4.findViewById(R.id.y_);
                } else {
                    arkAppView = null;
                }
                this.arkView = arkAppView;
                View view5 = this.arkViewLayout;
                if (view5 != null) {
                    layoutParams2 = view5.getLayoutParams();
                } else {
                    layoutParams2 = null;
                }
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams3 = null;
                }
                if (layoutParams3 != null) {
                    layoutParams3.addRule(14);
                }
            }
            float f18 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
            long j16 = msgRecord.msgId;
            if (QLog.isColorLevel()) {
                QLog.d("AIOShopArkContentComponent", 2, "arkDebugMeta  meta = " + a26 + ", msgId = " + j16);
            }
            com.tencent.aio.api.runtime.a P1 = P1();
            t b16 = t.INSTANCE.b(P1);
            ArkAppContainer R1 = R1(b16, j16, q1().n2());
            if (R1 == null) {
                ArkAppContainer arkAppContainer4 = new ArkAppContainer(P1);
                j3 = j16;
                boolean z18 = P;
                arkAppContainer4.setIndependentView(z18);
                arkAppContainer4.setMemoryOptimized(z18);
                tVar = b16;
                f16 = f18;
                num = null;
                z16 = Z1;
                c2(b16, j3, q1().n2(), arkAppContainer4);
                arkAppContainer = arkAppContainer4;
            } else {
                j3 = j16;
                tVar = b16;
                f16 = f18;
                z16 = Z1;
                num = null;
                arkAppContainer = R1;
            }
            String str7 = str2;
            arkAppContainer.init(str, str2, str4, a26, str5, str3, f16);
            arkAppContainer.h(P1);
            arkAppContainer.j(msgRecord);
            a81.e g17 = a81.e.INSTANCE.g();
            if (g17 != null) {
                num = Integer.valueOf(g17.p(j3, str, str7, t26));
            }
            if (num != null) {
                ArkAppLoadLayout arkAppLoadLayout2 = this.loadLayout;
                ArkAppView arkAppView5 = this.arkView;
                Intrinsics.checkNotNull(arkAppView5);
                str6 = str7;
                arkAppContainer2 = arkAppContainer;
                g2(arkAppLoadLayout2, arkAppContainer, arkAppView5, num.intValue(), f16);
            } else {
                str6 = str7;
                arkAppContainer2 = arkAppContainer;
            }
            String str8 = str6;
            ArkAppContainer arkAppContainer5 = arkAppContainer2;
            b bVar = new b(msgItem, this, P1, position, str, tVar, j3, f16, str8);
            c cVar = new c(msgItem, this, P1, position);
            ArkAppView arkAppView6 = this.arkView;
            if (arkAppView6 != null) {
                arkAppView6.setLoadCallback(bVar);
            }
            ArkAppView arkAppView7 = this.arkView;
            if (arkAppView7 != null) {
                arkAppView7.setCallback(cVar);
            }
            ArkAppConfig e17 = arkAppContainer5.e();
            this.arkAppConfig = e17;
            if (num != null) {
                Intrinsics.checkNotNull(e17);
                i2(arkAppContainer5, e17, str, num.intValue(), msgRecord);
            }
            ArkAppView arkAppView8 = this.arkView;
            if (arkAppView8 != null) {
                arkAppView8.setClipRadius(0.0f);
            }
            ArkAppView arkAppView9 = this.arkView;
            if (arkAppView9 != null) {
                ArkAppConfig arkAppConfig = this.arkAppConfig;
                Intrinsics.checkNotNull(arkAppConfig);
                z17 = true;
                arkAppView9.setBorderType(!arkAppConfig.isRectangleBorder() ? 1 : 0);
            } else {
                z17 = true;
            }
            ArkAppView arkAppView10 = this.arkView;
            if (arkAppView10 != null) {
                arkAppView10.setAlignLeft(msgItem.isSelf() ^ z17);
            }
            ArkAppView arkAppView11 = this.arkView;
            if (arkAppView11 != null) {
                arkAppView11.setMsgRecord(msgRecord);
            }
            ArkAppView arkAppView12 = this.arkView;
            if (arkAppView12 != null) {
                arkAppView12.setViewKey(O1(str, str8, z16));
            }
            ArkAppView arkAppView13 = this.arkView;
            if (arkAppView13 != null) {
                arkAppContainer3 = arkAppContainer5;
                arkAppView13.d(arkAppContainer3, this.loadLayout, false);
            } else {
                arkAppContainer3 = arkAppContainer5;
            }
            h2(t26, msgRecord, arkAppContainer3, this.arkView);
            return;
        }
        QLog.e("AIOShopArkContentComponent", 1, "element.arkElement data is null or empty");
    }

    private final String O1(String appName, String appView, boolean isShowArk) {
        return appName + "_" + appView + "_" + isShowArk;
    }

    private final ArkAppContainer Q1(com.tencent.aio.api.runtime.a aioContext, long messageId, boolean isFromShot) {
        return R1(t.INSTANCE.b(aioContext), messageId, isFromShot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArkAppContainer R1(t containerHelper, long messageId, boolean isFromShot) {
        if (isFromShot) {
            if (containerHelper == null) {
                return null;
            }
            return containerHelper.p(messageId);
        }
        if (containerHelper == null) {
            return null;
        }
        return containerHelper.o(messageId);
    }

    private final double V1(View view) {
        if (!view.getGlobalVisibleRect(new Rect())) {
            return 0.0d;
        }
        return ((r0.width() * 1.0d) * r0.height()) / (view.getWidth() * view.getHeight());
    }

    private final boolean W1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    private final boolean Y1(String appName, String appView, boolean isShowArk) {
        String str;
        if (this.arkRootView == null || this.arkView == null) {
            return true;
        }
        String O1 = O1(appName, appView, isShowArk);
        ArkAppView arkAppView = this.arkView;
        if (arkAppView != null) {
            str = arkAppView.c();
        } else {
            str = null;
        }
        return !TextUtils.equals(O1, str);
    }

    private final boolean Z1(MsgRecord msgRecord) {
        qx3.a aVar = this.delegate;
        if (aVar != null) {
            return aVar.b(msgRecord);
        }
        return true;
    }

    private final String a2(String appName, String meta, MsgRecord msgRecord) {
        Bundle bundle;
        AIOParam g16;
        String replace$default;
        String replace$default2;
        if (!TextUtils.isEmpty(appName) && !TextUtils.isEmpty(meta)) {
            if (TextUtils.equals("com.tencent.giftmall.giftark", appName)) {
                replace$default = StringsKt__StringsJVMKt.replace$default(meta, "#sender#", String.valueOf(MsgExtKt.S(msgRecord) ? 1 : 0), false, 4, (Object) null);
                replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "#msgId#", String.valueOf(msgRecord.msgId), false, 4, (Object) null);
                return replace$default2;
            }
            if (TextUtils.equals("com.tencent.template.public", appName)) {
                com.tencent.aio.api.runtime.a P1 = P1();
                if (P1 != null && (g16 = P1.g()) != null) {
                    bundle = g16.l();
                } else {
                    bundle = null;
                }
                return a81.f.f25705a.a(meta, msgRecord, bundle);
            }
            return meta;
        }
        return meta;
    }

    private final void c2(t containerHelper, long messageId, boolean isFromShot, ArkAppContainer arkAppContainer) {
        if (isFromShot && containerHelper != null) {
            WeakReference<ArkAppContainer> g16 = arkAppContainer.g();
            Intrinsics.checkNotNullExpressionValue(g16, "arkAppContainer.weakReference");
            containerHelper.s(messageId, g16);
        }
        if (containerHelper != null) {
            WeakReference<ArkAppContainer> g17 = arkAppContainer.g();
            Intrinsics.checkNotNullExpressionValue(g17, "arkAppContainer.weakReference");
            containerHelper.r(messageId, g17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(final com.tencent.aio.api.runtime.a aioContext, final int position) {
        this.contentView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.shop.a
            @Override // java.lang.Runnable
            public final void run() {
                AIOShopArkContentComponent.e2(AIOShopArkContentComponent.this, aioContext, position);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(AIOShopArkContentComponent this$0, com.tencent.aio.api.runtime.a aVar, int i3) {
        j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        double V1 = this$0.V1(this$0.contentView);
        QLog.d("AIOShopArkContentComponent", 1, "ShopArkMsgItem is last, visibleRect = " + V1);
        if (V1 < 1.0d && aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new AIOMsgListEvent.ScrollToPosition(i3));
        }
    }

    private final void f2() {
        int dip2px = ViewUtils.dip2px(8.0f);
        this.contentView.setOutlineProvider(new d(ViewUtils.dip2px(20.0f), dip2px));
        this.contentView.setClipToOutline(true);
    }

    private final void g2(ArkAppLoadLayout appLoadLayout, ArkAppContainer appContainer, ArkAppView appView, int preferredHeight, float scale) {
        Rect rect;
        int i3;
        if (appLoadLayout != null) {
            ViewGroup.LayoutParams layoutParams = appLoadLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = a.C7329a.f192417a.b();
            if (preferredHeight > 0) {
                i3 = preferredHeight;
            } else {
                i3 = a81.d.f25688f;
            }
            layoutParams2.height = i3;
            appLoadLayout.setLayoutParams(layoutParams2);
        }
        if (preferredHeight <= 0) {
            return;
        }
        if (appContainer != null && scale > 0.0f) {
            appContainer.getContainerRect().bottom = (int) (preferredHeight / scale);
        }
        ArkViewImplement arkViewImplement = appView.mViewImpl;
        if (arkViewImplement != null && (rect = arkViewImplement.mRectView) != null) {
            rect.bottom = preferredHeight;
            arkViewImplement.mPreferredHeight = (int) (preferredHeight / scale);
        }
        ViewGroup.LayoutParams layoutParams3 = appView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams3, "appView.layoutParams");
        layoutParams3.height = preferredHeight;
        appView.setLayoutParams(layoutParams3);
    }

    private final void h2(com.tencent.qqnt.msg.data.a arkMsgModel, MsgRecord msgRecord, ArkAppContainer arkAppContainer, ArkViewImplement.ArkViewInterface viewInterface) {
        if (!com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(T1(arkMsgModel, msgRecord, arkAppContainer));
        this.contentView.setContentDescription(sb5);
        if (viewInterface != null) {
            viewInterface.setContentDescription(sb5);
        }
        QLog.i("AIOShopArkContentComponent", 1, "Type is normal, and talkbackText is " + ((Object) sb5));
    }

    private final void i2(ArkAppContainer arkContainer, ArkAppConfig arkConfig, String appName, int preferredHeight, MsgRecord msgRecord) {
        boolean z16;
        Integer configWidth;
        e.Companion companion;
        StringBuilder sb5;
        int i3;
        int i16;
        int i17;
        int i18;
        boolean z17;
        int i19;
        int i26;
        int i27;
        Integer num;
        int width;
        Integer num2 = arkConfig.autoSize;
        Integer configHeight = 0;
        if (num2 != null && num2 != null && num2.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int U1 = U1();
        e.Companion companion2 = a81.e.INSTANCE;
        int c16 = companion2.c();
        boolean l3 = companion2.l(arkConfig);
        StringBuilder sb6 = new StringBuilder("isSetSize=");
        sb6.append(l3);
        sb6.append(",param=[");
        Integer num3 = arkConfig.width;
        if (num3 == null) {
            configWidth = configHeight;
        } else {
            configWidth = num3;
        }
        Integer num4 = arkConfig.height;
        if (num4 != null) {
            configHeight = num4;
        }
        if (l3) {
            float b16 = com.tencent.qqnt.aio.utils.h.b();
            Intrinsics.checkNotNullExpressionValue(configWidth, "configWidth");
            int intValue = configWidth.intValue();
            Intrinsics.checkNotNullExpressionValue(configHeight, "configHeight");
            Integer num5 = configWidth;
            sb5 = sb6;
            i16 = c16;
            companion = companion2;
            e.b q16 = companion2.q(b16, intValue, configHeight.intValue(), U1, i16);
            if (z16) {
                width = U1;
            } else {
                width = q16.getWidth();
            }
            this.mArkWidth = width;
            int height = q16.getHeight();
            this.mArkHeight = height;
            arkContainer.setFixSize(this.mArkWidth, height);
            sb5.append("arkConfig.width=");
            sb5.append(num5.intValue());
            sb5.append(",arkConfig.height=");
            sb5.append(configHeight.intValue());
            sb5.append("][autoSize=");
            sb5.append(z16);
            sb5.append(",maxSize=");
            sb5.append(U1);
            sb5.append("][size=");
            sb5.append(q16.getWidth());
            sb5.append(",");
            sb5.append(q16.getHeight());
            sb5.append("]");
            sb5.append("],app=");
            i3 = -1;
            sb5.append(appName);
        } else {
            Integer configWidth2 = configWidth;
            companion = companion2;
            sb5 = sb6;
            i3 = -1;
            i16 = c16;
            if (z16) {
                i17 = U1;
            } else {
                i17 = -1;
            }
            this.mArkWidth = i17;
            this.mArkHeight = -1;
            if (z16) {
                i18 = U1;
            } else {
                i18 = -1;
            }
            arkContainer.setFixSize(i18, -1);
            sb5.append("arkConfig.width=");
            Intrinsics.checkNotNullExpressionValue(configWidth2, "configWidth");
            sb5.append(configWidth2.intValue());
            sb5.append(",arkConfig.height=");
            Intrinsics.checkNotNullExpressionValue(configHeight, "configHeight");
            sb5.append(configHeight.intValue());
            sb5.append("][autoSize=");
            sb5.append(z16);
            sb5.append(",maxSize=");
            sb5.append(U1);
            sb5.append("]");
            sb5.append(",app=");
            sb5.append(appName);
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOShopArkContentComponent", 2, sb5.toString());
        }
        ArkAppConfig arkAppConfig = this.arkAppConfig;
        if (arkAppConfig != null && (num = arkAppConfig.showSender) != null && num.intValue() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17 && (i26 = msgRecord.chatType) != 103 && i26 != 118 && i26 != 201) {
            e.Companion companion3 = companion;
            int b17 = e.Companion.b(companion3, 30.0f, 0.0f, 2, null);
            int b18 = e.Companion.b(companion3, 30.0f, 0.0f, 2, null);
            if (preferredHeight <= 0) {
                i27 = U1;
            } else {
                i27 = preferredHeight;
            }
            arkContainer.setMinSize(b17, b18);
            arkContainer.setHintSize(i3, i27);
            arkContainer.i(U1, preferredHeight);
            arkContainer.setMaxSize(U1, i16);
            return;
        }
        e.Companion companion4 = companion;
        arkContainer.setFixSize(U1, i3);
        arkContainer.setMaxSize(U1, i3);
        int b19 = e.Companion.b(companion4, 352.0f, 0.0f, 2, null);
        if (companion4.k(this.arkAppConfig)) {
            ArkAppConfig arkAppConfig2 = this.arkAppConfig;
            Intrinsics.checkNotNull(arkAppConfig2);
            Intrinsics.checkNotNull(arkAppConfig2.hintWidth);
            int b26 = e.Companion.b(companion4, r5.intValue(), 0.0f, 2, null);
            ArkAppConfig arkAppConfig3 = this.arkAppConfig;
            Intrinsics.checkNotNull(arkAppConfig3);
            Intrinsics.checkNotNull(arkAppConfig3.hintHeight);
            i19 = b26;
            b19 = e.Companion.b(companion4, r7.intValue(), 0.0f, 2, null);
        } else {
            i19 = i3;
        }
        arkContainer.setHintSize(i19, b19);
        arkContainer.i(U1, b19);
    }

    public final void N1() {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        View view = this.arkRootView;
        RelativeLayout.LayoutParams layoutParams2 = null;
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 != null) {
            layoutParams2.addRule(3, R.id.f84654mu);
        }
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        d.e eVar = new d.e(null, 1, null);
        sendIntent(new d.h(eVar));
        return eVar.a();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return true;
    }

    @Nullable
    public final ArkAppView S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArkAppView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.arkView;
    }

    @Nullable
    protected String T1(@Nullable com.tencent.qqnt.msg.data.a arkMsgModel, @NotNull MsgRecord msgRecord, @NotNull ArkAppContainer arkAppContainer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, this, arkMsgModel, msgRecord, arkAppContainer);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(arkAppContainer, "arkAppContainer");
        if (arkMsgModel == null) {
            QLog.e("AIOShopArkContentComponent", 1, "getContentDescription arkMsgModel null");
            return "";
        }
        if (arkMsgModel.n() == null) {
            QLog.e("AIOShopArkContentComponent", 1, "getContentDescription arkMsgModel promptText null");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (MsgExtKt.S(msgRecord)) {
            sb5.append("\u53d1\u51fa");
        } else {
            sb5.append("\u53d1\u6765");
        }
        sb5.append(arkMsgModel.n());
        String talkBackText = arkAppContainer.getTalkBackText();
        Intrinsics.checkNotNullExpressionValue(talkBackText, "arkAppContainer.talkBackText");
        if (!TextUtils.isEmpty(talkBackText)) {
            sb5.append(talkBackText);
        }
        return sb5.toString();
    }

    protected int U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return a81.d.f25687e;
    }

    @QAutoInitMethod
    public final void X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.delegate = (qx3.a) com.tencent.mobileqq.qroute.utils.b.a(Q);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        Object last;
        View view;
        qx3.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        boolean W1 = W1(payloads);
        long msgId = msgItem.getMsgId();
        com.tencent.aio.api.runtime.a P1 = P1();
        ArkAppContainer Q1 = Q1(P1, msgId, q1().n2());
        if (W1 || Q1 == null) {
            this.contentView.setLayoutParams(new LinearLayout.LayoutParams(U1(), -2));
            this.contentView.setTag("ArkContentView");
            this.contentView.setPadding(0, 0, 0, ViewUtils.dip2px(20.0f));
            f2();
            Integer num = null;
            if (msgItem instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
                ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().elements;
                Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
                if (true ^ arrayList.isEmpty()) {
                    RelativeLayout relativeLayout = this.contentView;
                    ArrayList<MsgElement> arrayList2 = aIOMsgItem.getMsgRecord().elements;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "msgItem.msgRecord.elements");
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList2);
                    Intrinsics.checkNotNullExpressionValue(last, "msgItem.msgRecord.elements.last()");
                    M1(position, relativeLayout, (MsgElement) last, aIOMsgItem.getMsgRecord(), msgItem);
                    if (this.shopAdContainer == null) {
                        qx3.a aVar2 = this.delegate;
                        if (aVar2 != null) {
                            view = aVar2.e(this.contentView, U1());
                        } else {
                            view = null;
                        }
                        this.shopAdContainer = view;
                        if (view != null) {
                            view.setId(R.id.f84654mu);
                        }
                    }
                    if (!(msgItem instanceof g) || !((g) msgItem).w2()) {
                        N1();
                    }
                }
            }
            if (P1 != null && (g16 = P1.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                num = Integer.valueOf(c16.e());
            }
            ((IAIOReport) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOReport.class)).reportArkExpo(position, num, q1().getMsgRecord());
        }
        if ((msgItem instanceof g) && (aVar = this.delegate) != null) {
            aVar.d(((g) msgItem).getMsgRecord(), position, (k) msgItem);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (View) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.contentView;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        qx3.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOShopArkUIState.VideoPlayEvent) {
            qx3.a aVar2 = this.delegate;
            if (aVar2 != null) {
                aVar2.c(((AIOShopArkUIState.VideoPlayEvent) state).a());
                return;
            }
            return;
        }
        if ((state instanceof AIOShopArkUIState.ScrollStateChanged) && (aVar = this.delegate) != null) {
            aVar.a(((AIOShopArkUIState.ScrollStateChanged) state).a());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return new com.tencent.mobileqq.aio.shop.b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        boolean z16 = false;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new u(getMContext(), q1(), this));
        ArkAppConfig arkAppConfig = this.arkAppConfig;
        if (arkAppConfig != null && (num = arkAppConfig.forward) != null && num.intValue() == 1) {
            z16 = true;
        }
        if (z16) {
            mutableListOf.add(new u(getMContext(), q1(), this));
        }
        return mutableListOf;
    }
}
