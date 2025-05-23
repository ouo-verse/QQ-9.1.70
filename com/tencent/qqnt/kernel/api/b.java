package com.tencent.qqnt.kernel.api;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/kernel/api/b;", "", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", QQBrowserActivity.KEY_MSG_TYPE, "", "a", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface b {
    void a(@NotNull HashMap<Integer, MsgAttributeInfo> attrs, @NotNull Contact contact, int msgType);
}
