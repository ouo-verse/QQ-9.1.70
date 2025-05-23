package com.tencent.mobileqq.confess.data;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype21;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TroopConfessMsgItem implements Externalizable {
    static IPatchRedirector $redirector_;
    public String confessToNick;
    public long confessToUin;
    public int nickType;
    public String topic;
    public int topicId;

    public TroopConfessMsgItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public void convertFrom(hummer_commelem$MsgElemInfo_servtype21.GroupConfessItem groupConfessItem) {
        int i3;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupConfessItem);
            return;
        }
        int i16 = 0;
        if (groupConfessItem.uint32_topic_id.has()) {
            i3 = groupConfessItem.uint32_topic_id.get();
        } else {
            i3 = 0;
        }
        this.topicId = i3;
        if (groupConfessItem.uint64_confess_to_uin.has()) {
            j3 = groupConfessItem.uint64_confess_to_uin.get();
        } else {
            j3 = 0;
        }
        this.confessToUin = j3;
        String str2 = "";
        if (!groupConfessItem.bytes_confess_to_nick.has()) {
            str = "";
        } else {
            str = groupConfessItem.bytes_confess_to_nick.get().toStringUtf8();
        }
        this.confessToNick = str;
        if (groupConfessItem.bytes_topic.has()) {
            str2 = groupConfessItem.bytes_topic.get().toStringUtf8();
        }
        this.topic = str2;
        if (groupConfessItem.uint32_confess_to_nick_type.has()) {
            i16 = groupConfessItem.uint32_confess_to_nick_type.get();
        }
        this.nickType = i16;
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

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectInput);
            return;
        }
        if (objectInput.readInt() == 805) {
            this.topicId = objectInput.readInt();
            this.confessToUin = objectInput.readLong();
            this.confessToNick = objectInput.readUTF();
            this.topic = objectInput.readUTF();
            this.nickType = objectInput.readInt();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("topicId");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.topicId);
        sb5.append(",");
        sb5.append("confessToUin");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.confessToUin);
        sb5.append(",");
        sb5.append("confessToNick");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.confessToNick);
        sb5.append(",");
        sb5.append("topic");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.topic);
        sb5.append(",");
        sb5.append("nickType");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(this.nickType);
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
        objectOutput.writeInt(this.topicId);
        objectOutput.writeLong(this.confessToUin);
        objectOutput.writeUTF(this.confessToNick);
        objectOutput.writeUTF(this.topic);
        objectOutput.writeInt(this.nickType);
    }

    public TroopConfessMsgItem(TroopConfessMsgItem troopConfessMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopConfessMsgItem);
            return;
        }
        this.topicId = troopConfessMsgItem.topicId;
        this.confessToUin = troopConfessMsgItem.confessToUin;
        this.confessToNick = troopConfessMsgItem.confessToNick;
        this.topic = troopConfessMsgItem.topic;
        this.nickType = troopConfessMsgItem.nickType;
    }
}
