package com.tencent.mobileqq.proavatar.info;

import AvatarInfo.QQHeadInfo;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.bean.QQHeadDetails;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.utils.c;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.proavatar.ProAvatarComponentInit;
import com.tencent.mobileqq.proavatar.group.GroupUtil;
import com.tencent.mobileqq.proavatar.info.db.AvatarInfoEntity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.meta.info.d;
import com.tencent.qqnt.avatar.meta.info.g;
import com.tencent.qqnt.avatar.meta.refresh.RefreshMapping;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b:\u0010;J)\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0011\u0010\tJ\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0002J&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0003J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\u001c\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u001c\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u001e\u001a\u00020 H\u0002J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\rH\u0003J\u0018\u0010%\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\rH\u0002J\u0016\u0010(\u001a\u00020\u000f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001a0&H\u0007J&\u0010,\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\f\u0010'\u001a\b\u0012\u0004\u0012\u00020+0&H\u0007J \u0010-\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J)\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b.\u0010\tJ\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u00103\u001a\u00020\u000b2\u0006\u00100\u001a\u00020\u00022\u0006\u00102\u001a\u000201H\u0016J\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u00104\u001a\u00020\u0006R&\u00109\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r07068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/a;", "Lcom/tencent/qqnt/avatar/meta/info/d;", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "", "", "", "", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/qqnt/avatar/meta/a;)[Ljava/util/Map;", "bean", "", "skipMemory", "Lcom/tencent/qqnt/avatar/meta/info/g;", "callback", "", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "", "type", "id", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/avatar/api/IQQAvatarHandlerService;", DomainData.DOMAIN_NAME, "LAvatarInfo/QQHeadInfo;", "qqHeadInfo", "g", "Lcom/tencent/mobileqq/data/Setting;", "setting", h.F, "Lcom/tencent/mobileqq/proavatar/info/db/AvatarInfoEntity;", "i", "key", "cb", "e", "r", "", "list", "o", "dstUsrType", "idType", "Lcom/tencent/mobileqq/app/face/bean/QQHeadDetails;", "p", "c", "b", "d", "infoAvatarBean", "", "lastCheckTime", "a", "faceKey", "l", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "getAvatarInfoCallbackMap", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f259616a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, Set<g>> getAvatarInfoCallbackMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17917);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f259616a = new a();
            getAvatarInfoCallbackMap = new ConcurrentHashMap<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    private static final synchronized void e(String key, g cb5) {
        Set<g> putIfAbsent;
        synchronized (a.class) {
            ConcurrentHashMap<String, Set<g>> concurrentHashMap = getAvatarInfoCallbackMap;
            Set<g> set = concurrentHashMap.get(key);
            if (set == null && (putIfAbsent = concurrentHashMap.putIfAbsent(key, (set = new CopyOnWriteArraySet<>()))) != null) {
                set = putIfAbsent;
            }
            set.add(cb5);
        }
    }

    private final void f(com.tencent.qqnt.avatar.meta.a bean, boolean skipMemory, g callback) {
        boolean z16;
        String c16 = bean.c();
        if (c16 != null && c16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            callback.a(new Map[0]);
        }
        q(bean, skipMemory, callback);
    }

    private final Map<String, Object> g(QQHeadInfo qqHeadInfo) {
        HashMap hashMap = new HashMap();
        String str = qqHeadInfo.downLoadUrl;
        Intrinsics.checkNotNullExpressionValue(str, "qqHeadInfo.downLoadUrl");
        hashMap.put("url", str);
        String str2 = qqHeadInfo.zplanFaceBgUrl;
        Intrinsics.checkNotNullExpressionValue(str2, "qqHeadInfo.zplanFaceBgUrl");
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_BG_URL, str2);
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG, Byte.valueOf(qqHeadInfo.apngFaceFlag));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP, Long.valueOf(qqHeadInfo.dwTimestamp));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG, Byte.valueOf(qqHeadInfo.staticZplanFaceFlag));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_CLIP_PERCENT, Integer.valueOf(qqHeadInfo.zplanFaceClipPercent));
        hashMap.put("uin", String.valueOf(qqHeadInfo.uin));
        hashMap.put("avatar_type", Integer.valueOf(qqHeadInfo.dstUsrType));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.INFO_REQUEST_TIME, Long.valueOf(System.currentTimeMillis()));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, Byte.valueOf(qqHeadInfo.dwFaceFlgas));
        return hashMap;
    }

    private final Map<String, Object> h(Setting setting) {
        HashMap hashMap = new HashMap();
        String str = setting.url;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("url", str);
        String str3 = setting.zplanFaceBgUrl;
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_BG_URL, str3);
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG, Byte.valueOf(setting.apngFaceFlag));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP, Long.valueOf(setting.headImgTimestamp));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG, Byte.valueOf(setting.staticZplanFaceFlag));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_CLIP_PERCENT, Integer.valueOf(setting.zplanFaceClipPercent));
        String str4 = setting.uin;
        if (str4 != null) {
            str2 = str4;
        }
        hashMap.put("uin", str2);
        hashMap.put("avatar_type", Integer.valueOf(setting.bUsrType));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.INFO_REQUEST_TIME, Long.valueOf(setting.updateTimestamp));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, Byte.valueOf(setting.bFaceFlags));
        return hashMap;
    }

    private final Map<String, Object> i(AvatarInfoEntity setting) {
        HashMap hashMap = new HashMap();
        String str = setting.url;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put("url", str);
        String str3 = setting.zplanFaceBgUrl;
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_BG_URL, str3);
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG, Byte.valueOf(setting.apngFaceFlag));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP, Long.valueOf(setting.headImgTimestamp));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG, Byte.valueOf(setting.staticZplanFaceFlag));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_CLIP_PERCENT, Integer.valueOf(setting.zplanFaceClipPercent));
        String str4 = setting.key;
        if (str4 != null) {
            str2 = str4;
        }
        hashMap.put("uin", str2);
        hashMap.put("avatar_type", Integer.valueOf(setting.bUsrType));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.INFO_REQUEST_TIME, Long.valueOf(setting.updateTimestamp));
        hashMap.put(FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, Byte.valueOf(setting.bFaceFlags));
        return hashMap;
    }

    private final Map<String, Object> j(int type, String id5) {
        String faceKey = c.j(type, id5, 200);
        Intrinsics.checkNotNullExpressionValue(faceKey, "faceKey");
        return l(faceKey);
    }

    private final Map<String, Object> k(com.tencent.qqnt.avatar.meta.a bean) {
        String faceKey = c.j(bean.a(), bean.c(), 200);
        Intrinsics.checkNotNullExpressionValue(faceKey, "faceKey");
        return l(faceKey);
    }

    private final Map<String, Object>[] m(com.tencent.qqnt.avatar.meta.a avatarBean) {
        Map<String, Object> emptyMap;
        if (TextUtils.isEmpty(avatarBean.c())) {
            return new Map[0];
        }
        GroupUtil groupUtil = GroupUtil.f259599a;
        String c16 = avatarBean.c();
        Intrinsics.checkNotNull(c16);
        ArrayList<String> j3 = groupUtil.j(c16);
        QLog.i("CommonInfoRequestHandler", 2, "getNewGroupInfoFromCache avatarBean.id " + avatarBean.c() + " " + j3);
        if (j3.isEmpty()) {
            return new Map[0];
        }
        int size = j3.size();
        Map<String, Object>[] mapArr = new Map[size];
        for (int i3 = 0; i3 < size; i3++) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            mapArr[i3] = emptyMap;
        }
        int size2 = j3.size();
        for (int i16 = 0; i16 < size2; i16++) {
            RefreshMapping.f352936a.b(1, j3.get(i16), new com.tencent.qqnt.avatar.meta.refresh.bean.a(avatarBean.c(), avatarBean.a()));
            Map<String, Object> k3 = k(new com.tencent.qqnt.avatar.meta.a(0, 1, j3.get(i16), 140));
            if (k3.isEmpty()) {
                return new Map[0];
            }
            mapArr[i16] = k3;
        }
        return mapArr;
    }

    private final IQQAvatarHandlerService n() {
        try {
            return (IQQAvatarHandlerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQAvatarHandlerService.class, "");
        } catch (Exception e16) {
            QLog.e("CommonInfoRequestHandler", 1, "getQQAvatarHandlerService catch exception: ", e16);
            return null;
        }
    }

    @JvmStatic
    public static final void o(@NotNull List<QQHeadInfo> list) {
        String j3;
        Intrinsics.checkNotNullParameter(list, "list");
        QLog.i("CommonInfoRequestHandler", 4, "handleGetAvatarInfoCallback " + list.size());
        for (QQHeadInfo qQHeadInfo : list) {
            QLog.i("CommonInfoRequestHandler", 4, "handleGetAvatarInfoCallback info: " + qQHeadInfo);
            byte b16 = qQHeadInfo.dstUsrType;
            if (b16 == 11) {
                j3 = c.j(b16, qQHeadInfo.phoneNum, qQHeadInfo.idType);
            } else {
                j3 = c.j(b16, String.valueOf(qQHeadInfo.uin), qQHeadInfo.idType);
            }
            Set<g> remove = getAvatarInfoCallbackMap.remove(j3);
            if (remove != null) {
                Iterator<T> it = remove.iterator();
                while (it.hasNext()) {
                    ((g) it.next()).a(new Map[]{f259616a.g(qQHeadInfo)});
                }
            }
        }
    }

    @JvmStatic
    public static final void p(int dstUsrType, int idType, @NotNull List<? extends QQHeadDetails> list) {
        Integer num;
        Intrinsics.checkNotNullParameter(list, "list");
        QLog.i("CommonInfoRequestHandler", 4, "handleNoChangeAvatarInfoCallback " + list.size());
        for (QQHeadDetails qQHeadDetails : list) {
            QLog.i("CommonInfoRequestHandler", 4, "handleNoChangeAvatarInfoCallback detail: " + qQHeadDetails);
            String faceKey = c.j(dstUsrType, qQHeadDetails.uinOrMobile, idType);
            Set<g> remove = getAvatarInfoCallbackMap.remove(faceKey);
            if (remove != null) {
                num = Integer.valueOf(remove.size());
            } else {
                num = null;
            }
            QLog.i("CommonInfoRequestHandler", 4, "handleNoChangeAvatarInfoCallback handle[" + faceKey + "] cb[" + num + "] = " + remove);
            if (remove != null) {
                for (g gVar : remove) {
                    a aVar = f259616a;
                    Intrinsics.checkNotNullExpressionValue(faceKey, "faceKey");
                    gVar.a(new Map[]{aVar.l(faceKey)});
                }
            }
        }
    }

    @WorkerThread
    private final void q(com.tencent.qqnt.avatar.meta.a bean, boolean skipMemory, g callback) {
        Map<String, Object> emptyMap;
        boolean z16;
        if (!skipMemory) {
            Map<String, Object> k3 = k(bean);
            if (!k3.isEmpty()) {
                callback.a(new Map[]{k3});
                return;
            }
        }
        Object obj = bean.g().get(FaceConstant.ProAvatarBeanKeys.USE_LOCAL_AVATAR_INFO);
        if (obj instanceof Setting) {
            Setting setting = (Setting) obj;
            String str = setting.url;
            Intrinsics.checkNotNullExpressionValue(str, "setting.url");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                callback.a(new Map[]{h(setting)});
                return;
            }
        }
        if (1 != MobileQQ.sProcessId) {
            QLog.e("CommonInfoRequestHandler", 1, "realGetAvatarInfo from non MAIN Process");
            return;
        }
        QLog.d("CommonInfoRequestHandler", 4, "realGetAvatarInfo get from server " + bean.c() + " " + skipMemory);
        IQQAvatarHandlerService n3 = n();
        if (n3 == null) {
            return;
        }
        int a16 = bean.a();
        if (a16 != 1) {
            if (a16 != 4) {
                if (a16 != 11) {
                    if (a16 != 16) {
                        if (a16 != 32) {
                            if (a16 != 113) {
                                if (a16 != 115) {
                                    QLog.e("CommonInfoRequestHandler", 1, "realGetAvatarInfo error avatarType: " + bean.a() + " " + bean.c() + ".");
                                    emptyMap = MapsKt__MapsKt.emptyMap();
                                    callback.a(new Map[]{emptyMap});
                                } else {
                                    n3.getCustomHead(bean.c());
                                }
                            }
                        } else {
                            n3.getStrangerHead(bean.c(), 200, (byte) 1, (byte) 0);
                        }
                    } else {
                        n3.getQCallHead(bean.c(), 200, (byte) 1, (byte) 0);
                    }
                } else {
                    n3.getMobileQQHead(bean.c());
                }
            }
            n3.getTroopHead(bean.c());
        } else {
            n3.getCustomHead(bean.c());
        }
        String faceKey = c.j(bean.a(), bean.c(), 200);
        Intrinsics.checkNotNullExpressionValue(faceKey, "faceKey");
        e(faceKey, callback);
    }

    private final synchronized void r(com.tencent.qqnt.avatar.meta.a bean, g cb5) {
        String j3 = c.j(bean.a(), bean.c(), 200);
        ConcurrentHashMap<String, Set<g>> concurrentHashMap = getAvatarInfoCallbackMap;
        Set<g> set = concurrentHashMap.get(j3);
        if (set == null) {
            return;
        }
        set.remove(cb5);
        if (set.isEmpty()) {
            concurrentHashMap.remove(j3);
        }
    }

    private final Map<String, Object>[] s(com.tencent.qqnt.avatar.meta.a avatarBean) {
        boolean z16;
        for (com.tencent.mobileqq.proavatar.b bVar : com.tencent.mobileqq.proavatar.d.f259556a.a()) {
            if (bVar.b(avatarBean)) {
                return bVar.a(avatarBean);
            }
        }
        if (TextUtils.isEmpty(avatarBean.c())) {
            return new Map[0];
        }
        Object obj = avatarBean.g().get(FaceConstant.ProAvatarBeanKeys.USE_LOCAL_AVATAR_INFO);
        if (obj instanceof Setting) {
            Setting setting = (Setting) obj;
            String str = setting.url;
            Intrinsics.checkNotNullExpressionValue(str, "setting.url");
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return new Map[]{h(setting)};
            }
        }
        int a16 = avatarBean.a();
        if (a16 != 4 && a16 != 113) {
            return new Map[]{k(avatarBean)};
        }
        GroupUtil groupUtil = GroupUtil.f259599a;
        String c16 = avatarBean.c();
        Intrinsics.checkNotNull(c16);
        if (groupUtil.l(c16)) {
            return new Map[]{j(4, avatarBean.c())};
        }
        return m(avatarBean);
    }

    @Override // com.tencent.qqnt.avatar.meta.info.d
    public boolean a(@NotNull com.tencent.qqnt.avatar.meta.a infoAvatarBean, long lastCheckTime) {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, infoAvatarBean, Long.valueOf(lastCheckTime))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(infoAvatarBean, "infoAvatarBean");
        int a16 = infoAvatarBean.a();
        if (a16 != 1) {
            if ((a16 != 4 && a16 != 113) || (c16 = infoAvatarBean.c()) == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            GroupUtil groupUtil = GroupUtil.f259599a;
            if (!groupUtil.l(c16) || currentTimeMillis <= lastCheckTime || currentTimeMillis - lastCheckTime < com.tencent.qqnt.avatar.g.f352801a.f()) {
                z16 = false;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("CommonInfoRequestHandler", 4, "needCheckAvatarInfo " + infoAvatarBean.h() + "[" + z16 + "][" + groupUtil.l(c16) + "] time: " + lastCheckTime + ", " + currentTimeMillis + " ");
            }
            return z16;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 <= lastCheckTime || currentTimeMillis2 - lastCheckTime < com.tencent.qqnt.avatar.g.f352801a.f()) {
            z16 = false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CommonInfoRequestHandler", 4, "needCheckAvatarInfo " + infoAvatarBean.h() + "[" + z16 + "] time: " + lastCheckTime + ", " + currentTimeMillis2 + " ");
        }
        return z16;
    }

    @Override // com.tencent.qqnt.avatar.meta.info.d
    @NotNull
    public Map<String, Object>[] b(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map[]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarBean);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        return s(avatarBean);
    }

    @Override // com.tencent.qqnt.avatar.meta.info.d
    public void c(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean, boolean skipMemory, @NotNull g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, avatarBean, Boolean.valueOf(skipMemory), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        f(avatarBean, skipMemory, callback);
    }

    @Override // com.tencent.qqnt.avatar.meta.info.d
    public void d(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean, @NotNull g callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) avatarBean, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(callback, "callback");
        r(avatarBean, callback);
    }

    @NotNull
    public final Map<String, Object> l(@NotNull String faceKey) {
        Map<String, Object> emptyMap;
        String str;
        Map<String, Object> emptyMap2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this, (Object) faceKey);
        }
        Intrinsics.checkNotNullParameter(faceKey, "faceKey");
        if (1 != MobileQQ.sProcessId) {
            QLog.e("CommonInfoRequestHandler", 1, "getAvatarInfoFromCache from non MAIN Process");
            emptyMap2 = MapsKt__MapsKt.emptyMap();
            return emptyMap2;
        }
        String str2 = "null";
        if (ProAvatarComponentInit.c()) {
            AvatarInfoEntity a16 = ProAvatarComponentInit.a(faceKey, true);
            if (QLog.isDevelopLevel()) {
                if (a16 == null) {
                    str = "null";
                } else {
                    str = a16.url + "0  headImgTimesStamp:" + a16.headImgTimestamp;
                }
                QLog.d("CommonInfoRequestHandler", 4, "realGetAvatarInfo[" + faceKey + "] infoEntity: " + str);
            }
            if (a16 != null) {
                return i(a16);
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IQQAvatarDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026va, ProcessConstant.MAIN)");
        IQQAvatarDataService iQQAvatarDataService = (IQQAvatarDataService) runtimeService;
        Setting faceSetting = iQQAvatarDataService.getFaceSetting(faceKey);
        if (faceSetting != null && !TextUtils.isEmpty(faceSetting.url)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("CommonInfoRequestHandler", 4, "getAvatarInfoFromCache [" + faceSetting.uin + "] url: " + faceSetting.url);
            }
            return h(faceSetting);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.d("CommonInfoRequestHandler", 4, "realGetAvatarInfo[" + faceKey + "] startDB");
        }
        Setting settingFromDb = iQQAvatarDataService.getSettingFromDb(faceKey);
        if (QLog.isDevelopLevel()) {
            if (settingFromDb != null) {
                str2 = settingFromDb.url + settingFromDb.headImgTimestamp;
            }
            QLog.d("CommonInfoRequestHandler", 4, "realGetAvatarInfo[" + faceKey + "] settingFromDB = " + str2 + " cost(" + (System.currentTimeMillis() - currentTimeMillis) + ")");
        }
        if (settingFromDb == null || TextUtils.isEmpty(settingFromDb.url)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("CommonInfoRequestHandler", 2, "realGetAvatarInfo[" + faceKey + "] from db uin:" + settingFromDb.uin);
        }
        c.t(peekAppRuntime, settingFromDb);
        return h(settingFromDb);
    }
}
