package com.tencent.mobileqq.troop.troopblacklist.model;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qqnt.kernel.nativeinterface.GroupBlacklistGetAllApplyItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\f\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/model/c;", "Lcom/tencent/mobileqq/troop/troopblacklist/model/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "c", "()J", "uin", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "nickname", "", BdhLogUtil.LogTag.Tag_Conn, "()C", "firstChar", "<init>", "(JLjava/lang/String;C)V", "d", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class c extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickname;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final char firstChar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/model/c$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupBlacklistGetAllApplyItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/troop/troopblacklist/model/c;", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopblacklist.model.c$a, reason: from kotlin metadata */
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

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
        
            if (r1 != false) goto L42;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final c a(@NotNull GroupBlacklistGetAllApplyItem item) {
            boolean z16;
            boolean z17;
            char c16;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            }
            Intrinsics.checkNotNullParameter(item, "item");
            String nick = item.nickName;
            boolean z19 = true;
            if (nick != null && nick.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                nick = "\u672a\u77e5\u7528\u6237";
            }
            String d16 = ChnToSpell.d(nick, 1);
            if (d16 != null && d16.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            char c17 = '#';
            if (!z17) {
                c16 = d16.subSequence(0, 1).toString().charAt(0);
            } else {
                c16 = '#';
            }
            if ('A' <= c16 && c16 < '[') {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                if ('a' > c16 || c16 >= '{') {
                    z19 = false;
                }
            }
            c17 = Character.toUpperCase(c16);
            long j3 = item.uin;
            Intrinsics.checkNotNullExpressionValue(nick, "nick");
            return new c(j3, nick, Character.toUpperCase(c17));
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56910);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(long j3, @NotNull String nickname, char c16) {
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), nickname, Character.valueOf(c16));
            return;
        }
        this.uin = j3;
        this.nickname = nickname;
        this.firstChar = c16;
    }

    public final char a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Character) iPatchRedirector.redirect((short) 4, (Object) this)).charValue();
        }
        return this.firstChar;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.nickname;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.uin;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (this.uin == cVar.uin && Intrinsics.areEqual(this.nickname, cVar.nickname) && this.firstChar == cVar.firstChar) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return (((androidx.fragment.app.a.a(this.uin) * 31) + this.nickname.hashCode()) * 31) + this.firstChar;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "TroopBlackListMemberModel(uin=" + this.uin + ", nickname=" + this.nickname + ", firstChar=" + this.firstChar + ")";
    }
}
