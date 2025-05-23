package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.onlinestatus.networkhandler.d;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0006*\u0001\u001e\u0018\u0000 \u00112\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J9\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR3\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/networkhandler/b;", "", "", "uin", "", "f", "", "fileSha1", TagName.FILE_TYPE, "e", "filePath", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "callback", "g", "Lcom/tencent/mobileqq/highway/transaction/Transaction;", "a", "Lcom/tencent/mobileqq/highway/transaction/Transaction;", "transaction", "b", "[B", BaseConstants.ATTR_KET_SIF_SESSION, "c", "sessionKey", "d", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "com/tencent/mobileqq/onlinestatus/networkhandler/b$b", "Lcom/tencent/mobileqq/onlinestatus/networkhandler/b$b;", "transactionCallback", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Transaction transaction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private byte[] sigSession;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private byte[] sessionKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String filePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C8187b transactionCallback = new C8187b();

    private final String e(String uin, byte[] fileSha1, String fileType) {
        String lowerCase = (MD5Utils.toMD5(uin) + "-" + HexUtil.bytes2HexStr(fileSha1) + "." + fileType).toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    private final boolean f(String uin) {
        AppRuntime appRuntime;
        boolean z16;
        boolean z17;
        synchronized (SessionInfo.class) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            byte[] bArr = null;
            if (mobileQQ != null) {
                appRuntime = mobileQQ.peekAppRuntime();
            } else {
                appRuntime = null;
            }
            if (appRuntime == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(appRuntime, "MobileQQ.sMobileQQ?.peek\u2026Runtime() ?: return false");
            if (!Intrinsics.areEqual(uin, appRuntime.getCurrentAccountUin())) {
                return false;
            }
            SessionInfo sessionInfo = SessionInfo.getInstance(uin);
            if (sessionInfo == null) {
                return false;
            }
            Intrinsics.checkNotNullExpressionValue(sessionInfo, "getInstance(uin)");
            if (sessionInfo.getHttpconn_sig_session() != null) {
                byte[] httpconn_sig_session = sessionInfo.getHttpconn_sig_session();
                Intrinsics.checkNotNullExpressionValue(httpconn_sig_session, "it.httpconn_sig_session");
                if (httpconn_sig_session.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && sessionInfo.getSessionKey() != null) {
                    byte[] sessionKey = sessionInfo.getSessionKey();
                    Intrinsics.checkNotNullExpressionValue(sessionKey, "it.sessionKey");
                    if (sessionKey.length == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        if (sessionInfo.getHttpconn_sig_session() != null) {
                            int length = sessionInfo.getHttpconn_sig_session().length;
                            this.sigSession = new byte[length];
                            byte[] httpconn_sig_session2 = sessionInfo.getHttpconn_sig_session();
                            byte[] bArr2 = this.sigSession;
                            if (bArr2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(BaseConstants.ATTR_KET_SIF_SESSION);
                                bArr2 = null;
                            }
                            System.arraycopy(httpconn_sig_session2, 0, bArr2, 0, length);
                        }
                        if (sessionInfo.getSessionKey() != null) {
                            int length2 = sessionInfo.getSessionKey().length;
                            this.sessionKey = new byte[length2];
                            byte[] sessionKey2 = sessionInfo.getSessionKey();
                            byte[] bArr3 = this.sessionKey;
                            if (bArr3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("sessionKey");
                            } else {
                                bArr = bArr3;
                            }
                            System.arraycopy(sessionKey2, 0, bArr, 0, length2);
                        }
                        return true;
                    }
                }
            }
            HwServlet.getConfig(appRuntime, uin);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String filePath, Function1 callback, b this$0, String str, String uin) {
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (!FileUtils.fileExists(filePath)) {
            QLog.i("AvatarPreviewUpload", 1, "[upload] file not exist, path=" + filePath);
            callback.invoke(Boolean.FALSE);
            return;
        }
        if (!this$0.f(str)) {
            QLog.i("AvatarPreviewUpload", 1, "[upload] init session failed, path=" + filePath + ".");
            callback.invoke(Boolean.FALSE);
            return;
        }
        d.a a16 = d.f256083a.a(filePath);
        if (a16 == null) {
            QLog.i("AvatarPreviewUpload", 1, "[upload] failed to get file info, path=" + filePath + ".");
            callback.invoke(Boolean.FALSE);
            return;
        }
        String e16 = this$0.e(uin, a16.getSha1(), a16.getCom.tencent.ams.dsdk.monitor.metric.event.TagName.FILE_TYPE java.lang.String());
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        PBBytesField pBBytesField = commFileExtReq.bytes_uuid;
        byte[] bytes = e16.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        pBBytesField.set(ByteStringMicro.copyFrom(bytes));
        this$0.transaction = new Transaction(str, 2011, filePath, 0, a16.getMd5(), (ITransactionCallback) this$0.transactionCallback, commFileExtReq.toByteArray(), false);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        Transaction transaction = null;
        AppRuntime peekAppRuntime = mobileQQ != null ? mobileQQ.peekAppRuntime() : null;
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            QLog.i("AvatarPreviewUpload", 1, "[upload] fail, path=" + filePath + ", app not valid");
            callback.invoke(Boolean.FALSE);
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        if (!Intrinsics.areEqual(str, currentAccountUin)) {
            QLog.i("AvatarPreviewUpload", 1, "[upload] fail, path=" + filePath + ", uin not valid, last self: " + str + " current: " + currentAccountUin);
            callback.invoke(Boolean.FALSE);
            return;
        }
        HwEngine hwEngine = appInterface.getHwEngine();
        Transaction transaction2 = this$0.transaction;
        if (transaction2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transaction");
        } else {
            transaction = transaction2;
        }
        int submitTransactionTask = hwEngine.submitTransactionTask(transaction);
        if (submitTransactionTask != 0) {
            QLog.i("AvatarPreviewUpload", 1, "[upload] fail, path=" + filePath + ", errorCode=" + submitTransactionTask);
            callback.invoke(Boolean.FALSE);
            return;
        }
        QLog.i("AvatarPreviewUpload", 1, "[upload] start, path=" + filePath + ", uuid=" + e16 + " errorCode=" + submitTransactionTask);
    }

    public final void g(@NotNull final String uin, @NotNull final String filePath, @NotNull final Function1<? super Boolean, Unit> callback) {
        final String str;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z16 = true;
        QLog.i("AvatarPreviewUpload", 1, "[upload] path=" + filePath);
        this.filePath = filePath;
        this.callback = callback;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            callback.invoke(Boolean.FALSE);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.networkhandler.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.h(filePath, callback, this, str, uin);
                }
            }, 64, null, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J4\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bH\u0016J>\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/onlinestatus/networkhandler/b$b", "Lcom/tencent/mobileqq/highway/api/ITransactionCallback;", "", "transferedSize", "", "onUpdateProgress", "onSwitch2BackupChannel", "", "respData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", CacheTable.TABLE_NAME, "onSuccess", "retCode", "arg1", "onFailed", "onTransStart", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.networkhandler.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8187b implements ITransactionCallback {
        C8187b() {
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onFailed(int retCode, @Nullable byte[] arg1, @NotNull HashMap<String, String> reportInfo) {
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            String str = b.this.filePath;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
                str = null;
            }
            QLog.i("AvatarPreviewUpload", 1, "[onFailed] retCode=" + retCode + ", path=" + str);
            Function1 function1 = b.this.callback;
            b.this.callback = null;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSuccess(@NotNull byte[] respData, @NotNull HashMap<String, String> reportInfo) {
            Intrinsics.checkNotNullParameter(respData, "respData");
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            String str = b.this.filePath;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
                str = null;
            }
            QLog.i("AvatarPreviewUpload", 1, "[onSuccess] path=" + str);
            Function1 function1 = b.this.callback;
            b.this.callback = null;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onTransStart() {
            String str = b.this.filePath;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
                str = null;
            }
            QLog.i("AvatarPreviewUpload", 1, "[onTransStart] path=" + str);
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onSwitch2BackupChannel() {
        }

        @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
        public void onUpdateProgress(int transferedSize) {
        }
    }
}
