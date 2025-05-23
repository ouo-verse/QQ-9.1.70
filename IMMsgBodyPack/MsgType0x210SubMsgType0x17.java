package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210SubMsgType0x17 extends JceStruct {
    static AddGroup cache_stAddGroup;
    static DelGroup cache_stDelGroup;
    static ModFriendGroup cache_stModFriendGroup;
    static ModGroupName cache_stModGroupName;
    static ModGroupSort cache_stModGroupSort;
    public long dwOpType;
    public AddGroup stAddGroup;
    public DelGroup stDelGroup;
    public ModFriendGroup stModFriendGroup;
    public ModGroupName stModGroupName;
    public ModGroupSort stModGroupSort;

    public MsgType0x210SubMsgType0x17() {
        this.dwOpType = 0L;
        this.stAddGroup = null;
        this.stDelGroup = null;
        this.stModGroupName = null;
        this.stModGroupSort = null;
        this.stModFriendGroup = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dwOpType = jceInputStream.read(this.dwOpType, 0, false);
        if (cache_stAddGroup == null) {
            cache_stAddGroup = new AddGroup();
        }
        this.stAddGroup = (AddGroup) jceInputStream.read((JceStruct) cache_stAddGroup, 1, false);
        if (cache_stDelGroup == null) {
            cache_stDelGroup = new DelGroup();
        }
        this.stDelGroup = (DelGroup) jceInputStream.read((JceStruct) cache_stDelGroup, 2, false);
        if (cache_stModGroupName == null) {
            cache_stModGroupName = new ModGroupName();
        }
        this.stModGroupName = (ModGroupName) jceInputStream.read((JceStruct) cache_stModGroupName, 3, false);
        if (cache_stModGroupSort == null) {
            cache_stModGroupSort = new ModGroupSort();
        }
        this.stModGroupSort = (ModGroupSort) jceInputStream.read((JceStruct) cache_stModGroupSort, 4, false);
        if (cache_stModFriendGroup == null) {
            cache_stModFriendGroup = new ModFriendGroup();
        }
        this.stModFriendGroup = (ModFriendGroup) jceInputStream.read((JceStruct) cache_stModFriendGroup, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.dwOpType, 0);
        AddGroup addGroup = this.stAddGroup;
        if (addGroup != null) {
            jceOutputStream.write((JceStruct) addGroup, 1);
        }
        DelGroup delGroup = this.stDelGroup;
        if (delGroup != null) {
            jceOutputStream.write((JceStruct) delGroup, 2);
        }
        ModGroupName modGroupName = this.stModGroupName;
        if (modGroupName != null) {
            jceOutputStream.write((JceStruct) modGroupName, 3);
        }
        ModGroupSort modGroupSort = this.stModGroupSort;
        if (modGroupSort != null) {
            jceOutputStream.write((JceStruct) modGroupSort, 4);
        }
        ModFriendGroup modFriendGroup = this.stModFriendGroup;
        if (modFriendGroup != null) {
            jceOutputStream.write((JceStruct) modFriendGroup, 5);
        }
    }

    public MsgType0x210SubMsgType0x17(long j3, AddGroup addGroup, DelGroup delGroup, ModGroupName modGroupName, ModGroupSort modGroupSort, ModFriendGroup modFriendGroup) {
        this.dwOpType = j3;
        this.stAddGroup = addGroup;
        this.stDelGroup = delGroup;
        this.stModGroupName = modGroupName;
        this.stModGroupSort = modGroupSort;
        this.stModFriendGroup = modFriendGroup;
    }
}
