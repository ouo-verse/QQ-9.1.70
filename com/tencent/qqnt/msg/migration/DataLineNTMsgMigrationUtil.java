package com.tencent.qqnt.msg.migration;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataLineImportInfo;
import com.tencent.qqnt.kernel.nativeinterface.DataLineImportMsgRecords;
import com.tencent.qqnt.kernel.nativeinterface.DataLineImportQueryParam;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GuildMedal;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MultiTransInfo;
import com.tencent.qqnt.kernel.nativeinterface.PeerUid;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0011\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002\u001a\u0016\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002\u001a&\u0010\u001b\u001a\u00020\u00132\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00172\u0006\u0010\u001a\u001a\u00020\u0019\u001a\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002\u001a\u000e\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002\u001a\u000e\u0010 \u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u0002\u001a\u0010\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\rH\u0002\u001a\u0010\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rH\u0002\u001a\u0010\u0010&\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0002\u00a8\u0006'"}, d2 = {"", "j", "", ReportPlugin.KEY_TABLE_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/DataLineImportInfo;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/DataLineImportQueryParam;", "queryParam", "Lcom/tencent/qqnt/kernel/nativeinterface/DataLineImportMsgRecords;", "g", "", "Lcom/tencent/mobileqq/data/DataLineMsgRecord;", "msgRecords", "", "readCount", "", "nextId", "k", "mrList", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "l", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Lcom/tencent/mobileqq/data/MessageRecord;", "mr", tl.h.F, "uin", "e", "uid", "d", "i", "sendType", "c", "sendStatus", "b", QQBrowserActivity.KEY_MSG_TYPE, "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "DataLineNTMsgMigrationUtil")
/* loaded from: classes24.dex */
public final class DataLineNTMsgMigrationUtil {
    private static final int a(int i3) {
        if (i3 == -1000) {
            return 2;
        }
        return 3;
    }

    private static final int b(int i3) {
        if (i3 != 32768) {
            if (i3 != 32772) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private static final int c(int i3) {
        int i16 = 1;
        if (i3 != 1) {
            i16 = 2;
            if (i3 != 2) {
                return 0;
            }
        }
        return i16;
    }

    @NotNull
    public static final String d(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, uid)) {
            String str = AppConstants.DATALINE_PC_UIN;
            Intrinsics.checkNotNullExpressionValue(str, "{\n        AppConstants.DATALINE_PC_UIN\n    }");
            return str;
        }
        if (PeerUid.DATALINE_PHONE_UID.equals(uid)) {
            String str2 = AppConstants.DATALINE_PHONE_UIN;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n        AppConstants.DATALINE_PHONE_UIN\n    }");
            return str2;
        }
        if (PeerUid.DATALINE_PAD_UID.equals(uid)) {
            String str3 = AppConstants.DATALINE_IPAD_UIN;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n        AppConstants.DATALINE_IPAD_UIN\n    }");
            return str3;
        }
        return "";
    }

    @NotNull
    public static final String e(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (AppConstants.DATALINE_PC_UIN.equals(uin)) {
            return PeerUid.DATALINE_PC_UID;
        }
        if (AppConstants.DATALINE_PHONE_UIN.equals(uin)) {
            return PeerUid.DATALINE_PHONE_UID;
        }
        if (AppConstants.DATALINE_IPAD_UIN.equals(uin)) {
            return PeerUid.DATALINE_PAD_UID;
        }
        return "";
    }

    @NotNull
    public static final DataLineImportInfo f(@NotNull String tableName) {
        QQAppInterface qQAppInterface;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.d("DataLineNTMsgMigrationUtil", 2, "getDataLineImportInfosByTableName app is null");
            return new DataLineImportInfo();
        }
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IMessageFacade.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026rocessConstant.MAIN\n    )");
        int quickDBMsgCount = ((IMessageFacade) runtimeService).getQuickDBMsgCount(tableName, -1L, -1L, false);
        if (quickDBMsgCount <= 0) {
            QLog.d("DataLineNTMsgMigrationUtil", 2, "getAndroidImportTableInfos totalCount is " + quickDBMsgCount);
            return new DataLineImportInfo();
        }
        long g16 = r.f359707a.g(tableName);
        QLog.d("DataLineNTMsgMigrationUtil", 1, "getAndroidImportTableInfos tableName is " + tableName + ", quickDBCount:" + quickDBMsgCount + ", quickMaxId:" + g16);
        return new DataLineImportInfo(tableName, quickDBMsgCount, g16);
    }

    @NotNull
    public static final DataLineImportMsgRecords g(@NotNull DataLineImportQueryParam queryParam) {
        QQAppInterface qQAppInterface;
        List<DataLineMsgRecord> w3;
        List<DataLineMsgRecord> w16;
        List<DataLineMsgRecord> w17;
        Intrinsics.checkNotNullParameter(queryParam, "queryParam");
        r rVar = r.f359707a;
        String str = queryParam.tableName;
        Intrinsics.checkNotNullExpressionValue(str, "queryParam.tableName");
        String o16 = rVar.o(str, queryParam.startIndex, queryParam.readCount);
        if (o16 != null && !Intrinsics.areEqual(o16, "")) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            if (qQAppInterface == null) {
                QLog.d("DataLineNTMsgMigrationUtil", 2, "getAndroidImportParseMsgs app is null");
                return new DataLineImportMsgRecords();
            }
            System.currentTimeMillis();
            QLog.d("DataLineNTMsgMigrationUtil", 1, "getQuickDbMessage sql:" + o16);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            if (Intrinsics.areEqual("mr_data_line", queryParam.tableName) && (w17 = qQAppInterface.getDataLineMsgProxy(0).w(o16)) != null) {
                arrayList.addAll(w17);
            }
            if (Intrinsics.areEqual("mr_data_line_phone", queryParam.tableName) && (w16 = qQAppInterface.getDataLineMsgProxy(2).w(o16)) != null) {
                arrayList.addAll(w16);
            }
            if (Intrinsics.areEqual("mr_data_line_ipad", queryParam.tableName) && (w3 = qQAppInterface.getDataLineMsgProxy(1).w(o16)) != null) {
                arrayList.addAll(w3);
            }
            if (!arrayList.isEmpty()) {
                i3 = (int) ((DataLineMsgRecord) arrayList.get(arrayList.size() - 1)).getId();
            }
            System.currentTimeMillis();
            QLog.d("DataLineNTMsgMigrationUtil", 1, "parseDataLineMsgRecords size:" + arrayList.size());
            return k(arrayList, arrayList.size(), i3);
        }
        return new DataLineImportMsgRecords();
    }

    @NotNull
    public static final MsgRecord h(@NotNull ArrayList<MsgElement> msgElements, @NotNull MessageRecord mr5) {
        int i3;
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(mr5, "mr");
        long j3 = mr5.uniseq;
        int a16 = a(mr5.msgtype);
        int c16 = c(mr5.issend);
        long j16 = mr5.time;
        byte[] bArr = new byte[0];
        int b16 = b(mr5.extraflag);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        FreqLimitInfo freqLimitInfo = new FreqLimitInfo(0, 0, 0L);
        GuildClientIdentity guildClientIdentity = new GuildClientIdentity();
        FromRoleInfo fromRoleInfo = new FromRoleInfo();
        FromRoleInfo fromRoleInfo2 = new FromRoleInfo();
        FromRoleInfo fromRoleInfo3 = new FromRoleInfo();
        byte[] bArr2 = new byte[0];
        if (msgElements.size() > 1) {
            i3 = msgElements.size();
        } else {
            i3 = 0;
        }
        return new MsgRecord(0L, j3, 0L, 0L, 8, a16, 0, c16, "", "", "", "", 0L, 0L, 0L, j16, bArr, b16, "", "", "", "", "", msgElements, arrayList, arrayList2, 0L, 0, arrayList3, "", freqLimitInfo, false, "", "", "", 0L, 0L, guildClientIdentity, true, 0, 0, fromRoleInfo, fromRoleInfo2, fromRoleInfo3, 0L, false, bArr2, 0L, Integer.valueOf(i3), new FoldingInfo(), new MultiTransInfo(), 0L, 0L, new HashMap(), new AnonymousExtInfo(), 0, 0, new byte[0], new GuildMedal(), 0, null);
    }

    public static final int i(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (Intrinsics.areEqual(PeerUid.DATALINE_PC_UID, uid)) {
            return 6000;
        }
        if (Intrinsics.areEqual(PeerUid.DATALINE_PHONE_UID, uid)) {
            return 6005;
        }
        if (Intrinsics.areEqual(PeerUid.DATALINE_PAD_UID, uid)) {
            return 6003;
        }
        return 0;
    }

    public static final boolean j() {
        QQAppInterface qQAppInterface;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            QLog.d("DataLineNTMsgMigrationUtil", 2, "isHasDataLineMsgToImport app is null");
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("mr_data_line");
            arrayList.add("mr_data_line_phone");
            arrayList.add("mr_data_line_ipad");
            QRouteApi api = QRoute.api(IMessageFacadeService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(\n            IMessag\u2026ice::class.java\n        )");
            IMessageFacadeService iMessageFacadeService = (IMessageFacadeService) api;
            EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
            Intrinsics.checkNotNullExpressionValue(createEntityManager, "app.getEntityManagerFact\u2026y().createEntityManager()");
            Iterator it = arrayList.iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                Message S = iMessageFacadeService.getMessageProxy(qQAppInterface, 0).S(str2, createEntityManager);
                if (S != null) {
                    str = S.frienduin;
                } else {
                    str = null;
                }
                if (str != null) {
                    QLog.d("DataLineNTMsgMigrationUtil", 1, "isHasDataLineMsgToImport tableName:" + str2);
                    z16 = true;
                }
            }
            return z16;
        } catch (Throwable unused) {
            QLog.d("DataLineNTMsgMigrationUtil", 2, "isHasDataLineMsgToImport throwable");
            return false;
        }
    }

    private static final DataLineImportMsgRecords k(List<? extends DataLineMsgRecord> list, int i3, long j3) {
        String joinToString$default;
        List listOf;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        List<? extends DataLineMsgRecord> list2 = list;
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((DataLineMsgRecord) next).groupId > 0) {
                z17 = true;
            }
            if (z17) {
                arrayList2.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayList2) {
            Integer valueOf = Integer.valueOf(((DataLineMsgRecord) obj).groupId);
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        QLog.d("DataLineNTMsgMigrationUtil", 1, "parseDataLineMsgRecords multi pic msg, size:" + linkedHashMap.size());
        Iterator it5 = linkedHashMap.entrySet().iterator();
        while (it5.hasNext()) {
            try {
                arrayList.add(l((List) ((Map.Entry) it5.next()).getValue()));
            } catch (Throwable th5) {
                QLog.e("DataLineNTMsgMigrationUtil", 1, "parseDataLineMsgRecords error", th5);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : list2) {
            if (((DataLineMsgRecord) obj3).groupId == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj3);
            }
        }
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            try {
                listOf = CollectionsKt__CollectionsJVMKt.listOf((DataLineMsgRecord) it6.next());
                arrayList.add(l(listOf));
            } catch (Throwable th6) {
                QLog.e("DataLineNTMsgMigrationUtil", 1, "parseDataLineMsgRecords error", th6);
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, DataLineNTMsgMigrationUtil$parseDataLineMsgRecords$4.INSTANCE, 31, null);
        QLog.d("DataLineNTMsgMigrationUtil", 1, "parseDataLineMsgRecords " + joinToString$default);
        return new DataLineImportMsgRecords(linkedHashMap.size(), j3, arrayList);
    }

    private static final MsgRecord l(List<? extends DataLineMsgRecord> list) {
        Object first;
        boolean z16;
        ArrayList arrayList;
        Iterator it;
        String str;
        int i3;
        MsgElement msgElement;
        int i16;
        MsgElement msgElement2;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            DataLineMsgRecord dataLineMsgRecord = (DataLineMsgRecord) it5.next();
            MsgElement msgElement3 = new MsgElement();
            if (dataLineMsgRecord.msgtype == -1000) {
                TextElement textElement = new TextElement();
                textElement.content = dataLineMsgRecord.f203106msg;
                msgElement3.textElement = textElement;
                it = it5;
                arrayList2 = arrayList3;
                msgElement2 = msgElement3;
            } else {
                String bytes2HexStr = HexUtil.bytes2HexStr(dataLineMsgRecord.md5);
                String str2 = dataLineMsgRecord.filename;
                String path = dataLineMsgRecord.path;
                long j3 = dataLineMsgRecord.filesize;
                String str3 = dataLineMsgRecord.thumbPath;
                String str4 = dataLineMsgRecord.serverPath;
                int i17 = 5;
                if (path != null) {
                    Intrinsics.checkNotNullExpressionValue(path, "path");
                    if (new File(path).exists() || dataLineMsgRecord.bIsSended) {
                        i17 = 4;
                    }
                }
                String str5 = dataLineMsgRecord.path;
                if (str5 != null && str5.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16 && new File(dataLineMsgRecord.path).exists()) {
                    arrayList = arrayList3;
                    it = it5;
                    msgElement = msgElement3;
                    str = str4;
                    i16 = i17;
                } else {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                    QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
                    String str6 = dataLineMsgRecord.senderuin;
                    Intrinsics.checkNotNullExpressionValue(str6, "mr.senderuin");
                    int i18 = i(e(str6));
                    arrayList = arrayList3;
                    it = it5;
                    FileManagerEntity E = qQAppInterface.getFileManagerDataCenter().E(dataLineMsgRecord.sessionid, dataLineMsgRecord.senderuin, i18);
                    if (E == null) {
                        str = str4;
                        i3 = i17;
                        E = qQAppInterface.getFileManagerDataCenter().E(dataLineMsgRecord.uniseq, dataLineMsgRecord.senderuin, i18);
                    } else {
                        str = str4;
                        i3 = i17;
                    }
                    if (E != null) {
                        E.nOpType = 1;
                        long j16 = dataLineMsgRecord.uniseq;
                        long j17 = dataLineMsgRecord.sessionid;
                        msgElement = msgElement3;
                        StringBuilder sb5 = new StringBuilder();
                        i16 = i3;
                        sb5.append("update uniseq: ");
                        sb5.append(j16);
                        sb5.append(", session: ");
                        sb5.append(j17);
                        sb5.append(", mr: ");
                        sb5.append(dataLineMsgRecord);
                        sb5.append(" ");
                        sb5.append(E);
                        sb5.append(" nOpType to OPERATION_TYPE_RECV");
                        QLog.eAsync("DataLineNTMsgMigrationUtil", 1, sb5.toString());
                        qQAppInterface.getFileManagerDataCenter().f0(E);
                    } else {
                        msgElement = msgElement3;
                        i16 = i3;
                    }
                }
                HashMap<Integer, String> hashMap = new HashMap<>();
                hashMap.put(750, str3);
                FileElement fileElement = new FileElement();
                fileElement.fileMd5 = bytes2HexStr;
                fileElement.fileName = str2;
                fileElement.filePath = path;
                fileElement.fileSize = j3;
                fileElement.picThumbPath = hashMap;
                fileElement.fileUuid = str;
                fileElement.transferStatus = Integer.valueOf(i16);
                fileElement.fileTransType = 1;
                fileElement.fileGroupIndex = Integer.valueOf(dataLineMsgRecord.groupIndex);
                msgElement2 = msgElement;
                msgElement2.fileElement = fileElement;
                msgElement2.elementId = dataLineMsgRecord.sessionid;
                arrayList2 = arrayList;
            }
            arrayList2.add(msgElement2);
            arrayList3 = arrayList2;
            it5 = it;
        }
        ArrayList arrayList4 = arrayList3;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
        return h(arrayList4, (MessageRecord) first);
    }
}
