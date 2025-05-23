package cooperation.qqcircle.factory;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.richframework.collection.RFWThreadLocal;
import com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2;
import com.tencent.mobileqq.auto.engine.skin.entity.SkinAttr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.util.WeakReference;
import uq3.o;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleSkinFactory2 extends RFWSkinFactory2 {
    private static final String TAG = "QCircleSkinFactory2";
    private WeakReference<InflaterHelperImpl> mInflaterHelperWeak;
    protected final RFWThreadLocal<InflaterHelperImpl> mInflaterHelpers;
    private boolean mIsNeedUpdateViewVal;
    private WeakReference<OnHookCreateViewCallback> mOnHookCreateViewCallbackWeak;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class InflaterHelperImpl extends RFWSkinFactory2.InflaterHelper {
        InflaterHelperImpl() {
        }

        public void clear() {
            List<SkinAttr> list = this.mViewAttrs;
            if (list == null) {
                return;
            }
            list.clear();
        }
    }

    public QCircleSkinFactory2(String str) {
        super(str);
        this.mInflaterHelpers = new RFWThreadLocal<InflaterHelperImpl>() { // from class: cooperation.qqcircle.factory.QCircleSkinFactory2.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.tencent.biz.richframework.collection.RFWThreadLocal
            public InflaterHelperImpl initialValue(boolean z16) {
                return new InflaterHelperImpl();
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062 A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:11:0x0054, B:15:0x0062, B:19:0x0059), top: B:10:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:11:0x0054, B:15:0x0062, B:19:0x0059), top: B:10:0x0054 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View initCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View view2;
        WeakReference<InflaterHelperImpl> weakReference;
        boolean z16;
        InflaterHelperImpl inflaterHelperImpl = null;
        try {
            List<ParseViewAttrEntry> parseViewAttrResId = parseViewAttrResId(context, str, attributeSet);
            if (parseViewAttrResId != null && !parseViewAttrResId.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mIsNeedUpdateViewVal = z16;
            setForceSkinFactory2(z16);
            view2 = super.onCreateView(view, str, context, attributeSet);
            if (parseViewAttrResId != null) {
                try {
                    if (!parseViewAttrResId.isEmpty()) {
                        for (ParseViewAttrEntry parseViewAttrEntry : parseViewAttrResId) {
                            notifyUpdateViewAttrValue(context, view2, parseViewAttrEntry.mAttributeValue, parseViewAttrEntry.mAttributeName, parseViewAttrEntry.mViewAttrParse);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    QLog.e(TAG, 1, "[initCreateView] ex: ", th);
                    weakReference = this.mInflaterHelperWeak;
                    if (weakReference == null) {
                    }
                    if (inflaterHelperImpl != null) {
                    }
                    return view2;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            view2 = null;
        }
        try {
            weakReference = this.mInflaterHelperWeak;
            if (weakReference == null) {
                inflaterHelperImpl = weakReference.get();
            }
            if (inflaterHelperImpl != null) {
                inflaterHelperImpl.clear();
            }
        } catch (Throwable th7) {
            QLog.e(TAG, 1, "[initCreateView] ex: ", th7);
        }
        return view2;
    }

    private void notifyUpdateViewAttrValue(Context context, View view, String str, String str2, IQFSViewAttrParse iQFSViewAttrParse) {
        OnHookCreateViewCallback onHookCreateViewCallback;
        WeakReference<OnHookCreateViewCallback> weakReference = this.mOnHookCreateViewCallbackWeak;
        if (weakReference == null) {
            onHookCreateViewCallback = null;
        } else {
            onHookCreateViewCallback = weakReference.get();
        }
        OnHookCreateViewCallback onHookCreateViewCallback2 = onHookCreateViewCallback;
        if (onHookCreateViewCallback2 == null) {
            return;
        }
        onHookCreateViewCallback2.updateViewAttrValue(context, view, str, str2, iQFSViewAttrParse);
    }

    private List<ParseViewAttrEntry> parseViewAttrResId(Context context, String str, AttributeSet attributeSet) {
        OnHookCreateViewCallback onHookCreateViewCallback;
        WeakReference<OnHookCreateViewCallback> weakReference = this.mOnHookCreateViewCallbackWeak;
        if (weakReference == null) {
            onHookCreateViewCallback = null;
        } else {
            onHookCreateViewCallback = weakReference.get();
        }
        if (onHookCreateViewCallback == null) {
            return null;
        }
        return onHookCreateViewCallback.parseViewAttrResId(context, str, attributeSet);
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2
    public RFWSkinFactory2.InflaterHelper getInflaterHelper() {
        return this.mInflaterHelpers.get();
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return initCreateView(null, str, context, attributeSet);
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2
    public boolean parseSkinAttr(Context context, AttributeSet attributeSet, RFWSkinFactory2.InflaterHelper inflaterHelper) {
        boolean parseSkinAttr = super.parseSkinAttr(context, attributeSet, inflaterHelper);
        if (!parseSkinAttr && this.mIsNeedUpdateViewVal) {
            parseSkinAttr = true;
        }
        if (inflaterHelper instanceof InflaterHelperImpl) {
            this.mInflaterHelperWeak = new WeakReference<>((InflaterHelperImpl) inflaterHelper);
        }
        return parseSkinAttr;
    }

    public void release() {
        if (this.mInflaterHelpers == null) {
            return;
        }
        try {
            if (!o.R1()) {
                return;
            }
            this.mInflaterHelpers.get().clear();
            this.mInflaterHelpers.clear();
            QLog.d(TAG, 1, "[release] clear inflater impl objs.");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public void setOnHookLayoutInflaterViewAttr(OnHookCreateViewCallback onHookCreateViewCallback) {
        this.mOnHookCreateViewCallbackWeak = new WeakReference<>(onHookCreateViewCallback);
    }

    @Override // com.tencent.mobileqq.auto.engine.skin.RFWSkinFactory2, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return initCreateView(view, str, context, attributeSet);
    }
}
