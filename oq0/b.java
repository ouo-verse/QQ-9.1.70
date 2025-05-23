package oq0;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.reserve2.busi.chosen.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qq0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Loq0/b;", "Lpl3/a;", "Loq0/a;", "", "action", "", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements pl3.a<a, Object> {
    @Override // pl3.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull a action) {
        Intrinsics.checkNotNullParameter(action, "action");
        com.tencent.aio.api.runtime.a context = action.getContext();
        b.d intent = action.getIntent();
        Context mContext = intent.getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentManager supportFragmentManager = ((FragmentActivity) mContext).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "intent.mContext as Fragm\u2026y).supportFragmentManager");
        co0.a.f31161a.c(supportFragmentManager, new d.ChosenParams(context.g().r().c(), intent.getMsgSeq()), context);
    }
}
