package com.tencent.mobileqq.guild.message;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowTimeItem;
import com.tencent.mobileqq.guild.message.unread.DecreaseMsgSeqInfo;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "channelId")
/* loaded from: classes14.dex */
public class GuildMsgSeqTimeItem extends Entity {
    private static final String TAG = "GuildMsgSeqTimeItem";
    public String channelId;
    public String guildId;
    public long lastLocalMsgSeq = -1;
    public long lastLocalCntSeq = -1;
    public long lastLocalMsgTime = 0;
    public byte[] lastLocalMsgMeta = null;
    public long lastSvrMsgSeq = -1;
    public long lastSvrCntSeq = -1;
    public long lastSvrMsgTime = 0;
    public byte[] lastSvrMsgMeta = null;
    public long readedMsgSeq = -1;
    public long readedCntSeq = -1;
    public long readedMsgTime = 0;
    public byte[] readedMsgMeta = null;
    public long lastLocalVisibleMsgSeq = -1;
    public long lastLocalVisibleCntSeq = -1;
    public long lastLocalVisibleMsgTime = 0;
    public byte[] lastLocalVisibleMsgMeta = null;
    public long expiredMsgSeq = 0;
    public byte[] decreaseMsgSeqBytes = null;
    public byte[] eventFlowTimeItemBytes = null;

    @notColumn
    public HashSet<DecreaseMsgSeqInfo> decreaseMsgSeqList = new HashSet<>();

    @notColumn
    public GuildEventFlowTimeItem eventFlowTimeItem = new GuildEventFlowTimeItem();

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0045: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:70), block:B:25:0x0045 */
    @Nullable
    public static Object deserialize(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (bArr == null) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e16) {
                e = e16;
                objectInputStream = null;
            } catch (ClassNotFoundException e17) {
                e = e17;
                objectInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                closeQuietly(closeable2);
                closeQuietly(byteArrayInputStream);
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                closeQuietly(objectInputStream);
                closeQuietly(byteArrayInputStream);
                return readObject;
            } catch (IOException e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "deserialize: failed. ", e);
                }
                closeQuietly(objectInputStream);
                closeQuietly(byteArrayInputStream);
                return null;
            } catch (ClassNotFoundException e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "deserialize: failed. ", e);
                }
                closeQuietly(objectInputStream);
                closeQuietly(byteArrayInputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable2 = closeable;
            closeQuietly(closeable2);
            closeQuietly(byteArrayInputStream);
            throw th;
        }
    }

    private void onPostReadDecreaseMsgSeqList() {
        byte[] bArr = this.decreaseMsgSeqBytes;
        if (bArr != null) {
            Object deserialize = deserialize(bArr);
            if (deserialize instanceof HashSet) {
                this.decreaseMsgSeqList = (HashSet) deserialize;
            }
        }
    }

    private void onPostReadEventFlowTimeItem() {
        byte[] bArr = this.eventFlowTimeItemBytes;
        if (bArr != null) {
            Object deserialize = deserialize(bArr);
            if (deserialize instanceof GuildEventFlowTimeItem) {
                this.eventFlowTimeItem = (GuildEventFlowTimeItem) deserialize;
            }
        }
    }

    private void onPrewriteDecreaseMsgSeqList() {
        HashSet<DecreaseMsgSeqInfo> hashSet = this.decreaseMsgSeqList;
        if (hashSet != null && hashSet.size() != 0) {
            this.decreaseMsgSeqBytes = serialize(this.decreaseMsgSeqList);
        } else {
            this.decreaseMsgSeqBytes = null;
        }
    }

    private void onPrewriteEventFlowTimeItem() {
        this.eventFlowTimeItemBytes = serialize(this.eventFlowTimeItem);
    }

    @Nullable
    public static byte[] serialize(Object obj) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException e16) {
            e = e16;
            objectOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            closeQuietly(objectOutputStream2);
            closeQuietly(byteArrayOutputStream);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                closeQuietly(objectOutputStream);
                closeQuietly(byteArrayOutputStream);
                return byteArray;
            } catch (Throwable th6) {
                th = th6;
                objectOutputStream2 = objectOutputStream;
                closeQuietly(objectOutputStream2);
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (IOException e17) {
            e = e17;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "serialize: failed. ", e);
            }
            closeQuietly(objectOutputStream);
            closeQuietly(byteArrayOutputStream);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        onPostReadDecreaseMsgSeqList();
        onPostReadEventFlowTimeItem();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        onPrewriteDecreaseMsgSeqList();
        onPrewriteEventFlowTimeItem();
    }

    public String toString() {
        return "guildId:" + this.guildId + " channelId:" + this.channelId + " lastLocalMsgSeq:" + this.lastLocalMsgSeq + " lastLocalCntSeq:" + this.lastLocalCntSeq + " lastLocalMsgTime:" + this.lastLocalMsgTime + " lastSvrMsgSeq:" + this.lastSvrMsgSeq + " lastSvrCntSeq:" + this.lastSvrCntSeq + " lastSvrMsgTime:" + this.lastSvrMsgTime + " readedMsgSeq:" + this.readedMsgSeq + " readedCntSeq:" + this.readedCntSeq + " readedMsgTime:" + this.readedMsgTime + " lastLocalVisibleMsgSeq:" + this.lastLocalVisibleMsgSeq + " lastLocalVisibleCntSeq:" + this.lastLocalVisibleCntSeq + " lastLocalVisibleMsgTime:" + this.lastLocalVisibleMsgTime + " expiredMsgSeq:" + this.expiredMsgSeq + " decreaseMsgSeqList:" + this.decreaseMsgSeqList.toString() + " eventFlowTimeItem:" + this.eventFlowTimeItem.toString() + " ";
    }

    public static void closeQuietly(ObjectOutputStream objectOutputStream) {
        if (objectOutputStream != null) {
            try {
                objectOutputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }
}
