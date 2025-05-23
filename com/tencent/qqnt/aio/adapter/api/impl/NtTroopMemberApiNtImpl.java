package com.tencent.qqnt.aio.adapter.api.impl;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberListResult;
import com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J_\u0010\u0013\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022)\u0010\u0012\u001a%\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011H\u0016JY\u0010\u0018\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0017H\u0016JS\u0010\u001c\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022/\u0010\u0012\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0019\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u001bH\u0016J \u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/NtTroopMemberApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/INtTroopMemberApi;", "", TtmlNode.ATTR_TTS_ORIGIN, "removeColorNickChar", "troopUin", "memberUid", "", "needColorName", "needRemark", "from", "Lkotlin/Function1;", "Lcom/tencent/qqnt/aio/adapter/troop/a;", "Lkotlin/ParameterName;", "name", "nickInfo", "", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberNameCallback;", "callback", "fetchTroopMemberName", "forceNet", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "memberInfo", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberInfoCallback;", "fetchTroopMemberInfo", "", "memberInfoList", "Lcom/tencent/qqnt/aio/adapter/api/IFetchTroopMemberListCallback;", "fetchTroopMemberList", "needColorNick", "getShowName", "<init>", "()V", "Companion", "a", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NtTroopMemberApiNtImpl implements INtTroopMemberApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "NtTroopMemberApiNtImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/NtTroopMemberApiNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.adapter.api.impl.NtTroopMemberApiNtImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NtTroopMemberApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberInfo$lambda$4$lambda$3(String str, Function1 function1, int i3, String str2, GroupMemberListResult groupMemberListResult) {
        MemberInfo memberInfo = groupMemberListResult.infos.get(str);
        if (function1 != null) {
            function1.invoke(memberInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberList$lambda$6$lambda$5(Function1 function1, int i3, String str, GroupMemberListResult groupMemberListResult) {
        ArrayList arrayList = new ArrayList();
        Collection<MemberInfo> values = groupMemberListResult.infos.values();
        Intrinsics.checkNotNullExpressionValue(values, "result.infos.values");
        arrayList.addAll(values);
        if (function1 != null) {
            function1.invoke(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchTroopMemberName$lambda$2$lambda$1(String str, Function1 function1, String str2, NtTroopMemberApiNtImpl this$0, int i3, String str3, GroupMemberListResult groupMemberListResult) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        int i16;
        String str9;
        String str10;
        String str11;
        String str12;
        String l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MemberInfo memberInfo = groupMemberListResult.infos.get(str);
        if (memberInfo == null || (l3 = Long.valueOf(memberInfo.uin).toString()) == null) {
            str4 = "";
        } else {
            str4 = l3;
        }
        String str13 = null;
        if (memberInfo != null) {
            str5 = memberInfo.uid;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str5, "it?.uid ?: \"\"");
            str6 = str5;
        }
        if (memberInfo != null) {
            str7 = memberInfo.cardName;
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str8 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str7, "it?.cardName ?: \"\"");
            str8 = str7;
        }
        if (memberInfo != null) {
            i16 = memberInfo.cardNameId;
        } else {
            i16 = 0;
        }
        int i17 = i16;
        if (memberInfo != null) {
            str9 = memberInfo.cardName;
        } else {
            str9 = null;
        }
        if (str9 == null) {
            str9 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str9, "it?.cardName ?: \"\"");
        }
        String removeColorNickChar = this$0.removeColorNickChar(str9);
        if (memberInfo != null) {
            str10 = memberInfo.autoRemark;
        } else {
            str10 = null;
        }
        if (str10 == null) {
            str11 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str10, "it?.autoRemark ?: \"\"");
            str11 = str10;
        }
        if (memberInfo != null) {
            str13 = memberInfo.nick;
        }
        if (str13 == null) {
            str12 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str13, "it?.nick ?: \"\"");
            str12 = str13;
        }
        com.tencent.qqnt.aio.adapter.troop.a aVar = new com.tencent.qqnt.aio.adapter.troop.a(str2, str4, str6, str8, i17, removeColorNickChar, str11, str12);
        if (function1 != null) {
            function1.invoke(aVar);
        }
    }

    private final String removeColorNickChar(String origin) {
        int indexOf$default;
        if (TextUtils.isEmpty(origin)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < origin.length()) {
            if (origin.charAt(i3) == '<') {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) origin, Typography.greater, i3, false, 4, (Object) null);
                if (indexOf$default > 0) {
                    i3 = indexOf$default;
                }
            } else {
                sb5.append(origin.charAt(i3));
            }
            i3++;
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchTroopMemberInfo(@Nullable String troopUin, @Nullable final String memberUid, boolean forceNet, @NotNull String from, @Nullable final Function1<? super MemberInfo, Unit> callback) {
        boolean z16;
        boolean z17;
        Long longOrNull;
        long j3;
        ArrayList<String> arrayListOf;
        boolean isBlank;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, troopUin, memberUid, Boolean.valueOf(forceNet), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(troopUin);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (memberUid != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(memberUid);
                        if (!isBlank) {
                            z17 = false;
                            if (!z17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "fetchTroopMemberInfo: troopUin=" + troopUin + ", memberUid=" + memberUid + ", from=" + from);
                                }
                                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                                if (longOrNull != null) {
                                    j3 = longOrNull.longValue();
                                } else {
                                    j3 = 0;
                                }
                                long j16 = j3;
                                com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
                                if (c16 != null) {
                                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(memberUid);
                                    c16.e(j16, arrayListOf, forceNet, "NtTroopMemberApiNtImpl-" + from, new IGroupMemberListCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.au
                                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                                        public final void onResult(int i3, String str, GroupMemberListResult groupMemberListResult) {
                                            NtTroopMemberApiNtImpl.fetchTroopMemberInfo$lambda$4$lambda$3(memberUid, callback, i3, str, groupMemberListResult);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                QLog.e(TAG, 1, "fetchTroopMemberInfo: ");
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.e(TAG, 1, "fetchTroopMemberInfo: ");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        if (r0 != false) goto L12;
     */
    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchTroopMemberList(@Nullable String troopUin, boolean forceNet, @NotNull String from, @Nullable final Function1<? super List<MemberInfo>, Unit> callback) {
        Long longOrNull;
        long j3;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopUin, Boolean.valueOf(forceNet), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(troopUin);
        }
        z16 = true;
        if (z16) {
            QLog.e(TAG, 1, "fetchTroopMemberList: ");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "fetchTroopMemberList: troopUin=" + troopUin + ", from=" + from);
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
        if (c16 != null) {
            c16.getAllMemberList(j3, forceNet, new IGroupMemberListCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.av
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                public final void onResult(int i3, String str, GroupMemberListResult groupMemberListResult) {
                    NtTroopMemberApiNtImpl.fetchTroopMemberList$lambda$6$lambda$5(Function1.this, i3, str, groupMemberListResult);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchTroopMemberName(@Nullable final String troopUin, @Nullable final String memberUid, boolean needColorName, boolean needRemark, @NotNull String from, @Nullable final Function1<? super com.tencent.qqnt.aio.adapter.troop.a, Unit> callback) {
        boolean z16;
        boolean z17;
        Long longOrNull;
        long j3;
        ArrayList<String> arrayListOf;
        boolean isBlank;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, troopUin, memberUid, Boolean.valueOf(needColorName), Boolean.valueOf(needRemark), from, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (troopUin != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(troopUin);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    if (memberUid != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(memberUid);
                        if (!isBlank) {
                            z17 = false;
                            if (!z17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "fetchTroopMemberName: troopUin=" + troopUin + ", memberUid=" + memberUid + ", from=" + from);
                                }
                                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                                if (longOrNull != null) {
                                    j3 = longOrNull.longValue();
                                } else {
                                    j3 = 0;
                                }
                                long j16 = j3;
                                com.tencent.qqnt.kernel.api.s c16 = com.tencent.qqnt.msg.f.c();
                                if (c16 != null) {
                                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(memberUid);
                                    c16.e(j16, arrayListOf, false, "NtTroopMemberApiNtImpl-" + from, new IGroupMemberListCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.at
                                        @Override // com.tencent.qqnt.kernel.nativeinterface.IGroupMemberListCallback
                                        public final void onResult(int i3, String str, GroupMemberListResult groupMemberListResult) {
                                            NtTroopMemberApiNtImpl.fetchTroopMemberName$lambda$2$lambda$1(memberUid, callback, troopUin, this, i3, str, groupMemberListResult);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                }
                QLog.e(TAG, 1, "fetchTroopMemberName: ");
            }
        }
        z16 = true;
        if (!z16) {
        }
        QLog.e(TAG, 1, "fetchTroopMemberName: ");
    }

    @Override // com.tencent.qqnt.aio.adapter.api.INtTroopMemberApi
    @NotNull
    public String getShowName(@NotNull com.tencent.qqnt.aio.adapter.troop.a nickInfo, boolean needColorNick, boolean needRemark) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, nickInfo, Boolean.valueOf(needColorNick), Boolean.valueOf(needRemark));
        }
        Intrinsics.checkNotNullParameter(nickInfo, "nickInfo");
        if (needColorNick) {
            if (nickInfo.b().length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                return nickInfo.b();
            }
        }
        if (nickInfo.g().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return nickInfo.g();
        }
        if (needRemark) {
            if (nickInfo.a().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return nickInfo.a();
            }
        }
        if (nickInfo.d().length() <= 0) {
            z19 = false;
        }
        if (z19) {
            return nickInfo.d();
        }
        return nickInfo.j();
    }
}
