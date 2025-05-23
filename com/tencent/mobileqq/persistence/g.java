package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.ConversationFacadeExt;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.q;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g extends OGEntityManager {

    /* renamed from: a, reason: collision with root package name */
    public static a f258323a = new h();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a(List<MessageRecord> list);
    }

    public g(SQLiteOpenHelper sQLiteOpenHelper, String str) {
        super(sQLiteOpenHelper, str);
    }

    @NonNull
    private Entity b(String str, Cursor cursor, long j3) {
        boolean z16;
        int i3 = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_TYPE));
        byte[] blob = cursor.getBlob(cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_DATA));
        int i16 = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_EXT_LONG));
        String string = cursor.getString(cursor.getColumnIndex(AppConstants.Key.COLUMN_EXT_STR));
        int i17 = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_IS_TROOP));
        MessageRecord l3 = q.l(i3, blob, i16, string, i17);
        l3.msgData = blob;
        l3._id = j3;
        l3.extLong = i16;
        l3.extStr = string;
        l3.istroop = i17;
        l3.selfuin = cursor.getString(cursor.getColumnIndex("selfuin"));
        l3.frienduin = cursor.getString(cursor.getColumnIndex("frienduin"));
        l3.senderuin = cursor.getString(cursor.getColumnIndex("senderuin"));
        l3.time = cursor.getLong(cursor.getColumnIndex("time"));
        l3.msgtype = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_TYPE));
        boolean z17 = true;
        if (cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_IS_READ)) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        l3.isread = z16;
        l3.issend = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_IS_SEND));
        l3.msgseq = cursor.getLong(cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_SEQ));
        l3.shmsgseq = cursor.getLong(cursor.getColumnIndex(AppConstants.Key.COLUMN_SHMSG_SEQ));
        l3.extraflag = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_EXTRA_FLAG));
        l3.sendFailCode = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_SEND_FAIL_CODE));
        l3.msgId = cursor.getLong(cursor.getColumnIndex("msgId"));
        l3.longMsgIndex = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_LONG_MSG_INDEX));
        l3.longMsgId = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_LONG_MSG_ID));
        l3.longMsgCount = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_LONG_MSG_COUNT));
        l3.msgUid = cursor.getLong(cursor.getColumnIndex(AppConstants.Key.COLUMN_MSG_UID));
        l3.uniseq = cursor.getLong(cursor.getColumnIndex("uniseq"));
        l3.extInt = cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_EXT_INT));
        if (cursor.getInt(cursor.getColumnIndex(AppConstants.Key.COLUMN_IS_VALID)) == 0) {
            z17 = false;
        }
        l3.isValid = z17;
        l3.versionCode = cursor.getInt(cursor.getColumnIndex("versionCode"));
        l3.vipBubbleID = cursor.getLong(cursor.getColumnIndex(AppConstants.Key.COLUMN_VIP_BUBBLE_ID));
        if (l3.versionCode <= 0) {
            l3.f203106msg = cursor.getString(cursor.getColumnIndex("msg"));
        }
        if (j3 != -1 && str != null) {
            l3._status = 1001;
        } else {
            l3._status = 1002;
        }
        l3.postRead();
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List c(Class cls, String str, String[] strArr) {
        return super.rawQuery(cls, str, strArr);
    }

    private void d(List<MessageRecord> list) {
        f258323a.a(list);
    }

    @Override // com.tencent.mobileqq.persistence.OGEntityManager, com.tencent.mobileqq.persistence.EntityManager
    public Entity cursor2Entity(Class<? extends Entity> cls, String str, Cursor cursor, NoColumnErrorHandler noColumnErrorHandler) {
        Entity cursor2Entity;
        if (cursor.isBeforeFirst()) {
            cursor.moveToFirst();
        }
        long j3 = -1;
        try {
            if (cursor.getColumnIndex("_id") >= 0) {
                j3 = cursor.getLong(cursor.getColumnIndex("_id"));
            }
        } catch (Exception unused) {
        }
        try {
            if (cls.getName().equals(MessageRecord.class.getName())) {
                cursor2Entity = b(str, cursor, j3);
            } else {
                cursor2Entity = super.cursor2Entity(cls, str, cursor, null);
            }
            return cursor2Entity;
        } catch (Exception | OutOfMemoryError | VerifyError unused2) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<MessageRecord> e(String str, String[] strArr) {
        List rawQuery = rawQuery(MessageRecord.class, str, strArr);
        d(rawQuery);
        return rawQuery;
    }

    @Override // com.tencent.mobileqq.persistence.EntityManager
    @CallSuper
    public List<? extends Entity> rawQuery(final Class<? extends Entity> cls, final String str, final String[] strArr) {
        return ConversationFacadeExt.f116416a.h(str, new Function0() { // from class: com.tencent.mobileqq.persistence.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List c16;
                c16 = g.this.c(cls, str, strArr);
                return c16;
            }
        });
    }
}
