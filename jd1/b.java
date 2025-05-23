package jd1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.msg.MsgExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0017\u00a8\u0006\r"}, d2 = {"Ljd1/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/f;", "Landroid/view/View;", "avatarView", "Landroid/graphics/drawable/Drawable;", "drawable", "", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "a", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b implements f {
    private final void c(final View avatarView, final Drawable drawable) {
        if (avatarView instanceof ImageView) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: jd1.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(avatarView, drawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View avatarView, Drawable drawable) {
        Intrinsics.checkNotNullParameter(avatarView, "$avatarView");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        ((ImageView) avatarView).setImageDrawable(drawable);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.f
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void a(@NotNull View avatarView, @NotNull MsgRecord msgRecord) {
        String str;
        Unit unit;
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            return;
        }
        Context context = avatarView.getContext();
        TempChatGameSession gameSessionFromMsg = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromMsg(msgRecord);
        if (gameSessionFromMsg == null) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.f160830com);
            Intrinsics.checkNotNullExpressionValue(drawable, "context.resources.getDra\u2026eqq.qqui.R.drawable.h001)");
            c(avatarView, drawable);
            QLog.e("GameMsgAvatarProcessor", 1, "[onLoad] gameSession or roleId is invalid,isSelf:" + MsgExtKt.S(msgRecord));
            return;
        }
        if (MsgExtKt.S(msgRecord)) {
            str = gameSessionFromMsg.selfRoleId;
        } else {
            str = gameSessionFromMsg.peerRoleId;
        }
        URLDrawable gameUsrDrawable = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameUsrDrawable(context, (AppInterface) peekAppRuntime, str);
        if (gameUsrDrawable != null) {
            c(avatarView, gameUsrDrawable);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Drawable drawable2 = context.getResources().getDrawable(R.drawable.f160830com);
            Intrinsics.checkNotNullExpressionValue(drawable2, "context.resources.getDra\u2026eqq.qqui.R.drawable.h001)");
            c(avatarView, drawable2);
        }
    }
}
