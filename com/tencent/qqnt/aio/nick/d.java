package com.tencent.qqnt.aio.nick;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.anonymous.AIOTroopAnonymousNickBlock;
import com.tencent.qqnt.aio.gradelevel.AIOTroopMemberGradeLevelBlock;
import com.tencent.qqnt.aio.mutualmark.AIOTroopHonorNickBlock;
import com.tencent.qqnt.aio.nick.memberlevel.AIOTroopMemberLevelBlock;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\"\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/nick/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/b;", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "a", "", "bizId", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d extends com.tencent.mobileqq.aio.msglist.holder.component.nick.block.b {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.b
    @NotNull
    protected List<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> a(@NotNull Context context, @NotNull LinearLayout rootView) {
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) rootView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new AIOTroopMemberLevelBlock(context, rootView), new AIOTroopMemberGradeLevelBlock(context, rootView), new AIOTroopHonorNickBlock(context, rootView), new AIOTroopAnonymousNickBlock(context, rootView));
        return arrayListOf;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.nick.block.b
    @Nullable
    public com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a b(int bizId, @NotNull Context context, @NotNull LinearLayout rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(bizId), context, rootView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (bizId != 2) {
            if (bizId != 3) {
                return null;
            }
            return new AIOTroopHonorNickBlock(context, rootView);
        }
        return new AIOTroopMemberGradeLevelBlock(context, rootView);
    }
}
