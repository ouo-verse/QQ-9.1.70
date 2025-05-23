package com.tencent.mobileqq.guild.feed.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.event.GuildEmojiDialogDismissEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedEmojiEvent;
import com.tencent.mobileqq.guild.message.api.IGuildRecentUseEmojiHandler;
import com.tencent.mobileqq.guild.message.chatpie.a;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildEmojiTransFragment extends QPublicBaseFragment {
    private com.tencent.mobileqq.guild.message.chatpie.a C;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements a.h {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.message.chatpie.a.h
        public void onDismiss() {
            SimpleEventBus.getInstance().dispatchEvent(new GuildEmojiDialogDismissEvent(), true);
            if (GuildEmojiTransFragment.this.getActivity() != null) {
                GuildEmojiTransFragment.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements com.tencent.mobileqq.guild.emoj.f {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.emoj.f
        public void a(String str, String str2, long j3, int i3, int i16, boolean z16) {
            QLog.d("GuildEmojiTransFragment", 1, "emojiId:" + i3 + " emojiType:" + i16 + " localId:" + i3);
            SimpleEventBus.getInstance().dispatchEvent(new GuildFeedEmojiEvent(i16, i3, null), true);
        }
    }

    private com.tencent.mobileqq.guild.emoj.f ph() {
        return new b();
    }

    private a.h qh() {
        return new a();
    }

    public static void rh(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        window.setNavigationBarColor(i3);
    }

    private void sh() {
        Bundle bundleExtra = getActivity().getIntent().getBundleExtra(com.tencent.mobileqq.guild.feed.b.f218116b);
        com.tencent.mobileqq.guild.emoj.b bVar = new com.tencent.mobileqq.guild.emoj.b();
        if (bundleExtra != null) {
            bVar.f217872f = bundleExtra.getString("key_channel_id");
            bVar.f217873g = bundleExtra.getString("key_guild_id");
            bVar.f217869c = bundleExtra.getInt("key_channel_type");
        }
        bVar.f217874h = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        bVar.f217875i = (Activity) getContext();
        bVar.f217868b = true;
        QLog.d("GuildEmojiTransFragment", 1, "showWithAnim");
        ((IGuildRecentUseEmojiHandler) bVar.f217874h.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildRecentUseEmojiHandlerName())).reqRecentUseEmojiList();
        this.C = com.tencent.mobileqq.guild.message.chatpie.a.A(bVar, ScreenUtil.SCREEN_HIGHT / 2, ph(), qh());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        String str;
        int i3;
        super.initWindowStyleAndAnimation(activity);
        Intent intent = activity.getIntent();
        if (intent != null) {
            str = intent.getStringExtra("guild_emoji_source_from");
        } else {
            str = "";
        }
        TextUtils.equals(str, "guild_emoji_source_from_feed_detail");
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (isNowThemeIsNight) {
            i3 = Color.parseColor("#1d1d20");
        } else {
            i3 = -1;
        }
        rh(activity, i3);
        ImmersiveUtils.setStatusTextColor(!isNowThemeIsNight, activity.getWindow());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        sh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d("GuildEmojiTransFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        com.tencent.mobileqq.guild.message.chatpie.a aVar = this.C;
        if (aVar != null) {
            aVar.p();
        }
    }
}
