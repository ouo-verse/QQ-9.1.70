package com.tencent.mobileqq.aio.api.impl;

import android.content.Context;
import android.widget.EditText;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.aio.api.INTPanelInteractionListener;
import com.tencent.mobileqq.emosm.IAIOEmoticonUIHelper;
import com.tencent.qqnt.aio.adapter.emoticon.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/api/impl/NTPanelInteractionListenerImpl;", "Lcom/tencent/mobileqq/aio/api/INTPanelInteractionListener;", "Landroid/content/Context;", "context", "Landroid/widget/EditText;", "editText", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/emosm/IAIOEmoticonUIHelper;", "emoticonUIHelper", "", "panelProvider", "Lcom/tencent/mobileqq/AIODepend/IPanelInteractionListener;", "getNTPanelInteractionListener", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NTPanelInteractionListenerImpl implements INTPanelInteractionListener {
    @Override // com.tencent.mobileqq.aio.api.INTPanelInteractionListener
    public IPanelInteractionListener getNTPanelInteractionListener(Context context, EditText editText, a aioContext, IAIOEmoticonUIHelper emoticonUIHelper, Object panelProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editText, "editText");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(emoticonUIHelper, "emoticonUIHelper");
        return new k(context, editText, aioContext, emoticonUIHelper, null);
    }
}
