package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ForecastInfo extends JceStruct {
    static Date cache__date;
    public String _ac;
    public String _ac_n;
    public String _bp;
    public String _bp_n;
    public String _bwd;
    public String _bwea;
    public String _bws;
    public String _cl;
    public String _cl_n;
    public String _co;
    public String _co_n;
    public String _ct;
    public String _ct_n;
    public Date _date;
    public String _ewd;
    public String _ewea;
    public String _ews;
    public String _gj;
    public String _gj_n;
    public String _gm;
    public String _gm_n;
    public String _ls;
    public String _ls_n;
    public String _pj;
    public String _pj_n;
    public String _pl;
    public String _pl_n;
    public short _tmax;
    public short _tmin;
    public String _tr;
    public String _tr_n;
    public String _uv;
    public String _uv_n;
    public String _xc;
    public String _xc_n;
    public String _ys;
    public String _ys_n;
    public String _zs;
    public String _zs_n;

    public ForecastInfo() {
        this._date = null;
        this._bwea = "";
        this._ewea = "";
        this._bwd = "";
        this._ewd = "";
        this._bws = "";
        this._ews = "";
        this._tmax = (short) 0;
        this._tmin = (short) 0;
        this._ct = "";
        this._ct_n = "";
        this._co = "";
        this._co_n = "";
        this._cl = "";
        this._cl_n = "";
        this._gm = "";
        this._gm_n = "";
        this._ac = "";
        this._ac_n = "";
        this._xc = "";
        this._xc_n = "";
        this._ys = "";
        this._ys_n = "";
        this._pl = "";
        this._pl_n = "";
        this._pj = "";
        this._pj_n = "";
        this._ls = "";
        this._ls_n = "";
        this._tr = "";
        this._tr_n = "";
        this._gj = "";
        this._gj_n = "";
        this._uv = "";
        this._uv_n = "";
        this._zs = "";
        this._zs_n = "";
        this._bp = "";
        this._bp_n = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache__date == null) {
            cache__date = new Date();
        }
        this._date = (Date) jceInputStream.read((JceStruct) cache__date, 0, true);
        this._bwea = jceInputStream.readString(1, true);
        this._ewea = jceInputStream.readString(2, true);
        this._bwd = jceInputStream.readString(3, true);
        this._ewd = jceInputStream.readString(4, true);
        this._bws = jceInputStream.readString(5, true);
        this._ews = jceInputStream.readString(6, true);
        this._tmax = jceInputStream.read(this._tmax, 7, true);
        this._tmin = jceInputStream.read(this._tmin, 8, true);
        this._ct = jceInputStream.readString(9, true);
        this._ct_n = jceInputStream.readString(10, true);
        this._co = jceInputStream.readString(11, true);
        this._co_n = jceInputStream.readString(12, true);
        this._cl = jceInputStream.readString(13, true);
        this._cl_n = jceInputStream.readString(14, true);
        this._gm = jceInputStream.readString(15, true);
        this._gm_n = jceInputStream.readString(16, true);
        this._ac = jceInputStream.readString(17, true);
        this._ac_n = jceInputStream.readString(18, true);
        this._xc = jceInputStream.readString(19, true);
        this._xc_n = jceInputStream.readString(20, true);
        this._ys = jceInputStream.readString(21, true);
        this._ys_n = jceInputStream.readString(22, true);
        this._pl = jceInputStream.readString(23, true);
        this._pl_n = jceInputStream.readString(24, true);
        this._pj = jceInputStream.readString(25, true);
        this._pj_n = jceInputStream.readString(26, true);
        this._ls = jceInputStream.readString(27, true);
        this._ls_n = jceInputStream.readString(28, true);
        this._tr = jceInputStream.readString(29, true);
        this._tr_n = jceInputStream.readString(30, true);
        this._gj = jceInputStream.readString(31, true);
        this._gj_n = jceInputStream.readString(32, true);
        this._uv = jceInputStream.readString(33, true);
        this._uv_n = jceInputStream.readString(34, true);
        this._zs = jceInputStream.readString(35, true);
        this._zs_n = jceInputStream.readString(36, true);
        this._bp = jceInputStream.readString(37, true);
        this._bp_n = jceInputStream.readString(38, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this._date, 0);
        jceOutputStream.write(this._bwea, 1);
        jceOutputStream.write(this._ewea, 2);
        jceOutputStream.write(this._bwd, 3);
        jceOutputStream.write(this._ewd, 4);
        jceOutputStream.write(this._bws, 5);
        jceOutputStream.write(this._ews, 6);
        jceOutputStream.write(this._tmax, 7);
        jceOutputStream.write(this._tmin, 8);
        jceOutputStream.write(this._ct, 9);
        jceOutputStream.write(this._ct_n, 10);
        jceOutputStream.write(this._co, 11);
        jceOutputStream.write(this._co_n, 12);
        jceOutputStream.write(this._cl, 13);
        jceOutputStream.write(this._cl_n, 14);
        jceOutputStream.write(this._gm, 15);
        jceOutputStream.write(this._gm_n, 16);
        jceOutputStream.write(this._ac, 17);
        jceOutputStream.write(this._ac_n, 18);
        jceOutputStream.write(this._xc, 19);
        jceOutputStream.write(this._xc_n, 20);
        jceOutputStream.write(this._ys, 21);
        jceOutputStream.write(this._ys_n, 22);
        jceOutputStream.write(this._pl, 23);
        jceOutputStream.write(this._pl_n, 24);
        jceOutputStream.write(this._pj, 25);
        jceOutputStream.write(this._pj_n, 26);
        jceOutputStream.write(this._ls, 27);
        jceOutputStream.write(this._ls_n, 28);
        jceOutputStream.write(this._tr, 29);
        jceOutputStream.write(this._tr_n, 30);
        jceOutputStream.write(this._gj, 31);
        jceOutputStream.write(this._gj_n, 32);
        jceOutputStream.write(this._uv, 33);
        jceOutputStream.write(this._uv_n, 34);
        jceOutputStream.write(this._zs, 35);
        jceOutputStream.write(this._zs_n, 36);
        jceOutputStream.write(this._bp, 37);
        jceOutputStream.write(this._bp_n, 38);
    }

    public ForecastInfo(Date date, String str, String str2, String str3, String str4, String str5, String str6, short s16, short s17, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, String str32, String str33, String str34, String str35, String str36) {
        this._date = date;
        this._bwea = str;
        this._ewea = str2;
        this._bwd = str3;
        this._ewd = str4;
        this._bws = str5;
        this._ews = str6;
        this._tmax = s16;
        this._tmin = s17;
        this._ct = str7;
        this._ct_n = str8;
        this._co = str9;
        this._co_n = str10;
        this._cl = str11;
        this._cl_n = str12;
        this._gm = str13;
        this._gm_n = str14;
        this._ac = str15;
        this._ac_n = str16;
        this._xc = str17;
        this._xc_n = str18;
        this._ys = str19;
        this._ys_n = str20;
        this._pl = str21;
        this._pl_n = str22;
        this._pj = str23;
        this._pj_n = str24;
        this._ls = str25;
        this._ls_n = str26;
        this._tr = str27;
        this._tr_n = str28;
        this._gj = str29;
        this._gj_n = str30;
        this._uv = str31;
        this._uv_n = str32;
        this._zs = str33;
        this._zs_n = str34;
        this._bp = str35;
        this._bp_n = str36;
    }
}
