package bf1;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.t;
import com.tencent.mobileqq.app.automator.step.ChatBackgroundAuth;
import com.tencent.mobileqq.guild.background.GuildBackgroundContainer;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0016"}, d2 = {"Lbf1/a;", "Lr02/a;", "Landroid/content/Context;", "context", "", "curFriendUid", "", "uinType", "Landroid/view/View;", "b", "selfUin", "", "a", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "curFriendUin", "Landroid/graphics/drawable/Drawable;", "getCurrentChatBackgroundDrawable", "getCurrentChatBackgroundBg", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a implements r02.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28353a = new a();

    a() {
    }

    @Override // r02.a
    public void a(String selfUin) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
    }

    @Override // r02.a
    public View b(Context context, String curFriendUid, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUid, "curFriendUid");
        QLog.d("GuildBackgroundBase", 1, "AIO CREATE");
        new ChatBackgroundAuth().h(Boolean.FALSE);
        GuildBackgroundContainer guildBackgroundContainer = new GuildBackgroundContainer(context);
        guildBackgroundContainer.setInfo(curFriendUid, uinType);
        return guildBackgroundContainer;
    }

    @Override // r02.a
    public String getCurrentChatBackgroundBg(String curFriendUin, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        return ChatBackgroundUtil.getChatBackgroundPath(BaseApplication.getContext(), VasUtil.getCurrentUin(), curFriendUin);
    }

    @Override // r02.a
    public Drawable getCurrentChatBackgroundDrawable(String curFriendUin, int uinType) {
        Intrinsics.checkNotNullParameter(curFriendUin, "curFriendUin");
        t tVar = new t();
        if (TextUtils.isEmpty(curFriendUin)) {
            QLog.i("GuildBackgroundBase", 1, "convert uin is empty string, fail");
        }
        t.c(BaseApplication.getContext(), VasUtil.getCurrentUin(), curFriendUin, uinType, true, 7, tVar);
        Drawable drawable = tVar.f179996c;
        if (drawable != null && (drawable instanceof IGLDrawable)) {
            Drawable drawable2 = BaseApplication.getContext().getResources().getDrawable(R.drawable.chat_bg_texture);
            if (drawable2 instanceof BitmapDrawable) {
                ((BitmapDrawable) drawable2).setGravity(119);
            } else if (drawable2 instanceof SkinnableBitmapDrawable) {
                ((SkinnableBitmapDrawable) drawable2).setGravity(119);
            }
            tVar.f179996c = drawable2;
        }
        return tVar.f179996c;
    }

    @Override // r02.a
    public void onDestroy() {
    }

    @Override // r02.a
    public void onPause() {
    }

    @Override // r02.a
    public void onResume() {
    }
}
