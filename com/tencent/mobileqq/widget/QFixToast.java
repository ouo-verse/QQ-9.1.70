package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QFixToast extends Toast {
    public static final String TAG = "QFixToast";
    private static Field mTNField;
    private boolean hasHookTN;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class InternalRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final Runnable f316044d;

        InternalRunnable(Runnable runnable) {
            this.f316044d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f316044d.run();
            } catch (WindowManager.BadTokenException | IllegalStateException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements Handler.Callback {

        /* renamed from: d, reason: collision with root package name */
        private final Handler f316045d;

        public a(Handler handler) {
            this.f316045d = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                this.f316045d.handleMessage(message);
                return true;
            } catch (WindowManager.BadTokenException | IllegalStateException e16) {
                e16.printStackTrace();
                return true;
            }
        }
    }

    public QFixToast(Context context) {
        super(context);
        this.hasHookTN = false;
        fixTNAndroid7BadTokenAndIllegalState();
    }

    private void fixTNAndroid7BadTokenAndIllegalState() {
        if (Build.VERSION.SDK_INT <= 29) {
            Object tNObj = getTNObj();
            if (tNObj == null) {
                QLog.e(TAG, 2, "fixTNAndroid7BadToken get Toast TN Field Failed");
                return;
            }
            if (this.hasHookTN) {
                QLog.e(TAG, 2, "fixTNAndroid7BadToken has Hook");
                return;
            }
            Object fieldValue = getFieldValue(tNObj, "mShow");
            if (fieldValue instanceof Runnable) {
                this.hasHookTN = setFieldValue(tNObj, "mShow", new InternalRunnable((Runnable) fieldValue));
            }
            if (!this.hasHookTN) {
                Object fieldValue2 = getFieldValue(tNObj, "mHandler");
                if (fieldValue2 instanceof Handler) {
                    this.hasHookTN = setFieldValue(fieldValue2, "mCallback", new a((Handler) fieldValue2));
                }
            }
            if (!this.hasHookTN && QLog.isColorLevel()) {
                QLog.d(TAG, 1, "tryToHook error.");
            }
        }
    }

    protected static Field getDeclaredField(Object obj, String str) {
        Field field;
        Class<?> cls = obj.getClass();
        while (true) {
            field = null;
            if (cls == Object.class || cls == null) {
                break;
            }
            try {
                field = cls.getDeclaredField(str);
                break;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return field;
    }

    protected static Object getFieldValue(Object obj, String str) {
        return getFieldValue(obj, getDeclaredField(obj, str));
    }

    private void initTNField() {
        if (mTNField == null) {
            try {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                mTNField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                QLog.e(TAG, 2, "get Toast TN Field Failed");
            }
        }
    }

    protected static boolean setFieldValue(Object obj, String str, Object obj2) {
        Field declaredField = getDeclaredField(obj, str);
        if (declaredField != null) {
            try {
                if (Modifier.isFinal(declaredField.getModifiers())) {
                    Field declaredField2 = Field.class.getDeclaredField("accessFlags");
                    declaredField2.setAccessible(true);
                    declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
                }
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                declaredField.set(obj, obj2);
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object getTNObj() {
        if (mTNField == null) {
            initTNField();
        }
        Field field = mTNField;
        if (field == null) {
            return null;
        }
        try {
            return field.get(this);
        } catch (IllegalAccessException unused) {
            QLog.e(TAG, 2, "get Toast TN obj Failed");
            return null;
        }
    }

    protected static Object getFieldValue(Object obj, Field field) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
