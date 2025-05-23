package com.tencent.qqnt.aio.gallery.part;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chathistory.api.IChatHistoryApi;
import com.tencent.qqnt.chathistory.api.IHistoryForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.gallery.delegate.INTLayerOperationListener;
import com.tencent.richframework.gallery.part.NTAIOLayerBasePart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/part/k;", "Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "v", NodeProps.ON_CLICK, "Landroid/widget/ImageButton;", "d", "Landroid/widget/ImageButton;", "mHistoryMediaBtn", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class k extends NTAIOLayerBasePart implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageButton mHistoryMediaBtn;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (getMCurrentSelectedMessage() != null) {
                QRouteApi api = QRoute.api(IChatHistoryApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IChatHistoryApi::class.java)");
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                MsgRecord mCurrentSelectedMessage = getMCurrentSelectedMessage();
                Intrinsics.checkNotNull(mCurrentSelectedMessage);
                int i3 = mCurrentSelectedMessage.chatType;
                MsgRecord mCurrentSelectedMessage2 = getMCurrentSelectedMessage();
                Intrinsics.checkNotNull(mCurrentSelectedMessage2);
                String str = mCurrentSelectedMessage2.peerUid;
                Intrinsics.checkNotNullExpressionValue(str, "mCurrentSelectedMessage!!.peerUid");
                MsgRecord mCurrentSelectedMessage3 = getMCurrentSelectedMessage();
                Intrinsics.checkNotNull(mCurrentSelectedMessage3);
                IHistoryForwardApi.a.a((IHistoryForwardApi) api, context, new com.tencent.qqnt.chathistory.api.a(i3, str, mCurrentSelectedMessage3.peerName, 0, 8, null), 1, null, 8, null);
                INTLayerOperationListener mLayerOperateListener = getMLayerOperateListener();
                if (mLayerOperateListener != null) {
                    mLayerOperateListener.clickShowHistoryBtn();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ImageButton imageButton = (ImageButton) rootView.findViewById(R.id.zvc);
        this.mHistoryMediaBtn = imageButton;
        if (imageButton != null) {
            imageButton.setVisibility(0);
        }
        ImageButton imageButton2 = this.mHistoryMediaBtn;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        ImageButton imageButton3 = this.mHistoryMediaBtn;
        if (imageButton3 != null) {
            bindDtElement(imageButton3);
        }
    }
}
