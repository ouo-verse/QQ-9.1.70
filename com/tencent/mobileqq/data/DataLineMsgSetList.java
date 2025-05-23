package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DataLineMsgSetList implements Iterable<DataLineMsgSet> {
    private long nLastId = 0;
    private long nFirstId = 0;
    ArrayList<DataLineMsgSet> mList = new ArrayList<>();

    private void checkFirstLastIdByAddOrModify(DataLineMsgSet dataLineMsgSet) {
        long j3 = this.nFirstId;
        if (j3 == 0 || j3 > dataLineMsgSet.getFirstId()) {
            this.nFirstId = dataLineMsgSet.getFirstId();
        }
        long j16 = this.nLastId;
        if (j16 == 0 || j16 < dataLineMsgSet.getLastId()) {
            this.nLastId = dataLineMsgSet.getLastId();
        }
    }

    private void checkFirstLastIdByRemove() {
        this.nFirstId = 0L;
        this.nLastId = 0L;
        Iterator<DataLineMsgSet> it = this.mList.iterator();
        while (it.hasNext()) {
            checkFirstLastIdByAddOrModify(it.next());
        }
    }

    public synchronized DataLineMsgSet appendToList(DataLineMsgRecord dataLineMsgRecord) {
        DataLineMsgSet dataLineMsgSet;
        if (DataLineMsgSet.isSingle(dataLineMsgRecord)) {
            DataLineMsgSet dataLineMsgSet2 = new DataLineMsgSet(0);
            dataLineMsgSet2.put(0, dataLineMsgRecord);
            this.mList.add(dataLineMsgSet2);
            checkFirstLastIdByAddOrModify(dataLineMsgSet2);
            return dataLineMsgSet2;
        }
        Iterator<DataLineMsgSet> it = this.mList.iterator();
        while (true) {
            if (!it.hasNext()) {
                dataLineMsgSet = null;
                break;
            }
            dataLineMsgSet = it.next();
            if (dataLineMsgSet.getGroupId() == dataLineMsgRecord.groupId && dataLineMsgSet.isSendFromLocal() == dataLineMsgRecord.isSendFromLocal()) {
                break;
            }
        }
        if (dataLineMsgSet == null) {
            dataLineMsgSet = new DataLineMsgSet(dataLineMsgRecord.groupId);
            this.mList.add(dataLineMsgSet);
        }
        dataLineMsgSet.put(Integer.valueOf(dataLineMsgRecord.groupIndex), dataLineMsgRecord);
        checkFirstLastIdByAddOrModify(dataLineMsgSet);
        return dataLineMsgSet;
    }

    public synchronized void clear() {
        this.mList.clear();
        this.nFirstId = 0L;
        this.nLastId = 0L;
    }

    public void copyFrom(DataLineMsgSetList dataLineMsgSetList) {
        Iterator<DataLineMsgSet> it = dataLineMsgSetList.iterator();
        while (it.hasNext()) {
            this.mList.add(it.next());
        }
        this.nFirstId = dataLineMsgSetList.nFirstId;
        this.nLastId = dataLineMsgSetList.nLastId;
    }

    public DataLineMsgSet get(int i3) {
        return this.mList.get(i3);
    }

    public long getFirstId() {
        return this.nFirstId;
    }

    public long getLastId() {
        return this.nLastId;
    }

    public int getSetIndex(long j3) {
        Iterator<DataLineMsgSet> it = this.mList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Iterator<DataLineMsgRecord> it5 = it.next().values().iterator();
            while (it5.hasNext()) {
                if (it5.next().sessionid == j3) {
                    return i3;
                }
            }
            i3++;
        }
        return -1;
    }

    public synchronized boolean insertFrontToList(DataLineMsgRecord dataLineMsgRecord) {
        boolean z16;
        DataLineMsgSet dataLineMsgSet;
        z16 = true;
        if (DataLineMsgSet.isSingle(dataLineMsgRecord)) {
            DataLineMsgSet dataLineMsgSet2 = new DataLineMsgSet(0);
            dataLineMsgSet2.put(0, dataLineMsgRecord);
            this.mList.add(0, dataLineMsgSet2);
            checkFirstLastIdByAddOrModify(dataLineMsgSet2);
        } else {
            Iterator<DataLineMsgSet> it = this.mList.iterator();
            while (true) {
                if (it.hasNext()) {
                    dataLineMsgSet = it.next();
                    if (dataLineMsgSet.getGroupId() == dataLineMsgRecord.groupId && dataLineMsgSet.isSendFromLocal() == dataLineMsgRecord.isSendFromLocal()) {
                        break;
                    }
                } else {
                    dataLineMsgSet = null;
                    break;
                }
            }
            if (dataLineMsgSet == null) {
                dataLineMsgSet = new DataLineMsgSet(dataLineMsgRecord.groupId);
                this.mList.add(0, dataLineMsgSet);
            } else {
                z16 = false;
            }
            dataLineMsgSet.put(Integer.valueOf(dataLineMsgRecord.groupIndex), dataLineMsgRecord);
            checkFirstLastIdByAddOrModify(dataLineMsgSet);
        }
        return z16;
    }

    public boolean isEmpty() {
        return this.mList.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<DataLineMsgSet> iterator() {
        return this.mList.iterator();
    }

    public synchronized boolean remove(DataLineMsgSet dataLineMsgSet) {
        Iterator<DataLineMsgSet> it = this.mList.iterator();
        while (it.hasNext()) {
            DataLineMsgSet next = it.next();
            if (next.equals(dataLineMsgSet)) {
                boolean remove = this.mList.remove(next);
                checkFirstLastIdByRemove();
                return remove;
            }
        }
        return false;
    }

    public int size() {
        return this.mList.size();
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public DataLineMsgSetList m169clone() {
        DataLineMsgSetList dataLineMsgSetList = new DataLineMsgSetList();
        Iterator<DataLineMsgSet> it = this.mList.iterator();
        while (it.hasNext()) {
            dataLineMsgSetList.mList.add(it.next());
        }
        dataLineMsgSetList.nFirstId = this.nFirstId;
        dataLineMsgSetList.nLastId = this.nLastId;
        return dataLineMsgSetList;
    }

    public synchronized DataLineMsgSet remove(int i3) {
        DataLineMsgSet remove;
        remove = this.mList.remove(i3);
        checkFirstLastIdByRemove();
        return remove;
    }

    public synchronized void appendToList(DataLineMsgSet dataLineMsgSet) {
        if (dataLineMsgSet != null) {
            if (dataLineMsgSet.getFirstItem() != null) {
                if (!this.mList.contains(dataLineMsgSet) || dataLineMsgSet.getFirstItem().msgtype == -2073) {
                    this.mList.add(dataLineMsgSet);
                    checkFirstLastIdByAddOrModify(dataLineMsgSet);
                }
                return;
            }
        }
        QLog.w("DataLineMsgSetList", 1, "appendToList, but set is null!!");
    }
}
