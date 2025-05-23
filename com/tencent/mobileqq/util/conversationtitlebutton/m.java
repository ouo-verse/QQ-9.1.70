package com.tencent.mobileqq.util.conversationtitlebutton;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.avatar.utils.ProAvatarComponentUtils;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.conversationtitlebutton.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J4\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00070\u0002H\u0016J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016JN\u0010\u001b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2<\u0010\u000f\u001a8\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000e0\u0019\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00070\u0017H\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/m;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/g;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSupport", "", "callback", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfoForTip", "", "Landroid/graphics/drawable/Drawable;", "cb", "getAvatarDrawableList", "Lcom/tencent/mobileqq/util/conversationtitlebutton/l;", "buttonState", "", WadlProxyConsts.KEY_JUMP_URL, "handleIconClick", "needCustomizeTips", "Lkotlin/Function2;", "tip", "", "avatars", "getCustomTips", "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m implements g {
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object, android.graphics.drawable.Drawable[]] */
    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getAvatarDrawableList(Context context, BusinessInfoCheckUpdate.AppInfo appInfoForTip, Function1<? super Drawable[], Unit> cb5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        cb5.invoke(new Drawable[]{ProAvatarComponentUtils.e(context, 1, currentUin, false, 0L, 0, false, 0, null, 504, null)});
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public void getCustomTips(Context context, Function2<? super String, ? super List<? extends Drawable>, Unit> cb5) {
        List list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        list = ArraysKt___ArraysKt.toList(new Drawable[]{ProAvatarComponentUtils.e(context, 1, currentUin, false, 0L, 0, false, 0, null, 504, null)});
        cb5.invoke("test", list);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.g
    public boolean handleIconClick(TitleButtonState buttonState, Context context, String jumpUrl) {
        Intrinsics.checkNotNullParameter(buttonState, "buttonState");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        return false;
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
        return true;
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
