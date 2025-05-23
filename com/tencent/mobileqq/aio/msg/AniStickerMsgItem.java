package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0003IJKB\u000f\u0012\u0006\u0010F\u001a\u00020\u0011\u00a2\u0006\u0004\bG\u0010HJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001H\u0016J\u0010\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001c\u001a\u00020\tJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010!\u001a\u00020\u0002R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010+R\u0014\u00100\u001a\u00020-8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0011\u00103\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0011\u00105\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b4\u00102R\u0011\u00108\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u0010:\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b9\u00107R\u0011\u0010<\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b;\u00107R\u0011\u0010?\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0011\u0010A\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b@\u0010>R\u0014\u0010E\u001a\u00020B8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010D\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "u2", "v2", "w2", "k2", "Landroid/content/Context;", "context", "", "Y0", "X0", "z2", "", "f1", "newMsgItem", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "", "getViewType", "", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isRead", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "B2", Constants.BASE_IN_PLUGIN_VERSION, "Lcom/tencent/aio/data/msglist/a;", "target", "", "getChangePayload", "y2", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "W0", "Lcom/tencent/mobileqq/data/AniStickerInfo;", ICustomDataEditor.STRING_PARAM_2, "()Lcom/tencent/mobileqq/data/AniStickerInfo;", NowProxyConstants.AccountInfoKey.A2, "(Lcom/tencent/mobileqq/data/AniStickerInfo;)V", "stickerInfo", "Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem$b;", "Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem$b;", "stateInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "o2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", ICustomDataEditor.NUMBER_PARAM_2, "()I", "localId", "r2", "serverId", "q2", "()Ljava/lang/String;", "resultId", "t2", "surpriseId", "m2", "faceText", "x2", "()Z", "isMsgRead", "p2", "msgPlayedSurprise", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "l2", "()Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "a", "b", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AniStickerMsgItem extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: Y0, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: W0, reason: from kotlin metadata */
    @Nullable
    private AniStickerInfo stickerInfo;

    /* renamed from: X0, reason: from kotlin metadata */
    @NotNull
    private final b stateInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.AniStickerMsgItem$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \b2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem$b;", "", "", tl.h.F, "buf", "", "a", "Z", "d", "()Z", "e", "(Z)V", "isMsgRead", "", "b", "I", "()I", "f", "(I)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "c", "g", "playedSurprise", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: e, reason: collision with root package name */
        private static final Charset f190015e;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isMsgRead;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int playState;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean playedSurprise;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem$b$a;", "", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "CHARSET_UTF8", "Ljava/nio/charset/Charset;", "", "KEY_IS_MSG_READ", "Ljava/lang/String;", "KEY_PLAYED_SURPRISE", "KEY_PLAY_STATE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.aio.msg.AniStickerMsgItem$b$a, reason: from kotlin metadata */
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

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57126);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 10)) {
                redirector.redirect((short) 10);
            } else {
                INSTANCE = new Companion(null);
                f190015e = Charset.forName("UTF-8");
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean a(@NotNull byte[] buf) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) buf)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(buf, "buf");
            if (buf.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
            try {
                Charset CHARSET_UTF8 = f190015e;
                Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
                JSONObject jSONObject = new JSONObject(new String(buf, CHARSET_UTF8));
                this.isMsgRead = jSONObject.optBoolean("KEY_IS_MSG_READ");
                this.playState = jSONObject.optInt("KEY_PLAY_STATE");
                this.playedSurprise = jSONObject.optBoolean("KEY_PLAYED_SURPRISE");
                return true;
            } catch (JSONException e16) {
                com.tencent.qqnt.aio.utils.q.e("MsgExtendInfo", "[fromByteArray] failed, exc=" + e16);
                return false;
            }
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.playState;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.playedSurprise;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isMsgRead;
        }

        public final void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.isMsgRead = z16;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.playState = i3;
            }
        }

        public final void g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.playedSurprise = z16;
            }
        }

        @NotNull
        public final byte[] h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("KEY_IS_MSG_READ", this.isMsgRead);
                jSONObject.put("KEY_PLAY_STATE", this.playState);
                jSONObject.put("KEY_PLAYED_SURPRISE", this.playedSurprise);
                String jSONObject2 = jSONObject.toString(0);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "root.toString(0)");
                Charset CHARSET_UTF8 = f190015e;
                Intrinsics.checkNotNullExpressionValue(CHARSET_UTF8, "CHARSET_UTF8");
                byte[] bytes = jSONObject2.getBytes(CHARSET_UTF8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return bytes;
            } catch (JSONException e16) {
                com.tencent.qqnt.aio.utils.q.e("MsgExtendInfo", "[toByteArray] failed, exc=" + e16);
                return new byte[0];
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem$c;", "", "", "state", "", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f190019a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57127);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f190019a = new c();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean a(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, state)).booleanValue();
            }
            if (state != 2 && state != 3) {
                return false;
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AniStickerMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            return;
        }
        b bVar = new b();
        this.stateInfo = bVar;
        byte[] bArr = o2().extBufForUI;
        Intrinsics.checkNotNullExpressionValue(bArr, "msgElement.extBufForUI");
        bVar.a(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(final int i3, final String str) {
        com.tencent.qqnt.aio.utils.q.b("AniStickerMsgItem", new Function0<String>(i3, str) { // from class: com.tencent.mobileqq.aio.msg.AniStickerMsgItem$updateStateInfo$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$errMsg = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "update state info, result=" + this.$result + ", msg=" + this.$errMsg;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(final int i3, final String str) {
        com.tencent.qqnt.aio.utils.q.b("AniStickerMsgItem", new Function0<String>(i3, str) { // from class: com.tencent.mobileqq.aio.msg.AniStickerMsgItem$updateStateInfoPlayedSurprise$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ int $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$errMsg = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "update state info, result=" + this.$result + ", msg=" + this.$errMsg;
            }
        });
    }

    private final MsgElement o2() {
        MsgElement firstTypeElement = getFirstTypeElement(6);
        Intrinsics.checkNotNull(firstTypeElement);
        return firstTypeElement;
    }

    public final void A2(@Nullable AniStickerInfo aniStickerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aniStickerInfo);
        } else {
            this.stickerInfo = aniStickerInfo;
        }
    }

    public final void B2(boolean isRead, int playState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Boolean.valueOf(isRead), Integer.valueOf(playState));
            return;
        }
        if (this.stateInfo.d() != isRead) {
            this.stateInfo.e(isRead);
            z16 = true;
        }
        if (this.stateInfo.b() != playState) {
            this.stateInfo.f(playState);
        } else {
            z17 = z16;
        }
        if (z17) {
            o2().extBufForUI = this.stateInfo.h();
            com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                Contact contact = new Contact(getMsgRecord().chatType, getMsgRecord().peerUid, "");
                long q06 = q0();
                long j3 = o2().elementId;
                byte[] bArr = o2().extBufForUI;
                Intrinsics.checkNotNullExpressionValue(bArr, "msgElement.extBufForUI");
                e16.updateElementExtBufForUI(contact, q06, j3, bArr, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.c
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        AniStickerMsgItem.C2(i3, str);
                    }
                });
            }
        }
    }

    public final void D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (this.stateInfo.c()) {
            return;
        }
        this.stateInfo.g(true);
        o2().extBufForUI = this.stateInfo.h();
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            Contact contact = new Contact(getMsgRecord().chatType, getMsgRecord().peerUid, "");
            long q06 = q0();
            long j3 = o2().elementId;
            byte[] bArr = o2().extBufForUI;
            Intrinsics.checkNotNullExpressionValue(bArr, "msgElement.extBufForUI");
            e16.updateElementExtBufForUI(contact, q06, j3, bArr, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msg.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    AniStickerMsgItem.E2(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public List<CharSequence> Q() {
        List filterNotNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (List) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<MsgElement> elements = getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList2.add((MsgElement) it.next());
                }
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            FaceElement faceElement = ((MsgElement) it5.next()).faceElement;
            if (faceElement != null) {
                arrayList.add(faceElement.faceText);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void X0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.X0();
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            g1(f1());
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        z2();
        com.tencent.qqnt.aio.anisticker.view.h.f348873a.e();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 22, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new AniStickerMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ypd) + HardCodeUtil.qqStr(R.string.f170197yp0) + l2().faceText;
        }
        if (com.tencent.mobileqq.aio.utils.d.s(this)) {
            return getMsgRecord().anonymousExtInfo.anonymousNick + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.f170197yp0) + l2().faceText;
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ypc) + HardCodeUtil.qqStr(R.string.f170197yp0) + l2().faceText;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return iPatchRedirector.redirect((short) 27, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        try {
            if (changePayload instanceof Map) {
                hashMap.putAll((Map) changePayload);
            }
        } catch (Exception e16) {
            QLog.e("AniStickerMsgItem", 1, e16, new Object[0]);
            if (!com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                throw e16;
            }
        }
        if (!(target instanceof AniStickerMsgItem)) {
            QLog.i("AniStickerMsgItem", 1, "getChangePayload  target is not AniStickerMsgItem, " + target);
            return hashMap;
        }
        AniStickerMsgItem aniStickerMsgItem = (AniStickerMsgItem) target;
        if (!Intrinsics.areEqual(aniStickerMsgItem.l2().resultId, l2().resultId)) {
            AIOMsgItemPayloadType aIOMsgItemPayloadType = AIOMsgItemPayloadType.RANDOM_LOTTIE_RESULT;
            String str = aniStickerMsgItem.l2().resultId;
            if (str == null) {
                str = "";
            }
            hashMap.put(aIOMsgItemPayloadType, new a.as(str));
        }
        if (aniStickerMsgItem.stickerInfo == null && !TextUtils.isEmpty(com.tencent.mobileqq.emoticon.m.o(5))) {
            hashMap.put(AIOMsgItemPayloadType.LOTTIE_RES_UPDATE_PAYLOAD, a.x.f192677a);
            if (QLog.isColorLevel()) {
                QLog.d("AniStickerMsgItem", 2, "getChangePayload LOTTIE_RES_UPDATE_PAYLOAD", Thread.currentThread().getName());
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        if (getMsgRecord().msgType == 2) {
            if (isSelf()) {
                return 15;
            }
            return 14;
        }
        return super.getViewType();
    }

    public final boolean k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (u2()) {
            return v2();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        ((AniStickerMsgItem) newMsgItem).stickerInfo = this.stickerInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final FaceElement l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (FaceElement) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        FaceElement faceElement = o2().faceElement;
        Intrinsics.checkNotNullExpressionValue(faceElement, "msgElement.faceElement");
        return faceElement;
    }

    @NotNull
    public final String m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = l2().faceText;
        Intrinsics.checkNotNullExpressionValue(str, "faceElement.faceText");
        return str;
    }

    public final int n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return QQSysFaceUtil.convertToLocal(r2());
    }

    public final boolean p2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.stateInfo.c();
    }

    @NotNull
    public final String q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = l2().resultId;
        Intrinsics.checkNotNullExpressionValue(str, "faceElement.resultId");
        return str;
    }

    public final int r2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return l2().faceIndex;
    }

    @Nullable
    public final AniStickerInfo s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AniStickerInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.stickerInfo;
    }

    @NotNull
    public final String t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = l2().surpriseId;
        Intrinsics.checkNotNullExpressionValue(str, "faceElement.surpriseId");
        return str;
    }

    public final boolean u2() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        Integer num2 = l2().stickerType;
        if ((num2 == null || num2.intValue() != 2) && ((num = l2().stickerType) == null || num.intValue() != 3)) {
            return false;
        }
        return true;
    }

    public final boolean v2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return c.f190019a.a(this.stateInfo.b());
    }

    public final boolean w2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.stateInfo.b() == 0) {
            return true;
        }
        return false;
    }

    public final boolean x2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.stateInfo.d();
    }

    public final boolean y2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        AniStickerInfo aniStickerInfo = this.stickerInfo;
        if (aniStickerInfo == null || TextUtils.isEmpty(aniStickerInfo.aniStickerPackId) || TextUtils.isEmpty(aniStickerInfo.aniStickerId)) {
            return false;
        }
        return true;
    }

    public void z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            this.stickerInfo = com.tencent.qqnt.aio.anisticker.view.e.f348849a.h(n2(), q2(), t2());
        }
    }
}
