package com.tencent.biz.qqcircle.immersive;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleAlbumBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.part.dz;
import com.tencent.biz.qqcircle.immersive.personal.utils.QFSPersonalConsumeTimeManager;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uq3.o;

/* loaded from: classes4.dex */
public class QFSLayerPageFragment extends QFSBaseFragment {
    private QCircleInitBean E;

    private void Ah(QCircleInitBean qCircleInitBean, Map<String, Object> map) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            String str = qCircleInitBean.getSchemeAttrs().get(QCircleDaTongConstant.ElementParamKey.XSJ_BEGBOOST_ARK_RATE);
            String str2 = qCircleInitBean.getSchemeAttrs().get(QCircleSchemeAttr.HelpPush.IS_REFORMED_PUSH_SHARE);
            String str3 = qCircleInitBean.getSchemeAttrs().get(QCircleSchemeAttr.HelpPush.SHARE_UIN);
            if (str != null) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_BEGBOOST_ARK_RATE, str);
            }
            if (str2 != null) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_FROM_BEGBOOST_ARK, str2);
            }
            if (str3 != null) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_SHARER_UIN, str3);
            }
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_WHITELIST, 0);
        }
    }

    private String rh(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            return qCircleInitBean.getSchemeAttrs().get("xsj_custom_pgid");
        }
        return xh(qCircleInitBean);
    }

    private String sh(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            return qCircleInitBean.getSchemeAttrs().get(QCircleDaTongConstant.ElementParamKey.XSJ_SOURCE_FEED_ID);
        }
        return null;
    }

    private String th() {
        QCircleInitBean initBean = getInitBean();
        if (initBean != null && initBean.getSchemeAttrs() != null) {
            if (!initBean.getSchemeAttrs().containsKey("xsj_main_entrance")) {
                return "";
            }
            return initBean.getSchemeAttrs().get("xsj_main_entrance");
        }
        QLog.e("QFSLayerPageFragment", 1, "[parseSchemeAttrs] schemeAttr is null");
        return "";
    }

    private String uh() {
        String rh5 = rh(getInitBean());
        if (!TextUtils.isEmpty(rh5)) {
            return rh5;
        }
        return "0";
    }

    private String vh(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean != null && qCircleInitBean.getSchemeAttrs() != null) {
            return qCircleInitBean.getSchemeAttrs().get("uin");
        }
        return null;
    }

    private void wh(int i3) {
        if (getInitBean() != null && getInitBean().getExtraTypeInfo() != null && getInitBean().getExtraTypeInfo().sourceType == 20101 && getInitBean().getFeed() != null && getInitBean().getFeed().poster != null) {
            if ("pg_xsj_explore_page".equals(getInitBean().getFromReportBean().getDtFromPageId()) || dz.z9()) {
                QFSPersonalConsumeTimeManager.e().d(getInitBean().getFeed(), getInitBean().getFeed().poster.f398463id.get(), i3);
            }
        }
    }

    private String xh(QCircleInitBean qCircleInitBean) {
        if (!o.l1() || qCircleInitBean == null || qCircleInitBean.getFromReportBean() == null) {
            return null;
        }
        return qCircleInitBean.getFromReportBean().getDtPageId();
    }

    private void yh() {
        if (getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
    }

    private void zh(Map<String, Object> map) {
        String str;
        if (getInitBean().getUser() != null) {
            if (r.u0(getInitBean().getUser())) {
                str = "host";
            } else {
                str = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
            }
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST_GUEST_TYPE, str);
            if (!TextUtils.isEmpty(getInitBean().getUser().f398463id.get())) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST, getInitBean().getUser().f398463id.get());
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        com.tencent.biz.qqcircle.immersive.layer.base.b a16;
        if (getInitBean() == null || (a16 = n50.a.a(getInitBean())) == null) {
            return null;
        }
        return a16.p(a16.u().d(getInitBean()).c(this));
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public Map<String, Object> getChildDaTongPageParams() {
        String str;
        Object obj;
        QCircleLayerBean.QFSTagPolymerizationBean qfsTagPolymerizationBean;
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("xsj_custom_pgid", uh());
        hashMap.put("come_from", th());
        QCircleInitBean initBean = getInitBean();
        if (initBean == null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_RECENT_WATCHED_PAGE, 0);
            return hashMap;
        }
        String str2 = (String) initBean.getExtraTypeInfo().mReportExtraMap.get(QFS5507ReportHelper.JsonKey.TRANS_FEEDID);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_RECOM_TRANS_TRACEID, str2);
        }
        String sh5 = sh(initBean);
        if (!TextUtils.isEmpty(sh5)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SOURCE_FEED_ID, sh5);
        }
        if (initBean.getTagInfo() != null && initBean.getTagInfo().has()) {
            if (initBean.getTagInfo().tagId.has()) {
                hashMap.put("xsj_topic_id", initBean.getTagInfo().tagId.get());
            }
            if (initBean.getTagInfo().tagName.has()) {
                hashMap.put("xsj_topic_name", initBean.getTagInfo().tagName.get());
            }
        }
        hashMap.put("xsj_topic_page_source", "0");
        if ((initBean instanceof QCircleLayerBean) && (qfsTagPolymerizationBean = ((QCircleLayerBean) initBean).getQfsTagPolymerizationBean()) != null) {
            hashMap.put("xsj_topic_page_source", qfsTagPolymerizationBean.feedTagPageFromType);
            hashMap.put("xsj_operation_activity_id", qfsTagPolymerizationBean.operationActivityId);
        }
        if (TextUtils.equals(initBean.getLayerBizAssemblerType(), "biz_album_page")) {
            zh(hashMap);
            hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_ALBUM_PAGE);
            QCircleAlbumBean qCircleAlbumBean = (QCircleAlbumBean) initBean;
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_SOURCE, c40.b.b(qCircleAlbumBean));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_ID, Long.valueOf(qCircleAlbumBean.getFeedAlbumInfo().mAlbumId));
        }
        if (TextUtils.equals(initBean.getLayerBizAssemblerType(), "biz_tag_challenge_page")) {
            zh(hashMap);
            hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_TOPIC_CHALLENGE_AGG_PAGE);
        }
        if (e50.a.x(initBean)) {
            if (r.v0(vh(initBean))) {
                obj = "host";
            } else {
                obj = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
            }
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_PROFILE_HOST_GUEST_TYPE, obj);
        }
        if (initBean.getExtraTypeInfo() != null && initBean.getExtraTypeInfo().sourceType == 20107) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_RECENT_WATCHED_PAGE, 1);
        } else {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_RECENT_WATCHED_PAGE, 0);
        }
        if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.h(initBean)) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSG_PAGE_REF_FEEDID, initBean.getFeed().f398449id.get());
        }
        Ah(initBean, hashMap);
        if (initBean.getSchemeAttrs() != null && (str = initBean.getSchemeAttrs().get("key_jump_from")) != null && TextUtils.equals(str, String.valueOf(1006))) {
            hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LIVE_AVATAR_ENTRANCE, "4");
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168695gg0;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public String getDaTongPageId() {
        if (getInitBean() != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.f(getInitBean())) {
            return "pg_xsj_gzh_page";
        }
        if (QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE.equals(rh(getInitBean()))) {
            return QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE;
        }
        return QCircleDaTongConstant.PageId.PG_XSJ_LAYER_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public QCircleInitBean getInitBean() {
        if (this.E == null) {
            this.E = QCirclePluginUtil.getQCircleInitBean(getActivity());
        }
        return this.E;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPageFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        if (getInitBean() != null && com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.f(getInitBean())) {
            return 301;
        }
        if (getInitBean() != null && getInitBean().getExtraTypeInfo() != null && getInitBean().getExtraTypeInfo().sourceType == 85) {
            return 506;
        }
        if (getInitBean() != null && getInitBean().getExtraTypeInfo() != null && getInitBean().getExtraTypeInfo().sourceType == 90) {
            return 200;
        }
        if (QCircleDaTongConstant.PageId.PG_XSJ_AVATAR_APERTURE_PAGE.equals(rh(getInitBean()))) {
            return 1053;
        }
        return 57;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        QFSHodorCollectManager.f84689a.a("QFS_LAYER_PAGE_CREATE_COST");
        yh();
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        wh(1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.QFSBaseFragment, com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        wh(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreatedAfterPartInit(view, bundle);
        QFSHodorCollectManager.f84689a.c("QFS_LAYER_PAGE_CREATE_COST");
    }
}
