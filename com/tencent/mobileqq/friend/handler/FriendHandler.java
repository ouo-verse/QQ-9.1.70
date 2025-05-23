package com.tencent.mobileqq.friend.handler;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.config.a;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.recevier.AddBatchPhoneFriendReceiver;
import com.tencent.mobileqq.friend.handler.recevier.c;
import com.tencent.mobileqq.friend.handler.recevier.d;
import com.tencent.mobileqq.friend.handler.recevier.e;
import com.tencent.mobileqq.friend.handler.recevier.f;
import com.tencent.mobileqq.friend.handler.recevier.g;
import com.tencent.mobileqq.friend.handler.recevier.i;
import com.tencent.mobileqq.friend.handler.recevier.j;
import com.tencent.mobileqq.friend.handler.recevier.k;
import com.tencent.mobileqq.friend.handler.recevier.l;
import com.tencent.mobileqq.friend.handler.recevier.m;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.friend.servlet.b;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.realname.RealNameSource;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x10fa.oidb_0x10fa$IsFriendBatchReq;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$ClientExtention;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$FetchOnlyChatPagedReq;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$FetchSelectReq;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$Permission;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$SetReq;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$UserPermission;
import tencent.im.oidb.cmd0x829.oidb_0x829$ReqBody;
import tencent.im.oidb.oidb_0x5e1$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0086\u00012\u00020\u0001:\u0002\u0087\u0001B\u0013\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u00a2\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0014J\b\u0010\r\u001a\u00020\u0002H\u0016J&\u0010\u0014\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0016J\u0016\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u0019J\u00aa\u0001\u00102\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010%2\u0006\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u00010%J\u000e\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u000203J(\u00107\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004J0\u00109\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u00020\u0006J$\u0010?\u001a\u00020\u00022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00040:2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=J \u0010@\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0016\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u0004JV\u0010K\u001a\u00020\u00022\u0016\u0010F\u001a\u0012\u0012\u0004\u0012\u00020D0Cj\b\u0012\u0004\u0012\u00020D`E2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001e\u0010J\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010Cj\f\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u0001`EJ\u001c\u0010N\u001a\u00020\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040:2\u0006\u0010M\u001a\u00020\u0006J$\u0010Q\u001a\u00020\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040:2\u0006\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0006J\u000e\u0010R\u001a\u00020\u00022\u0006\u0010O\u001a\u00020\u0006J,\u0010W\u001a\u0004\u0018\u00010\u000e2\b\u0010S\u001a\u0004\u0018\u00010\u00042\u0006\u0010T\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010%J\u000e\u0010Y\u001a\u00020X2\u0006\u0010M\u001a\u00020\u0006R\u0017\u0010_\u001a\u00020Z8\u0006\u00a2\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u0017\u0010e\u001a\u00020`8\u0006\u00a2\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0017\u0010k\u001a\u00020f8\u0006\u00a2\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR2\u0010w\u001a\u0012\u0012\u0004\u0012\u00020p0Cj\b\u0012\u0004\u0012\u00020p`E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR0\u0010z\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000x0Cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000x`E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\by\u0010rR$\u0010\u0081\u0001\u001a\u0002038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "L2", "", "friendUin", "", "sourceId", "subSourceId", "O2", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "onReceive", "", "getCommandList", "Lcom/tencent/mobileqq/friend/data/FriendListRequestData;", WebViewPlugin.KEY_REQUEST, "", "checkFreq", "T2", "Lcom/tencent/mobileqq/friend/data/GroupRequestData;", "S2", "M2", "extraUin", "friendSetting", "", "groupId", "msg", "sourceID", "", "extSourceId", "autoSend", PreloadTRTCPlayerParams.KEY_SIG, "isContactBothWay", "remark", RealNameSource.EXTRA_KEY_SOURCE_NAME, "myCard", "ticket", "Landroid/os/Bundle;", "extraParam", "isSupportSecurityTips", "addFriendToken", "Q2", "", "uin", "W2", "sourceSubID", "X2", "ranKey", "Y2", "", "openIdList", "appId", "Landroid/os/ResultReceiver;", "receiver", "V2", "R2", "openId", "U2", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/data/PhoneContact;", "Lkotlin/collections/ArrayList;", "phoneArr", "verifyMsg", "pkgIndex", "Lcom/tencent/mobileqq/app/AddBatchPhoneFriendResult;", "resultList", "P2", "uins", "status", "Z2", "startIndex", "endIndex", "K2", "J2", "cmd", "command", "serviceType", "bodyByte", Constants.BASE_IN_PLUGIN_VERSION, "Ltencent/im/oidb/cmd0x1122/oidb_0x1122$ClientExtention;", "N2", "Lcom/tencent/mobileqq/friend/servlet/b;", "d", "Lcom/tencent/mobileqq/friend/servlet/b;", "I2", "()Lcom/tencent/mobileqq/friend/servlet/b;", "mService", "Lcom/tencent/mobileqq/friend/config/a;", "e", "Lcom/tencent/mobileqq/friend/config/a;", Constants.MMCCID, "()Lcom/tencent/mobileqq/friend/config/a;", "mConfig", "Lcom/tencent/mobileqq/friend/helper/a;", "f", "Lcom/tencent/mobileqq/friend/helper/a;", "E2", "()Lcom/tencent/mobileqq/friend/helper/a;", "addFrdTokenHelper", "Lcom/tencent/mobileqq/friend/processor/a;", h.F, "Lcom/tencent/mobileqq/friend/processor/a;", "mBusinessProcessorFactory", "Lcom/tencent/mobileqq/friend/processor/BaseFriendProcessor;", "i", "Ljava/util/ArrayList;", "F2", "()Ljava/util/ArrayList;", "setMBusinessProcessors", "(Ljava/util/ArrayList;)V", "mBusinessProcessors", "Lcom/tencent/mobileqq/friend/handler/recevier/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mProtocolProcessors", BdhLogUtil.LogTag.Tag_Conn, "J", "H2", "()J", ICustomDataEditor.STRING_ARRAY_PARAM_3, "(J)V", "mRequestFriendListTimestamp", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "D", "a", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FriendHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long mRequestFriendListTimestamp;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.friend.helper.a addFrdTokenHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.friend.processor.a mBusinessProcessorFactory;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<BaseFriendProcessor> mBusinessProcessors;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.friend.handler.recevier.a<FriendHandler>> mProtocolProcessors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/FriendHandler$a;", "", "", "ONLY_CHAT", "J", "QZONE_BLOCK", "QZONE_EXCLUDE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.handler.FriendHandler$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34117);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
            return;
        }
        this.mService = new b(app);
        this.mConfig = new a(app);
        this.addFrdTokenHelper = new com.tencent.mobileqq.friend.helper.a();
        com.tencent.mobileqq.friend.processor.a aVar = new com.tencent.mobileqq.friend.processor.a();
        this.mBusinessProcessorFactory = aVar;
        this.mProtocolProcessors = new ArrayList<>();
        ArrayList<BaseFriendProcessor> a16 = aVar.a(this.appRuntime);
        Intrinsics.checkNotNullExpressionValue(a16, "mBusinessProcessorFactor\u2026getProcessors(appRuntime)");
        this.mBusinessProcessors = a16;
        L2();
    }

    private final void L2() {
        ArrayList<com.tencent.mobileqq.friend.handler.recevier.a<FriendHandler>> arrayList = this.mProtocolProcessors;
        AppInterface appRuntime = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
        arrayList.add(new e(appRuntime, this));
        ArrayList<com.tencent.mobileqq.friend.handler.recevier.a<FriendHandler>> arrayList2 = this.mProtocolProcessors;
        AppInterface appRuntime2 = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime2, "appRuntime");
        arrayList2.add(new m(appRuntime2, this));
        ArrayList<com.tencent.mobileqq.friend.handler.recevier.a<FriendHandler>> arrayList3 = this.mProtocolProcessors;
        AppInterface appRuntime3 = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime3, "appRuntime");
        arrayList3.add(new d(appRuntime3, this));
        this.mProtocolProcessors.add(new k(this.appRuntime, this));
        this.mProtocolProcessors.add(new j(this.appRuntime, this));
        this.mProtocolProcessors.add(new f(this.appRuntime, this));
        this.mProtocolProcessors.add(new g(this.appRuntime, this));
        this.mProtocolProcessors.add(new AddBatchPhoneFriendReceiver(this.appRuntime, this));
        this.mProtocolProcessors.add(new com.tencent.mobileqq.friend.handler.recevier.h(this.appRuntime, this));
        this.mProtocolProcessors.add(new l(this.appRuntime, this));
        this.mProtocolProcessors.add(new c(this.appRuntime, this));
        this.mProtocolProcessors.add(new com.tencent.mobileqq.friend.handler.recevier.b(this.appRuntime, this));
        this.mProtocolProcessors.add(new i(this.appRuntime, this));
    }

    private final void O2(String friendUin, int sourceId, int subSourceId) {
        if (Intrinsics.areEqual("0", friendUin)) {
            QLog.e("IMCore.friend.FriendHandler", 1, "requestAutoInfo friendUin=0, srcId=" + sourceId + ", subSrcId=" + subSourceId);
            return;
        }
        QLog.i("IMCore.friend.FriendHandler", 1, "requestAutoInfo, srcId=" + sourceId + ", subSrcId=" + subSourceId);
    }

    @Nullable
    public final ToServiceMsg D2(@Nullable String cmd, int command, int serviceType, @Nullable byte[] bodyByte) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 28, this, cmd, Integer.valueOf(command), Integer.valueOf(serviceType), bodyByte);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(command);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(serviceType);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bodyByte));
        ToServiceMsg createToServiceMsg = createToServiceMsg(cmd);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        return createToServiceMsg;
    }

    @NotNull
    public final com.tencent.mobileqq.friend.helper.a E2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.friend.helper.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.addFrdTokenHelper;
    }

    @NotNull
    public final ArrayList<BaseFriendProcessor> F2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mBusinessProcessors;
    }

    @NotNull
    public final a G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mConfig;
    }

    public final long H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.mRequestFriendListTimestamp;
    }

    @NotNull
    public final b I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mService;
    }

    public final void J2(int startIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, startIndex);
            return;
        }
        oidb_0x1122$FetchOnlyChatPagedReq oidb_0x1122_fetchonlychatpagedreq = new oidb_0x1122$FetchOnlyChatPagedReq();
        oidb_0x1122_fetchonlychatpagedreq.start_index.set(startIndex);
        sendPbReq(D2("OidbSvcTrpcTcp.0x112b_1", 4395, 1, oidb_0x1122_fetchonlychatpagedreq.toByteArray()));
    }

    public final void K2(@NotNull List<String> uins, int startIndex, int endIndex) {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, uins, Integer.valueOf(startIndex), Integer.valueOf(endIndex));
            return;
        }
        Intrinsics.checkNotNullParameter(uins, "uins");
        List<String> list = uins;
        if (!list.isEmpty() && startIndex <= endIndex) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = startIndex; i3 < endIndex; i3++) {
                arrayList.add(Long.valueOf(Long.parseLong(uins.get(i3))));
            }
            arrayList2.add(100L);
            arrayList2.add(101L);
            arrayList2.add(102L);
            oidb_0x1122$FetchSelectReq oidb_0x1122_fetchselectreq = new oidb_0x1122$FetchSelectReq();
            oidb_0x1122_fetchselectreq.req_uins.set(arrayList);
            oidb_0x1122_fetchselectreq.req_tags.set(arrayList2);
            ToServiceMsg D2 = D2("OidbSvcTrpcTcp.0x1130_1", 4400, 1, oidb_0x1122_fetchselectreq.toByteArray());
            if (D2 != null && (bundle3 = D2.extraData) != null) {
                bundle3.putInt("qzone_permission_set_fetch_start", startIndex);
            }
            if (D2 != null && (bundle2 = D2.extraData) != null) {
                bundle2.putInt("qzone_permission_set_fetch_end", endIndex);
            }
            if (D2 != null && (bundle = D2.extraData) != null) {
                bundle.putStringArrayList("qzone_permission_set_fetch_origin_uins", new ArrayList<>(list));
            }
            sendPbReq(D2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendHandler", 2, "getPermissionSelectFriend, uins  is invalid.");
        }
    }

    public final boolean M2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendHandler", 2, "isRequestingFriendList, timestamp: " + this.mRequestFriendListTimestamp);
        }
        if (this.mRequestFriendListTimestamp > 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final oidb_0x1122$ClientExtention N2(int status) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (oidb_0x1122$ClientExtention) iPatchRedirector.redirect((short) 29, (Object) this, status);
        }
        oidb_0x1122$Permission oidb_0x1122_permission = new oidb_0x1122$Permission();
        boolean z18 = false;
        if ((status & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((status >> 1) & 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (((status >> 2) & 1) == 1) {
            z18 = true;
        }
        oidb_0x1122_permission.qzone_not_watch.set(z18);
        oidb_0x1122_permission.qzone_not_watched.set(z17);
        oidb_0x1122_permission.only_chat.set(z16);
        oidb_0x1122$ClientExtention oidb_0x1122_clientextention = new oidb_0x1122$ClientExtention();
        oidb_0x1122_clientextention.bytes_permission.set(ByteStringMicro.copyFrom(oidb_0x1122_permission.toByteArray()));
        return oidb_0x1122_clientextention;
    }

    public final void P2(@NotNull ArrayList<PhoneContact> phoneArr, @NotNull String verifyMsg, int pkgIndex, int sourceId, @Nullable ArrayList<AddBatchPhoneFriendResult> resultList) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, phoneArr, verifyMsg, Integer.valueOf(pkgIndex), Integer.valueOf(sourceId), resultList);
            return;
        }
        Intrinsics.checkNotNullParameter(phoneArr, "phoneArr");
        Intrinsics.checkNotNullParameter(verifyMsg, "verifyMsg");
        if (sourceId != 3078 && sourceId != 3079) {
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.FriendHandler", 2, "addBatchPhoneFriend, sourceId=" + sourceId + " is invalid.");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList(30);
        int i17 = pkgIndex * 30;
        int size = phoneArr.size() - i17;
        if (size > 30) {
            i3 = i17 + 30;
            i16 = pkgIndex + 1;
        } else {
            if (size == 30) {
                i3 = i17 + 30;
            } else {
                i3 = size + i17;
            }
            i16 = -1;
        }
        while (i17 < i3) {
            String str = phoneArr.get(i17).unifiedCode;
            Intrinsics.checkNotNullExpressionValue(str, "phoneArr[i].unifiedCode");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            ByteStringMicro copyFrom = ByteStringMicro.copyFrom(bytes);
            Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(phoneArr[i].unifiedCode.toByteArray())");
            arrayList.add(copyFrom);
            i17++;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("addBatchPhoneFriend sourceId:%s, pkgIndex:%s, verifyMsg:%s ", Arrays.copyOf(new Object[]{Integer.valueOf(sourceId), Integer.valueOf(pkgIndex), verifyMsg}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d("addFriendTag", 2, format);
        }
        oidb_0x829$ReqBody oidb_0x829_reqbody = new oidb_0x829$ReqBody();
        oidb_0x829_reqbody.uint32_source_id.set(sourceId);
        oidb_0x829_reqbody.uint32_sub_source_id.set(1);
        PBBytesField pBBytesField = oidb_0x829_reqbody.bytes_msg;
        byte[] bytes2 = verifyMsg.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
        pBBytesField.set(ByteStringMicro.copyFrom(bytes2));
        oidb_0x829_reqbody.rpt_bytes_mobiles.set(arrayList);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2089);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x829_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x829_1");
        createToServiceMsg.extraData.putSerializable("phones", phoneArr);
        createToServiceMsg.extraData.putInt("package", i16);
        createToServiceMsg.extraData.putString("verifyMsg", verifyMsg);
        createToServiceMsg.extraData.putSerializable("resultList", resultList);
        createToServiceMsg.extraData.putInt("sourceId", sourceId);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public final void Q2(@Nullable String friendUin, @Nullable String extraUin, int friendSetting, byte groupId, @Nullable String msg2, int sourceID, int subSourceId, @Nullable byte[] extSourceId, boolean autoSend, @Nullable byte[] sig, boolean isContactBothWay, @Nullable String remark, @Nullable String sourceName, byte myCard, @Nullable String ticket, @Nullable Bundle extraParam, boolean isSupportSecurityTips, @Nullable byte[] addFriendToken) {
        boolean z16;
        String str;
        byte b16;
        byte b17;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, friendUin, extraUin, Integer.valueOf(friendSetting), Byte.valueOf(groupId), msg2, Integer.valueOf(sourceID), Integer.valueOf(subSourceId), extSourceId, Boolean.valueOf(autoSend), sig, Boolean.valueOf(isContactBothWay), remark, sourceName, Byte.valueOf(myCard), ticket, extraParam, Boolean.valueOf(isSupportSecurityTips), addFriendToken);
            return;
        }
        if (QLog.isColorLevel()) {
            if (extraParam != null) {
                extraParam.getString("troop_uin");
            }
            StringBuilder sb5 = new StringBuilder(300);
            sb5.append("addFriendInternal, uin:");
            sb5.append(friendUin);
            sb5.append(", sourceID:");
            sb5.append(sourceID);
            sb5.append(", subSourceId:");
            sb5.append(subSourceId);
            sb5.append(", extSourceId:");
            sb5.append(extSourceId);
            sb5.append(", extraUin:");
            sb5.append(extraUin);
            sb5.append(", friendSetting:");
            sb5.append(friendSetting);
            sb5.append(", groupId:");
            b16 = groupId;
            sb5.append((int) b16);
            sb5.append(", msg:");
            sb5.append(msg2);
            sb5.append(", autoSend:");
            z16 = autoSend;
            sb5.append(z16);
            str = "troop_uin";
            sb5.append(", isContactBothWay:");
            sb5.append(isContactBothWay);
            sb5.append(", remark:");
            sb5.append(remark);
            sb5.append(", sourceName:");
            sb5.append(sourceName);
            sb5.append(", myCard:");
            b17 = myCard;
            sb5.append((int) b17);
            sb5.append(", extraParam:");
            sb5.append(extraParam);
            sb5.append(", isSupportSecurityTips:");
            sb5.append(isSupportSecurityTips);
            sb5.append(", sig:");
            sb5.append(sig != null ? Integer.valueOf(sig.length) : "null");
            sb5.append(", ticket:");
            sb5.append(ticket != null ? Integer.valueOf(ticket.length()) : "null");
            sb5.append(", token:");
            sb5.append(addFriendToken != null ? new String(addFriendToken, Charsets.UTF_8) : "");
            QLog.d("addFriendTag", 2, sb5.toString());
        } else {
            z16 = autoSend;
            str = "troop_uin";
            b16 = groupId;
            b17 = myCard;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "friendlist.addFriend");
        Bundle bundle = toServiceMsg.extraData;
        bundle.putString("uin", friendUin);
        bundle.putInt("friend_setting", friendSetting);
        bundle.putByte("group_id", b16);
        bundle.putString("msg", msg2);
        bundle.putInt("source_id", sourceID);
        bundle.putByte("show_my_card", b17);
        bundle.putInt("sub_source_id", subSourceId);
        bundle.putString("extra", extraUin);
        bundle.putBoolean("auto_send", z16);
        bundle.putByteArray(PreloadTRTCPlayerParams.KEY_SIG, sig);
        bundle.putBoolean("contact_bothway", isContactBothWay);
        bundle.putString("remark", remark);
        bundle.putString("src_name", sourceName);
        bundle.putByteArray("third_source_id", extSourceId);
        if (extraParam != null) {
            String str2 = str;
            bundle.putString(str2, extraParam.getString(str2));
            bundle.putString(AppConstants.Key.TROOP_CODE, extraParam.getString(AppConstants.Key.TROOP_CODE));
            bundle.putInt("flc_notify_type", extraParam.getInt("flc_notify_type"));
            bundle.putString("flc_recommend_uin", extraParam.getString("flc_recommend_uin"));
            z17 = false;
            bundle.putByteArray("friend_permission_byte_array", N2(extraParam.getInt("friend_permission", 0)).toByteArray());
            byte[] byteArray = extraParam.getByteArray("friend_src_desc");
            if (byteArray != null) {
                bundle.putByteArray("friend_src_desc", byteArray);
            }
        } else {
            z17 = false;
        }
        byte[] b18 = addFriendToken == null ? this.addFrdTokenHelper.b(friendUin, sourceID, subSourceId) : addFriendToken;
        if (b18 != null) {
            if (b18.length == 0) {
                z17 = true;
            }
            if (!z17) {
                bundle.putByteArray("flc_add_frd_token", b18);
            }
        }
        bundle.putString("security_ticket", ticket);
        bundle.putBoolean("security_ticket_support", isSupportSecurityTips);
        this.mService.f(toServiceMsg);
    }

    public final void R2(@Nullable String friendUin, int sourceId, int subSourceId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, friendUin, Integer.valueOf(sourceId), Integer.valueOf(subSourceId));
            return;
        }
        O2(friendUin, sourceId, subSourceId);
        ToServiceMsg request = createToServiceMsg("friendlist.GetAutoInfoReq");
        request.extraData.putString("uin", friendUin);
        request.extraData.putByte("cType", (byte) 1);
        request.extraData.putInt("source_id", sourceId);
        request.extraData.putInt("sub_source_id", subSourceId);
        b bVar = this.mService;
        Intrinsics.checkNotNullExpressionValue(request, "request");
        bVar.f(request);
    }

    public final void S2(@NotNull GroupRequestData requestData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) requestData);
            return;
        }
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendHandler", 2, "requestFriendGroup| requestData: " + requestData);
        }
        ToServiceMsg request = createToServiceMsg("friendlist.SetGroupReq");
        request.extraData.putSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName(), requestData);
        b bVar = this.mService;
        Intrinsics.checkNotNullExpressionValue(request, "request");
        bVar.f(request);
    }

    public final void T2(@NotNull FriendListRequestData requestData, boolean checkFreq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, requestData, Boolean.valueOf(checkFreq));
            return;
        }
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "requestFriendList| requestData: " + requestData + ", checkFreq: " + checkFreq);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!requestData.isRequestSingle()) {
            if (checkFreq && M2() && currentTimeMillis - this.mRequestFriendListTimestamp < MiniBoxNoticeInfo.MIN_5) {
                QLog.d("IMCore.friend.FriendHandler", 1, "requestFriendList| request too busy");
                return;
            }
            this.mRequestFriendListTimestamp = currentTimeMillis;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("friendlist.getFriendGroupList");
        Intrinsics.checkNotNullExpressionValue(createToServiceMsg, "createToServiceMsg(Frien\u2026MD.GET_FRIEND_GROUP_LIST)");
        createToServiceMsg.setEnableFastResend(true);
        createToServiceMsg.extraData.putSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName(), requestData);
        this.mService.f(createToServiceMsg);
    }

    public final void U2(@NotNull String openId, @NotNull String appId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) openId, (Object) appId);
            return;
        }
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendHandler", 2, "infoOpenId " + openId + ", " + appId);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1505);
        oidb_sso_oidbssopkg.uint32_service_type.set(8);
        oidb_0x5e1$ReqBody oidb_0x5e1_reqbody = new oidb_0x5e1$ReqBody();
        PBRepeatField<ByteStringMicro> pBRepeatField = oidb_0x5e1_reqbody.rpt_bytes_openid;
        byte[] bytes = openId.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        pBRepeatField.add(ByteStringMicro.copyFrom(bytes));
        oidb_0x5e1_reqbody.uint32_appid.set((int) Long.parseLong(appId));
        oidb_0x5e1_reqbody.uint32_req_nick.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5e1_reqbody.toByteArray()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x5e1_8");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        toServiceMsg.extraData.putString("uin", openId);
        sendPbReq(toServiceMsg);
    }

    public final void V2(@NotNull List<String> openIdList, @NotNull String appId, @NotNull ResultReceiver receiver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, openIdList, appId, receiver);
            return;
        }
        Intrinsics.checkNotNullParameter(openIdList, "openIdList");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendHandler", 2, "requestIsFriendByOpenIdFromZPlan " + openIdList + ", " + appId);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4346);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_0x10fa$IsFriendBatchReq oidb_0x10fa_isfriendbatchreq = new oidb_0x10fa$IsFriendBatchReq();
        oidb_0x10fa_isfriendbatchreq.appid.set(Integer.parseInt(appId));
        oidb_0x10fa_isfriendbatchreq.openids.set(openIdList);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x10fa_isfriendbatchreq.toByteArray()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvcTrpcTcp.0x10fa");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        toServiceMsg.extraData.putBoolean("isFromZPlan", true);
        toServiceMsg.extraData.putParcelable("zplanResultReceiver", receiver);
        sendPbReq(toServiceMsg);
    }

    public final void W2(long uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, uin);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendHandler", 2, "requestUinSafetyFlag " + uin);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(com.tencent.luggage.wxa.yh.c.CTRL_INDEX);
        oidb_sso_oidbssopkg.uint32_service_type.set(147);
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.putShort((short) 1);
        allocate.putInt((int) uin);
        oidb_sso_oidbssopkg.bytes_bodybuffer.setHasFlag(true);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x476_147");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        toServiceMsg.extraData.putLong("uin", uin);
        sendPbReq(toServiceMsg);
    }

    public final void X2(@NotNull String uin, int sourceID, int sourceSubID, @Nullable String extraUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, uin, Integer.valueOf(sourceID), Integer.valueOf(sourceSubID), extraUin);
        } else {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Y2(uin, sourceID, sourceSubID, extraUin, 0);
        }
    }

    public final void Y2(@NotNull String uin, int sourceID, int sourceSubID, @Nullable String extraUin, int ranKey) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, uin, Integer.valueOf(sourceID), Integer.valueOf(sourceSubID), extraUin, Integer.valueOf(ranKey));
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendHandler", 2, "getUserAddFriendSetting " + uin + ", " + sourceID + ", " + extraUin);
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "friendlist.getUserAddFriendSetting");
        toServiceMsg.extraData.putString("uin", uin);
        toServiceMsg.extraData.putInt("source_id", sourceID);
        toServiceMsg.extraData.putInt("sub_source_id", sourceSubID);
        toServiceMsg.extraData.putInt("random_key", ranKey);
        if (extraUin != null) {
            if (extraUin.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                toServiceMsg.extraData.putString("extra", extraUin);
            }
        }
        this.mService.f(toServiceMsg);
    }

    public final void Z2(@NotNull List<String> uins, int status) {
        Bundle bundle;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) uins, status);
            return;
        }
        Intrinsics.checkNotNullParameter(uins, "uins");
        if (!uins.isEmpty() && status >= 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : uins) {
                QLog.i("IMCore.friend.FriendHandler", 1, "getPermissionSelectFriend, uins : " + str);
                oidb_0x1122$UserPermission oidb_0x1122_userpermission = new oidb_0x1122$UserPermission();
                oidb_0x1122$Permission oidb_0x1122_permission = new oidb_0x1122$Permission();
                boolean z18 = false;
                if ((status & 1) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (((status >> 1) & 1) == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (((status >> 2) & 1) == 1) {
                    z18 = true;
                }
                oidb_0x1122_permission.qzone_not_watch.set(z18);
                oidb_0x1122_permission.qzone_not_watched.set(z17);
                oidb_0x1122_permission.only_chat.set(z16);
                oidb_0x1122_userpermission.uin.set(Long.parseLong(str));
                oidb_0x1122_userpermission.perm.set(oidb_0x1122_permission);
                arrayList.add(oidb_0x1122_userpermission);
            }
            QLog.i("IMCore.friend.FriendHandler", 2, "setBatchFriendPermission \uff5c setBatchFriendPermission: " + status);
            oidb_0x1122$SetReq oidb_0x1122_setreq = new oidb_0x1122$SetReq();
            oidb_0x1122_setreq.domain.set(1);
            oidb_0x1122_setreq.user_perms.set(arrayList);
            ToServiceMsg D2 = D2("OidbSvcTrpcTcp.0x1122_1", 4386, 1, oidb_0x1122_setreq.toByteArray());
            if (D2 != null && (bundle = D2.extraData) != null) {
                bundle.putInt("qzone_permission_status", status);
            }
            sendPbReq(D2);
            return;
        }
        QLog.e("IMCore.friend.FriendHandler", 1, "setQZonePermission, uins or status is invalid.");
    }

    public final void a3(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.mRequestFriendListTimestamp = j3;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("friendlist.addFriend");
            this.allowCmdSet.add("OidbSvc.0x476_147");
            this.allowCmdSet.add("friendlist.getUserAddFriendSetting");
            this.allowCmdSet.add("friendlist.GetAutoInfoReq");
            this.allowCmdSet.add("OidbSvc.0x5e1_8");
            this.allowCmdSet.add("OidbSvc.0x829_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x10fa");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x1122_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x1130_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x112b_1");
            this.allowCmdSet.add("OidbSvc.0x5e1_414");
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Class) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return com.tencent.mobileqq.friend.observer.b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<BaseFriendProcessor> it = this.mBusinessProcessors.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.mBusinessProcessors.clear();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, req, res, data);
            return;
        }
        if (req != null && res != null) {
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.FriendHandler", 2, "onReceive| " + req.getServiceCmd());
            }
            Iterator<com.tencent.mobileqq.friend.handler.recevier.a<FriendHandler>> it = this.mProtocolProcessors.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.friend.handler.recevier.a<FriendHandler> next = it.next();
                String serviceCmd = req.getServiceCmd();
                Intrinsics.checkNotNullExpressionValue(serviceCmd, "req.serviceCmd");
                if (next.a(serviceCmd)) {
                    next.e(req, res, data);
                }
            }
            return;
        }
        QLog.e("IMCore.friend.FriendHandler", 1, "onReceive| req == null || res == null");
    }
}
