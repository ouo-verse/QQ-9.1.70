package com.tencent.mobileqq.qqlive.widget.floatwindow;

import android.content.Intent;
import android.util.Size;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b\n\u0010!R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b\u001a\u0010$R\u0017\u0010&\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u0016\u0010\u001d\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/floatwindow/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "a", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "e", "()Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "Landroid/util/Size;", "b", "Landroid/util/Size;", "f", "()Landroid/util/Size;", QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE, "Landroid/content/Intent;", "c", "Landroid/content/Intent;", "()Landroid/content/Intent;", "intent", "d", "Z", "g", "()Z", "isMute", "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/a;", "Lcom/tencent/mobileqq/qqlive/widget/floatwindow/a;", "()Lcom/tencent/mobileqq/qqlive/widget/floatwindow/a;", "heartBeatReporter", "Ljava/lang/String;", "()Ljava/lang/String;", "playUrl", "needChangePlayer", "<init>", "(Lcom/tencent/mobileqq/qqlive/sail/room/e;Landroid/util/Size;Landroid/content/Intent;ZLcom/tencent/mobileqq/qqlive/widget/floatwindow/a;Ljava/lang/String;Z)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mobileqq.qqlive.sail.room.e room;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Size videoSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Intent intent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isMute;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a heartBeatReporter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String playUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean needChangePlayer;

    public b(@Nullable com.tencent.mobileqq.qqlive.sail.room.e eVar, @NotNull Size videoSize, @NotNull Intent intent, boolean z16, @Nullable a aVar, @Nullable String str, boolean z17) {
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eVar, videoSize, intent, Boolean.valueOf(z16), aVar, str, Boolean.valueOf(z17));
            return;
        }
        this.room = eVar;
        this.videoSize = videoSize;
        this.intent = intent;
        this.isMute = z16;
        this.heartBeatReporter = aVar;
        this.playUrl = str;
        this.needChangePlayer = z17;
    }

    @Nullable
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.heartBeatReporter;
    }

    @NotNull
    public final Intent b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Intent) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.intent;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.needChangePlayer;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.playUrl;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.room.e e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.qqlive.sail.room.e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.room;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.room, bVar.room) && Intrinsics.areEqual(this.videoSize, bVar.videoSize) && Intrinsics.areEqual(this.intent, bVar.intent) && this.isMute == bVar.isMute && Intrinsics.areEqual(this.heartBeatReporter, bVar.heartBeatReporter) && Intrinsics.areEqual(this.playUrl, bVar.playUrl) && this.needChangePlayer == bVar.needChangePlayer) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Size f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Size) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.videoSize;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isMute;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        com.tencent.mobileqq.qqlive.sail.room.e eVar = this.room;
        int i3 = 0;
        if (eVar == null) {
            hashCode = 0;
        } else {
            hashCode = eVar.hashCode();
        }
        int hashCode3 = ((((hashCode * 31) + this.videoSize.hashCode()) * 31) + this.intent.hashCode()) * 31;
        boolean z16 = this.isMute;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode3 + i17) * 31;
        a aVar = this.heartBeatReporter;
        if (aVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = aVar.hashCode();
        }
        int i19 = (i18 + hashCode2) * 31;
        String str = this.playUrl;
        if (str != null) {
            i3 = str.hashCode();
        }
        int i26 = (i19 + i3) * 31;
        boolean z17 = this.needChangePlayer;
        if (!z17) {
            i16 = z17 ? 1 : 0;
        }
        return i26 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return "QQLiveFloatShowParams(room=" + this.room + ", videoSize=" + this.videoSize + ", intent=" + this.intent + ", isMute=" + this.isMute + ", heartBeatReporter=" + this.heartBeatReporter + ", playUrl=" + this.playUrl + ", needChangePlayer=" + this.needChangePlayer + ')';
    }
}
