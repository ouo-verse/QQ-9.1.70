package com.tencent.mobileqq.aio.msglist.holder.component.ark;

import a81.d;
import a81.e;
import a81.f;
import a81.g;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ark;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.AIOArkContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppView;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.utils.aa;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.api.IAIOReport;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ao;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.utils.h;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QQConnectAttr;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.data.a;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQCustomArkDialogUtil;
import defpackage.MsgListUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b=\b\u0016\u0018\u0000 \u0096\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0097\u0001B\u0011\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J,\u0010\u0018\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J4\u0010\"\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0002J8\u0010(\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00142\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010*\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002J \u0010,\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010+\u001a\u00020\u001eH\u0002J \u0010-\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010+\u001a\u00020\u001eH\u0002J \u0010/\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010.\u001a\u00020&2\u0006\u0010\r\u001a\u00020\fH\u0002J$\u00105\u001a\u0004\u0018\u00010\u00142\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0006H\u0002J$\u00108\u001a\u0004\u0018\u00010\u00142\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u0006H\u0002J*\u00109\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020\u00062\u0006\u0010;\u001a\u00020:H\u0002J\u001c\u0010?\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\u00142\b\u0010>\u001a\u0004\u0018\u00010=H\u0002J\b\u0010@\u001a\u0004\u0018\u000100J&\u0010B\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\n\u0010D\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010E\u001a\u00020\u001eH\u0016J$\u0010G\u001a\u0004\u0018\u00010&2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010H\u001a\u00020\u001eH\u0014J2\u0010O\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010I\u001a\u0004\u0018\u00010&2\u0006\u0010J\u001a\u00020C2\u0006\u0010L\u001a\u00020K2\u0006\u0010N\u001a\u00020MJ\b\u0010P\u001a\u00020CH\u0016J\u000e\u0010S\u001a\b\u0012\u0004\u0012\u00020R0QH\u0016R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R$\u0010e\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010l\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010`\u001a\u0004\bn\u0010b\"\u0004\bo\u0010dR$\u0010L\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010N\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR&\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R(\u0010\u0085\u0001\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0082\u0001\u0010`\u001a\u0005\b\u0083\u0001\u0010b\"\u0005\b\u0084\u0001\u0010dR+\u0010\u008c\u0001\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R+\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/AIOArkContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/ArkMsgItem;", "", "", "payloads", "", "Z1", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "L1", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppContainer;", "arkAppContainer", "Lcom/tencent/ark/ArkViewImplement$ArkViewInterface;", "viewInterface", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "appLoadLayout", "appContainer", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;", QQCustomArkDialogUtil.APP_VIEW, "", "preferredHeight", "", "scale", "f2", "arkContainer", "Lcom/tencent/ark/data/ArkAppConfig;", "arkConfig", "", "appName", "i2", "arkDataJson", "Y1", "qunShareArkType", "M1", ICustomDataEditor.STRING_ARRAY_PARAM_2, PublicAccountMessageUtilImpl.META_NAME, "d2", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "messageId", "isFromShot", "S1", "Lcom/tencent/mobileqq/aio/helper/t;", "containerHelper", "T1", "e2", "Landroid/content/Context;", "context", "c2", "Lcom/tencent/qqnt/kernel/nativeinterface/QQConnectAttr;", "qqConnectAttr", "g2", "N1", "position", "b1", "Landroid/view/View;", "e1", "importance", "l1", "V1", "X1", ark.APP_SPECIFIC_BIZSRC, "appInfoLayoutView", "Landroid/widget/ImageView;", "appInfoIconIv", "Landroid/widget/TextView;", "appInfoNameTv", "j2", "c1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", BdhLogUtil.LogTag.Tag_Conn, "I", "mArkWidth", "D", "mArkHeight", "Landroid/widget/LinearLayout;", "E", "Landroid/widget/LinearLayout;", "contentView", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "setRootView", "(Landroid/view/View;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "G", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;", "U1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;", "setArkView", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/view/ArkAppView;)V", "arkView", "H", "P1", "setAppInfoLayoutView", "Landroid/widget/ImageView;", "O1", "()Landroid/widget/ImageView;", "setAppInfoIconIv", "(Landroid/widget/ImageView;)V", "J", "Landroid/widget/TextView;", "Q1", "()Landroid/widget/TextView;", "setAppInfoNameTv", "(Landroid/widget/TextView;)V", "K", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "W1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "setLoadLayout", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;)V", "loadLayout", "L", "getArkViewLayout", "setArkViewLayout", "arkViewLayout", "M", "Lcom/tencent/ark/data/ArkAppConfig;", "R1", "()Lcom/tencent/ark/data/ArkAppConfig;", "setArkAppConfig", "(Lcom/tencent/ark/data/ArkAppConfig;)V", "arkAppConfig", "N", "Lcom/tencent/qqnt/msg/data/a;", "getMArkMsgModel", "()Lcom/tencent/qqnt/msg/data/a;", "setMArkMsgModel", "(Lcom/tencent/qqnt/msg/data/a;)V", "mArkMsgModel", "<init>", "(Landroid/content/Context;)V", "P", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOArkContentComponent extends BaseContentComponent<ArkMsgItem> {
    private static final boolean Q = true;
    private static int R;

    /* renamed from: C, reason: from kotlin metadata */
    private int mArkWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int mArkHeight;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout contentView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ArkAppView arkView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View appInfoLayoutView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView appInfoIconIv;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView appInfoNameTv;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ArkAppLoadLayout loadLayout;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View arkViewLayout;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ArkAppConfig arkAppConfig;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private a mArkMsgModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0017J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/ark/AIOArkContentComponent$b", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "state", "errorCode", "", "msg", "", "canRetry", "", "onLoadFailed", "onLoadState", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements ArkViewImplement.LoadCallback {
        final /* synthetic */ Ref.ObjectRef<String> C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f190668d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIOArkContentComponent f190669e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f190670f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f190671h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ float f190672i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f190673m;

        b(String str, AIOArkContentComponent aIOArkContentComponent, t tVar, long j3, float f16, String str2, Ref.ObjectRef<String> objectRef) {
            this.f190668d = str;
            this.f190669e = aIOArkContentComponent;
            this.f190670f = tVar;
            this.f190671h = j3;
            this.f190672i = f16;
            this.f190673m = str2;
            this.C = objectRef;
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        @TargetApi(14)
        public void onLoadFailed(int state, int errorCode, @Nullable String msg2, boolean canRetry) {
            onLoadState(state);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        @TargetApi(14)
        public void onLoadState(int state) {
            if (state == -1) {
                QLog.d("AIOArkContentComponent", 2, "onLoadFinish state = ", Integer.valueOf(state), " ,appName = ", this.f190668d);
            }
            if (state == 1) {
                View appInfoLayoutView = this.f190669e.getAppInfoLayoutView();
                if (appInfoLayoutView != null) {
                    AIOArkContentComponent aIOArkContentComponent = this.f190669e;
                    String str = this.f190668d;
                    String str2 = this.C.element;
                    ImageView appInfoIconIv = aIOArkContentComponent.getAppInfoIconIv();
                    Intrinsics.checkNotNull(appInfoIconIv);
                    TextView appInfoNameTv = aIOArkContentComponent.getAppInfoNameTv();
                    Intrinsics.checkNotNull(appInfoNameTv);
                    aIOArkContentComponent.j2(str, str2, appInfoLayoutView, appInfoIconIv, appInfoNameTv);
                }
                AIOArkContentComponent aIOArkContentComponent2 = this.f190669e;
                ArkAppContainer T1 = aIOArkContentComponent2.T1(this.f190670f, this.f190671h, AIOArkContentComponent.K1(aIOArkContentComponent2).n2());
                if (T1 == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(T1.getContainerRect(), "container.containerRect");
                float f16 = this.f190672i;
                int i3 = (int) ((r0.right - r0.left) * f16);
                int i16 = (int) (f16 * (r0.bottom - r0.top));
                ArkAppView arkView = this.f190669e.getArkView();
                Intrinsics.checkNotNull(arkView);
                ViewGroup.LayoutParams layoutParams = arkView.getLayoutParams();
                Intrinsics.checkNotNullExpressionValue(layoutParams, "arkView!!.layoutParams");
                e.Companion companion = e.INSTANCE;
                e g16 = companion.g();
                if (g16 != null) {
                    g16.q(this.f190671h, this.f190668d, this.f190673m, layoutParams.height);
                }
                if (companion.j()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOArkContentComponent", 2, "ArkFold.onLoadFinish arkContainer rect(" + i3 + "," + i16 + "), arkView layout rect(" + layoutParams.width + "," + layoutParams.height + "), init mArkWidth=" + this.f190669e.mArkWidth + ",mArkHeight=" + this.f190669e.mArkHeight + ",appName=" + this.f190668d);
                    }
                }
                ArkMsgItem K1 = AIOArkContentComponent.K1(this.f190669e);
                String d16 = T1.d();
                Intrinsics.checkNotNullExpressionValue(d16, "container.appVersion");
                K1.u2(d16);
                ArkAppView arkView2 = this.f190669e.getArkView();
                if (arkView2 != null) {
                    arkView2.removeView(this.f190669e.getLoadLayout());
                }
            }
        }
    }

    public AIOArkContentComponent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.contentView = new LinearLayout(context);
    }

    public static final /* synthetic */ ArkMsgItem K1(AIOArkContentComponent aIOArkContentComponent) {
        return aIOArkContentComponent.q1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void L1(ViewGroup parent, MsgElement element, MsgRecord msgRecord, com.tencent.aio.data.msglist.a msgItem) {
        String str;
        String str2;
        String str3;
        String str4;
        View inflate;
        ArkAppView arkAppView;
        View view;
        ImageView imageView;
        TextView textView;
        ArkAppLoadLayout arkAppLoadLayout;
        View view2;
        int dimension;
        ViewGroup.LayoutParams layoutParams;
        ArkAppContainer arkAppContainer;
        int i3;
        boolean z16;
        ArkAppContainer arkAppContainer2;
        t tVar;
        long j3;
        a aVar;
        com.tencent.aio.api.runtime.a aVar2;
        ArkAppContainer arkAppContainer3;
        MsgAttributeInfo msgAttributeInfo;
        QQConnectAttr qQConnectAttr;
        e g16;
        Ref.ObjectRef objectRef;
        String str5;
        String str6;
        int i16;
        ArkAppView arkAppView2;
        ArkAppView arkAppView3;
        ArkAppView arkAppView4;
        boolean z17;
        ArkAppView arkAppView5;
        ArkAppView arkAppView6;
        ArkAppView arkAppView7;
        ArkAppView arkAppView8;
        ArkElement arkElement = element.arkElement;
        if (arkElement != null && !TextUtils.isEmpty(arkElement.bytesData)) {
            a t26 = q1().t2();
            if (t26 == null) {
                QLog.e("AIOArkContentComponent", 1, "element.arkElement.bytesData parse error = " + element.arkElement.bytesData);
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
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            String f16 = t26.f();
            T t16 = f16;
            if (f16 == null) {
                t16 = "";
            }
            objectRef2.element = t16;
            String d26 = d2(str, m3, msgRecord);
            String c16 = t26.c();
            if (c16 == null) {
                str3 = "";
            } else {
                str3 = c16;
            }
            String g17 = t26.g();
            if (g17 == null) {
                str4 = "";
            } else {
                str4 = g17;
            }
            int Y1 = Y1(str, str2, q1().k2());
            boolean a26 = a2(str, str2, Y1);
            if (a26 && this.contentView.getChildCount() > 0) {
                ArkAppView arkAppView9 = this.arkView;
                if (arkAppView9 != null) {
                    arkAppView9.destroyBitmapBuffer();
                }
                ArkAppView arkAppView10 = this.arkView;
                if (arkAppView10 != null) {
                    arkAppView10.releaseViewContext();
                }
                ArkAppView arkAppView11 = this.arkView;
                if (arkAppView11 != null) {
                    arkAppView11.removeAllViews();
                }
                this.contentView.removeAllViews();
            }
            Integer num = null;
            if (this.rootView == null || a26) {
                if (MsgListUtil.f24918a.u()) {
                    new g().i(parent.getContext(), this.contentView);
                    inflate = this.contentView;
                } else {
                    inflate = View.inflate(parent.getContext(), R.layout.du_, this.contentView);
                }
                this.rootView = inflate;
                if (inflate != null) {
                    arkAppView = (ArkAppView) inflate.findViewById(R.id.y_);
                } else {
                    arkAppView = null;
                }
                this.arkView = arkAppView;
                View view3 = this.rootView;
                if (view3 != null) {
                    view = view3.findViewById(R.id.f164456yf);
                } else {
                    view = null;
                }
                this.appInfoLayoutView = view;
                View view4 = this.rootView;
                if (view4 != null) {
                    imageView = (ImageView) view4.findViewById(R.id.f164455ye);
                } else {
                    imageView = null;
                }
                this.appInfoIconIv = imageView;
                View view5 = this.rootView;
                if (view5 != null) {
                    textView = (TextView) view5.findViewById(R.id.f164457yg);
                } else {
                    textView = null;
                }
                this.appInfoNameTv = textView;
                View view6 = this.rootView;
                if (view6 != null) {
                    arkAppLoadLayout = (ArkAppLoadLayout) view6.findViewById(R.id.eet);
                } else {
                    arkAppLoadLayout = null;
                }
                this.loadLayout = arkAppLoadLayout;
                View view7 = this.rootView;
                if (view7 != null) {
                    view2 = view7.findViewById(R.id.svh);
                } else {
                    view2 = null;
                }
                this.arkViewLayout = view2;
                int dimension2 = (int) getMContext().getResources().getDimension(R.dimen.f158247b9);
                float f17 = 10;
                int i17 = (int) (this.context.getResources().getDisplayMetrics().density * f17);
                int dimension3 = (int) getMContext().getResources().getDimension(R.dimen.b_);
                if (e.INSTANCE.m(t26, q1())) {
                    dimension = (int) (this.context.getResources().getDisplayMetrics().density * f17);
                } else {
                    dimension = (int) getMContext().getResources().getDimension(R.dimen.f158192a0);
                }
                View view8 = this.arkViewLayout;
                if (view8 != null) {
                    layoutParams = view8.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                ((RelativeLayout.LayoutParams) layoutParams).addRule(14);
                View view9 = this.arkViewLayout;
                if (view9 != null) {
                    view9.setPadding(dimension2, i17, dimension3, dimension);
                }
            }
            if (TextUtils.isEmpty(ArkAppCacheMgr.getApplicationDesc(str))) {
                View view10 = this.appInfoLayoutView;
                if (view10 != null) {
                    view10.setVisibility(8);
                }
            } else {
                View view11 = this.appInfoLayoutView;
                if (view11 != null) {
                    view11.setVisibility(4);
                }
            }
            float f18 = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().scaledDensity;
            long j16 = msgRecord.msgId;
            e.Companion companion = e.INSTANCE;
            if (companion.j()) {
                QLog.d("AIOArkContentComponent", 2, "arkDebugMeta  meta = " + d26 + ", msgId = " + j16);
            }
            com.tencent.aio.api.runtime.a N1 = N1();
            t b16 = t.INSTANCE.b(N1);
            ArkAppContainer T1 = T1(b16, j16, q1().n2());
            if (T1 != null) {
                boolean z18 = T1.needRefresh;
                arkAppContainer = T1;
                i3 = 1;
                if (z18) {
                    z16 = true;
                    if (!z16) {
                        QLog.i("AIOArkContentComponent", i3, "arkAppContainer needRefresh, set null ");
                        arkAppContainer2 = null;
                    } else {
                        arkAppContainer2 = arkAppContainer;
                    }
                    if (arkAppContainer2 != null) {
                        arkAppContainer3 = new ArkAppContainer(N1);
                        boolean z19 = Q;
                        arkAppContainer3.setIndependentView(z19);
                        arkAppContainer3.setMemoryOptimized(z19);
                        tVar = b16;
                        aVar = t26;
                        aVar2 = N1;
                        j3 = j16;
                        e2(b16, j16, q1().n2(), arkAppContainer3);
                    } else {
                        tVar = b16;
                        j3 = j16;
                        aVar = t26;
                        aVar2 = N1;
                        arkAppContainer3 = arkAppContainer2;
                    }
                    arkAppContainer3.init(str, str2, str3, d26, str4, (String) objectRef2.element, f18);
                    arkAppContainer3.h(aVar2);
                    arkAppContainer3.j(msgRecord);
                    msgAttributeInfo = msgRecord.msgAttrs.get(12);
                    if (msgAttributeInfo == null) {
                        qQConnectAttr = msgAttributeInfo.qqConnectAttr;
                    } else {
                        qQConnectAttr = null;
                    }
                    g2(arkAppContainer3, qQConnectAttr);
                    g16 = companion.g();
                    if (g16 == null) {
                        objectRef = objectRef2;
                        str5 = str2;
                        str6 = str;
                        num = Integer.valueOf(g16.p(j3, str, str2, aVar));
                    } else {
                        objectRef = objectRef2;
                        str5 = str2;
                        str6 = str;
                    }
                    if (num == null) {
                        ArkAppLoadLayout arkAppLoadLayout2 = this.loadLayout;
                        ArkAppView arkAppView12 = this.arkView;
                        Intrinsics.checkNotNull(arkAppView12);
                        i16 = Y1;
                        f2(arkAppLoadLayout2, arkAppContainer3, arkAppView12, num.intValue(), f18);
                    } else {
                        i16 = Y1;
                    }
                    String str7 = str5;
                    b bVar = new b(str6, this, tVar, j3, f18, str5, objectRef);
                    arkAppView2 = this.arkView;
                    if (arkAppView2 != null) {
                        arkAppView2.setLoadCallback(bVar);
                    }
                    ArkAppConfig e17 = arkAppContainer3.e();
                    this.arkAppConfig = e17;
                    if (num != null) {
                        Intrinsics.checkNotNull(e17);
                        i2(arkAppContainer3, e17, str6, num.intValue(), msgRecord, aVar);
                    }
                    arkAppView3 = this.arkView;
                    if (arkAppView3 != null) {
                        arkAppView3.setClipRadius(10.0f);
                    }
                    arkAppView4 = this.arkView;
                    if (arkAppView4 == null) {
                        ArkAppConfig arkAppConfig = this.arkAppConfig;
                        Intrinsics.checkNotNull(arkAppConfig);
                        z17 = true;
                        arkAppView4.setBorderType(!arkAppConfig.isRectangleBorder() ? 1 : 0);
                    } else {
                        z17 = true;
                    }
                    arkAppView5 = this.arkView;
                    if (arkAppView5 != null) {
                        arkAppView5.setAlignLeft(msgItem.isSelf() ^ z17);
                    }
                    arkAppView6 = this.arkView;
                    if (arkAppView6 != null) {
                        arkAppView6.setMsgRecord(msgRecord);
                    }
                    arkAppView7 = this.arkView;
                    if (arkAppView7 != null) {
                        arkAppView7.setViewKey(M1(str6, str7, i16));
                    }
                    arkAppView8 = this.arkView;
                    if (arkAppView8 != null) {
                        arkAppView8.d(arkAppContainer3, this.loadLayout, false);
                    }
                    h2(aVar, msgRecord, arkAppContainer3, this.arkView);
                    return;
                }
            } else {
                arkAppContainer = T1;
                i3 = 1;
            }
            z16 = false;
            if (!z16) {
            }
            if (arkAppContainer2 != null) {
            }
            arkAppContainer3.init(str, str2, str3, d26, str4, (String) objectRef2.element, f18);
            arkAppContainer3.h(aVar2);
            arkAppContainer3.j(msgRecord);
            msgAttributeInfo = msgRecord.msgAttrs.get(12);
            if (msgAttributeInfo == null) {
            }
            g2(arkAppContainer3, qQConnectAttr);
            g16 = companion.g();
            if (g16 == null) {
            }
            if (num == null) {
            }
            String str72 = str5;
            b bVar2 = new b(str6, this, tVar, j3, f18, str5, objectRef);
            arkAppView2 = this.arkView;
            if (arkAppView2 != null) {
            }
            ArkAppConfig e172 = arkAppContainer3.e();
            this.arkAppConfig = e172;
            if (num != null) {
            }
            arkAppView3 = this.arkView;
            if (arkAppView3 != null) {
            }
            arkAppView4 = this.arkView;
            if (arkAppView4 == null) {
            }
            arkAppView5 = this.arkView;
            if (arkAppView5 != null) {
            }
            arkAppView6 = this.arkView;
            if (arkAppView6 != null) {
            }
            arkAppView7 = this.arkView;
            if (arkAppView7 != null) {
            }
            arkAppView8 = this.arkView;
            if (arkAppView8 != null) {
            }
            h2(aVar, msgRecord, arkAppContainer3, this.arkView);
            return;
        }
        QLog.e("AIOArkContentComponent", 1, "element.arkElement data is null or empty");
    }

    private final String M1(String appName, String appView, int qunShareArkType) {
        return appName + "_" + appView + "_" + qunShareArkType;
    }

    private final ArkAppContainer S1(com.tencent.aio.api.runtime.a aioContext, long messageId, boolean isFromShot) {
        return T1(t.INSTANCE.b(aioContext), messageId, isFromShot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArkAppContainer T1(t containerHelper, long messageId, boolean isFromShot) {
        if (c2(getMContext()) && containerHelper != null) {
            containerHelper.u();
        }
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

    private final int Y1(String appName, String appView, String arkDataJson) {
        JSONObject jSONObject;
        if (TextUtils.equals(appName, "com.tencent.qun.pro") && TextUtils.equals(appView, "contact")) {
            try {
                JSONObject optJSONObject = new JSONObject(arkDataJson).optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
                Integer num = null;
                if (optJSONObject != null) {
                    jSONObject = optJSONObject.optJSONObject("contact");
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    num = Integer.valueOf(jSONObject.optInt("ark_type"));
                }
                Intrinsics.checkNotNull(num);
                return num.intValue();
            } catch (Exception e16) {
                QLog.e("AIOArkContentComponent", 1, "getQunProShareArkType e: " + e16.getMessage());
            }
        }
        return 0;
    }

    private final boolean Z1(List<Object> payloads) {
        Iterator<Object> it = payloads.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            if (it.next() instanceof HashMap) {
                z16 = false;
            }
        }
        return z16;
    }

    private final boolean a2(String appName, String appView, int qunShareArkType) {
        String str;
        if (this.rootView == null || this.arkView == null) {
            return true;
        }
        String M1 = M1(appName, appView, qunShareArkType);
        ArkAppView arkAppView = this.arkView;
        if (arkAppView != null) {
            str = arkAppView.c();
        } else {
            str = null;
        }
        return !TextUtils.equals(M1, str);
    }

    private final boolean c2(Context context) {
        if (com.tencent.qqnt.util.b.f362976b.isSplitViewMode(context)) {
            int d16 = a.C7329a.f192417a.d();
            int i3 = R;
            if (i3 == 0) {
                R = d16;
                return false;
            }
            if (i3 != d16) {
                QLog.i("AIOArkContentComponent", 1, "split changed nowSize" + d16 + ", screenSize: " + i3);
                R = d16;
                return true;
            }
            return false;
        }
        return false;
    }

    private final String d2(String appName, String meta, MsgRecord msgRecord) {
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
                com.tencent.aio.api.runtime.a N1 = N1();
                if (N1 != null && (g16 = N1.g()) != null) {
                    bundle = g16.l();
                } else {
                    bundle = null;
                }
                return f.f25705a.a(meta, msgRecord, bundle);
            }
            return meta;
        }
        return meta;
    }

    private final void e2(t containerHelper, long messageId, boolean isFromShot, ArkAppContainer arkAppContainer) {
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

    private final void f2(ArkAppLoadLayout appLoadLayout, ArkAppContainer appContainer, ArkAppView appView, int preferredHeight, float scale) {
        Rect rect;
        int i3;
        if (appLoadLayout != null) {
            int dimension = (int) getMContext().getResources().getDimension(R.dimen.f158247b9);
            int i16 = (int) (this.context.getResources().getDisplayMetrics().density * 10);
            int dimension2 = (int) getMContext().getResources().getDimension(R.dimen.b_);
            int dimension3 = (int) getMContext().getResources().getDimension(R.dimen.f158192a0);
            ViewGroup.LayoutParams layoutParams = appLoadLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = a.C7329a.f192417a.b();
            if (preferredHeight > 0) {
                i3 = preferredHeight;
            } else {
                i3 = d.f25688f;
            }
            layoutParams2.height = i3;
            layoutParams2.setMargins(dimension, i16, dimension2, dimension3);
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

    private final void g2(ArkAppContainer arkContainer, QQConnectAttr qqConnectAttr) {
        if (arkContainer != null && qqConnectAttr != null) {
            arkContainer.setQQConnectParams(String.valueOf(qqConnectAttr.appID), String.valueOf(qqConnectAttr.appType));
        }
    }

    private final void h2(com.tencent.qqnt.msg.data.a arkMsgModel, MsgRecord msgRecord, ArkAppContainer arkAppContainer, ArkViewImplement.ArkViewInterface viewInterface) {
        if (!com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(V1(arkMsgModel, msgRecord, arkAppContainer));
        this.contentView.setContentDescription(sb5);
        if (viewInterface != null) {
            viewInterface.setContentDescription(sb5);
        }
        QLog.i("AIOArkContentComponent", 1, "Type is normal, and talkbackText is " + ((Object) sb5));
    }

    private final void i2(ArkAppContainer arkContainer, ArkAppConfig arkConfig, String appName, int preferredHeight, MsgRecord msgRecord, com.tencent.qqnt.msg.data.a arkMsgModel) {
        boolean z16;
        StringBuilder sb5;
        String str;
        int i3;
        e.Companion companion;
        int i16;
        int i17;
        boolean z17;
        int i18;
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
        int X1 = X1();
        e.Companion companion2 = e.INSTANCE;
        String e16 = arkMsgModel.e();
        if (e16 == null) {
            e16 = "";
        }
        Integer f16 = companion2.f(appName, e16, X1);
        if (f16 != null) {
            X1 = f16.intValue();
            if (QLog.isDevelopLevel()) {
                QLog.d("AIOArkContentComponent", 4, "got hardCodeSize for " + appName + "," + arkMsgModel.e() + ", value is " + f16);
            }
            z16 = true;
        }
        int c16 = companion2.c();
        boolean l3 = companion2.l(arkConfig);
        StringBuilder sb6 = new StringBuilder("isSetSize=");
        sb6.append(l3);
        sb6.append(",param=[");
        Integer configWidth = arkConfig.width;
        if (configWidth == null) {
            configWidth = configHeight;
        }
        Integer num3 = arkConfig.height;
        if (num3 != null) {
            configHeight = num3;
        }
        if (l3) {
            float b16 = h.b();
            Intrinsics.checkNotNullExpressionValue(configWidth, "configWidth");
            int intValue = configWidth.intValue();
            Intrinsics.checkNotNullExpressionValue(configHeight, "configHeight");
            sb5 = sb6;
            i3 = c16;
            str = "AIOArkContentComponent";
            companion = companion2;
            e.b q16 = companion2.q(b16, intValue, configHeight.intValue(), X1, i3);
            if (z16) {
                width = X1;
            } else {
                width = q16.getWidth();
            }
            this.mArkWidth = width;
            int height = q16.getHeight();
            this.mArkHeight = height;
            arkContainer.setFixSize(this.mArkWidth, height);
            sb5.append("arkConfig.width=");
            sb5.append(configWidth.intValue());
            sb5.append(",arkConfig.height=");
            sb5.append(configHeight.intValue());
            sb5.append("][autoSize=");
            sb5.append(z16);
            sb5.append(",maxSize=");
            sb5.append(X1);
            sb5.append("][size=");
            sb5.append(q16.getWidth());
            sb5.append(",");
            sb5.append(q16.getHeight());
            sb5.append("]");
            sb5.append("],app=");
            sb5.append(appName);
        } else {
            sb5 = sb6;
            str = "AIOArkContentComponent";
            i3 = c16;
            companion = companion2;
            if (z16) {
                i16 = X1;
            } else {
                i16 = -1;
            }
            this.mArkWidth = i16;
            this.mArkHeight = -1;
            if (z16) {
                i17 = X1;
            } else {
                i17 = -1;
            }
            arkContainer.setFixSize(i17, -1);
            sb5.append("arkConfig.width=");
            Intrinsics.checkNotNullExpressionValue(configWidth, "configWidth");
            sb5.append(configWidth.intValue());
            sb5.append(",arkConfig.height=");
            Intrinsics.checkNotNullExpressionValue(configHeight, "configHeight");
            sb5.append(configHeight.intValue());
            sb5.append("][autoSize=");
            sb5.append(z16);
            sb5.append(",maxSize=");
            sb5.append(X1);
            sb5.append("]");
            sb5.append(",app=");
            sb5.append(appName);
        }
        if (companion.j()) {
            QLog.i(str, 2, sb5.toString());
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
                i27 = X1;
            } else {
                i27 = preferredHeight;
            }
            arkContainer.setMinSize(b17, b18);
            arkContainer.setHintSize(-1, i27);
            arkContainer.i(X1, preferredHeight);
            arkContainer.setMaxSize(X1, i3);
            return;
        }
        e.Companion companion4 = companion;
        arkContainer.setFixSize(X1, -1);
        arkContainer.setMaxSize(X1, -1);
        int b19 = e.Companion.b(companion4, 352.0f, 0.0f, 2, null);
        if (companion4.k(this.arkAppConfig)) {
            ArkAppConfig arkAppConfig2 = this.arkAppConfig;
            Intrinsics.checkNotNull(arkAppConfig2);
            Intrinsics.checkNotNull(arkAppConfig2.hintWidth);
            i19 = e.Companion.b(companion4, r5.intValue(), 0.0f, 2, null);
            ArkAppConfig arkAppConfig3 = this.arkAppConfig;
            Intrinsics.checkNotNull(arkAppConfig3);
            Intrinsics.checkNotNull(arkAppConfig3.hintHeight);
            i18 = e.Companion.b(companion4, r5.intValue(), 0.0f, 2, null);
        } else {
            i18 = b19;
            i19 = -1;
        }
        arkContainer.setHintSize(i19, i18);
        arkContainer.i(X1, i18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(View appInfoLayoutView, ImageView appInfoIconIv, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(appInfoLayoutView, "$appInfoLayoutView");
        Intrinsics.checkNotNullParameter(appInfoIconIv, "$appInfoIconIv");
        if (bitmap != null) {
            appInfoLayoutView.setVisibility(0);
            appInfoIconIv.setVisibility(0);
            appInfoIconIv.setImageBitmap(bitmap);
            return;
        }
        appInfoIconIv.setVisibility(8);
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a N1() {
        d.e eVar = new d.e(null, 1, null);
        sendIntent(new d.h(eVar));
        return eVar.a();
    }

    @Nullable
    /* renamed from: O1, reason: from getter */
    public final ImageView getAppInfoIconIv() {
        return this.appInfoIconIv;
    }

    @Nullable
    /* renamed from: P1, reason: from getter */
    public final View getAppInfoLayoutView() {
        return this.appInfoLayoutView;
    }

    @Nullable
    /* renamed from: Q1, reason: from getter */
    public final TextView getAppInfoNameTv() {
        return this.appInfoNameTv;
    }

    @Nullable
    /* renamed from: R1, reason: from getter */
    public final ArkAppConfig getArkAppConfig() {
        return this.arkAppConfig;
    }

    @Nullable
    /* renamed from: U1, reason: from getter */
    public final ArkAppView getArkView() {
        return this.arkView;
    }

    @Nullable
    protected String V1(@Nullable com.tencent.qqnt.msg.data.a arkMsgModel, @NotNull MsgRecord msgRecord, @NotNull ArkAppContainer arkAppContainer) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(arkAppContainer, "arkAppContainer");
        if (arkMsgModel == null) {
            QLog.e("AIOArkContentComponent", 1, "getContentDescription arkMsgModel null");
            return "";
        }
        if (arkMsgModel.n() == null) {
            QLog.e("AIOArkContentComponent", 1, "getContentDescription arkMsgModel promptText null");
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

    @Nullable
    /* renamed from: W1, reason: from getter */
    public final ArkAppLoadLayout getLoadLayout() {
        return this.loadLayout;
    }

    protected int X1() {
        return a.C7329a.f192417a.f(true);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Integer num;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        Object last;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        boolean Z1 = Z1(payloads);
        long msgId = msgItem.getMsgId();
        com.tencent.aio.api.runtime.a N1 = N1();
        ArkAppContainer S1 = S1(N1, msgId, q1().n2());
        if (Z1 || S1 == null || S1.needRefresh) {
            this.contentView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.contentView.setTag("ArkContentView");
            if (msgItem instanceof AIOMsgItem) {
                AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
                Intrinsics.checkNotNullExpressionValue(aIOMsgItem.getMsgRecord().elements, "msgItem.msgRecord.elements");
                if (!r0.isEmpty()) {
                    LinearLayout linearLayout = this.contentView;
                    ArrayList<MsgElement> arrayList = aIOMsgItem.getMsgRecord().elements;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
                    last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
                    Intrinsics.checkNotNullExpressionValue(last, "msgItem.msgRecord.elements.last()");
                    L1(linearLayout, (MsgElement) last, aIOMsgItem.getMsgRecord(), msgItem);
                }
            }
            if (N1 != null && (g16 = N1.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                num = Integer.valueOf(c16.e());
            } else {
                num = null;
            }
            ((IAIOReport) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOReport.class)).reportArkExpo(position, num, q1().getMsgRecord());
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        return this.contentView;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        return this.arkView;
    }

    public final void j2(@Nullable String appName, @Nullable String bizSrc, @NotNull final View appInfoLayoutView, @NotNull final ImageView appInfoIconIv, @NotNull TextView appInfoNameTv) {
        Intrinsics.checkNotNullParameter(appInfoLayoutView, "appInfoLayoutView");
        Intrinsics.checkNotNullParameter(appInfoIconIv, "appInfoIconIv");
        Intrinsics.checkNotNullParameter(appInfoNameTv, "appInfoNameTv");
        ArkAppCacheMgr.getAppIcon(appName, bizSrc, new ArkAppCacheMgr.OnGetAppIcon() { // from class: a81.a
            @Override // com.tencent.ark.open.ArkAppCacheMgr.OnGetAppIcon
            public final void callback(String str, Bitmap bitmap) {
                AIOArkContentComponent.k2(appInfoLayoutView, appInfoIconIv, str, bitmap);
            }
        });
        String applicationDesc = ArkAppCacheMgr.getApplicationDesc(appName);
        if (applicationDesc != null) {
            appInfoLayoutView.setVisibility(0);
            appInfoNameTv.setVisibility(0);
            appInfoNameTv.setText(applicationDesc);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        ArkAppView arkAppView = this.arkView;
        if (arkAppView != null) {
            arkAppView.setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        ArrayList arrayList = new ArrayList();
        e.Companion companion = e.INSTANCE;
        if (companion.p(this.mArkMsgModel, q1())) {
            arrayList.add(new ad(getMContext(), q1(), this));
        }
        if (companion.n(this.mArkMsgModel, this.arkAppConfig, N1(), q1())) {
            arrayList.add(new k(getMContext(), q1(), this, null, 8, null));
        }
        if (aa.f194101a.b(q1())) {
            arrayList.add(new i(getMContext(), q1()));
        }
        arrayList.add(new ap(getMContext(), q1(), this));
        arrayList.add(new af(getMContext(), q1(), this));
        arrayList.add(new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this));
        if (companion.o(this.mArkMsgModel, this.arkAppConfig)) {
            arrayList.add(new u(getMContext(), q1(), this));
        }
        arrayList.add(new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this));
        arrayList.add(new ao(getMContext(), q1()));
        arrayList.add(new ag(getMContext(), q1()));
        arrayList.add(new aj(getMContext(), q1(), this));
        return arrayList;
    }
}
