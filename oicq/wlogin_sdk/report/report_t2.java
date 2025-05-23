package oicq.wlogin_sdk.report;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.TreeMap;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class report_t2 extends report_t {
    private static final long serialVersionUID = 1;
    public long _app;
    public long[] _app_list;
    public String _oper;
    public long _start;
    public long _sub_app;
    public String _type;
    public int attr;
    public int _used = 0;
    public long _uin = 0;
    public String _name = new String("");
    public int _rst1 = 0;
    public int _rst2 = 0;
    public int _rlen = 0;
    public int _slen = 0;
    public TreeMap<Integer, report_t3> _log = new TreeMap<>();

    public report_t2(int i3) {
        this._type = new String("");
        this._oper = new String("");
        this._start = 0L;
        this._app = 0L;
        this._sub_app = 0L;
        this._app_list = null;
        this._type = "login";
        this._oper = "null";
        this._start = System.currentTimeMillis();
        this._app = 0L;
        this._sub_app = 0L;
        this._app_list = null;
        this.attr = i3;
    }

    public void add_t3(report_t3 report_t3Var) {
        this._rlen += report_t3Var._rlen;
        this._slen += report_t3Var._slen;
        TreeMap<Integer, report_t3> treeMap = this._log;
        treeMap.put(Integer.valueOf(treeMap.size()), report_t3Var);
    }

    public void clear_t3() {
        this._log.clear();
    }

    public void commit(long j3, String str, int i3, int i16) {
        this._uin = j3;
        this._name = str;
        this._rst1 = i3;
        this._rst2 = i16;
        this._used = (int) (System.currentTimeMillis() - this._start);
    }

    public JSONObject toJasonObj() {
        JSONObject jSONObject;
        StringBuilder sb5;
        String format;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this._type);
                jSONObject.put("oper", this._oper);
                int i3 = 0;
                jSONObject.put("start", String.format("%d", Long.valueOf((this._start / 1000) & 4294967295L)));
                jSONObject.put("used", String.format("%d", Long.valueOf(this._used & 4294967295L)));
                jSONObject.put("uin", String.format("%d", Long.valueOf(this._uin & 4294967295L)));
                jSONObject.put("app", String.format("%d", Long.valueOf(this._app & 4294967295L)));
                jSONObject.put("subapp", String.format("%d", Long.valueOf(this._sub_app & 4294967295L)));
                jSONObject.put("email", this._name);
                jSONObject.put("attr", this.attr);
                String str = "";
                if (this._app_list != null) {
                    int i16 = 0;
                    while (true) {
                        long[] jArr = this._app_list;
                        if (i16 >= jArr.length) {
                            break;
                        }
                        if (i16 == jArr.length - 1) {
                            sb5 = new StringBuilder();
                            sb5.append(str);
                            format = String.format("%d", Long.valueOf(this._app_list[i16] & 4294967295L));
                        } else {
                            sb5 = new StringBuilder();
                            sb5.append(str);
                            format = String.format("%d,", Long.valueOf(this._app_list[i16] & 4294967295L));
                        }
                        sb5.append(format);
                        str = sb5.toString();
                        i16++;
                    }
                }
                jSONObject.put("applist", str);
                jSONObject.put("rst1", String.format("%d", Long.valueOf(this._rst1 & 4294967295L)));
                jSONObject.put("rst2", String.format("%d", Long.valueOf(4294967295L & this._rst2)));
                JSONArray jSONArray = new JSONArray();
                Iterator<Integer> it = this._log.keySet().iterator();
                while (it.hasNext()) {
                    jSONArray.put(i3, this._log.get(it.next()).toJasonObj());
                    i3++;
                }
                jSONObject.put("log", jSONArray);
            } catch (Exception e16) {
                e = e16;
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
                e.printStackTrace(printWriter);
                printWriter.flush();
                stringWriter.flush();
                util.LOGD("exception", stringWriter.toString());
                return jSONObject;
            }
        } catch (Exception e17) {
            e = e17;
            jSONObject = null;
        }
        return jSONObject;
    }

    public report_t2(String str, String str2, long j3, long j16, long j17, long[] jArr) {
        this._type = new String("");
        this._oper = new String("");
        this._start = 0L;
        this._app = 0L;
        this._sub_app = 0L;
        this._app_list = null;
        this._type = str;
        this._oper = str2;
        this._start = j3;
        this._app = j16;
        this._sub_app = j17;
        this._app_list = jArr;
    }
}
