package com.tencent.mobileqq.aio.msglist.holder.component.markdown.flashtransfer;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.flashtransfer.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.q;
import com.tencent.qqnt.kernel.nativeinterface.FileSetDownloadStatus;
import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileSetSimpleStatus;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElementExtFlashTransferInfo;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElementExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.SimpleFileSetStatusInfo;
import com.tencent.util.UiThreadUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0002\u001f\u001eB\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010&R\u0014\u0010*\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010)\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/flashtransfer/b;", "Lcom/tencent/qqnt/aio/markdown/a;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SimpleFileSetStatusInfo;", "Lkotlin/collections/ArrayList;", "infos", "", "k", "Lcom/tencent/qqnt/kernel/api/q;", "f", "status", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/markdown/d;", "i", "", "e", "", "leftTime", "d", "Lorg/json/JSONObject;", "content", "j", h.F, "size", "g", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/qqnt/aio/markdown/c;", "listener", "", "b", "a", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/flashtransfer/b$b;", "Ljava/util/List;", "listeners", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "fileSetListener", "c", "Ljava/lang/String;", "peerUid", WadlProxyConsts.SCENE_ID, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(Lcom/tencent/aio/api/runtime/a;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b implements com.tencent.qqnt.aio.markdown.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<C7304b> listeners;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IFlashTransferFileSetStatusListener fileSetListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerUid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sceneId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/flashtransfer/b$a;", "", "", "CLICK_SCHEMA", "Ljava/lang/String;", "SCENE_ID_AIO", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.flashtransfer.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/flashtransfer/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "c", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "msgItem", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "fileSetId", "Lcom/tencent/qqnt/aio/markdown/c;", "Lcom/tencent/qqnt/aio/markdown/c;", "()Lcom/tencent/qqnt/aio/markdown/c;", "listener", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;Ljava/lang/String;Lcom/tencent/qqnt/aio/markdown/c;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.flashtransfer.b$b, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final /* data */ class C7304b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarkdownMsgItem msgItem;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String fileSetId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.qqnt.aio.markdown.c listener;

        public C7304b(@NotNull MarkdownMsgItem msgItem, @NotNull String fileSetId, @NotNull com.tencent.qqnt.aio.markdown.c listener) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            Intrinsics.checkNotNullParameter(fileSetId, "fileSetId");
            Intrinsics.checkNotNullParameter(listener, "listener");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, msgItem, fileSetId, listener);
                return;
            }
            this.msgItem = msgItem;
            this.fileSetId = fileSetId;
            this.listener = listener;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.fileSetId;
        }

        @NotNull
        public final com.tencent.qqnt.aio.markdown.c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.aio.markdown.c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.listener;
        }

        @NotNull
        public final MarkdownMsgItem c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MarkdownMsgItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.msgItem;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C7304b)) {
                return false;
            }
            C7304b c7304b = (C7304b) other;
            if (Intrinsics.areEqual(this.msgItem, c7304b.msgItem) && Intrinsics.areEqual(this.fileSetId, c7304b.fileSetId) && Intrinsics.areEqual(this.listener, c7304b.listener)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.msgItem.hashCode() * 31) + this.fileSetId.hashCode()) * 31) + this.listener.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "Listener(msgItem=" + this.msgItem + ", fileSetId=" + this.fileSetId + ", listener=" + this.listener + ")";
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f191039a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61376);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[FileSetSimpleStatus.values().length];
            try {
                iArr[FileSetSimpleStatus.KDOWNLOADFINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileSetSimpleStatus.KUPLOADFINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileSetSimpleStatus.KREMOTEUPLOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileSetSimpleStatus.KUPLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FileSetSimpleStatus.KDOWNLOADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FileSetSimpleStatus.KDELETED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FileSetSimpleStatus.KEXPIRED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FileSetSimpleStatus.KDOWNLOADPAUSED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[FileSetSimpleStatus.KUPLOADPAUSED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[FileSetSimpleStatus.KDOWNLOADFAILED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[FileSetSimpleStatus.KDOWNLOADCANCELED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[FileSetSimpleStatus.KUPLOADFAILED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[FileSetSimpleStatus.KUPLOADCANCELED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[FileSetSimpleStatus.KCANCELLED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[FileSetSimpleStatus.KHIT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            f191039a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/flashtransfer/b$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/SimpleFileSetStatusInfo;", "Lkotlin/collections/ArrayList;", "infos", "", "onFileSetStatusUpdate", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements IFlashTransferFileSetStatusListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(b this$0, ArrayList infos) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(infos, "$infos");
            this$0.k(infos);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetStatusListener
        public void onFileSetStatusUpdate(@NotNull final ArrayList<SimpleFileSetStatusInfo> infos) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) infos);
                return;
            }
            Intrinsics.checkNotNullParameter(infos, "infos");
            final b bVar = b.this;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.flashtransfer.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.d.b(b.this, infos);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61379);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext);
            return;
        }
        this.listeners = new ArrayList();
        String j3 = aioContext.g().r().c().j();
        this.peerUid = j3;
        this.sceneId = "aio_" + j3 + "_" + aioContext.hashCode();
    }

    private final String d(long leftTime) {
        if (leftTime <= 0) {
            return "\u5df2\u8fc7\u671f";
        }
        long j3 = 86400;
        if (leftTime >= j3) {
            return (((leftTime + j3) - 1) / j3) + "\u5929\u540e\u8fc7\u671f";
        }
        long j16 = 3600;
        if (leftTime >= j16) {
            return (((leftTime + j16) - 1) / j16) + "\u5c0f\u65f6\u540e\u8fc7\u671f";
        }
        return ((leftTime + 59) / 60) + "\u5206\u949f\u540e\u8fc7\u671f";
    }

    private final String e(SimpleFileSetStatusInfo status, MarkdownMsgItem msgItem) {
        FileSetSimpleInfo fileSetSimpleInfo = status.fileSetSimpleInfo;
        long j3 = fileSetSimpleInfo.totalFileCount;
        long j16 = fileSetSimpleInfo.totalFileSize;
        FileSetSimpleStatus fileSetSimpleStatus = status.status;
        FileSetSimpleStatus fileSetSimpleStatus2 = FileSetSimpleStatus.KDOWNLOADPAUSED;
        if (fileSetSimpleStatus == fileSetSimpleStatus2 || fileSetSimpleStatus == FileSetSimpleStatus.KDOWNLOADFAILED || fileSetSimpleStatus == FileSetSimpleStatus.KDOWNLOADCANCELED) {
            long j17 = status.totalTaskFileSize;
            if (j17 != 0) {
                j16 = j17;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        String g16 = g(j16);
        int i3 = status.fileSetSimpleInfo.expireLeftTime;
        FileSetSimpleStatus fileSetSimpleStatus3 = status.status;
        if (fileSetSimpleStatus3 != FileSetSimpleStatus.KEXPIRED && i3 > 0) {
            if (fileSetSimpleStatus3 == fileSetSimpleStatus2) {
                sb5.append("\u5df2\u6682\u505c  " + d(i3));
            } else if (fileSetSimpleStatus3 != FileSetSimpleStatus.KCANCELLED && fileSetSimpleStatus3 != FileSetSimpleStatus.KHIT) {
                sb5.append(g16);
                sb5.append("  " + d(i3));
            } else {
                sb5.append("\u5df2\u5220\u9664");
            }
        } else {
            sb5.append(g16);
            sb5.append("  \u5df2\u8fc7\u671f");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "builder.toString()");
        return sb6;
    }

    private final q f() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IK\u2026ava, ProcessConstant.ALL)");
        return ((IKernelService) runtimeService).getFlashTransferService();
    }

    private final String g(long size) {
        if (size < 1024) {
            return size + "B";
        }
        float f16 = ((float) size) / 1024.0f;
        if (f16 < 1024.0f) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1fKB", Arrays.copyOf(new Object[]{Float.valueOf(f16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        float f17 = f16 / 1024.0f;
        if (f17 < 1024.0f) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.1fMB", Arrays.copyOf(new Object[]{Float.valueOf(f17)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%.1fGB", Arrays.copyOf(new Object[]{Float.valueOf(f17 / 1024.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        return format3;
    }

    private final String h(SimpleFileSetStatusInfo status) {
        int roundToInt;
        int roundToInt2;
        long j3 = status.timeRemain;
        if (j3 >= 3600) {
            roundToInt2 = MathKt__MathJVMKt.roundToInt(((float) j3) / 3600.0f);
            return roundToInt2 + "\u5c0f\u65f6";
        }
        if (j3 >= 60) {
            roundToInt = MathKt__MathJVMKt.roundToInt(((float) j3) / 60.0f);
            return roundToInt + "\u5206\u949f";
        }
        return j3 + "\u79d2";
    }

    private final com.tencent.qqnt.aio.markdown.d i(SimpleFileSetStatusInfo status, MarkdownMsgItem msgItem) {
        String str;
        float f16;
        float f17;
        int i3;
        String str2;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jSONObject.put("viewId", "desc");
        jSONObject2.put("viewId", "progressRight");
        jSONObject3.put("viewId", "progressLeft");
        long j3 = status.totalTaskFileSize;
        if (j3 == 0) {
            j3 = status.fileSetSimpleInfo.totalFileSize;
        }
        if (j3 == 0) {
            str = "viewId";
            f16 = 0.0f;
        } else {
            f16 = ((float) status.completedFileSize) / ((float) j3);
            str = "viewId";
        }
        long j16 = status.totalTaskFileCount;
        if (j16 == 0) {
            j16 = status.fileSetSimpleInfo.totalFileCount;
        }
        float f18 = f16;
        String str3 = str;
        if (status.completedFileSize == 0 && j16 != 0) {
            f17 = ((float) status.completedFileCount) / ((float) j16);
        } else {
            f17 = f18;
        }
        jSONObject2.put("progress", Float.valueOf(f17));
        String format = String.format("mqqrouter://flash_transfer/aio_bubble_action?fileset_id=%s&status=%d&version=1&channel_id=1&src_type=internal", Arrays.copyOf(new Object[]{status.fileSetSimpleInfo.fileSetId, Integer.valueOf(status.status.ordinal())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        jSONObject2.put(QZoneDTLoginReporter.SCHEMA, format);
        jSONObject3.put("progress", Float.valueOf(f17));
        String format2 = String.format("mqqrouter://flash_transfer/aio_bubble_action?fileset_id=%s&status=%d&version=1&channel_id=1&src_type=internal", Arrays.copyOf(new Object[]{status.fileSetSimpleInfo.fileSetId, Integer.valueOf(status.status.ordinal())}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        jSONObject3.put(QZoneDTLoginReporter.SCHEMA, format2);
        jSONObject.put("textColor", "text_secondary");
        FileSetSimpleStatus fileSetSimpleStatus = status.status;
        if (fileSetSimpleStatus == null) {
            i3 = -1;
        } else {
            i3 = c.f191039a[fileSetSimpleStatus.ordinal()];
        }
        long j17 = j3;
        switch (i3) {
            case 1:
                if (status.completedFileCount == status.fileSetSimpleInfo.totalFileCount && status.downloadStatus != FileSetDownloadStatus.KPARTIALDOWNLOADFINISHED) {
                    jSONObject2.put("state", "normal");
                    jSONObject3.put("state", "normal");
                    if (status.completedFileCount == 1) {
                        jSONObject.put("text", g(status.completedFileSize) + "  \u5df2\u4e0b\u8f7d");
                        break;
                    } else {
                        jSONObject.put("text", "\u5168\u90e8\u6587\u4ef6\u5df2\u4e0b\u8f7d  " + d(status.fileSetSimpleInfo.expireLeftTime));
                        break;
                    }
                } else {
                    jSONObject2.put("progress", Float.valueOf(0.0f));
                    jSONObject2.put("state", "download");
                    jSONObject3.put("progress", Float.valueOf(0.0f));
                    jSONObject3.put("state", "download");
                    jSONObject.put("text", "\u90e8\u5206\u6587\u4ef6\u5df2\u4e0b\u8f7d  " + d(status.fileSetSimpleInfo.expireLeftTime));
                    break;
                }
                break;
            case 2:
                FileSetSimpleInfo fileSetSimpleInfo = status.fileSetSimpleInfo;
                if (fileSetSimpleInfo.expireLeftTime <= 0) {
                    jSONObject2.put("state", "gray");
                    jSONObject3.put("state", "gray");
                } else if (fileSetSimpleInfo.isLocalCreate) {
                    jSONObject2.put("state", "normal");
                    jSONObject3.put("state", "normal");
                } else {
                    jSONObject2.put("progress", Float.valueOf(0.0f));
                    jSONObject2.put("state", "download");
                    jSONObject3.put("progress", Float.valueOf(0.0f));
                    jSONObject3.put("state", "download");
                }
                jSONObject.put("text", e(status, msgItem));
                break;
            case 3:
                jSONObject2.put("state", "none");
                jSONObject3.put("state", "none");
                jSONObject.put("text", "\u6587\u4ef6\u4e0a\u4f20\u4e2d");
                break;
            case 4:
                jSONObject2.put("state", JobDbManager.TBL_UPLOAD);
                jSONObject3.put("state", JobDbManager.TBL_UPLOAD);
                jSONObject.put("text", g(status.completedFileSize) + "/" + g(j17) + "  \u9884\u8ba1" + h(status));
                break;
            case 5:
                jSONObject2.put("state", "pause");
                jSONObject3.put("state", "pause");
                if (((float) status.timeRemain) / 3600.0f >= 99.0f) {
                    str2 = "\u4e0b\u8f7d\u51c6\u5907\u4e2d";
                } else {
                    str2 = "\u9884\u8ba1" + h(status);
                }
                jSONObject.put("text", g(status.completedFileSize) + "/" + g(j17) + "  " + str2 + " ");
                break;
            case 6:
                jSONObject2.put("state", "gray");
                jSONObject3.put("state", "gray");
                jSONObject.put("text", "\u5171\u4eab\u8005\u5df2\u5220\u9664\u6587\u4ef6");
                break;
            case 7:
                jSONObject2.put("state", "gray");
                jSONObject3.put("state", "gray");
                jSONObject.put("text", e(status, msgItem));
                break;
            case 8:
                jSONObject2.put("state", "download");
                jSONObject3.put("state", "download");
                jSONObject.put("text", e(status, msgItem));
                break;
            case 9:
                jSONObject2.put("state", JobDbManager.TBL_UPLOAD);
                jSONObject3.put("state", JobDbManager.TBL_UPLOAD);
                jSONObject.put("text", "\u4e0a\u4f20\u4e2d" + ((int) (f17 * 100)) + "%  \u5df2\u6682\u505c");
                break;
            case 10:
            case 11:
                jSONObject2.put("state", "download");
                jSONObject3.put("state", "download");
                j(status, jSONObject, msgItem);
                break;
            case 12:
            case 13:
                if (status.fileSetSimpleInfo.isLocalCreate) {
                    jSONObject2.put("state", JobDbManager.TBL_UPLOAD);
                    jSONObject3.put("state", JobDbManager.TBL_UPLOAD);
                } else {
                    jSONObject2.put("state", "normal");
                    jSONObject3.put("state", "normal");
                }
                j(status, jSONObject, msgItem);
                break;
            case 14:
                jSONObject2.put("state", "none");
                jSONObject3.put("state", "none");
                if (status.downloadStatus == FileSetDownloadStatus.KPARTIALDOWNLOADFINISHED) {
                    jSONObject.put("text", "\u90e8\u5206\u6587\u4ef6\u5df2\u4e0b\u8f7d  " + d(status.fileSetSimpleInfo.expireLeftTime));
                    break;
                } else {
                    jSONObject.put("text", e(status, msgItem));
                    break;
                }
            case 15:
                jSONObject2.put("state", "none");
                jSONObject3.put("state", "none");
                jSONObject4.put(str3, "image");
                jSONObject4.put("src", "https://static-res.qq.com/static-res/aio/flash_transfer/file_banned.png");
                jSONObject.put("text", e(status, msgItem));
                break;
            default:
                jSONObject2.put("state", "normal");
                jSONObject3.put("state", "normal");
                jSONObject.put("text", e(status, msgItem));
                break;
        }
        jSONArray.mo162put(jSONObject);
        jSONArray.mo162put(jSONObject2);
        jSONArray.mo162put(jSONObject3);
        jSONArray.mo162put(jSONObject4);
        return new com.tencent.qqnt.aio.markdown.d(jSONArray);
    }

    private final void j(SimpleFileSetStatusInfo status, JSONObject content, MarkdownMsgItem msgItem) {
        String str;
        int i3;
        String str2;
        long j3 = status.failedFileCount;
        if (j3 == 0) {
            content.put("text", e(status, msgItem));
            content.put("textColor", "text_secondary");
            return;
        }
        FileSetSimpleInfo fileSetSimpleInfo = status.fileSetSimpleInfo;
        if (fileSetSimpleInfo.totalFileCount == 1) {
            str = g(fileSetSimpleInfo.totalFileSize) + "  ";
        } else {
            str = j3 + "\u4e2a\u6587\u4ef6";
        }
        FileSetSimpleStatus fileSetSimpleStatus = status.status;
        if (fileSetSimpleStatus == null) {
            i3 = -1;
        } else {
            i3 = c.f191039a[fileSetSimpleStatus.ordinal()];
        }
        switch (i3) {
            case 10:
            case 11:
                str2 = "\u4e0b\u8f7d";
                break;
            case 12:
            case 13:
                str2 = "\u4e0a\u4f20";
                break;
            default:
                str2 = "";
                break;
        }
        content.put("text", str + str2 + "\u5931\u8d25");
        content.put("textColor", "feedback_error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(ArrayList<SimpleFileSetStatusInfo> infos) {
        SimpleFileSetStatusInfo info;
        Iterator<SimpleFileSetStatusInfo> it = infos.iterator();
        while (it.hasNext()) {
            SimpleFileSetStatusInfo next = it.next();
            FileSetSimpleInfo fileSetSimpleInfo = next.fileSetSimpleInfo;
            String str = fileSetSimpleInfo.fileSetId;
            FileSetSimpleStatus fileSetSimpleStatus = next.status;
            FileSetDownloadStatus fileSetDownloadStatus = next.downloadStatus;
            long j3 = fileSetSimpleInfo.totalFileCount;
            long j16 = fileSetSimpleInfo.totalFileSize;
            long j17 = next.completedFileCount;
            long j18 = next.completedFileSize;
            Iterator<SimpleFileSetStatusInfo> it5 = it;
            long j19 = next.failedFileCount;
            long j26 = next.totalTaskFileCount;
            long j27 = next.totalTaskFileSize;
            int i3 = fileSetSimpleInfo.expireLeftTime;
            StringBuilder sb5 = new StringBuilder();
            SimpleFileSetStatusInfo simpleFileSetStatusInfo = next;
            sb5.append("updateFileSetStatus fileSetId=");
            sb5.append(str);
            sb5.append(" status=");
            sb5.append(fileSetSimpleStatus);
            sb5.append(" downloadStatus=");
            sb5.append(fileSetDownloadStatus);
            sb5.append(" tCount=");
            sb5.append(j3);
            sb5.append(" tSize=");
            sb5.append(j16);
            sb5.append(" cCount=");
            sb5.append(j17);
            sb5.append(" cSize=");
            sb5.append(j18);
            sb5.append(" fCount=");
            sb5.append(j19);
            sb5.append(" taskCount=");
            sb5.append(j26);
            sb5.append(" taskSize=");
            sb5.append(j27);
            sb5.append(" leftTime=");
            sb5.append(i3);
            QLog.d("FlashTransferStateProcessor", 1, sb5.toString());
            for (C7304b c7304b : this.listeners) {
                if (Intrinsics.areEqual(c7304b.a(), str)) {
                    QLog.d("FlashTransferStateProcessor", 1, "updateFileSetStatus seq=" + c7304b.c().getMsgSeq() + " msgId=" + c7304b.c().getMsgId());
                    info = simpleFileSetStatusInfo;
                    Intrinsics.checkNotNullExpressionValue(info, "info");
                    c7304b.b().a(i(info, c7304b.c()));
                } else {
                    info = simpleFileSetStatusInfo;
                }
                simpleFileSetStatusInfo = info;
            }
            it = it5;
        }
    }

    @Override // com.tencent.qqnt.aio.markdown.a
    public void a(@NotNull com.tencent.qqnt.aio.markdown.c listener) {
        Object obj;
        ArrayList<String> arrayListOf;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        Iterator<T> it = this.listeners.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((C7304b) obj).b() == listener) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        C7304b c7304b = (C7304b) obj;
        if (c7304b == null) {
            return;
        }
        this.listeners.remove(c7304b);
        q f16 = f();
        if (f16 != null) {
            String str = this.sceneId;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(c7304b.a());
            f16.removeFileSetSimpleStatusMonitoring(str, arrayListOf);
        }
        if (QLog.isColorLevel()) {
            QLog.i("FlashTransferStateProcessor", 2, "[removeListener] msgId:" + c7304b.c().getMsgId() + " seq:" + c7304b.c().getMsgSeq() + " fileSetId:" + c7304b.a() + " listener:" + listener.hashCode());
        }
    }

    @Override // com.tencent.qqnt.aio.markdown.a
    public boolean b(@NotNull AIOMsgItem msgItem, @NotNull com.tencent.qqnt.aio.markdown.c listener) {
        MarkdownElementExtFlashTransferInfo markdownElementExtFlashTransferInfo;
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgItem, (Object) listener)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!(msgItem instanceof MarkdownMsgItem)) {
            return false;
        }
        MarkdownMsgItem markdownMsgItem = (MarkdownMsgItem) msgItem;
        MarkdownElementExtInfo markdownElementExtInfo = markdownMsgItem.r2().mdExtInfo;
        if (markdownElementExtInfo != null) {
            markdownElementExtFlashTransferInfo = markdownElementExtInfo.flashTransferInfo;
        } else {
            markdownElementExtFlashTransferInfo = null;
        }
        if (markdownElementExtFlashTransferInfo == null) {
            QLog.e("FlashTransferStateProcessor", 1, "[addListener] flashInfo is null");
            return false;
        }
        q f16 = f();
        if (f16 == null) {
            QLog.e("FlashTransferStateProcessor", 1, "[addListener] flashTransferService is null");
            return false;
        }
        String fileSetId = markdownElementExtFlashTransferInfo.filesetId;
        if (this.fileSetListener == null) {
            d dVar = new d();
            this.fileSetListener = dVar;
            String str = this.sceneId;
            Intrinsics.checkNotNull(dVar);
            f16.addFileSetSimpleStatusListener(str, dVar);
            QLog.i("FlashTransferStateProcessor", 2, "[addListener] initListener sceneId=" + this.sceneId);
        }
        List<C7304b> list = this.listeners;
        Intrinsics.checkNotNullExpressionValue(fileSetId, "fileSetId");
        list.add(new C7304b(markdownMsgItem, fileSetId, listener));
        String str2 = this.sceneId;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(fileSetId);
        f16.addFileSetSimpleStatusMonitoring(str2, arrayListOf);
        if (QLog.isColorLevel()) {
            QLog.i("FlashTransferStateProcessor", 2, "[addListener] msgId:" + msgItem.getMsgId() + " seq:" + msgItem.getMsgSeq() + " fileSetId:" + fileSetId + " listener:" + listener.hashCode());
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.markdown.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        q f16 = f();
        if (f16 != null) {
            f16.removeFileSetSimpleStatusListener(this.sceneId);
        }
        this.fileSetListener = null;
        this.listeners.clear();
        QLog.d("FlashTransferStateProcessor", 1, "onDestroy sceneId=" + this.sceneId);
    }
}
