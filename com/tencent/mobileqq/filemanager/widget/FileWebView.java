package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ZoomButtonsController;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qimei.webview.QmX5Webview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileWebView extends QmX5Webview {
    b C;
    boolean D;
    private Timer E;
    private Object F;
    float G;
    final int H;
    long I;
    float J;
    float K;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void loadFinish(int i3, int i16, String str);

        void loadFinish(int i3, boolean z16, int i16, String str);

        void openFile(String str, String str2, long j3, boolean z16);

        void updatePage(int i3, int i16);

        void webLog(String str);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface b {
        void a();

        void b(boolean z16);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public FileWebView(Context context) {
        this(context, null);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    private Class q(Type type, int i3) {
        if (type instanceof ParameterizedType) {
            return r((ParameterizedType) type, i3);
        }
        if (type instanceof TypeVariable) {
            return q(((TypeVariable) type).getBounds()[0], 0);
        }
        return (Class) type;
    }

    private Class r(ParameterizedType parameterizedType, int i3) {
        Type type = parameterizedType.getActualTypeArguments()[i3];
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return (Class) ((GenericArrayType) type).getGenericComponentType();
        }
        if (type instanceof TypeVariable) {
            return q(((TypeVariable) type).getBounds()[0], 0);
        }
        return (Class) type;
    }

    @Override // com.tencent.smtt.sdk.WebView
    public void destroy() {
        synchronized (this.F) {
            if (this.E != null) {
                QLog.d("FileWebView", 4, "memoryleaktest webview timer " + this.E + " this " + this + "is cancel");
                this.E.cancel();
                this.E = null;
            }
        }
        super.destroy();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.C == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.C.a();
                }
            } else {
                if (Calendar.getInstance().getTimeInMillis() - this.I < 80) {
                    this.C.e();
                    return super.dispatchTouchEvent(motionEvent);
                }
                float y16 = motionEvent.getY();
                this.K = y16;
                if (this.J > y16) {
                    getContentHeight();
                    getHeight();
                    int webScrollY = getWebScrollY();
                    getScale();
                    if ((getContentHeight() * getScale()) - (getView().getHeight() + getWebScrollY()) >= 1.0d && webScrollY != 0) {
                        this.C.g();
                    } else {
                        this.C.c();
                        this.C.f();
                        return super.dispatchTouchEvent(motionEvent);
                    }
                } else {
                    this.C.d();
                    if (getScrollY() < 1.0f) {
                        this.C.b(false);
                        this.C.f();
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                this.C.f();
            }
        } else {
            this.I = Calendar.getInstance().getTimeInMillis();
            this.J = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        if (this.D) {
            return true;
        }
        return super.onCheckIsTextEditor();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
        if (this.C == null) {
            return;
        }
        int contentHeight = getContentHeight();
        int height = getView().getHeight();
        int webScrollY = getWebScrollY();
        float scale = getScale();
        if (QLog.isDevelopLevel()) {
            QLog.d("FileWebView", 4, "contentHeight[" + contentHeight + "],height[" + height + "],scroolY[" + webScrollY + "],scale[" + scale + "]");
        }
        float contentHeight2 = (getContentHeight() * getScale()) - (getView().getHeight() + getWebScrollY());
        if (contentHeight2 < height * 2 && !FileManagerUtil.is2GOr3G()) {
            this.C.h();
        }
        if (contentHeight2 < 2.5d) {
            this.C.c();
        }
        if (i16 == 0 && i18 != 0) {
            this.C.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.smtt.sdk.WebView, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (i16 != 0) {
            super.onSizeChanged(i3, i16, i17, i18);
        }
    }

    public boolean p(WebView webView, String str, a aVar) {
        String str2;
        LinkedHashMap linkedHashMap;
        if (str == null || !str.startsWith("jsbridge://")) {
            return false;
        }
        String[] split = str.split("[?]");
        String str3 = "";
        if (str.length() <= 1 || split.length <= 1) {
            str2 = "";
        } else {
            String str4 = split[0];
            str2 = split[1].replaceFirst("p=", "");
            str3 = str4;
        }
        List asList = Arrays.asList((str3 + "/#").split("/"));
        if (asList.size() < 5 || !((String) asList.get(2)).equalsIgnoreCase("preview")) {
            return false;
        }
        String str5 = (String) asList.get(3);
        Method method = null;
        try {
            linkedHashMap = FileManagerUtil.jsonToMap(str2);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("FileWebView", 1, "paramString parse fail!,paramString:" + str2);
            }
            e16.printStackTrace();
            linkedHashMap = null;
        }
        Method[] methods = aVar.getClass().getMethods();
        int length = methods.length;
        int i3 = 0;
        Class<?>[] clsArr = null;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Method method2 = methods[i3];
            if (method2.getName().equals(str5)) {
                clsArr = method2.getParameterTypes();
                if (linkedHashMap != null && clsArr.length == linkedHashMap.size()) {
                    method = method2;
                    break;
                }
            }
            i3++;
        }
        if (method == null) {
            aVar.webLog(str2);
            return true;
        }
        try {
            if (linkedHashMap.size() == 0) {
                method.invoke(aVar, new Object[0]);
                return true;
            }
            Object[] array = linkedHashMap.values().toArray();
            Object[] objArr = new Object[clsArr.length];
            for (int i16 = 0; i16 < clsArr.length; i16++) {
                try {
                    String lowerCase = q(clsArr[i16], i16).toString().toLowerCase();
                    if (!lowerCase.contains(PoiListCacheRecord.WEIGHT_TYPE) && !lowerCase.contains("integer")) {
                        if (lowerCase.contains(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                            objArr[i16] = Long.valueOf(Long.parseLong((String) array[i16]));
                        } else if (lowerCase.contains(HippyControllerProps.STRING)) {
                            objArr[i16] = (String) array[i16];
                        } else if (lowerCase.contains(HippyControllerProps.BOOLEAN)) {
                            objArr[i16] = Boolean.valueOf(Boolean.parseBoolean((String) array[i16]));
                        }
                    }
                    objArr[i16] = Integer.valueOf(Integer.parseInt((String) array[i16]));
                } catch (IllegalAccessException unused) {
                    QLog.e("FileWebView", 2, "invoke method exception!!! IllegalAccessException");
                    return false;
                } catch (IllegalArgumentException unused2) {
                    QLog.e("FileWebView", 2, "invoke method exception!!! IllegalArgumentException");
                    return false;
                } catch (InvocationTargetException unused3) {
                    QLog.e("FileWebView", 1, "invoke method exception!!! InvocationTargetException");
                    return false;
                } catch (Exception unused4) {
                    QLog.e("FileWebView", 1, "invoke method exception!!! Exception");
                    return false;
                }
            }
            method.invoke(aVar, objArr);
            return true;
        } catch (IllegalAccessException unused5) {
        } catch (IllegalArgumentException unused6) {
        } catch (InvocationTargetException unused7) {
        } catch (Exception unused8) {
        }
    }

    public void setOnCustomScroolChangeListener(b bVar) {
        this.C = bVar;
    }

    public void setOverrideOnCheckIsTextEditor(boolean z16) {
        this.D = z16;
    }

    public void setZoomControlGone(View view) {
        try {
            Field declaredField = WebView.class.getDeclaredField("mZoomButtonsController");
            declaredField.setAccessible(true);
            ZoomButtonsController zoomButtonsController = new ZoomButtonsController(view);
            zoomButtonsController.getZoomControls().setVisibility(8);
            try {
                declaredField.set(view, zoomButtonsController);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
            }
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
        } catch (SecurityException e19) {
            e19.printStackTrace();
        }
    }

    public FileWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    public FileWebView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = false;
        this.E = null;
        this.F = new Object();
        this.G = 1.0f;
        this.H = 80;
        this.I = 0L;
        this.J = 0.0f;
        this.K = 0.0f;
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        if (Integer.valueOf(Build.VERSION.SDK).intValue() < 11) {
            setZoomControlGone(this);
        } else {
            getSettings().setDisplayZoomControls(false);
        }
    }
}
