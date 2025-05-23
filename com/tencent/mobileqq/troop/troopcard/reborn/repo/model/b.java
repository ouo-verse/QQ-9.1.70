package com.tencent.mobileqq.troop.troopcard.reborn.repo.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopcard.reborn.uimodel.h;
import com.tencent.qqnt.kernel.nativeinterface.EssenceMsgContent;
import com.tencent.qqnt.kernel.nativeinterface.EssenceMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupLatestEssenceListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/model/b;", "", "", "a", "Z", "c", "()Z", "isEnd", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "cookie", "", "Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;", "Ljava/util/List;", "()Ljava/util/List;", "fileList", "<init>", "(ZLjava/lang/String;Ljava/util/List;)V", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnd;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String cookie;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<h> fileList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/model/b$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupLatestEssenceListRsp;", "rsp", "Lcom/tencent/mobileqq/troop/troopcard/reborn/repo/model/b;", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.repo.model.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final b a(@NotNull GetGroupLatestEssenceListRsp rsp) {
            int collectionSizeOrDefault;
            Object firstOrNull;
            String str;
            String str2;
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            ArrayList<EssenceMsgInfo> arrayList = rsp.msgList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "rsp.msgList");
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (Iterator it = arrayList.iterator(); it.hasNext(); it = it) {
                EssenceMsgInfo essenceMsgInfo = (EssenceMsgInfo) it.next();
                ArrayList<EssenceMsgContent> arrayList3 = essenceMsgInfo.msgContent;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "it.msgContent");
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
                EssenceMsgContent essenceMsgContent = (EssenceMsgContent) firstOrNull;
                long j16 = essenceMsgInfo.groupCode;
                int i3 = essenceMsgInfo.msgSeq;
                int i16 = essenceMsgInfo.msgRandom;
                int i17 = essenceMsgInfo.senderTime;
                String jumpUrl = essenceMsgInfo.jumpUrl;
                String str3 = null;
                if (essenceMsgContent != null) {
                    str = essenceMsgContent.fileName;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "fileInfo?.fileName ?: \"\"");
                }
                if (essenceMsgContent != null) {
                    str3 = essenceMsgContent.fileThumbnailUrl;
                }
                if (str3 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str3, "fileInfo?.fileThumbnailUrl ?: \"\"");
                    str2 = str3;
                }
                if (essenceMsgContent != null) {
                    j3 = essenceMsgContent.fileSize;
                } else {
                    j3 = 0;
                }
                long j17 = j3;
                String senderNick = essenceMsgInfo.senderNick;
                String jumpUrl2 = essenceMsgInfo.jumpUrl;
                Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
                Intrinsics.checkNotNullExpressionValue(senderNick, "senderNick");
                Intrinsics.checkNotNullExpressionValue(jumpUrl2, "jumpUrl");
                arrayList2.add(new h(j16, i3, i16, i17, str, j17, str2, jumpUrl, senderNick, jumpUrl2));
            }
            boolean z16 = rsp.isEnd;
            String str4 = rsp.nextPageCookie;
            Intrinsics.checkNotNullExpressionValue(str4, "rsp.nextPageCookie");
            return new b(z16, str4, arrayList2);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57276);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(boolean z16, @NotNull String cookie, @NotNull List<h> fileList) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), cookie, fileList);
            return;
        }
        this.isEnd = z16;
        this.cookie = cookie;
        this.fileList = fileList;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.cookie;
    }

    @NotNull
    public final List<h> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fileList;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isEnd;
    }
}
