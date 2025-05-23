package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.activity.ChatSettingActivity;
import com.tencent.qqnt.aio.adapter.api.ITitleRight1IvApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TitleRight1IvApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITitleRight1IvApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "Ljava/lang/Class;", "Landroid/app/Activity;", "toClass", "", "onRight1IvClick", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TitleRight1IvApiNtImpl implements ITitleRight1IvApi {
    static IPatchRedirector $redirector_;

    public TitleRight1IvApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITitleRight1IvApi
    public void onRight1IvClick(@NotNull com.tencent.aio.api.runtime.a context, @Nullable Class<? extends Activity> toClass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) toClass);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (toClass == null) {
            toClass = ChatSettingActivity.class;
        }
        Intent intent = new Intent(context.c().getContext(), toClass);
        intent.putExtra("key_peerId", context.g().r().c().j());
        intent.putExtra("key_chat_type", context.g().r().c().e());
        intent.putExtra("key_chat_name", context.g().r().c().g());
        FragmentActivity activity = context.c().getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }
}
