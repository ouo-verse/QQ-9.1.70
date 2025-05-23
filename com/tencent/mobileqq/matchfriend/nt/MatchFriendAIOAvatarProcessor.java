package com.tencent.mobileqq.matchfriend.nt;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.f;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0003J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/nt/MatchFriendAIOAvatarProcessor;", "Lcom/tencent/mobileqq/aio/msglist/holder/f;", "Lcom/tencent/common/app/AppInterface;", "app", "Landroid/view/View;", "avatarView", "", "chatType", "", "uid", "", "d", "", "tinyId", "g", "url", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MatchFriendAIOAvatarProcessor implements f {
    private final void d(AppInterface app, View avatarView, int chatType, String uid) {
        Long longOrNull;
        String str;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(uid);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            QQStrangerUserInfo userInfo = ((IQQStrangerUserInfoMgr) app.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(chatType, longValue, null, 4, null));
            boolean z16 = false;
            if (userInfo != null && (str = userInfo.avatar) != null) {
                if (str.length() > 0) {
                    z16 = true;
                }
            }
            if (!z16) {
                g(app, avatarView, chatType, longValue);
            } else {
                e(avatarView, userInfo.avatar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(final View avatarView, final String url) {
        final Drawable drawable = avatarView.getResources().getDrawable(R.drawable.exy);
        Intrinsics.checkNotNullExpressionValue(drawable, "avatarView.resources.get\u2026qq_nearby_avatar_default)");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.nt.a
            @Override // java.lang.Runnable
            public final void run() {
                MatchFriendAIOAvatarProcessor.f(url, avatarView, drawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String url, View avatarView, Drawable defaultDrawable) {
        Intrinsics.checkNotNullParameter(url, "$url");
        Intrinsics.checkNotNullParameter(avatarView, "$avatarView");
        Intrinsics.checkNotNullParameter(defaultDrawable, "$defaultDrawable");
        if (QLog.isDevelopLevel()) {
            QLog.d("MatchFriendAIOAvatarProcessor", 4, "loadAvatarInner url: " + url);
        }
        ((IImageLoader) QRoute.api(IImageLoader.class)).displayImage((ImageView) avatarView, url, defaultDrawable, defaultDrawable, null, true);
    }

    private final void g(AppInterface app, final View avatarView, int chatType, long tinyId) {
        ((IQQStrangerUserInfoMgr) app.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).reqUserInfo(new com.tencent.mobileqq.matchfriend.bean.c(chatType, tinyId, ""), new Function1<QQStrangerUserInfo, Unit>() { // from class: com.tencent.mobileqq.matchfriend.nt.MatchFriendAIOAvatarProcessor$loadAvatarRemote$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQStrangerUserInfo qQStrangerUserInfo) {
                invoke2(qQStrangerUserInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQStrangerUserInfo qQStrangerUserInfo) {
                if (qQStrangerUserInfo != null) {
                    MatchFriendAIOAvatarProcessor.this.e(avatarView, qQStrangerUserInfo.avatar);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.f
    public void a(View avatarView, MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(avatarView, "avatarView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        int i3 = msgRecord.chatType;
        String uid = msgRecord.senderUid;
        AppRuntime peekAppRuntime = BaseApplicationImpl.sApplication.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        if (Intrinsics.areEqual(appInterface.getCurrentUid(), uid)) {
            QQStrangerUserInfo selfUserInfo = ((IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getSelfUserInfo();
            if (selfUserInfo == null) {
                QLog.e("MatchFriendAIOAvatarProcessor", 1, "[onLoad] selfUserInfo is null. currentUid=" + uid);
                return;
            }
            d(appInterface, avatarView, i3, String.valueOf(selfUserInfo.tinyId));
            return;
        }
        if (TextUtils.isEmpty(uid)) {
            d(appInterface, avatarView, i3, "256111111111111111");
        } else {
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            d(appInterface, avatarView, i3, uid);
        }
    }
}
