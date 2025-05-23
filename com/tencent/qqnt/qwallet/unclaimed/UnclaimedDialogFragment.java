package com.tencent.qqnt.qwallet.unclaimed;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.hb.UnclaimedHbPB$GetUpForGrabsReq;
import com.qwallet.protocol.Wallet.hb.UnclaimedHbPB$GetUpForGrabsRsp;
import com.qwallet.protocol.Wallet.hb.UnclaimedHbPB$HbAioInfo;
import com.qwallet.temp.IQwTemp;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.reserve.Reserve1Event;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.QWalletDialogFragment;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.qqnt.qwallet.aio.hb.GrabHbViewModel;
import com.tencent.qqnt.qwallet.db.HbStateEntity;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment;
import com.tencent.qqnt.qwallet.unclaimed.UnclaimedDialogFragment;
import com.tencent.qqnt.qwallet.unclaimed.UnclaimedEvent;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.h;
import rx3.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t*\u0001H\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u0010\"R\u0016\u00108\u001a\u0004\u0018\u00010 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010\"R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006P"}, d2 = {"Lcom/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment;", "Lcom/tencent/mobileqq/qwallet/QWalletDialogFragment;", "", "Fh", OcrConfig.CHINESE, "Dh", "Landroid/view/View;", "Eh", "Hh", "Lrx3/h;", "model", "Gh", "aioModel", "Ch", "aioUnclaimedModel", "", "Bh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Dialog;", "onCreateDialog", "", "D", "Ljava/lang/String;", "groupId", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "centerImg", "G", "Landroid/view/View;", "loadingLayout", "H", "loadingView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "emptyText", "J", "addFloatType", "K", "updateHbList", "Lcom/tencent/qqnt/qwallet/aio/hb/GrabHbViewModel;", "L", "Lkotlin/Lazy;", "yh", "()Lcom/tencent/qqnt/qwallet/aio/hb/GrabHbViewModel;", "grabHbViewModel", "Landroid/animation/ObjectAnimator;", "M", "Landroid/animation/ObjectAnimator;", "currentAnimator", "N", "Z", "needUpdate", "P", "needDismiss", "com/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment$b", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment$b;", "action", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class UnclaimedDialogFragment extends QWalletDialogFragment {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView centerImg;

    /* renamed from: G, reason: from kotlin metadata */
    private View loadingLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private View loadingView;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView emptyText;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy grabHbViewModel;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private ObjectAnimator currentAnimator;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean needUpdate;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean needDismiss;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String groupId = "";

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private final String addFloatType = Reflection.getOrCreateKotlinClass(Reserve1Event.AddFloatView.class).getQualifiedName();

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private final String updateHbList = Reflection.getOrCreateKotlinClass(UnclaimedEvent.UpdateHbList.class).getQualifiedName();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment$a;", "", "", "groupId", "Lcom/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment;", "a", "CMD_METHOD", "Ljava/lang/String;", "CMD_SERVICE", "PARAMS_KEY_GROUP_ID", "TAG", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qwallet.unclaimed.UnclaimedDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UnclaimedDialogFragment a(@NotNull String groupId) {
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            UnclaimedDialogFragment unclaimedDialogFragment = new UnclaimedDialogFragment();
            unclaimedDialogFragment.setStyle(0, R.style.qZoneInputDialog);
            Bundle bundle = new Bundle();
            bundle.putString("qwallet_group_id", groupId);
            unclaimedDialogFragment.setArguments(bundle);
            return unclaimedDialogFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof Reserve1Event.AddFloatView) {
                UnclaimedDialogFragment.this.dismiss();
            } else if (i3 instanceof UnclaimedEvent.UpdateHbList) {
                UnclaimedDialogFragment.this.needUpdate = true;
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment$c", "Lpl2/h;", "Lcom/qwallet/protocol/Wallet/hb/UnclaimedHbPB$GetUpForGrabsRsp;", "rsp", "", "e", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends h<UnclaimedHbPB$GetUpForGrabsRsp> {
        c() {
            super(UnclaimedDialogFragment.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ArrayList modelList, final UnclaimedDialogFragment this$0) {
            String str;
            Intrinsics.checkNotNullParameter(modelList, "$modelList");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.qwallet.c.f("unGrabHB.page.result", String.valueOf(modelList.size()), null, null, null, 28, null);
            final ArrayList arrayList = new ArrayList();
            Iterator it = modelList.iterator();
            while (true) {
                boolean z16 = true;
                if (it.hasNext()) {
                    Object next = it.next();
                    HbStateEntity y16 = QWalletDBManager.f361825a.y(((rx3.h) next).getBillNo(), com.tencent.mobileqq.base.a.c());
                    if (y16 != null) {
                        str = y16.getText();
                    } else {
                        str = null;
                    }
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(next);
                    }
                } else {
                    QLog.d("UnclaimedDialogFragment", 1, "after size = " + arrayList.size());
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.qwallet.unclaimed.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            UnclaimedDialogFragment.c.g(arrayList, this$0);
                        }
                    });
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(List needShowList, UnclaimedDialogFragment this$0) {
            Intrinsics.checkNotNullParameter(needShowList, "$needShowList");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (needShowList.isEmpty()) {
                this$0.zh();
                return;
            }
            if (needShowList.size() != 1 || ((rx3.h) needShowList.get(0)).getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() == 6) {
                this$0.Dh();
                RecyclerView recyclerView = this$0.recyclerView;
                RecyclerView recyclerView2 = null;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                recyclerView.setAdapter(new e(needShowList));
                RecyclerView recyclerView3 = this$0.recyclerView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                } else {
                    recyclerView2 = recyclerView3;
                }
                recyclerView2.setVisibility(0);
                return;
            }
            this$0.Gh((rx3.h) needShowList.get(0));
        }

        @Override // pl2.k
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull UnclaimedHbPB$GetUpForGrabsRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            final ArrayList arrayList = new ArrayList();
            List<UnclaimedHbPB$HbAioInfo> list = rsp.hb_aio_infos.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.hb_aio_infos.get()");
            UnclaimedDialogFragment unclaimedDialogFragment = UnclaimedDialogFragment.this;
            for (UnclaimedHbPB$HbAioInfo it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new rx3.h(it, unclaimedDialogFragment.groupId));
            }
            QLog.d("UnclaimedDialogFragment", 1, "before size = " + arrayList.size());
            final UnclaimedDialogFragment unclaimedDialogFragment2 = UnclaimedDialogFragment.this;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.qwallet.unclaimed.c
                @Override // java.lang.Runnable
                public final void run() {
                    UnclaimedDialogFragment.c.f(arrayList, unclaimedDialogFragment2);
                }
            }, 32, null, false);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("UnclaimedDialogFragment", 1, errMsg);
            UnclaimedDialogFragment.this.zh();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/qwallet/unclaimed/UnclaimedDialogFragment$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class d extends ViewOutlineProvider {
        d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getHeight() / 2.0f);
        }
    }

    public UnclaimedDialogFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GrabHbViewModel>() { // from class: com.tencent.qqnt.qwallet.unclaimed.UnclaimedDialogFragment$grabHbViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GrabHbViewModel invoke() {
                return new GrabHbViewModel();
            }
        });
        this.grabHbViewModel = lazy;
        this.needUpdate = true;
        this.action = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(UnclaimedDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final boolean Bh(rx3.h aioUnclaimedModel) {
        if (2 == aioUnclaimedModel.getChatType() && ((IQwTemp) QRoute.api(IQwTemp.class)).isUinSilencedInTroop(aioUnclaimedModel.getPeerUinStr())) {
            return true;
        }
        return false;
    }

    private final void Ch(rx3.h aioModel) {
        if (((IAnonymousChatApi) QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(aioModel.getPeerUinStr())) {
            String string = MobileQQ.sMobileQQ.getString(R.string.f170952mf, "\u8bed\u97f3\u53e3\u4ee4\u7ea2\u5305");
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.st\u2026b_in_anonymous, \"\u8bed\u97f3\u53e3\u4ee4\u7ea2\u5305\")");
            i.f432935a.b(string, aioModel.getPeerUinStr(), aioModel.getChatType());
            zh();
            return;
        }
        if (Bh(aioModel)) {
            String string2 = MobileQQ.sMobileQQ.getString(R.string.f170962mg, "\u8bed\u97f3\u53e3\u4ee4\u7ea2\u5305");
            Intrinsics.checkNotNullExpressionValue(string2, "sMobileQQ.getString(R.st\u2026ab_in_silenced, \"\u8bed\u97f3\u53e3\u4ee4\u7ea2\u5305\")");
            i.f432935a.b(string2, aioModel.getPeerUinStr(), aioModel.getChatType());
            zh();
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(sx3.a.b(aioModel));
        com.tencent.mobileqq.base.c.f(getContext(), intent, GrabVoiceHbFragment.class, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh() {
        ImageView imageView = this.centerImg;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerImg");
            imageView = null;
        }
        imageView.setVisibility(8);
        ObjectAnimator objectAnimator = this.currentAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.currentAnimator = null;
        View view = this.loadingLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            view = null;
        }
        view.setVisibility(8);
        TextView textView2 = this.emptyText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyText");
        } else {
            textView = textView2;
        }
        textView.setVisibility(8);
    }

    private final void Eh(View view) {
        view.setOutlineProvider(new d());
        view.setClipToOutline(true);
    }

    private final void Fh() {
        ImageView imageView = this.centerImg;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerImg");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.ow8);
        ImageView imageView2 = this.centerImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerImg");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        View view2 = this.loadingLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            view2 = null;
        }
        view2.setVisibility(0);
        ObjectAnimator objectAnimator = this.currentAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        View view3 = this.loadingView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        } else {
            view = view3;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", -15.0f, ViewUtils.dip2px(107.0f));
        ofFloat.setDuration(1000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        this.currentAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(rx3.h model) {
        final Activity activity;
        Map<String, ? extends Object> emptyMap;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && !activity.isFinishing()) {
            if (model.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() == 20) {
                GrabHbViewModel yh5 = yh();
                emptyMap = MapsKt__MapsKt.emptyMap();
                yh5.X1(activity, model, emptyMap);
                this.needDismiss = true;
                return;
            }
            if (model.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() != 13 && model.getCom.tencent.mobileqq.activity.QQBrowserActivity.KEY_MSG_TYPE java.lang.String() != 15) {
                yh().W1(activity, model, new Function1<Integer, Unit>() { // from class: com.tencent.qqnt.qwallet.unclaimed.UnclaimedDialogFragment$singleHbModel$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        UnclaimedDialogFragment.this.needDismiss = true;
                        if (i3 != 0) {
                            String string = activity.getResources().getString(R.string.f17938398, Integer.valueOf(i3));
                            Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026ay_hb_pregrab_fail, code)");
                            QQToast.makeText(UnclaimedDialogFragment.this.getContext(), string, 0).show();
                        }
                    }
                });
            } else {
                Ch(model);
                this.needDismiss = true;
            }
        }
    }

    private final void Hh() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.tencent.qqnt.qwallet.unclaimed.b
            @Override // java.lang.Runnable
            public final void run() {
                UnclaimedDialogFragment.Ih(UnclaimedDialogFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(UnclaimedDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = this$0.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        int height = recyclerView.getHeight();
        RecyclerView recyclerView3 = this$0.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        int width = (recyclerView3.getWidth() - ((int) ((height * 168.0f) / 230.0f))) / 2;
        RecyclerView recyclerView4 = this$0.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setPadding(width, 0, width, 0);
    }

    private final GrabHbViewModel yh() {
        return (GrabHbViewModel) this.grabHbViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
        Log.d("UnclaimedDialogFragment", "isHbEmpty: ");
        ImageView imageView = this.centerImg;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerImg");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this.centerImg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerImg");
            imageView2 = null;
        }
        imageView2.setImageResource(R.drawable.ow7);
        TextView textView = this.emptyText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emptyText");
            textView = null;
        }
        textView.setVisibility(0);
        ObjectAnimator objectAnimator = this.currentAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.currentAnimator = null;
        View view2 = this.loadingLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        } else {
            view = view2;
        }
        view.setVisibility(8);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.qwallet.unclaimed.a
            @Override // java.lang.Runnable
            public final void run() {
                UnclaimedDialogFragment.Ah(UnclaimedDialogFragment.this);
            }
        }, 1000L);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("qwallet_group_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.groupId = str;
        AIOContextHolder aIOContextHolder = AIOContextHolder.f361707d;
        aIOContextHolder.b(this.addFloatType, this.action);
        aIOContextHolder.b(this.updateHbList, this.action);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            window.setAttributes(attributes);
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setLayout(-1, -2);
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hip, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AIOContextHolder aIOContextHolder = AIOContextHolder.f361707d;
        aIOContextHolder.e(this.addFloatType, this.action);
        aIOContextHolder.e(this.updateHbList, this.action);
        ObjectAnimator objectAnimator = this.currentAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.currentAnimator = null;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.needDismiss) {
            Dh();
        }
        if (this.needUpdate) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setVisibility(4);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needDismiss) {
            dismiss();
            QLog.d("UnclaimedDialogFragment", 1, "onResume: return not needDismiss");
            return;
        }
        if (!this.needUpdate) {
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            recyclerView.setVisibility(0);
            QLog.d("UnclaimedDialogFragment", 1, "onResume: return not needUpdate");
            return;
        }
        this.needUpdate = false;
        c cVar = new c();
        Fh();
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        UnclaimedHbPB$GetUpForGrabsReq unclaimedHbPB$GetUpForGrabsReq = new UnclaimedHbPB$GetUpForGrabsReq();
        unclaimedHbPB$GetUpForGrabsReq.group_id.set(this.groupId);
        Object newInstance = UnclaimedHbPB$GetUpForGrabsRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qqhb.records.UpForGrabs", "GetUpForGrabs", unclaimedHbPB$GetUpForGrabsReq, (MessageMicro) newInstance, false, false, false, null, cVar);
        QLog.d("UnclaimedDialogFragment", 1, "onResume: request");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.f113956s1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.unclaimed_center_img)");
        this.centerImg = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.f113966s2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.unclaimed_hb_empty_text)");
        this.emptyText = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f113986s4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.unclaimed_loading_layout)");
        this.loadingLayout = findViewById3;
        View findViewById4 = view.findViewById(R.id.f113996s5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.unclaimed_loading_view)");
        this.loadingView = findViewById4;
        View findViewById5 = view.findViewById(R.id.f113976s3);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.unclaimed_hb_recycler)");
        this.recyclerView = (RecyclerView) findViewById5;
        View view2 = this.loadingLayout;
        RecyclerView recyclerView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
            view2 = null;
        }
        Eh(view2);
        View view3 = this.loadingView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            view3 = null;
        }
        Eh(view3);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        Hh();
        com.tencent.mobileqq.qwallet.c.f("unGrabHB.page.show", null, null, null, null, 30, null);
    }
}
