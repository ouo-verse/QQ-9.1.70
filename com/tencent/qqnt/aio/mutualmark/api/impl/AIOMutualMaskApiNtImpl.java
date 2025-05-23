package com.tencent.qqnt.aio.mutualmark.api.impl;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/mutualmark/api/impl/AIOMutualMaskApiNtImpl;", "Lcom/tencent/qqnt/aio/mutualmark/api/IAIOMutualMaskApi;", "", "troopUin", "uin", "honorStr", "", "richFlag", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "getDrawable", "memberUin", "Lcom/tencent/qqnt/aio/mutualmark/api/a;", "getMutualMarkInfo", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOMutualMaskApiNtImpl implements IAIOMutualMaskApi {
    static IPatchRedirector $redirector_;

    public AIOMutualMaskApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi
    @NotNull
    public ArrayList<Drawable> getDrawable(@NotNull String troopUin, @NotNull String uin, @NotNull String honorStr, byte richFlag) {
        ArrayList<Drawable> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, this, troopUin, uin, honorStr, Byte.valueOf(richFlag));
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(honorStr, "honorStr");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ColorDrawable(SupportMenu.CATEGORY_MASK), new ColorDrawable(-7829368));
        return arrayListOf;
    }

    @Override // com.tencent.qqnt.aio.mutualmark.api.IAIOMutualMaskApi
    @Nullable
    public com.tencent.qqnt.aio.mutualmark.api.a getMutualMarkInfo(@NotNull String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.aio.mutualmark.api.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin, (Object) memberUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        return null;
    }
}
