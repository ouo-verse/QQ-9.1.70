package com.tencent.ams.dsdk.event.handler;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.fodder.ResourceManager;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.mini.cache.Entry;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CommonMethodHandler implements DKMethodHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String CONTEXT = "CONTEXT";
    private static final String TAG = "CommonMethodHandler";
    private static final int VALUE_FAILED = -1;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private @interface MethodName {
        public static final String CALL = "call";
        public static final String CLOSE = "close";
        public static final String GET_GLOBAL_PARAMS = "getGlobalParams";
        public static final String IS_TEMPLATE_RESOURCE_CACHED = "isTemplateResourceCached";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class ParamsBean {
        static IPatchRedirector $redirector_;
        private Class[] classArray;
        private Object[] valueArray;

        ParamsBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) CommonMethodHandler.this);
        }

        /* synthetic */ ParamsBean(CommonMethodHandler commonMethodHandler, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) commonMethodHandler, (Object) anonymousClass1);
        }
    }

    public CommonMethodHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void genParamPaire(String str, String str2, ArrayList<Class> arrayList, ArrayList<Object> arrayList2) {
        if (str != null && str2 != null && arrayList != null && arrayList2 != null) {
            try {
                if (str.endsWith(Entry.DATA_TYPE_STRING)) {
                    arrayList.add(String.class);
                    arrayList2.add(str2);
                } else if (str.endsWith(PoiListCacheRecord.WEIGHT_TYPE)) {
                    int parseInt = Integer.parseInt(str2);
                    arrayList.add(Integer.TYPE);
                    arrayList2.add(Integer.valueOf(parseInt));
                } else if (str.endsWith("double")) {
                    double parseDouble = Double.parseDouble(str2);
                    arrayList.add(Double.TYPE);
                    arrayList2.add(Double.valueOf(parseDouble));
                } else if (str.endsWith("float")) {
                    float parseFloat = Float.parseFloat(str2);
                    arrayList.add(Float.TYPE);
                    arrayList2.add(Float.valueOf(parseFloat));
                } else if (str.endsWith(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                    long parseLong = Long.parseLong(str2);
                    arrayList.add(Long.TYPE);
                    arrayList2.add(Long.valueOf(parseLong));
                } else if (str.endsWith(HippyControllerProps.BOOLEAN)) {
                    boolean parseBoolean = Boolean.parseBoolean(str2);
                    arrayList.add(Boolean.TYPE);
                    arrayList2.add(Boolean.valueOf(parseBoolean));
                } else if (str.endsWith(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                    short parseShort = Short.parseShort(str2);
                    arrayList.add(Short.TYPE);
                    arrayList2.add(Short.valueOf(parseShort));
                } else if (str.endsWith("byte")) {
                    byte parseByte = Byte.parseByte(str2);
                    arrayList.add(Byte.TYPE);
                    arrayList2.add(Byte.valueOf(parseByte));
                } else if (str.endsWith(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR) && str2.length() > 0) {
                    arrayList.add(Character.TYPE);
                    arrayList2.add(Character.valueOf(str2.charAt(0)));
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    private ParamsBean genParamsBean(JSONObject jSONObject) {
        ParamsBean paramsBean = null;
        byte b16 = 0;
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("pms");
            ArrayList<Class> arrayList = new ArrayList<>();
            ArrayList<Object> arrayList2 = new ArrayList<>();
            if (optJSONArray == null) {
                return null;
            }
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                genParamPaire(jSONObject2.optString("c"), jSONObject2.optString("v"), arrayList, arrayList2);
            }
            if (arrayList.size() <= 0 || arrayList2.size() <= 0 || arrayList.size() != arrayList2.size()) {
                return null;
            }
            ParamsBean paramsBean2 = new ParamsBean(this, b16 == true ? 1 : 0);
            try {
                int size = arrayList.size();
                paramsBean2.classArray = (Class[]) arrayList.toArray(new Class[size]);
                paramsBean2.valueArray = arrayList2.toArray(new Object[size]);
                return paramsBean2;
            } catch (Throwable th5) {
                paramsBean = paramsBean2;
                th = th5;
                th.printStackTrace();
                return paramsBean;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleCall(DKEngine dKEngine, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        Object obj;
        String optString;
        boolean z16;
        Class<?> cls;
        JSONArray optJSONArray;
        Object[] objArr;
        Class<?>[] clsArr;
        Field declaredField;
        Object obj2;
        Field field;
        Method method;
        Object obj3;
        Method method2;
        int optInt = jSONObject.optInt("instanceId");
        String optString2 = jSONObject.optString("callDescribe");
        DLog.d(TAG, "call, callDescribeStr: " + optString2);
        try {
            JSONObject jSONObject2 = new JSONObject(optString2);
            String optString3 = jSONObject2.optString(Constants.Service.CLASS);
            optString = jSONObject2.optString("obj");
            z16 = !TextUtils.isEmpty(optString3);
            if (z16) {
                cls = Class.forName(optString3);
            } else {
                cls = null;
            }
            optJSONArray = jSONObject2.optJSONArray("call");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (optJSONArray != null) {
            obj = null;
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i3);
                String optString4 = jSONObject3.optString(GdtADFlyingStreamingReportHelper.PARAM_KEY_MN);
                ParamsBean genParamsBean = genParamsBean(jSONObject3);
                if (genParamsBean != null) {
                    clsArr = genParamsBean.classArray;
                    objArr = genParamsBean.valueArray;
                } else {
                    objArr = null;
                    clsArr = null;
                }
                if (!TextUtils.isEmpty(optString4)) {
                    if (obj == null) {
                        if (z16) {
                            method2 = cls.getMethod(optString4, clsArr);
                            obj3 = null;
                            obj = method2.invoke(obj3, objArr);
                        } else {
                            obj = optObject(dKEngine, optString, optInt);
                            method = obj.getClass().getMethod(optString4, clsArr);
                        }
                    } else {
                        method = obj.getClass().getMethod(optString4, clsArr);
                    }
                    Method method3 = method;
                    obj3 = obj;
                    method2 = method3;
                    obj = method2.invoke(obj3, objArr);
                } else {
                    String optString5 = jSONObject3.optString("fn");
                    if (!TextUtils.isEmpty(optString5)) {
                        if (obj == null) {
                            if (z16) {
                                field = cls.getDeclaredField(optString5);
                                obj2 = null;
                                field.setAccessible(true);
                                obj = field.get(obj2);
                            } else {
                                obj = optObject(dKEngine, optString, optInt);
                                declaredField = obj.getClass().getDeclaredField(optString5);
                            }
                        } else {
                            declaredField = obj.getClass().getDeclaredField(optString5);
                        }
                        Field field2 = declaredField;
                        obj2 = obj;
                        field = field2;
                        field.setAccessible(true);
                        obj = field.get(obj2);
                    }
                }
            }
            if (obj == null) {
                callback.onResult(String.valueOf(obj));
                return;
            } else {
                callback.onFailure(-3, null);
                return;
            }
        }
        obj = null;
        if (obj == null) {
        }
    }

    private void handleClose(DKEngine dKEngine, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (callback != null) {
            callback.onResult(null);
        }
    }

    private void handleGetGlobalParams(DKEngine dKEngine, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (callback != null) {
            Map<String, String> completeGlobalParams = DynamicUtils.getCompleteGlobalParams();
            JSONObject jSONObject2 = null;
            if (completeGlobalParams != null) {
                try {
                    jSONObject2 = new JSONObject(completeGlobalParams);
                } catch (Throwable th5) {
                    DLog.e(TAG, "map to json error.", th5);
                }
            }
            callback.onResult(jSONObject2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v3 */
    private void handleIsTemplateResourceCached(DKEngine dKEngine, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        File preloadFile;
        int length;
        ArrayList arrayList = new ArrayList();
        ?? r16 = 0;
        r16 = 0;
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("resourceUrlList");
            DLog.i(TAG, "resourceUrlList: " + optJSONArray);
            if (optJSONArray == null) {
                length = 0;
            } else {
                length = optJSONArray.length();
            }
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    arrayList.add(optJSONObject.optString("url"));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str) && ((preloadFile = ResourceManager.getInstance().getPreloadFile(str)) == null || !preloadFile.exists())) {
                    break;
                }
            } else {
                r16 = 1;
                break;
            }
        }
        DLog.i(TAG, "handleGetTemplateResourceLocation, params: " + jSONObject + ", isCached: " + ((boolean) r16));
        if (callback != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", Integer.valueOf((int) r16));
            callback.onResult(hashMap);
        }
    }

    private Object optObject(DKEngine dKEngine, String str, int i3) {
        ViewGroup viewGroup;
        HippyEngineContext hippyEngineContext;
        if (dKEngine instanceof DKHippyEngine) {
            DKHippyEngine dKHippyEngine = (DKHippyEngine) dKEngine;
            hippyEngineContext = dKHippyEngine.getHippyEngineContext();
            viewGroup = dKHippyEngine.getRootView();
        } else {
            viewGroup = null;
            hippyEngineContext = null;
        }
        if (hippyEngineContext != null && viewGroup != null) {
            Context context = viewGroup.getContext();
            if (CONTEXT.equalsIgnoreCase(str)) {
                return context;
            }
        }
        return null;
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Common";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
    
        if (r8.equals(com.tencent.ams.dsdk.event.handler.CommonMethodHandler.MethodName.GET_GLOBAL_PARAMS) == false) goto L13;
     */
    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, dKEngine, str, jSONObject, callback)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case 3045982:
                if (str.equals("call")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 94756344:
                if (str.equals("close")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 863303039:
                break;
            case 883656628:
                if (str.equals(MethodName.IS_TEMPLATE_RESOURCE_CACHED)) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                handleCall(dKEngine, jSONObject, callback);
                return true;
            case 1:
                handleClose(dKEngine, jSONObject, callback);
                return true;
            case 2:
                handleGetGlobalParams(dKEngine, jSONObject, callback);
                return true;
            case 3:
                handleIsTemplateResourceCached(dKEngine, jSONObject, callback);
                return true;
            default:
                return false;
        }
    }
}
