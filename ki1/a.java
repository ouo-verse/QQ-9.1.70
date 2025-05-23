package ki1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.inbox.centerpanel.assistant.GuildAssistantFragment;
import com.tencent.mobileqq.guild.inbox.centerpanel.income.GuildNoticeIncomeFragment;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.GuildNoticeFragment;
import com.tencent.mobileqq.guild.inbox.startpanel.p;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b$\u0010%J*\u0010\t\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\n\u0010\u000e\u001a\u00060\rR\u00020\u0000J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0003R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00058\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u00060\rR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lki1/a;", "", "", "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "list", "", "inboxType", "", "guildId", "d", "uiData", "Lcom/tencent/mobileqq/guild/api/LaunchGuildChatPieParam;", "a", "Lki1/a$a;", "b", "", h.F, "dataList", "e", "", "f", "Ljava/lang/String;", "TAG", "I", "c", "()I", "INBOX_SELECT_NONE", "Lki1/a$a;", "mSelItem", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "g", "(Landroid/content/Context;)V", "context", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "Guild.C2C.GuildInboxSelectHelper";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int INBOX_SELECT_NONE = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C10661a mSelItem = new C10661a(-1, "");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000f\u001a\u0004\b\b\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lki1/a$a;", "", "obj", "", "equals", "", "toString", "", "a", "I", "b", "()I", "d", "(I)V", "selType", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "selKey", "<init>", "(Lki1/a;ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ki1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public final class C10661a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int selType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String selKey;

        public C10661a(int i3, @Nullable String str) {
            a.this.getINBOX_SELECT_NONE();
            this.selType = i3;
            this.selKey = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getSelKey() {
            return this.selKey;
        }

        /* renamed from: b, reason: from getter */
        public final int getSelType() {
            return this.selType;
        }

        public final void c(@Nullable String str) {
            this.selKey = str;
        }

        public final void d(int i3) {
            this.selType = i3;
        }

        public boolean equals(@Nullable Object obj) {
            String str;
            C10661a c10661a;
            String str2;
            if (!(obj instanceof C10661a) || (str = this.selKey) == null || (str2 = (c10661a = (C10661a) obj).selKey) == null || this.selType != c10661a.selType || !Intrinsics.areEqual(str, str2)) {
                return false;
            }
            return true;
        }

        @NotNull
        public String toString() {
            return "SelItem{selType=" + this.selType + ", selKey='" + this.selKey + "'}";
        }
    }

    private final LaunchGuildChatPieParam a(p uiData) {
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        LaunchGuildChatPieParam a16 = new LaunchGuildChatPieParam().l(uiData.f226296e).b(uiData.f226297f).r(true).o(2).g(5).k(bundle).a();
        Intrinsics.checkNotNullExpressionValue(a16, "LaunchGuildChatPieParam(\u2026ras)\n            .build()");
        return a16;
    }

    private final p d(List<? extends p> list, int inboxType, String guildId) {
        if (inboxType == this.INBOX_SELECT_NONE) {
            return null;
        }
        for (p pVar : list) {
            if (inboxType == pVar.f226295d && TextUtils.equals(guildId, pVar.f226296e)) {
                return pVar;
            }
        }
        return null;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final C10661a getMSelItem() {
        return this.mSelItem;
    }

    /* renamed from: c, reason: from getter */
    public final int getINBOX_SELECT_NONE() {
        return this.INBOX_SELECT_NONE;
    }

    public final void e(@NotNull List<? extends p> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        int selType = this.mSelItem.getSelType();
        String selKey = this.mSelItem.getSelKey();
        p d16 = d(dataList, selType, selKey);
        if (d16 == null) {
            QLog.w(this.TAG, 1, "openCenterPanel failed " + selKey + " size:" + dataList.size());
            return;
        }
        f(d16);
    }

    public final boolean f(@NotNull p uiData) {
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        if (this.context == null) {
            QLog.w(this.TAG, 1, "openCenterPanel failed context == null");
            return false;
        }
        if (uiData.f226295d == 1) {
            if (TextUtils.equals(uiData.f226296e, "6")) {
                Context context = this.context;
                Intrinsics.checkNotNull(context);
                GuildNoticeFragment.Mh(context, uiData.F);
            } else if (TextUtils.equals(uiData.f226296e, "7")) {
                GuildAssistantFragment.Companion companion = GuildAssistantFragment.INSTANCE;
                Context context2 = this.context;
                Intrinsics.checkNotNull(context2);
                companion.b(context2);
            } else if (TextUtils.equals(uiData.f226296e, "5")) {
                GuildNoticeIncomeFragment.Companion companion2 = GuildNoticeIncomeFragment.INSTANCE;
                Context context3 = this.context;
                Intrinsics.checkNotNull(context3);
                companion2.b(context3);
            }
        } else {
            LaunchGuildChatPieParam a16 = a(uiData);
            ILaunchGuildChatPieApi iLaunchGuildChatPieApi = (ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class);
            Context context4 = this.context;
            Intrinsics.checkNotNull(context4);
            iLaunchGuildChatPieApi.launchGuildDirectMessageAio(context4, a16);
        }
        return true;
    }

    public final void g(@Nullable Context context) {
        this.context = context;
    }

    public final void h(int inboxType, @Nullable String guildId) {
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 1, "setCurSelectInboxItem from " + this.mSelItem);
        }
        this.mSelItem.d(inboxType);
        this.mSelItem.c(guildId);
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 1, "setCurSelectInboxItem to " + this.mSelItem);
        }
    }
}
