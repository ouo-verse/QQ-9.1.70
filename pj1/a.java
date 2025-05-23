package pj1;

import android.content.Context;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.event.GuildFeedMuteStateChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShowBusinessDialogEvent;
import com.tencent.mobileqq.guild.feed.event.GuildSpeakThresholdStateChangeEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.util.GuildFeedCommentUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.qphone.base.util.QLog;
import dl1.d;
import dl1.e;
import dl1.f;
import dl1.g;
import dl1.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sz1.JoinTimeItem;
import tl.h;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0002\u0011\u0004B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u001c\u0010\u001f\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u001e\u00a8\u0006\""}, d2 = {"Lpj1/a;", "", "", "c", "b", "f", "g", "Lnj1/a;", "params", "e", "", "placeHolder", h.F, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "permissionType", "d", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "bottomHintTextView", "Lpj1/a$a;", "Lpj1/a$a;", "callback", "Landroid/util/SparseArray;", "Ldl1/b;", "Landroid/util/SparseArray;", "hintProcessors", "Ljava/lang/String;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "()Landroid/content/Context;", "context", "<init>", "(Landroid/widget/TextView;Lpj1/a$a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final b f426311e = new b(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView bottomHintTextView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceC11021a callback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<dl1.b> hintProcessors;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String placeHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lpj1/a$a;", "", "Lnj1/a;", "params", "", "b", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "c", "()Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "bean", "Lpj1/b;", "a", "()Lpj1/b;", "calculatorCompat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pj1.a$a, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC11021a {
        @NotNull
        pj1.b a();

        void b(@NotNull nj1.a params);

        @NotNull
        GuildFeedDetailInitBean c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lpj1/a$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f426316a;

        static {
            int[] iArr = new int[SpeakPermissionType.values().length];
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_MUTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_JOIN_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_VISITOR_NEED_JOIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_REAL_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_NORMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f426316a = iArr;
        }
    }

    public a(@NotNull TextView bottomHintTextView, @NotNull InterfaceC11021a callback) {
        List<dl1.b> listOf;
        Intrinsics.checkNotNullParameter(bottomHintTextView, "bottomHintTextView");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.bottomHintTextView = bottomHintTextView;
        this.callback = callback;
        SparseArray<dl1.b> sparseArray = new SparseArray<>();
        dl1.b[] bVarArr = new dl1.b[8];
        bVarArr[0] = new dl1.c();
        bVarArr[1] = new g();
        bVarArr[2] = new e();
        bVarArr[3] = new i();
        bVarArr[4] = new dl1.h();
        bVarArr[5] = new d();
        dl1.a aVar = new dl1.a();
        if (callback.c().getBusinessType() == 7) {
            aVar.c(HardCodeUtil.qqStr(R.string.f143790n1));
        }
        Unit unit = Unit.INSTANCE;
        bVarArr[6] = aVar;
        bVarArr[7] = new f();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) bVarArr);
        for (dl1.b bVar : listOf) {
            sparseArray.put(bVar.a(), bVar);
        }
        this.hintProcessors = sparseArray;
        this.placeHolder = "";
    }

    private final Context a() {
        return this.bottomHintTextView.getContext();
    }

    private final void b() {
        String str;
        if (this.callback.c().getBusinessType() == 7) {
            GuildFeedMuteStateChangeEvent muteEvent = this.callback.a().getMuteEvent();
            if (muteEvent != null) {
                str = muteEvent.muteTimeHint;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            n.A(0, str);
            return;
        }
        GuildFeedMuteStateChangeEvent muteEvent2 = this.callback.a().getMuteEvent();
        if (muteEvent2 != null) {
            String string = a().getString(R.string.f144570p5, com.tencent.mobileqq.guild.setting.mute.c.G(Long.valueOf(muteEvent2.globalShutUpExpireTime)));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026it)\n                    )");
            n.A(0, string);
        }
    }

    private final void c() {
        long j3;
        IGuildSpeakableThresholdPermission iGuildSpeakableThresholdPermission;
        Context a16 = a();
        Object[] objArr = new Object[1];
        JoinTimeItem.Companion companion = JoinTimeItem.INSTANCE;
        GuildSpeakThresholdStateChangeEvent speakThresholdEvent = this.callback.a().getSpeakThresholdEvent();
        if (speakThresholdEvent != null && (iGuildSpeakableThresholdPermission = speakThresholdEvent.mSpeakThresholdState) != null) {
            j3 = iGuildSpeakableThresholdPermission.getGuildLimitTime();
        } else {
            j3 = 0;
        }
        objArr[0] = companion.b(j3);
        String string = a16.getString(R.string.f144560p4, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026          )\n            )");
        n.A(0, string);
    }

    private final void f() {
        String str;
        if (this.callback.c().getBusinessType() == 7) {
            GuildFeedMuteStateChangeEvent muteEvent = this.callback.a().getMuteEvent();
            if (muteEvent != null) {
                str = muteEvent.muteTimeHint;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            n.A(0, str);
            return;
        }
        GuildFeedMuteStateChangeEvent muteEvent2 = this.callback.a().getMuteEvent();
        if (muteEvent2 != null) {
            String string = a().getString(R.string.f144600p8, com.tencent.mobileqq.guild.setting.mute.c.G(Long.valueOf(muteEvent2.myShutUpExpireTime)));
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026it)\n                    )");
            n.A(0, string);
        }
    }

    private final void g() {
        n.z(0, R.string.f144500oy);
        GuildFeedDetailInitBean c16 = this.callback.c();
        if (!c16.getJoinInfoParam().isValid()) {
            QLog.e("WebSpeakPermissionFacade", 1, "joinInfoParam is invalid, " + c16.getJoinInfoParam());
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        GuildFeedShowBusinessDialogEvent guildFeedShowBusinessDialogEvent = new GuildFeedShowBusinessDialogEvent();
        guildFeedShowBusinessDialogEvent.setType("joinGuildGuide");
        guildFeedShowBusinessDialogEvent.setJumpGuildParam(new JumpGuildParam(c16.getGuildId(), c16.getChannelId(), c16.getJoinInfoParam().getJoinSignature(), c16.getJoinInfoParam().getMainSource(), c16.getJoinInfoParam().getSubSource()));
        simpleEventBus.dispatchEvent(guildFeedShowBusinessDialogEvent, true);
    }

    public final void d(@NotNull SpeakPermissionType permissionType) {
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        QLog.i("WebSpeakPermissionFacade", 1, "handlePermissionTypeChange placeHolder=" + this.placeHolder);
        dl1.b bVar = this.hintProcessors.get(permissionType.ordinal());
        if (bVar != null) {
            bVar.b(this.bottomHintTextView, this.placeHolder);
        }
    }

    public final void e(@NotNull nj1.a params) {
        IGuildSpeakableThresholdPermission iGuildSpeakableThresholdPermission;
        Intrinsics.checkNotNullParameter(params, "params");
        String str = null;
        switch (c.f426316a[this.callback.a().f().ordinal()]) {
            case 1:
                GuildFeedMuteStateChangeEvent muteEvent = this.callback.a().getMuteEvent();
                if (muteEvent != null) {
                    str = muteEvent.muteTimeHint;
                }
                if (str == null) {
                    str = "";
                }
                n.A(0, str);
                return;
            case 2:
                c();
                return;
            case 3:
                g();
                return;
            case 4:
                GuildFeedCommentUtil guildFeedCommentUtil = GuildFeedCommentUtil.f223766a;
                Context context = a();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                GuildSpeakThresholdStateChangeEvent speakThresholdEvent = this.callback.a().getSpeakThresholdEvent();
                if (speakThresholdEvent != null && (iGuildSpeakableThresholdPermission = speakThresholdEvent.mSpeakThresholdState) != null) {
                    str = iGuildSpeakableThresholdPermission.getVerifyUrl();
                }
                guildFeedCommentUtil.q(context, str);
                return;
            case 5:
                this.callback.b(params);
                return;
            case 6:
                f();
                return;
            case 7:
                b();
                return;
            default:
                return;
        }
    }

    public final void h(@NotNull String placeHolder) {
        Intrinsics.checkNotNullParameter(placeHolder, "placeHolder");
        QLog.i("WebSpeakPermissionFacade", 1, "setConfigPlaceHolder placeHolder=" + placeHolder);
        this.placeHolder = placeHolder;
    }
}
