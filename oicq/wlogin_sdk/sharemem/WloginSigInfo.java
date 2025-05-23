package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WloginSigInfo implements Serializable, Parcelable {
    public static final int SIG_RESERVE_LENGTH = 16;
    public static final int SIG_RESERVE_VALID_LENGTH = 7;
    private static final long serialVersionUID = 1;
    public long _A1_version;
    public long _A2_create_time;
    public long _A2_expire_time;
    public byte[] _D2;
    public byte[] _D2Key;
    public long _D2_create_time;
    public long _D2_expire_time;
    public byte[] _DA2;
    public byte[] _G;
    public byte[] _TGT;
    public byte[] _TGTKey;
    public byte[] _access_token;
    public long _access_token_create_time;
    public long _app_pri;
    public byte[] _aqSig;
    public long _aqSig_create_time;
    public long _create_time;
    public byte[] _device_token;
    public byte[] _dpwd;
    public byte[] _en_A1;
    public int _login_bitmap;
    public byte[] _lsKey;
    public long _lsKey_create_time;
    public long _lsKey_expire_time;
    public byte[] _noPicSig;
    public byte[] _openid;
    public byte[] _openkey;
    public long _openkey_create_time;
    public byte[] _pay_token;
    public byte[] _pf;
    public byte[] _pfKey;
    public byte[] _psKey;
    public long _psKey_create_time;
    public byte[] _pt4Token;
    public byte[] _randseed;
    public byte[] _sKey;
    public long _sKey_create_time;
    public long _sKey_expire_time;
    public byte[] _sid;
    public long _sid_create_time;
    public long _sid_expire_time;
    public byte[] _superKey;
    public byte[] _userA5;
    public long _userA5_create_time;
    public byte[] _userA8;
    public long _userA8_create_time;
    public long _userA8_expire_time;
    public byte[] _userSig64;
    public long _userSig64_create_time;
    public byte[] _userStSig;
    public long _userStSig_create_time;
    public byte[] _userStWebSig;
    public long _userStWebSig_create_time;
    public long _userStWebSig_expire_time;
    public byte[] _userSt_Key;
    public long _vKey_expire_time;
    public byte[] _vkey;
    public long _vkey_create_time;
    public transient List<Ticket> cacheTickets;
    public transient long cacheUpdateStamp;
    public int mainSigMap;
    public byte[] wtSessionTicket;
    public long wtSessionTicketCreatTime;
    public byte[] wtSessionTicketKey;
    public static byte[] _LHSig = new byte[0];
    public static byte[] _QRPUSHSig = new byte[0];
    public static final Parcelable.Creator<WloginSigInfo> CREATOR = new Parcelable.Creator<WloginSigInfo>() { // from class: oicq.wlogin_sdk.sharemem.WloginSigInfo.1
        @Override // android.os.Parcelable.Creator
        public WloginSigInfo createFromParcel(Parcel parcel) {
            return new WloginSigInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public WloginSigInfo[] newArray(int i3) {
            return new WloginSigInfo[i3];
        }
    };

    public WloginSigInfo(long j3, long j16, long j17, long j18, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13, long[] jArr, int i3) {
        this._TGT = new byte[0];
        this._TGTKey = new byte[0];
        this._userStSig = new byte[0];
        this._userSt_Key = new byte[0];
        this._userStWebSig = new byte[0];
        this._userA5 = new byte[0];
        this._userA8 = new byte[0];
        this._lsKey = new byte[0];
        this._sKey = new byte[0];
        this._userSig64 = new byte[0];
        this._openid = new byte[0];
        this._openkey = new byte[0];
        this._vkey = new byte[0];
        this._en_A1 = new byte[0];
        this._access_token = new byte[0];
        this._D2 = new byte[0];
        this._D2Key = new byte[0];
        this._sid = new byte[0];
        this._noPicSig = new byte[0];
        this._aqSig = new byte[0];
        this._psKey = new byte[0];
        this._pt4Token = new byte[0];
        this._superKey = new byte[0];
        this._G = new byte[0];
        this._dpwd = new byte[0];
        this._randseed = new byte[0];
        this._pay_token = new byte[0];
        this._pf = new byte[0];
        this._pfKey = new byte[0];
        this._DA2 = new byte[0];
        this._app_pri = 0L;
        this._login_bitmap = 0;
        this._A2_expire_time = 0L;
        this._lsKey_expire_time = 0L;
        this._sKey_expire_time = 0L;
        this._vKey_expire_time = 0L;
        this._userA8_expire_time = 0L;
        this._userStWebSig_expire_time = 0L;
        this._D2_expire_time = 0L;
        this._sid_expire_time = 0L;
        this._create_time = 0L;
        this._A2_create_time = 0L;
        this._userStSig_create_time = 0L;
        this._userStWebSig_create_time = 0L;
        this._userA5_create_time = 0L;
        this._userA8_create_time = 0L;
        this._lsKey_create_time = 0L;
        this._sKey_create_time = 0L;
        this._userSig64_create_time = 0L;
        this._openkey_create_time = 0L;
        this._vkey_create_time = 0L;
        this._access_token_create_time = 0L;
        this._D2_create_time = 0L;
        this._sid_create_time = 0L;
        this._aqSig_create_time = 0L;
        this._psKey_create_time = 0L;
        this.wtSessionTicket = new byte[0];
        this.wtSessionTicketKey = new byte[0];
        this._device_token = new byte[0];
        this._A1_version = 0L;
        this.cacheTickets = null;
        SetSigInfo(j3, j16, j17, j18, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, jArr, i3);
    }

    public WloginSigInfo Set(long j3, long j16, long j17, long j18, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13, long[] jArr, int i3) {
        SetSigInfo(j3, j16, j17, j18, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, jArr, i3);
        return this;
    }

    public void SetSigInfo(long j3, long j16, long j17, long j18, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13, long[] jArr, int i3) {
        String str;
        String str2;
        int length;
        int length2;
        byte[] bArr14;
        String str3;
        if (bArr13 == null || bArr13.length != 16) {
            str = "";
            str2 = "ERROR:reserve null or length not right";
        } else {
            if (jArr != null && jArr.length == 7) {
                this._app_pri = j3;
                this._A2_expire_time = j18;
                this._login_bitmap |= i3;
                if (bArr != null && bArr.length > 0) {
                    this._TGT = (byte[]) bArr.clone();
                    this._A2_create_time = j16;
                }
                if (bArr2 != null && bArr2.length > 0) {
                    this._TGTKey = (byte[]) bArr2.clone();
                }
                if (bArr3 != null && bArr3.length > 0) {
                    this._userStSig = (byte[]) bArr3.clone();
                    this._userStSig_create_time = j16;
                }
                if (bArr4 != null && bArr4.length > 0) {
                    this._userSt_Key = (byte[]) bArr4.clone();
                }
                if (bArr5 != null && bArr5.length > 0) {
                    this._userStWebSig = (byte[]) bArr5.clone();
                    this._userStWebSig_create_time = j16;
                    this._userStWebSig_expire_time = jArr[4] + j16;
                }
                if (bArr6 != null && bArr6.length > 0) {
                    this._userA5 = (byte[]) bArr6.clone();
                    this._userA5_create_time = j16;
                }
                if (bArr7 != null && bArr7.length > 0) {
                    this._userA8 = (byte[]) bArr7.clone();
                    this._userA8_create_time = j16;
                    this._userA8_expire_time = jArr[3] + j16;
                }
                if (bArr8 != null && bArr8.length > 0) {
                    this._lsKey = (byte[]) bArr8.clone();
                    this._lsKey_create_time = j16;
                    this._lsKey_expire_time = jArr[0] + j16;
                }
                util.LOGI("set skey " + util.getMaskBytes(bArr9, 2, 2), "");
                if (bArr9 != null && bArr9.length > 0) {
                    this._sKey = (byte[]) bArr9.clone();
                    this._sKey_create_time = j16;
                    this._sKey_expire_time = jArr[1] + j16;
                }
                if (bArr10 != null && bArr10.length > 0) {
                    this._userSig64 = (byte[]) bArr10.clone();
                    this._userSig64_create_time = j16;
                }
                if (bArr11 != null && bArr11.length > 0) {
                    this._openid = (byte[]) bArr11.clone();
                }
                if (bArr12 != null && bArr12.length > 0) {
                    this._openkey = (byte[]) bArr12.clone();
                    this._openkey_create_time = j16;
                }
                byte[] bArr15 = bArr13[0];
                if (bArr15 != null && bArr15.length > 0) {
                    this._vkey = (byte[]) bArr15.clone();
                    this._vkey_create_time = j16;
                    this._vKey_expire_time = jArr[2] + j16;
                }
                byte[] bArr16 = bArr13[1];
                if (bArr16 != null && bArr16.length > 0) {
                    this._access_token = (byte[]) bArr16.clone();
                    this._access_token_create_time = j16;
                }
                byte[] bArr17 = bArr13[2];
                if (bArr17 != null && bArr17.length > 0) {
                    this._D2 = (byte[]) bArr17.clone();
                    this._D2_create_time = j16;
                    this._D2_expire_time = jArr[5] + j16;
                }
                byte[] bArr18 = bArr13[3];
                if (bArr18 != null && bArr18.length > 0) {
                    this._D2Key = (byte[]) bArr18.clone();
                }
                byte[] bArr19 = bArr13[4];
                if (bArr19 != null && bArr19.length > 0) {
                    this._sid = (byte[]) bArr19.clone();
                    this._sid_create_time = j16;
                    this._sid_expire_time = jArr[6] + j16;
                }
                byte[] bArr20 = bArr13[5];
                if (bArr20 != null && bArr20.length > 0) {
                    this._aqSig = (byte[]) bArr20.clone();
                    this._aqSig_create_time = j16;
                }
                byte[] bArr21 = bArr13[6];
                if (bArr21 != null && bArr21.length >= 2) {
                    this._psKey = (byte[]) bArr21.clone();
                    this._psKey_create_time = j16;
                }
                byte[] bArr22 = bArr13[7];
                if (bArr22 != null && bArr22.length > 0) {
                    this._superKey = (byte[]) bArr22.clone();
                    this._psKey_create_time = j16;
                }
                byte[] bArr23 = bArr13[8];
                if (bArr23 != null && bArr23.length > 0) {
                    this._pay_token = (byte[]) bArr23.clone();
                }
                byte[] bArr24 = bArr13[9];
                if (bArr24 != null && bArr24.length > 0) {
                    this._pf = (byte[]) bArr24.clone();
                }
                byte[] bArr25 = bArr13[10];
                if (bArr25 != null && bArr25.length > 0) {
                    this._pfKey = (byte[]) bArr25.clone();
                }
                byte[] bArr26 = this._DA2;
                if (bArr26 == null) {
                    util.LOGI("_DA2 is null", "");
                    length = 0;
                } else {
                    length = bArr26.length;
                }
                byte[] bArr27 = bArr13[11];
                if (bArr27 == null) {
                    util.LOGI("reserve[11] is null", "");
                    length2 = 0;
                } else {
                    length2 = bArr27.length;
                }
                util.LOGI("mainSigMap 0x" + Integer.toHexString(this.mainSigMap) + " file da2 len " + length + " rsp da2 len " + length2, "");
                byte[] bArr28 = bArr13[11];
                if (bArr28 != null) {
                    if (bArr28.length > 0) {
                        this._DA2 = (byte[]) bArr28.clone();
                        str3 = "get _DA2";
                    } else if ((this.mainSigMap & 33554432) != 0) {
                        this._DA2 = new byte[0];
                        str3 = "clear _DA2";
                    }
                    util.LOGI(str3, "");
                }
                byte[] bArr29 = bArr13[12];
                if (bArr29 != null && bArr29.length > 2) {
                    this._pt4Token = (byte[]) bArr29.clone();
                }
                byte[] bArr30 = bArr13[13];
                if (bArr30 != null && bArr30.length > 0 && (bArr14 = bArr13[14]) != null && bArr14.length > 0) {
                    this.wtSessionTicket = bArr30;
                    this.wtSessionTicketKey = bArr14;
                    this.wtSessionTicketCreatTime = u.e();
                }
                byte[] bArr31 = bArr13[15];
                if (bArr31 == null || bArr31.length <= 0) {
                    return;
                }
                this._device_token = bArr31;
                return;
            }
            str = "";
            str2 = "reserve_valid null or length not right";
        }
        util.LOGI(str2, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAllTicketString() {
        return "A1[" + this._en_A1.length + "][" + this._create_time + "]\nA2[" + this._TGT.length + "][0]\nPskey[" + this._psKey.length + "][" + this._psKey_create_time + "]\nPt4token[" + this._pt4Token.length + "][0]\nWtST[" + this.wtSessionTicket.length + "][0]\nWtSTKey" + this.wtSessionTicketKey.length + "][0]\n";
    }

    public boolean iSExpireA2(long j3) {
        if (j3 > this._A2_expire_time) {
            return true;
        }
        return false;
    }

    public boolean isWtSessionTicketExpired() {
        long j3 = this.wtSessionTicketCreatTime + 2592000;
        long e16 = u.e();
        if (e16 > j3) {
            return true;
        }
        if (j3 > 2592000 + e16) {
            util.LOGI("time for system may be  modified manually expireTime " + j3 + " current " + e16, "");
            return true;
        }
        return false;
    }

    public void readFromParcel(Parcel parcel) {
        this._TGT = parcel.createByteArray();
        this._TGTKey = parcel.createByteArray();
        this._userStSig = parcel.createByteArray();
        this._userSt_Key = parcel.createByteArray();
        this._userStWebSig = parcel.createByteArray();
        this._userA5 = parcel.createByteArray();
        this._userA8 = parcel.createByteArray();
        this._lsKey = parcel.createByteArray();
        this._sKey = parcel.createByteArray();
        this._userSig64 = parcel.createByteArray();
        this._openid = parcel.createByteArray();
        this._openkey = parcel.createByteArray();
        this._vkey = parcel.createByteArray();
        this._en_A1 = parcel.createByteArray();
        this._access_token = parcel.createByteArray();
        this._D2 = parcel.createByteArray();
        this._D2Key = parcel.createByteArray();
        this._sid = parcel.createByteArray();
        this._noPicSig = parcel.createByteArray();
        this._aqSig = parcel.createByteArray();
        this._psKey = parcel.createByteArray();
        this._superKey = parcel.createByteArray();
        this._G = parcel.createByteArray();
        this._dpwd = parcel.createByteArray();
        this._randseed = parcel.createByteArray();
        this._login_bitmap = parcel.readInt();
        this._app_pri = parcel.readLong();
        this._A2_expire_time = parcel.readLong();
        this._lsKey_expire_time = parcel.readLong();
        this._sKey_expire_time = parcel.readLong();
        this._vKey_expire_time = parcel.readLong();
        this._userA8_expire_time = parcel.readLong();
        this._userStWebSig_expire_time = parcel.readLong();
        this._D2_expire_time = parcel.readLong();
        this._sid_expire_time = parcel.readLong();
        this._create_time = parcel.readLong();
        this._A2_create_time = parcel.readLong();
        this._userStSig_create_time = parcel.readLong();
        this._userStWebSig_create_time = parcel.readLong();
        this._userA5_create_time = parcel.readLong();
        this._userA8_create_time = parcel.readLong();
        this._lsKey_create_time = parcel.readLong();
        this._sKey_create_time = parcel.readLong();
        this._userSig64_create_time = parcel.readLong();
        this._openkey_create_time = parcel.readLong();
        this._vkey_create_time = parcel.readLong();
        this._access_token_create_time = parcel.readLong();
        this._D2_create_time = parcel.readLong();
        this._sid_create_time = parcel.readLong();
        this._aqSig_create_time = parcel.readLong();
        this._psKey_create_time = parcel.readLong();
        this._pay_token = parcel.createByteArray();
        this._pf = parcel.createByteArray();
        this._pfKey = parcel.createByteArray();
        this._DA2 = parcel.createByteArray();
        this._pt4Token = parcel.createByteArray();
        this.wtSessionTicket = parcel.createByteArray();
        this.wtSessionTicketKey = parcel.createByteArray();
        this._device_token = parcel.createByteArray();
        this._A1_version = parcel.readLong();
        this.wtSessionTicketCreatTime = parcel.readLong();
    }

    public WloginSigInfo setDA2(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this._DA2 = (byte[]) bArr.clone();
        } else {
            util.LOGI("WloginSiginfo.setDA2 da2 0", "");
            this._DA2 = new byte[0];
        }
        return this;
    }

    public WloginSigInfo setNetST(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.wtSessionTicket = (byte[]) bArr.clone();
        this.wtSessionTicketKey = (byte[]) bArr2.clone();
        return this;
    }

    public WloginSigInfo setRandSeed(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            this._randseed = (byte[]) bArr.clone();
        }
        return this;
    }

    public String toString() {
        try {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[13];
            int i3 = 0;
            objArr[0] = Integer.valueOf(this._en_A1.length);
            objArr[1] = Long.valueOf(this._create_time);
            objArr[2] = Integer.valueOf(this._TGT.length);
            objArr[3] = util.buf_to_string(this._TGT, 2);
            objArr[4] = Integer.valueOf(this._psKey.length);
            objArr[5] = Long.valueOf(this._psKey_create_time);
            objArr[6] = Integer.valueOf(this._pt4Token.length);
            byte[] bArr = this.wtSessionTicket;
            if (bArr != null) {
                i3 = bArr.length;
            }
            objArr[7] = Integer.valueOf(i3);
            objArr[8] = Integer.valueOf(this._DA2.length);
            objArr[9] = Integer.valueOf(this._D2.length);
            objArr[10] = Integer.valueOf(this._D2Key.length);
            objArr[11] = Long.valueOf(this._D2_create_time);
            objArr[12] = Long.valueOf(this._D2_expire_time);
            return String.format(locale, "{A1:%d,%d A2:%d,%s pskey:%d,%d pt4token:%d wtST:%d da2:%d D2:%d,%d %d-%d}", objArr);
        } catch (Exception unused) {
            return "WloginSigInfo";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByteArray(this._TGT);
        parcel.writeByteArray(this._TGTKey);
        parcel.writeByteArray(this._userStSig);
        parcel.writeByteArray(this._userSt_Key);
        parcel.writeByteArray(this._userStWebSig);
        parcel.writeByteArray(this._userA5);
        parcel.writeByteArray(this._userA8);
        parcel.writeByteArray(this._lsKey);
        parcel.writeByteArray(this._sKey);
        parcel.writeByteArray(this._userSig64);
        parcel.writeByteArray(this._openid);
        parcel.writeByteArray(this._openkey);
        parcel.writeByteArray(this._vkey);
        parcel.writeByteArray(this._en_A1);
        parcel.writeByteArray(this._access_token);
        parcel.writeByteArray(this._D2);
        parcel.writeByteArray(this._D2Key);
        parcel.writeByteArray(this._sid);
        parcel.writeByteArray(this._noPicSig);
        parcel.writeByteArray(this._aqSig);
        parcel.writeByteArray(this._psKey);
        parcel.writeByteArray(this._superKey);
        parcel.writeByteArray(this._G);
        parcel.writeByteArray(this._dpwd);
        parcel.writeByteArray(this._randseed);
        parcel.writeInt(this._login_bitmap);
        parcel.writeLong(this._app_pri);
        parcel.writeLong(this._A2_expire_time);
        parcel.writeLong(this._lsKey_expire_time);
        parcel.writeLong(this._sKey_expire_time);
        parcel.writeLong(this._vKey_expire_time);
        parcel.writeLong(this._userA8_expire_time);
        parcel.writeLong(this._userStWebSig_expire_time);
        parcel.writeLong(this._D2_expire_time);
        parcel.writeLong(this._sid_expire_time);
        parcel.writeLong(this._create_time);
        parcel.writeLong(this._A2_create_time);
        parcel.writeLong(this._userStSig_create_time);
        parcel.writeLong(this._userStWebSig_create_time);
        parcel.writeLong(this._userA5_create_time);
        parcel.writeLong(this._userA8_create_time);
        parcel.writeLong(this._lsKey_create_time);
        parcel.writeLong(this._sKey_create_time);
        parcel.writeLong(this._userSig64_create_time);
        parcel.writeLong(this._openkey_create_time);
        parcel.writeLong(this._vkey_create_time);
        parcel.writeLong(this._access_token_create_time);
        parcel.writeLong(this._D2_create_time);
        parcel.writeLong(this._sid_create_time);
        parcel.writeLong(this._aqSig_create_time);
        parcel.writeLong(this._psKey_create_time);
        parcel.writeByteArray(this._pay_token);
        parcel.writeByteArray(this._pf);
        parcel.writeByteArray(this._pfKey);
        parcel.writeByteArray(this._DA2);
        parcel.writeByteArray(this._pt4Token);
        parcel.writeByteArray(this.wtSessionTicket);
        parcel.writeByteArray(this.wtSessionTicketKey);
        parcel.writeByteArray(this._device_token);
        parcel.writeLong(this._A1_version);
        parcel.writeLong(this.wtSessionTicketCreatTime);
    }

    public WloginSigInfo(long j3, long j16, long j17, long j18, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, byte[] bArr9, byte[] bArr10, byte[] bArr11, byte[] bArr12, byte[][] bArr13, long[] jArr, int i3, int i16) {
        this._TGT = new byte[0];
        this._TGTKey = new byte[0];
        this._userStSig = new byte[0];
        this._userSt_Key = new byte[0];
        this._userStWebSig = new byte[0];
        this._userA5 = new byte[0];
        this._userA8 = new byte[0];
        this._lsKey = new byte[0];
        this._sKey = new byte[0];
        this._userSig64 = new byte[0];
        this._openid = new byte[0];
        this._openkey = new byte[0];
        this._vkey = new byte[0];
        this._en_A1 = new byte[0];
        this._access_token = new byte[0];
        this._D2 = new byte[0];
        this._D2Key = new byte[0];
        this._sid = new byte[0];
        this._noPicSig = new byte[0];
        this._aqSig = new byte[0];
        this._psKey = new byte[0];
        this._pt4Token = new byte[0];
        this._superKey = new byte[0];
        this._G = new byte[0];
        this._dpwd = new byte[0];
        this._randseed = new byte[0];
        this._pay_token = new byte[0];
        this._pf = new byte[0];
        this._pfKey = new byte[0];
        this._DA2 = new byte[0];
        this._app_pri = 0L;
        this._login_bitmap = 0;
        this._A2_expire_time = 0L;
        this._lsKey_expire_time = 0L;
        this._sKey_expire_time = 0L;
        this._vKey_expire_time = 0L;
        this._userA8_expire_time = 0L;
        this._userStWebSig_expire_time = 0L;
        this._D2_expire_time = 0L;
        this._sid_expire_time = 0L;
        this._create_time = 0L;
        this._A2_create_time = 0L;
        this._userStSig_create_time = 0L;
        this._userStWebSig_create_time = 0L;
        this._userA5_create_time = 0L;
        this._userA8_create_time = 0L;
        this._lsKey_create_time = 0L;
        this._sKey_create_time = 0L;
        this._userSig64_create_time = 0L;
        this._openkey_create_time = 0L;
        this._vkey_create_time = 0L;
        this._access_token_create_time = 0L;
        this._D2_create_time = 0L;
        this._sid_create_time = 0L;
        this._aqSig_create_time = 0L;
        this._psKey_create_time = 0L;
        this.wtSessionTicket = new byte[0];
        this.wtSessionTicketKey = new byte[0];
        this._device_token = new byte[0];
        this._A1_version = 0L;
        this.cacheTickets = null;
        this.mainSigMap = i16;
        SetSigInfo(j3, j16, j17, j18, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, jArr, i3);
    }

    public WloginSigInfo Set(byte[][] bArr, long j3) {
        if (bArr != null && bArr.length == 5) {
            byte[] bArr2 = bArr[0];
            if (bArr2 != null && bArr2.length > 0) {
                this._en_A1 = (byte[]) bArr2.clone();
                this._create_time = j3;
                util.LOGI("update A1 sig, length = " + this._en_A1.length, "");
                byte[] bArr3 = bArr[1];
                if (bArr3 == null || bArr3.length <= 0) {
                    this._noPicSig = new byte[0];
                } else {
                    this._noPicSig = (byte[]) bArr3.clone();
                }
            }
            byte[] bArr4 = bArr[2];
            if (bArr4 != null && bArr4.length > 0) {
                this._G = (byte[]) bArr4.clone();
            }
            byte[] bArr5 = bArr[3];
            if (bArr5 != null && bArr5.length > 0) {
                this._dpwd = (byte[]) bArr5.clone();
            }
            byte[] bArr6 = bArr[4];
            if (bArr6 != null && bArr6.length > 0) {
                this._randseed = (byte[]) bArr6.clone();
            }
        }
        return this;
    }

    public WloginSigInfo(long j3, long j16, byte[] bArr, byte[] bArr2) {
        this._TGT = new byte[0];
        this._TGTKey = new byte[0];
        this._userStSig = new byte[0];
        this._userSt_Key = new byte[0];
        this._userStWebSig = new byte[0];
        this._userA5 = new byte[0];
        this._userA8 = new byte[0];
        this._lsKey = new byte[0];
        this._sKey = new byte[0];
        this._userSig64 = new byte[0];
        this._openid = new byte[0];
        this._openkey = new byte[0];
        this._vkey = new byte[0];
        this._en_A1 = new byte[0];
        this._access_token = new byte[0];
        this._D2 = new byte[0];
        this._D2Key = new byte[0];
        this._sid = new byte[0];
        this._noPicSig = new byte[0];
        this._aqSig = new byte[0];
        this._psKey = new byte[0];
        this._pt4Token = new byte[0];
        this._superKey = new byte[0];
        this._G = new byte[0];
        this._dpwd = new byte[0];
        this._randseed = new byte[0];
        this._pay_token = new byte[0];
        this._pf = new byte[0];
        this._pfKey = new byte[0];
        this._DA2 = new byte[0];
        this._login_bitmap = 0;
        this._A2_expire_time = 0L;
        this._lsKey_expire_time = 0L;
        this._sKey_expire_time = 0L;
        this._vKey_expire_time = 0L;
        this._userA8_expire_time = 0L;
        this._userStWebSig_expire_time = 0L;
        this._D2_expire_time = 0L;
        this._sid_expire_time = 0L;
        this._create_time = 0L;
        this._A2_create_time = 0L;
        this._userStSig_create_time = 0L;
        this._userStWebSig_create_time = 0L;
        this._userA5_create_time = 0L;
        this._userA8_create_time = 0L;
        this._lsKey_create_time = 0L;
        this._sKey_create_time = 0L;
        this._userSig64_create_time = 0L;
        this._openkey_create_time = 0L;
        this._vkey_create_time = 0L;
        this._access_token_create_time = 0L;
        this._D2_create_time = 0L;
        this._sid_create_time = 0L;
        this._aqSig_create_time = 0L;
        this._psKey_create_time = 0L;
        this.wtSessionTicket = new byte[0];
        this.wtSessionTicketKey = new byte[0];
        this._device_token = new byte[0];
        this._A1_version = 0L;
        this.cacheTickets = null;
        this._app_pri = 4294967295L;
        if (bArr != null && bArr.length > 0) {
            this._userStSig = (byte[]) bArr.clone();
            this._userStSig_create_time = j3;
        }
        if (bArr2 == null || bArr2.length <= 0) {
            return;
        }
        this._userSt_Key = (byte[]) bArr2.clone();
    }

    public WloginSigInfo Set(byte[][] bArr, long j3, long j16) {
        byte[] bArr2;
        util.LOGI("A1 version: [new version = " + j16 + "][old version = " + this._A1_version + "]", "");
        if (bArr != null && bArr.length == 5 && (bArr2 = bArr[0]) != null && bArr2.length > 0 && j16 >= this._A1_version) {
            this._A1_version = j16;
            Set(bArr, j3);
        }
        return this;
    }

    WloginSigInfo(Parcel parcel) {
        this._TGT = new byte[0];
        this._TGTKey = new byte[0];
        this._userStSig = new byte[0];
        this._userSt_Key = new byte[0];
        this._userStWebSig = new byte[0];
        this._userA5 = new byte[0];
        this._userA8 = new byte[0];
        this._lsKey = new byte[0];
        this._sKey = new byte[0];
        this._userSig64 = new byte[0];
        this._openid = new byte[0];
        this._openkey = new byte[0];
        this._vkey = new byte[0];
        this._en_A1 = new byte[0];
        this._access_token = new byte[0];
        this._D2 = new byte[0];
        this._D2Key = new byte[0];
        this._sid = new byte[0];
        this._noPicSig = new byte[0];
        this._aqSig = new byte[0];
        this._psKey = new byte[0];
        this._pt4Token = new byte[0];
        this._superKey = new byte[0];
        this._G = new byte[0];
        this._dpwd = new byte[0];
        this._randseed = new byte[0];
        this._pay_token = new byte[0];
        this._pf = new byte[0];
        this._pfKey = new byte[0];
        this._DA2 = new byte[0];
        this._app_pri = 0L;
        this._login_bitmap = 0;
        this._A2_expire_time = 0L;
        this._lsKey_expire_time = 0L;
        this._sKey_expire_time = 0L;
        this._vKey_expire_time = 0L;
        this._userA8_expire_time = 0L;
        this._userStWebSig_expire_time = 0L;
        this._D2_expire_time = 0L;
        this._sid_expire_time = 0L;
        this._create_time = 0L;
        this._A2_create_time = 0L;
        this._userStSig_create_time = 0L;
        this._userStWebSig_create_time = 0L;
        this._userA5_create_time = 0L;
        this._userA8_create_time = 0L;
        this._lsKey_create_time = 0L;
        this._sKey_create_time = 0L;
        this._userSig64_create_time = 0L;
        this._openkey_create_time = 0L;
        this._vkey_create_time = 0L;
        this._access_token_create_time = 0L;
        this._D2_create_time = 0L;
        this._sid_create_time = 0L;
        this._aqSig_create_time = 0L;
        this._psKey_create_time = 0L;
        this.wtSessionTicket = new byte[0];
        this.wtSessionTicketKey = new byte[0];
        this._device_token = new byte[0];
        this._A1_version = 0L;
        this.cacheTickets = null;
        readFromParcel(parcel);
    }
}
