package com.tencent.mobileqq.activity.contact.addcontact.gridentrance;

import android.text.TextUtils;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/h;", "", "", "c", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/d;", "a", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "DEFAULT_ID_LIST", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f181167a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> DEFAULT_ID_LIST;

    static {
        List<String> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.SRERR_CONVERT_UTF8);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f181167a = new h();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"1", "3", "6", "2", "7", "5", "4"});
        DEFAULT_ID_LIST = listOf;
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            String qqStr = HardCodeUtil.qqStr(R.string.ylb);
            if (qqStr == null) {
                return "";
            }
            return qqStr;
        }
        String addContactsMatchFriendEntryTitle = ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).getAddContactsMatchFriendEntryTitle(qQAppInterface);
        if (TextUtils.isEmpty(addContactsMatchFriendEntryTitle)) {
            addContactsMatchFriendEntryTitle = HardCodeUtil.qqStr(R.string.ylb);
            if (addContactsMatchFriendEntryTitle == null) {
                return "";
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(addContactsMatchFriendEntryTitle, "{\n            matchFriendTitle\n        }");
        }
        return addContactsMatchFriendEntryTitle;
    }

    @NotNull
    public final Map<String, d> a() {
        Map<String, d> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Pair[] pairArr = new Pair[9];
        String qqStr = HardCodeUtil.qqStr(R.string.yl5);
        String str = "";
        if (qqStr == null) {
            qqStr = "";
        }
        pairArr[0] = TuplesKt.to("1", new d(1001, qqStr, R.drawable.qui_telephone, 103));
        String qqStr2 = HardCodeUtil.qqStr(R.string.yl6);
        if (qqStr2 == null) {
            qqStr2 = "";
        }
        pairArr[1] = TuplesKt.to("2", new d(1002, qqStr2, R.drawable.qui_search, 106));
        String qqStr3 = HardCodeUtil.qqStr(R.string.yl_);
        if (qqStr3 == null) {
            qqStr3 = "";
        }
        pairArr[2] = TuplesKt.to("3", new d(1006, qqStr3, R.drawable.qui_scan, 104));
        String qqStr4 = HardCodeUtil.qqStr(R.string.yl9);
        if (qqStr4 == null) {
            qqStr4 = "";
        }
        pairArr[3] = TuplesKt.to("4", new d(1003, qqStr4, R.drawable.qui_position, 108));
        String qqStr5 = HardCodeUtil.qqStr(R.string.yl8);
        if (qqStr5 == null) {
            qqStr5 = "";
        }
        pairArr[4] = TuplesKt.to("5", new d(1004, qqStr5, R.drawable.qui_group_building, 107));
        String qqStr6 = HardCodeUtil.qqStr(R.string.yl7);
        if (qqStr6 == null) {
            qqStr6 = "";
        }
        pairArr[5] = TuplesKt.to("6", new d(1010, qqStr6, R.drawable.qui_face_to_face_add_friend, 105));
        pairArr[6] = TuplesKt.to("7", new d(1007, c(), R.drawable.qui_match_friend_bg, ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).getAddContactEntryDTID()));
        String qqStr7 = HardCodeUtil.qqStr(R.string.fz9);
        if (qqStr7 != null) {
            str = qqStr7;
        }
        pairArr[7] = TuplesKt.to("8", new d(1008, str, R.drawable.qui_add_friend, 109));
        pairArr[8] = TuplesKt.to("10", new d(1011, "\u627e\u642d\u5b50", R.drawable.qui_dazi_activity, 110));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return DEFAULT_ID_LIST;
    }
}
