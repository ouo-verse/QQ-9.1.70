package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.timi.game.api.ITimiGameApi;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ConcurrentHashMap;
import kl4.s;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002BCB\u000f\u0012\u0006\u0010$\u001a\u00020!\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "T9", "ba", "", "errorMsg", "ca", ZPlanPublishSource.FROM_SCHEME, "O9", "", "R9", "", "N9", "M9", "Q9", "S9", "P9", "isGokSelect", "productNum", "shopProductNum", "da", "Y9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$a;", "d", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$a;", "operatePartAdapter", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "ecommerceLayout", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "ecommerceNumLayout", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "ecommerceNumTextView", "Lcom/tencent/component/core/event/Eventor;", "i", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/room/prepare/k;", "viewModel", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Handler;", "uiHandler", "D", "Landroid/view/View;", "tricksContainer", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$a;)V", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveRtmpPrepareOperatePart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View tricksContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a operatePartAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup ecommerceLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout ecommerceNumLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView ecommerceNumTextView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.room.prepare.k viewModel;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$a;", "", "", "c", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface a {
        long a();

        long c();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$b;", "", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$b;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements OnEvent<b> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareOperatePart.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull b event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
            } else {
                Intrinsics.checkNotNullParameter(event, "event");
                QQLiveRtmpPrepareOperatePart.this.Y9();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareOperatePart$d", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/mobileqq/qqlive/room/prepare/rtmp/QQLiveRtmpPrepareFragment$b;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements OnEvent<QQLiveRtmpPrepareFragment.b> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareOperatePart.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull QQLiveRtmpPrepareFragment.b event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
            } else {
                Intrinsics.checkNotNullParameter(event, "event");
                QQLiveRtmpPrepareOperatePart.this.ba();
            }
        }
    }

    public QQLiveRtmpPrepareOperatePart(@NotNull a operatePartAdapter) {
        Intrinsics.checkNotNullParameter(operatePartAdapter, "operatePartAdapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) operatePartAdapter);
            return;
        }
        this.operatePartAdapter = operatePartAdapter;
        this.eventor = new Eventor();
        this.uiHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int M9() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            return kVar.R1();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int N9() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            return kVar.T1();
        }
        return 0;
    }

    private final String O9(String scheme) {
        Uri.Builder buildUpon = Uri.parse(scheme).buildUpon();
        buildUpon.appendQueryParameter("live_user_id", String.valueOf(this.operatePartAdapter.a()));
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            buildUpon.appendQueryParameter("live_room_id", String.valueOf(kVar.f271954i.roomAttr.roomId));
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
        return uri;
    }

    private final boolean P9() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null && (qQECLiveEntryGoodsData = kVar.S) != null) {
            return qQECLiveEntryGoodsData.getIsEcomAuthenticated();
        }
        return false;
    }

    private final boolean Q9() {
        Boolean bool;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            bool = kVar.h2();
        } else {
            bool = null;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R9() {
        Boolean bool;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            bool = kVar.i2();
        } else {
            bool = null;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private final boolean S9() {
        Boolean bool;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            bool = kVar.j2();
        } else {
            bool = null;
        }
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
    
        if (r3 != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void T9() {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData;
        long j3;
        Long l3;
        boolean z16;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar;
        boolean z17;
        boolean z18;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar2 = this.viewModel;
        if (kVar2 != null) {
            qQECLiveEntryGoodsData = kVar2.S;
        } else {
            qQECLiveEntryGoodsData = null;
        }
        if (qQECLiveEntryGoodsData == null) {
            this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.r
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveRtmpPrepareOperatePart.U9(QQLiveRtmpPrepareOperatePart.this);
                }
            });
            return;
        }
        EIPCResultCallback eIPCResultCallback = new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.s
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QQLiveRtmpPrepareOperatePart.V9(QQLiveRtmpPrepareOperatePart.this, eIPCResult);
            }
        };
        Bundle bundle = new Bundle();
        com.tencent.mobileqq.qqlive.room.prepare.k kVar3 = this.viewModel;
        if (kVar3 != null && (qQLiveAnchorDataPrepare = kVar3.f271954i) != null && (qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr) != null) {
            j3 = qQLiveAnchorDataRoomAttr.roomId;
        } else {
            j3 = 0;
        }
        bundle.putLong("KEY_LIVE_ROOM_ID", j3);
        a aVar = this.operatePartAdapter;
        if (aVar != null) {
            l3 = Long.valueOf(aVar.c());
        } else {
            l3 = null;
        }
        bundle.putString("KEY_LIVE_USER_ID", String.valueOf(l3));
        bundle.putBoolean("is_xiaodian_user", S9());
        bundle.putInt("live_product_counts", N9());
        bundle.putInt("live_shop_product_counts", M9());
        bundle.putBoolean("is_wangzhe_user", Q9());
        bundle.putBoolean("is_ecommerce_authenticated", P9());
        if (Q9()) {
            if (!com.tencent.mobileqq.qqlive.room.prepare.k.T) {
                com.tencent.mobileqq.qqlive.room.prepare.k kVar4 = this.viewModel;
                if (kVar4 != null) {
                    z18 = kVar4.g2();
                } else {
                    z18 = false;
                }
            }
            z16 = true;
            bundle.putBoolean("is_wangzhe_select", z16);
            if (P9() && !S9()) {
                IQQECommerceSdk iQQECommerceSdk = (IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class);
                String O9 = O9("mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1");
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = O9.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                iQQECommerceSdk.handleScheme("mqqapi://ecommerce/open?target=1&channel=8&src_type=internal&version=1&jump_scheme=" + Base64.encodeToString(bytes, 0), null);
                return;
            }
            cj4.c.f31003a.c("ACTION_CLICK_LIVE_ENTRY", bundle, eIPCResultCallback);
            kVar = this.viewModel;
            if (kVar == null) {
                z17 = Intrinsics.areEqual(kVar.f2(), Boolean.TRUE);
            } else {
                z17 = false;
            }
            if (!z17) {
                com.tencent.mobileqq.qqlive.room.prepare.k.T = false;
                return;
            }
            return;
        }
        z16 = false;
        bundle.putBoolean("is_wangzhe_select", z16);
        if (P9()) {
        }
        cj4.c.f31003a.c("ACTION_CLICK_LIVE_ENTRY", bundle, eIPCResultCallback);
        kVar = this.viewModel;
        if (kVar == null) {
        }
        if (!z17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QQLiveRtmpPrepareOperatePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ca("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(final QQLiveRtmpPrepareOperatePart this$0, EIPCResult eIPCResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (eIPCResult != null) {
            int i3 = eIPCResult.code;
            if (i3 == 0) {
                QLog.d(this$0.getTAG(), 1, "ACTION_CLICK_LIVE_ENTRY onCallback result\uff1a" + eIPCResult.data);
                final int i16 = eIPCResult.data.getInt("live_product_counts");
                final int i17 = eIPCResult.data.getInt("live_shop_product_counts");
                final boolean z16 = eIPCResult.data.getBoolean("GOK_LIVE_SELECT_WANGZHE");
                this$0.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveRtmpPrepareOperatePart.W9(QQLiveRtmpPrepareOperatePart.this, z16, i16, i17);
                    }
                });
                return;
            }
            if (i3 == -102) {
                this$0.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveRtmpPrepareOperatePart.X9(QQLiveRtmpPrepareOperatePart.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QQLiveRtmpPrepareOperatePart this$0, boolean z16, int i3, int i16) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.da(z16, i3, i16);
        if (!this$0.R9() && (frameLayout = this$0.ecommerceNumLayout) != null) {
            frameLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(QQLiveRtmpPrepareOperatePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ca("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y9() {
        com.tencent.mobileqq.qqlive.room.prepare.k kVar;
        int i3;
        try {
            if (R9() && (kVar = this.viewModel) != null) {
                cj4.c cVar = cj4.c.f31003a;
                String valueOf = String.valueOf(this.operatePartAdapter.a());
                QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr = kVar.f271954i.roomAttr;
                long j3 = qQLiveAnchorDataRoomAttr.roomId;
                int i16 = qQLiveAnchorDataRoomAttr.openTabLevel;
                String str = qQLiveAnchorDataRoomAttr.roomName;
                Intrinsics.checkNotNullExpressionValue(str, "it.prepareLiveData.roomAttr.roomName");
                String programId = kVar.W1().roomInfo.getProgramId();
                Intrinsics.checkNotNullExpressionValue(programId, "it.getPrepareLiveData().roomInfo.getProgramId()");
                Boolean f26 = kVar.f2();
                Intrinsics.checkNotNullExpressionValue(f26, "it.isGame");
                if (f26.booleanValue()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                cVar.i(valueOf, j3, 8, i16, str, programId, i3);
            }
        } catch (Exception e16) {
            QLog.e(getTAG(), 2, "onSetCallback notifyLiveOpen error:" + e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QQLiveRtmpPrepareOperatePart this$0, View view) {
        Long l3;
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        s.Companion companion = kl4.s.INSTANCE;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this$0.viewModel;
        Long l16 = null;
        if (kVar != null && (qQLiveAnchorDataPrepare = kVar.f271954i) != null && (qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr) != null) {
            l3 = Long.valueOf(qQLiveAnchorDataRoomAttr.roomId);
        } else {
            l3 = null;
        }
        a aVar = this$0.operatePartAdapter;
        if (aVar != null) {
            l16 = Long.valueOf(aVar.c());
        }
        companion.d(false, l3, l16);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba() {
        QQLiveAnchorDataPrepare prepareLiveData;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null) {
            if (kVar.S == null) {
                if (kVar.f271955m && (prepareLiveData = kVar.f271954i) != null) {
                    Intrinsics.checkNotNullExpressionValue(prepareLiveData, "prepareLiveData");
                    cj4.c.f31003a.m(prepareLiveData.roomAttr.roomId, this.operatePartAdapter.a(), new QQLiveRtmpPrepareOperatePart$requestLiveData$1$1$1(this, kVar));
                    return;
                }
                return;
            }
            if (R9()) {
                da(kVar.g2(), N9(), M9());
            }
            QLog.d(getTAG(), 2, "requestLiveData respData:" + kVar.S);
        }
    }

    private final void ca(String errorMsg) {
        Activity activity = getActivity();
        if (activity != null) {
            QQToast.makeText(activity, errorMsg, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(boolean isGokSelect, int productNum, int shopProductNum) {
        QQECLiveEntryGoodsData qQECLiveEntryGoodsData;
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        int i3;
        ViewGroup.LayoutParams layoutParams5;
        ViewGroup.LayoutParams layoutParams6;
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null && (qQECLiveEntryGoodsData = kVar.S) != null) {
            int i16 = productNum + shopProductNum;
            if (kVar != null) {
                Boolean f26 = kVar.f2();
                Intrinsics.checkNotNullExpressionValue(f26, "it.isGame");
                if (f26.booleanValue()) {
                    if (isGokSelect) {
                        i16 += qQECLiveEntryGoodsData.getLiveGokGoodsNumber();
                    }
                    qQECLiveEntryGoodsData.k(isGokSelect);
                }
            }
            if (i16 > 999) {
                ViewGroup viewGroup = this.ecommerceLayout;
                if (viewGroup != null && (layoutParams6 = viewGroup.getLayoutParams()) != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams6, "layoutParams");
                    layoutParams6.width = ti2.a.a(40.0f);
                }
                FrameLayout frameLayout = this.ecommerceNumLayout;
                if (frameLayout != null && (layoutParams5 = frameLayout.getLayoutParams()) != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams5, "layoutParams");
                    layoutParams5.width = -2;
                }
            } else if (i16 >= 100) {
                ViewGroup viewGroup2 = this.ecommerceLayout;
                if (viewGroup2 != null && (layoutParams4 = viewGroup2.getLayoutParams()) != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams4, "layoutParams");
                    layoutParams4.width = ti2.a.a(40.0f);
                }
                FrameLayout frameLayout2 = this.ecommerceNumLayout;
                if (frameLayout2 != null && (layoutParams3 = frameLayout2.getLayoutParams()) != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams3, "layoutParams");
                    layoutParams3.width = ti2.a.a(24.0f);
                    layoutParams3.height = ti2.a.a(14.0f);
                }
            } else {
                ViewGroup viewGroup3 = this.ecommerceLayout;
                if (viewGroup3 != null && (layoutParams2 = viewGroup3.getLayoutParams()) != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams2, "layoutParams");
                    layoutParams2.width = ti2.a.a(36.0f);
                }
                FrameLayout frameLayout3 = this.ecommerceNumLayout;
                if (frameLayout3 != null && (layoutParams = frameLayout3.getLayoutParams()) != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                }
            }
            FrameLayout frameLayout4 = this.ecommerceNumLayout;
            if (frameLayout4 != null) {
                if (i16 > 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                frameLayout4.setVisibility(i3);
            }
            qQECLiveEntryGoodsData.l(productNum);
            qQECLiveEntryGoodsData.m(shopProductNum);
            TextView textView = this.ecommerceNumTextView;
            if (textView != null) {
                textView.setText(String.valueOf(i16));
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QQLiveRtmpPrepareOperatePart";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f60322v4) {
                T9();
                try {
                    ViewGroup viewGroup = this.ecommerceLayout;
                    if (viewGroup != null) {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        concurrentHashMap.put("qqlive_anchor_button_type", "5");
                        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(viewGroup, false, null, "em_qqlive_beauty_button", concurrentHashMap);
                        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("clck", viewGroup, concurrentHashMap);
                    }
                } catch (Exception e16) {
                    QLog.e(getTAG(), 1, "onClick report error\uff1a" + e16.getMessage());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        FrameLayout frameLayout;
        TextView textView;
        MutableLiveData<LabelModel> mutableLiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        View view = null;
        if (rootView != null) {
            viewGroup = (ViewGroup) rootView.findViewById(R.id.f60322v4);
        } else {
            viewGroup = null;
        }
        this.ecommerceLayout = viewGroup;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f60332v5);
        } else {
            frameLayout = null;
        }
        this.ecommerceNumLayout = frameLayout;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f60342v6);
        } else {
            textView = null;
        }
        this.ecommerceNumTextView = textView;
        ViewGroup viewGroup2 = this.ecommerceLayout;
        if (viewGroup2 != null) {
            viewGroup2.setOnClickListener(this);
        }
        kl4.s.INSTANCE.g();
        if (rootView != null) {
            view = rootView.findViewById(R.id.f60962wu);
        }
        this.tricksContainer = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QQLiveRtmpPrepareOperatePart.Z9(QQLiveRtmpPrepareOperatePart.this, view2);
                }
            });
        }
        this.viewModel = (com.tencent.mobileqq.qqlive.room.prepare.k) new ViewModelProvider(getHostFragment(), com.tencent.mobileqq.qqlive.room.prepare.k.U).get(com.tencent.mobileqq.qqlive.room.prepare.k.class);
        this.eventor.addOnEvent(new c());
        this.eventor.addOnEvent(new d());
        com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.viewModel;
        if (kVar != null && (mutableLiveData = kVar.Q) != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<LabelModel, Unit> function1 = new Function1<LabelModel, Unit>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.QQLiveRtmpPrepareOperatePart$onInitView$4
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveRtmpPrepareOperatePart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LabelModel labelModel) {
                    invoke2(labelModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LabelModel labelModel) {
                    com.tencent.mobileqq.qqlive.room.prepare.k kVar2;
                    int N9;
                    int M9;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) labelModel);
                        return;
                    }
                    kVar2 = QQLiveRtmpPrepareOperatePart.this.viewModel;
                    if (kVar2 != null) {
                        QQLiveRtmpPrepareOperatePart qQLiveRtmpPrepareOperatePart = QQLiveRtmpPrepareOperatePart.this;
                        boolean g26 = kVar2.g2();
                        N9 = qQLiveRtmpPrepareOperatePart.N9();
                        M9 = qQLiveRtmpPrepareOperatePart.M9();
                        qQLiveRtmpPrepareOperatePart.da(g26, N9, M9);
                    }
                }
            };
            mutableLiveData.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QQLiveRtmpPrepareOperatePart.aa(Function1.this, obj);
                }
            });
        }
        try {
            ViewGroup viewGroup3 = this.ecommerceLayout;
            if (viewGroup3 != null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.put("qqlive_anchor_button_type", "5");
                ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(viewGroup3, false, null, "em_qqlive_beauty_button", concurrentHashMap);
                ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent("imp", viewGroup3, concurrentHashMap);
            }
        } catch (Exception e16) {
            QLog.e(getTAG(), 1, "onInitView report error\uff1a" + e16.getMessage());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        this.uiHandler.removeCallbacksAndMessages(null);
        this.eventor.removeAll();
    }
}
