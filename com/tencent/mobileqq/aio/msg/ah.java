package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.google.gson.Gson;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IQQShowTofu;
import com.tencent.qqnt.aio.api.IQzoneEMCodeApi;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TofuActionButton;
import com.tencent.qqnt.kernel.nativeinterface.TofuContent;
import com.tencent.qqnt.kernel.nativeinterface.TofuRecordElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002mnB\u000f\u0012\u0006\u0010j\u001a\u00020\u0007\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\r\u001a\u00020\fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000eJ\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eJ\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0013J\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001eJ\u0010\u0010#\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH\u0016J\b\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\nJ\u0006\u0010*\u001a\u00020)J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010+\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010,J\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020\nJ\u001c\u00104\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0013032\u0006\u00102\u001a\u000201H\u0014J\u0012\u00106\u001a\u0004\u0018\u0001052\u0006\u00102\u001a\u000201H\u0016J\u0010\u00108\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u0001H\u0016J\b\u00109\u001a\u00020\u0013H\u0016R\u0014\u0010<\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010;R\u0016\u0010C\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER*\u0010K\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010Gj\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010;R\u0018\u0010N\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010;R*\u0010P\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010Gj\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010JR\u0018\u0010R\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010;R\u001e\u0010U\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010a\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010i\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010h\u00a8\u0006o"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ah;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "z2", "Landroid/content/Context;", "context", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "e2", "", "k2", "", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuActionButton;", "u2", "Lcom/tencent/qqnt/kernel/nativeinterface/TofuContent;", "p2", "", "j2", "background", NowProxyConstants.AccountInfoKey.A2, "getIcon", "o2", "v2", "", ICustomDataEditor.NUMBER_PARAM_2, "m2", "l2", "Lcom/tencent/qqnt/aio/k;", "t2", "onlineStatus", "C2", "viewType", "getSubViewType", "getViewType", "k", FaceUtil.IMG_TEMP, "B2", "w2", "Lcom/tencent/mobileqq/aio/msg/ah$a;", "q2", "info", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", Constants.BASE_IN_PLUGIN_VERSION, "x2", "y2", "Lcom/tencent/aio/data/msglist/a;", "target", "Lkotlin/Pair;", "o", "", "getChangePayload", "newMsgItem", "l", "toString", "W0", "Ljava/lang/String;", "TAG", "X0", "J", "busiid", "busi_uuid", "Z0", "I", "beancurdStyle", ICustomDataEditor.STRING_ARRAY_PARAM_1, "Lcom/tencent/qqnt/kernel/nativeinterface/TofuContent;", "descriptionContent", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b1", "Ljava/util/ArrayList;", "contentList", "c1", "d1", "icon", "e1", SquareJSConst.Params.PARAMS_UIN_LIST, "f1", "busiExtra", "g1", "Ljava/util/List;", "tofuActionButton", "h1", "Z", "exported", "i1", "Lcom/tencent/qqnt/aio/k;", "j1", "Lcom/tencent/mobileqq/aio/msg/ah$a;", "r2", "()Lcom/tencent/mobileqq/aio/msg/ah$a;", "setMExtraInfo", "(Lcom/tencent/mobileqq/aio/msg/ah$a;)V", "mExtraInfo", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "k1", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", ICustomDataEditor.STRING_PARAM_2, "()Lcom/tencent/android/androidbypass/richui/viewdata/k;", "setMixUIViewData", "(Lcom/tencent/android/androidbypass/richui/viewdata/k;)V", "mixUIViewData", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "a", "b", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ah extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: W0, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: X0, reason: from kotlin metadata */
    private long busiid;

    /* renamed from: Y0, reason: from kotlin metadata */
    @Nullable
    private String busi_uuid;

    /* renamed from: Z0, reason: from kotlin metadata */
    private int beancurdStyle;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TofuContent descriptionContent;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<TofuContent> contentList;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String background;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String icon;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<Long> uinList;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String busiExtra;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<TofuActionButton> tofuActionButton;

    /* renamed from: h1, reason: collision with root package name and from kotlin metadata */
    private boolean exported;

    /* renamed from: i1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.k onlineStatus;

    /* renamed from: j1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a mExtraInfo;

    /* renamed from: k1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.android.androidbypass.richui.viewdata.k mixUIViewData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\fB%\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ah$a;", "", "targetInfo", "", "f", "d", "e", "", "j", "", "toString", "", "a", "I", "b", "()I", tl.h.F, "(I)V", "from", "g", "authorityStatus", "c", "Z", "()Z", "i", "(Z)V", "needDelete", "<init>", "(IIZ)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int from;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int authorityStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean needDelete;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ah$a$a;", "", "", "bytes", "Lcom/tencent/mobileqq/aio/msg/ah$a;", "a", "", "AUTHORITY_STATUS_DATA_ERROR", "I", "AUTHORITY_STATUS_FAILED", "AUTHORITY_STATUS_FORBID", "AUTHORITY_STATUS_NETWORK_EXCEPTION", "AUTHORITY_STATUS_PERMIT", "AUTHORITY_STATUS_UNKNOWN", "FROM_DO_REQUEST", "FROM_PUSH", "FROM_PUSH_AND_EXPOSURE", "FROM_SOUGOU", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.msg.ah$a$a, reason: collision with other inner class name and from kotlin metadata */
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
            public final a a(@Nullable byte[] bytes) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bytes);
                }
                if (bytes != null) {
                    if (bytes.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        String str = new String(bytes, Charsets.UTF_8);
                        try {
                            Object fromJson = new Gson().fromJson(str, (Class<Object>) a.class);
                            Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                    Gs\u2026s.java)\n                }");
                            return (a) fromJson;
                        } catch (Exception e16) {
                            QLog.w("PushExtraInfo", 1, "[fromBytes] exception!!! bytes not valid json, e=" + e16 + ", json=" + str);
                            return new a(0, 0, false, 7, null);
                        }
                    }
                }
                QLog.w("PushExtraInfo", 1, "[fromBytes] exception!!! bytes illegal");
                return new a(0, 0, false, 7, null);
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48708);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 16)) {
                redirector.redirect((short) 16);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public a() {
            this(0, 0, false, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return;
            }
            iPatchRedirector.redirect((short) 15, (Object) this);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.authorityStatus;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.from;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.needDelete;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            int i3 = this.from;
            if (i3 != 2 && i3 != 4) {
                return false;
            }
            return true;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            if (this.from == 1) {
                return true;
            }
            return false;
        }

        public final boolean f(@NotNull a targetInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) targetInfo)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(targetInfo, "targetInfo");
            if (this.from == targetInfo.from && this.authorityStatus == targetInfo.authorityStatus && this.needDelete == targetInfo.needDelete) {
                return true;
            }
            return false;
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.authorityStatus = i3;
            }
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.from = i3;
            }
        }

        public final void i(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, z16);
            } else {
                this.needDelete = z16;
            }
        }

        @NotNull
        public final byte[] j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (byte[]) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            String json = new Gson().toJson(this);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(this)");
            byte[] bytes = json.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "ExtraInfo(from=" + this.from + ", authorityStatus=" + this.authorityStatus + ", needDelete=" + this.needDelete + ")";
        }

        public a(int i3, int i16, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
                return;
            }
            this.from = i3;
            this.authorityStatus = i16;
            this.needDelete = z16;
        }

        public /* synthetic */ a(int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 3 : i3, (i17 & 2) != 0 ? 0 : i16, (i17 & 4) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0010\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/ah$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setFrom", "(Ljava/lang/Integer;)V", "from", "setAuthorityStatus", "authorityStatus", "c", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setNeedDelete", "(Ljava/lang/Boolean;)V", "needDelete", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer from;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Integer authorityStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean needDelete;

        public b(@Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, num, num2, bool);
                return;
            }
            this.from = num;
            this.authorityStatus = num2;
            this.needDelete = bool;
        }

        @Nullable
        public final Integer a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Integer) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.authorityStatus;
        }

        @Nullable
        public final Integer b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Integer) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.from;
        }

        @Nullable
        public final Boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Boolean) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.needDelete;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.from, bVar.from) && Intrinsics.areEqual(this.authorityStatus, bVar.authorityStatus) && Intrinsics.areEqual(this.needDelete, bVar.needDelete)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            Integer num = this.from;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            Integer num2 = this.authorityStatus;
            if (num2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Boolean bool = this.needDelete;
            if (bool != null) {
                i3 = bool.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "PendingExtraInfo(from=" + this.from + ", authorityStatus=" + this.authorityStatus + ", needDelete=" + this.needDelete + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        } else {
            this.TAG = "TofuMsgItem";
            this.mExtraInfo = new a(0, 0, false, 7, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(ah this$0, a info, IOperateCallback iOperateCallback, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        QLog.w(this$0.TAG, 1, "setPushExtraInfo info:" + info + ", result=" + i3 + ", errMsg=" + str);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    private final void z2() {
        ArrayList<TofuActionButton> arrayList;
        Long l3;
        Object firstOrNull;
        TofuRecordElement tofuRecordElement;
        TofuRecordElement tofuRecordElement2;
        MsgElement firstTypeElement = getFirstTypeElement(26);
        if (firstTypeElement != null && (tofuRecordElement2 = firstTypeElement.tofuRecordElement) != null) {
            Intrinsics.checkNotNullExpressionValue(tofuRecordElement2, "tofuRecordElement");
            this.busiid = tofuRecordElement2.busiid;
            this.busi_uuid = tofuRecordElement2.busiuuid;
            this.beancurdStyle = tofuRecordElement2.beancurstyle;
            this.descriptionContent = tofuRecordElement2.descriptionContent;
            this.contentList = tofuRecordElement2.contentlist;
            this.background = tofuRecordElement2.background;
            this.icon = tofuRecordElement2.icon;
            this.uinList = tofuRecordElement2.uinlist;
            this.busiExtra = tofuRecordElement2.busiExtra;
            this.mExtraInfo = a.INSTANCE.a(firstTypeElement.extBufForUI);
        }
        ArrayList<TofuContent> arrayList2 = this.contentList;
        if (arrayList2 != null) {
            for (TofuContent tofuContent : arrayList2) {
                IQzoneEMCodeApi iQzoneEMCodeApi = (IQzoneEMCodeApi) QRoute.api(IQzoneEMCodeApi.class);
                long j3 = this.busiid;
                String str = tofuContent.title;
                Intrinsics.checkNotNullExpressionValue(str, "it.title");
                tofuContent.title = iQzoneEMCodeApi.parseTofuContent(j3, str);
            }
        }
        g1(((IQzoneEMCodeApi) QRoute.api(IQzoneEMCodeApi.class)).parseTofuContent(this.busiid, w()));
        MsgElement firstTypeElement2 = getFirstTypeElement(26);
        String str2 = null;
        if (firstTypeElement2 != null && (tofuRecordElement = firstTypeElement2.tofuRecordElement) != null) {
            arrayList = tofuRecordElement.actionButtons;
        } else {
            arrayList = null;
        }
        this.tofuActionButton = arrayList;
        if (TofuMsgDebugSwitch.INSTANCE.c()) {
            int i3 = this.beancurdStyle;
            if (i3 == 1) {
                StringBuilder sb5 = new StringBuilder();
                ArrayList<TofuContent> arrayList3 = this.contentList;
                if (arrayList3 != null) {
                    Iterator<T> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        sb5.append(((TofuContent) it.next()).title);
                    }
                }
                com.tencent.mobileqq.aio.beancurd.a aVar = new com.tencent.mobileqq.aio.beancurd.a();
                Object[] objArr = new Object[5];
                String str3 = this.background;
                String str4 = "";
                if (str3 == null) {
                    str3 = "";
                }
                objArr[0] = str3;
                ArrayList<Long> arrayList4 = this.uinList;
                if (arrayList4 != null) {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList4);
                    l3 = (Long) firstOrNull;
                } else {
                    l3 = null;
                }
                objArr[1] = String.valueOf(l3);
                TofuContent tofuContent2 = this.descriptionContent;
                if (tofuContent2 != null) {
                    str2 = tofuContent2.title;
                }
                if (str2 == null) {
                    str2 = "";
                }
                objArr[2] = str2;
                String str5 = this.icon;
                if (str5 != null) {
                    str4 = str5;
                }
                objArr[3] = str4;
                objArr[4] = sb5.toString();
                this.mixUIViewData = aVar.b(objArr);
                return;
            }
            if (i3 == 3 && ((int) this.busiid) == 22) {
                this.mixUIViewData = new com.tencent.mobileqq.aio.beancurd.b().b(this);
            }
        }
    }

    public final void A2(@NotNull String background) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) background);
        } else {
            Intrinsics.checkNotNullParameter(background, "background");
            this.background = background;
        }
    }

    public final void B2(boolean temp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, temp);
        } else {
            this.exported = temp;
        }
    }

    public final void C2(@Nullable com.tencent.qqnt.aio.k onlineStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) onlineStatus);
        } else {
            this.onlineStatus = onlineStatus;
        }
    }

    public final void D2(@NotNull final a info, @Nullable final IOperateCallback callback) {
        com.tencent.qqnt.kernel.api.w e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) info, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        MsgElement firstTypeElement = getFirstTypeElement(26);
        if (firstTypeElement != null && (e16 = com.tencent.qqnt.msg.f.e()) != null) {
            e16.updateElementExtBufForUI(new Contact(p0(), r0(), ""), q0(), firstTypeElement.elementId, info.j(), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.ag
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    ah.E2(ah.this, info, callback, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            super.Y0(context);
            z2();
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 7, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new ah(getMsgRecord());
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        HashMap hashMap;
        ah ahVar;
        Integer num;
        Integer num2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return iPatchRedirector.redirect((short) 32, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Object changePayload = super.getChangePayload(target);
        if (changePayload instanceof HashMap) {
            hashMap = (HashMap) changePayload;
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        if (target instanceof ah) {
            ahVar = (ah) target;
        } else {
            ahVar = null;
        }
        if (ahVar != null) {
            if (!this.mExtraInfo.f(ahVar.mExtraInfo)) {
                hashMap.put(AIOMsgItemPayloadType.AUTHENTICATION_PAYLOAD, a.e.f192658a);
            }
            if (!com.tencent.qqnt.aio.msg.d.q(this, (AIOMsgItem) target)) {
                hashMap.put(AIOMsgItemPayloadType.SCREEN_SIZE_CHANGE, a.e.f192658a);
            }
            List<TofuActionButton> list = ahVar.tofuActionButton;
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            List<TofuActionButton> list2 = this.tofuActionButton;
            if (list2 != null) {
                num2 = Integer.valueOf(list2.size());
            } else {
                num2 = null;
            }
            if (!Intrinsics.areEqual(num, num2)) {
                hashMap.put(AIOMsgItemPayloadType.TOFU_ACTION_BUTTON_PAYLOAD, a.be.f192648a);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    @Nullable
    public final String getIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.icon;
    }

    @Override // com.tencent.aio.data.msglist.a
    public int getSubViewType(int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, viewType)).intValue();
        }
        return this.beancurdStyle;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return 66;
    }

    @Nullable
    public final String j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.background;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        long j3 = this.busiid;
        if (j3 == 0) {
            try {
                z2();
                j3 = this.busiid;
            } catch (Throwable unused) {
            }
        }
        if (!((IQQShowTofu) QRoute.api(IQQShowTofu.class)).checkNeedTimeStampForQQShowTofu(j3)) {
            return false;
        }
        return super.k();
    }

    public final int k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.beancurdStyle;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ah ahVar = (ah) newMsgItem;
        ahVar.busiid = this.busiid;
        ahVar.busi_uuid = this.busi_uuid;
        ahVar.beancurdStyle = this.beancurdStyle;
        ahVar.descriptionContent = this.descriptionContent;
        ahVar.contentList = this.contentList;
        ahVar.background = this.background;
        ahVar.icon = this.icon;
        ahVar.uinList = this.uinList;
        ahVar.busiExtra = this.busiExtra;
        ahVar.exported = this.exported;
        ahVar.onlineStatus = this.onlineStatus;
        ahVar.mExtraInfo = new a(this.mExtraInfo.b(), this.mExtraInfo.a(), this.mExtraInfo.c());
        ahVar.tofuActionButton = this.tofuActionButton;
        ahVar.mixUIViewData = this.mixUIViewData;
    }

    @Nullable
    public final String l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.busiExtra;
    }

    @Nullable
    public final String m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.busi_uuid;
    }

    public final long n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.busiid;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public Pair<Boolean, String> o(@NotNull com.tencent.aio.data.msglist.a target) {
        ah ahVar;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (Pair) iPatchRedirector.redirect((short) 31, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Integer num2 = null;
        if (target instanceof ah) {
            ahVar = (ah) target;
        } else {
            ahVar = null;
        }
        if (ahVar != null) {
            if (!this.mExtraInfo.f(ahVar.mExtraInfo)) {
                return new Pair<>(Boolean.FALSE, "authentication");
            }
            if (!com.tencent.qqnt.aio.msg.d.q(this, (AIOMsgItem) target)) {
                return new Pair<>(Boolean.FALSE, "sizeChanged");
            }
            List<TofuActionButton> list = ahVar.tofuActionButton;
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            List<TofuActionButton> list2 = this.tofuActionButton;
            if (list2 != null) {
                num2 = Integer.valueOf(list2.size());
            }
            if (!Intrinsics.areEqual(num, num2)) {
                return new Pair<>(Boolean.FALSE, "tofuActionButtonChanged");
            }
        }
        return super.o(target);
    }

    @Nullable
    public final List<TofuContent> o2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.contentList;
    }

    @Nullable
    public final TofuContent p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TofuContent) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.descriptionContent;
    }

    @NotNull
    public final a q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (a) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.mExtraInfo;
    }

    @NotNull
    public final a r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mExtraInfo;
    }

    @Nullable
    public final com.tencent.android.androidbypass.richui.viewdata.k s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.android.androidbypass.richui.viewdata.k) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mixUIViewData;
    }

    @Nullable
    public final com.tencent.qqnt.aio.k t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (com.tencent.qqnt.aio.k) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.onlineStatus;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String toString() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Long> arrayList2 = this.uinList;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(MD5Utils.encodeHexStr(String.valueOf(((Number) it.next()).longValue())));
            }
        }
        String str2 = this.TAG;
        long j3 = this.busiid;
        String str3 = this.busi_uuid;
        int i3 = this.beancurdStyle;
        TofuContent tofuContent = this.descriptionContent;
        ArrayList<TofuContent> arrayList3 = this.contentList;
        String str4 = this.background;
        String str5 = this.icon;
        com.tencent.qqnt.aio.k kVar = this.onlineStatus;
        boolean z16 = this.exported;
        long j16 = getMsgRecord().msgSeq;
        long j17 = getMsgRecord().msgTime;
        List<TofuActionButton> list = this.tofuActionButton;
        if (list != null) {
            str = list.toString();
        } else {
            str = null;
        }
        return "TofuMsgItem(TAG='" + str2 + "', busiid=" + j3 + ", busi_uuid=" + str3 + ", md5UinList=" + arrayList + ", beancurdStyle=" + i3 + ", descriptionContent=" + tofuContent + ", contentList=" + arrayList3 + ", background=" + str4 + ", icon=" + str5 + ", onlineStatus=" + kVar + ", exported=" + z16 + "), tofuMsgSeq:" + j16 + ", tofuMsgTime:" + j17 + ", tofuActionButton: " + str;
    }

    @NotNull
    public final List<TofuActionButton> u2() {
        List<TofuActionButton> emptyList;
        List<TofuActionButton> take;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        List<TofuActionButton> list = this.tofuActionButton;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (list.size() > 3) {
            take = CollectionsKt___CollectionsKt.take(list, 3);
            return take;
        }
        return list;
    }

    @Nullable
    public final List<String> v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Long> arrayList2 = this.uinList;
        if (arrayList2 != null) {
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Number) it.next()).longValue()));
            }
        }
        return arrayList;
    }

    public final boolean w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.exported;
    }

    public final boolean x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        if (this.mExtraInfo.d() && (this.mExtraInfo.a() == 0 || this.mExtraInfo.a() == 4)) {
            return true;
        }
        return false;
    }

    public final boolean y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        if (this.mExtraInfo.d() && (this.mExtraInfo.a() == 2 || this.mExtraInfo.c())) {
            return true;
        }
        return false;
    }
}
