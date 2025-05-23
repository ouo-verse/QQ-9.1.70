package com.tencent.biz.richframework.ioc;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.bean.FindIocKeyResult;
import com.tencent.biz.richframework.ioc.callback.IocPromise;
import com.tencent.biz.richframework.ioc.callback.IocPromiseTask;
import com.tencent.biz.richframework.ioc.operate.ViewTagSaveOperate;
import com.tencent.biz.richframework.ioc.operate.ViewTreeFindOperate;
import com.tencent.biz.richframework.ioc.operate.api.IViewTagSaveOperate;
import com.tencent.biz.richframework.ioc.operate.api.IViewTreeFindOperate;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class RFWIocAbilityProvider {
    private static final int IOC_KEY_TAG_ID = 2131385783;
    private static volatile RFWIocAbilityProvider sInstance;
    private final IViewTreeFindOperate mFindOperate;
    private final RFWIocInterfaceCenter mIocInterfaceCenter;
    private final RFWLogicParentViewStore mLogicParentViewStore;
    private final IViewTagSaveOperate mSaveOperate = new ViewTagSaveOperate();

    RFWIocAbilityProvider() {
        ViewTreeFindOperate viewTreeFindOperate = new ViewTreeFindOperate();
        this.mFindOperate = viewTreeFindOperate;
        this.mIocInterfaceCenter = new RFWIocInterfaceCenter();
        RFWLogicParentViewStore rFWLogicParentViewStore = new RFWLogicParentViewStore();
        this.mLogicParentViewStore = rFWLogicParentViewStore;
        viewTreeFindOperate.injectILogicParentViewGetter(rFWLogicParentViewStore);
    }

    public static RFWIocAbilityProvider g() {
        if (sInstance == null) {
            synchronized (RFWIocAbilityProvider.class) {
                if (sInstance == null) {
                    sInstance = new RFWIocAbilityProvider();
                }
            }
        }
        return sInstance;
    }

    @Nullable
    private Object getFirstIocFromResult(int i3, FindIocKeyResult findIocKeyResult) {
        Object obj = null;
        if (findIocKeyResult != null && findIocKeyResult.getIocKeyList() != null && !findIocKeyResult.getIocKeyList().isEmpty()) {
            Iterator<String> it = findIocKeyResult.getIocKeyList().iterator();
            while (it.hasNext()) {
                obj = this.mIocInterfaceCenter.getSingleIoc(i3, it.next());
                if (obj != null) {
                    break;
                }
            }
        }
        return obj;
    }

    public <T> IocPromise<T> getIoc(Class<T> cls) {
        IocPromiseTask iocPromiseTask = new IocPromiseTask();
        iocPromiseTask.setIocClass(cls);
        iocPromiseTask.setIocInterfaceCenter(this.mIocInterfaceCenter);
        iocPromiseTask.setViewTreeFindOperate(this.mFindOperate);
        iocPromiseTask.setIocKeyTagId(IOC_KEY_TAG_ID);
        return iocPromiseTask;
    }

    @Deprecated
    public <T> T getIocInterface(Class<T> cls, View view, ViewGroup viewGroup) {
        if (view != null && cls != null) {
            int hashCode = view.getContext().hashCode();
            String name = cls.getName();
            FindIocKeyResult findIocKey = this.mFindOperate.findIocKey(IOC_KEY_TAG_ID, view, viewGroup, name);
            Object firstIocFromResult = getFirstIocFromResult(hashCode, findIocKey);
            if (firstIocFromResult == null) {
                firstIocFromResult = (T) this.mIocInterfaceCenter.getSingleIoc(hashCode, cls.getName() + "_" + hashCode);
            }
            if (firstIocFromResult == null && TextUtils.equals(view.getClass().getName(), "com.android.internal.policy.DecorView") && (view instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) view;
                if (viewGroup2.getChildCount() > 0) {
                    int hashCode2 = viewGroup2.getChildAt(0).getContext().hashCode();
                    firstIocFromResult = (T) this.mIocInterfaceCenter.getSingleIoc(hashCode2, cls.getName() + "_" + hashCode2);
                }
            }
            if (firstIocFromResult != null) {
                return (T) firstIocFromResult;
            }
            RFWLog.e("qioc-RFWIocAbilityProvider", RFWLog.USR, "getIocInterface  find ioc result. | pageKey = " + hashCode + " | iocClassName = " + name + " | view = " + view.getClass().getSimpleName() + " | result = " + findIocKey + " | ioc = null | viewHash = " + view.hashCode());
            return null;
        }
        RFWLog.e("qioc-RFWIocAbilityProvider", RFWLog.USR, "getIocInterface  params error");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RFWIocInterfaceCenter getIocInterfaceCenter() {
        return this.mIocInterfaceCenter;
    }

    public void registerGlobalIoc(Context context, Object obj, Class<?> cls) {
        if (context != null && obj != null && cls != null) {
            int hashCode = context.hashCode();
            String str = cls.getName() + "_" + context.hashCode();
            RFWLog.i("qioc-RFWIocAbilityProvider", RFWLog.USR, "registerGlobalIoc   | pageKey = " + hashCode + " | context = " + context + " | iocKey = " + str);
            this.mIocInterfaceCenter.addIocInterface(hashCode, str, obj);
            return;
        }
        RFWLog.e("qioc-RFWIocAbilityProvider", RFWLog.USR, "registerGlobalIoc  params error");
    }

    public void registerIoc(View view, Object obj, Class<?> cls) {
        if (view != null && obj != null && cls != null) {
            int hashCode = view.getContext().hashCode();
            String str = cls.getName() + "_" + view.hashCode();
            RFWLog.i("qioc-RFWIocAbilityProvider", RFWLog.USR, "registerIoc   | pageKey = " + hashCode + " | view = " + view.getClass().getSimpleName() + " | iocKey = " + str);
            this.mIocInterfaceCenter.addIocInterface(hashCode, str, obj);
            this.mSaveOperate.saveIocKeyToViewTag(IOC_KEY_TAG_ID, view, str);
            LifecycleIocManagerRetriever.g().addViewLifecycle(view, hashCode, str);
            return;
        }
        RFWLog.e("qioc-RFWIocAbilityProvider", RFWLog.USR, "registerIoc  params error");
    }

    @Deprecated
    public void setLogicParentView(View view, ViewGroup viewGroup) {
        this.mLogicParentViewStore.setLogicParentView(view, viewGroup);
    }

    public void unregisterGlobalIoc(Context context, Class<?> cls) {
        if (context != null && cls != null) {
            int hashCode = context.hashCode();
            String str = cls.getName() + "_" + context.hashCode();
            RFWLog.i("qioc-RFWIocAbilityProvider", RFWLog.USR, "unregisterGlobalIoc   | pageKey = " + hashCode + " | context = " + context + " | iocKey = " + str);
            this.mIocInterfaceCenter.removeSingleIoc(hashCode, str);
            return;
        }
        RFWLog.e("qioc-RFWIocAbilityProvider", RFWLog.USR, "unregisterGlobalIoc  params error");
    }

    public void unregisterSingleIoc(View view, Class<?> cls) {
        if (view != null && cls != null) {
            int hashCode = view.getContext().hashCode();
            String str = cls.getName() + "_" + view.hashCode();
            RFWLog.i("qioc-RFWIocAbilityProvider", RFWLog.USR, "unregisterSingleIoc   | pageKey = " + hashCode + " | view = " + view.getClass().getSimpleName() + " | iocKey = " + str);
            this.mIocInterfaceCenter.removeSingleIoc(hashCode, str);
            this.mSaveOperate.removeIocKeyFromViewTag(IOC_KEY_TAG_ID, view, str);
            return;
        }
        RFWLog.e("qioc-RFWIocAbilityProvider", RFWLog.USR, "unregisterSingleIoc  params error");
    }
}
