package com.tencent.biz.richframework.ioc.operate;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocUtils;
import com.tencent.biz.richframework.ioc.bean.FindIocKeyResult;
import com.tencent.biz.richframework.ioc.operate.api.ILogicParentViewGetter;
import com.tencent.biz.richframework.ioc.operate.api.IParentViewAttacher;
import com.tencent.biz.richframework.ioc.operate.api.IViewTreeFindOperate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ViewTreeFindOperate implements IViewTreeFindOperate {
    private ILogicParentViewGetter mILogicParentViewGetter;

    private void findIocKeyFromViewTag(int i3, View view, String str, List<String> list) {
        CopyOnWriteArrayList<String> object2CopyOnWriteArrayListOfString;
        if (view == null || list == null || TextUtils.isEmpty(str) || (object2CopyOnWriteArrayListOfString = RFWIocUtils.object2CopyOnWriteArrayListOfString(view.getTag(i3))) == null) {
            return;
        }
        Iterator<String> it = object2CopyOnWriteArrayListOfString.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && next.startsWith(str)) {
                list.add(next);
            }
        }
    }

    @NonNull
    private List<String> getIocKeyFromViewTree(int i3, View view, String str) {
        List<String> arrayList = new ArrayList<>();
        findIocKeyFromViewTag(i3, view, str, arrayList);
        View parentViewFromView = getParentViewFromView(view);
        if (parentViewFromView != null) {
            List<String> iocKeyFromViewTree = getIocKeyFromViewTree(i3, parentViewFromView, str);
            if (iocKeyFromViewTree.size() > 0) {
                arrayList.addAll(iocKeyFromViewTree);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View getParentViewFromView(View view) {
        if (view != 0 && (view.getParent() instanceof View)) {
            return (View) view.getParent();
        }
        if (view instanceof IParentViewAttacher) {
            IParentViewAttacher iParentViewAttacher = (IParentViewAttacher) view;
            if (iParentViewAttacher.getParentView() != null) {
                return iParentViewAttacher.getParentView();
            }
        }
        ILogicParentViewGetter iLogicParentViewGetter = this.mILogicParentViewGetter;
        if (iLogicParentViewGetter != null && iLogicParentViewGetter.getLogicParentView(view) != null) {
            return this.mILogicParentViewGetter.getLogicParentView(view);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.ioc.operate.api.IViewTreeFindOperate
    public FindIocKeyResult findIocKey(int i3, View view, ViewGroup viewGroup, String str) {
        if (view != null && i3 != 0 && !TextUtils.isEmpty(str)) {
            List<String> iocKeyFromViewTree = getIocKeyFromViewTree(i3, view, str);
            if ((iocKeyFromViewTree == null || iocKeyFromViewTree.size() == 0) && viewGroup != null) {
                iocKeyFromViewTree = getIocKeyFromViewTree(i3, viewGroup, str);
            }
            return new FindIocKeyResult(iocKeyFromViewTree);
        }
        RFWLog.e("qioc-ViewTreeFindOperate", RFWLog.USR, "findIocKey  params error");
        return new FindIocKeyResult(null);
    }

    @Override // com.tencent.biz.richframework.ioc.operate.api.IViewTreeFindOperate
    public void injectILogicParentViewGetter(ILogicParentViewGetter iLogicParentViewGetter) {
        this.mILogicParentViewGetter = iLogicParentViewGetter;
    }
}
