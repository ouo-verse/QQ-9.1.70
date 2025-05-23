package com.tencent.mobileqq.util.conversationtitlebutton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.conversationtitlebutton.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ+\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/e;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/g;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSupport", "", "callback", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e implements g {
    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getAvatarDrawableList(Context context, BusinessInfoCheckUpdate.AppInfo appInfo, Function1<? super Drawable[], Unit> function1) {
        g.a.a(this, context, appInfo, function1);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getCustomTips(Context context, Function2<? super String, ? super List<? extends Drawable>, Unit> function2) {
        g.a.b(this, context, function2);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean handleIconClick(TitleButtonState titleButtonState, Context context, String str) {
        return g.a.c(this, titleButtonState, context, str);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void isSupport(Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(Boolean.TRUE);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeRedDot() {
        return g.a.d(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean needCustomizeTips() {
        return g.a.e(this);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void onButtonDidShow(ConversationTitleBtnConfig conversationTitleBtnConfig) {
        g.a.f(this, conversationTitleBtnConfig);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void refreshRedDot(RedTouch redTouch, BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16) {
        g.a.g(this, redTouch, appInfo, z16);
    }
}
