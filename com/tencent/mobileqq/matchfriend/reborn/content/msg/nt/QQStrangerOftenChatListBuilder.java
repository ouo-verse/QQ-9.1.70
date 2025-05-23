package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerOftenChatListBuilder;", "Lcom/tencent/qqnt/chats/core/data/a;", "", "e", "", tl.h.F, "f", "d", "Landroid/view/View;", "c", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerOftenChatListBuilder extends com.tencent.qqnt.chats.core.data.a {
    @Override // com.tencent.qqnt.chats.core.data.a
    public View c() {
        Lazy lazy;
        RelativeLayout relativeLayout = new RelativeLayout(QBaseActivity.sTopActivity);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        layoutParams.topMargin = ViewUtils.dpToPx(250.0f);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) QQStrangerOftenChatListBuilder$getEmptyView$emptyView$1.INSTANCE);
        relativeLayout.addView((View) lazy.getValue(), layoutParams);
        return relativeLayout;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public int d() {
        return 0;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public int e() {
        return 1;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public boolean f() {
        return false;
    }

    @Override // com.tencent.qqnt.chats.core.data.a
    public boolean h() {
        return false;
    }
}
