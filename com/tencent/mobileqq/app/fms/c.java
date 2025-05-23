package com.tencent.mobileqq.app.fms;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.fms.FullMessageSearchResult;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String[] f195622a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70179);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.struct_msg_global_search.name(), IDPCApiConstant.STRUT_MSG_SERVICE_IDS);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgSearch", 2, featureValue);
        }
        f195622a = featureValue.split("\\|");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FullMessageSearchResult.SearchResultItem a(QQAppInterface qQAppInterface, EntityManager entityManager, Cursor cursor, String str, int i3, String str2, b bVar) {
        String b16;
        boolean z16;
        MessageRecord messageRecord;
        String str3;
        FullMessageSearchResult.SearchResultItem searchResultItem = null;
        if (cursor != null && cursor.getCount() != 0 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String lowerCase = str2.toLowerCase(Locale.US);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (cursor.isBeforeFirst()) {
                cursor.moveToFirst();
            }
            while (!cursor.isAfterLast()) {
                if (bVar.f195618i == 3 || bVar.f195618i == 2) {
                    return null;
                }
                int columnIndex = cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_DATA);
                int columnIndex2 = cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_TYPE);
                if (columnIndex >= 0 && columnIndex2 >= 0) {
                    byte[] blob = cursor.getBlob(columnIndex);
                    int i16 = cursor.getInt(columnIndex2);
                    String str4 = "";
                    if (blob != null) {
                        try {
                        } catch (Exception e16) {
                            e = e16;
                            e.printStackTrace();
                            z16 = false;
                            if (z16) {
                            }
                            cursor.moveToNext();
                        }
                        if (blob.length > 0) {
                            if (i16 == -1000) {
                                b16 = new String(blob, "utf-8");
                            } else if (i16 == -1035) {
                                MessageForMixedMsg messageForMixedMsg = new MessageForMixedMsg();
                                messageForMixedMsg.msgData = blob;
                                messageForMixedMsg.doParse();
                                b16 = messageForMixedMsg.f203106msg;
                            } else if (i16 == -2011) {
                                b16 = b(blob);
                            }
                            if (b16 != null) {
                                try {
                                    str3 = new String("");
                                } catch (Exception e17) {
                                    e = e17;
                                    str4 = b16;
                                    e.printStackTrace();
                                    z16 = false;
                                    if (z16) {
                                    }
                                    cursor.moveToNext();
                                }
                            } else {
                                str3 = b16;
                            }
                            str4 = str3.toLowerCase(Locale.US);
                            z16 = str4.contains(lowerCase);
                            if (z16) {
                                if (arrayList.size() < 1 && (messageRecord = (MessageRecord) entityManager.cursor2Entity(MessageRecord.class, null, cursor)) != null) {
                                    messageRecord.f203106msg = str4;
                                    arrayList.add(messageRecord);
                                }
                                int columnIndex3 = cursor.getColumnIndex("uniseq");
                                if (columnIndex3 >= 0) {
                                    arrayList2.add(Long.valueOf(cursor.getLong(columnIndex3)));
                                }
                            }
                        }
                    }
                    b16 = "";
                    if (b16 != null) {
                    }
                    str4 = str3.toLowerCase(Locale.US);
                    z16 = str4.contains(lowerCase);
                    if (z16) {
                    }
                }
                cursor.moveToNext();
            }
            if (arrayList.size() > 0) {
                searchResultItem = new FullMessageSearchResult.SearchResultItem();
                searchResultItem.secondPageList = arrayList;
                searchResultItem.secondPageMessageUniseq = arrayList2;
            }
            d dVar = bVar.f195619j;
            if (dVar != null) {
                dVar.f195623a += cursor.getCount();
                int size = dVar.f195625c + arrayList.size();
                dVar.f195625c = size;
                dVar.f195625c = size + arrayList2.size();
            }
        }
        return searchResultItem;
    }

    private static String b(byte[] bArr) {
        AbsStructMsg d16;
        if (bArr != null && bArr.length > 0 && (d16 = i.d(bArr)) != null) {
            boolean c16 = c(String.valueOf(d16.mMsgServiceID));
            if ((d16 instanceof AbsShareMsg) && c16) {
                AbsShareMsg absShareMsg = (AbsShareMsg) d16;
                String str = absShareMsg.mContentTitle;
                if (TextUtils.isEmpty(str)) {
                    return absShareMsg.mMsgBrief;
                }
                return str;
            }
        }
        return "";
    }

    public static boolean c(String str) {
        String[] strArr;
        if (TextUtils.isEmpty(str) || str.equals("0") || (strArr = f195622a) == null) {
            return false;
        }
        int length = strArr.length;
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
