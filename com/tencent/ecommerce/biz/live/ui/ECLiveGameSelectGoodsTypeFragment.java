package com.tencent.ecommerce.biz.live.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.remote.ServiceConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 B2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00104\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010/R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010/R\u0016\u00108\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010<\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0016\u0010?\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveGameSelectGoodsTypeFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "uh", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "initArguments", "isSelect", "Zh", "ai", "Yh", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "Landroid/widget/FrameLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/FrameLayout;", "showWangZheLayout", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/LinearLayout;", "showWindowGoodsLayout", ExifInterface.LATITUDE_SOUTH, "showWindowLayout", "Landroid/widget/ImageView;", "T", "Landroid/widget/ImageView;", "showWangZheGoodsImageView", "U", "showWindowGoodsImageView", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "windowGoodsNumberTextView", "W", "Z", "isWangZheGoodsSelected", "X", "isWindowGoodsSelected", "Y", "isWangZheUser", "notAuthenticated", "a0", "Ljava/lang/String;", "sessionId", "b0", "roomId", "c0", "userId", "d0", "I", "goodsNumber", "<init>", "()V", "e0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveGameSelectGoodsTypeFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private FrameLayout showWangZheLayout;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout showWindowGoodsLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private FrameLayout showWindowLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private ImageView showWangZheGoodsImageView;

    /* renamed from: U, reason: from kotlin metadata */
    private ImageView showWindowGoodsImageView;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView windowGoodsNumberTextView;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isWangZheGoodsSelected;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isWindowGoodsSelected;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isWangZheUser;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean notAuthenticated;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String sessionId = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String roomId = "0";

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String userId = "0";

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int goodsNumber;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveGameSelectGoodsTypeFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            String str;
            Bundle arguments = ECLiveGameSelectGoodsTypeFragment.this.getArguments();
            if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
                str = "";
            }
            if (str.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("GOK_LIVE_SELECT_WANGZHE", ECLiveGameSelectGoodsTypeFragment.this.isWangZheGoodsSelected);
                jSONObject.put("GOK_LIVE_SELECT_WINDOW", ECLiveGameSelectGoodsTypeFragment.this.isWindowGoodsSelected);
                jSONObject.put("live_product_counts", ECLiveGameSelectGoodsTypeFragment.this.goodsNumber);
                IECSchemeCallback b16 = ug0.a.b(str);
                if (b16 != null) {
                    b16.onCallbackFinished(jSONObject);
                }
                cg0.a.b("ECLiveSelectGoodsTypeFloatFragment", "onPageClose real do callback json=" + jSONObject);
            }
            ei0.a aVar = ei0.a.f396300a;
            ECLiveGameSelectGoodsTypeFragment eCLiveGameSelectGoodsTypeFragment = ECLiveGameSelectGoodsTypeFragment.this;
            aVar.b(eCLiveGameSelectGoodsTypeFragment, eCLiveGameSelectGoodsTypeFragment.roomId, ECLiveGameSelectGoodsTypeFragment.this.userId);
            FragmentActivity activity = ECLiveGameSelectGoodsTypeFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveGameSelectGoodsTypeFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ECLiveGameSelectGoodsTypeFragment.this.notAuthenticated) {
                ECScheme.g("mqqapi://ecommerce/open?target=1&channel=8&src_type=internal&version=1&jump_scheme=", null, 2, null);
            } else {
                ECLiveGameSelectGoodsTypeFragment.this.Zh(!r0.isWangZheGoodsSelected);
            }
            ei0.a.f396300a.c(ECLiveGameSelectGoodsTypeFragment.Ph(ECLiveGameSelectGoodsTypeFragment.this), "em_qqlive_wz_shop_button", ECLiveGameSelectGoodsTypeFragment.this.roomId, ECLiveGameSelectGoodsTypeFragment.this.userId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ FrameLayout Ph(ECLiveGameSelectGoodsTypeFragment eCLiveGameSelectGoodsTypeFragment) {
        FrameLayout frameLayout = eCLiveGameSelectGoodsTypeFragment.showWangZheLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWangZheLayout");
        }
        return frameLayout;
    }

    public static final /* synthetic */ FrameLayout Qh(ECLiveGameSelectGoodsTypeFragment eCLiveGameSelectGoodsTypeFragment) {
        FrameLayout frameLayout = eCLiveGameSelectGoodsTypeFragment.showWindowLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWindowLayout");
        }
        return frameLayout;
    }

    public static final /* synthetic */ TextView Sh(ECLiveGameSelectGoodsTypeFragment eCLiveGameSelectGoodsTypeFragment) {
        TextView textView = eCLiveGameSelectGoodsTypeFragment.windowGoodsNumberTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowGoodsNumberTextView");
        }
        return textView;
    }

    private final void Yh() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        this.isWangZheUser = false;
        if (intent != null && intent.hasExtra("is_wangzhe_user")) {
            this.isWangZheUser = Intrinsics.areEqual(intent.getStringExtra("is_wangzhe_user"), "true");
        }
        bundle.putInt("scroll_margin_top", (int) (ECDeviceUtils.f104857e.i(r1.d()) - (this.isWangZheUser ? 194.0f : 138.0f)));
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.floatGestureLayout = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new b());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout2.setContentScrollListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout3 = this.floatGestureLayout;
        if (eCFloatGestureLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout3.C(this, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(boolean isSelect) {
        this.isWangZheGoodsSelected = isSelect;
        ImageView imageView = this.showWangZheGoodsImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWangZheGoodsImageView");
        }
        imageView.setImageResource(this.isWangZheGoodsSelected ? R.drawable.dhy : R.drawable.dhz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ai(boolean isSelect) {
        this.isWindowGoodsSelected = isSelect;
        ImageView imageView = this.showWindowGoodsImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWindowGoodsImageView");
        }
        imageView.setImageResource(this.isWindowGoodsSelected ? R.drawable.dhy : R.drawable.dhz);
    }

    private final void initArguments() {
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            this.isWangZheGoodsSelected = Intrinsics.areEqual(intent.getStringExtra("is_wangzhe_select"), "true");
            this.isWindowGoodsSelected = Intrinsics.areEqual(intent.getStringExtra("is_window_select"), "true");
            String stringExtra = intent.getStringExtra("live_product_counts");
            this.goodsNumber = stringExtra != null ? Integer.parseInt(stringExtra) : 0;
            this.notAuthenticated = Intrinsics.areEqual(intent.getStringExtra("is_not_authenticated"), "true");
            String stringExtra2 = intent.getStringExtra(ServiceConst.PARA_SESSION_ID);
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.sessionId = stringExtra2;
            String stringExtra3 = intent.getStringExtra("live_room_id");
            if (stringExtra3 == null) {
                stringExtra3 = "0";
            }
            this.roomId = stringExtra3;
            String stringExtra4 = intent.getStringExtra("live_user_id");
            this.userId = stringExtra4 != null ? stringExtra4 : "0";
        }
        cg0.a.b("ECLiveSelectGoodsTypeFloatFragment", "initArguments, isWangZheGoodsSelected:" + this.isWangZheGoodsSelected + ", isWindowGoodsSelected:" + this.isWindowGoodsSelected + ",goodsNumber:" + this.goodsNumber + '}');
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveSelectGoodsTypeFloatFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqb;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout.E();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Yh();
        this.showWangZheLayout = (FrameLayout) view.findViewById(R.id.of_);
        this.showWindowLayout = (FrameLayout) view.findViewById(R.id.ofx);
        this.showWangZheGoodsImageView = (ImageView) view.findViewById(R.id.of9);
        this.showWindowGoodsImageView = (ImageView) view.findViewById(R.id.ofw);
        this.showWindowGoodsLayout = (LinearLayout) view.findViewById(R.id.ofq);
        this.windowGoodsNumberTextView = (TextView) view.findViewById(R.id.ofp);
        ei0.a aVar = ei0.a.f396300a;
        aVar.a(this, this.roomId, this.userId);
        ImageView imageView = this.showWindowGoodsImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWindowGoodsImageView");
        }
        aVar.d(imageView, "em_qqlive_commerce_window", this.roomId, this.userId);
        FrameLayout frameLayout = this.showWangZheLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWangZheLayout");
        }
        aVar.d(frameLayout, "em_qqlive_wz_shop_button", this.roomId, this.userId);
        FrameLayout frameLayout2 = this.showWindowLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWindowLayout");
        }
        aVar.d(frameLayout2, "em_qqlive_shopwindow_button", this.roomId, this.userId);
        boolean z16 = false;
        if (this.isWangZheUser) {
            FrameLayout frameLayout3 = this.showWangZheLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showWangZheLayout");
            }
            frameLayout3.setVisibility(0);
        } else {
            FrameLayout frameLayout4 = this.showWangZheLayout;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showWangZheLayout");
            }
            frameLayout4.setVisibility(8);
        }
        Zh(this.isWangZheGoodsSelected);
        if (this.isWindowGoodsSelected && this.goodsNumber > 0) {
            z16 = true;
        }
        ai(z16);
        if (this.isWindowGoodsSelected && this.goodsNumber > 0) {
            TextView textView = this.windowGoodsNumberTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowGoodsNumberTextView");
            }
            textView.setText("\u5df2\u6dfb\u52a0" + this.goodsNumber + "\u4e2a\u5546\u54c1");
        } else {
            TextView textView2 = this.windowGoodsNumberTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowGoodsNumberTextView");
            }
            textView2.setText(requireContext().getString(R.string.wnf));
        }
        FrameLayout frameLayout5 = this.showWangZheLayout;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWangZheLayout");
        }
        frameLayout5.setOnClickListener(new d());
        FrameLayout frameLayout6 = this.showWindowLayout;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("showWindowLayout");
        }
        frameLayout6.setOnClickListener(new ECLiveGameSelectGoodsTypeFragment$onViewCreated$2(this));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }
}
