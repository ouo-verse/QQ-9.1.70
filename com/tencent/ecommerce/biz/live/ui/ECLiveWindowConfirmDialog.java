package com.tencent.ecommerce.biz.live.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ei0.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0002()B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0010H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006*"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowConfirmDialog;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", ParseCommon.CONTAINER, "", "Oh", "", "uh", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowConfirmDialog$IButtonClickListener;", "clickListener", "Nh", "", "message", "Mh", "getBusinessDescription", "P", "Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowConfirmDialog$IButtonClickListener;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "rootContainer", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "messageTextView", ExifInterface.LATITUDE_SOUTH, "buttonDivider", "T", "Ljava/lang/String;", "Landroid/graphics/drawable/Drawable;", "U", "Landroid/graphics/drawable/Drawable;", "rootBackground", "<init>", "()V", "V", "a", "IButtonClickListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowConfirmDialog extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private IButtonClickListener clickListener;

    /* renamed from: Q, reason: from kotlin metadata */
    private View rootContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView messageTextView;

    /* renamed from: S, reason: from kotlin metadata */
    private View buttonDivider;

    /* renamed from: T, reason: from kotlin metadata */
    private String message;

    /* renamed from: U, reason: from kotlin metadata */
    private Drawable rootBackground;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/live/ui/ECLiveWindowConfirmDialog$IButtonClickListener;", "", "onNegativeBtnClick", "", "view", "Landroid/view/View;", "onPositiveBtnClick", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface IButtonClickListener {
        void onNegativeBtnClick(View view);

        void onPositiveBtnClick(View view);
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
            IButtonClickListener iButtonClickListener = ECLiveWindowConfirmDialog.this.clickListener;
            if (iButtonClickListener != null) {
                iButtonClickListener.onNegativeBtnClick(view);
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
            IButtonClickListener iButtonClickListener = ECLiveWindowConfirmDialog.this.clickListener;
            if (iButtonClickListener != null) {
                iButtonClickListener.onPositiveBtnClick(view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public final void Mh(String message) {
        if (message.length() > 0) {
            this.message = message;
            TextView textView = this.messageTextView;
            if (textView != null) {
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageTextView");
                }
                textView.setText(message);
            }
        }
    }

    public final void Nh(IButtonClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECLiveWindowConfirmDialog";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.crr;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.rootContainer = view.findViewById(R.id.nvi);
        this.messageTextView = (TextView) view.findViewById(R.id.nvj);
        this.buttonDivider = view.findViewById(R.id.nrx);
        String str = this.message;
        if (str != null) {
            if (str.length() > 0) {
                TextView textView = this.messageTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("messageTextView");
                }
                textView.setText(this.message);
            }
        }
        if (this.rootBackground != null) {
            View view2 = this.rootContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            }
            view2.setBackground(this.rootBackground);
        }
        Oh(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    private final void Oh(View container) {
        ((TextView) container.findViewById(R.id.od8)).setOnClickListener(new b());
        ((TextView) container.findViewById(R.id.odb)).setOnClickListener(new c());
        d dVar = d.f396304b;
        dVar.c(container.findViewById(R.id.od8));
        dVar.d(container.findViewById(R.id.odb));
    }
}
