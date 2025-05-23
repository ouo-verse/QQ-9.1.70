package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.base.PicSize;
import com.tencent.mobileqq.aio.msglist.holder.component.pic.PicUtil;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.ar;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 O2\u00020\u0001:\u0003PQRB\u000f\u0012\u0006\u0010M\u001a\u00020\u001b\u00a2\u0006\u0004\bN\u00106J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0006J\b\u0010$\u001a\u00020\u0002H\u0016J\u0012\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016R\u0016\u0010,\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R.\u00107\u001a\u0004\u0018\u00010\u001b2\b\u00100\u001a\u0004\u0018\u00010\u001b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0017\u0010C\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b@\u0010.\u001a\u0004\bA\u0010BR\u001a\u0010G\u001a\u00060DR\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0011\u0010J\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u0011\u0010L\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bK\u0010I\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/u;", "Lcom/tencent/mobileqq/aio/msg/o;", "", "text", "", "emojiSize", "", "ignoreLink", "", NowProxyConstants.AccountInfoKey.A2, "J2", "", "N2", "M2", "O2", "L2", "K2", "M0", Constants.MMCCID, "I2", "Landroid/text/TextPaint;", "textPaint", "", "F2", "Landroid/content/Context;", "context", "Y0", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "b0", "newMsgItem", "l", FaceUtil.IMG_TEMP, "P2", "H2", "f1", "Lcom/tencent/aio/data/msglist/a;", "target", "", "getChangePayload", "getViewType", "i1", "Z", "exported", "j1", "Ljava/lang/String;", "mediaDesc", "value", "k1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", Constants.BASE_IN_PLUGIN_VERSION, "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Q2", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "replyMsgRecord", "Lcom/tencent/mobileqq/aio/msg/u$c;", "l1", "Lcom/tencent/mobileqq/aio/msg/u$c;", "C2", "()Lcom/tencent/mobileqq/aio/msg/u$c;", "setReplyMsgInfo", "(Lcom/tencent/mobileqq/aio/msg/u$c;)V", "replyMsgInfo", "m1", "getNickname", "()Ljava/lang/String;", "nickname", "Lcom/tencent/mobileqq/aio/msg/u$b;", ICustomDataEditor.NUMBER_PARAM_1, "Lcom/tencent/mobileqq/aio/msg/u$b;", "preprocessData", "z2", "()Ljava/lang/CharSequence;", "msgDownQQText", "E2", "sourceQQText", "msgRecord", "<init>", "o1", "a", "b", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class u extends o {
    static IPatchRedirector $redirector_;

    /* renamed from: o1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: p1, reason: collision with root package name */
    @NotNull
    private static final IQQTextApi f190298p1;

    /* renamed from: i1, reason: collision with root package name and from kotlin metadata */
    private boolean exported;

    /* renamed from: j1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mediaDesc;

    /* renamed from: k1, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord replyMsgRecord;

    /* renamed from: l1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c replyMsgInfo;

    /* renamed from: m1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickname;

    /* renamed from: n1, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b preprocessData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/u$a;", "", "", "DOWN_TEXT_EMOJI_SIZE", "I", "MIN_VALID_PIC_WIDTH", "", "NEW_LINE", "Ljava/lang/String;", "SOURCE_TEXT_EMOJI_SIZE", "TAG", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "textApi", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msg.u$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R3\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR3\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/u$b;", "", "", "d", "c", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "qqTextCache", "", "b", "textWidthCache", "<init>", "(Lcom/tencent/mobileqq/aio/msg/u;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashMap<String, CharSequence> qqTextCache;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashMap<String, Float> textWidthCache;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
            } else {
                this.qqTextCache = new HashMap<>();
                this.textWidthCache = new HashMap<>();
            }
        }

        private final void d() {
            if (u.this.D2() != null && u.this.M0()) {
                u.this.E2();
            }
        }

        @NotNull
        public final HashMap<String, CharSequence> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.qqTextCache;
        }

        @NotNull
        public final HashMap<String, Float> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.textWidthCache;
        }

        public final void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                d();
                u.this.z2();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0012\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010(\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010$\u001a\u0004\b\n\u0010%\"\u0004\b&\u0010'R$\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010*\u001a\u0004\b\u000e\u0010+\"\u0004\b,\u0010-R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b/\u0010\b\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/aio/msg/u$c;", "", "", "a", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;)V", "sourceText", "b", "i", "r", "sourceTime", "c", "f", "o", "msgDownText", "d", "e", DomainData.DOMAIN_NAME, "mediaPath", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)V", "mediaMsgElement", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "g", "()Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;", "p", "(Lcom/tencent/mobileqq/aio/msglist/holder/base/PicSize;)V", "picSize", "", "I", "()I", "k", "(I)V", TagName.FILE_TYPE, "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "l", "(Landroid/graphics/drawable/Drawable;)V", "fileTypeIcon", "j", "arkMsgIcon", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String sourceText;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String sourceTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String msgDownText;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String mediaPath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private MsgElement mediaMsgElement;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private PicSize picSize;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private int fileType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable fileTypeIcon;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String arkMsgIcon;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.sourceText = "";
            this.sourceTime = "";
            this.msgDownText = "";
            this.mediaPath = "";
            this.picSize = PicSize.PIC_DOWNLOAD_THUMB;
            this.fileType = -1;
            this.arkMsgIcon = "";
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.arkMsgIcon;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            return this.fileType;
        }

        @Nullable
        public final Drawable c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (Drawable) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.fileTypeIcon;
        }

        @Nullable
        public final MsgElement d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (MsgElement) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.mediaMsgElement;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.mediaPath;
        }

        @NotNull
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.msgDownText;
        }

        @NotNull
        public final PicSize g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (PicSize) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return this.picSize;
        }

        @NotNull
        public final String h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.sourceText;
        }

        @NotNull
        public final String i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.sourceTime;
        }

        public final void j(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.arkMsgIcon = str;
            }
        }

        public final void k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, i3);
            } else {
                this.fileType = i3;
            }
        }

        public final void l(@Nullable Drawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) drawable);
            } else {
                this.fileTypeIcon = drawable;
            }
        }

        public final void m(@Nullable MsgElement msgElement) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) msgElement);
            } else {
                this.mediaMsgElement = msgElement;
            }
        }

        public final void n(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.mediaPath = str;
            }
        }

        public final void o(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.msgDownText = str;
            }
        }

        public final void p(@NotNull PicSize picSize) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) picSize);
            } else {
                Intrinsics.checkNotNullParameter(picSize, "<set-?>");
                this.picSize = picSize;
            }
        }

        public final void q(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.sourceText = str;
            }
        }

        public final void r(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.sourceTime = str;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57310);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
            f190298p1 = (IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
            return;
        }
        this.mediaDesc = "";
        this.replyMsgInfo = new c();
        String str = msgRecord.sendMemberName;
        str = str.length() == 0 ? msgRecord.sendNickName : str;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.sendMemberName\u2026 msgRecord.sendNickName }");
        this.nickname = str;
        this.preprocessData = new b();
        ReplyElement c16 = com.tencent.mobileqq.aio.reply.c.c(this);
        if (c16 != null) {
            Long l3 = c16.sourceMsgIdInRecords;
            if (l3 != null) {
                Intrinsics.checkNotNullExpressionValue(l3, "replyElement.sourceMsgIdInRecords");
                if (l3.longValue() > 0) {
                    ArrayList<MsgRecord> arrayList = msgRecord.records;
                    Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.records");
                    for (MsgRecord msgRecord2 : arrayList) {
                        long j3 = msgRecord2.msgId;
                        Long l16 = c16.sourceMsgIdInRecords;
                        if (l16 != null && j3 == l16.longValue()) {
                            Q2(msgRecord2);
                            if (QLog.isDevelopLevel()) {
                                long msgId = getMsgId();
                                MsgRecord msgRecord3 = this.replyMsgRecord;
                                Intrinsics.checkNotNull(msgRecord3);
                                QLog.i("ReplyMsgItem", 4, "from sourceMsgIdInRecords, msgId=" + msgId + ", replyMsgId=" + msgRecord3.msgId);
                            }
                        }
                    }
                }
            }
            M1(c16.replayMsgId);
        }
    }

    private final CharSequence A2(String text, int emojiSize, boolean ignoreLink) {
        boolean z16;
        int i3 = 0;
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        CharSequence charSequence = this.preprocessData.a().get(text);
        if (charSequence != null) {
            return charSequence;
        }
        IQQTextApi iQQTextApi = f190298p1;
        if (!ignoreLink) {
            i3 = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a.d();
        }
        CharSequence c16 = IQQTextApi.a.c(iQQTextApi, text, i3, emojiSize, null, null, 24, null);
        this.preprocessData.a().put(text, c16);
        iQQTextApi.setBizSrc(c16, "biz_src_jc_aio");
        return c16;
    }

    static /* synthetic */ CharSequence B2(u uVar, String str, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            z16 = false;
        }
        return uVar.A2(str, i3, z16);
    }

    private final boolean J2() {
        MsgRecord msgRecord = this.replyMsgRecord;
        if (msgRecord == null || msgRecord.msgType != 3) {
            return false;
        }
        return true;
    }

    private final void K2() {
        ArrayList<MsgElement> arrayList;
        MsgRecord msgRecord = this.replyMsgRecord;
        if (msgRecord != null && (arrayList = msgRecord.elements) != null) {
            for (MsgElement it : arrayList) {
                if (it.elementType == 10) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    com.tencent.mobileqq.aio.reply.c.g(it, this.replyMsgInfo);
                }
            }
        }
    }

    private final void L2() {
        ArrayList<MsgElement> arrayList;
        String str;
        Long l3;
        HashMap<Integer, String> hashMap;
        String str2;
        MsgRecord msgRecord = this.replyMsgRecord;
        if (msgRecord != null && (arrayList = msgRecord.elements) != null) {
            for (MsgElement msgElement : arrayList) {
                if (msgElement.elementType == 3) {
                    c cVar = this.replyMsgInfo;
                    FileElement fileElement = msgElement.fileElement;
                    Intrinsics.checkNotNullExpressionValue(fileElement, "it.fileElement");
                    cVar.k(com.tencent.qqnt.aio.element.file.util.a.d(fileElement));
                    Long l16 = null;
                    String str3 = null;
                    if (this.replyMsgInfo.b() != 0 && 2 != this.replyMsgInfo.b()) {
                        this.replyMsgInfo.l(ResourcesCompat.getDrawable(BaseApplication.context.getResources(), c81.a.i(this.replyMsgInfo.b()), BaseApplication.context.getTheme()));
                        c cVar2 = this.replyMsgInfo;
                        FileElement fileElement2 = msgElement.fileElement;
                        if (fileElement2 != null) {
                            str3 = fileElement2.fileName;
                        }
                        if (str3 == null) {
                            str3 = BaseApplication.context.getString(R.string.ytk);
                            str2 = "context.getString(R.string.aio_save_file_msg)";
                        } else {
                            str2 = "it.fileElement?.fileName\u2026string.aio_save_file_msg)";
                        }
                        Intrinsics.checkNotNullExpressionValue(str3, str2);
                        cVar2.q(str3);
                    } else {
                        this.replyMsgInfo.m(msgElement);
                        c cVar3 = this.replyMsgInfo;
                        FileElement fileElement3 = msgElement.fileElement;
                        if (fileElement3 != null && (hashMap = fileElement3.picThumbPath) != null) {
                            str = hashMap.get(750);
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str, "it.fileElement?.picThumb\u2026RMFILETHUMBSIZE750) ?: \"\"");
                        }
                        cVar3.n(str);
                        if (QLog.isDevelopLevel()) {
                            MsgRecord msgRecord2 = this.replyMsgRecord;
                            if (msgRecord2 != null) {
                                l3 = Long.valueOf(msgRecord2.msgId);
                            } else {
                                l3 = null;
                            }
                            long j3 = msgElement.elementId;
                            FileElement fileElement4 = msgElement.fileElement;
                            QLog.i("ReplyMsgItem", 1, "[parseFileMsg] msgId:" + l3 + ", elementId:" + j3 + ", picSize=" + fileElement4.picWidth + "," + fileElement4.picHeight);
                        }
                        Integer num = msgElement.fileElement.picWidth;
                        Intrinsics.checkNotNullExpressionValue(num, "it.fileElement.picWidth");
                        if (num.intValue() > 64) {
                            Integer num2 = msgElement.fileElement.picHeight;
                            Intrinsics.checkNotNullExpressionValue(num2, "it.fileElement.picHeight");
                            if (num2.intValue() <= 64) {
                            }
                        }
                        Pair<Integer, Integer> c16 = PicUtil.f191410a.c(this.replyMsgInfo.e());
                        msgElement.fileElement.picWidth = c16.getFirst();
                        msgElement.fileElement.picHeight = c16.getSecond();
                        MsgRecord msgRecord3 = this.replyMsgRecord;
                        if (msgRecord3 != null) {
                            l16 = Long.valueOf(msgRecord3.msgId);
                        }
                        QLog.i("ReplyMsgItem", 1, "fix file image size, msgId=" + l16 + ", size=" + c16.getFirst() + "," + c16.getSecond() + ", path=" + this.replyMsgInfo.e());
                    }
                }
            }
        }
    }

    private final void M2() {
        boolean z16;
        boolean z17;
        boolean startsWith$default;
        ArrayList<MsgElement> arrayList;
        FaceElement faceElement;
        int intValue;
        boolean z18;
        MsgRecord msgRecord = this.replyMsgRecord;
        if (msgRecord != null && com.tencent.mobileqq.aio.utils.d.G(msgRecord)) {
            z16 = true;
        } else {
            z16 = false;
        }
        Integer num = null;
        if (z16) {
            c cVar = this.replyMsgInfo;
            MsgRecord msgRecord2 = this.replyMsgRecord;
            Intrinsics.checkNotNull(msgRecord2);
            cVar.q(com.tencent.mobileqq.aio.reply.c.e(msgRecord2, false, null, 4, null).toString());
            return;
        }
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) api;
        MsgRecord msgRecord3 = this.replyMsgRecord;
        if (msgRecord3 != null && (arrayList = msgRecord3.elements) != null) {
            z17 = false;
            for (MsgElement it : arrayList) {
                int i3 = it.elementType;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 6 && (faceElement = it.faceElement) != null) {
                            Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                            if (!z17) {
                                if (MsgExtKt.N(faceElement)) {
                                    c cVar2 = this.replyMsgInfo;
                                    cVar2.q(cVar2.h() + ar.f194115a.a(faceElement, true));
                                } else {
                                    c cVar3 = this.replyMsgInfo;
                                    String h16 = cVar3.h();
                                    QRouteApi api2 = QRoute.api(IEmojiSpanService.class);
                                    Intrinsics.checkNotNullExpressionValue(api2, "api(IEmojiSpanService::class.java)");
                                    IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api2;
                                    int i16 = faceElement.faceType;
                                    int i17 = faceElement.faceIndex;
                                    Integer num2 = faceElement.imageType;
                                    if (num2 == null) {
                                        intValue = 0;
                                    } else {
                                        Intrinsics.checkNotNullExpressionValue(num2, "faceElement.imageType ?: 0");
                                        intValue = num2.intValue();
                                    }
                                    cVar3.q(h16 + ((Object) IEmojiSpanService.a.a(iEmojiSpanService, i16, i17, intValue, true, 0, 16, null)));
                                }
                            }
                        }
                    } else if (!z17) {
                        PicUtil picUtil = PicUtil.f191410a;
                        PicSize g16 = this.replyMsgInfo.g();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        if (!picUtil.q(g16, it)) {
                            this.replyMsgInfo.p(PicSize.PIC_DOWNLOAD_THUMB);
                            if (!picUtil.q(this.replyMsgInfo.g(), it)) {
                                this.replyMsgInfo.p(PicSize.PIC_DOWNLOAD_ORI);
                            }
                        }
                        this.replyMsgInfo.m(it);
                        c cVar4 = this.replyMsgInfo;
                        cVar4.n(AIOPicDownloader.f190570a.p(it, cVar4.g()));
                        this.mediaDesc = HardCodeUtil.qqStr(R.string.yp6).toString();
                        z17 = true;
                    }
                } else {
                    if (!z17) {
                        c cVar5 = this.replyMsgInfo;
                        String h17 = cVar5.h();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        cVar5.q(h17 + iMsgUtilApi.getElementContent(it));
                    }
                    if (z17) {
                        if (this.replyMsgInfo.f().length() == 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            c cVar6 = this.replyMsgInfo;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            cVar6.o(iMsgUtilApi.getElementContent(it));
                        }
                    }
                }
            }
        } else {
            z17 = false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.replyMsgInfo.f(), "\n", false, 2, null);
        if (startsWith$default) {
            c cVar7 = this.replyMsgInfo;
            String substring = cVar7.f().substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            cVar7.o(substring);
        }
        if (QLog.isDevelopLevel()) {
            long msgId = getMsgId();
            MsgElement d16 = this.replyMsgInfo.d();
            if (d16 != null) {
                num = Integer.valueOf(d16.elementType);
            }
            AIOUtil aIOUtil = AIOUtil.f194084a;
            QLog.i("ReplyMsgItem", 4, "[parseMixMsgInfo] msgId=" + msgId + ", hasMedia=" + z17 + ", mediaElement=" + num + ", sourceText=" + ((Object) aIOUtil.o(this.replyMsgInfo.h())) + ", msgDownText=" + ((Object) aIOUtil.o(this.replyMsgInfo.f())) + "}");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private final void N2() {
        Integer num;
        ?? r56;
        ?? r57;
        ?? r58;
        ?? r59;
        ?? r510;
        ArrayList<MsgElement> arrayList;
        MsgRecord msgRecord = this.replyMsgRecord;
        if (msgRecord == null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("ReplyMsgItem", 1, "[parseReplyMsgInfo] replyMsgRecord == null, msgId=" + getMsgId());
                return;
            }
            return;
        }
        c cVar = this.replyMsgInfo;
        BaseApplication baseApplication = BaseApplication.context;
        Intrinsics.checkNotNull(msgRecord);
        cVar.r(en.f(baseApplication, 3, msgRecord.msgTime * 1000, true, true).toString());
        if (M0()) {
            return;
        }
        MsgRecord msgRecord2 = this.replyMsgRecord;
        Integer num2 = null;
        r3 = null;
        StringBuilder sb5 = null;
        if (msgRecord2 != null) {
            num = Integer.valueOf(msgRecord2.msgType);
        } else {
            num = null;
        }
        if ((num != null && num.intValue() == 2) || (num != null && num.intValue() == 9)) {
            r56 = true;
        } else {
            r56 = false;
        }
        if (r56 != false) {
            M2();
            return;
        }
        if (num != null && num.intValue() == 7) {
            O2();
            return;
        }
        if (num != null && num.intValue() == 11) {
            K2();
            return;
        }
        if (num != null && num.intValue() == 3) {
            L2();
            return;
        }
        if ((num != null && num.intValue() == 6) || (num != null && num.intValue() == 10)) {
            r57 = true;
        } else {
            r57 = false;
        }
        if (r57 != false || (num != null && num.intValue() == 17)) {
            r58 = true;
        } else {
            r58 = false;
        }
        if (r58 != false || (num != null && num.intValue() == 24)) {
            r59 = true;
        } else {
            r59 = false;
        }
        if (r59 != false || (num != null && num.intValue() == 8)) {
            r510 = true;
        } else {
            r510 = false;
        }
        if (r510 != false) {
            c cVar2 = this.replyMsgInfo;
            MsgRecord msgRecord3 = this.replyMsgRecord;
            Intrinsics.checkNotNull(msgRecord3);
            cVar2.q(com.tencent.mobileqq.aio.reply.c.e(msgRecord3, false, null, 4, null).toString());
            return;
        }
        if (num != null && num.intValue() == 31) {
            if (com.tencent.mobileqq.aio.utils.d.S(getMsgRecord())) {
                c cVar3 = this.replyMsgInfo;
                MsgRecord msgRecord4 = this.replyMsgRecord;
                if (msgRecord4 != null && (arrayList = msgRecord4.elements) != null) {
                    sb5 = new StringBuilder();
                    for (MsgElement msgElement : arrayList) {
                        if (msgElement.elementType == 14) {
                            sb5.append(msgElement.markdownElement.mdSummary);
                        }
                    }
                }
                cVar3.q(((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).parseExcludeExtData(String.valueOf(sb5), 50).toString());
                return;
            }
            c cVar4 = this.replyMsgInfo;
            MsgRecord msgRecord5 = this.replyMsgRecord;
            Intrinsics.checkNotNull(msgRecord5);
            cVar4.q(com.tencent.mobileqq.aio.reply.c.e(msgRecord5, false, null, 4, null).toString());
            return;
        }
        MsgRecord msgRecord6 = this.replyMsgRecord;
        if (msgRecord6 != null) {
            num2 = Integer.valueOf(msgRecord6.msgType);
        }
        QLog.d("ReplyMsgItem", 1, "parseReplyMsgInfo ignore msgType : " + num2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r1 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void O2() {
        ArrayList<MsgElement> arrayList;
        String str;
        MsgRecord msgRecord = this.replyMsgRecord;
        if (msgRecord != null && (arrayList = msgRecord.elements) != null) {
            for (MsgElement msgElement : arrayList) {
                if (msgElement.elementType == 5) {
                    this.replyMsgInfo.m(msgElement);
                    c cVar = this.replyMsgInfo;
                    VideoElement videoElement = msgElement.videoElement;
                    if (videoElement != null) {
                        Intrinsics.checkNotNullExpressionValue(videoElement, "videoElement");
                        str = com.tencent.mobileqq.aio.utils.aj.f(videoElement);
                    }
                    str = "";
                    cVar.n(str);
                    this.mediaDesc = HardCodeUtil.qqStr(R.string.ypf).toString();
                }
            }
        }
    }

    @NotNull
    public final c C2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.replyMsgInfo;
    }

    @Nullable
    public final MsgRecord D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.replyMsgRecord;
    }

    @NotNull
    public final CharSequence E2() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        if (!TextUtils.isEmpty(this.replyMsgInfo.h())) {
            String h16 = this.replyMsgInfo.h();
            if (this.replyMsgInfo.c() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            return A2(h16, 15, z16);
        }
        return "";
    }

    public final float F2(@NotNull TextPaint textPaint, @NotNull String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, (Object) this, (Object) textPaint, (Object) text)).floatValue();
        }
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        Intrinsics.checkNotNullParameter(text, "text");
        Float f16 = this.preprocessData.b().get(text);
        if (f16 != null) {
            return f16.floatValue();
        }
        float measureText = textPaint.measureText(text);
        this.preprocessData.b().put(text, Float.valueOf(measureText));
        return measureText;
    }

    public boolean G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        MsgRecord msgRecord = this.replyMsgRecord;
        if (msgRecord == null || msgRecord.msgType != 1) {
            return false;
        }
        return true;
    }

    public final boolean H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.exported;
    }

    public final boolean I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (!J2() || this.replyMsgInfo.b() == 0 || this.replyMsgInfo.b() == 2) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean M0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        ReplyElement c16 = com.tencent.mobileqq.aio.reply.c.c(this);
        if (c16 == null || c16.replyMsgRevokeType != 1) {
            return false;
        }
        return true;
    }

    public final void P2(boolean temp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, temp);
        } else {
            this.exported = temp;
        }
    }

    public final void Q2(@Nullable MsgRecord msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msgRecord);
        } else {
            this.replyMsgRecord = msgRecord;
            N2();
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.o, com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) context);
        } else {
            super.Y0(context);
            this.preprocessData.c();
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.o, com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 14, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new u(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.o, com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        List<o.b> o26 = o2();
        int size = o26.size();
        String str = "";
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            o.b bVar = o26.get(i16);
            if (bVar.b() != null) {
                str = str + HardCodeUtil.qqStr(R.string.yp6);
            } else if (bVar.c() != null) {
                CharSequence charSequence = p2().get(Integer.valueOf(i3));
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = " ";
                }
                str = str + com.tencent.qqnt.emotion.utils.s.b(String.valueOf(charSequence));
                i3++;
            }
        }
        if (isSelf()) {
            return HardCodeUtil.qqStr(R.string.ypb) + HardCodeUtil.qqStr(R.string.ype) + str;
        }
        if (com.tencent.mobileqq.aio.utils.d.s(this)) {
            return getMsgRecord().anonymousExtInfo.anonymousNick + HardCodeUtil.qqStr(R.string.ype) + str;
        }
        CharSequence x16 = x();
        return ((Object) x16) + HardCodeUtil.qqStr(R.string.ype) + str;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        String str;
        ArrayList<MsgElement> arrayList;
        String str2;
        ArrayList<MsgElement> arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return iPatchRedirector.redirect((short) 20, (Object) this, (Object) target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        Object changePayload = super.getChangePayload(target);
        boolean z16 = false;
        try {
            if (changePayload instanceof Map) {
                hashMap.putAll((Map) changePayload);
            }
        } catch (Exception e16) {
            QLog.e("ReplyMsgItem", 1, e16, new Object[0]);
        }
        if (!(target instanceof u)) {
            QLog.i("ReplyMsgItem", 1, "getChangePayload  target is not ReplyMsgItem, " + target);
            return hashMap;
        }
        u uVar = (u) target;
        MsgRecord msgRecord = uVar.replyMsgRecord;
        if (msgRecord != null && msgRecord.msgType == 3) {
            z16 = true;
        }
        if (z16 && uVar.replyMsgInfo.b() == 0) {
            MsgRecord msgRecord2 = this.replyMsgRecord;
            String str3 = "";
            if (msgRecord2 == null || (arrayList2 = msgRecord2.elements) == null) {
                str = "";
            } else {
                Iterator<T> it = arrayList2.iterator();
                loop0: while (true) {
                    str = "";
                    while (it.hasNext()) {
                        FileElement fileElement = ((MsgElement) it.next()).fileElement;
                        if (fileElement != null) {
                            str = fileElement.filePath;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            break;
                        }
                        Intrinsics.checkNotNullExpressionValue(str, "it.fileElement?.filePath ?: \"\"");
                    }
                }
            }
            MsgRecord msgRecord3 = uVar.replyMsgRecord;
            if (msgRecord3 != null && (arrayList = msgRecord3.elements) != null) {
                Iterator<T> it5 = arrayList.iterator();
                loop2: while (true) {
                    str2 = "";
                    while (it5.hasNext()) {
                        FileElement fileElement2 = ((MsgElement) it5.next()).fileElement;
                        if (fileElement2 != null) {
                            str2 = fileElement2.filePath;
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            break;
                        }
                        Intrinsics.checkNotNullExpressionValue(str2, "it.fileElement?.filePath ?: \"\"");
                    }
                }
                str3 = str2;
            }
            if (!Intrinsics.areEqual(str, str3)) {
                hashMap.put(AIOMsgItemPayloadType.MEDIA_PATH_PAYLOAD, a.av.f192638a);
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msg.o, com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 24;
        }
        return 23;
    }

    @Override // com.tencent.mobileqq.aio.msg.o, com.tencent.mobileqq.aio.msg.w, com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void l(@NotNull AIOMsgItem newMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) newMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(newMsgItem, "newMsgItem");
        super.l(newMsgItem);
        u uVar = (u) newMsgItem;
        uVar.Q2(this.replyMsgRecord);
        uVar.replyMsgInfo = this.replyMsgInfo;
        uVar.preprocessData = this.preprocessData;
    }

    @NotNull
    public final CharSequence z2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CharSequence) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (!TextUtils.isEmpty(this.replyMsgInfo.f())) {
            return B2(this, this.replyMsgInfo.f(), 15, false, 4, null);
        }
        return "";
    }
}
