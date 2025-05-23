package com.tencent.ecommerce.biz.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0002\u001a\u001bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ECDetailGuidanceDialog;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initUI", "", "uh", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getBusinessDescription", "Lcom/tencent/ecommerce/biz/detail/ECDetailGuidanceDialog$IECDetailGuidanceDialogListener;", "P", "Lcom/tencent/ecommerce/biz/detail/ECDetailGuidanceDialog$IECDetailGuidanceDialogListener;", "Lh", "()Lcom/tencent/ecommerce/biz/detail/ECDetailGuidanceDialog$IECDetailGuidanceDialogListener;", "Mh", "(Lcom/tencent/ecommerce/biz/detail/ECDetailGuidanceDialog$IECDetailGuidanceDialogListener;)V", "onClickListener", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "IECDetailGuidanceDialogListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECDetailGuidanceDialog extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private IECDetailGuidanceDialogListener onClickListener;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/ECDetailGuidanceDialog$IECDetailGuidanceDialogListener;", "", "onCancel", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface IECDetailGuidanceDialogListener {
        void onCancel();
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
            IECDetailGuidanceDialogListener onClickListener = ECDetailGuidanceDialog.this.getOnClickListener();
            if (onClickListener != null) {
                onClickListener.onCancel();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* renamed from: Lh, reason: from getter */
    public final IECDetailGuidanceDialogListener getOnClickListener() {
        return this.onClickListener;
    }

    public final void Mh(IECDetailGuidanceDialogListener iECDetailGuidanceDialogListener) {
        this.onClickListener = iECDetailGuidanceDialogListener;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECDetailGuildDialog";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cpy;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return 0;
    }

    private final void initUI(View rootView) {
        ((Button) rootView.findViewById(R.id.f163028nx3)).setOnClickListener(new b());
        Bundle arguments = getArguments();
        int i3 = arguments != null ? arguments.getInt("channel_id") : -1;
        if (i3 == QQECChannel.CHANNEL_QQ_LITTLE_WORLD.ordinal()) {
            ((ImageView) rootView.findViewById(R.id.f163026nx1)).setImageResource(R.drawable.dic);
            ((TextView) rootView.findViewById(R.id.f163027nx2)).setText(R.string.wny);
            IECLocalConfig.a.h(ECLocalConfig.f100650f, "CHANNEL_MALGRANDA_MONDO_GVIDILO_KEY", true, null, 4, null);
        } else if (i3 == QQECChannel.CHANNEL_QQ_CHANNEL.ordinal()) {
            ((ImageView) rootView.findViewById(R.id.f163026nx1)).setImageResource(R.drawable.d0c);
            ((TextView) rootView.findViewById(R.id.f163027nx2)).setText(R.string.wga);
            IECLocalConfig.a.h(ECLocalConfig.f100650f, "CHANNEL_BABILEJO_GVIDILO_KEY", true, null, 4, null);
        }
    }
}
