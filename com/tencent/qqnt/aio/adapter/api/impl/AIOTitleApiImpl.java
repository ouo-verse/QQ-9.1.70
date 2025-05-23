package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.nt.aio.title.GameMsgTitleEvent;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.aio.contact.profile.l;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.relation.common.nt.api.IRelationAIOService;
import com.tencent.util.TokenResUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOTitleApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOTitleApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "openCircleProfileActivity", "openProfileActivity", "", "uid", "nameByConfig", "openProfileActivityFromGroup", "openContactStrangerProfile", "", "isSupportEar", "isSupportUnreadCount", "Landroid/graphics/drawable/Drawable;", "getRight1Bg", "getRight2Bg", "onNickClick", "Landroid/content/Context;", "Landroid/widget/TextView;", "getLyricView", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOTitleApiImpl implements IAIOTitleApi {
    public static final String TAG = "AIOTitleApiImpl";

    private final String nameByConfig(String uid) {
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        if (uid == null) {
            return null;
        }
        aVar.d(uid);
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    private final void openCircleProfileActivity(com.tencent.aio.api.runtime.a context) {
        l.Companion companion = com.tencent.qqnt.aio.contact.profile.l.INSTANCE;
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        AIOParam g16 = context.g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        companion.a(requireActivity, su3.c.a(g16));
    }

    private final void openContactStrangerProfile(com.tencent.aio.api.runtime.a context) {
        AIOSession r16;
        AIOContact c16;
        String j3;
        AIOSession r17;
        AIOContact c17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        SessionInfo sessionInfo = new SessionInfo();
        AIOParam g16 = context.g();
        if (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return;
        }
        String nameFromPhone = ((IRelationAIOService) QRoute.api(IRelationAIOService.class)).getNameFromPhone(j3);
        AIOParam g17 = context.g();
        Integer valueOf = (g17 == null || (r17 = g17.r()) == null || (c17 = r17.c()) == null) ? null : Integer.valueOf(c17.e());
        Intrinsics.checkNotNull(valueOf);
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(valueOf.intValue());
        sessionInfo.f179557e = j3;
        if (!TextUtils.isEmpty(nameFromPhone)) {
            j3 = nameFromPhone;
        }
        sessionInfo.f179563i = j3;
        ChatActivityFacade.t0(sessionInfo, qQAppInterface, context.c().requireActivity());
    }

    private final void openProfileActivity(com.tencent.aio.api.runtime.a context) {
        AIOSession r16;
        AIOContact c16;
        AIOSession r17;
        AIOContact c17;
        AIOSession r18;
        AIOContact c18;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        SessionInfo sessionInfo = new SessionInfo();
        AIOParam g16 = context.g();
        String str = null;
        Integer valueOf = (g16 == null || (r18 = g16.r()) == null || (c18 = r18.c()) == null) ? null : Integer.valueOf(c18.e());
        Intrinsics.checkNotNull(valueOf);
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(valueOf.intValue());
        AIOParam g17 = context.g();
        sessionInfo.f179557e = String.valueOf(g17 != null ? Long.valueOf(su3.c.a(g17)) : null);
        AIOParam g18 = context.g();
        String nameByConfig = nameByConfig((g18 == null || (r17 = g18.r()) == null || (c17 = r17.c()) == null) ? null : c17.j());
        if (TextUtils.isEmpty(nameByConfig)) {
            nameByConfig = com.tencent.mobileqq.utils.ac.s(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179559f, com.tencent.mobileqq.utils.ac.w(sessionInfo.f179555d), 3);
        }
        sessionInfo.f179563i = nameByConfig;
        AIOParam g19 = context.g();
        if (g19 != null && (r16 = g19.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        }
        sessionInfo.f178172i0 = str;
        ChatActivityFacade.t0(sessionInfo, qQAppInterface, context.c().requireActivity());
    }

    private final void openProfileActivityFromGroup(final com.tencent.aio.api.runtime.a context) {
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.qqnt.kernel.api.w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        AIOParam g16 = context.g();
        if (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null || (msgService = ((IKernelService) qQAppInterface.getRuntimeService(IKernelService.class, "")).getMsgService()) == null) {
            return;
        }
        msgService.getTempChatInfo(100, j3, new IGetTempChatInfoCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.z
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
            public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                AIOTitleApiImpl.openProfileActivityFromGroup$lambda$0(AIOTitleApiImpl.this, context, qQAppInterface, i3, str, tempChatInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openProfileActivityFromGroup$lambda$0(AIOTitleApiImpl this$0, com.tencent.aio.api.runtime.a context, QQAppInterface app, int i3, String str, TempChatInfo tempChatInfo) {
        AIOSession r16;
        AIOContact c16;
        AIOSession r17;
        AIOContact c17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(app, "$app");
        if (i3 != 0) {
            this$0.openProfileActivity(context);
            QLog.e(TAG, 1, "getTempChatInfo result:" + i3 + ", errMsg:" + str);
            return;
        }
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179559f = tempChatInfo.groupCode;
        AIOParam g16 = context.g();
        String str2 = null;
        Integer valueOf = (g16 == null || (r17 = g16.r()) == null || (c17 = r17.c()) == null) ? null : Integer.valueOf(c17.e());
        Intrinsics.checkNotNull(valueOf);
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(valueOf.intValue());
        AIOParam g17 = context.g();
        String valueOf2 = String.valueOf(g17 != null ? Long.valueOf(su3.c.a(g17)) : null);
        sessionInfo.f179557e = valueOf2;
        sessionInfo.f179563i = com.tencent.mobileqq.utils.ac.s(app, valueOf2, sessionInfo.f179559f, com.tencent.mobileqq.utils.ac.w(sessionInfo.f179555d), 3);
        AIOParam g18 = context.g();
        if (g18 != null && (r16 = g18.r()) != null && (c16 = r16.c()) != null) {
            str2 = c16.j();
        }
        sessionInfo.f178172i0 = str2;
        ChatActivityFacade.t0(sessionInfo, app, context.c().requireActivity());
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public TextView getLyricView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        OnlineStatusLyricView onlineStatusLyricView = new OnlineStatusLyricView(context);
        onlineStatusLyricView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        onlineStatusLyricView.setGravity(17);
        onlineStatusLyricView.setEllipsize(TextUtils.TruncateAt.END);
        onlineStatusLyricView.setIncludeFontPadding(false);
        onlineStatusLyricView.setMaxWidth((int) TypedValue.applyDimension(1, 200.0f, onlineStatusLyricView.getResources().getDisplayMetrics()));
        onlineStatusLyricView.setMaxLines(1);
        onlineStatusLyricView.setUseDefaultTextViewWhenNoLyrics(true);
        onlineStatusLyricView.setTextColor(Color.parseColor("#03081A"));
        onlineStatusLyricView.setTextAlign(Paint.Align.LEFT);
        onlineStatusLyricView.setTextSize(10.0f);
        return onlineStatusLyricView;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public Drawable getRight1Bg(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = context.c().getResources().getDrawable(R.drawable.qui_chat_settings_icon_nav_secondary);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.fragment.resourc\u2026tings_icon_nav_secondary)");
        return drawable;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public Drawable getRight2Bg(com.tencent.aio.api.runtime.a context) {
        int tokenRes;
        int tokenRes2;
        GroupAnonymousInfo anonymousInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = context.g().r().c().e();
        if (e16 == 1) {
            if (QQTheme.isNowSimpleUI()) {
                return BaseApplication.getContext().getResources().getDrawable(TokenResUtils.getTokenRes(R.drawable.b6s, R.drawable.qui_telephone_icon_nav_secondary));
            }
            return BaseApplication.getContext().getResources().getDrawable(TokenResUtils.getTokenRes(R.drawable.b6t, R.drawable.qui_telephone_icon_nav_secondary));
        }
        if (e16 != 2) {
            return null;
        }
        String j3 = context.g().r().c().j();
        com.tencent.qqnt.kernel.api.w e17 = com.tencent.qqnt.msg.f.e();
        boolean z16 = (e17 == null || (anonymousInfo = e17.getAnonymousInfo(j3)) == null) ? false : anonymousInfo.isAnonymousChat;
        if (QQTheme.isNowSimpleUI()) {
            if (z16) {
                tokenRes2 = TokenResUtils.getTokenRes(R.drawable.lmr, R.drawable.qui_daka_icon_secondary_01);
            } else {
                tokenRes2 = TokenResUtils.getTokenRes(R.drawable.lms, R.drawable.qui_daka_icon_nav_secondary);
            }
            return BaseApplication.getContext().getResources().getDrawable(tokenRes2);
        }
        if (z16) {
            tokenRes = TokenResUtils.getTokenRes(R.drawable.lmr, R.drawable.qui_daka_icon_nav_secondary);
        } else {
            tokenRes = TokenResUtils.getTokenRes(R.drawable.lmq, R.drawable.qui_daka_icon_nav_secondary);
        }
        return BaseApplication.getContext().getResources().getDrawable(tokenRes);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public boolean isSupportEar(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = context.g().r().c().e();
        return e16 == 2 || e16 == 1;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public boolean isSupportUnreadCount(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = context.g().r().c().e();
        if (context.g().l().getBoolean("key_is_scale_chat", false)) {
            return false;
        }
        return e16 == 2 || e16 == 1 || e16 == 111 || e16 == 101 || e16 == 100 || e16 == 3;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public void onNickClick(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int e16 = context.g().r().c().e();
        if (e16 == 1) {
            openProfileActivity(context);
            return;
        }
        if (e16 == 2) {
            TitleRight1IvApiImpl.INSTANCE.c(context);
            return;
        }
        if (e16 == 105) {
            context.e().h(GameMsgTitleEvent.MainTitleClickEvent.f212240d);
            return;
        }
        if (e16 == 111) {
            openContactStrangerProfile(context);
            return;
        }
        if (e16 == 113) {
            openCircleProfileActivity(context);
            return;
        }
        if (e16 != 117) {
            switch (e16) {
                case 100:
                    openProfileActivityFromGroup(context);
                    return;
                case 101:
                    openProfileActivity(context);
                    return;
                case 102:
                    openProfileActivity(context);
                    return;
                default:
                    return;
            }
        }
        openContactStrangerProfile(context);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOTitleApi
    public void setWindowStyle(Window window) {
        IAIOTitleApi.a.a(this, window);
    }
}
