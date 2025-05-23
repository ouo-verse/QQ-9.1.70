package com.tencent.qqnt.chathistory.ui.media.data.model;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.chathistory.ui.base.item.b;
import com.tencent.qqnt.chathistory.util.PicSize;
import com.tencent.qqnt.chathistory.util.a;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.util.string.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\b\u0018\u0000 \u00122\u00020\u00012\u00020\u00022\u00020\u0003:\u00016B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b;\u0010<J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010$\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R'\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b\u001c\u00104R\u0014\u00107\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u0010\u001fR\u0014\u00108\u001a\u00020\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u0010\u001fR\u0011\u0010:\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b9\u0010\u001f\u00a8\u0006="}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel;", "Lcom/tencent/qqnt/chathistory/ui/base/item/b;", "", "Lcom/tencent/qqnt/chathistory/ui/base/i;", "", "r", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "toString", "", "hashCode", "other", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "k", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "g", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "", "f", "J", h.F, "()J", "elementId", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", QQBrowserActivity.KEY_MSG_TYPE, "Z", "i", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "expire", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", "t", "(Ljava/lang/String;)V", "thumbPath", "Lkotlin/Pair;", "j", "Lkotlin/Lazy;", "()Lkotlin/Pair;", "downLoadReq", "a", "msgTime", "msgId", "l", "msgSeq", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class SearchMediaItemModel extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgElement element;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final long elementId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int msgType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean expire;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String thumbPath;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy downLoadReq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/media/data/model/SearchMediaItemModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48208);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SearchMediaItemModel(@NotNull MsgRecord msgRecord, @NotNull MsgElement element) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(element, "element");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord, (Object) element);
            return;
        }
        this.msgRecord = msgRecord;
        this.element = element;
        this.elementId = element.elementId;
        this.msgType = msgRecord.msgType;
        this.expire = a.k(element);
        this.thumbPath = a.i(element, PicSize.PIC_DOWNLOAD_THUMB);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Pair<? extends Integer, ? extends Integer>>() { // from class: com.tencent.qqnt.chathistory.ui.media.data.model.SearchMediaItemModel$downLoadReq$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchMediaItemModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Pair<? extends Integer, ? extends Integer> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? a.f(SearchMediaItemModel.this.g(), PicSize.PIC_DOWNLOAD_THUMB) : (Pair) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.downLoadReq = lazy;
    }

    @Override // com.tencent.qqnt.chathistory.ui.base.i
    /* renamed from: a */
    public long getMsgTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.msgRecord.msgTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchMediaItemModel)) {
            return false;
        }
        SearchMediaItemModel searchMediaItemModel = (SearchMediaItemModel) other;
        if (Intrinsics.areEqual(this.msgRecord, searchMediaItemModel.msgRecord) && Intrinsics.areEqual(this.element, searchMediaItemModel.element)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Pair<Integer, Integer> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Pair) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return (Pair) this.downLoadReq.getValue();
    }

    @NotNull
    public final MsgElement g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgElement) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.element;
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.elementId;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return (this.msgRecord.hashCode() * 31) + this.element.hashCode();
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.expire;
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.msgRecord.msgId;
    }

    @NotNull
    public final MsgRecord k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.msgRecord;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.msgRecord.msgSeq;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.msgType;
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.thumbPath;
    }

    @Nullable
    public final String o() {
        VideoElement videoElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        if (p() || (videoElement = this.element.videoElement) == null) {
            return null;
        }
        return c.f362990a.a(videoElement.fileTime);
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        MsgRecord msgRecord = this.msgRecord;
        int i3 = msgRecord.msgType;
        if (i3 == 2 && this.element.elementType == 2) {
            return true;
        }
        if (i3 == 3) {
            MsgElement i16 = MsgExtKt.i(msgRecord, 3);
            Intrinsics.checkNotNull(i16);
            FileElement fileElement = i16.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "msgRecord.getFirstTypeEl\u2026EMTYPEFILE)!!.fileElement");
            if (com.tencent.qqnt.aio.element.file.util.a.d(fileElement) == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        MsgRecord msgRecord = this.msgRecord;
        int i3 = msgRecord.msgType;
        if (i3 == 7 && this.element.elementType == 5) {
            return true;
        }
        if (i3 == 3) {
            MsgElement i16 = MsgExtKt.i(msgRecord, 3);
            Intrinsics.checkNotNull(i16);
            FileElement fileElement = i16.fileElement;
            Intrinsics.checkNotNullExpressionValue(fileElement, "msgRecord.getFirstTypeEl\u2026EMTYPEFILE)!!.fileElement");
            if (com.tencent.qqnt.aio.element.file.util.a.d(fileElement) == 2) {
                return true;
            }
            return false;
        }
        return false;
    }

    @NotNull
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return a.i(this.element, PicSize.PIC_DOWNLOAD_ORI);
    }

    public final void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.expire = z16;
        }
    }

    public final void t(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.thumbPath = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "SearchMediaItemModel(msgRecord=" + this.msgRecord + ", element=" + this.element + ")";
    }
}
