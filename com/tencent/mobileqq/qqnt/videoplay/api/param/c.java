package com.tencent.mobileqq.qqnt.videoplay.api.param;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u001a\u0010 \"\u0004\b!\u0010\"R$\u0010&\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u000f\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\u0006\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b(\u00101\"\u0004\b2\u00103R$\u0010;\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b/\u00108\"\u0004\b9\u0010:R$\u0010B\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b6\u0010?\"\u0004\b@\u0010AR$\u0010H\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010D\u001a\u0004\b=\u0010E\"\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "", "param", "", "k", "", "a", "I", "c", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "mSceneId", "", "b", "Ljava/lang/String;", "getMSceneName", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "mSceneName", "Z", "()Z", "l", "(Z)V", "mIsLocal", "d", "e", "p", "mVideoPath", "", "[Ljava/lang/String;", "()[Ljava/lang/String;", "o", "([Ljava/lang/String;)V", "mUrls", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mVideoSavePath", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/b;", "g", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/b;", "()Lcom/tencent/mobileqq/qqnt/videoplay/api/param/b;", "setControl", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/param/b;)V", "control", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/d;", h.F, "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/d;", "()Lcom/tencent/mobileqq/qqnt/videoplay/api/param/d;", "setProperty", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/param/d;)V", "property", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/e;", "i", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/e;", "()Lcom/tencent/mobileqq/qqnt/videoplay/api/param/e;", "r", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/param/e;)V", "videoDownloadListener", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/f;", "j", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/f;", "()Lcom/tencent/mobileqq/qqnt/videoplay/api/param/f;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/qqnt/videoplay/api/param/f;)V", "videoPlayListener", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/g;", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/g;", "()Lcom/tencent/mobileqq/qqnt/videoplay/api/param/g;", "t", "(Lcom/tencent/mobileqq/qqnt/videoplay/api/param/g;)V", "videoPlaySink", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mSceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mSceneName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLocal;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mVideoPath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String[] mUrls;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mVideoSavePath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b control;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d property;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e videoDownloadListener;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f videoPlayListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g videoPlaySink;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.control = new b();
            this.property = new d();
        }
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (b) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.control;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mIsLocal;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.mSceneId;
    }

    @Nullable
    public final String[] d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mUrls;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mVideoPath;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mVideoSavePath;
    }

    @NotNull
    public final d g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (d) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.property;
    }

    @Nullable
    public final e h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (e) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.videoDownloadListener;
    }

    @Nullable
    public final f i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (f) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.videoPlayListener;
    }

    @Nullable
    public final g j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (g) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.videoPlaySink;
    }

    public final boolean k(@Nullable Object param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, param)).booleanValue();
        }
        if (!(param instanceof c)) {
            return false;
        }
        c cVar = (c) param;
        if (cVar.mIsLocal != this.mIsLocal || cVar.control.b() != this.control.b() || cVar.control.c() != this.control.c()) {
            return false;
        }
        String str = this.mVideoPath;
        if (str != null && Intrinsics.areEqual(cVar.mVideoPath, str)) {
            return true;
        }
        String[] strArr = this.mUrls;
        if (strArr == null || !Arrays.equals(cVar.mUrls, strArr)) {
            return false;
        }
        return true;
    }

    public final void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mIsLocal = z16;
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mSceneId = i3;
        }
    }

    public final void n(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.mSceneName = str;
        }
    }

    public final void o(@Nullable String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) strArr);
        } else {
            this.mUrls = strArr;
        }
    }

    public final void p(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.mVideoPath = str;
        }
    }

    public final void q(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            this.mVideoSavePath = str;
        }
    }

    public final void r(@Nullable e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) eVar);
        } else {
            this.videoDownloadListener = eVar;
        }
    }

    public final void s(@Nullable f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) fVar);
        } else {
            this.videoPlayListener = fVar;
        }
    }

    public final void t(@Nullable g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) gVar);
        } else {
            this.videoPlaySink = gVar;
        }
    }
}
