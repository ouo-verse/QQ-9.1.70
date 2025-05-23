package com.tencent.ecommerce.biz.shophome.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopRoleForbidDialog;", "Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopRoleForbidDialog$ECShopRoleForbidDialogResult;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "wh", "<init>", "()V", "ECShopRoleForbidDialogResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopRoleForbidDialog extends ECBaseDialogFragment<ECShopRoleForbidDialogResult> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopRoleForbidDialog$ECShopRoleForbidDialogResult;", "Landroid/os/Parcelable;", "()V", "Confirm", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopRoleForbidDialog$ECShopRoleForbidDialogResult$Confirm;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class ECShopRoleForbidDialogResult implements Parcelable {

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopRoleForbidDialog$ECShopRoleForbidDialogResult$Confirm;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopRoleForbidDialog$ECShopRoleForbidDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static final class Confirm extends ECShopRoleForbidDialogResult {

            /* renamed from: d, reason: collision with root package name */
            public static final Confirm f104363d = new Confirm();
            public static final Parcelable.Creator<Confirm> CREATOR = new a();

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
            /* loaded from: classes31.dex */
            public static class a implements Parcelable.Creator<Confirm> {
                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Confirm createFromParcel(Parcel parcel) {
                    if (parcel.readInt() != 0) {
                        return Confirm.f104363d;
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

        ECShopRoleForbidDialogResult() {
        }

        public /* synthetic */ ECShopRoleForbidDialogResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECBaseDialogFragment.th(ECShopRoleForbidDialog.this, ECShopRoleForbidDialogResult.Confirm.f104363d, 0, 2, null);
            ECShopRoleForbidDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.cu9;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wh(view);
    }

    public final void wh(View rootView) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        ((TextView) rootView.findViewById(R.id.o9f)).setOnClickListener(new a());
    }
}
