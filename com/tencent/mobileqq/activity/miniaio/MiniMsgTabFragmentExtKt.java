package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.biz.miniaio.IMiniAIOAPI;
import com.tencent.qqnt.chats.biz.miniaio.MiniAioActivity;
import com.tencent.qqnt.chats.biz.miniaio.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/miniaio/MiniMsgTabFragment;", "", "needHeader", "shieldGoMsgTabBtn", "", "c", "Lcom/tencent/qqnt/chats/biz/miniaio/a;", "event", "b", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class MiniMsgTabFragmentExtKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MiniMsgTabFragment miniMsgTabFragment, com.tencent.qqnt.chats.biz.miniaio.a aVar) {
        if (Intrinsics.areEqual(aVar, h.c.f354355a)) {
            FragmentActivity activity = miniMsgTabFragment.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(aVar, h.d.f354356a)) {
            miniMsgTabFragment.Wh();
        }
    }

    public static final void c(@NotNull MiniMsgTabFragment miniMsgTabFragment, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(miniMsgTabFragment, "<this>");
        FragmentTransaction beginTransaction = miniMsgTabFragment.getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        com.tencent.qqnt.chats.biz.miniaio.b createMiniMsgFragment = ((IMiniAIOAPI) QRoute.api(IMiniAIOAPI.class)).createMiniMsgFragment();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(miniMsgTabFragment), null, null, new MiniMsgTabFragmentExtKt$showMsgList$miniMsgInterface$1$1(createMiniMsgFragment, miniMsgTabFragment, null), 3, null);
        Fragment fragment = createMiniMsgFragment.getFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_need_header", z16);
        bundle.putBoolean("key_block_goto_msgTab", z17);
        fragment.setArguments(bundle);
        beginTransaction.add(R.id.f1l, fragment, MiniAioActivity.FRAGMENT_TAG);
        beginTransaction.show(fragment);
        beginTransaction.commitAllowingStateLoss();
    }
}
