package com.tencent.mobileqq.qqgamepub.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgamepub.data.QQGamePubSubscribe$AppSubscribeInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameSubscribeService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f264394a;

        /* renamed from: b, reason: collision with root package name */
        public String f264395b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f264396c;

        public a(String str, String str2, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Boolean.valueOf(z16));
                return;
            }
            this.f264394a = str;
            this.f264395b = str2;
            this.f264396c = z16;
        }
    }

    void enterSingleGameMsgPage(Context context, String str, int i3);

    boolean enterSubscribeManagePage(Activity activity, String str, String str2, String str3);

    void filterSingleGameMsgList(Activity activity, List<ChatMessage> list);

    View findGameGrayTipsViewInParent(ViewGroup viewGroup);

    List<QQGamePubSubscribe$AppSubscribeInfo> getCachedSubscribeList();

    a getGameInfoFromCacheMap(String str);

    void getSubscribeInfo(String str);

    void handleGameInfoUiOnRsp(ViewGroup viewGroup, String str, QQGamePubSubscribe$AppSubscribeInfo qQGamePubSubscribe$AppSubscribeInfo, boolean z16);

    void handleSubscribeGrayTipsUi(String str, ChatMessage chatMessage, ViewGroup viewGroup, int i3);

    boolean isFromAllMsgGameSinglePage(Intent intent);

    boolean isGameSinglePage(Intent intent);

    boolean isSubscribed(String str);

    void preHandleGameInfoUi(ViewGroup viewGroup, String str);

    void putToGameInfoMap(String str, a aVar);

    long reqSetSubscribeStatus(String str, int i3, int i16);

    void reqSubscribeList(int i3);
}
