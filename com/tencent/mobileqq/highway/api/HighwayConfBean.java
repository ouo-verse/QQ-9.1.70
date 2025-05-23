package com.tencent.mobileqq.highway.api;

import android.app.Application;
import com.tencent.mobileqq.highway.IInject;
import com.tencent.mobileqq.highway.segment.RequestFinishQuery;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HighwayConfBean {
    static IPatchRedirector $redirector_ = null;
    public static final String HIGHWAY_REQUEST_QUERY_FINISH = "sp_highway_request_query_finish";
    public static final String SP_HIGHWAY_REQUEST_QUERY_FINISH_COUNT = "sp_highway_request_query_finish_count";
    public static final String SP_HIGHWAY_REQUEST_QUERY_FINISH_INTERVAL = "sp_highway_request_query_finish_interval";
    public int requestQueryFinishCount;
    public int requestQueryFinishInterval;

    public HighwayConfBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.requestQueryFinishCount = 3;
            this.requestQueryFinishInterval = 5000;
        }
    }

    public static void init(IInject iInject) {
        if (iInject == null) {
            return;
        }
        Application application = iInject.getApplication();
        RequestFinishQuery.QUERY_HOLE_MAX_COUNT = application.getSharedPreferences(HIGHWAY_REQUEST_QUERY_FINISH, 0).getInt(SP_HIGHWAY_REQUEST_QUERY_FINISH_COUNT, 3);
        RequestFinishQuery.QUERY_HOLE_INTERVAL = application.getSharedPreferences(HIGHWAY_REQUEST_QUERY_FINISH, 0).getInt(SP_HIGHWAY_REQUEST_QUERY_FINISH_INTERVAL, 5000);
        BdhLogUtil.LogEvent("E", "init: QUERY_HOLE_MAX_COUNT:" + RequestFinishQuery.QUERY_HOLE_MAX_COUNT + " QUERY_HOLE_INTERVAL:" + RequestFinishQuery.QUERY_HOLE_INTERVAL);
    }

    public static HighwayConfBean parse(String str) {
        if (str == null) {
            return null;
        }
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(str.getBytes("utf-8")));
            NodeList elementsByTagName = parse.getElementsByTagName("bdh_config");
            if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
                HighwayConfBean highwayConfBean = new HighwayConfBean();
                highwayConfBean.requestQueryFinishCount = Integer.parseInt(parse.getElementsByTagName("max_finish_query_hole_time").item(0).getFirstChild().getNodeValue());
                highwayConfBean.requestQueryFinishInterval = Integer.parseInt(parse.getElementsByTagName("finish_query_hole_interval").item(0).getFirstChild().getNodeValue());
                return highwayConfBean;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }

    public static void updateHighwayConf(AppRuntime appRuntime, HighwayConfBean highwayConfBean) {
        appRuntime.getApplication().getSharedPreferences(HIGHWAY_REQUEST_QUERY_FINISH, 0).edit().putInt(SP_HIGHWAY_REQUEST_QUERY_FINISH_COUNT, highwayConfBean.requestQueryFinishCount).commit();
        appRuntime.getApplication().getSharedPreferences(HIGHWAY_REQUEST_QUERY_FINISH, 0).edit().putInt(SP_HIGHWAY_REQUEST_QUERY_FINISH_INTERVAL, highwayConfBean.requestQueryFinishInterval).commit();
        RequestFinishQuery.QUERY_HOLE_MAX_COUNT = highwayConfBean.requestQueryFinishCount;
        RequestFinishQuery.QUERY_HOLE_INTERVAL = highwayConfBean.requestQueryFinishInterval;
        BdhLogUtil.LogEvent("E", "updateHighwayConf: QUERY_HOLE_MAX_COUNT:" + RequestFinishQuery.QUERY_HOLE_MAX_COUNT + " QUERY_HOLE_INTERVAL:" + RequestFinishQuery.QUERY_HOLE_INTERVAL);
    }
}
