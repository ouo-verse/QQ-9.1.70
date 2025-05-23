package com.tencent.qqnt.aio.settings;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.settings.NTFriendSettingHelper;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SpecialCareSetting;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001;B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J(\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002J5\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002J\u001a\u0010!\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0017H\u0002J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0016\u0010'\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0002J\u0016\u0010(\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0%H\u0002J#\u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00172\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bJ.\u00100\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.J\u000e\u00101\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bJ\u0018\u00103\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u00102\u001a\u00020\nJ5\u00108\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n04H\u0007\u00a8\u0006<"}, d2 = {"Lcom/tencent/qqnt/aio/settings/NTFriendSettingHelper;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/qqnt/kernel/api/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/api/w;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/aio/settings/NTFriendSettingHelper$a;", "params", "", "r", "isSuccess", "", "errMsg", "", "B", "isRingOn", "isZoneOn", "J", "G", "H", "I", "", QQBrowserActivity.KEY_MSG_TYPE, "", "data", "K", "(Lcom/tencent/mobileqq/app/QQAppInterface;IZ[Ljava/lang/Object;)V", UserInfo.SEX_FEMALE, "E", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "friendUin", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uinType", "Z", "D", "Lkotlin/Function0;", "runnable", ReportConstant.COSTREPORT_PREFIX, "L", "stringRes", "toastType", "X", "(ILjava/lang/Integer;)V", "N", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "U", ExifInterface.LATITUDE_SOUTH, "isReqServer", "P", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "checkParamsInvalid", "v", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NTFriendSettingHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NTFriendSettingHelper f352067a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u000e\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/settings/NTFriendSettingHelper$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/app/QQAppInterface;", "a", "Lcom/tencent/mobileqq/app/QQAppInterface;", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uin", "c", "uid", "Z", "e", "()Z", "f", "(Z)V", "isSwitch", "I", "()I", "type", "<init>", "(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ZI)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final QQAppInterface app;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String uin;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String uid;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isSwitch;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int type;

        public a(@Nullable QQAppInterface qQAppInterface, @Nullable String str, @Nullable String str2, boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            this.app = qQAppInterface;
            this.uin = str;
            this.uid = str2;
            this.isSwitch = z16;
            this.type = i3;
        }

        @Nullable
        public final QQAppInterface a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQAppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.app;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.type;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.uid;
        }

        @Nullable
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.uin;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.isSwitch;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.app, aVar.app) && Intrinsics.areEqual(this.uin, aVar.uin) && Intrinsics.areEqual(this.uid, aVar.uid) && this.isSwitch == aVar.isSwitch && this.type == aVar.type) {
                return true;
            }
            return false;
        }

        public final void f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, z16);
            } else {
                this.isSwitch = z16;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            QQAppInterface qQAppInterface = this.app;
            int i3 = 0;
            if (qQAppInterface == null) {
                hashCode = 0;
            } else {
                hashCode = qQAppInterface.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.uin;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.uid;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            int i18 = (i17 + i3) * 31;
            boolean z16 = this.isSwitch;
            int i19 = z16;
            if (z16 != 0) {
                i19 = 1;
            }
            return ((i18 + i19) * 31) + this.type;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "ParamsBean(app=" + this.app + ", uin=" + this.uin + ", uid=" + this.uid + ", isSwitch=" + this.isSwitch + ", type=" + this.type + ")";
        }

        public /* synthetic */ a(QQAppInterface qQAppInterface, String str, String str2, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(qQAppInterface, str, str2, z16, (i16 & 16) != 0 ? 0 : i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, str, str2, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/settings/NTFriendSettingHelper$b", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f352073a;

        b(a aVar) {
            this.f352073a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> responseData) {
            String str;
            QQMessageFacade messageFacade;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            QQAppInterface a16 = this.f352073a.a();
            if (a16 != null) {
                str = a16.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String qqStr = HardCodeUtil.qqStr(R.string.ms6);
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            MessageRecord d16 = q.d(MessageRecord.MSG_TYPE_SHIELD_MSG);
            d16.init(str, this.f352073a.d(), str, qqStr, K0, 0, 0, K0);
            d16.msgtype = MessageRecord.MSG_TYPE_SHIELD_MSG;
            d16.isread = true;
            QQAppInterface a17 = this.f352073a.a();
            if (a17 != null && (messageFacade = a17.getMessageFacade()) != null) {
                messageFacade.c(d16, str);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/settings/NTFriendSettingHelper$c", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.ntrelation.otherinfo.bean.c f352074a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f352075b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f352076c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/settings/NTFriendSettingHelper$c$a", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes23.dex */
        public static final class a implements hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f352077a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f352078b;

            a(a aVar, boolean z16) {
                this.f352077a = aVar;
                this.f352078b = z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, aVar, Boolean.valueOf(z16));
                }
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> responseData) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                    return;
                }
                com.tencent.mobileqq.activity.specialcare.e.t(this.f352077a.d(), "1", this.f352077a.a());
                NTFriendSettingHelper nTFriendSettingHelper = NTFriendSettingHelper.f352067a;
                QQAppInterface a16 = this.f352077a.a();
                Intrinsics.checkNotNull(a16);
                nTFriendSettingHelper.K(a16, 92, this.f352078b, new Object[]{1, new String[]{this.f352077a.d()}, new boolean[]{this.f352077a.e()}});
            }
        }

        c(com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar, a aVar, boolean z16) {
            this.f352074a = cVar;
            this.f352075b = aVar;
            this.f352076c = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, cVar, aVar, Boolean.valueOf(z16));
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
            } else {
                ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(this.f352074a, "NTFriendSettingHelper", new a(this.f352075b, this.f352076c));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/settings/NTFriendSettingHelper$d", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f352079a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f352080b;

        d(a aVar, boolean z16) {
            this.f352079a = aVar;
            this.f352080b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Boolean.valueOf(z16));
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            NTFriendSettingHelper nTFriendSettingHelper = NTFriendSettingHelper.f352067a;
            QQAppInterface a16 = this.f352079a.a();
            Intrinsics.checkNotNull(a16);
            nTFriendSettingHelper.K(a16, 94, this.f352080b, new Object[]{3, new String[]{this.f352079a.d()}, new boolean[]{this.f352079a.e()}});
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/settings/NTFriendSettingHelper$e", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class e implements hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f352081a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f352082b;

        e(a aVar, boolean z16) {
            this.f352081a = aVar;
            this.f352082b = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, aVar, Boolean.valueOf(z16));
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            if (this.f352081a.e()) {
                com.tencent.mobileqq.activity.specialcare.e.t(this.f352081a.d(), "1", this.f352081a.a());
            }
            NTFriendSettingHelper nTFriendSettingHelper = NTFriendSettingHelper.f352067a;
            QQAppInterface a16 = this.f352081a.a();
            Intrinsics.checkNotNull(a16);
            nTFriendSettingHelper.K(a16, 93, this.f352082b, new Object[]{2, new String[]{this.f352081a.d()}, new boolean[]{this.f352081a.e()}});
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63802);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f352067a = new NTFriendSettingHelper();
        }
    }

    NTFriendSettingHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final w A(QQAppInterface app) {
        return ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getMsgService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(a params, boolean isSuccess, String errMsg) {
        if (r(params)) {
            return;
        }
        if (isSuccess) {
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(params.d());
            QRouteApi api = QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(\n                IFr\u2026:class.java\n            )");
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) api;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            String d16 = params.d();
            if (d16 == null) {
                d16 = "";
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uid, d16);
            dVar.M();
            dVar.r0(params.e());
            iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(dVar, "NTFriendSettingHelper", new b(params));
            if (!params.e()) {
                QQAppInterface a16 = params.a();
                Intrinsics.checkNotNull(a16);
                w A = A(a16);
                if (A != null) {
                    String c16 = params.c();
                    Intrinsics.checkNotNull(c16);
                    A.setMsgRead(new Contact(1, c16, ""), new IOperateCallback() { // from class: com.tencent.qqnt.aio.settings.i
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                        public final void onResult(int i3, String str) {
                            NTFriendSettingHelper.C(i3, str);
                        }
                    });
                }
            }
        }
        QQAppInterface a17 = params.a();
        Intrinsics.checkNotNull(a17);
        String d17 = params.d();
        Intrinsics.checkNotNull(d17);
        K(a17, 54, isSuccess, new Object[]{Long.valueOf(Long.parseLong(d17)), Boolean.valueOf(params.e()), Boolean.valueOf(isSuccess), Boolean.FALSE, errMsg});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("NTFriendSettingHelper", 1, "[handleBlockResp] setMsgRead: result=" + i3 + ", errMsg=" + msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(a params, boolean isSuccess) {
        if (isSuccess) {
            s(NTFriendSettingHelper$handleClearMsgResp$1.INSTANCE);
        } else {
            s(NTFriendSettingHelper$handleClearMsgResp$2.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(a params, boolean isSuccess) {
        if (r(params)) {
            return;
        }
        if (isSuccess) {
            q(params.e(), params.d());
            return;
        }
        Q(this, new a(params.a(), params.d(), params.c(), !params.e(), 0, 16, null), false, 2, null);
        FriendsStatusUtil.x(params.a());
        s(NTFriendSettingHelper$handleMsgNotifyResp$1.INSTANCE);
    }

    private final void F(a params, boolean isSuccess) {
        long j3;
        if (r(params)) {
            return;
        }
        if (isSuccess) {
            QQAppInterface a16 = params.a();
            Intrinsics.checkNotNull(a16);
            String d16 = params.d();
            Intrinsics.checkNotNull(d16);
            int b16 = params.b();
            if (params.e()) {
                j3 = com.tencent.mobileqq.service.message.e.K0();
            } else {
                j3 = 0;
            }
            FriendsStatusUtil.v(a16, d16, b16, j3, true, true);
            return;
        }
        QQAppInterface a17 = params.a();
        Intrinsics.checkNotNull(a17);
        String d17 = params.d();
        Intrinsics.checkNotNull(d17);
        FriendsStatusUtil.l(a17, d17);
        s(NTFriendSettingHelper$handleSetTopResp$1.INSTANCE);
    }

    private final void G(a params, boolean isSuccess) {
        if (isSuccess) {
            if (params.e()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(null, null, 3, null);
                dVar.M();
                com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(null, null, 3, null);
                cVar.m();
                dVar.M();
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(params.d());
                String d16 = params.d();
                String str = "";
                if (d16 == null) {
                    d16 = "";
                }
                dVar.w0(d16);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                dVar.v0(uid);
                String d17 = params.d();
                if (d17 != null) {
                    str = d17;
                }
                cVar.u(str);
                cVar.t(uid);
                dVar.p0("1");
                Boolean bool = Boolean.TRUE;
                dVar.t0(bool);
                dVar.s0(bool);
                cVar.q(1);
                ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, "NTFriendSettingHelper", new c(cVar, params, isSuccess));
                return;
            }
            QQAppInterface a16 = params.a();
            Intrinsics.checkNotNull(a16);
            K(a16, 92, isSuccess, new Object[]{1, new String[]{params.d()}, new boolean[]{params.e()}});
            return;
        }
        QQAppInterface a17 = params.a();
        Intrinsics.checkNotNull(a17);
        K(a17, 92, isSuccess, new Object[]{1, new String[]{params.d()}, new boolean[]{params.e()}});
    }

    private final void H(a params, boolean isSuccess) {
        if (isSuccess) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(null, null, 3, null);
            dVar.M();
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(params.d());
            String d16 = params.d();
            if (d16 == null) {
                d16 = "";
            }
            dVar.w0(d16);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            dVar.v0(uid);
            dVar.t0(Boolean.valueOf(params.e()));
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, "NTFriendSettingHelper", new d(params, isSuccess));
            return;
        }
        QQAppInterface a16 = params.a();
        Intrinsics.checkNotNull(a16);
        K(a16, 94, isSuccess, new Object[]{3, new String[]{params.d()}, new boolean[]{params.e()}});
    }

    private final void I(a params, boolean isSuccess) {
        if (isSuccess) {
            com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(null, null, 3, null);
            String d16 = params.d();
            if (d16 == null) {
                d16 = "";
            }
            cVar.u(d16);
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(params.d());
            Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026getUidFromUin(params.uin)");
            cVar.t(uidFromUin);
            cVar.m();
            cVar.q(params.e() ? 1 : 0);
            ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(cVar, "NTFriendSettingHelper", new e(params, isSuccess));
            return;
        }
        QQAppInterface a16 = params.a();
        Intrinsics.checkNotNull(a16);
        K(a16, 93, isSuccess, new Object[]{2, new String[]{params.d()}, new boolean[]{params.e()}});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(a params, boolean isRingOn, boolean isZoneOn, boolean isSuccess) {
        if (r(params)) {
            return;
        }
        int b16 = params.b();
        if (b16 != 0) {
            if (b16 != 1) {
                if (b16 == 2) {
                    params.f(isZoneOn);
                    H(params, isSuccess);
                    return;
                }
                return;
            }
            params.f(isRingOn);
            I(params, isSuccess);
            return;
        }
        G(params, isSuccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(QQAppInterface app, int msgType, boolean isSuccess, Object[] data) {
        app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(msgType, isSuccess, data);
    }

    private final void L(final Function0<Unit> runnable) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.settings.e
            @Override // java.lang.Runnable
            public final void run() {
                NTFriendSettingHelper.M(Function0.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(final a params, final int i3, final String errMsg) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        f352067a.L(new Function0<Unit>(i3, errMsg, params) { // from class: com.tencent.qqnt.aio.settings.NTFriendSettingHelper$setFriendBlock$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ NTFriendSettingHelper.a $params;
            final /* synthetic */ int $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$errMsg = errMsg;
                this.$params = params;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errMsg, params);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("NTFriendSettingHelper", 1, "[setFriendBlock] result=" + this.$result + ", errMsg=" + this.$errMsg + ", isBlock=" + this.$params.e());
                NTFriendSettingHelper.f352067a.B(this.$params, this.$result == 0, this.$errMsg);
            }
        });
    }

    public static /* synthetic */ void Q(NTFriendSettingHelper nTFriendSettingHelper, a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        nTFriendSettingHelper.P(aVar, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final boolean z16, final a params, final int i3, final String errMsg) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        f352067a.L(new Function0<Unit>(i3, errMsg, z16, params) { // from class: com.tencent.qqnt.aio.settings.NTFriendSettingHelper$setFriendMsgNotify$1$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ boolean $isNoDisturb;
            final /* synthetic */ NTFriendSettingHelper.a $params;
            final /* synthetic */ int $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$errMsg = errMsg;
                this.$isNoDisturb = z16;
                this.$params = params;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errMsg, Boolean.valueOf(z16), params);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("NTFriendSettingHelper", 1, "[setFriendMsgNotify] result=" + this.$result + ", errMsg=" + this.$errMsg + ", noDisturb=" + this.$isNoDisturb);
                NTFriendSettingHelper.f352067a.E(this.$params, this.$result == 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(a params, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        boolean z16 = true;
        QLog.d("NTFriendSettingHelper", 1, "[setFriendTop] result=" + i3 + ", errMsg=" + errMsg + ", isTop=" + params.e());
        NTFriendSettingHelper nTFriendSettingHelper = f352067a;
        if (i3 != 0) {
            z16 = false;
        }
        nTFriendSettingHelper.F(params, z16);
    }

    public static /* synthetic */ void V(NTFriendSettingHelper nTFriendSettingHelper, a aVar, boolean z16, boolean z17, IOperateCallback iOperateCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        if ((i3 & 8) != 0) {
            iOperateCallback = null;
        }
        nTFriendSettingHelper.U(aVar, z16, z17, iOperateCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(final a params, final boolean z16, final boolean z17, final IOperateCallback iOperateCallback, final int i3, final String errMsg) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        f352067a.L(new Function0<Unit>(i3, errMsg, params, z16, z17, iOperateCallback) { // from class: com.tencent.qqnt.aio.settings.NTFriendSettingHelper$setSpecialCareSwitch$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ IOperateCallback $callback;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ boolean $isRingOn;
            final /* synthetic */ boolean $isZoneOn;
            final /* synthetic */ NTFriendSettingHelper.a $params;
            final /* synthetic */ int $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$errMsg = errMsg;
                this.$params = params;
                this.$isZoneOn = z16;
                this.$isRingOn = z17;
                this.$callback = iOperateCallback;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errMsg, params, Boolean.valueOf(z16), Boolean.valueOf(z17), iOperateCallback);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("NTFriendSettingHelper", 1, "[setSpecialCare] result=" + this.$result + ", errMsg=" + this.$errMsg + ", type=" + this.$params.b() + ", switch=" + this.$params.e() + ", zoneOn=" + this.$isZoneOn);
                NTFriendSettingHelper.f352067a.J(this.$params, this.$isRingOn, this.$isZoneOn, this.$result == 0);
                IOperateCallback iOperateCallback2 = this.$callback;
                if (iOperateCallback2 != null) {
                    iOperateCallback2.onResult(this.$result, this.$errMsg);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int stringRes, Integer toastType) {
        QQToast makeText = QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(stringRes), 0);
        if (toastType != null) {
            makeText.setToastIcon(QQToast.getIconRes(toastType.intValue()));
        }
        makeText.show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Y(NTFriendSettingHelper nTFriendSettingHelper, int i3, Integer num, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            num = null;
        }
        nTFriendSettingHelper.X(i3, num);
    }

    private final int Z(int uinType) {
        int l3 = com.tencent.nt.adapter.session.c.l(uinType);
        if (l3 == 0) {
            return 1;
        }
        return l3;
    }

    private final void q(boolean isOpen, String friendUin) {
        String text;
        if (friendUin == null) {
            return;
        }
        if (isOpen) {
            text = HardCodeUtil.qqStr(R.string.mtw);
        } else {
            text = HardCodeUtil.qqStr(R.string.mtz);
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(friendUin);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.getUidFromUin(friendUin)");
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(uidFromUin, 1, 2100L, 0, true, false, null, 104, null);
        Intrinsics.checkNotNullExpressionValue(text, "text");
        LocalGrayTip m3 = LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, text, 0, 2, null).m();
        INtGrayTipApi iNtGrayTipApi = (INtGrayTipApi) QRoute.api(INtGrayTipApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        iNtGrayTipApi.addLocalGrayTip(peekAppRuntime, m3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r(a params) {
        boolean z16;
        boolean z17;
        if (params.a() == null) {
            return true;
        }
        String d16 = params.d();
        if (d16 != null && d16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        String c16 = params.c();
        if (c16 != null && c16.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    private final void s(final Function0<Unit> runnable) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.invoke();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.settings.f
                @Override // java.lang.Runnable
                public final void run() {
                    NTFriendSettingHelper.t(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w(NTFriendSettingHelper nTFriendSettingHelper, a aVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = new NTFriendSettingHelper$clearMsgRecords$1(nTFriendSettingHelper);
        }
        nTFriendSettingHelper.v(aVar, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final a params, final int i3, final String str, final long j3) {
        Intrinsics.checkNotNullParameter(params, "$params");
        f352067a.L(new Function0<Unit>(i3, str, j3, params) { // from class: com.tencent.qqnt.aio.settings.NTFriendSettingHelper$clearMsgRecords$2$1$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $delLastSeq;
            final /* synthetic */ String $errMsg;
            final /* synthetic */ NTFriendSettingHelper.a $params;
            final /* synthetic */ int $result;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$result = i3;
                this.$errMsg = str;
                this.$delLastSeq = j3;
                this.$params = params;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Long.valueOf(j3), params);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QLog.d("NTFriendSettingHelper", 1, "[clearMsgRecords] result=" + this.$result + ", errMsg=" + this.$errMsg + ", delLastSeq=" + this.$delLastSeq);
                NTFriendSettingHelper.f352067a.D(this.$params, this.$result == 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(int i3, String str) {
        QLog.d("NTFriendSettingHelper", 1, "[delRoamMsgRecords] result=" + i3 + ", errMsg=" + str);
    }

    private final m z(QQAppInterface app) {
        return ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getBuddyService();
    }

    public final void N(@NotNull final a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (r(params)) {
            return;
        }
        QQAppInterface a16 = params.a();
        Intrinsics.checkNotNull(a16);
        m z16 = z(a16);
        if (z16 != null) {
            String c16 = params.c();
            Intrinsics.checkNotNull(c16);
            z16.setBlock(c16, params.e(), new IOperateCallback() { // from class: com.tencent.qqnt.aio.settings.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTFriendSettingHelper.O(NTFriendSettingHelper.a.this, i3, str);
                }
            });
        }
    }

    public final void P(@NotNull final a params, boolean isReqServer) {
        QQAppInterface a16;
        m z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, params, Boolean.valueOf(isReqServer));
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (r(params)) {
            return;
        }
        com.tencent.qqnt.contact.friends.b bVar = com.tencent.qqnt.contact.friends.b.f355778a;
        if (!bVar.c(params.d(), "NTFriendSettingHelper")) {
            return;
        }
        final boolean e16 = params.e();
        bVar.e(params.d(), !e16, "NTFriendSettingHelper");
        FriendsStatusUtil.x(params.a());
        FriendsStatusUtil.m(params.a(), params.d(), e16 ? 1 : 0);
        if (isReqServer && (a16 = params.a()) != null && (z16 = f352067a.z(a16)) != null) {
            String c16 = params.c();
            Intrinsics.checkNotNull(c16);
            z16.setMsgNotify(c16, e16, new IOperateCallback() { // from class: com.tencent.qqnt.aio.settings.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTFriendSettingHelper.R(e16, params, i3, str);
                }
            });
        }
    }

    public final void S(@NotNull final a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (r(params)) {
            return;
        }
        QQAppInterface a16 = params.a();
        Intrinsics.checkNotNull(a16);
        m z16 = z(a16);
        if (z16 != null) {
            String c16 = params.c();
            Intrinsics.checkNotNull(c16);
            z16.setTop(c16, params.e(), new IOperateCallback() { // from class: com.tencent.qqnt.aio.settings.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTFriendSettingHelper.T(NTFriendSettingHelper.a.this, i3, str);
                }
            });
        }
    }

    public final void U(@NotNull final a params, final boolean isRingOn, final boolean isZoneOn, @Nullable final IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, params, Boolean.valueOf(isRingOn), Boolean.valueOf(isZoneOn), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (r(params)) {
            return;
        }
        QQAppInterface a16 = params.a();
        Intrinsics.checkNotNull(a16);
        m z16 = z(a16);
        if (z16 != null) {
            String c16 = params.c();
            Intrinsics.checkNotNull(c16);
            z16.L(c16, new SpecialCareSetting(isRingOn, isZoneOn, params.e()), new IOperateCallback() { // from class: com.tencent.qqnt.aio.settings.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    NTFriendSettingHelper.W(NTFriendSettingHelper.a.this, isZoneOn, isRingOn, callback, i3, str);
                }
            });
        }
    }

    @JvmOverloads
    public final void u(@NotNull a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) params);
        } else {
            Intrinsics.checkNotNullParameter(params, "params");
            w(this, params, null, 2, null);
        }
    }

    @JvmOverloads
    public final void v(@NotNull final a params, @NotNull Function1<? super a, Boolean> checkParamsInvalid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) params, (Object) checkParamsInvalid);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(checkParamsInvalid, "checkParamsInvalid");
        if (checkParamsInvalid.invoke(params).booleanValue()) {
            return;
        }
        QQAppInterface a16 = params.a();
        Intrinsics.checkNotNull(a16);
        w A = A(a16);
        if (A != null) {
            int Z = f352067a.Z(params.b());
            String c16 = params.c();
            Intrinsics.checkNotNull(c16);
            Contact contact = new Contact(Z, c16, "");
            A.clearMsgRecords(contact, new IClearMsgRecordsCallback() { // from class: com.tencent.qqnt.aio.settings.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback
                public final void onResult(int i3, String str, long j3) {
                    NTFriendSettingHelper.x(NTFriendSettingHelper.a.this, i3, str, j3);
                }
            });
            if (params.e()) {
                A.O(contact, new IOperateCallback() { // from class: com.tencent.qqnt.aio.settings.d
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        NTFriendSettingHelper.y(i3, str);
                    }
                });
            }
        }
    }
}
