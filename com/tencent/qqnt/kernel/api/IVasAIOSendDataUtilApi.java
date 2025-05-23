package com.tencent.qqnt.kernel.api;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IVasAIOSendDataUtilApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "detailVasMsgDataAttrs", "", Node.ATTRS_ATTR, "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "contact", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", QQBrowserActivity.KEY_MSG_TYPE, "kernel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IVasAIOSendDataUtilApi extends QRouteApi {
    void detailVasMsgDataAttrs(@NotNull HashMap<Integer, MsgAttributeInfo> attrs, @NotNull Contact contact, int msgType);
}
