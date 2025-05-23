package com.tencent.mobileqq.matchfriend.report.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.matchfriend.report.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.QZoneClickReport;
import java.util.HashMap;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMatchFriendJubaoApi extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;
    public static final HashMap<From, String> SECRET_KEY;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class From {
        private static final /* synthetic */ From[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final From AIO;
        public static final From PARTY_ROOM;
        public static final From PARTY_ROOM_AUDIO;
        public static final From PARTY_ROOM_MSG;
        public static final From PROFILE_CARD;
        public static final From VOICE_MATCH;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24155);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            From from = new From("VOICE_MATCH", 0);
            VOICE_MATCH = from;
            From from2 = new From("PROFILE_CARD", 1);
            PROFILE_CARD = from2;
            From from3 = new From(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, 2);
            AIO = from3;
            From from4 = new From("PARTY_ROOM", 3);
            PARTY_ROOM = from4;
            From from5 = new From("PARTY_ROOM_MSG", 4);
            PARTY_ROOM_MSG = from5;
            From from6 = new From("PARTY_ROOM_AUDIO", 5);
            PARTY_ROOM_AUDIO = from6;
            $VALUES = new From[]{from, from2, from3, from4, from5, from6};
        }

        From(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static From valueOf(String str) {
            return (From) Enum.valueOf(From.class, str);
        }

        public static From[] values() {
            return (From[]) $VALUES.clone();
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(24161), (Class<?>) IMatchFriendJubaoApi.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            SECRET_KEY = new HashMap<>();
        }
    }

    void jumpMatchFriendJuBao(AppInterface appInterface, Activity activity, String str, String str2, String str3);

    void reportFeed(Context context, String str, String str2);

    void startMatchFriendJubaoByScene(BaseQQAppInterface baseQQAppInterface, Context context, From from, String str, String str2, a aVar);
}
