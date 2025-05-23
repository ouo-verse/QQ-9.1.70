package com.tencent.biz.qqcircle.aioshare;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSAIOFeedShareInitBean;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import l20.d;
import l20.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/aioshare/QFSAIOFeedShareFragment;", "Lcom/tencent/biz/qqcircle/immersive/QFSBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "getPageId", "", "", "getChildDaTongPageParams", "getDaTongPageId", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSAIOFeedShareFragment extends QFSBaseFragment {
    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new e(), new d());
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public Map<String, Object> getChildDaTongPageParams() {
        QFSAIOFeedShareInitBean qFSAIOFeedShareInitBean;
        HashMap hashMap = new HashMap();
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean instanceof QFSAIOFeedShareInitBean) {
            qFSAIOFeedShareInitBean = (QFSAIOFeedShareInitBean) qCircleInitBean;
        } else {
            qFSAIOFeedShareInitBean = null;
        }
        if (qFSAIOFeedShareInitBean != null) {
            hashMap.put("xsj_target_qq", qFSAIOFeedShareInitBean.getAioUin());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, qFSAIOFeedShareInitBean.getFromType());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g7r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_PERSONAL_WORKS_LAYER_PAGE;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAIOFeedShareFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 0;
    }
}
