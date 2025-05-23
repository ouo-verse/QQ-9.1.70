package com.tencent.imcore.message;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class t implements Cursor {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static b f116733i;

    /* renamed from: d, reason: collision with root package name */
    private y f116734d;

    /* renamed from: e, reason: collision with root package name */
    private List<MessageRecord> f116735e;

    /* renamed from: f, reason: collision with root package name */
    private int f116736f;

    /* renamed from: h, reason: collision with root package name */
    private String[] f116737h;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.imcore.message.t.b
        public Object a(AppRuntime appRuntime, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, this, appRuntime, str, str2);
            }
            return null;
        }

        @Override // com.tencent.imcore.message.t.b
        public Object b(AppRuntime appRuntime, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, this, appRuntime, str, Integer.valueOf(i3));
            }
            return null;
        }

        @Override // com.tencent.imcore.message.t.b
        public Object c(String str, AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) appRuntime);
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface b {
        Object a(AppRuntime appRuntime, String str, String str2);

        Object b(AppRuntime appRuntime, String str, int i3);

        Object c(String str, AppRuntime appRuntime);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37269);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 43)) {
            redirector.redirect((short) 43);
        } else {
            s.a();
            f116733i = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t(y yVar, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) yVar, (Object) list);
            return;
        }
        this.f116736f = -1;
        this.f116737h = new String[]{"_id", "selfuin", "frienduin", "senderuin", "time", "msg", AppConstants.Key.COLUMN_MSG_TYPE, AppConstants.Key.COLUMN_IS_READ, AppConstants.Key.COLUMN_IS_SEND, AppConstants.Key.COLUMN_MSG_SEQ, AppConstants.Key.COLUMN_SHMSG_SEQ, AppConstants.Key.COLUMN_IS_TROOP, AppConstants.Key.COLUMN_EXTRA_FLAG, "troopnick", "friendnick", "versionCode", AppConstants.Key.COLUMN_MSG_DATA, AppConstants.Key.COLUMN_VIP_BUBBLE_ID, AppConstants.Key.COLUMN_MSG_UID, "uniseq", AppConstants.Key.COLUMN_SEND_FAIL_CODE, "versionCode"};
        this.f116734d = yVar;
        this.f116735e = list;
    }

    private Object a(int i3) {
        MessageRecord messageRecord = this.f116735e.get(this.f116736f);
        switch (i3) {
            case 0:
            case 1:
                return Long.valueOf(messageRecord.msgId);
            case 2:
                return messageRecord.selfuin;
            case 3:
                return messageRecord.frienduin;
            case 4:
                return messageRecord.senderuin;
            case 5:
                return Long.valueOf(messageRecord.time);
            case 6:
                return messageRecord.f203106msg;
            case 7:
                return Integer.valueOf(messageRecord.msgtype);
            case 8:
                return Integer.valueOf(messageRecord.isread ? 1 : 0);
            case 9:
                return Integer.valueOf(messageRecord.issend);
            case 10:
                return Long.valueOf(messageRecord.msgseq);
            case 11:
                return Long.valueOf(messageRecord.shmsgseq);
            case 12:
                return Integer.valueOf(messageRecord.istroop);
            case 13:
                return Integer.valueOf(messageRecord.extraflag);
            case 14:
                return f116733i.a(this.f116734d.m1(), messageRecord.senderuin, messageRecord.frienduin);
            case 15:
                return f116733i.b(this.f116734d.m1(), messageRecord.senderuin, messageRecord.istroop);
            case 16:
                return f116733i.c(messageRecord.frienduin, this.f116734d.m1());
            case 17:
                return Integer.valueOf(messageRecord.versionCode);
            case 18:
                return messageRecord.msgData;
            case 19:
                return Long.valueOf(messageRecord.vipBubbleID);
            case 20:
                return Long.valueOf(messageRecord.msgUid);
            case 21:
                return Long.valueOf(messageRecord.uniseq);
            case 22:
                return Integer.valueOf(messageRecord.sendFailCode);
            case 23:
                return Integer.valueOf(messageRecord.versionCode);
            default:
                return null;
        }
    }

    public static void b(b bVar) {
        f116733i = bVar;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        }
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, i3, (Object) charArrayBuffer);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void deactivate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        }
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (byte[]) iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
        Object a16 = a(i3);
        if (a16 instanceof byte[]) {
            return (byte[]) a16;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(a16);
            objectOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return bArr;
        } catch (IOException e16) {
            e16.printStackTrace();
            return bArr;
        }
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f116737h.length;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).intValue();
        }
        if ("_id".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("selfuin".equals(str)) {
            return 2;
        }
        if ("frienduin".equals(str)) {
            return 3;
        }
        if ("senderuin".equals(str)) {
            return 4;
        }
        if ("time".equals(str)) {
            return 5;
        }
        if ("msg".equals(str)) {
            return 6;
        }
        if (AppConstants.Key.COLUMN_MSG_TYPE.equals(str)) {
            return 7;
        }
        if (AppConstants.Key.COLUMN_IS_READ.equals(str)) {
            return 8;
        }
        if (AppConstants.Key.COLUMN_IS_SEND.equals(str)) {
            return 9;
        }
        if (AppConstants.Key.COLUMN_MSG_SEQ.equals(str)) {
            return 10;
        }
        if (AppConstants.Key.COLUMN_SHMSG_SEQ.equals(str)) {
            return 11;
        }
        if (AppConstants.Key.COLUMN_IS_TROOP.equals(str)) {
            return 12;
        }
        if (AppConstants.Key.COLUMN_EXTRA_FLAG.equals(str)) {
            return 13;
        }
        if ("troopnick".equals(str)) {
            return 14;
        }
        if ("friendnick".equals(str)) {
            return 15;
        }
        if ("friendstatus".equals(str)) {
            return 16;
        }
        if ("versionCode".equals(str)) {
            return 17;
        }
        if (AppConstants.Key.COLUMN_MSG_DATA.equals(str)) {
            return 18;
        }
        if (AppConstants.Key.COLUMN_VIP_BUBBLE_ID.equals(str)) {
            return 19;
        }
        if (AppConstants.Key.COLUMN_MSG_UID.equals(str)) {
            return 20;
        }
        if ("uniseq".equals(str)) {
            return 21;
        }
        if (AppConstants.Key.COLUMN_SEND_FAIL_CODE.equals(str)) {
            return 22;
        }
        if ("versionCode".equals(str)) {
            return 23;
        }
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).intValue();
        }
        if (getColumnIndex(str) >= 0) {
            return getColumnIndex(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // android.database.Cursor
    public String getColumnName(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        if (i3 > 0) {
            String[] strArr = this.f116737h;
            if (i3 < strArr.length) {
                return strArr[i3];
            }
            return null;
        }
        return null;
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f116737h;
    }

    @Override // android.database.Cursor
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f116735e.size();
    }

    @Override // android.database.Cursor
    public double getDouble(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Double) iPatchRedirector.redirect((short) 26, (Object) this, i3)).doubleValue();
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (Bundle) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public float getFloat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Float) iPatchRedirector.redirect((short) 27, (Object) this, i3)).floatValue();
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getInt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        Object a16 = a(i3);
        if (a16 == null) {
            return 0;
        }
        return ((Integer) a16).intValue();
    }

    @Override // android.database.Cursor
    public long getLong(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
        }
        Object a16 = a(i3);
        if (a16 == null) {
            return 0L;
        }
        return ((Long) a16).longValue();
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Uri) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public int getPosition() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f116736f;
    }

    @Override // android.database.Cursor
    public short getShort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Short) iPatchRedirector.redirect((short) 10, (Object) this, i3)).shortValue();
        }
        Object a16 = a(i3);
        if (a16 == null) {
            return (short) 0;
        }
        return ((Short) a16).shortValue();
    }

    @Override // android.database.Cursor
    public String getString(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, i3);
        }
        return String.valueOf(a(i3));
    }

    @Override // android.database.Cursor
    public int getType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Integer) iPatchRedirector.redirect((short) 42, (Object) this, i3)).intValue();
        }
        return 0;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        if (getCount() == 0 || this.f116736f == this.f116735e.size()) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        if (this.f116736f < 0) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (this.f116736f == 0) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (this.f116736f == this.f116735e.size() - 1) {
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean isNull(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, i3)).booleanValue();
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public boolean move(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        if (this.f116736f + i3 < this.f116735e.size()) {
            int i16 = this.f116736f;
            if (i16 + i3 >= 0) {
                this.f116736f = i16 + i3;
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        this.f116736f = 0;
        if (this.f116735e.size() <= 0) {
            return false;
        }
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        this.f116736f = this.f116735e.size() - 1;
        return true;
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (this.f116736f <= this.f116735e.size() - 1) {
            this.f116736f++;
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, i3)).booleanValue();
        }
        if (i3 < this.f116735e.size() && i3 >= 0) {
            this.f116736f = i3;
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        int i3 = this.f116736f;
        if (i3 > 0) {
            this.f116736f = i3 - 1;
            return true;
        }
        return false;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) contentObserver);
        }
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) dataSetObserver);
        }
    }

    @Override // android.database.Cursor
    public boolean requery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (Bundle) iPatchRedirector.redirect((short) 38, (Object) this, (Object) bundle);
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) bundle);
        }
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) contentResolver, (Object) uri);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) contentObserver);
        }
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) dataSetObserver);
        }
    }
}
