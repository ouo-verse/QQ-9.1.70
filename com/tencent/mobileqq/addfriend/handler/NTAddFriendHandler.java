package com.tencent.mobileqq.addfriend.handler;

import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.addfriend.api.BusinessNTHandler;
import com.tencent.mobileqq.addfriend.api.impl.j;
import com.tencent.mobileqq.addfriend.handler.receiver.a;
import com.tencent.mobileqq.addfriend.handler.receiver.f;
import com.tencent.mobileqq.addfriend.handler.receiver.g;
import com.tencent.mobileqq.addfriend.handler.receiver.i;
import com.tencent.mobileqq.addfriend.handler.receiver.k;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.remote.b;
import com.tencent.qqnt.remote.c;
import com.tencent.qqnt.remote.d;
import com.tenpay.realname.RealNameSource;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$ClientExtention;
import tencent.im.oidb.cmd0x1122.oidb_0x1122$Permission;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0001`B\u0011\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u00b4\u0001\u0010\u001f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016J&\u0010*\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0+H\u0014J\"\u00100\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u0004J \u00104\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u00103\u001a\u000202J(\u00105\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J@\u00109\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u00108\u001a\u00020\u0006J\u0016\u0010:\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u00103\u001a\u000202J\u008c\u0001\u0010;\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0012J\u00b2\u0001\u0010=\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010<\u001a\u0004\u0018\u00010\u0010J\u000e\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020\u0006J\b\u0010A\u001a\u00020\u0002H\u0016R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR0\u0010K\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000G0Fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000G`H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR2\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020T0Fj\b\u0012\u0004\u0012\u00020T`H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010J\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler;", "Lcom/tencent/mobileqq/addfriend/api/BusinessNTHandler;", "", "E2", "", "friendUin", "", "sourceId", "subSourceId", "H2", "callFrom", "extraUin", "friendSetting", "groupId", "msg", "sourceID", "", "extSourceId", "", "autoSend", PreloadTRTCPlayerParams.KEY_SIG, "isContactBothWay", "remark", RealNameSource.EXTRA_KEY_SOURCE_NAME, "", "myCard", "ticket", "Landroid/os/Bundle;", "extraParam", "isSupportSecurityTips", "addFriendToken", "J2", "Lcom/tencent/qqnt/remote/d;", "req", "Lcom/tencent/qqnt/remote/b;", "resp", "F2", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "openId", "appId", "M2", "uid", "", "uin", "K2", "N2", "type", "sourceSubID", "ranKey", "P2", "O2", "I2", "token", "L2", "status", "Ltencent/im/oidb/cmd0x1122/oidb_0x1122$ClientExtention;", Constants.MMCCID, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/remote/c;", "d", "Lcom/tencent/qqnt/remote/c;", "ntServlet", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/addfriend/handler/receiver/a;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "mNtReceivers", "Lcom/tencent/mobileqq/friend/processor/a;", "f", "Lcom/tencent/mobileqq/friend/processor/a;", "mBusinessProcessorFactory", "Lcom/tencent/mobileqq/friend/helper/a;", h.F, "Lcom/tencent/mobileqq/friend/helper/a;", "addFrdTokenHelper", "Lcom/tencent/mobileqq/friend/processor/BaseFriendProcessor;", "i", Constants.BASE_IN_PLUGIN_VERSION, "()Ljava/util/ArrayList;", "setMBusinessProcessors", "(Ljava/util/ArrayList;)V", "mBusinessProcessors", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class NTAddFriendHandler extends BusinessNTHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c ntServlet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<a<NTAddFriendHandler>> mNtReceivers;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.friend.processor.a mBusinessProcessorFactory;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.friend.helper.a addFrdTokenHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<BaseFriendProcessor> mBusinessProcessors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/handler/NTAddFriendHandler$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20999);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTAddFriendHandler(@Nullable AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.ntServlet = new j();
        this.mNtReceivers = new ArrayList<>();
        com.tencent.mobileqq.friend.processor.a aVar = new com.tencent.mobileqq.friend.processor.a();
        this.mBusinessProcessorFactory = aVar;
        this.addFrdTokenHelper = new com.tencent.mobileqq.friend.helper.a();
        ArrayList<BaseFriendProcessor> a16 = aVar.a(this.appRuntime);
        Intrinsics.checkNotNullExpressionValue(a16, "mBusinessProcessorFactor\u2026getProcessors(appRuntime)");
        this.mBusinessProcessors = a16;
        E2();
    }

    private final void E2() {
        ArrayList<a<NTAddFriendHandler>> arrayList = this.mNtReceivers;
        AppInterface appRuntime = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
        arrayList.add(new com.tencent.mobileqq.addfriend.handler.receiver.j(appRuntime, this));
        ArrayList<a<NTAddFriendHandler>> arrayList2 = this.mNtReceivers;
        AppInterface appRuntime2 = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime2, "appRuntime");
        arrayList2.add(new f(appRuntime2, this));
        ArrayList<a<NTAddFriendHandler>> arrayList3 = this.mNtReceivers;
        AppInterface appRuntime3 = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime3, "appRuntime");
        arrayList3.add(new k(appRuntime3, this));
        ArrayList<a<NTAddFriendHandler>> arrayList4 = this.mNtReceivers;
        AppInterface appRuntime4 = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime4, "appRuntime");
        arrayList4.add(new i(appRuntime4, this));
        ArrayList<a<NTAddFriendHandler>> arrayList5 = this.mNtReceivers;
        AppInterface appRuntime5 = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime5, "appRuntime");
        arrayList5.add(new com.tencent.mobileqq.addfriend.handler.receiver.h(appRuntime5, this));
        ArrayList<a<NTAddFriendHandler>> arrayList6 = this.mNtReceivers;
        AppInterface appRuntime6 = this.appRuntime;
        Intrinsics.checkNotNullExpressionValue(appRuntime6, "appRuntime");
        arrayList6.add(new g(appRuntime6, this));
    }

    private final void H2(String friendUin, int sourceId, int subSourceId) {
        if (Intrinsics.areEqual("0", friendUin)) {
            QLog.e("NTAddFriendHandler", 1, "requestSmartInfo friendUin=0, srcId=" + sourceId + ", subSrcId=" + subSourceId);
            return;
        }
        QLog.i("NTAddFriendHandler", 1, "requestSmartInfo, srcId=" + sourceId + ", subSrcId=" + subSourceId);
    }

    private final void J2(String callFrom, String friendUin, String extraUin, int friendSetting, int groupId, String msg2, int sourceID, int subSourceId, byte[] extSourceId, boolean autoSend, byte[] sig, boolean isContactBothWay, String remark, String sourceName, byte myCard, String ticket, Bundle extraParam, boolean isSupportSecurityTips, byte[] addFriendToken) {
        byte[] bArr;
        String str;
        NTAddFriendHandler nTAddFriendHandler;
        String str2;
        if (QLog.isColorLevel()) {
            if (extraParam != null) {
                extraParam.getString("troop_uin");
            }
            str = "troop_uin";
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
            sb5.append(groupId);
            sb5.append(", msg:");
            sb5.append(msg2);
            sb5.append(", autoSend:");
            sb5.append(autoSend);
            sb5.append(", isContactBothWay:");
            sb5.append(isContactBothWay);
            sb5.append(", remark:");
            sb5.append(remark);
            sb5.append(", sourceName:");
            sb5.append(sourceName);
            sb5.append(", myCard:");
            sb5.append((int) myCard);
            sb5.append(", extraParam:");
            sb5.append(extraParam);
            sb5.append(", isSupportSecurityTips:");
            sb5.append(isSupportSecurityTips);
            sb5.append(", sig:");
            str2 = "null";
            bArr = sig;
            sb5.append(bArr != null ? Integer.valueOf(bArr.length) : str2);
            sb5.append(", ticket:");
            sb5.append(ticket != null ? Integer.valueOf(ticket.length()) : "null");
            sb5.append(", token:");
            sb5.append(addFriendToken != null ? new String(addFriendToken, Charsets.UTF_8) : "");
            QLog.d("NTAddFriendHandler", 2, cq.w(sb5.toString(), 2));
        } else {
            bArr = sig;
            str = "troop_uin";
        }
        d dVar = new d("mobileqq.service", this.appRuntime.getAccount(), com.tencent.mobileqq.addfriend.api.a.INSTANCE.a());
        Bundle a16 = dVar.a();
        a16.putString("uin", friendUin);
        a16.putInt("friend_setting", friendSetting);
        a16.putInt("group_id", groupId);
        a16.putString("msg", msg2);
        a16.putInt("source_id", sourceID);
        a16.putByte("show_my_card", myCard);
        a16.putInt("sub_source_id", subSourceId);
        a16.putString("extra", extraUin);
        a16.putBoolean("auto_send", autoSend);
        a16.putByteArray(PreloadTRTCPlayerParams.KEY_SIG, bArr);
        a16.putBoolean("contact_bothway", isContactBothWay);
        a16.putString("remark", remark);
        a16.putString("src_name", sourceName);
        a16.putByteArray("third_source_id", extSourceId);
        if (extraParam != null) {
            String str3 = str;
            a16.putString(str3, extraParam.getString(str3));
            a16.putString(AppConstants.Key.TROOP_CODE, extraParam.getString(AppConstants.Key.TROOP_CODE));
            a16.putInt("flc_notify_type", extraParam.getInt("flc_notify_type"));
            a16.putString("flc_recommend_uin", extraParam.getString("flc_recommend_uin"));
            nTAddFriendHandler = this;
            a16.putByteArray("friend_permission_byte_array", nTAddFriendHandler.G2(extraParam.getInt("friend_permission", 0)).toByteArray());
            byte[] byteArray = extraParam.getByteArray("friend_src_desc");
            if (byteArray != null) {
                a16.putByteArray("friend_src_desc", byteArray);
            }
            a16.putInt("type", extraParam.getInt("k_uin_type"));
        } else {
            nTAddFriendHandler = this;
        }
        byte[] b16 = addFriendToken == null ? nTAddFriendHandler.addFrdTokenHelper.b(friendUin, sourceID, subSourceId) : addFriendToken;
        if (b16 != null) {
            if (!(b16.length == 0)) {
                a16.putByteArray("flc_add_frd_token", b16);
            }
        }
        a16.putString("security_ticket", ticket);
        a16.putBoolean("security_ticket_support", isSupportSecurityTips);
        nTAddFriendHandler.ntServlet.a(callFrom, dVar);
    }

    @NotNull
    public final ArrayList<BaseFriendProcessor> D2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mBusinessProcessors;
    }

    public void F2(@NotNull d req, @NotNull b resp) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req, (Object) resp);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive| ");
            sb5.append(req.b());
            sb5.append("  msg:");
            Object a16 = resp.a();
            if (a16 != null) {
                str = a16.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            QLog.d("NTAddFriendHandler", 2, sb5.toString());
        }
        Iterator<a<NTAddFriendHandler>> it = this.mNtReceivers.iterator();
        while (it.hasNext()) {
            a<NTAddFriendHandler> next = it.next();
            if (next.a(req.b())) {
                next.d(req, resp);
            }
        }
    }

    @NotNull
    public final oidb_0x1122$ClientExtention G2(int status) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (oidb_0x1122$ClientExtention) iPatchRedirector.redirect((short) 17, (Object) this, status);
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

    public final void I2(@NotNull String callFrom, @Nullable String friendUin, @Nullable String extraUin, int friendSetting, int groupId, @Nullable String msg2, int sourceID, int subSourceId, boolean autoSend, @Nullable byte[] sig, boolean isContactBothWay, @Nullable String remark, @Nullable String sourceName, @Nullable Bundle extraParam, boolean isSupportSecurityTips) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, callFrom, friendUin, extraUin, Integer.valueOf(friendSetting), Integer.valueOf(groupId), msg2, Integer.valueOf(sourceID), Integer.valueOf(subSourceId), Boolean.valueOf(autoSend), sig, Boolean.valueOf(isContactBothWay), remark, sourceName, extraParam, Boolean.valueOf(isSupportSecurityTips));
        } else {
            Intrinsics.checkNotNullParameter(callFrom, "callFrom");
            J2(callFrom, friendUin, extraUin, friendSetting, groupId, msg2, sourceID, subSourceId, null, autoSend, sig, isContactBothWay, remark, sourceName, (byte) 0, "", extraParam, isSupportSecurityTips, null);
        }
    }

    public final void K2(@NotNull String callFrom, @Nullable String uid, long uin) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, callFrom, uid, Long.valueOf(uin));
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        if (QLog.isColorLevel()) {
            QLog.d("NTAddFriendHandler", 2, "call from " + callFrom + ", requestAddFriendTag " + uin + ", " + uid);
        }
        String b16 = this.ntServlet.b();
        AppInterface appInterface = this.appRuntime;
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        d dVar = new d(b16, str, com.tencent.mobileqq.addfriend.api.a.INSTANCE.g());
        dVar.a().putLong("uin", uin);
        dVar.a().putString("uid", uid);
        this.ntServlet.a(callFrom, dVar);
    }

    public final void L2(@NotNull String callFrom, @Nullable String friendUin, @Nullable String extraUin, int friendSetting, int groupId, @Nullable String msg2, int sourceID, int subSourceId, @Nullable byte[] extSourceId, boolean autoSend, @Nullable byte[] sig, boolean isContactBothWay, @Nullable String remark, @Nullable String sourceName, byte myCard, @Nullable String ticket, @Nullable Bundle extraParam, boolean isSupportSecurityTips, @Nullable byte[] token) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, callFrom, friendUin, extraUin, Integer.valueOf(friendSetting), Integer.valueOf(groupId), msg2, Integer.valueOf(sourceID), Integer.valueOf(subSourceId), extSourceId, Boolean.valueOf(autoSend), sig, Boolean.valueOf(isContactBothWay), remark, sourceName, Byte.valueOf(myCard), ticket, extraParam, Boolean.valueOf(isSupportSecurityTips), token);
        } else {
            Intrinsics.checkNotNullParameter(callFrom, "callFrom");
            J2(callFrom, friendUin, extraUin, friendSetting, groupId, msg2, sourceID, subSourceId, extSourceId, autoSend, sig, isContactBothWay, remark, sourceName, myCard, ticket, extraParam, isSupportSecurityTips, token);
        }
    }

    public final void M2(@NotNull String callFrom, @Nullable String openId, @Nullable String appId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, callFrom, openId, appId);
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        if (QLog.isColorLevel()) {
            QLog.d("NTAddFriendHandler", 2, "call from " + callFrom + ", requestAddFriendTag " + openId + ", " + appId);
        }
        String b16 = this.ntServlet.b();
        AppInterface appInterface = this.appRuntime;
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        d dVar = new d(b16, str, com.tencent.mobileqq.addfriend.api.a.INSTANCE.f());
        dVar.a().putString("uin", openId);
        dVar.a().putString("extra", appId);
        this.ntServlet.a(callFrom, dVar);
    }

    public final void N2(@NotNull String callFrom, @Nullable String friendUin, int sourceId, int subSourceId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, callFrom, friendUin, Integer.valueOf(sourceId), Integer.valueOf(subSourceId));
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        H2(friendUin, sourceId, subSourceId);
        String b16 = this.ntServlet.b();
        AppInterface appInterface = this.appRuntime;
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        d dVar = new d(b16, str, com.tencent.mobileqq.addfriend.api.a.INSTANCE.d());
        dVar.a().putString("uin", friendUin);
        this.ntServlet.a(callFrom, dVar);
    }

    public final void O2(@NotNull String callFrom, long uin) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, callFrom, Long.valueOf(uin));
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        if (QLog.isColorLevel()) {
            QLog.d("NTAddFriendHandler", 2, "call from " + callFrom + ",requestUinSafetyFlag " + uin);
        }
        String b16 = this.ntServlet.b();
        AppInterface appInterface = this.appRuntime;
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        d dVar = new d(b16, str, com.tencent.mobileqq.addfriend.api.a.INSTANCE.c());
        dVar.a().putLong("uin", uin);
        this.ntServlet.a(callFrom, dVar);
    }

    public final void P2(@NotNull String callFrom, @NotNull String uin, int type, int sourceID, int sourceSubID, @Nullable String extraUin, int ranKey) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, callFrom, uin, Integer.valueOf(type), Integer.valueOf(sourceID), Integer.valueOf(sourceSubID), extraUin, Integer.valueOf(ranKey));
            return;
        }
        Intrinsics.checkNotNullParameter(callFrom, "callFrom");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (QLog.isColorLevel()) {
            QLog.d("NTAddFriendHandler", 2, "call from " + callFrom + ",requestUserAddFriendSetting " + uin + ", " + sourceID + ", " + extraUin);
        }
        String b16 = this.ntServlet.b();
        AppInterface appInterface = this.appRuntime;
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        d dVar = new d(b16, str, com.tencent.mobileqq.addfriend.api.a.INSTANCE.b());
        dVar.a().putString("uin", uin);
        dVar.a().putInt("type", type);
        dVar.a().putInt("source_id", sourceID);
        dVar.a().putInt("sub_source_id", sourceSubID);
        dVar.a().putInt("random_key", ranKey);
        if (extraUin != null) {
            if (extraUin.length() <= 0) {
                z16 = false;
            }
            if (z16) {
                dVar.a().putString("extra", extraUin);
            }
        }
        this.ntServlet.a(callFrom, dVar);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return com.tencent.mobileqq.addfriend.observer.a.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, req, res, data);
        }
    }
}
