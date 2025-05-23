package com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/replace/b;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/replace/a;", "", "source", "", "c", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/replace/d;", "extraInfo", "d", "a", "replacement", "b", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/replace/b$a;", "", "", "TAG", "Ljava/lang/String;", "TA_DEFAULT", "TA_FEMALE", "TA_MALE", "TA_REPLACEMENT", "<init>", "()V", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace.b$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29880);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<String> c(String source) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("\\{\\w+\\}").matcher(source);
        while (matcher.find()) {
            String group = matcher.group();
            Intrinsics.checkNotNullExpressionValue(group, "matcher.group()");
            arrayList.add(group);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String d(d extraInfo) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar;
        int v3;
        ArrayList<String> arrayListOf;
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid;
        Object obj;
        Contact a16 = extraInfo.a();
        if (a16.chatType != 1) {
            return "\u4ed6";
        }
        Integer num = null;
        try {
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            String str = a16.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str);
            friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf, "LIADefaultReplaceProcessor");
        } catch (Throwable unused) {
        }
        if (friendSimpleInfoWithUid != null) {
            Iterator<T> it = friendSimpleInfoWithUid.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj).getUid(), a16.peerUid)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj;
            if (QLog.isColorLevel()) {
                if (dVar != null) {
                    num = Integer.valueOf(dVar.v());
                }
                QLog.i("LIADefaultReplaceProcessor", 2, "getTAReplace sex: " + num);
            }
            if (dVar != null || (v3 = dVar.v()) == 1 || v3 != 2) {
                return "\u4ed6";
            }
            return "\u5979";
        }
        dVar = null;
        if (QLog.isColorLevel()) {
        }
        return dVar != null ? "\u4ed6" : "\u4ed6";
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace.a
    @NotNull
    public List<String> a(@NotNull String source) {
        boolean z16;
        List<String> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
        }
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("LIADefaultReplaceProcessor", 2, "getReplacements source: " + source);
        if (source.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(c(source));
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.i("LIADefaultReplaceProcessor", 2, "getReplacements replacements: " + arrays);
        return arrayList;
    }

    @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace.a
    @NotNull
    public String b(@NotNull String replacement, @NotNull d extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) replacement, (Object) extraInfo);
        }
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (Intrinsics.areEqual(replacement, "{ta}")) {
            return d(extraInfo);
        }
        return replacement;
    }
}
