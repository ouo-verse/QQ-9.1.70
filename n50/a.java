package n50;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.layer.base.b;
import com.tencent.biz.qqcircle.immersive.layer.base.c;
import com.tencent.biz.qqcircle.immersive.layer.base.f;
import com.tencent.biz.qqcircle.immersive.layer.biz.g;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.album.e;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final b f418372a = new com.tencent.biz.qqcircle.immersive.layer.biz.b();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Class<? extends c>> f418373b;

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f418374c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, f> f418375d;

    static {
        ConcurrentHashMap<String, Class<? extends c>> concurrentHashMap = new ConcurrentHashMap<>();
        f418373b = concurrentHashMap;
        ConcurrentHashMap<String, b> concurrentHashMap2 = new ConcurrentHashMap<>();
        f418374c = concurrentHashMap2;
        ConcurrentHashMap<String, f> concurrentHashMap3 = new ConcurrentHashMap<>();
        f418375d = concurrentHashMap3;
        concurrentHashMap2.put("biz_tab", new com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.c());
        concurrentHashMap2.put("biz_data_share", new z40.a());
        concurrentHashMap2.put("biz_album_page", new e());
        concurrentHashMap2.put("biz_tag_challenge_page", new com.tencent.biz.qqcircle.immersive.layer.biz.inside.challeng.a());
        concurrentHashMap2.put("biz_wink_tag_polymerization", new a50.a());
        concurrentHashMap2.put("biz_polymerization", new v40.a());
        concurrentHashMap2.put("biz_search_result_page", new x40.b());
        concurrentHashMap2.put("biz_qq_search", new x40.a());
        concurrentHashMap2.put("biz_qzone_qq_video_layer", new w40.a());
        concurrentHashMap2.put("biz_aio_chat_history_layer", new b50.a());
        concurrentHashMap3.put("biz_tvideo", new com.tencent.mobileqq.tvideo.base.a());
        concurrentHashMap3.put("biz_subscribe", new com.tencent.biz.qqcircle.immersive.layer.biz.outside.subscribe.a());
        concurrentHashMap3.put("biz_search", new com.tencent.biz.qqcircle.immersive.layer.biz.outside.search.a());
        concurrentHashMap3.put("biz_polymerize_detail", new com.tencent.biz.qqcircle.immersive.layer.biz.outside.polymerize.a());
        concurrentHashMap3.put("biz_mini_game", new d50.a());
        concurrentHashMap3.put("biz_hot_comment_collection", new c50.a());
        concurrentHashMap3.put("biz_public_account_from_message", new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.a());
        concurrentHashMap3.put("biz_public_account_from_staggered", new h50.a());
        concurrentHashMap3.put("qq_profile_card", new e50.a());
        concurrentHashMap3.put("qq_profile_dynamic_avatar", new e50.b());
        concurrentHashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_SHARE_MID_PAGE, g.class);
        concurrentHashMap.put(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_QQ_VIDEO_PAGE, g.class);
    }

    public static b a(QCircleInitBean qCircleInitBean) {
        if (qCircleInitBean == null) {
            QLog.e("QFSLayerAssemblerManager", 1, "[getAssembler]  initBean = null");
            return null;
        }
        if (!TextUtils.isEmpty(qCircleInitBean.getLayerBizAssemblerType())) {
            QLog.i("QFSLayerAssemblerManager", 1, "[getAssembler]  initBean.getLayerBizAssemblerType = " + qCircleInitBean.getLayerBizAssemblerType());
            ConcurrentHashMap<String, b> concurrentHashMap = f418374c;
            if (!concurrentHashMap.containsKey(qCircleInitBean.getLayerBizAssemblerType())) {
                QLog.e("QFSLayerAssemblerManager", 1, "[getAssembler] bizId:" + qCircleInitBean.getLayerBizAssemblerType() + " is not register table ASSEMBLER_MAP");
                if (!QCircleHostConstants._AppSetting.isDebugVersion()) {
                    return null;
                }
                throw new RuntimeException("QFSLayerAssemblerManager no register table ASSEMBLER_MAP, bizId = " + qCircleInitBean.getLayerBizAssemblerType());
            }
            return concurrentHashMap.get(qCircleInitBean.getLayerBizAssemblerType());
        }
        for (f fVar : f418375d.values()) {
            if (fVar.w(qCircleInitBean)) {
                return fVar;
            }
        }
        return f418372a;
    }

    public static String b(QCircleInitBean qCircleInitBean) {
        HashMap<String, String> schemeAttrs;
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || (schemeAttrs = qCircleInitBean.getSchemeAttrs()) == null || !schemeAttrs.containsKey("xsj_custom_pgid")) {
            return "";
        }
        return schemeAttrs.get("xsj_custom_pgid");
    }

    public static c c(QCircleInitBean qCircleInitBean) {
        String b16 = b(qCircleInitBean);
        if (!TextUtils.isEmpty(b16)) {
            ConcurrentHashMap<String, Class<? extends c>> concurrentHashMap = f418373b;
            if (concurrentHashMap.containsKey(b16)) {
                try {
                    c newInstance = concurrentHashMap.get(b16).newInstance();
                    newInstance.c(qCircleInitBean);
                    return newInstance;
                } catch (IllegalAccessException e16) {
                    QLog.d("QFSLayerAssemblerManager", 1, "getPreloadTaskError", e16);
                } catch (InstantiationException e17) {
                    QLog.d("QFSLayerAssemblerManager", 1, "getPreloadTaskError", e17);
                }
            }
        }
        return null;
    }
}
