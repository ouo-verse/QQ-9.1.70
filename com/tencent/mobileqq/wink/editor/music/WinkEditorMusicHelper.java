package com.tencent.mobileqq.wink.editor.music;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.cx;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicPanelData;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.request.QQWinkBatchGetMusicInfoRequest;
import com.tencent.mobileqq.wink.request.QQWinkCategoryTopMusicReq;
import com.tencent.mobileqq.wink.request.QQWinkGetMusicCollectionReq;
import com.tencent.mobileqq.wink.request.QQWinkModMusicCollectionReq;
import com.tencent.mobileqq.wink.request.QQWinkMusicCategoryReq;
import com.tencent.mobileqq.wink.request.QQWinkMusicStuckPointInfoReq;
import com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp;
import qqcircle.QQCircleSmartMatchMusic$GetMusicCollectionRsp;
import qqcircle.QQCircleSmartMatchMusic$ModMusicCollectionRsp;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$MusicStuckPointInfoRsp;
import qqcircle.QQCircleSmartMatchMusic$SmartMatchMusicRsp;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkEditorMusicHelper {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class MusicDownloadRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private AppRuntime f320663d;

        /* renamed from: e, reason: collision with root package name */
        private WinkEditorMusicInfo f320664e;

        /* renamed from: f, reason: collision with root package name */
        private String f320665f;

        /* renamed from: h, reason: collision with root package name */
        private String f320666h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<b> f320667i;

        public MusicDownloadRunnable(@NonNull AppRuntime appRuntime, @NonNull WinkEditorMusicInfo winkEditorMusicInfo, @NonNull String str, @NonNull String str2, b bVar) {
            this.f320663d = appRuntime;
            this.f320664e = winkEditorMusicInfo;
            this.f320665f = str;
            this.f320666h = str2;
            this.f320667i = new WeakReference<>(bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            WinkEditorMusicHelper.n(this.f320663d, this.f320664e, this.f320665f, this.f320666h, this.f320667i.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f320668d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkEditorMusicInfo f320669e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f320670f;

        a(b bVar, WinkEditorMusicInfo winkEditorMusicInfo, String str) {
            this.f320668d = bVar;
            this.f320669e = winkEditorMusicInfo;
            this.f320670f = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16;
            if (netResp != null && netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ms.a.f("WinkEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + z16);
            b bVar = this.f320668d;
            if (bVar != null) {
                bVar.a(this.f320669e, z16, this.f320670f);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            b bVar = this.f320668d;
            if (bVar != null) {
                bVar.b(this.f320669e, (int) ((((float) j3) * 100.0f) / ((float) j16)));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void a(@NonNull WinkEditorMusicInfo winkEditorMusicInfo, boolean z16, @NonNull String str);

        void b(@NonNull WinkEditorMusicInfo winkEditorMusicInfo, int i3);
    }

    public static void A(WinkEditorMusicInfo winkEditorMusicInfo, boolean z16, final VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$ModMusicCollectionRsp> onVSRspCallBack) {
        int i3;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        w93.e.f445096a.j(new QQWinkModMusicCollectionReq(winkEditorMusicInfo.p(), i3), new Function5() { // from class: com.tencent.mobileqq.wink.editor.music.e
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit r16;
                r16 = WinkEditorMusicHelper.r(VSDispatchObserver.OnVSRspCallBack.this, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (QQCircleSmartMatchMusic$ModMusicCollectionRsp) obj5);
                return r16;
            }
        });
    }

    public static void B(final VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$GetMusicCollectionRsp> onVSRspCallBack) {
        w53.b.a("WinkEditorMusicHelper", "requestCollectionMusicList");
        w93.e.f445096a.j(new QQWinkGetMusicCollectionReq(), new Function5() { // from class: com.tencent.mobileqq.wink.editor.music.d
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit s16;
                s16 = WinkEditorMusicHelper.s(VSDispatchObserver.OnVSRspCallBack.this, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (QQCircleSmartMatchMusic$GetMusicCollectionRsp) obj5);
                return s16;
            }
        });
    }

    public static void C(@NonNull ArrayList<String> arrayList, VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$MusicInfoRsp> onVSRspCallBack) {
        D(arrayList, onVSRspCallBack);
    }

    public static void D(@NonNull ArrayList<String> arrayList, final VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$MusicInfoRsp> onVSRspCallBack) {
        w53.b.a("WinkEditorMusicHelper", "requestDetailedMusicInfo");
        w93.e.f445096a.j(new QQWinkBatchGetMusicInfoRequest(arrayList), new Function5() { // from class: com.tencent.mobileqq.wink.editor.music.f
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit t16;
                t16 = WinkEditorMusicHelper.t(VSDispatchObserver.OnVSRspCallBack.this, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (QQCircleSmartMatchMusic$MusicInfoRsp) obj5);
                return t16;
            }
        });
    }

    public static void E(VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$MusicInfoRsp> onVSRspCallBack) {
        D(MusicSourceViewModel.INSTANCE.a(), onVSRspCallBack);
    }

    public static void F(final VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp> onVSRspCallBack) {
        w53.b.a("WinkEditorMusicHelper", "requestMusicCategoryList");
        w93.e.f445096a.j(new QQWinkMusicCategoryReq(), new Function5() { // from class: com.tencent.mobileqq.wink.editor.music.g
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit u16;
                u16 = WinkEditorMusicHelper.u(VSDispatchObserver.OnVSRspCallBack.this, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp) obj5);
                return u16;
            }
        });
    }

    public static void G(List<String> list, final VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$MusicStuckPointInfoRsp> onVSRspCallBack) {
        w53.b.a("WinkEditorMusicHelper", "requestMusicStuckPointInfo");
        w93.e.f445096a.j(new QQWinkMusicStuckPointInfoReq(list), new Function5() { // from class: com.tencent.mobileqq.wink.editor.music.h
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit v3;
                v3 = WinkEditorMusicHelper.v(VSDispatchObserver.OnVSRspCallBack.this, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (QQCircleSmartMatchMusic$MusicStuckPointInfoRsp) obj5);
                return v3;
            }
        });
    }

    public static void H(@NonNull List<byte[]> list, @Nullable SosoLocation sosoLocation, @QQWinkSmartMatchMusicReq.VideoType int i3, @Nullable LocalMediaInfo localMediaInfo, @QQWinkSmartMatchMusicReq.CameraType int i16, String str, @QQWinkSmartMatchMusicReq.DataType int i17, boolean z16, @Nullable final VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$SmartMatchMusicRsp> onVSRspCallBack) {
        int i18;
        w53.b.a("WinkEditorMusicHelper", "requestRecommendMusicList");
        String str2 = "";
        try {
            WinkContext.Companion companion = WinkContext.INSTANCE;
            if (companion.l()) {
                str2 = companion.d().getDtParams().c();
            }
        } catch (Exception e16) {
            ms.a.c("WinkEditorMusicHelper", "requestRecommendMusicList sessionId initialized fail\uff1a" + e16.getMessage());
        }
        String str3 = str2;
        WinkContext.Companion companion2 = WinkContext.INSTANCE;
        if (companion2.l() && companion2.d().u("QCIRCLE")) {
            IQCircleABTestApi iQCircleABTestApi = (IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class);
            iQCircleABTestApi.reportExpExposure("exp_fabuqiyinyuetuijian_v3");
            if (iQCircleABTestApi.isExperiment("exp_fabuqiyinyuetuijian_v3")) {
                i18 = 1;
            } else {
                i18 = 0;
            }
        } else {
            i18 = 2;
        }
        int i19 = i18;
        w53.b.f("WinkEditorMusicHelper", "[requestRecommendMusicList] musicScene=" + i19);
        w93.e.f445096a.j(new QQWinkSmartMatchMusicReq(list, sosoLocation, i3, i16, localMediaInfo, str, i17, str3, i19, z16), new Function5() { // from class: com.tencent.mobileqq.wink.editor.music.i
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit w3;
                w3 = WinkEditorMusicHelper.w(VSDispatchObserver.OnVSRspCallBack.this, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (QQCircleSmartMatchMusic$SmartMatchMusicRsp) obj5);
                return w3;
            }
        });
    }

    public static void I(WinkEditorMusicInfo winkEditorMusicInfo, b bVar) {
        w53.b.a("WinkEditorMusicHelper", "startCacheDownloadMusic");
        if (winkEditorMusicInfo != null && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            String o16 = o(winkEditorMusicInfo);
            if (p(o16)) {
                return;
            }
            if (winkEditorMusicInfo.f321260f == 1) {
                ms.a.f("WinkEditorMusicHelper", "[startCacheDownloadMusic], editorMusicInfo=" + winkEditorMusicInfo + ", downloadStatus=STATUS_DOWNLOADING");
                return;
            }
            winkEditorMusicInfo.f321260f = 1;
            ThreadManagerV2.excute(new MusicDownloadRunnable(MobileQQ.sMobileQQ.peekAppRuntime(), winkEditorMusicInfo, winkEditorMusicInfo.t(), o16, bVar), 128, null, true);
        }
    }

    public static void J(@NonNull Context context, Intent intent, Boolean bool) {
        if (intent == null) {
            return;
        }
        ms.a.f("WinkEditorMusicHelper", "[startMusicWebView]");
        String m3 = m(MusicPanelData.INSTANCE.a(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_editor_music_config", "")).getMusicLibUrl(), intent, bool, cx.INSTANCE.b());
        w53.b.a("WinkEditorMusicHelper", "startMusicWebView, url = " + m3);
        intent.putExtra("url", m3);
        z93.b e16 = Wink.INSTANCE.e();
        if (e16 != null) {
            e16.c(context, intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.f155080vw, R.anim.f155082vy);
                return;
            }
            return;
        }
        w53.b.c("WinkEditorMusicHelper", "[startMusicWebView] invalid wink navigate api");
    }

    public static void K(@NonNull Context context, Intent intent, Boolean bool) {
        if (intent == null) {
            return;
        }
        ms.a.f("WinkEditorMusicHelper", "[startMusicWebView]");
        String m3 = m(MusicPanelData.INSTANCE.a(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_editor_music_config", "")).getMusicSearchUrl(), intent, bool, cx.INSTANCE.a());
        w53.b.a("WinkEditorMusicHelper", "startMusicWebView, url = " + m3);
        intent.putExtra("url", m3);
        z93.b e16 = Wink.INSTANCE.e();
        if (e16 != null) {
            e16.c(context, intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.f155080vw, R.anim.f155082vy);
                return;
            }
            return;
        }
        w53.b.c("WinkEditorMusicHelper", "[startMusicWebView] invalid wink navigate api");
    }

    public static boolean L(@NonNull VsMusicItemInfo vsMusicItemInfo) {
        if (!TextUtils.isEmpty(vsMusicItemInfo.mSongMid) && !TextUtils.isEmpty(vsMusicItemInfo.mMusicName) && !TextUtils.isEmpty(vsMusicItemInfo.mUrl) && vsMusicItemInfo.musicDuration != 0) {
            return true;
        }
        return false;
    }

    private static String h(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        }
        return "";
    }

    private static void i(StringBuilder sb5, String str, String str2) {
        if (sb5 == null) {
            return;
        }
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(str);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(str2);
    }

    public static List<WinkEditorMusicInfo> j(@Nullable List<VsMusicItemInfo> list, String str, String str2) {
        ms.a.f("WinkEditorMusicHelper", "[assembleEditorMusicInfoList]");
        if (list == null) {
            return new LinkedList();
        }
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            VsMusicItemInfo vsMusicItemInfo = list.get(i3);
            if (vsMusicItemInfo != null) {
                linkedList.add(new WinkEditorMusicInfo(vsMusicItemInfo, false, 2, true, i3 + 1, str, str2));
            }
        }
        return linkedList;
    }

    public static VsMusicItemInfo k(JSONObject jSONObject) {
        VsMusicItemInfo vsMusicItemInfo = new VsMusicItemInfo();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("albumInfo");
            JSONObject jSONObject3 = jSONObject.getJSONObject("singerInfo");
            JSONObject jSONObject4 = jSONObject.getJSONObject("songInfo");
            JSONObject jSONObject5 = jSONObject.getJSONObject("confInfo");
            JSONObject jSONObject6 = jSONObject.getJSONObject("lyricInfo");
            JSONObject jSONObject7 = jSONObject.getJSONObject("confInfo");
            JSONObject jSONObject8 = jSONObject.getJSONObject("foreignlyric");
            vsMusicItemInfo.mType = 5;
            vsMusicItemInfo.mMusicName = jSONObject4.optString("name");
            vsMusicItemInfo.mSingername = jSONObject3.optString("name");
            vsMusicItemInfo.mItemId = jSONObject4.optInt("ID");
            vsMusicItemInfo.mAlbumUrl = jSONObject2.optString("thumbURL");
            vsMusicItemInfo.mSongMid = jSONObject4.optString("MID");
            boolean z16 = true;
            if (jSONObject4.optInt("Copyright") != 1) {
                z16 = false;
            }
            vsMusicItemInfo.mHasCopyright = z16;
            vsMusicItemInfo.f320654h = 2;
            vsMusicItemInfo.mUrl = jSONObject4.optString("PlayUrl");
            vsMusicItemInfo.musicDuration = jSONObject4.optInt("IPlayTime") * 1000;
            vsMusicItemInfo.musicStart = jSONObject5.optInt("startPos");
            vsMusicItemInfo.f320652e = jSONObject6.optString("strLyric");
            vsMusicItemInfo.musicEnd = 0;
            vsMusicItemInfo.f320651d = jSONObject6.optString("strFormat");
            vsMusicItemInfo.f320655i = jSONObject7.optInt("isCollected");
            vsMusicItemInfo.f320656m = jSONObject8.optString("strLyric");
            vsMusicItemInfo.C = jSONObject8.optString("strFormat");
        } catch (JSONException e16) {
            ms.a.d("WinkEditorMusicHelper", "[convertJsonToVsMusicInfo], error=", e16);
        }
        return vsMusicItemInfo;
    }

    @NonNull
    public static List<VsMusicItemInfo> l(@Nullable List<QQCircleSmartMatchMusic$MusicInfo> list) {
        if (list == null) {
            ms.a.f("WinkEditorMusicHelper", "[convertToMusicItemList] stMusicList is null");
            return new LinkedList();
        }
        ms.a.f("WinkEditorMusicHelper", "[convertToMusicItemList] stMusicList.size=" + list.size());
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            QQCircleSmartMatchMusic$MusicInfo qQCircleSmartMatchMusic$MusicInfo = list.get(i3);
            if (qQCircleSmartMatchMusic$MusicInfo != null) {
                linkedList.add(new VsMusicItemInfo(qQCircleSmartMatchMusic$MusicInfo));
            }
        }
        return linkedList;
    }

    public static String m(String str, Intent intent, Boolean bool, int i3) {
        StringBuilder sb5 = new StringBuilder();
        if ("photo".equals(intent.getStringExtra("type"))) {
            str = h(str, "type", "photo");
        }
        sb5.append(str);
        i(sb5, "videoclipduration", String.valueOf(intent.getIntExtra("videoclipduration", 0)));
        i(sb5, "scene", String.valueOf(i3));
        i(sb5, "videofrom", intent.getStringExtra("videofrom"));
        if (bool.booleanValue()) {
            i(sb5, "type", "photo");
        }
        return sb5.toString();
    }

    public static void n(@NonNull AppRuntime appRuntime, @NonNull WinkEditorMusicInfo winkEditorMusicInfo, @NonNull String str, @NonNull String str2, @Nullable b bVar) {
        ms.a.f("WinkEditorMusicHelper", "[downloadMusic], url=" + str + ", localPath=" + str2);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str2;
        httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
        httpNetReq.mExcuteTimeLimit = 30000L;
        httpNetReq.mCallback = new a(bVar, winkEditorMusicInfo, str2);
        try {
            ((IHttpEngineService) appRuntime.getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        } catch (Exception e16) {
            ms.a.c("WinkEditorMusicHelper", "[downloadMusic], error=" + e16);
        }
    }

    @NonNull
    public static String o(@Nullable WinkEditorMusicInfo winkEditorMusicInfo) {
        if (winkEditorMusicInfo != null && !winkEditorMusicInfo.y()) {
            return u53.a.f438362c + File.separator + winkEditorMusicInfo.p() + ".m4a";
        }
        return "";
    }

    public static boolean p(@Nullable String str) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            z16 = new File(str).exists();
        } else {
            z16 = false;
        }
        ms.a.f("WinkEditorMusicHelper", String.format("[isMusicLocalExists], isExist=%s,musicLocalPath=%s", Boolean.valueOf(z16), str));
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit q(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack, BaseRequest baseRequest, Boolean bool, Long l3, String str, QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp) {
        onVSRspCallBack.onReceive(baseRequest, bool.booleanValue(), l3.longValue(), str, qQCircleSmartMatchMusic$GetMusicCategoryTopListRsp);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit r(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack, BaseRequest baseRequest, Boolean bool, Long l3, String str, QQCircleSmartMatchMusic$ModMusicCollectionRsp qQCircleSmartMatchMusic$ModMusicCollectionRsp) {
        onVSRspCallBack.onReceive(baseRequest, bool.booleanValue(), l3.longValue(), str, qQCircleSmartMatchMusic$ModMusicCollectionRsp);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit s(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack, BaseRequest baseRequest, Boolean bool, Long l3, String str, QQCircleSmartMatchMusic$GetMusicCollectionRsp qQCircleSmartMatchMusic$GetMusicCollectionRsp) {
        onVSRspCallBack.onReceive(baseRequest, bool.booleanValue(), l3.longValue(), str, qQCircleSmartMatchMusic$GetMusicCollectionRsp);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit t(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack, BaseRequest baseRequest, Boolean bool, Long l3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        onVSRspCallBack.onReceive(baseRequest, bool.booleanValue(), l3.longValue(), str, qQCircleSmartMatchMusic$MusicInfoRsp);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit u(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack, BaseRequest baseRequest, Boolean bool, Long l3, String str, QQCircleSmartMatchMusic$GetMusicCategoryInfoRsp qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp) {
        onVSRspCallBack.onReceive(baseRequest, bool.booleanValue(), l3.longValue(), str, qQCircleSmartMatchMusic$GetMusicCategoryInfoRsp);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit v(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack, BaseRequest baseRequest, Boolean bool, Long l3, String str, QQCircleSmartMatchMusic$MusicStuckPointInfoRsp qQCircleSmartMatchMusic$MusicStuckPointInfoRsp) {
        onVSRspCallBack.onReceive(baseRequest, bool.booleanValue(), l3.longValue(), str, qQCircleSmartMatchMusic$MusicStuckPointInfoRsp);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit w(VSDispatchObserver.OnVSRspCallBack onVSRspCallBack, BaseRequest baseRequest, Boolean bool, Long l3, String str, QQCircleSmartMatchMusic$SmartMatchMusicRsp qQCircleSmartMatchMusic$SmartMatchMusicRsp) {
        onVSRspCallBack.onReceive(baseRequest, bool.booleanValue(), l3.longValue(), str, qQCircleSmartMatchMusic$SmartMatchMusicRsp);
        return Unit.INSTANCE;
    }

    public static List<WinkEditorMusicInfo> x(@Nullable List<WinkEditorMusicInfo> list, @Nullable List<WinkEditorMusicInfo> list2) {
        String str;
        w53.b.f("WinkEditorMusicHelper", "[mergeTongKuanEditorMusicInfoList]");
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        if (list2 != null && !list2.isEmpty() && list2.get(0) != null) {
            str = list2.get(0).p();
        } else {
            str = "";
        }
        if (list != null) {
            for (WinkEditorMusicInfo winkEditorMusicInfo : list) {
                if (!str.equals(winkEditorMusicInfo.p())) {
                    arrayList.add(winkEditorMusicInfo);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static VsMusicItemInfo y(@NonNull Intent intent) {
        ms.a.f("WinkEditorMusicHelper", "[parseMusicWebData]");
        String stringExtra = intent.getStringExtra("data");
        String stringExtra2 = intent.getStringExtra("event");
        ms.a.f("WinkEditorMusicHelper", "[parseMusicWebData], eventValue=" + stringExtra2);
        VsMusicItemInfo vsMusicItemInfo = null;
        if (!QQWinkConstants.JS_PLUGIN_EVENT_SELECT_MUSIC.equals(stringExtra2) && !QQWinkConstants.JS_PLUGIN_EVENT_CLIP_MUSIC.equals(stringExtra2) && !QQWinkConstants.JS_PLUGIN_EVENT_COLLECT_MUSIC.equals(stringExtra2)) {
            return null;
        }
        ms.a.f("WinkEditorMusicHelper", "[parseMusicWebData], dataValue=" + stringExtra);
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            vsMusicItemInfo = k(jSONObject);
            if (jSONObject.has(CacheTable.TABLE_NAME)) {
                intent.putExtra(CacheTable.TABLE_NAME, jSONObject.get(CacheTable.TABLE_NAME).toString());
            }
        } catch (Exception e16) {
            ms.a.d("WinkEditorMusicHelper", "[parseMusicWebData], error=", e16);
        }
        return vsMusicItemInfo;
    }

    public static void z(ax axVar, final VSDispatchObserver.OnVSRspCallBack<QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp> onVSRspCallBack) {
        if (axVar == null) {
            return;
        }
        w93.e.f445096a.j(new QQWinkCategoryTopMusicReq(axVar.f320783a), new Function5() { // from class: com.tencent.mobileqq.wink.editor.music.c
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit q16;
                q16 = WinkEditorMusicHelper.q(VSDispatchObserver.OnVSRspCallBack.this, (BaseRequest) obj, (Boolean) obj2, (Long) obj3, (String) obj4, (QQCircleSmartMatchMusic$GetMusicCategoryTopListRsp) obj5);
                return q16;
            }
        });
    }
}
