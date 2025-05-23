package oicq.wlogin_sdk.report;

import java.util.Iterator;
import java.util.TreeMap;
import oicq.wlogin_sdk.tools.LogCallBack;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Reporter extends report_t {
    private static final long serialVersionUID = 1;
    public int _os = 2;
    public String _os_v = new String("");
    public String _app_v = new String("");
    public String _sdk_v = new Integer(22).toString();
    public String _ksid = new String("");
    public String _app_n = new String("");
    public String _disp_name = new String("");
    public String _device = new String("");
    public String _app_sig = new String("");
    public String _btime = util.get_release_time();
    public String _bver = util.SDK_VERSION;
    public TreeMap<Integer, report_t2> _lst = new TreeMap<>();

    public synchronized void add_t2(report_t2 report_t2Var) {
        if (this._lst.size() >= 10) {
            this._lst.remove(Integer.valueOf(r0.size() - 1));
        }
        TreeMap<Integer, report_t2> treeMap = this._lst;
        treeMap.put(Integer.valueOf(treeMap.size()), report_t2Var);
    }

    public synchronized void add_t3(report_t3 report_t3Var) {
        if (this._lst.size() <= 0) {
            return;
        }
        this._lst.get(Integer.valueOf(r0.size() - 1)).add_t3(report_t3Var);
    }

    public synchronized void attr_api(int i3) {
        add_t2(new report_t2(i3));
    }

    public synchronized void clear_t2() {
        Iterator<Integer> it = this._lst.keySet().iterator();
        while (it.hasNext()) {
            this._lst.get(it.next()).clear_t3();
        }
        this._lst.clear();
    }

    public synchronized void commit(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this._os_v = str;
        this._app_v = str2;
        this._ksid = str4;
        this._app_n = str5;
        this._disp_name = str6;
        this._device = str7;
        this._app_sig = str8;
        this._btime = str9;
        this._bver = str10;
    }

    public synchronized void commit_t2(long j3, String str, int i3, int i16) {
        if (this._lst.size() <= 0) {
            return;
        }
        this._lst.get(Integer.valueOf(r0.size() - 1)).commit(j3, str, i3, i16);
        LogCallBack logCallBack = util.LCB;
        if (logCallBack != null) {
            logCallBack.OnLog(this._lst.get(Integer.valueOf(r9.size() - 1)).toJasonObj());
        }
    }

    public synchronized JSONObject toJasonObj() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                int i3 = 0;
                jSONObject.put("os", String.format("%d", Integer.valueOf(this._os)));
                jSONObject.put("os_v", this._os_v);
                jSONObject.put("app_v", this._app_v);
                jSONObject.put("sdk_v", this._sdk_v);
                jSONObject.put("ksid", this._ksid);
                jSONObject.put("app_n", this._app_n);
                jSONObject.put("disp_name", this._disp_name);
                jSONObject.put("device", this._device);
                jSONObject.put("app_sig", this._app_sig);
                jSONObject.put("btime", this._btime);
                jSONObject.put("bver", this._bver);
                JSONArray jSONArray = new JSONArray();
                Iterator<Integer> it = this._lst.keySet().iterator();
                while (it.hasNext()) {
                    jSONArray.put(i3, this._lst.get(it.next()).toJasonObj());
                    i3++;
                }
                jSONObject.put("lst", jSONArray);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            jSONObject = null;
        }
        return jSONObject;
    }
}
