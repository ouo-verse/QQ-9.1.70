package com.tencent.mobileqq.intervideo.yiqikan;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private WindowManager.LayoutParams C;
    private WindowManager D;

    /* renamed from: d, reason: collision with root package name */
    private Activity f238509d;

    /* renamed from: e, reason: collision with root package name */
    private String f238510e;

    /* renamed from: f, reason: collision with root package name */
    private String f238511f;

    /* renamed from: h, reason: collision with root package name */
    private View f238512h;

    /* renamed from: i, reason: collision with root package name */
    com.tencent.mobileqq.activity.aio.j f238513i;

    /* renamed from: m, reason: collision with root package name */
    MiniMsgUserParam f238514m;

    public i(Activity activity, String str, String str2, MiniMsgUserParam miniMsgUserParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, str, str2, miniMsgUserParam);
            return;
        }
        this.f238513i = com.tencent.mobileqq.activity.aio.j.b();
        this.f238509d = activity;
        this.f238510e = str;
        this.f238514m = miniMsgUserParam;
        this.f238511f = str2;
    }

    public void a() {
        com.tencent.mobileqq.activity.miniaio.f businessInfo;
        int[] i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        MiniMsgUserParam miniMsgUserParam = this.f238514m;
        if (miniMsgUserParam != null) {
            if (miniMsgUserParam.accessType == 0 && miniMsgUserParam.entryType == 0 && (businessInfo = MiniMsgIPCClient.getInstance().getBusinessInfo(this.f238514m.businessName)) != null && (i3 = ((com.tencent.mobileqq.activity.miniaio.e) this.f238514m.unreadCallback).i()) != null) {
                businessInfo.f183484e = i3[0];
                businessInfo.f183485f = i3[1];
            }
            MiniMsgIPCClient.getInstance();
            MiniMsgIPCClient.onProcessBackground(this.f238514m.businessName);
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f238514m != null) {
            MiniMsgIPCClient.getInstance();
            MiniMsgIPCClient.register(this.f238514m.businessName, BaseApplicationImpl.getApplication().getQQProcessName());
            MiniMsgIPCClient.getInstance().syncGetUnread();
            MiniMsgIPCClient.getInstance();
            MiniMsgIPCClient.onProcessForeGround(this.f238514m.businessName);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f238512h == null) {
            View inflate = View.inflate(this.f238509d.getApplicationContext(), R.layout.f169180cf0, null);
            this.f238512h = inflate;
            inflate.setOnClickListener(this);
            String avatarAddress = ((ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class)).getAvatarAddress("", this.f238510e, 0);
            AbsDownloader.getFile(avatarAddress);
            RelativeLayout relativeLayout = (RelativeLayout) this.f238512h.findViewById(R.id.ewr);
            URLImageView uRLImageView = (URLImageView) this.f238512h.findViewById(R.id.ews);
            TextView textView = (TextView) this.f238512h.findViewById(R.id.ewt);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) uRLImageView.getLayoutParams();
            int dpToPx = ViewUtils.dpToPx(32.0f);
            int dpToPx2 = ViewUtils.dpToPx(28.0f);
            layoutParams.width = dpToPx;
            layoutParams.height = dpToPx2;
            int dpToPx3 = ViewUtils.dpToPx(24.0f);
            layoutParams2.width = dpToPx3;
            layoutParams2.height = dpToPx3;
            layoutParams2.leftMargin = ViewUtils.dpToPx(4.0f);
            uRLImageView.setPadding(0, 0, 0, 0);
            uRLImageView.setBackgroundDrawable(null);
            uRLImageView.setImageDrawable(URLDrawable.getDrawable(avatarAddress, (URLDrawable.URLDrawableOptions) null));
            if (AppSetting.f99565y) {
                AccessibilityUtil.e(this.f238512h, false);
            }
            this.D = (WindowManager) this.f238509d.getApplicationContext().getSystemService("window");
            this.C = new WindowManager.LayoutParams();
            if (QLog.isColorLevel()) {
                QLog.d("WatchTogetherMiniAioHelper", 2, "is activity window focused " + this.f238509d.hasWindowFocus());
            }
            MiniMsgUserParam miniMsgUserParam = this.f238514m;
            int i3 = miniMsgUserParam.positionX;
            int i16 = miniMsgUserParam.positionY;
            WindowManager.LayoutParams layoutParams3 = this.C;
            layoutParams3.type = 1002;
            layoutParams3.format = 1;
            layoutParams3.flags = 40;
            layoutParams3.gravity = 51;
            layoutParams3.x = i3;
            layoutParams3.y = i16;
            layoutParams3.width = -2;
            layoutParams3.height = -2;
            layoutParams3.token = this.f238509d.getWindow().getDecorView().getWindowToken();
            this.D.addView(this.f238512h, this.C);
        }
        this.f238512h.setVisibility(0);
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else {
            MiniMsgUserParam miniMsgUserParam = this.f238514m;
            if (miniMsgUserParam != null) {
                MiniMsgUser.IMiniMsgActionCallback iMiniMsgActionCallback = miniMsgUserParam.actionCallback;
                if (iMiniMsgActionCallback != null) {
                    iMiniMsgActionCallback.onOpenMiniAIOCallback();
                }
                Intent intent = new Intent();
                intent.putExtra(MiniChatConstants.KEY_MINI_NEED_UPDATE_UNREAD, true);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BUSINAME, this.f238514m.businessName);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_TYPE, this.f238514m.filterMsgType);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_NEED_FULL_SCREEN, this.f238514m.isNeedFullScreen);
                intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_ISNEED_BACK_CONVERSATION, this.f238514m.isNeedBackConversation);
                MiniMsgUserParam miniMsgUserParam2 = this.f238514m;
                if (miniMsgUserParam2.isNeedBackConversation) {
                    intent.putExtra(MiniChatConstants.KEY_MINI_MSGTAB_BACK_PENDING_INTENT, miniMsgUserParam2.backConversationIntent);
                }
                MiniChatActivity.Q2(this.f238509d, 1, this.f238510e, this.f238511f);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
