package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MOBILE_LIST_ITEM extends JceStruct {
    public int _accountAbi;
    public long _bind_uin;
    public int _commFrdCount;
    public int _flag;
    public long _isFriend;
    public long _isRecommend;
    public String _mobile;
    public String _mobileCode;
    public String _mobileInDCache;
    public String _name;
    public String _nameInDCache;
    public String _nationCode;
    public String _nick_name;
    public long _originBinder;
    public long _recommendDate;
    public int _rmdScore;
    public String _value;

    public MOBILE_LIST_ITEM() {
        this._mobile = "";
        this._name = "";
        this._bind_uin = 0L;
        this._isRecommend = 0L;
        this._value = "";
        this._nationCode = "";
        this._mobileCode = "";
        this._nick_name = "";
        this._isFriend = 0L;
        this._mobileInDCache = "";
        this._nameInDCache = "";
        this._recommendDate = 0L;
        this._originBinder = 0L;
        this._accountAbi = 0;
        this._commFrdCount = 0;
        this._flag = 0;
        this._rmdScore = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this._mobile = jceInputStream.readString(0, true);
        this._name = jceInputStream.readString(1, true);
        this._bind_uin = jceInputStream.read(this._bind_uin, 2, true);
        this._isRecommend = jceInputStream.read(this._isRecommend, 3, false);
        this._value = jceInputStream.readString(4, false);
        this._nationCode = jceInputStream.readString(5, false);
        this._mobileCode = jceInputStream.readString(6, false);
        this._nick_name = jceInputStream.readString(7, false);
        this._isFriend = jceInputStream.read(this._isFriend, 8, false);
        this._mobileInDCache = jceInputStream.readString(9, false);
        this._nameInDCache = jceInputStream.readString(10, false);
        this._recommendDate = jceInputStream.read(this._recommendDate, 11, false);
        this._originBinder = jceInputStream.read(this._originBinder, 12, false);
        this._accountAbi = jceInputStream.read(this._accountAbi, 13, false);
        this._commFrdCount = jceInputStream.read(this._commFrdCount, 14, false);
        this._flag = jceInputStream.read(this._flag, 15, false);
        this._rmdScore = jceInputStream.read(this._rmdScore, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this._mobile, 0);
        jceOutputStream.write(this._name, 1);
        jceOutputStream.write(this._bind_uin, 2);
        jceOutputStream.write(this._isRecommend, 3);
        String str = this._value;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this._nationCode;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this._mobileCode;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this._nick_name;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this._isFriend, 8);
        String str5 = this._mobileInDCache;
        if (str5 != null) {
            jceOutputStream.write(str5, 9);
        }
        String str6 = this._nameInDCache;
        if (str6 != null) {
            jceOutputStream.write(str6, 10);
        }
        jceOutputStream.write(this._recommendDate, 11);
        jceOutputStream.write(this._originBinder, 12);
        jceOutputStream.write(this._accountAbi, 13);
        jceOutputStream.write(this._commFrdCount, 14);
        jceOutputStream.write(this._flag, 15);
        jceOutputStream.write(this._rmdScore, 16);
    }

    public MOBILE_LIST_ITEM(String str, String str2, long j3, long j16, String str3, String str4, String str5, String str6, long j17, String str7, String str8, long j18, long j19, int i3, int i16, int i17, int i18) {
        this._mobile = str;
        this._name = str2;
        this._bind_uin = j3;
        this._isRecommend = j16;
        this._value = str3;
        this._nationCode = str4;
        this._mobileCode = str5;
        this._nick_name = str6;
        this._isFriend = j17;
        this._mobileInDCache = str7;
        this._nameInDCache = str8;
        this._recommendDate = j18;
        this._originBinder = j19;
        this._accountAbi = i3;
        this._commFrdCount = i16;
        this._flag = i17;
        this._rmdScore = i18;
    }
}
