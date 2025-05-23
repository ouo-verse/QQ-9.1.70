package com.tencent.mobileqq.gamecenter.data;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.data.GameGlobalData;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002JD\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0010H\u0007J\u001c\u0010\u001a\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0007J$\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\r2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J4\u0010!\u001a\u00020\b2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010$\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"H\u0007J\u0012\u0010%\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0007J0\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/e;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lorg/json/JSONObject;", "root", "", AppConstants.Key.COLUMN_MSG_UID, "", "g", "", tl.h.F, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/gamecenter/data/e$a;", "Lkotlin/collections/ArrayList;", "grayTipsInfo", "", "fromTinyId", "toTinyId", "fromUin", "b", "peerUid", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip$LocalGrayTipBuilder;", "e", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "localGrayTip", "a", "tip", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "finalContent", "grayTip", "d", "i", "Lcom/tencent/mobileqq/graytip/g;", "grayTipParam", "j", "c", "data", "f", "J", "sLastMsgUid", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f212007a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long sLastMsgUid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/e$a;", "", "", "a", "I", "b", "()I", "e", "(I)V", "type", "", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "title", "c", "f", "url", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String title;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String url;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final void d(@Nullable String str) {
            this.title = str;
        }

        public final void e(int i3) {
            this.type = i3;
        }

        public final void f(@Nullable String str) {
            this.url = str;
        }
    }

    e() {
    }

    @JvmStatic
    public static final void a(@Nullable LocalGrayTip localGrayTip, @Nullable String peerUid) {
        ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).addGrayTipForGameAIO(localGrayTip, peerUid);
    }

    private final void b(QQAppInterface app, ArrayList<a> grayTipsInfo, String fromTinyId, String toTinyId, String fromUin) {
        boolean z16;
        boolean z17;
        QLog.d("GameMsgGrayTipsHandler", 1, "[createGrayTips]");
        if (grayTipsInfo != null && !grayTipsInfo.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        try {
            String createUidFromTinyId = ((IGameMsgNtApi) api).createUidFromTinyId(Long.parseLong(toTinyId), Long.parseLong(fromTinyId));
            LocalGrayTip.LocalGrayTipBuilder e16 = e(createUidFromTinyId);
            StringBuilder sb5 = new StringBuilder();
            Iterator<a> it = grayTipsInfo.iterator();
            boolean z18 = false;
            while (it.hasNext()) {
                a tip = it.next();
                String title = tip.getTitle();
                if (title != null && title.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    Intrinsics.checkNotNullExpressionValue(tip, "tip");
                    if (d(tip, sb5, e16)) {
                        z18 = true;
                    }
                }
            }
            if (z18) {
                a(e16.m(), createUidFromTinyId);
                i(sb5, fromTinyId, toTinyId, fromUin, app);
            } else {
                QLog.e("GameMsgGrayTipsHandler", 1, "[addGrayTips] tips is invalid");
            }
        } catch (Exception e17) {
            QLog.e("GameMsgGrayTipsHandler", 1, e17, new Object[0]);
        }
    }

    @JvmStatic
    public static final void c(@Nullable String peerUid) {
        if (TextUtils.isEmpty(peerUid)) {
            QLog.e("GameMsgGrayTipsHandler", 1, "[addTipsForAddFriend] peerUid is empty");
            return;
        }
        try {
            Intrinsics.checkNotNull(peerUid);
            LocalGrayTip.LocalGrayTipBuilder e16 = e(peerUid);
            String string = MobileQQ.sMobileQQ.getResources().getString(R.string.f1363303v);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.resources.getS\u2026e_aio_not_qq_friend_tips)");
            LocalGrayTip.LocalGrayTipBuilder.i(e16, string, 0, 2, null);
            String string2 = MobileQQ.sMobileQQ.getResources().getString(R.string.f13606035);
            Intrinsics.checkNotNullExpressionValue(string2, "sMobileQQ.resources.getS\u2026io_click_add_friend_tips)");
            LocalGrayTip.LocalGrayTipBuilder.j(e16, string2, new ld1.a(), 0, 4, null);
            a(e16.m(), peerUid);
        } catch (Throwable th5) {
            QLog.e("GameMsgGrayTipsHandler", 1, th5, new Object[0]);
        }
    }

    private final boolean d(a tip, StringBuilder finalContent, LocalGrayTip.LocalGrayTipBuilder grayTip) {
        boolean z16;
        boolean z17;
        QLog.i("GameMsgGrayTipsHandler", 1, "[buildGrayTip] type:" + tip.getType() + ",title:" + tip.getTitle() + ",url:" + tip.getUrl());
        int type = tip.getType();
        if (type != 2) {
            if (type != 3) {
                if (type != 4) {
                    if (type != 5) {
                        String title = tip.getTitle();
                        Intrinsics.checkNotNull(title);
                        finalContent.append(title);
                        String title2 = tip.getTitle();
                        Intrinsics.checkNotNull(title2);
                        LocalGrayTip.LocalGrayTipBuilder.i(grayTip, title2, 0, 2, null);
                        return true;
                    }
                    String url = tip.getUrl();
                    if (url != null && url.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        String title3 = tip.getTitle();
                        Intrinsics.checkNotNull(title3);
                        finalContent.append(title3);
                        String url2 = tip.getUrl();
                        Intrinsics.checkNotNull(url2);
                        if (HttpUtil.isValidUrl(url2)) {
                            String title4 = tip.getTitle();
                            Intrinsics.checkNotNull(title4);
                            String url3 = tip.getUrl();
                            Intrinsics.checkNotNull(url3);
                            LocalGrayTip.LocalGrayTipBuilder.b(grayTip, title4, url3, 0, 4, null);
                            return true;
                        }
                        String title5 = tip.getTitle();
                        Intrinsics.checkNotNull(title5);
                        String url4 = tip.getUrl();
                        Intrinsics.checkNotNull(url4);
                        LocalGrayTip.LocalGrayTipBuilder.f(grayTip, title5, url4, 0, 4, null);
                        return true;
                    }
                } else {
                    String title6 = tip.getTitle();
                    Intrinsics.checkNotNull(title6);
                    finalContent.append(title6);
                    String title7 = tip.getTitle();
                    Intrinsics.checkNotNull(title7);
                    LocalGrayTip.LocalGrayTipBuilder.j(grayTip, title7, new ld1.a(), 0, 4, null);
                    return true;
                }
            } else {
                String title8 = tip.getTitle();
                Intrinsics.checkNotNull(title8);
                finalContent.append(title8);
                String title9 = tip.getTitle();
                Intrinsics.checkNotNull(title9);
                LocalGrayTip.LocalGrayTipBuilder.j(grayTip, title9, new ld1.c(), 0, 4, null);
                return true;
            }
        } else {
            String url5 = tip.getUrl();
            if (url5 != null && url5.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String title10 = tip.getTitle();
                Intrinsics.checkNotNull(title10);
                finalContent.append(title10);
                String title11 = tip.getTitle();
                Intrinsics.checkNotNull(title11);
                String url6 = tip.getUrl();
                Intrinsics.checkNotNull(url6);
                LocalGrayTip.LocalGrayTipBuilder.b(grayTip, title11, url6, 0, 4, null);
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    @NotNull
    public static final LocalGrayTip.LocalGrayTipBuilder e(@NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return new LocalGrayTip.LocalGrayTipBuilder(peerUid, 105, 656397L, 0, false, false, null, 120, null);
    }

    @JvmStatic
    public static final void g(@NotNull QQAppInterface app, @NotNull JSONObject root, long msgUid) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(root, "root");
        try {
            QLog.i("GameMsgGrayTipsHandler", 1, "[handleGrayTipsFrom0x11c],data:" + root + ",uid:" + msgUid);
            e eVar = f212007a;
            if (eVar.h(msgUid)) {
                return;
            }
            sLastMsgUid = msgUid;
            String fromTinyId = root.optString("from_tinyid");
            String myTinyId = root.optString("tinyid");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content", root.optJSONArray("content"));
            jSONArray.mo162put(jSONObject);
            Intrinsics.checkNotNullExpressionValue(fromTinyId, "fromTinyId");
            Intrinsics.checkNotNullExpressionValue(myTinyId, "myTinyId");
            eVar.f(jSONArray, app, fromTinyId, myTinyId, "");
        } catch (Throwable th5) {
            QLog.e("GameMsgGrayTipsHandler", 1, th5, new Object[0]);
        }
    }

    private final boolean h(long msgUid) {
        if (msgUid == sLastMsgUid) {
            return true;
        }
        return false;
    }

    private final void i(StringBuilder finalContent, String fromTinyId, String toTinyId, String fromUin, QQAppInterface app) {
        String str;
        String str2;
        String currentAccountUin;
        IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
        GameGlobalData.Companion companion = GameGlobalData.INSTANCE;
        iGameMsgHelperApi.reportForGameMsg(companion.a().getMAppId(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "207652", finalContent.toString(), "", "8", "");
        if (!TextUtils.isEmpty(fromTinyId) && !TextUtils.isEmpty(toTinyId)) {
            str2 = fromTinyId;
            currentAccountUin = toTinyId;
        } else {
            if (!TextUtils.isEmpty(fromUin)) {
                str = fromUin;
            } else {
                str = "";
            }
            str2 = str;
            currentAccountUin = app.getCurrentAccountUin();
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(companion.a().getMAppId(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92005", "207652", finalContent.toString(), "", "8", str2, "", currentAccountUin);
    }

    @JvmStatic
    public static final void j(@Nullable QQAppInterface app, long msgUid, @Nullable com.tencent.mobileqq.graytip.g grayTipParam) {
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.msgUid = msgUid;
        messageForUniteGrayTip.initGrayTipMsg(app, grayTipParam);
        com.tencent.mobileqq.graytip.f.a(app, messageForUniteGrayTip);
    }

    public final void f(@Nullable Object data, @NotNull QQAppInterface app, @NotNull String fromTinyId, @NotNull String toTinyId, @NotNull String fromUin) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(fromTinyId, "fromTinyId");
        Intrinsics.checkNotNullParameter(toTinyId, "toTinyId");
        Intrinsics.checkNotNullParameter(fromUin, "fromUin");
        try {
            if (QLog.isColorLevel()) {
                QLog.d("GameMsgGrayTipsHandler", 2, "[onGetGrayTips], data:", data);
            }
            if (data == null) {
                return;
            }
            JSONArray jSONArray = (JSONArray) data;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONArray jSONArray2 = jSONArray.getJSONObject(i3).getJSONArray("content");
                ArrayList<a> arrayList = new ArrayList<>();
                int length2 = jSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    a aVar = new a();
                    JSONObject jSONObject = jSONArray2.getJSONObject(i16);
                    aVar.d(jSONObject.optString("title"));
                    aVar.e(jSONObject.optInt("type"));
                    aVar.f(jSONObject.optString("url"));
                    arrayList.add(aVar);
                }
                b(app, arrayList, fromTinyId, toTinyId, fromUin);
            }
        } catch (Throwable th5) {
            QLog.e("GameMsgGrayTipsHandler", 1, th5, new Object[0]);
        }
    }
}
