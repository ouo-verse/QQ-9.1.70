package com.tencent.qqnt.aio.forward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aio.data.AIOContact;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgRecordParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgForwardNtUtil;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.forward.l;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MultiMsgInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001CB\t\b\u0002\u00a2\u0006\u0004\bA\u0010BJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\nH\u0007J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002JF\u0010 \u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001bj\b\u0012\u0004\u0012\u00020\u0019`\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\"\u001a\u00020!H\u0002J\u001e\u0010&\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120$H\u0002J(\u0010(\u001a\u0012\u0012\u0004\u0012\u00020'0\u001bj\b\u0012\u0004\u0012\u00020'`\u001c2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J>\u0010-\u001a\u00020\u00102\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020'0\u001bj\b\u0012\u0004\u0012\u00020'`\u001c2\u0006\u0010*\u001a\u00020\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010+H\u0002J>\u0010.\u001a\u00020\u00102\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u001bj\b\u0012\u0004\u0012\u00020\u0019`\u001c2\u0006\u0010*\u001a\u00020\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010/\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010+H\u0002J\b\u00100\u001a\u00020\u0010H\u0002J\u001e\u00102\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u0002012\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u0012J4\u00105\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00120$2\u0006\u00104\u001a\u000203J&\u00107\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u0002012\u0006\u0010\"\u001a\u00020!2\u0006\u00106\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0012J2\u0010;\u001a\u00020\u00102\u0006\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\n2\b\u0010,\u001a\u0004\u0018\u00010+R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/aio/forward/NtMsgForwardUtils;", "", "Landroid/os/Bundle;", "data", "", "f", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "", "forwardType", "Landroid/content/Intent;", "k", "l", "Landroid/content/Context;", "context", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", DomainData.DOMAIN_NAME, "", "rootMsgIds", "", "forwardMsgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "srcContact", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "dstContacts", "", "comment", "r", "Lcom/tencent/aio/data/AIOContact;", "contact", "t", "", TabPreloadItem.TAB_NAME_MESSAGE, "j", "Lcom/tencent/qqnt/aio/forward/NtMsgForwardUtils$a;", "p", "selectContacts", "isMultiSelect", "Lcom/tencent/qqnt/aio/a;", "aioContext", tl.h.F, ReportConstant.COSTREPORT_PREFIX, "g", "o", "Landroid/app/Activity;", "u", "Lcom/tencent/mvi/base/route/j;", "messenger", "y", "text", HippyTKDListViewAdapter.X, WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", QzoneIPCModule.RESULT_CODE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "Lcom/tencent/qqnt/aio/forward/c;", "b", "Ljava/util/Map;", "forwardHandlers", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class NtMsgForwardUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NtMsgForwardUtils f349949a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, com.tencent.qqnt.aio.forward.c> forwardHandlers;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/forward/NtMsgForwardUtils$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "b", "I", "()I", "uinType", "<init>", "(Ljava/lang/String;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int uinType;

        public a(@NotNull String uin, int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uin, i3);
            } else {
                this.uin = uin;
                this.uinType = i3;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.uin;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.uinType;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.uin, aVar.uin) && this.uinType == aVar.uinType) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return (this.uin.hashCode() * 31) + this.uinType;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "SelectContact(uin=" + this.uin + ", uinType=" + this.uinType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/forward/NtMsgForwardUtils$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "", "result", "", "errMsg", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements IOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Contact f349953a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Contact f349954b;

        b(Contact contact, Contact contact2) {
            this.f349953a = contact;
            this.f349954b = contact2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) contact, (Object) contact2);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
        public void onResult(int result, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, result, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("NtMsgForwardUtils", 1, "[realForwardMultiMsg]: multiForward result is " + result + " errmsg is " + errMsg + ", srcContact is " + this.f349953a + " dstContact is " + this.f349954b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JB\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042&\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/forward/NtMsgForwardUtils$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IForwardOperateCallback;", "", "result", "", "errMsg", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "detailErr", "", "onResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements IForwardOperateCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Contact f349955a;

        c(Contact contact) {
            this.f349955a = contact;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) contact);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IForwardOperateCallback
        public void onResult(int result, @Nullable String errMsg, @Nullable HashMap<Long, Integer> detailErr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, detailErr);
                return;
            }
            QLog.i("NtMsgForwardUtils", 1, "[realForwardMultiMsg]: forward result is " + result + " errmsg is " + errMsg + ", srcContact is " + this.f349955a);
        }
    }

    static {
        Map<Integer, com.tencent.qqnt.aio.forward.c> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f349949a = new NtMsgForwardUtils();
        mapOf = MapsKt__MapsKt.mapOf(new Pair(2, new f()), new Pair(7, new n()), new Pair(17, new e()), new Pair(9, new m()), new Pair(3, new com.tencent.qqnt.aio.forward.b()), new Pair(11, new com.tencent.qqnt.aio.forward.a()), new Pair(8, new g()), new Pair(31, new d()));
        forwardHandlers = mapOf;
    }

    NtMsgForwardUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean f(@Nullable Bundle data) {
        if (data == null) {
            QLog.e("NtMsgForwardUtils", 1, "canHandleByNt data is null");
            return false;
        }
        boolean z16 = data.getBoolean(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, false);
        boolean z17 = data.getBoolean(AEEditorConstants.EXTRA_IS_EDITED_PIC, false);
        boolean z18 = data.getBoolean(AppConstants.Key.SHARE_REQ_FROM_NEW_PANEL, false);
        QLog.d("NtMsgForwardUtils", 1, "canHandleByNt " + z16 + " " + z17 + " " + z18);
        if (z16 && !z17 && !z18) {
            return true;
        }
        return false;
    }

    private final void g(com.tencent.qqnt.aio.a aioContext) {
        l.INSTANCE.a().b();
        if (aioContext != null) {
            aioContext.b(new MsgForwardEvent.MultiForwardSelectResult(false, null, null, null, false, 28, null));
        }
    }

    private final void h(ArrayList<a> selectContacts, final boolean isMultiSelect, final String comment, final com.tencent.qqnt.aio.a aioContext) {
        QLog.d("NtMsgForwardUtils", 1, "forwardMultiSelectMsg");
        final ArrayList<Contact> arrayList = new ArrayList<>();
        for (a aVar : selectContacts) {
            if (!com.tencent.nt.adapter.session.c.e(aVar.b())) {
                arrayList.add(new Contact(com.tencent.nt.adapter.session.c.l(aVar.b()), aVar.a(), ""));
            }
        }
        final ArrayList arrayList2 = new ArrayList();
        for (Object obj : selectContacts) {
            if (com.tencent.nt.adapter.session.c.e(((a) obj).b())) {
                arrayList2.add(obj);
            }
        }
        if (arrayList2.isEmpty()) {
            s(arrayList, isMultiSelect, comment, aioContext);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.forward.i
                @Override // java.lang.Runnable
                public final void run() {
                    NtMsgForwardUtils.i(arrayList2, arrayList, isMultiSelect, comment, aioContext);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(List dstUinContacts, final ArrayList dstContacts, final boolean z16, final String str, final com.tencent.qqnt.aio.a aVar) {
        boolean z17;
        Intrinsics.checkNotNullParameter(dstUinContacts, "$dstUinContacts");
        Intrinsics.checkNotNullParameter(dstContacts, "$dstContacts");
        Iterator it = dstUinContacts.iterator();
        while (it.hasNext()) {
            a aVar2 = (a) it.next();
            int l3 = com.tencent.nt.adapter.session.c.l(aVar2.b());
            if (l3 == 10021) {
                QLog.d("NtMsgForwardUtils", 1, "forwardMultiSelectMsg unknown uinType:" + aVar2);
            } else {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(aVar2.a());
                if (uidFromUin != null) {
                    Intrinsics.checkNotNullExpressionValue(uidFromUin, "getUidFromUin(sessionInfo.uin)");
                    if (uidFromUin.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        dstContacts.add(new Contact(l3, uidFromUin, ""));
                    } else {
                        QLog.d("NtMsgForwardUtils", 1, "forwardMultiSelectMsg empty uid " + aVar2);
                    }
                }
            }
        }
        PostUtilKt.b(new Function0<Unit>(dstContacts, z16, str, aVar) { // from class: com.tencent.qqnt.aio.forward.NtMsgForwardUtils$forwardMultiSelectMsg$2$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.qqnt.aio.a $aioContext;
            final /* synthetic */ String $comment;
            final /* synthetic */ ArrayList<Contact> $dstContacts;
            final /* synthetic */ boolean $isMultiSelect;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$dstContacts = dstContacts;
                this.$isMultiSelect = z16;
                this.$comment = str;
                this.$aioContext = aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, dstContacts, Boolean.valueOf(z16), str, aVar);
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
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    NtMsgForwardUtils.f349949a.s(this.$dstContacts, this.$isMultiSelect, this.$comment, this.$aioContext);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    private final String j(Context context, List<? extends AIOMsgItem> msgList) {
        boolean z16;
        ArrayList<String> arrayListOf;
        ArrayList<String> arrayListOf2;
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = str3;
        for (AIOMsgItem aIOMsgItem : msgList) {
            if (str4.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str4 = aIOMsgItem.getMsgRecord().senderUid;
                Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.senderUid");
                com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
                if (b16 != null) {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(str4);
                    Map<String, String> buddyNick = b16.getBuddyNick(arrayListOf);
                    if (buddyNick != null && (str3 = buddyNick.get(str4)) != null) {
                    }
                }
                str3 = "";
            } else if (!str4.equals(aIOMsgItem.getMsgRecord().senderUid)) {
                String secondUid = aIOMsgItem.getMsgRecord().senderUid;
                com.tencent.qqnt.kernel.api.m b17 = com.tencent.qqnt.msg.f.b();
                if (b17 != null) {
                    Intrinsics.checkNotNullExpressionValue(secondUid, "secondUid");
                    arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(secondUid);
                    Map<String, String> buddyNick2 = b17.getBuddyNick(arrayListOf2);
                    if (buddyNick2 != null && (str = buddyNick2.get(secondUid)) != null) {
                        str2 = str;
                    }
                }
                return ((Object) str3) + context.getString(R.string.kch) + str2 + context.getString(R.string.mq7);
            }
        }
        return ((Object) str3) + context.getString(R.string.mq7);
    }

    @JvmStatic
    public static final boolean k(@NotNull SessionInfo sessionInfo, int forwardType, @NotNull Intent data) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(data, "data");
        Bundle extras = data.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        return l(sessionInfo, forwardType, extras);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
    
        if (r1[0] != 0) goto L24;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean l(@NotNull SessionInfo sessionInfo, int forwardType, @NotNull final Bundle data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z17 = true;
        QLog.d("NtMsgForwardUtils", 1, "handleForwardNtMsg type=" + forwardType);
        if (forwardType == 0) {
            long[] longArray = data.getLongArray(AppConstants.Key.FORWARD_NT_ROOT_MSG_IDS);
            if (longArray != null) {
                if (longArray.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                }
            }
            String string = data.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
            if (string != null && string.length() != 0) {
                z17 = false;
            }
            if (!z17 && data.getBoolean("is_from_file", false)) {
                com.tencent.mobileqq.forward.utils.f.f211079a.i(sessionInfo, string);
            }
            return false;
        }
        if (!f(data)) {
            QLog.e("NtMsgForwardUtils", 1, "handleForwardNtMsg cannot handleByNt");
            return false;
        }
        boolean z18 = data.getBoolean(AppConstants.Key.FORWARD_NT_MULTI_SELECT, false);
        final long j3 = data.getLong(AppConstants.Key.FORWARD_NT_MSG_ID, -1L);
        if (!z18 && j3 >= 0) {
            final int l3 = com.tencent.nt.adapter.session.c.l(sessionInfo.f179555d);
            if (l3 == 10021) {
                QLog.e("NtMsgForwardUtils", 1, "handleForwardNtMsg unknown curType: " + sessionInfo.f179555d);
                return true;
            }
            if (sessionInfo.f179555d == 10014 && ((IGuildForwardUtilsApi) QRoute.api(IGuildForwardUtilsApi.class)).checkTextExceedLimit(data)) {
                data.putBoolean("is_need_show_toast", false);
                QQToastUtil.showQQToast(1, R.string.her);
                return true;
            }
            if (TextUtils.isEmpty(sessionInfo.f179557e)) {
                QLog.e("NtMsgForwardUtils", 1, "handleForwardNtMsg error uin is null");
                return true;
            }
            String string2 = data.getString(AppConstants.Key.FORWARD_NT_SOURCE_UID);
            int i3 = data.getInt(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, -1);
            if (i3 != -1 && !TextUtils.isEmpty(string2)) {
                final long[] longArray2 = data.getLongArray(AppConstants.Key.FORWARD_NT_ROOT_MSG_IDS);
                final Contact contact = new Contact(i3, string2, "");
                if (l3 == 8) {
                    String string3 = data.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
                    ArrayList<Contact> arrayList = new ArrayList<>();
                    arrayList.add(new Contact(l3, sessionInfo.f178172i0, ""));
                    f349949a.r(longArray2, j3, contact, arrayList, string3);
                    return true;
                }
                String str = sessionInfo.f179557e;
                Intrinsics.checkNotNullExpressionValue(str, "sessionInfo.curFriendUin");
                com.tencent.nt.adapter.session.c.j(str, sessionInfo.f179555d, new Function2<Boolean, com.tencent.nt.adapter.session.e, Unit>(data, longArray2, j3, contact, l3) { // from class: com.tencent.qqnt.aio.forward.NtMsgForwardUtils$handleForwardNtMsg$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $chatType;
                    final /* synthetic */ Bundle $data;
                    final /* synthetic */ long $forwardMsgId;
                    final /* synthetic */ long[] $rootMsgIds;
                    final /* synthetic */ Contact $srcContact;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                        this.$data = data;
                        this.$rootMsgIds = longArray2;
                        this.$forwardMsgId = j3;
                        this.$srcContact = contact;
                        this.$chatType = l3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, data, longArray2, Long.valueOf(j3), contact, Integer.valueOf(l3));
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, com.tencent.nt.adapter.session.e eVar) {
                        invoke(bool.booleanValue(), eVar);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z19, @Nullable com.tencent.nt.adapter.session.e eVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z19), eVar);
                            return;
                        }
                        if (eVar == null) {
                            QLog.e("NtMsgForwardUtils", 1, "uin2Uid fail");
                            return;
                        }
                        String string4 = this.$data.getString("guild_id");
                        if (string4 == null) {
                            string4 = "";
                        }
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new Contact(this.$chatType, eVar.b(), string4));
                        NtMsgForwardUtils.f349949a.r(this.$rootMsgIds, this.$forwardMsgId, this.$srcContact, arrayList2, this.$data.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE));
                    }
                });
                return true;
            }
            QLog.e("NtMsgForwardUtils", 1, "handleForwardNtMsg error " + i3 + " " + string2);
            return true;
        }
        QLog.e("NtMsgForwardUtils", 1, "handleForwardNtMsg isMultiSelect=" + z18 + " forwardMsgId=" + j3);
        return true;
    }

    private final boolean n(AIOMsgItem msgItem) {
        String str;
        boolean z16;
        boolean z17;
        ArkElement arkElement;
        ArkElement arkElement2;
        if (msgItem.getMsgRecord().msgType != 11) {
            return false;
        }
        MsgElement firstTypeElement = msgItem.getFirstTypeElement(10);
        String str2 = null;
        if (firstTypeElement != null && (arkElement2 = firstTypeElement.arkElement) != null) {
            str = arkElement2.bytesData;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (firstTypeElement != null && (arkElement = firstTypeElement.arkElement) != null) {
            str2 = arkElement.bytesData;
        }
        com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
        if (str2 != null && aVar.o(str2)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return ArkMsgUtils.isMultiMsg(aVar.d(), aVar.e());
        }
        QLog.i("NtMsgForwardUtils", 1, "isArkMultiMsg parse ark model failed, msgId=" + msgItem.getMsgRecord().msgId + " content=" + ((Object) str2));
        return false;
    }

    private final void o() {
        l.INSTANCE.a().b();
    }

    private final ArrayList<a> p(Intent data, int forwardType) {
        ArrayList<a> arrayList = new ArrayList<>();
        ArrayList<ResultRecord> parcelableArrayListExtra = data.getParcelableArrayListExtra(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayListExtra != null) {
            for (ResultRecord resultRecord : parcelableArrayListExtra) {
                if (resultRecord.getUinType() != 10014) {
                    String str = resultRecord.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "target.uin");
                    arrayList.add(new a(str, resultRecord.uinType));
                }
            }
        } else {
            SessionInfo n06 = ForwardUtils.n0(data);
            Intrinsics.checkNotNullExpressionValue(n06, "sessionFromIntent(data)");
            if (n06.f179555d == 10014) {
                ForwardUtils.K(n06, forwardType, data);
            } else {
                String str2 = n06.f179557e;
                Intrinsics.checkNotNullExpressionValue(str2, "sessionInfo.curFriendUin");
                arrayList.add(new a(str2, n06.f179555d));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void q(@NotNull Context context, @NotNull Intent intent) {
        List<AIOMsgItem> list;
        int intExtra;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID);
        int intExtra2 = intent.getIntExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, -1);
        boolean z17 = 1;
        if (intExtra2 != -1 && !TextUtils.isEmpty(stringExtra)) {
            String stringExtra2 = intent.getStringExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE);
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = context.getString(R.string.mpg);
            }
            boolean booleanExtra = intent.getBooleanExtra(AppConstants.Key.FORWARD_NT_MULTI_SELECT, false);
            if (booleanExtra) {
                list = l.INSTANCE.a().h();
            } else {
                AIOMsgItem d16 = l.INSTANCE.a().d();
                if (d16 != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(d16);
                    list = arrayList;
                } else {
                    list = null;
                }
            }
            if (list != null && !list.isEmpty()) {
                if (!booleanExtra) {
                    AIOMsgItem aIOMsgItem = list.get(0);
                    if (aIOMsgItem.getMsgRecord().msgType != 8) {
                        z17 = 0;
                    }
                    if (z17 == 0) {
                        z17 = f349949a.n(aIOMsgItem);
                    }
                    intExtra = !z17;
                    z16 = z17;
                } else {
                    intExtra = intent.getIntExtra(AppConstants.Key.FORWARD_NT_TYPE, -1);
                    z16 = false;
                }
                boolean booleanExtra2 = intent.getBooleanExtra(AppConstants.Key.FORWARD_ACTIVITY_BG, false);
                IMsgForwardNtUtil iMsgForwardNtUtil = (IMsgForwardNtUtil) QRoute.api(IMsgForwardNtUtil.class);
                Intrinsics.checkNotNull(stringExtra);
                Intrinsics.checkNotNull(stringExtra2);
                iMsgForwardNtUtil.previewMsg(context, intExtra2, stringExtra, stringExtra2, list, z16, intExtra, booleanExtra2);
                return;
            }
            QLog.e("NtMsgForwardUtils", 1, "previewMsg invalid");
            return;
        }
        QLog.e("NtMsgForwardUtils", 1, "previewForwardMsg source data invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(long[] rootMsgIds, long forwardMsgId, Contact srcContact, ArrayList<Contact> dstContacts, String comment) {
        ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).forward(rootMsgIds, forwardMsgId, srcContact, dstContacts, comment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ArrayList<Contact> dstContacts, boolean isMultiSelect, String comment, com.tencent.qqnt.aio.a aioContext) {
        boolean z16;
        ArrayList<MsgElement> forwardCommentElement;
        QLog.d("NtMsgForwardUtils", 1, "forward dstContacts = " + dstContacts + ", comment=" + comment);
        if (dstContacts.isEmpty()) {
            g(aioContext);
        } else if (isMultiSelect) {
            if (aioContext != null) {
                aioContext.b(new MsgForwardEvent.MultiForwardSelectResult(true, dstContacts, null, comment, false, 20, null));
            } else {
                QLog.d("NtMsgForwardUtils", 1, "[realForwardMultiMsg]: aioContext is null, forwardByMsgStore");
                l.Companion companion = l.INSTANCE;
                int i3 = companion.a().i();
                Contact j3 = companion.a().j();
                if (j3 == null) {
                    QLog.i("NtMsgForwardUtils", 1, "[realForwardMultiMsg]: srcContact is null");
                    g(null);
                    return;
                }
                if (comment != null && comment.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    forwardCommentElement = null;
                } else {
                    forwardCommentElement = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getForwardCommentElement(comment);
                }
                if (i3 != 0) {
                    if (i3 == 1) {
                        ArrayList<Long> f16 = companion.a().f();
                        if (f16.isEmpty()) {
                            QLog.i("NtMsgForwardUtils", 1, "[realForwardMultiMsg]: msgIdList is empty");
                            g(null);
                            return;
                        } else {
                            w e16 = com.tencent.qqnt.msg.f.e();
                            if (e16 != null) {
                                e16.forwardMsg(f16, j3, dstContacts, forwardCommentElement, new c(j3));
                            }
                        }
                    }
                } else {
                    ArrayList<MultiMsgInfo> g16 = companion.a().g();
                    if (g16.isEmpty()) {
                        QLog.i("NtMsgForwardUtils", 1, "[realForwardMultiMsg]: multiMsgInfo is empty");
                        g(null);
                        return;
                    }
                    for (Contact contact : dstContacts) {
                        w e17 = com.tencent.qqnt.msg.f.e();
                        if (e17 != null) {
                            e17.t0(g16, j3, contact, forwardCommentElement, new b(j3, contact));
                        }
                    }
                }
            }
        }
        o();
    }

    private final void t(Intent intent, AIOContact contact) {
        intent.putExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, com.tencent.nt.adapter.session.c.c(contact.e()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final Intent intent, String newPath, final Activity context) {
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(newPath, "$newPath");
        Intrinsics.checkNotNullParameter(context, "$context");
        String stringExtra = intent.getStringExtra(AppConstants.Key.FORWARD_FILEPATH);
        String str = "";
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = intent.getStringExtra(AppConstants.Key.FORWARD_THUMB);
        if (stringExtra2 != null) {
            str = stringExtra2;
        }
        if (new File(stringExtra).exists()) {
            n0.a.c(new File(stringExtra), new File(newPath));
        } else {
            n0.a.c(new File(str), new File(newPath));
        }
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, newPath);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.forward.j
            @Override // java.lang.Runnable
            public final void run() {
                NtMsgForwardUtils.w(context, intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Activity context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(intent, "$intent");
        ForwardBaseOption.startForwardActivityForResult(context, intent, 21);
    }

    public final void m(@NotNull Activity activity, int requestCode, int resultCode, @Nullable Intent data, @Nullable com.tencent.qqnt.aio.a aioContext) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data, aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d("NtMsgForwardUtils", 1, "handleOnActivityResult requestCode=" + requestCode + " resultCode=" + resultCode + ", data=" + data);
        if (requestCode != 21) {
            return;
        }
        if (resultCode == -1 && data != null) {
            int intExtra = data.getIntExtra("forward_type", Integer.MAX_VALUE);
            if (intExtra == Integer.MAX_VALUE) {
                QLog.e("NtMsgForwardUtils", 1, "handleOnActivityResult forwardType invalid");
                g(aioContext);
                return;
            }
            boolean booleanExtra = data.getBooleanExtra(AppConstants.Key.FORWARD_NT_MULTI_SELECT, false);
            if (!booleanExtra) {
                QLog.d("NtMsgForwardUtils", 1, "handleOnActivityResult handleForwardData");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) peekAppRuntime;
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface == null) {
                    return;
                }
                ForwardUtils.w(qQAppInterface, activity, activity, data, null);
                o();
                return;
            }
            data.removeExtra("forward_type");
            h(p(data, intExtra), booleanExtra, data.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE), aioContext);
            return;
        }
        g(aioContext);
    }

    public final boolean u(@NotNull final Activity context, @NotNull AIOContact contact, @NotNull AIOMsgItem msgItem) {
        long[] longArray;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, contact, msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QLog.d("NtMsgForwardUtils", 1, "startForwardMsg msg_type=" + msgItem.getMsgRecord().msgType);
        com.tencent.qqnt.aio.forward.c cVar = forwardHandlers.get(Integer.valueOf(msgItem.getMsgRecord().msgType));
        if (cVar == null) {
            QLog.e("NtMsgForwardUtils", 1, "startForwardMsg unSupport msg");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (MsgRecordParams h06 = msgItem.h0(); h06 != null; h06 = h06.c()) {
            arrayList.add(Long.valueOf(h06.b()));
        }
        CollectionsKt___CollectionsJvmKt.reverse(arrayList);
        final Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        intent.putExtra(AppConstants.Key.FORWARD_NT_MSG_ID, msgItem.getMsgRecord().msgId);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID, contact.j());
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, contact.e());
        longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
        intent.putExtra(AppConstants.Key.FORWARD_NT_ROOT_MSG_IDS, longArray);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        if (msgItem.f2()) {
            intent.putExtra(AppConstants.Key.FORWARD_SHOW_WECHAT_ENTRANCE, true);
        }
        t(intent, contact);
        if (!cVar.a(msgItem, contact, intent)) {
            QLog.e("NtMsgForwardUtils", 1, "startForwardMsg cannot handle msg");
            return false;
        }
        l.INSTANCE.a().l(msgItem);
        final String stringExtra = intent.getStringExtra("add_file_suffix");
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.forward.h
                @Override // java.lang.Runnable
                public final void run() {
                    NtMsgForwardUtils.v(intent, stringExtra, context);
                }
            }, 64, null, false);
        } else {
            ForwardBaseOption.startForwardActivityForResult(context, intent, 21);
        }
        return true;
    }

    public final void x(@NotNull Activity context, @NotNull AIOContact contact, @NotNull String text, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, contact, text, msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        QLog.e("NtMsgForwardUtils", 1, "startForwardText");
        Intent intent = new Intent();
        t(intent, contact);
        MsgRecord msgRecord = msgItem.getMsgRecord();
        MsgRecord msgRecord2 = new MsgRecord();
        msgRecord2.sendStatus = 2;
        msgRecord2.msgType = 2;
        msgRecord2.peerUid = msgRecord.peerUid;
        msgRecord2.chatType = msgRecord.chatType;
        msgRecord2.sendNickName = msgRecord.sendNickName;
        msgRecord2.senderUid = msgRecord.senderUid;
        msgRecord2.sendType = msgRecord.sendType;
        msgRecord2.senderUin = msgRecord.senderUin;
        msgRecord2.msgSeq = msgRecord.msgSeq;
        msgRecord2.msgTime = msgRecord.msgTime;
        msgRecord2.avatarFlag = msgRecord.avatarFlag;
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        msgRecord2.elements = arrayList;
        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(text));
        AIOMsgItem transformMsgRecordWithType = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).transformMsgRecordWithType(msgRecord2);
        transformMsgRecordWithType.k1(1);
        intent.putExtra(AppConstants.Key.FORWARD_NT_MSG_ID, transformMsgRecordWithType.getMsgRecord().msgId);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID, contact.j());
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, contact.e());
        com.tencent.qqnt.aio.forward.c cVar = forwardHandlers.get(Integer.valueOf(transformMsgRecordWithType.getMsgRecord().msgType));
        if (cVar == null) {
            QLog.e("NtMsgForwardUtils", 1, "startForwardText unSupport msg");
        } else if (!cVar.a(transformMsgRecordWithType, contact, intent)) {
            QLog.e("NtMsgForwardUtils", 1, "startForwardText cannot handle msg");
        } else {
            l.INSTANCE.a().l(transformMsgRecordWithType);
            ForwardBaseOption.startForwardActivityForResult(context, intent, 21);
        }
    }

    public final void y(@NotNull Context context, int forwardType, @NotNull AIOContact contact, @NotNull List<? extends AIOMsgItem> msgList, @NotNull com.tencent.mvi.base.route.j messenger) {
        String j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(forwardType), contact, msgList, messenger);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        QLog.d("NtMsgForwardUtils", 1, "startMultiForwardMsg " + forwardType);
        Intent intent = new Intent();
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        intent.putExtra(AppConstants.Key.FORWARD_NT_MULTI_SELECT, true);
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_UID, contact.j());
        intent.putExtra(AppConstants.Key.FORWARD_NT_SOURCE_CHATTYPE, contact.e());
        intent.putExtra(AppConstants.Key.FORWARD_NT_TYPE, forwardType);
        if (forwardType == 0) {
            String string = context.getString(R.string.mpw);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.qqstr_forwards_0d019093)");
            int e16 = contact.e();
            if (e16 != 1) {
                if (e16 != 2) {
                    j3 = "";
                } else {
                    j3 = context.getString(R.string.l2u) + context.getString(R.string.mq7);
                }
            } else {
                j3 = j(context, msgList);
            }
            intent.putExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE, j3);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, string + j3);
        } else {
            String string2 = context.getString(R.string.mqp);
            String string3 = context.getString(R.string.f172011mqq);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026.qqstr_forwards_b221c326)");
            String format = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(msgList.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            intent.putExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE, context.getString(R.string.f172196o92));
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, string2 + format);
        }
        l.Companion companion = l.INSTANCE;
        companion.a().m(msgList);
        companion.a().n(forwardType);
        companion.a().o(new Contact(contact.e(), contact.j(), ""));
        ForwardBaseOption.startForwardActivityForResult((Activity) context, intent, 21);
    }
}
