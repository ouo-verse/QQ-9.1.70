package com.tencent.mobileqq.troop.troopcard.reborn.uimodel;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u0014\u00a2\u0006\u0004\b#\u0010$R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0003\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u001b\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\u001f\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u0017\u0010!\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\"\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/uimodel/h;", "", "", "a", "J", tl.h.F, "()J", "troopUin", "", "b", "I", "getMsgSeq", "()I", "msgSeq", "c", "getRandom", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "d", "g", "sendTimeS", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", WadlProxyConsts.PARAM_FILENAME, "f", "fileSize", "fileThumbnail", "getFileUrl", "fileUrl", "i", "fileOwner", "j", WadlProxyConsts.KEY_JUMP_URL, "id", "<init>", "(JIIILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int msgSeq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int random;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int sendTimeS;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long fileSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileThumbnail;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileOwner;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String jumpUrl;

    public h(long j3, int i3, int i16, int i17, @NotNull String fileName, long j16, @NotNull String fileThumbnail, @NotNull String fileUrl, @NotNull String fileOwner, @NotNull String jumpUrl) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(fileThumbnail, "fileThumbnail");
        Intrinsics.checkNotNullParameter(fileUrl, "fileUrl");
        Intrinsics.checkNotNullParameter(fileOwner, "fileOwner");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), fileName, Long.valueOf(j16), fileThumbnail, fileUrl, fileOwner, jumpUrl);
            return;
        }
        this.troopUin = j3;
        this.msgSeq = i3;
        this.random = i16;
        this.sendTimeS = i17;
        this.fileName = fileName;
        this.fileSize = j16;
        this.fileThumbnail = fileThumbnail;
        this.fileUrl = fileUrl;
        this.fileOwner = fileOwner;
        this.jumpUrl = jumpUrl;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.fileName;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.fileOwner;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.fileSize;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.fileThumbnail;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.troopUin + "_" + this.msgSeq + "_" + this.random;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.jumpUrl;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.sendTimeS;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.troopUin;
    }
}
