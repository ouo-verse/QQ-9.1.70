package com.tencent.ecommerce.biz.showwindow.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import ck0.Product;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.util.ECDebugUtils;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import ei0.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;
import yi0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0016\u0018\u0000 g2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010+\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010:R\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010CR\u0016\u0010J\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010CR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010MR\u0016\u0010V\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010QR\u0016\u0010X\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010QR\u0016\u0010Z\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010CR\u0016\u0010\\\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010QR\u0016\u0010^\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010QR\u0016\u0010`\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010<R\u0016\u0010b\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010<R\u0016\u0010d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010<\u00a8\u0006i"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "getContentLayoutId", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getBusinessDescription", "", "onBackPressed", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Zh", "Yh", "ai", "searching", "fi", "ei", "bi", "ci", "di", "Xh", "P", "I", "windowType", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "deliverProductCallbackId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "deliverProductCallback", ExifInterface.LATITUDE_SOUTH, WadlProxyConsts.CHANNEL, "T", GetAdInfoRequest.SOURCE_FROM, "U", "liveUserId", "", "V", "J", "liveRoomId", "Landroid/widget/ImageView;", "W", "Landroid/widget/ImageView;", "backButton", "Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment;", "X", "Lcom/tencent/ecommerce/biz/showwindow/fragment/ECLiveShowWindowListFragment;", "listFragment", "Landroid/view/ViewGroup;", "Y", "Landroid/view/ViewGroup;", "fragmentContainer", "Z", "actualSearchBarContainer", "Landroid/widget/EditText;", "a0", "Landroid/widget/EditText;", "actutalSearchBar", "b0", "Landroid/view/View;", "searchDeleteButton", "c0", "titleContainer", "d0", "addProductButton", "e0", "searchBarContainer", "Landroid/widget/LinearLayout;", "f0", "Landroid/widget/LinearLayout;", "searchBar", "Landroid/widget/TextView;", "g0", "Landroid/widget/TextView;", "searchTextView", "h0", "searchIconAndText", "i0", "searchCancel", "j0", "titleTextView", "k0", "liveEditToolBar", "l0", "liveSelectedNumberTextView", "m0", "liveConfirmBtn", "n0", "isCurrentNightMode", "o0", "needSaveOperateBeforeBack", "p0", "needBackAfterUpdate", "<init>", "()V", "q0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECLiveShowWindowFragment extends ECBaseFragment {

    /* renamed from: R, reason: from kotlin metadata */
    private IECSchemeCallback deliverProductCallback;

    /* renamed from: V, reason: from kotlin metadata */
    private long liveRoomId;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView backButton;

    /* renamed from: X, reason: from kotlin metadata */
    private ECLiveShowWindowListFragment listFragment;

    /* renamed from: Y, reason: from kotlin metadata */
    private ViewGroup fragmentContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private ViewGroup actualSearchBarContainer;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private EditText actutalSearchBar;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private View searchDeleteButton;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup titleContainer;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private View addProductButton;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private View searchBarContainer;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout searchBar;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private TextView searchTextView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private LinearLayout searchIconAndText;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private TextView searchCancel;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private View liveEditToolBar;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private TextView liveSelectedNumberTextView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private TextView liveConfirmBtn;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean isCurrentNightMode;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean needSaveOperateBeforeBack;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean needBackAfterUpdate;

    /* renamed from: P, reason: from kotlin metadata */
    private int windowType = 1;

    /* renamed from: Q, reason: from kotlin metadata */
    private String deliverProductCallbackId = "";

    /* renamed from: S, reason: from kotlin metadata */
    private String channel = "";

    /* renamed from: T, reason: from kotlin metadata */
    private String sourceFrom = "";

    /* renamed from: U, reason: from kotlin metadata */
    private String liveUserId = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!ECLiveShowWindowFragment.this.onBackPressed()) {
                ECLiveShowWindowFragment.this.Xh();
                ECLiveShowWindowFragment.this.requireActivity().finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.r(Uri.parse(String.valueOf(10)));
            fj0.b.f399473a.a(ECLiveShowWindowFragment.this.channel, 1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            view.setVisibility(8);
            ECLiveShowWindowFragment.Ph(ECLiveShowWindowFragment.this).bi().s3("");
            ECLiveShowWindowListFragment.ni(ECLiveShowWindowFragment.Ph(ECLiveShowWindowFragment.this), null, false, false, 7, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveShowWindowFragment.Mh(ECLiveShowWindowFragment.this).setText("");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveShowWindowFragment.this.needBackAfterUpdate = false;
            ECLiveShowWindowFragment.Ph(ECLiveShowWindowFragment.this).qi();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<Integer> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            ECLiveShowWindowFragment.this.Xh();
            FragmentActivity activity = ECLiveShowWindowFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<Integer> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Integer num) {
            TextView Rh = ECLiveShowWindowFragment.Rh(ECLiveShowWindowFragment.this);
            Context context = ECLiveShowWindowFragment.this.getContext();
            Rh.setText(context != null ? context.getString(R.string.wsl, num) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i<T> implements Observer<Boolean> {
        i() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECLiveShowWindowFragment.Qh(ECLiveShowWindowFragment.this).setEnabled(Intrinsics.areEqual(bool, Boolean.TRUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lck0/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j<T> implements Observer<List<? extends Product>> {
        j() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<Product> list) {
            TextView textView = (TextView) ECLiveShowWindowFragment.this.yh().findViewById(R.id.oes);
            StringBuilder sb5 = new StringBuilder();
            sb5.append('(');
            sb5.append(list.size());
            sb5.append(')');
            textView.setText(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveShowWindowFragment.this.fi(true);
            com.tencent.ecommerce.biz.common.f.f101556a.d(ECLiveShowWindowFragment.this.channel, "window_search_bar_clk");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ EditText Mh(ECLiveShowWindowFragment eCLiveShowWindowFragment) {
        EditText editText = eCLiveShowWindowFragment.actutalSearchBar;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
        }
        return editText;
    }

    public static final /* synthetic */ ViewGroup Oh(ECLiveShowWindowFragment eCLiveShowWindowFragment) {
        ViewGroup viewGroup = eCLiveShowWindowFragment.fragmentContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        return viewGroup;
    }

    public static final /* synthetic */ ECLiveShowWindowListFragment Ph(ECLiveShowWindowFragment eCLiveShowWindowFragment) {
        ECLiveShowWindowListFragment eCLiveShowWindowListFragment = eCLiveShowWindowFragment.listFragment;
        if (eCLiveShowWindowListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFragment");
        }
        return eCLiveShowWindowListFragment;
    }

    public static final /* synthetic */ TextView Qh(ECLiveShowWindowFragment eCLiveShowWindowFragment) {
        TextView textView = eCLiveShowWindowFragment.liveConfirmBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
        }
        return textView;
    }

    public static final /* synthetic */ TextView Rh(ECLiveShowWindowFragment eCLiveShowWindowFragment) {
        TextView textView = eCLiveShowWindowFragment.liveSelectedNumberTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveSelectedNumberTextView");
        }
        return textView;
    }

    public static final /* synthetic */ LinearLayout Th(ECLiveShowWindowFragment eCLiveShowWindowFragment) {
        LinearLayout linearLayout = eCLiveShowWindowFragment.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh() {
        JSONObject jSONObject = new JSONObject();
        ECLiveShowWindowListFragment eCLiveShowWindowListFragment = this.listFragment;
        if (eCLiveShowWindowListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFragment");
        }
        jSONObject.put("shop_product_counts", eCLiveShowWindowListFragment.bi().D2().getValue());
        jSONObject.put("need_update", true);
        jSONObject.put("is_from_shopwindow", true);
        jSONObject.put("live_tab_id", LiveTabId.LIVE_TAB_QSHOP.getValue());
        IECSchemeCallback iECSchemeCallback = this.deliverProductCallback;
        if (iECSchemeCallback != null) {
            iECSchemeCallback.onCallbackFinished(jSONObject);
        }
        cg0.a.b("ECLiveShowWindowFragment", "callbackFinished, callback=" + this.deliverProductCallback + ", json=" + jSONObject);
    }

    private final void Yh() {
        final Context context = getContext();
        if (context != null) {
            final com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(context);
            gVar.Y(context.getResources().getString(R.string.wnd));
            gVar.b0(context.getResources().getString(R.string.wnl));
            gVar.f0(context.getResources().getString(R.string.wnj));
            gVar.d0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowFragment$checkOperationSave$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    c cVar = c.f396302a;
                    cVar.l(g.this.X());
                    cVar.k(g.this.S());
                }
            });
            gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowFragment$checkOperationSave$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    c.f396302a.c(g.this.S());
                    this.Xh();
                    FragmentActivity activity = this.getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            });
            gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowFragment$checkOperationSave$$inlined$also$lambda$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    c.f396302a.c(g.this.X());
                    ECLiveShowWindowFragment.Ph(this).qi();
                }
            });
            gVar.show();
        }
    }

    private final void ai(View rootView) {
        cg0.a.b("ECLiveShowWindowFragment", "[initWindowTypePage], windowType = " + this.windowType);
        this.liveEditToolBar = rootView.findViewById(R.id.o9b);
        this.liveSelectedNumberTextView = (TextView) rootView.findViewById(R.id.odv);
        this.liveConfirmBtn = (TextView) rootView.findViewById(R.id.odu);
        new View(getContext()).setLayoutParams(new ViewGroup.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(20.0f)));
        this.actualSearchBarContainer = (ViewGroup) rootView.findViewById(R.id.o2p);
        this.actutalSearchBar = (EditText) rootView.findViewById(R.id.nyr);
        this.titleContainer = (ViewGroup) rootView.findViewById(R.id.o3j);
        this.searchDeleteButton = rootView.findViewById(R.id.o1g);
        EditText editText = this.actutalSearchBar;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
        }
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowFragment$initWindowTypePage$1
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                if (i3 == 3) {
                    ECLiveShowWindowFragment.Oh(ECLiveShowWindowFragment.this).setVisibility(0);
                    String obj = textView.getText().toString();
                    ECLiveShowWindowFragment.Ph(ECLiveShowWindowFragment.this).bi().s3(obj);
                    ECLiveShowWindowListFragment.ni(ECLiveShowWindowFragment.Ph(ECLiveShowWindowFragment.this), null, false, false, 7, null);
                    c.f396302a.h(ECLiveShowWindowFragment.Th(ECLiveShowWindowFragment.this), obj);
                    ECLiveShowWindowFragment.Mh(ECLiveShowWindowFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowFragment$initWindowTypePage$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            ECLiveShowWindowFragment.Mh(ECLiveShowWindowFragment.this).clearFocus();
                            SoftKeyboardStateHelper.INSTANCE.d(ECLiveShowWindowFragment.Mh(ECLiveShowWindowFragment.this));
                        }
                    });
                }
                EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
                return true;
            }
        });
        View view = this.searchDeleteButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchDeleteButton");
        }
        view.setOnClickListener(new e());
        TextView textView = this.liveConfirmBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
        }
        textView.setOnClickListener(new f());
        fi(false);
        ei0.c cVar = ei0.c.f396302a;
        cVar.o(this);
        View view2 = this.addProductButton;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
        }
        cVar.i(view2);
        TextView textView2 = this.liveConfirmBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveConfirmBtn");
        }
        cVar.j(textView2);
        LinearLayout linearLayout = this.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        TextView textView3 = this.searchTextView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchTextView");
        }
        cVar.p(linearLayout, textView3.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bi() {
        di();
        ci();
    }

    private final void ci() {
        ECLiveShowWindowListFragment eCLiveShowWindowListFragment = this.listFragment;
        if (eCLiveShowWindowListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFragment");
        }
        eCLiveShowWindowListFragment.bi().D2().observe(getViewLifecycleOwner(), new g());
        ECLiveShowWindowListFragment eCLiveShowWindowListFragment2 = this.listFragment;
        if (eCLiveShowWindowListFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFragment");
        }
        eCLiveShowWindowListFragment2.bi().H2().observe(getViewLifecycleOwner(), new h());
        ECLiveShowWindowListFragment eCLiveShowWindowListFragment3 = this.listFragment;
        if (eCLiveShowWindowListFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFragment");
        }
        eCLiveShowWindowListFragment3.bi().v2().observe(getViewLifecycleOwner(), new i());
    }

    private final void di() {
        ECLiveShowWindowListFragment eCLiveShowWindowListFragment = this.listFragment;
        if (eCLiveShowWindowListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFragment");
        }
        eCLiveShowWindowListFragment.bi().A2().observe(getViewLifecycleOwner(), new j());
    }

    private final void ei() {
        LinearLayout linearLayout = this.searchBar;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        }
        linearLayout.setOnClickListener(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fi(boolean searching) {
        if (searching) {
            ViewGroup viewGroup = this.fragmentContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            }
            viewGroup.setVisibility(8);
            View view = this.addProductButton;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
            }
            view.setVisibility(8);
            ViewGroup viewGroup2 = this.titleContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
            }
            viewGroup2.setVisibility(8);
            View view2 = this.searchBarContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
            }
            view2.setVisibility(8);
            ViewGroup viewGroup3 = this.actualSearchBarContainer;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actualSearchBarContainer");
            }
            viewGroup3.setVisibility(0);
            EditText editText = this.actutalSearchBar;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
            }
            editText.setText("");
            EditText editText2 = this.actutalSearchBar;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
            }
            editText2.post(new Runnable() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowFragment$updateSearchBarState$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECLiveShowWindowFragment.Mh(ECLiveShowWindowFragment.this).requestFocus();
                    SoftKeyboardStateHelper.INSTANCE.f(ECLiveShowWindowFragment.Mh(ECLiveShowWindowFragment.this));
                }
            });
            return;
        }
        ViewGroup viewGroup4 = this.fragmentContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        viewGroup4.setVisibility(0);
        View view3 = this.addProductButton;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
        }
        view3.setVisibility(0);
        ViewGroup viewGroup5 = this.titleContainer;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        }
        viewGroup5.setVisibility(0);
        View view4 = this.searchBarContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBarContainer");
        }
        view4.setVisibility(0);
        ViewGroup viewGroup6 = this.actualSearchBarContainer;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actualSearchBarContainer");
        }
        viewGroup6.setVisibility(8);
        SoftKeyboardStateHelper.Companion companion = SoftKeyboardStateHelper.INSTANCE;
        EditText editText3 = this.actutalSearchBar;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actutalSearchBar");
        }
        companion.d(editText3);
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        String string;
        String string2;
        Bundle arguments = getArguments();
        String str5 = "";
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        this.deliverProductCallbackId = str;
        this.deliverProductCallback = ug0.a.b(str);
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString(WadlProxyConsts.CHANNEL)) == null) {
            str2 = "";
        }
        this.channel = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("source_from")) == null) {
            str3 = "";
        }
        this.sourceFrom = str3;
        this.isCurrentNightMode = fg0.a.f398587b.a();
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string2 = arguments4.getString("live_user_id")) != null) {
            str5 = string2;
        }
        this.liveUserId = str5;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str4 = arguments5.getString("live_room_id")) == null) {
            str4 = "0";
        }
        this.liveRoomId = Long.parseLong(str4);
        try {
            Bundle arguments6 = getArguments();
            this.windowType = (arguments6 == null || (string = arguments6.getString("window_type")) == null) ? 1 : Integer.parseInt(string);
        } catch (NumberFormatException e16) {
            cg0.a.a("ECLiveShowWindowFragment", "[initArguments]", e16.toString());
        }
        cg0.a.b("ECLiveShowWindowFragment", "[initArguments] deliverProductCallId = " + this.deliverProductCallbackId + ", channel = " + this.channel + ", sourceFrom = " + this.sourceFrom + ", isNightMode = " + this.isCurrentNightMode + ", windowType = " + this.windowType + ", liveUserId = " + this.liveUserId + ", liveRoomId = " + this.liveRoomId);
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveShowWindowFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqs;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ViewGroup viewGroup = this.actualSearchBarContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actualSearchBarContainer");
        }
        if (viewGroup.getVisibility() == 0) {
            fi(false);
            ECLiveShowWindowListFragment eCLiveShowWindowListFragment = this.listFragment;
            if (eCLiveShowWindowListFragment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listFragment");
            }
            eCLiveShowWindowListFragment.bi().s3("");
            ECLiveShowWindowListFragment eCLiveShowWindowListFragment2 = this.listFragment;
            if (eCLiveShowWindowListFragment2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listFragment");
            }
            ECLiveShowWindowListFragment.ni(eCLiveShowWindowListFragment2, null, false, false, 7, null);
            return true;
        }
        if (!this.needSaveOperateBeforeBack) {
            return false;
        }
        Yh();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setRequestedOrientation(1);
        }
        initArguments();
        r.f104881b.e(getActivity(), true);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.fragmentContainer = (ViewGroup) view.findViewById(R.id.f163066o42);
        this.listFragment = ECLiveShowWindowListFragment.INSTANCE.a(getArguments(), new Function1<Fragment, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECLiveShowWindowFragment$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Fragment fragment) {
                invoke2(fragment);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Fragment fragment) {
                ECLiveShowWindowFragment.this.bi();
            }
        });
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        ECLiveShowWindowListFragment eCLiveShowWindowListFragment = this.listFragment;
        if (eCLiveShowWindowListFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listFragment");
        }
        beginTransaction.replace(R.id.f163066o42, eCLiveShowWindowListFragment).commitAllowingStateLoss();
        Zh(view);
        ai(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    private final void Zh(View rootView) {
        this.backButton = (ImageView) rootView.findViewById(R.id.o18);
        this.addProductButton = rootView.findViewById(R.id.o2r);
        this.searchBarContainer = rootView.findViewById(R.id.o9u);
        this.searchBar = (LinearLayout) rootView.findViewById(R.id.nzi);
        this.searchTextView = (TextView) rootView.findViewById(R.id.oe8);
        this.searchIconAndText = (LinearLayout) rootView.findViewById(R.id.o3c);
        this.searchCancel = (TextView) rootView.findViewById(R.id.oe7);
        this.titleTextView = (TextView) rootView.findViewById(R.id.oer);
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setOnClickListener(new b());
        View view = this.addProductButton;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addProductButton");
        }
        view.setOnClickListener(new c());
        TextView textView = this.searchCancel;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchCancel");
        }
        textView.setOnClickListener(new d());
        ei();
        ECDebugUtils eCDebugUtils = ECDebugUtils.f104852b;
        TextView textView2 = this.titleTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        eCDebugUtils.e(textView2);
    }
}
