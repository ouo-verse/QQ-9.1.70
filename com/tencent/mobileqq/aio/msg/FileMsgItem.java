package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.google.gson.Gson;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.FileMsgItem;
import com.tencent.mobileqq.aio.msg.FileMsgItem$picProgressProvider$2;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.at;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.aio.widget.PicProgressView;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 n2\u00020\u0001:\u0003opqB\u001b\b\u0002\u0012\u0006\u0010j\u001a\u00020\u001c\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bk\u0010lB\u0011\b\u0016\u0012\u0006\u0010j\u001a\u00020\u001c\u00a2\u0006\u0004\bk\u0010mJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J&\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J(\u0010\u0017\u001a\u00020\u000b*\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0002J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0001H\u0016J\b\u0010!\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0016J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010%\u001a\u00020$H\u0014J\u0010\u0010)\u001a\u00020(2\u0006\u0010%\u001a\u00020$H\u0016J\u0006\u0010*\u001a\u00020&J\b\u0010+\u001a\u0004\u0018\u00010\u0004J\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0006\u00101\u001a\u000200J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\u0006\u00104\u001a\u00020\u000bJ\u0006\u00105\u001a\u00020\u000bR\u0014\u00108\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010<\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010;R\"\u0010B\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00107\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010F\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u00107\u001a\u0004\bD\u0010?\"\u0004\bE\u0010AR\u0016\u0010I\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR$\u0010M\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bK\u00107\u001a\u0004\bL\u0010?R\"\u0010Q\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u00107\u001a\u0004\bO\u0010?\"\u0004\bP\u0010AR\u001b\u0010V\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u001b\u0010Z\u001a\u00020W8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010S\u001a\u0004\bX\u0010YR$\u0010_\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\\\u0010U\"\u0004\b]\u0010^R$\u0010e\u001a\u00020`2\u0006\u0010[\u001a\u00020`8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0013\u0010i\u001a\u0004\u0018\u00010f8F\u00a2\u0006\u0006\u001a\u0004\bg\u0010h\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FileMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/FileMsgItem$b;", "k2", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElement", "", "x2", "", "r2", "H2", "", "C2", "", "fileElemId", "Lkotlin/Pair;", "o2", "p2", "width", "height", "j2", "Lkotlin/Function0;", "block", "F2", "m2", "Landroid/content/Context;", "context", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "newMsgItem", "l", "getViewType", "viewType", "getSubViewType", "Lcom/tencent/aio/data/msglist/a;", "target", "", "o", "", "getChangePayload", Constants.MMCCID, ICustomDataEditor.NUMBER_PARAM_2, "status", "K2", NowProxyConstants.AccountInfoKey.A2, "u2", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "l2", "toString", "f1", Constants.BASE_IN_PLUGIN_VERSION, "E2", "W0", "I", TagName.FILE_TYPE, "X0", "subViewType", "Lcom/tencent/mobileqq/aio/msg/FileMsgItem$b;", "extInfo", "Z0", "v2", "()I", "setThumbHeight", "(I)V", "thumbHeight", ICustomDataEditor.STRING_ARRAY_PARAM_1, "y2", "setThumbWidth", "thumbWidth", "b1", "Z", "isInitThumbSize", "<set-?>", "c1", "B2", "uiFileStatus", "d1", "z2", "J2", "transferProgress", "e1", "Lkotlin/Lazy;", "t2", "()Ljava/lang/String;", "progressViewKey", "Lcom/tencent/qqnt/aio/widget/PicProgressView$c;", ICustomDataEditor.STRING_PARAM_2, "()Lcom/tencent/qqnt/aio/widget/PicProgressView$c;", "picProgressProvider", "value", "w2", "I2", "(Ljava/lang/String;)V", "thumbPath", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "getFileTransNotifyInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "setFileTransNotifyInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "fileTransNotifyInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "q2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Lcom/tencent/mobileqq/aio/msg/FileMsgItem$b;)V", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "g1", "a", "b", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class FileMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    private final int fileType;

    /* renamed from: X0, reason: from kotlin metadata */
    private final int subViewType;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    private final b extInfo;

    /* renamed from: Z0, reason: from kotlin metadata */
    private int thumbHeight;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private int thumbWidth;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private boolean isInitThumbSize;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private int uiFileStatus;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    private int transferProgress;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy progressViewKey;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy picProgressProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FileMsgItem$a;", "", "", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.FileMsgItem$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        public final List<Integer> a() {
            List<Integer> listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(com.tencent.aio.data.msglist.b.a(9, 1)), Integer.valueOf(com.tencent.aio.data.msglist.b.a(9, 2)), Integer.valueOf(com.tencent.aio.data.msglist.b.a(9, 3)), Integer.valueOf(com.tencent.aio.data.msglist.b.a(96, 1)), Integer.valueOf(com.tencent.aio.data.msglist.b.a(97, 1)), Integer.valueOf(com.tencent.aio.data.msglist.b.a(8, 1)), Integer.valueOf(com.tencent.aio.data.msglist.b.a(8, 2)), Integer.valueOf(com.tencent.aio.data.msglist.b.a(8, 3))});
                return listOf;
            }
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR(\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FileMsgItem$b;", "", "Lcom/tencent/mobileqq/aio/msg/FileMsgItem;", "fileMsgItem", "", "c", "", "f", "", "path", "e", "<set-?>", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "thumbPath", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String thumbPath;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.thumbPath = "";
            }
        }

        private final void c(FileMsgItem fileMsgItem) {
            com.tencent.qqnt.kernel.api.w e16;
            MsgElement q26 = fileMsgItem.q2();
            if (q26 != null && (e16 = com.tencent.qqnt.msg.f.e()) != null) {
                e16.updateElementExtBufForUI(new Contact(fileMsgItem.p0(), fileMsgItem.r0(), ""), fileMsgItem.q0(), q26.elementId, f(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.h
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        FileMsgItem.b.d(i3, str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("FileMsgItem", 1, "update ext info, result=" + i3 + ", msg=" + str);
            }
        }

        private final byte[] f() {
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.thumbPath;
        }

        public final void e(@NotNull FileMsgItem fileMsgItem, @NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) fileMsgItem, (Object) path);
                return;
            }
            Intrinsics.checkNotNullParameter(fileMsgItem, "fileMsgItem");
            Intrinsics.checkNotNullParameter(path, "path");
            this.thumbPath = path;
            c(fileMsgItem);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/FileMsgItem$c;", "", "", TagName.FILE_TYPE, "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    private static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f190031a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57149);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f190031a = new c();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final int a(int fileType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, fileType)).intValue();
            }
            if (fileType != 0) {
                if (fileType == 2) {
                    return 2;
                }
                return 3;
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57159);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    FileMsgItem(final MsgRecord msgRecord, b bVar) {
        super(msgRecord);
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord, (Object) bVar);
            return;
        }
        this.extInfo = bVar == null ? k2() : bVar;
        int r26 = r2();
        this.fileType = r26;
        this.subViewType = c.f190031a.a(r26);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.aio.msg.FileMsgItem$progressViewKey$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgRecord.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                MsgRecord msgRecord2 = MsgRecord.this;
                return msgRecord2.peerUid + "_" + msgRecord2.msgId;
            }
        });
        this.progressViewKey = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FileMsgItem$picProgressProvider$2.a>() { // from class: com.tencent.mobileqq.aio.msg.FileMsgItem$picProgressProvider$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/aio/msg/FileMsgItem$picProgressProvider$2$a", "Lcom/tencent/qqnt/aio/widget/PicProgressView$c;", "", "d", "progress", "", "b", "c", "", "a", "I", "currentProgress", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements PicProgressView.c {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                private int currentProgress;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ FileMsgItem f190033b;

                a(FileMsgItem fileMsgItem) {
                    this.f190033b = fileMsgItem;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) fileMsgItem);
                    }
                }

                @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
                public boolean a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
                    }
                    return true;
                }

                @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
                public void b(int progress) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, progress);
                    } else {
                        this.currentProgress = progress;
                    }
                }

                @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
                public int c() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
                    }
                    return this.f190033b.u2();
                }

                @Override // com.tencent.qqnt.aio.widget.PicProgressView.c
                public int d() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                    }
                    return this.currentProgress;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FileMsgItem.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(FileMsgItem.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.picProgressProvider = lazy2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlin.Pair] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    private final void C2() {
        ?? r26;
        int i3 = this.fileType;
        if (i3 != 2 && i3 != 0) {
            this.isInitThumbSize = true;
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FileElement n26 = n2();
        if (n26 != null) {
            Integer num = n26.picWidth;
            Intrinsics.checkNotNullExpressionValue(num, "it.picWidth");
            if (num.intValue() > 0) {
                Integer num2 = n26.picHeight;
                Intrinsics.checkNotNullExpressionValue(num2, "it.picHeight");
                if (num2.intValue() > 0) {
                    r26 = new Pair(n26.picWidth, n26.picHeight);
                }
            }
            MsgElement q26 = q2();
            Intrinsics.checkNotNull(q26);
            r26 = o2(n26, q26.elementId);
        } else {
            r26 = 0;
        }
        objectRef.element = r26;
        F2(r26, new Function0<Unit>(objectRef, this) { // from class: com.tencent.mobileqq.aio.msg.FileMsgItem$initThumbSize$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<Pair<Integer, Integer>> $sizePair;
            final /* synthetic */ FileMsgItem this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$sizePair = objectRef;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlin.Pair] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ?? p26;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Ref.ObjectRef<Pair<Integer, Integer>> objectRef2 = this.$sizePair;
                p26 = this.this$0.p2();
                objectRef2.element = p26;
            }
        });
        Pair pair = (Pair) objectRef.element;
        if (pair == null) {
            pair = new Pair(0, 0);
        }
        Pair<Integer, Integer> j26 = j2(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        this.thumbWidth = j26.getFirst().intValue();
        this.thumbHeight = j26.getSecond().intValue();
    }

    private final void F2(Pair<Integer, Integer> pair, Function0<Unit> function0) {
        if (pair == null || pair.getFirst().intValue() <= 0 || pair.getSecond().intValue() <= 0) {
            function0.invoke();
        }
    }

    private final int H2() {
        Integer num;
        int i3 = this.uiFileStatus;
        if (i3 != 0) {
            return i3;
        }
        if (getFileTransNotifyInfo().trasferStatus != 0) {
            return getFileTransNotifyInfo().trasferStatus;
        }
        FileElement n26 = n2();
        if (n26 != null) {
            num = n26.transferStatus;
        } else {
            num = null;
        }
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private final Pair<Integer, Integer> j2(int width, int height) {
        if (width > 0 && height > 0) {
            if (this.fileType == 2) {
                this.isInitThumbSize = true;
                com.tencent.mobileqq.aio.msglist.holder.component.video.c cVar = com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a;
                AIOBubbleSkinInfo x06 = x0();
                Intrinsics.checkNotNull(x06);
                com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = x06.b();
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.skin.padding.AIOFileBubbleLayoutInfo");
                return cVar.j(width, height, ((com.tencent.mobileqq.aio.msglist.holder.skin.padding.b) b16).l());
            }
            this.isInitThumbSize = true;
            return PicUtil.f191410a.p(width, height, false, false);
        }
        this.isInitThumbSize = false;
        return m2();
    }

    private final b k2() {
        boolean z16;
        MsgElement q26 = q2();
        if (q26 != null) {
            byte[] bArr = q26.extBufForUI;
            Intrinsics.checkNotNullExpressionValue(bArr, "it.extBufForUI");
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return new b();
            }
            try {
                byte[] bArr2 = q26.extBufForUI;
                Intrinsics.checkNotNullExpressionValue(bArr2, "it.extBufForUI");
                Object fromJson = new Gson().fromJson(new String(bArr2, Charsets.UTF_8), (Class<Object>) b.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(json, ExtInfo::class.java)");
                return (b) fromJson;
            } catch (Exception e16) {
                QLog.i("FileMsgItem", 1, "extInfo fail, exc=" + e16);
                return new b();
            }
        }
        return new b();
    }

    private final Pair<Integer, Integer> m2() {
        int i3 = this.fileType;
        if (i3 != 0) {
            if (i3 != 2) {
                return new Pair<>(Integer.valueOf(com.tencent.mobileqq.aio.utils.p.c(100)), Integer.valueOf(com.tencent.mobileqq.aio.utils.p.c(100)));
            }
            return ((IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class)).getVideoFileDefaultSize();
        }
        return ((IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class)).getPicFileDefaultSize();
    }

    private final Pair<Integer, Integer> o2(FileElement fileElement, long fileElemId) {
        return ((IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class)).fixFileThumbSize(this, fileElement, fileElemId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, Integer> p2() {
        return ((IAIOFileManagerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOFileManagerApi.class)).fixFileThumbSizeFromFile(w2());
    }

    private final int r2() {
        FileElement n26 = n2();
        if (n26 == null) {
            com.tencent.qqnt.aio.utils.q.e("FileMsgItem", "fail to get file type, msgRecord=" + getMsgRecord().msgId);
            return 11;
        }
        return c81.a.j(n26);
    }

    private final String x2(FileElement fileElement) {
        HashMap<Integer, String> hashMap = fileElement.picThumbPath;
        if (hashMap == null || hashMap.isEmpty()) {
            return "";
        }
        Pair pair = new Pair(0, "");
        for (Map.Entry<Integer, String> entry : fileElement.picThumbPath.entrySet()) {
            Integer key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "entry.key");
            if (key.intValue() > ((Number) pair.getFirst()).intValue()) {
                pair = new Pair(entry.getKey(), entry.getValue());
            }
        }
        return (String) pair.getSecond();
    }

    public final int A2() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
        }
        if (H2() == 0 && o81.a.c(this)) {
            FileElement n26 = n2();
            boolean z16 = false;
            if (n26 != null && (num = n26.transferStatus) != null && num.intValue() == 5) {
                z16 = true;
            }
            if (!z16) {
                K2(2);
            }
        }
        return H2();
    }

    public final int B2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.uiFileStatus;
    }

    public final void D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (this.isInitThumbSize) {
            return;
        }
        Pair<Integer, Integer> p26 = p2();
        if (p26 == null) {
            p26 = new Pair<>(0, 0);
        }
        Pair<Integer, Integer> j26 = j2(p26.getFirst().intValue(), p26.getSecond().intValue());
        this.thumbWidth = j26.getFirst().intValue();
        this.thumbHeight = j26.getSecond().intValue();
    }

    public final void E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else {
            if (this.isInitThumbSize) {
                return;
            }
            C2();
        }
    }

    public final boolean G2() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        int A2 = A2();
        if (QLog.isColorLevel()) {
            long j3 = getMsgRecord().msgId;
            int i3 = this.uiFileStatus;
            int i16 = getFileTransNotifyInfo().trasferStatus;
            FileElement n26 = n2();
            if (n26 != null) {
                num = n26.transferStatus;
            } else {
                num = null;
            }
            QLog.i("FileMsgItem", 1, "isTransferring  msgId=" + j3 + ", status=" + A2 + ", uiFileStatus=" + i3 + ", notifyInfo=" + i16 + ", fileElement=" + num);
        }
        if (A2 == 2 || A2 == 3) {
            return true;
        }
        return false;
    }

    public final void I2(@NotNull String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.extInfo.e(this, value);
        FileElement n26 = n2();
        if (n26 != null) {
            HashMap<Integer, String> hashMap = n26.picThumbPath;
            Intrinsics.checkNotNullExpressionValue(hashMap, "it.picThumbPath");
            hashMap.put(750, value);
        }
    }

    public final void J2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.transferProgress = i3;
        }
    }

    public final void K2(int status) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, status);
        } else {
            this.uiFileStatus = status;
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        Y1(com.tencent.mobileqq.aio.utils.n.f194168a.f(context, this));
        this.extInfo.b();
        C2();
        if (QLog.isColorLevel()) {
            QLog.i("FileMsgItem", 2, "onTransform msgId: " + getMsgRecord().msgId + ", thumbWidth:" + this.thumbWidth + ", thumbHeight:" + this.thumbHeight);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 15, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new FileMsgItem(targetMsgRecord, this.extInfo);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (String) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        String str = null;
        if (isSelf()) {
            String qqStr = HardCodeUtil.qqStr(R.string.ypb);
            String qqStr2 = HardCodeUtil.qqStr(R.string.ypd);
            String qqStr3 = HardCodeUtil.qqStr(R.string.f170198yp1);
            FileElement n26 = n2();
            if (n26 != null) {
                str = n26.fileName;
            }
            return qqStr + qqStr2 + qqStr3 + "," + str;
        }
        CharSequence x16 = x();
        String qqStr4 = HardCodeUtil.qqStr(R.string.ypc);
        String qqStr5 = HardCodeUtil.qqStr(R.string.f170198yp1);
        FileElement n27 = n2();
        if (n27 != null) {
            str = n27.fileName;
        }
        return ((Object) x16) + qqStr4 + qqStr5 + "," + str;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @NotNull
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        Integer num;
        Integer num2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return iPatchRedirector.redirect((short) 20, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        int i3 = 0;
        try {
            if (changePayload instanceof Map) {
                hashMap.putAll((Map) changePayload);
            }
        } catch (Exception e16) {
            QLog.e("FileMsgItem", 1, e16, new Object[0]);
            if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                throw e16;
            }
        }
        if (!(target instanceof FileMsgItem)) {
            QLog.i("FileMsgItem", 1, "getChangePayload  target is not FileMsgItem, " + target);
            return hashMap;
        }
        FileMsgItem fileMsgItem = (FileMsgItem) target;
        FileElement n26 = fileMsgItem.n2();
        Integer num3 = null;
        if (n26 != null) {
            num = n26.transferStatus;
        } else {
            num = null;
        }
        FileElement n27 = n2();
        if (n27 != null) {
            num2 = n27.transferStatus;
        } else {
            num2 = null;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            AIOMsgItemPayloadType aIOMsgItemPayloadType = AIOMsgItemPayloadType.FILE_TRANSFER_STATUS_PAYLOAD;
            FileElement n28 = fileMsgItem.n2();
            if (n28 != null) {
                num3 = n28.transferStatus;
            }
            if (num3 != null) {
                i3 = num3.intValue();
            }
            hashMap.put(aIOMsgItemPayloadType, new a.p(i3));
        }
        if (com.tencent.mobileqq.aio.utils.d.w(this) && com.tencent.mobileqq.aio.utils.d.w((AIOMsgItem) target) && this.transferProgress != fileMsgItem.transferProgress) {
            hashMap.put(AIOMsgItemPayloadType.FILE_TRANSFER_PROGRESS_PAYLOAD, a.o.f192668a);
        }
        if (com.tencent.mobileqq.aio.utils.d.w(this) && com.tencent.mobileqq.aio.utils.d.w((AIOMsgItem) target) && this.uiFileStatus != fileMsgItem.uiFileStatus) {
            hashMap.put(AIOMsgItemPayloadType.FILE_TRANSFER_END_PAYLOAD, a.n.f192667a);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public FileTransNotifyInfo getFileTransNotifyInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (FileTransNotifyInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return super.getFileTransNotifyInfo();
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getSubViewType(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, viewType)).intValue();
        }
        return this.subViewType;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        if (getMsgRecord().msgType == 3) {
            if (isSelf()) {
                return 9;
            }
            return 8;
        }
        return super.getViewType();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        if (newMsgItem instanceof FileMsgItem) {
            FileMsgItem fileMsgItem = (FileMsgItem) newMsgItem;
            fileMsgItem.transferProgress = this.transferProgress;
            if (com.tencent.mobileqq.aio.utils.d.w(this) && com.tencent.mobileqq.aio.utils.d.w(newMsgItem)) {
                fileMsgItem.uiFileStatus = this.uiFileStatus;
            }
            fileMsgItem.thumbWidth = this.thumbWidth;
            fileMsgItem.thumbHeight = this.thumbHeight;
            fileMsgItem.isInitThumbSize = this.isInitThumbSize;
        }
    }

    @NotNull
    public final RichMediaElementGetReq l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (RichMediaElementGetReq) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        MsgElement firstTypeElement = getFirstTypeElement(3);
        Intrinsics.checkNotNull(firstTypeElement);
        RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
        richMediaElementGetReq.msgId = q0();
        richMediaElementGetReq.peerUid = r0();
        richMediaElementGetReq.chatType = p0();
        richMediaElementGetReq.elementId = firstTypeElement.elementId;
        richMediaElementGetReq.downloadType = 2;
        richMediaElementGetReq.thumbSize = 750;
        return richMediaElementGetReq;
    }

    @Nullable
    public final FileElement n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (FileElement) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        MsgElement firstTypeElement = getFirstTypeElement(3);
        if (firstTypeElement != null) {
            return firstTypeElement.fileElement;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Pair) iPatchRedirector.redirect((short) 19, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        FileElement n26 = n2();
        Integer num2 = null;
        if (n26 != null) {
            num = n26.transferStatus;
        } else {
            num = null;
        }
        FileMsgItem fileMsgItem = (FileMsgItem) target;
        FileElement n27 = fileMsgItem.n2();
        if (n27 != null) {
            num2 = n27.transferStatus;
        }
        if (!Intrinsics.areEqual(num, num2)) {
            return new Pair<>(Boolean.FALSE, "transferStatus");
        }
        if (com.tencent.mobileqq.aio.utils.d.w(this) && com.tencent.mobileqq.aio.utils.d.w((AIOMsgItem) target) && this.transferProgress != fileMsgItem.transferProgress) {
            return new Pair<>(Boolean.FALSE, "videoFiletransferProgress");
        }
        if (com.tencent.mobileqq.aio.utils.d.w(this) && com.tencent.mobileqq.aio.utils.d.w((AIOMsgItem) target) && this.uiFileStatus != fileMsgItem.uiFileStatus) {
            return new Pair<>(Boolean.FALSE, "videoFileTransferUIState");
        }
        return super.o(target);
    }

    @Nullable
    public final MsgElement q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (MsgElement) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return getFirstTypeElement(3);
    }

    @NotNull
    public final PicProgressView.c s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (PicProgressView.c) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return (PicProgressView.c) this.picProgressProvider.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void setFileTransNotifyInfo(@NotNull FileTransNotifyInfo value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) value);
            return;
        }
        Intrinsics.checkNotNullParameter(value, "value");
        this.uiFileStatus = value.trasferStatus;
        super.setFileTransNotifyInfo(value);
    }

    @NotNull
    public final String t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return (String) this.progressViewKey.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (String) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return FileMsgItem.class.getSimpleName() + ":msgId=" + getMsgRecord().msgId + ",fileType=" + this.fileType + ",fileStatus=" + this.uiFileStatus;
    }

    public final int u2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        MsgElement firstTypeElement = getFirstTypeElement(3);
        if (firstTypeElement == null) {
            return 0;
        }
        return at.f194116a.b(firstTypeElement, 3, getFileTransNotifyInfo());
    }

    public final int v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.thumbHeight;
    }

    @NotNull
    public final String w2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String b16 = this.extInfo.b();
        if (b16 != null) {
            if (b16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return b16;
            }
        }
        FileElement n26 = n2();
        if (n26 != null) {
            return x2(n26);
        }
        return "";
    }

    public final int y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.thumbWidth;
    }

    public final int z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.transferProgress;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileMsgItem(@NotNull MsgRecord msgRecord) {
        this(msgRecord, null);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgRecord);
    }
}
