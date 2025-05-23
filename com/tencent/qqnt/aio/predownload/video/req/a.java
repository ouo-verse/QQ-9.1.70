package com.tencent.qqnt.aio.predownload.video.req;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b@\u0010AJ\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b\u0017\u0010+\"\u0004\b,\u0010-R\"\u00102\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR*\u0010:\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010?\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u0013\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010>\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/aio/predownload/video/req/a;", "", "another", "", "c", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "d", "Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;", "msgItem", "", "e", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "fileUUid", "", "f", "J", "l", "()J", "msgId", h.F, "I", DomainData.DOMAIN_NAME, "()I", "t", "(I)V", "preDownloadPriority", "getPreDownloadOriginalPriority", ReportConstant.COSTREPORT_PREFIX, "preDownloadOriginalPriority", "", "Z", "p", "()Z", "v", "(Z)V", "isSaveReq", "Llv3/a;", BdhLogUtil.LogTag.Tag_Conn, "Llv3/a;", "()Llv3/a;", "setDownListener", "(Llv3/a;)V", "downListener", "D", "o", "u", "preLoadID", "", "E", "[Ljava/lang/String;", "k", "()[Ljava/lang/String;", "r", "([Ljava/lang/String;)V", "mVideoUrls", UserInfo.SEX_FEMALE, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(J)V", "mPos", "<init>", "(Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a implements Comparable<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private lv3.a downListener;

    /* renamed from: D, reason: from kotlin metadata */
    private int preLoadID;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String[] mVideoUrls;

    /* renamed from: F, reason: from kotlin metadata */
    private long mPos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ShortVideoMsgItem msgItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String fileUUid;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long msgId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int preDownloadPriority;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int preDownloadOriginalPriority;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isSaveReq;

    public a(@NotNull ShortVideoMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            return;
        }
        this.msgItem = msgItem;
        this.fileUUid = msgItem.G2();
        this.msgId = msgItem.getMsgId();
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull a another) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) another)).intValue();
        }
        Intrinsics.checkNotNullParameter(another, "another");
        int i3 = this.preDownloadPriority;
        int i16 = another.preDownloadPriority;
        if (i3 < i16) {
            return -1;
        }
        if (i3 > i16) {
            return 1;
        }
        return 0;
    }

    @Nullable
    public final lv3.a h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (lv3.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.downListener;
    }

    @NotNull
    public final String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.fileUUid;
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.mPos;
    }

    @Nullable
    public final String[] k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String[]) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mVideoUrls;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.msgId;
    }

    @NotNull
    public final ShortVideoMsgItem m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ShortVideoMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgItem;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.preDownloadPriority;
    }

    public final int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.preLoadID;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isSaveReq;
    }

    public final void q(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.mPos = j3;
        }
    }

    public final void r(@Nullable String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) strArr);
        } else {
            this.mVideoUrls = strArr;
        }
    }

    public final void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.preDownloadOriginalPriority = i3;
        }
    }

    public final void t(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.preDownloadPriority = i3;
        }
    }

    public final void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.preLoadID = i3;
        }
    }

    public final void v(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.isSaveReq = z16;
        }
    }
}
