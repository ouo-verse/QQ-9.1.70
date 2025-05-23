package com.tencent.qqnt.richui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.qqnt.avatar.meta.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/richui/a;", "Lcom/tencent/android/androidbypass/richui/view/c;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "j", "", "avatarId", "", "b", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements com.tencent.android.androidbypass.richui.view.c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final QQProAvatarView avatarView;

    public a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatarView = new QQProAvatarView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    @Override // com.tencent.android.androidbypass.richui.view.c
    public void b(String avatarId) {
        Intrinsics.checkNotNullParameter(avatarId, "avatarId");
        this.avatarView.A(new b.a(1, avatarId, 140, true).b());
    }

    @Override // com.tencent.android.androidbypass.richui.view.h
    /* renamed from: j, reason: from getter and merged with bridge method [inline-methods] */
    public QQProAvatarView getTextView() {
        return this.avatarView;
    }
}
