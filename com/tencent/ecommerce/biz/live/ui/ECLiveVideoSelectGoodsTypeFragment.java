package com.tencent.ecommerce.biz.live.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Switch;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010&\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00101R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010(\u00a8\u0006?"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveVideoSelectGoodsTypeFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "uh", "getContentLayoutId", "", "getBusinessDescription", "", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "initArguments", "ai", "isSelect", "ci", ZPlanPublishSource.FROM_SCHEME, "bi", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "Landroid/widget/Switch;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/Switch;", "selectGokSwitcher", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/FrameLayout;", "selectGokLayout", ExifInterface.LATITUDE_SOUTH, "selectWindowLayout", "T", "selectQShopLayout", "U", "Z", "isEcommerceAuth", "V", "isGokGoodsSelected", "W", "isWangZheUser", "X", "isQShopUser", "Y", "Ljava/lang/String;", "roomId", "userId", "a0", "I", "goodsNumber", "b0", "shopGoodsNumber", "c0", "hasCallback", "<init>", "()V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveVideoSelectGoodsTypeFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private Switch selectGokSwitcher;

    /* renamed from: R, reason: from kotlin metadata */
    private FrameLayout selectGokLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private FrameLayout selectWindowLayout;

    /* renamed from: T, reason: from kotlin metadata */
    private FrameLayout selectQShopLayout;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isEcommerceAuth;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isGokGoodsSelected;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isWangZheUser;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isQShopUser;

    /* renamed from: Y, reason: from kotlin metadata */
    private String roomId = "0";

    /* renamed from: Z, reason: from kotlin metadata */
    private String userId = "0";

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int goodsNumber;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int shopGoodsNumber;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean hasCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveVideoSelectGoodsTypeFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            String str;
            if (!ECLiveVideoSelectGoodsTypeFragment.this.hasCallback) {
                Bundle arguments = ECLiveVideoSelectGoodsTypeFragment.this.getArguments();
                if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
                    str = "";
                }
                if (str.length() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("live_product_counts", ECLiveVideoSelectGoodsTypeFragment.this.goodsNumber);
                    jSONObject.put("shop_product_counts", ECLiveVideoSelectGoodsTypeFragment.this.shopGoodsNumber);
                    jSONObject.put("is_wangzhe_select", ECLiveVideoSelectGoodsTypeFragment.this.isGokGoodsSelected);
                    IECSchemeCallback b16 = ug0.a.b(str);
                    if (b16 != null) {
                        b16.onCallbackFinished(jSONObject);
                    }
                    cg0.a.b("ECLiveVideoSelectGoodsTypeFragment", "onPageClose real do callback json=" + jSONObject);
                }
            }
            FragmentActivity activity = ECLiveVideoSelectGoodsTypeFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/live/ui/ECLiveVideoSelectGoodsTypeFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            ECLiveVideoSelectGoodsTypeFragment.this.isGokGoodsSelected = z16;
            ei0.a.f396300a.c(ECLiveVideoSelectGoodsTypeFragment.Ph(ECLiveVideoSelectGoodsTypeFragment.this), "em_qqlive_wz_shop_button", ECLiveVideoSelectGoodsTypeFragment.this.roomId, ECLiveVideoSelectGoodsTypeFragment.this.userId);
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveVideoSelectGoodsTypeFragment eCLiveVideoSelectGoodsTypeFragment = ECLiveVideoSelectGoodsTypeFragment.this;
            if (eCLiveVideoSelectGoodsTypeFragment.goodsNumber > 0) {
                str = "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_trans_activity=1&is_appcompat_style=1&default_tab_id=0";
            } else {
                str = "mqqapi://ecommerce/open?target=7&channel=8&window_type=3&src_type=internal&version=1";
            }
            eCLiveVideoSelectGoodsTypeFragment.bi(str);
            ei0.a.f396300a.c(ECLiveVideoSelectGoodsTypeFragment.Rh(ECLiveVideoSelectGoodsTypeFragment.this), "em_qqlive_shopwindow_button", ECLiveVideoSelectGoodsTypeFragment.this.roomId, ECLiveVideoSelectGoodsTypeFragment.this.userId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            ECLiveVideoSelectGoodsTypeFragment eCLiveVideoSelectGoodsTypeFragment = ECLiveVideoSelectGoodsTypeFragment.this;
            if (eCLiveVideoSelectGoodsTypeFragment.shopGoodsNumber > 0) {
                str = "mqqapi://ecommerce/open?target=19&channel=8&is_master=1&is_trans_activity=1&is_appcompat_style=1&default_tab_id=2";
            } else {
                str = "mqqapi://ecommerce/open?target=51&channel=8&window_type=4&src_type=internal&version=1&is_appcompat_style=1";
            }
            eCLiveVideoSelectGoodsTypeFragment.bi(str);
            ei0.a.f396300a.c(ECLiveVideoSelectGoodsTypeFragment.Qh(ECLiveVideoSelectGoodsTypeFragment.this), "em_qqlive_qshop_button", ECLiveVideoSelectGoodsTypeFragment.this.roomId, ECLiveVideoSelectGoodsTypeFragment.this.userId);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ ECFloatGestureLayout Lh(ECLiveVideoSelectGoodsTypeFragment eCLiveVideoSelectGoodsTypeFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCLiveVideoSelectGoodsTypeFragment.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        return eCFloatGestureLayout;
    }

    public static final /* synthetic */ Switch Ph(ECLiveVideoSelectGoodsTypeFragment eCLiveVideoSelectGoodsTypeFragment) {
        Switch r16 = eCLiveVideoSelectGoodsTypeFragment.selectGokSwitcher;
        if (r16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectGokSwitcher");
        }
        return r16;
    }

    public static final /* synthetic */ FrameLayout Qh(ECLiveVideoSelectGoodsTypeFragment eCLiveVideoSelectGoodsTypeFragment) {
        FrameLayout frameLayout = eCLiveVideoSelectGoodsTypeFragment.selectQShopLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectQShopLayout");
        }
        return frameLayout;
    }

    public static final /* synthetic */ FrameLayout Rh(ECLiveVideoSelectGoodsTypeFragment eCLiveVideoSelectGoodsTypeFragment) {
        FrameLayout frameLayout = eCLiveVideoSelectGoodsTypeFragment.selectWindowLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectWindowLayout");
        }
        return frameLayout;
    }

    private final void ai() {
        Bundle bundle = new Bundle();
        boolean z16 = false;
        bundle.putBoolean("scroll_to_top", false);
        if (this.isWangZheUser && this.isEcommerceAuth) {
            z16 = true;
        }
        int a16 = (com.tencent.ecommerce.biz.util.b.a(z16) * 56) + (com.tencent.ecommerce.biz.util.b.a(this.isQShopUser) * 56) + (com.tencent.ecommerce.biz.util.b.a(this.isEcommerceAuth) * 56);
        bundle.putInt("scroll_margin_top", (int) (ECDeviceUtils.f104857e.i(r2.d()) - (a16 + 71)));
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
    public final void bi(String scheme) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("PARAM_ROOM_ID", this.roomId);
        hashMap.put("PARAM_USER_ID", this.userId);
        hashMap.put("PARAM_ENTRY_JUMP_SCHEME", scheme);
        cg0.a.b("ECLiveVideoSelectGoodsTypeFragment", "jumpTo scheme:" + scheme);
        com.tencent.ecommerce.biz.live.a.f102661d.m(hashMap, new ECLiveVideoSelectGoodsTypeFragment$jumpTo$1(this));
    }

    private final void ci(boolean isSelect) {
        this.isGokGoodsSelected = isSelect;
        Switch r26 = this.selectGokSwitcher;
        if (r26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectGokSwitcher");
        }
        r26.setChecked(this.isGokGoodsSelected);
    }

    private final void initArguments() {
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("PARAM_ROOM_ID");
            if (stringExtra == null) {
                stringExtra = "0";
            }
            this.roomId = stringExtra;
            String stringExtra2 = intent.getStringExtra("PARAM_USER_ID");
            this.userId = stringExtra2 != null ? stringExtra2 : "0";
            this.isEcommerceAuth = Intrinsics.areEqual(intent.getStringExtra("PARAM_IS_ECOMMERCE_AUTH"), "true");
            this.isWangZheUser = Intrinsics.areEqual(intent.getStringExtra("is_wangzhe_user"), "true");
            this.isQShopUser = Intrinsics.areEqual(intent.getStringExtra("PARAM_IS_XIAODIAN_USER"), "true");
            this.isGokGoodsSelected = Intrinsics.areEqual(intent.getStringExtra("is_wangzhe_select"), "true");
            String stringExtra3 = intent.getStringExtra("live_product_counts");
            this.goodsNumber = stringExtra3 != null ? Integer.parseInt(stringExtra3) : 0;
            String stringExtra4 = intent.getStringExtra("shop_product_counts");
            this.shopGoodsNumber = stringExtra4 != null ? Integer.parseInt(stringExtra4) : 0;
        }
        cg0.a.b("ECLiveVideoSelectGoodsTypeFragment", "initArguments, roomId:" + this.roomId + ",userId:" + this.userId + ",isWangZheUser:" + this.isWangZheUser + ",isXiaoDianUser:" + this.isQShopUser + ",isWangZheGoodsSelected:" + this.isGokGoodsSelected + ",goodsNumber:" + this.goodsNumber + ",shopGoodsNumber:" + this.shopGoodsNumber + ",isEcommerceAuth:" + this.isEcommerceAuth);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    public String getBusinessDescription() {
        return "ECLiveVideoSelectGoodsTypeFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqc;
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
        com.tencent.ecommerce.base.device.a.f100685b.f(requireContext(), view);
        ai();
        this.selectGokLayout = (FrameLayout) view.findViewById(R.id.of_);
        this.selectWindowLayout = (FrameLayout) view.findViewById(R.id.ofx);
        this.selectQShopLayout = (FrameLayout) view.findViewById(R.id.f163127og1);
        this.selectGokSwitcher = (Switch) view.findViewById(R.id.ofa);
        View findViewById = view.findViewById(R.id.o_l);
        FrameLayout frameLayout = this.selectWindowLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectWindowLayout");
        }
        frameLayout.setVisibility(this.isEcommerceAuth ? 0 : 8);
        FrameLayout frameLayout2 = this.selectGokLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectGokLayout");
        }
        frameLayout2.setVisibility(this.isEcommerceAuth && this.isWangZheUser ? 0 : 8);
        ci(this.isGokGoodsSelected);
        Switch r85 = this.selectGokSwitcher;
        if (r85 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectGokSwitcher");
        }
        r85.setOnCheckedChangeListener(new d());
        if (this.isQShopUser) {
            FrameLayout frameLayout3 = this.selectQShopLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectQShopLayout");
            }
            frameLayout3.setVisibility(0);
        } else {
            FrameLayout frameLayout4 = this.selectQShopLayout;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectQShopLayout");
            }
            frameLayout4.setVisibility(8);
        }
        FrameLayout frameLayout5 = this.selectWindowLayout;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectWindowLayout");
        }
        frameLayout5.setOnClickListener(new e());
        FrameLayout frameLayout6 = this.selectQShopLayout;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectQShopLayout");
        }
        frameLayout6.setOnClickListener(new f());
        ei0.a aVar = ei0.a.f396300a;
        aVar.a(this, this.roomId, this.userId);
        aVar.d(findViewById, "em_qqlive_commerce_window", this.roomId, this.userId);
        Switch r75 = this.selectGokSwitcher;
        if (r75 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectGokSwitcher");
        }
        aVar.d(r75, "em_qqlive_wz_shop_button", this.roomId, this.userId);
        FrameLayout frameLayout7 = this.selectWindowLayout;
        if (frameLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectWindowLayout");
        }
        aVar.d(frameLayout7, "em_qqlive_shopwindow_button", this.roomId, this.userId);
        FrameLayout frameLayout8 = this.selectQShopLayout;
        if (frameLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectQShopLayout");
        }
        aVar.d(frameLayout8, "em_qqlive_qshop_button", this.roomId, this.userId);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }
}
