package com.tencent.qqnt.notification.struct;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010*\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b\u001e\u0010'\"\u0004\b(\u0010)R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\r\u001a\u0004\b\u0005\u0010\u000f\"\u0004\b,\u0010\u0011R$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\r\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R+\u00107\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00178F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\"\u0010=\u001a\u0002088\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b \u00109\u001a\u0004\b.\u0010:\"\u0004\b;\u0010<R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b5\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b>\u0010\u0011R+\u0010A\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001d8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b/\u00104\u001a\u0004\b+\u0010!\"\u0004\b@\u0010#R$\u0010C\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u00109\u001a\u0004\b3\u0010:\"\u0004\bB\u0010<\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/notification/struct/d;", "", "", "toString", "Landroid/content/Intent;", "a", "Landroid/content/Intent;", "f", "()Landroid/content/Intent;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/content/Intent;)V", "intent", "b", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;)V", "title", "c", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "content", "", "I", "()I", "p", "(I)V", "chatType", "", "e", "Z", "j", "()Z", "w", "(Z)V", "showPreview", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "r", "(Landroid/graphics/Bitmap;)V", "icon", "g", DomainData.DOMAIN_NAME, "brief", h.F, "l", "y", RemoteMessageConst.Notification.TICKER, "<set-?>", "i", "Lkotlin/properties/ReadWriteProperty;", "k", HippyTKDListViewAdapter.X, "smallIcon", "Landroid/app/PendingIntent;", "Landroid/app/PendingIntent;", "()Landroid/app/PendingIntent;", "u", "(Landroid/app/PendingIntent;)V", "pendingIntent", "o", "channelId", "t", "ongoing", "v", "replyPendingIntent", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: o, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f359888o;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent intent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int chatType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean showPreview;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap icon;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String brief;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String ticker;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty smallIcon;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public PendingIntent pendingIntent;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public String channelId;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty ongoing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PendingIntent replyPendingIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/notification/struct/d$a;", "", "", "info", "a", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.struct.d$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        public final String a(@NotNull String info) {
            char first;
            char last;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            if (info.length() > 2) {
                first = StringsKt___StringsKt.first(info);
                last = StringsKt___StringsKt.last(info);
                return first + MiniBoxNoticeInfo.APPNAME_SUFFIX + last + "|" + info.length();
            }
            return info;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45550);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            f359888o = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "smallIcon", "getSmallIcon()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(d.class, "ongoing", "getOngoing()Z", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.title = "";
        this.content = "";
        this.brief = "";
        Delegates delegates = Delegates.INSTANCE;
        this.smallIcon = delegates.notNull();
        this.ongoing = delegates.notNull();
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.brief;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        String str = this.channelId;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("channelId");
        return null;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.chatType;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.content;
    }

    @Nullable
    public final Bitmap e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.icon;
    }

    @Nullable
    public final Intent f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.intent;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return ((Boolean) this.ongoing.getValue(this, f359888o[1])).booleanValue();
    }

    @NotNull
    public final PendingIntent h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        PendingIntent pendingIntent = this.pendingIntent;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pendingIntent");
        return null;
    }

    @Nullable
    public final PendingIntent i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (PendingIntent) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.replyPendingIntent;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.showPreview;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return ((Number) this.smallIcon.getValue(this, f359888o[0])).intValue();
    }

    @Nullable
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.ticker;
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.title;
    }

    public final void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.brief = str;
        }
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.channelId = str;
        }
    }

    public final void p(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.chatType = i3;
        }
    }

    public final void q(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }
    }

    public final void r(@Nullable Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bitmap);
        } else {
            this.icon = bitmap;
        }
    }

    public final void s(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            this.intent = intent;
        }
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.ongoing.setValue(this, f359888o[1], Boolean.valueOf(z16));
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        Intent intent = this.intent;
        if (intent != null) {
            Intrinsics.checkNotNull(intent);
            intent.getExtras();
        }
        Bitmap bitmap = this.icon;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            String.valueOf(bitmap.getHeight());
        }
        try {
            Companion companion = INSTANCE;
            return "NotificationElement{ title=" + companion.a(this.title) + ", content=" + companion.a(this.content) + ", brief=" + companion.a(this.brief) + " }";
        } catch (Exception unused) {
            return "exception";
        }
    }

    public final void u(@NotNull PendingIntent pendingIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) pendingIntent);
        } else {
            Intrinsics.checkNotNullParameter(pendingIntent, "<set-?>");
            this.pendingIntent = pendingIntent;
        }
    }

    public final void v(@Nullable PendingIntent pendingIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) pendingIntent);
        } else {
            this.replyPendingIntent = pendingIntent;
        }
    }

    public final void w(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, z16);
        } else {
            this.showPreview = z16;
        }
    }

    public final void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.smallIcon.setValue(this, f359888o[0], Integer.valueOf(i3));
        }
    }

    public final void y(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        } else {
            this.ticker = str;
        }
    }

    public final void z(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }
    }
}
