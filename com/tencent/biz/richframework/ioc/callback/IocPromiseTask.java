package com.tencent.biz.richframework.ioc.callback;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocInterfaceCenter;
import com.tencent.biz.richframework.ioc.bean.FindIocKeyResult;
import com.tencent.biz.richframework.ioc.operate.api.IViewTreeFindOperate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class IocPromiseTask<T> implements IocPromise<T> {
    private IViewTreeFindOperate mFindOperate;
    private Context mGlobalContext;
    private Class<T> mIocClass;
    private RFWIocInterfaceCenter mIocInterfaceCenter;
    private int mIocKeyTagId;
    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.biz.richframework.ioc.callback.IocPromiseTask.1
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (IocPromiseTask.this.mOriginView.getViewTreeObserver().isAlive()) {
                IocPromiseTask.this.mOriginView.getViewTreeObserver().removeOnPreDrawListener(IocPromiseTask.this.mOnPreDrawListener);
            }
            IocPromiseTask.this.onDoneCallback(IocPromiseTask.this.mFindOperate.findIocKey(IocPromiseTask.this.mIocKeyTagId, IocPromiseTask.this.mOriginView, null, IocPromiseTask.this.mIocClass.getName()), true);
            return true;
        }
    };
    private View mOriginView;
    private OnPromiseRejected mPromiseRejected;
    private OnPromiseResolved<T> mPromiseResolved;

    private void addContextWrapperIoc(List<Object> list) {
        View view = this.mOriginView;
        if (view != null && this.mIocClass != null && TextUtils.equals(view.getClass().getName(), "com.android.internal.policy.DecorView")) {
            View view2 = this.mOriginView;
            if ((view2 instanceof ViewGroup) && ((ViewGroup) view2).getChildCount() != 0) {
                int hashCode = ((ViewGroup) this.mOriginView).getChildAt(0).getContext().hashCode();
                Object singleIoc = this.mIocInterfaceCenter.getSingleIoc(hashCode, this.mIocClass.getName() + "_" + hashCode);
                if (singleIoc != null) {
                    list.add(singleIoc);
                }
            }
        }
    }

    private void addGlobalContextIoc(List<Object> list) {
        if (this.mGlobalContext != null && this.mIocClass != null && this.mIocInterfaceCenter != null) {
            Object singleIoc = this.mIocInterfaceCenter.getSingleIoc(this.mGlobalContext.hashCode(), this.mIocClass.getName() + "_" + this.mGlobalContext.hashCode());
            if (singleIoc != null) {
                list.add(singleIoc);
            }
        }
    }

    private void addViewTreeIoc(FindIocKeyResult findIocKeyResult, List<Object> list) {
        if (findIocKeyResult != null && list != null && findIocKeyResult.getIocKeyList() != null && this.mOriginView != null && this.mIocInterfaceCenter != null) {
            for (String str : findIocKeyResult.getIocKeyList()) {
                Object singleIoc = this.mIocInterfaceCenter.getSingleIoc(this.mOriginView.getContext().hashCode(), str);
                if (singleIoc != null) {
                    list.add(singleIoc);
                }
            }
        }
    }

    private boolean checkEnvironmentParamIsSafe() {
        if (this.mIocClass == null) {
            onFailCallback("[checkParamIsSafe] iocClass == null, please set iocClass");
            return false;
        }
        View view = this.mOriginView;
        if (view == null && this.mGlobalContext == null) {
            onFailCallback("[checkParamIsSafe] originView == null && && mGlobalContext == null, please set at least one of the");
            return false;
        }
        if (this.mGlobalContext == null) {
            this.mGlobalContext = view.getContext();
        }
        if (this.mFindOperate == null) {
            onFailCallback("[checkParamIsSafe] inner error, mFindOperate == null");
            return false;
        }
        if (this.mIocInterfaceCenter == null) {
            onFailCallback("[checkParamIsSafe] inner error, mIocInterfaceCenter == null");
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void finalIocResultCallback(boolean z16, List<Object> list) {
        if (!list.isEmpty()) {
            OnPromiseResolved<T> onPromiseResolved = this.mPromiseResolved;
            if (onPromiseResolved != 0) {
                onPromiseResolved.onDone(list.get(0));
                return;
            }
            return;
        }
        onFailCallback("[onDoneCallback] no find ioc interface, isAsync = " + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDoneCallback(FindIocKeyResult findIocKeyResult, boolean z16) {
        if (this.mIocInterfaceCenter == null) {
            onFailCallback("[onDoneCallback] inner error, mIocInterfaceCenter == null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        addViewTreeIoc(findIocKeyResult, arrayList);
        addGlobalContextIoc(arrayList);
        addContextWrapperIoc(arrayList);
        finalIocResultCallback(z16, arrayList);
    }

    private void onFailCallback(String str) {
        RFWLog.e("qioc-IocPromiseTask", RFWLog.CLR, "onFailCallback  | error = " + str + " | mPromiseResolved = " + this.mPromiseResolved + " | mPromiseRejected = " + this.mPromiseRejected);
        OnPromiseRejected onPromiseRejected = this.mPromiseRejected;
        if (onPromiseRejected != null) {
            onPromiseRejected.onFail(str);
        }
    }

    @Override // com.tencent.biz.richframework.ioc.callback.IocPromise
    public IocPromise<T> done(OnPromiseResolved<T> onPromiseResolved) {
        this.mPromiseResolved = onPromiseResolved;
        return this;
    }

    @Override // com.tencent.biz.richframework.ioc.callback.IocPromise
    public IocPromise<T> fail(OnPromiseRejected onPromiseRejected) {
        this.mPromiseRejected = onPromiseRejected;
        return this;
    }

    public View getOriginView() {
        return this.mOriginView;
    }

    @Override // com.tencent.biz.richframework.ioc.callback.IocPromise
    public IocPromise<T> originView(View view) {
        this.mOriginView = view;
        return this;
    }

    public void release() {
        if (this.mOriginView.getViewTreeObserver().isAlive()) {
            this.mOriginView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    @Override // com.tencent.biz.richframework.ioc.callback.IocPromise
    public void run() {
        if (!checkEnvironmentParamIsSafe()) {
            return;
        }
        View view = this.mOriginView;
        if (view != null) {
            FindIocKeyResult findIocKey = this.mFindOperate.findIocKey(this.mIocKeyTagId, view, null, this.mIocClass.getName());
            if (findIocKey != null && findIocKey.getIocKeyList() != null && !findIocKey.getIocKeyList().isEmpty()) {
                onDoneCallback(findIocKey, false);
                return;
            } else {
                this.mIocInterfaceCenter.saveIocPromiseTask(this);
                this.mOriginView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
                return;
            }
        }
        onDoneCallback(null, false);
    }

    public void setIocClass(Class<T> cls) {
        this.mIocClass = cls;
    }

    public void setIocInterfaceCenter(RFWIocInterfaceCenter rFWIocInterfaceCenter) {
        this.mIocInterfaceCenter = rFWIocInterfaceCenter;
    }

    public void setIocKeyTagId(int i3) {
        this.mIocKeyTagId = i3;
    }

    public void setViewTreeFindOperate(IViewTreeFindOperate iViewTreeFindOperate) {
        this.mFindOperate = iViewTreeFindOperate;
    }

    @Override // com.tencent.biz.richframework.ioc.callback.IocPromise
    public IocPromise<T> withGlobal(Context context) {
        this.mGlobalContext = context;
        return this;
    }
}
