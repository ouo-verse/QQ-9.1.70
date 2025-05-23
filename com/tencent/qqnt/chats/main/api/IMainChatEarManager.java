package com.tencent.qqnt.chats.main.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.core.ui.third.f;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0015J\u001e\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H&J&\u0010\b\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H&J\b\u0010\t\u001a\u00020\u0004H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0011\u001a\u00020\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0014\u001a\u00020\u0004H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/IMainChatEarManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "", "callback", "setNextCallback", "", "setOnLittleEarChangeCallback", "onLitterEarChange", "getCurItem", "getNextItem", "", "notify", "moveToNext", "hasLittleEar", "Lcom/tencent/qqnt/chats/core/ui/third/f;", "buildLittleParam", "Lcom/tencent/qqnt/chats/main/api/IMainChatEarManager$a;", "getParseInfo", "fetchEarChatList", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IMainChatEarManager extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/main/api/IMainChatEarManager$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "spCnt", "keywordCnt", "<init>", "(II)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int spCnt;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int keywordCnt;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a() {
            this(r2, r2, 3, null);
            int i3 = 0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.keywordCnt;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.spCnt;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.spCnt == aVar.spCnt && this.keywordCnt == aVar.keywordCnt) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.spCnt * 31) + this.keywordCnt;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "ParseInfo(spCnt=" + this.spCnt + ", keywordCnt=" + this.keywordCnt + ")";
        }

        public a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.spCnt = i3;
                this.keywordCnt = i16;
            }
        }

        public /* synthetic */ a(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? 0 : i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    @NotNull
    f buildLittleParam();

    void fetchEarChatList();

    @Nullable
    RecentContactInfo getCurItem();

    @Nullable
    RecentContactInfo getNextItem();

    @Nullable
    a getParseInfo();

    boolean hasLittleEar();

    boolean moveToNext(boolean notify);

    void onLitterEarChange();

    void setNextCallback(@Nullable Function1<? super RecentContactInfo, Unit> callback);

    void setOnLittleEarChangeCallback(@Nullable Function1<? super List<RecentContactInfo>, Unit> callback);
}
