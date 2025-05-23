package com.tencent.ecommerce.biz.shophome.ui.dialog;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cg0.a;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog;", "Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initView", "initListener", "", "shopId", "Ah", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "G", "Ljava/lang/String;", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "confirmBtn", "I", "cancelBtn", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "J", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "unbindShopHomeLoadingView", "Landroid/view/ViewGroup;", "K", "Landroid/view/ViewGroup;", "unbindShopHomeContainer", "<init>", "()V", "L", "a", "ECShopUnbindDialogResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopUnbindDialog extends ECBaseDialogFragment<ECShopUnbindDialogResult> {

    /* renamed from: G, reason: from kotlin metadata */
    private String shopId = "";

    /* renamed from: H, reason: from kotlin metadata */
    private TextView confirmBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView cancelBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private ECStateCenterView unbindShopHomeLoadingView;

    /* renamed from: K, reason: from kotlin metadata */
    private ViewGroup unbindShopHomeContainer;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult;", "Landroid/os/Parcelable;", "()V", "Cancel", "Confirm", "ReadyGo", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult$Confirm;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult$ReadyGo;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult$Cancel;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class ECShopUnbindDialogResult implements Parcelable {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult$Cancel;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class Cancel extends ECShopUnbindDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final Cancel f104366d = new Cancel();
            public static final Parcelable.Creator<Cancel> CREATOR = new a();

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<Cancel> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Cancel createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return Cancel.f104366d;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Cancel[] newArray(int i3) {
                    return new Cancel[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            Cancel() {
                super(null);
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(1);
            }
        }

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult$Confirm;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class Confirm extends ECShopUnbindDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final Confirm f104367d = new Confirm();
            public static final Parcelable.Creator<Confirm> CREATOR = new a();

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<Confirm> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Confirm createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return Confirm.f104367d;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Confirm[] newArray(int i3) {
                    return new Confirm[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            Confirm() {
                super(null);
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(1);
            }
        }

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult$ReadyGo;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopUnbindDialog$ECShopUnbindDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class ReadyGo extends ECShopUnbindDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final ReadyGo f104368d = new ReadyGo();
            public static final Parcelable.Creator<ReadyGo> CREATOR = new a();

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<ReadyGo> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final ReadyGo createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return ReadyGo.f104368d;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final ReadyGo[] newArray(int i3) {
                    return new ReadyGo[i3];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            ReadyGo() {
                super(null);
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(1);
            }
        }

        ECShopUnbindDialogResult() {
        }

        public /* synthetic */ ECShopUnbindDialogResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

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
            a.b("ECShopUnbindDialog", "Click cancel");
            ECBaseDialogFragment.th(ECShopUnbindDialog.this, ECShopUnbindDialogResult.Cancel.f104366d, 0, 2, null);
            ECShopUnbindDialog.this.dismiss();
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
            a.b("ECShopUnbindDialog", "Click Confirm");
            ECBaseDialogFragment.th(ECShopUnbindDialog.this, ECShopUnbindDialogResult.ReadyGo.f104368d, 0, 2, null);
            String str = ECShopUnbindDialog.this.shopId;
            if (str != null) {
                ECShopUnbindDialog.this.Ah(str);
            }
            ECShopUnbindDialog.xh(ECShopUnbindDialog.this).setVisibility(8);
            ECShopUnbindDialog.yh(ECShopUnbindDialog.this).setVisibility(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(String shopId) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ECShopUnbindDialog$requestUnBindShopPromoter$1(this, shopId, null), 3, null);
    }

    private final void initListener() {
        TextView textView = this.cancelBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        }
        textView.setOnClickListener(new b());
        TextView textView2 = this.confirmBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        }
        textView2.setOnClickListener(new c());
    }

    public static final /* synthetic */ ViewGroup xh(ECShopUnbindDialog eCShopUnbindDialog) {
        ViewGroup viewGroup = eCShopUnbindDialog.unbindShopHomeContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unbindShopHomeContainer");
        }
        return viewGroup;
    }

    public static final /* synthetic */ ECStateCenterView yh(ECShopUnbindDialog eCShopUnbindDialog) {
        ECStateCenterView eCStateCenterView = eCShopUnbindDialog.unbindShopHomeLoadingView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unbindShopHomeLoadingView");
        }
        return eCStateCenterView;
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.cua;
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.shopId = arguments != null ? arguments.getString("shopId", "") : null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    private final void initView(View rootView) {
        this.confirmBtn = (TextView) rootView.findViewById(R.id.oeu);
        this.cancelBtn = (TextView) rootView.findViewById(R.id.oet);
        this.unbindShopHomeContainer = (ViewGroup) rootView.findViewById(R.id.oex);
        this.unbindShopHomeLoadingView = (ECStateCenterView) rootView.findViewById(R.id.oew);
    }
}
