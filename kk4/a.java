package kk4;

import android.content.Context;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.profile.data.UserFileds;
import dl4.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rr4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lkk4/a;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static el4.a f412609b;

    /* renamed from: c, reason: collision with root package name */
    private static long f412610c;

    /* renamed from: d, reason: collision with root package name */
    private static long f412611d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private static LiveUserInfo f412612e;

    /* renamed from: f, reason: collision with root package name */
    private static int f412613f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f412614g;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007J<\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007JR\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u0015\u001a\u00020\fH\u0007J\b\u0010\u0016\u001a\u00020\fH\u0007J2\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007R\u0014\u0010\u0019\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001f\u00a8\u0006)"}, d2 = {"Lkk4/a$a;", "", "Landroid/content/Context;", "context", "", "anchorUid", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "liveUserInfo", "", "reportSource", "", "isAcrossRoomAnchor", "", "g", "", RemoteMessageConst.MessageBody.MSG_CONTENT, "e", "Lrr4/e;", "qqGroupInfo", "platform", "f", "a", "b", "roomId", "c", "TAG", "Ljava/lang/String;", "Lel4/a;", "anchorCardInfo", "Lel4/a;", "lastAnchorUid", "J", "lastIsAcrossRoomAnchor", "Z", "lastLiveUserInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "lastReportSource", "I", "lastRoomId", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kk4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"kk4/a$a$a", "Lfl4/a;", "Lel4/a;", "userCardInfo", "", "a", "", "errorCode", "", "errorMsg", "onFailed", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: kk4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C10665a extends fl4.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f412615a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f412616b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f412617c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f412618d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ LiveUserInfo f412619e;

            C10665a(long j3, long j16, int i3, boolean z16, LiveUserInfo liveUserInfo) {
                this.f412615a = j3;
                this.f412616b = j16;
                this.f412617c = i3;
                this.f412618d = z16;
                this.f412619e = liveUserInfo;
            }

            @Override // fl4.a
            public void a(@NotNull el4.a userCardInfo) {
                Intrinsics.checkNotNullParameter(userCardInfo, "userCardInfo");
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("unknown|QQLiveProfileHelper", "showDialog", "getUserCardInfo success, userCardInfo=" + userCardInfo);
                if (userCardInfo.uid == 0) {
                    companion.w("unknown|QQLiveProfileHelper", "showDialog", "getUserCardInfo, invalid user card uid, roomId=" + this.f412615a);
                    return;
                }
                long j3 = this.f412616b;
                userCardInfo.f396561b = j3;
                userCardInfo.f396562c = this.f412617c;
                userCardInfo.f396568i = false;
                userCardInfo.f396571l = this.f412618d;
                if (this.f412619e.uid == j3) {
                    a.f412609b = userCardInfo;
                }
            }

            @Override // com.tencent.mobileqq.qqlive.callback.BaseCallback
            public void onFailed(int errorCode, @Nullable String errorMsg) {
                AegisLogger.INSTANCE.e("unknown|QQLiveProfileHelper", "showDialog", "getUserCardInfo, errorCode=" + errorCode + ",errorMsg=" + errorMsg);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void d(Companion companion, long j3, long j16, LiveUserInfo liveUserInfo, int i3, boolean z16, int i16, Object obj) {
            boolean z17;
            if ((i16 & 16) != 0) {
                z17 = false;
            } else {
                z17 = z16;
            }
            companion.c(j3, j16, liveUserInfo, i3, z17);
        }

        public static /* synthetic */ void h(Companion companion, Context context, long j3, LiveUserInfo liveUserInfo, int i3, String str, boolean z16, int i16, Object obj) {
            boolean z17;
            if ((i16 & 32) != 0) {
                z17 = false;
            } else {
                z17 = z16;
            }
            companion.e(context, j3, liveUserInfo, i3, str, z17);
        }

        public static /* synthetic */ void i(Companion companion, Context context, long j3, LiveUserInfo liveUserInfo, int i3, e eVar, String str, boolean z16, String str2, int i16, Object obj) {
            boolean z17;
            String str3;
            if ((i16 & 64) != 0) {
                z17 = false;
            } else {
                z17 = z16;
            }
            if ((i16 & 128) != 0) {
                str3 = null;
            } else {
                str3 = str2;
            }
            companion.f(context, j3, liveUserInfo, i3, eVar, str, z17, str3);
        }

        public static /* synthetic */ void j(Companion companion, Context context, long j3, LiveUserInfo liveUserInfo, int i3, boolean z16, int i16, Object obj) {
            if ((i16 & 16) != 0) {
                z16 = false;
            }
            companion.g(context, j3, liveUserInfo, i3, z16);
        }

        @JvmStatic
        public final void a() {
            a.f412610c = 0L;
            a.f412611d = 0L;
            a.f412612e = null;
            a.f412613f = 0;
            a.f412614g = false;
        }

        @JvmStatic
        public final void c(long roomId, long anchorUid, @NotNull LiveUserInfo liveUserInfo, int reportSource, boolean isAcrossRoomAnchor) {
            Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
            a.f412610c = roomId;
            a.f412611d = anchorUid;
            a.f412612e = liveUserInfo;
            a.f412613f = reportSource;
            a.f412614g = isAcrossRoomAnchor;
            ArrayList arrayList = new ArrayList();
            arrayList.add(UserFileds.Fileds_Follow);
            arrayList.add(UserFileds.Fileds_FANS_GROUP);
            arrayList.add(UserFileds.Fileds_MEDAL);
            arrayList.add(UserFileds.Fileds_Fans_QQ_Group);
            arrayList.add(UserFileds.Fileds_Suspect_Url);
            arrayList.add(UserFileds.Fileds_Pendant);
            arrayList.add(UserFileds.Fileds_Background);
            b.c(roomId, liveUserInfo.uid, anchorUid, arrayList, new C10665a(roomId, anchorUid, reportSource, isAcrossRoomAnchor, liveUserInfo));
        }

        @JvmStatic
        public final void e(@NotNull Context context, long anchorUid, @NotNull LiveUserInfo liveUserInfo, int reportSource, @Nullable String msgContent, boolean isAcrossRoomAnchor) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
            i(this, context, anchorUid, liveUserInfo, reportSource, null, msgContent, isAcrossRoomAnchor, null, 128, null);
        }

        @JvmStatic
        public final void f(@NotNull Context context, long anchorUid, @NotNull LiveUserInfo liveUserInfo, int reportSource, @Nullable e qqGroupInfo, @Nullable String msgContent, boolean isAcrossRoomAnchor, @Nullable String platform) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
        }

        @JvmStatic
        public final void g(@NotNull Context context, long anchorUid, @NotNull LiveUserInfo liveUserInfo, int reportSource, boolean isAcrossRoomAnchor) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(liveUserInfo, "liveUserInfo");
            i(this, context, anchorUid, liveUserInfo, reportSource, null, null, isAcrossRoomAnchor, null, 128, null);
        }

        Companion() {
        }

        @JvmStatic
        public final void b() {
        }
    }

    @JvmStatic
    public static final void g(@NotNull Context context, long j3, @NotNull LiveUserInfo liveUserInfo, int i3, boolean z16) {
        INSTANCE.g(context, j3, liveUserInfo, i3, z16);
    }
}
