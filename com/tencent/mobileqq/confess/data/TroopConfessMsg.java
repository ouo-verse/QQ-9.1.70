package com.tencent.mobileqq.confess.data;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype21;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TroopConfessMsg implements Externalizable {
    static IPatchRedirector $redirector_;
    public long confessTime;
    public byte confessorSex;
    public long confessorUin;
    public List<TroopConfessMsgItem> items;
    public byte sysMsgFlag;
    public int totalCount;

    public TroopConfessMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.items = new ArrayList();
        }
    }

    public void convertFrom(hummer_commelem$MsgElemInfo_servtype21 hummer_commelem_msgeleminfo_servtype21) {
        long j3;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hummer_commelem_msgeleminfo_servtype21);
            return;
        }
        if (hummer_commelem_msgeleminfo_servtype21.group_confess_msg.has()) {
            hummer_commelem$MsgElemInfo_servtype21.GroupConfessMsg groupConfessMsg = hummer_commelem_msgeleminfo_servtype21.group_confess_msg.get();
            long j16 = 0;
            if (groupConfessMsg.uint64_confess_time.has()) {
                j3 = groupConfessMsg.uint64_confess_time.get();
            } else {
                j3 = 0;
            }
            this.confessTime = j3;
            if (groupConfessMsg.uint64_confessor_uin.has()) {
                j16 = groupConfessMsg.uint64_confessor_uin.get();
            }
            this.confessorUin = j16;
            int i17 = 0;
            if (groupConfessMsg.uint32_confessor_sex.has()) {
                i3 = groupConfessMsg.uint32_confessor_sex.get();
            } else {
                i3 = 0;
            }
            this.confessorSex = (byte) i3;
            if (groupConfessMsg.uint32_sysmsg_flag.has()) {
                i16 = groupConfessMsg.uint32_sysmsg_flag.get();
            } else {
                i16 = 0;
            }
            this.sysMsgFlag = (byte) i16;
            if (groupConfessMsg.uint32_total_topic_count.has()) {
                i17 = groupConfessMsg.uint32_total_topic_count.get();
            }
            this.totalCount = i17;
            if (groupConfessMsg.confess_items.has() && groupConfessMsg.confess_items.size() > 0) {
                for (hummer_commelem$MsgElemInfo_servtype21.GroupConfessItem groupConfessItem : groupConfessMsg.confess_items.get()) {
                    TroopConfessMsgItem troopConfessMsgItem = new TroopConfessMsgItem();
                    troopConfessMsgItem.convertFrom(groupConfessItem);
                    this.items.add(troopConfessMsgItem);
                }
            }
        }
    }

    public byte[] getBytes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            writeExternal(objectOutputStream);
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopConfess", 2, e16.getMessage(), e16);
                return null;
            }
            return null;
        }
    }

    public String getConfessToNick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.items.size() > 0) {
            TroopConfessMsgItem troopConfessMsgItem = this.items.get(0);
            int i3 = troopConfessMsgItem.nickType;
            if (i3 == 0) {
                sb5.append(troopConfessMsgItem.confessToNick);
            } else if (i3 == 1) {
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
                if (!Long.toString(troopConfessMsgItem.confessToUin).equals(qQAppInterface.getCurrentAccountUin())) {
                    Friends u16 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(Long.toString(troopConfessMsgItem.confessToUin));
                    if (u16 != null && u16.isFriend() && !TextUtils.isEmpty(u16.remark)) {
                        sb5.append(u16.remark);
                    } else {
                        sb5.append(troopConfessMsgItem.confessToNick);
                    }
                } else {
                    sb5.append(qQAppInterface.getCurrentNickname());
                }
            }
            if (sb5.length() == 0) {
                sb5.append(Long.toString(troopConfessMsgItem.confessToUin));
            }
        }
        return sb5.toString();
    }

    public long getConfessToUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        List<TroopConfessMsgItem> list = this.items;
        if (list != null && list.size() > 0) {
            return this.items.get(0).confessToUin;
        }
        return 0L;
    }

    public int getConfessTopicId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        List<TroopConfessMsgItem> list = this.items;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.items.get(0).topicId;
    }

    public String getSimpleMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this.items.size() > 0) {
            TroopConfessMsgItem troopConfessMsgItem = this.items.get(0);
            sb5.append(getConfessToNick());
            sb5.append("\uff0c");
            sb5.append(troopConfessMsgItem.topic);
        }
        return sb5.toString();
    }

    public boolean isToSelf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.sApplication.getRuntime();
        Iterator<TroopConfessMsgItem> it = this.items.iterator();
        while (it.hasNext()) {
            if (Long.toString(it.next().confessToUin).equals(qQAppInterface.getCurrentAccountUin())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectInput);
            return;
        }
        if (objectInput.readInt() == 805) {
            this.confessTime = objectInput.readLong();
            this.confessorUin = objectInput.readLong();
            this.confessorSex = objectInput.readByte();
            this.sysMsgFlag = objectInput.readByte();
            this.totalCount = objectInput.readInt();
            List list = (List) objectInput.readObject();
            if (list != null && list.size() > 0) {
                this.items.addAll(list);
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("confessorUin");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.confessorUin);
        sb5.append(",");
        sb5.append("confessTime");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.confessTime);
        sb5.append(",");
        sb5.append("confessorSex");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append((int) this.confessorSex);
        sb5.append(",");
        sb5.append("sysMsgFlag");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append((int) this.sysMsgFlag);
        sb5.append(",");
        sb5.append("totalCount");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.totalCount);
        sb5.append("[");
        Iterator<TroopConfessMsgItem> it = this.items.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().toString());
            sb5.append("\n");
        }
        sb5.append("]");
        return sb5.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectOutput);
            return;
        }
        objectOutput.writeInt(805);
        objectOutput.writeLong(this.confessTime);
        objectOutput.writeLong(this.confessorUin);
        objectOutput.writeByte(this.confessorSex);
        objectOutput.writeByte(this.sysMsgFlag);
        objectOutput.writeInt(this.totalCount);
        objectOutput.writeObject(this.items);
    }
}
