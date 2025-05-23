package com.tencent.ecommerce.biz.mainpage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010%\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPageSchemaTestFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initUI", "initListener", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getBusinessDescription", "", "Bh", "Landroid/widget/EditText;", "P", "Landroid/widget/EditText;", "schemaEtx", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "shopIdEtx", BdhLogUtil.LogTag.Tag_Req, "spuIdEtx", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "schemaEtxHint", "T", "shopIdEtxHint", "U", "spuIdEtxHint", "V", "schemaBtn", "W", "shopIdBtn", "X", "spuIdBtn", "<init>", "()V", "Y", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECMainPageSchemaTestFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private EditText schemaEtx;

    /* renamed from: Q, reason: from kotlin metadata */
    private EditText shopIdEtx;

    /* renamed from: R, reason: from kotlin metadata */
    private EditText spuIdEtx;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView schemaEtxHint;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView shopIdEtxHint;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView spuIdEtxHint;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView schemaBtn;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView shopIdBtn;

    /* renamed from: X, reason: from kotlin metadata */
    private TextView spuIdBtn;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/mainpage/ECMainPageSchemaTestFragment$b$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements IECSchemeCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f102945a;

            a(String str) {
                this.f102945a = str;
            }

            @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
            public void onCallbackFinished(JSONObject data) {
                cg0.a.b("ECMainPageSchemaTestFragment", "schema = " + this.f102945a + ", \u56de\u5305\uff1a" + data);
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = ECMainPageSchemaTestFragment.Lh(ECMainPageSchemaTestFragment.this).getText().toString();
            if (obj.length() > 0) {
                ECScheme.c(obj, new a(obj), null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/mainpage/ECMainPageSchemaTestFragment$c$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements IECSchemeCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f102947a;

            a(String str) {
                this.f102947a = str;
            }

            @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
            public void onCallbackFinished(JSONObject data) {
                cg0.a.b("ECMainPageSchemaTestFragment", "shopId = " + this.f102947a + ", \u56de\u5305\uff1a" + data);
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = ECMainPageSchemaTestFragment.Nh(ECMainPageSchemaTestFragment.this).getText().toString();
            ECScheme.c("mqqapi://ecommerce/open?target=21&channel=2&shop_id=" + obj + "&source=2", new a(obj), null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements View.OnClickListener {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/mainpage/ECMainPageSchemaTestFragment$d$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class a implements IECSchemeCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f102949a;

            a(String str) {
                this.f102949a = str;
            }

            @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
            public void onCallbackFinished(JSONObject data) {
                cg0.a.b("ECMainPageSchemaTestFragment", "spuId = " + this.f102949a + ", \u56de\u5305\uff1a" + data);
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            String obj = ECMainPageSchemaTestFragment.Ph(ECMainPageSchemaTestFragment.this).getText().toString();
            ECScheme.c("mqqapi://ecommerce/open?target=9&biz_type=1&channel=2&spu_id=" + obj + "&source_from=1", new a(obj), null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnFocusChangeListener {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
        
            if ((com.tencent.ecommerce.biz.mainpage.ECMainPageSchemaTestFragment.Lh(r1.f102950d).getText().toString().length() > 0) != false) goto L9;
         */
        @Override // android.view.View.OnFocusChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onFocusChange(View view, boolean z16) {
            int i3;
            TextView Mh = ECMainPageSchemaTestFragment.Mh(ECMainPageSchemaTestFragment.this);
            if (!z16) {
                i3 = 0;
            }
            i3 = 8;
            Mh.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnFocusChangeListener {
        f() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
        
            if ((com.tencent.ecommerce.biz.mainpage.ECMainPageSchemaTestFragment.Lh(r1.f102951d).getText().toString().length() > 0) != false) goto L9;
         */
        @Override // android.view.View.OnFocusChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onFocusChange(View view, boolean z16) {
            int i3;
            TextView Oh = ECMainPageSchemaTestFragment.Oh(ECMainPageSchemaTestFragment.this);
            if (!z16) {
                i3 = 0;
            }
            i3 = 8;
            Oh.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnFocusChangeListener {
        g() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0020, code lost:
        
            if ((com.tencent.ecommerce.biz.mainpage.ECMainPageSchemaTestFragment.Lh(r1.f102952d).getText().toString().length() > 0) != false) goto L9;
         */
        @Override // android.view.View.OnFocusChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onFocusChange(View view, boolean z16) {
            int i3;
            TextView Qh = ECMainPageSchemaTestFragment.Qh(ECMainPageSchemaTestFragment.this);
            if (!z16) {
                i3 = 0;
            }
            i3 = 8;
            Qh.setVisibility(i3);
        }
    }

    public static final /* synthetic */ EditText Lh(ECMainPageSchemaTestFragment eCMainPageSchemaTestFragment) {
        EditText editText = eCMainPageSchemaTestFragment.schemaEtx;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schemaEtx");
        }
        return editText;
    }

    public static final /* synthetic */ TextView Mh(ECMainPageSchemaTestFragment eCMainPageSchemaTestFragment) {
        TextView textView = eCMainPageSchemaTestFragment.schemaEtxHint;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schemaEtxHint");
        }
        return textView;
    }

    public static final /* synthetic */ EditText Nh(ECMainPageSchemaTestFragment eCMainPageSchemaTestFragment) {
        EditText editText = eCMainPageSchemaTestFragment.shopIdEtx;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopIdEtx");
        }
        return editText;
    }

    public static final /* synthetic */ TextView Oh(ECMainPageSchemaTestFragment eCMainPageSchemaTestFragment) {
        TextView textView = eCMainPageSchemaTestFragment.shopIdEtxHint;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopIdEtxHint");
        }
        return textView;
    }

    public static final /* synthetic */ EditText Ph(ECMainPageSchemaTestFragment eCMainPageSchemaTestFragment) {
        EditText editText = eCMainPageSchemaTestFragment.spuIdEtx;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spuIdEtx");
        }
        return editText;
    }

    public static final /* synthetic */ TextView Qh(ECMainPageSchemaTestFragment eCMainPageSchemaTestFragment) {
        TextView textView = eCMainPageSchemaTestFragment.spuIdEtxHint;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spuIdEtxHint");
        }
        return textView;
    }

    private final void initListener() {
        TextView textView = this.schemaBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schemaBtn");
        }
        textView.setOnClickListener(new b());
        TextView textView2 = this.shopIdBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopIdBtn");
        }
        textView2.setOnClickListener(new c());
        TextView textView3 = this.spuIdBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spuIdBtn");
        }
        textView3.setOnClickListener(new d());
        EditText editText = this.schemaEtx;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schemaEtx");
        }
        editText.setOnFocusChangeListener(new e());
        EditText editText2 = this.shopIdEtx;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopIdEtx");
        }
        editText2.setOnFocusChangeListener(new f());
        EditText editText3 = this.spuIdEtx;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spuIdEtx");
        }
        editText3.setOnFocusChangeListener(new g());
    }

    private final void initUI() {
        setTitle("\u81ea\u5b9a\u4e49\u8df3\u8f6c\u94fe\u63a5");
        this.schemaEtx = (EditText) yh().findViewById(R.id.nys);
        this.shopIdEtx = (EditText) yh().findViewById(R.id.nyt);
        this.spuIdEtx = (EditText) yh().findViewById(R.id.nyu);
        this.schemaEtxHint = (TextView) yh().findViewById(R.id.nyo);
        this.shopIdEtxHint = (TextView) yh().findViewById(R.id.nyp);
        this.spuIdEtxHint = (TextView) yh().findViewById(R.id.nyq);
        this.schemaBtn = (TextView) yh().findViewById(R.id.o9v);
        this.shopIdBtn = (TextView) yh().findViewById(R.id.o9w);
        this.spuIdBtn = (TextView) yh().findViewById(R.id.o9x);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECMainPageSchemaTestFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cs7;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI();
        initListener();
    }
}
