package com.tencent.ecommerce.base.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J.\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010'\u00a8\u00061"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECFloatCommonDetailBulletinFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "key", "", "", "map", RemoteHandleConst.PARAM_DEFAULT_VALUE, "Mh", "", "initArguments", "Nh", "", "getContentLayoutId", "getBusinessDescription", "", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "Landroid/widget/ImageView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/ImageView;", "closeImageView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "titleTv", ExifInterface.LATITUDE_SOUTH, "bulletinTextView", "T", "Ljava/lang/String;", "defaultTitle", "U", "titleTxt", "V", "bulletinText", "<init>", "()V", "W", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ECFloatCommonDetailBulletinFragment extends ECBaseFragment {

    /* renamed from: W, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private ImageView closeImageView;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView titleTv;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView bulletinTextView;

    /* renamed from: T, reason: from kotlin metadata */
    private String defaultTitle = "\u516c\u544a";

    /* renamed from: U, reason: from kotlin metadata */
    private String titleTxt = "\u516c\u544a";

    /* renamed from: V, reason: from kotlin metadata */
    private String bulletinText = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/base/ui/ECFloatCommonDetailBulletinFragment$a;", "", "Landroid/content/Context;", "context", "", "bulletinText", "title", "", "a", "CONTENT", "Ljava/lang/String;", "TAG", "TITLE", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.base.ui.ECFloatCommonDetailBulletinFragment$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, String bulletinText, String title) {
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("content", bulletinText);
            bundle.putString("is_trans_activity", "1");
            IECRouterLauncher a16 = xi0.a.INSTANCE.a();
            context.startActivity(a16 != null ? a16.getIntent(context, ECFloatCommonDetailBulletinFragment.class, bundle) : null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/base/ui/ECFloatCommonDetailBulletinFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECFloatCommonDetailBulletinFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/base/ui/ECFloatCommonDetailBulletinFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
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
    /* loaded from: classes32.dex */
    static final class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECFloatCommonDetailBulletinFragment.Lh(ECFloatCommonDetailBulletinFragment.this).E();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ ECFloatGestureLayout Lh(ECFloatCommonDetailBulletinFragment eCFloatCommonDetailBulletinFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCFloatCommonDetailBulletinFragment.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        return eCFloatGestureLayout;
    }

    private final String Mh(String key, Map<Object, ? extends Object> map, String defaultValue) {
        if (!map.containsKey(key) || !(map.get(key) instanceof String)) {
            return defaultValue;
        }
        Object obj = map.get(key);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void Nh() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putInt("scroll_margin_top", (int) (ECDeviceUtils.f104857e.i(r1.d()) - 206.0f));
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

    private final void initArguments() {
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent != null) {
            if (intent.hasExtra("title") && intent.hasExtra("content")) {
                String stringExtra = intent.getStringExtra("title");
                if (stringExtra == null) {
                    stringExtra = this.defaultTitle;
                }
                this.titleTxt = stringExtra;
                String stringExtra2 = intent.getStringExtra("content");
                this.bulletinText = stringExtra2 != null ? stringExtra2 : "";
                return;
            }
            Map<Object, Object> extUserDataMap = com.tencent.ecommerce.base.ktx.a.a(requireArguments(), "ext_userdata").getExtUserDataMap();
            this.titleTxt = Mh("title", extUserDataMap, this.defaultTitle);
            this.bulletinText = Mh("content", extUserDataMap, "");
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECFloatCommonDetailBulletinFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cpo;
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
        Nh();
        this.closeImageView = (ImageView) view.findViewById(R.id.nsn);
        this.titleTv = (TextView) view.findViewById(R.id.nsp);
        this.bulletinTextView = (TextView) view.findViewById(R.id.nso);
        ImageView imageView = this.closeImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeImageView");
        }
        imageView.setOnClickListener(new d());
        TextView textView = this.titleTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        }
        textView.setText(this.titleTxt);
        TextView textView2 = this.bulletinTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bulletinTextView");
        }
        textView2.setText(this.bulletinText);
    }
}
