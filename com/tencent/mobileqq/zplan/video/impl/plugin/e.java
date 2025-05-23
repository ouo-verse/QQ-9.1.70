package com.tencent.mobileqq.zplan.video.impl.plugin;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.mobileqq.zootopia.ue.b;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.UpdateFrom;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoVidInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoVodInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.luabridge.LuaArgument;
import com.tencent.zplan.luabridge.LuaBasePlugin;
import com.tencent.zplan.luabridge.LuaEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/impl/plugin/e;", "Lcom/tencent/zplan/luabridge/LuaBasePlugin;", "", "eventData", "", h.F, "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "g", "Lcom/tencent/zplan/luabridge/LuaArgument;", "argument", "handleAddMediaComponent", "handleRemoveMediaComponent", "handleQueryCurrentMediaInfo", "handleOpenMediaList", "handleCloseMediaComponent", "handlePostSmallHomeEvent", "handleOwnerSwitchVid", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "viewManager", "<init>", "(Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e extends LuaBasePlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager viewManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/video/impl/plugin/e$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<VideoMediaInfo> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoPlayInfo f335902d;

        b(VideoPlayInfo videoPlayInfo) {
            this.f335902d = videoPlayInfo;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(VideoMediaInfo result) {
            Intrinsics.checkNotNullParameter(result, "result");
            ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).B0(UpdateFrom.SWITCH_ON, this.f335902d.getComponentId(), result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanTXVideoLuaPlugin", 1, "handleOwnerSwitchVid failed :: error == " + error + " , message == " + message);
        }
    }

    public e(UEActivityViewManager viewManager) {
        Intrinsics.checkNotNullParameter(viewManager, "viewManager");
        this.viewManager = viewManager;
    }

    private final void d() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.video.impl.plugin.d
            @Override // java.lang.Runnable
            public final void run() {
                e.e(e.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewManager.n();
    }

    private final boolean g(Activity activity) {
        try {
            int i3 = activity.getResources().getConfiguration().orientation;
            QLog.d("ZPlanTXVideoLuaPlugin", 1, "activity.configuration " + i3);
            return i3 == 2;
        } catch (Exception e16) {
            QLog.e("ZPlanTXVideoLuaPlugin", 1, "configuration error ", e16);
            return false;
        }
    }

    private final void h(String eventData) {
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "preloadWebView  == " + eventData);
        try {
            final VideoPlayInfo b16 = VideoPlayInfo.INSTANCE.b(new JSONObject(eventData));
            final String cidUrl = ((zk3.a) vb3.a.f441346a.b(zk3.a.class)).a0().getCidUrl();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.video.impl.plugin.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.i(cidUrl, b16, this);
                }
            });
        } catch (Exception e16) {
            QLog.e("ZPlanTXVideoLuaPlugin", 1, "eventData => ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String baseUrl, VideoPlayInfo playInfo, e this$0) {
        Intrinsics.checkNotNullParameter(baseUrl, "$baseUrl");
        Intrinsics.checkNotNullParameter(playInfo, "$playInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewManager.y(com.tencent.mobileqq.zplan.video.api.bean.a.f335855a.a(baseUrl, null, playInfo, null, this$0.g(this$0.viewManager.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String()), true));
    }

    @LuaEvent("L2N_AddMediaComponent")
    public final String handleAddMediaComponent(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "ZPlanTXVideoLuaPlugin :: L2N_AddMediaComponent == " + argument.getF440574c());
        JSONObject optJSONObject = new JSONObject(argument.getF440574c()).optJSONObject("PlayInfo");
        if (optJSONObject == null) {
            return argument.fail();
        }
        ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).I0(VideoPlayInfo.INSTANCE.b(optJSONObject));
        return argument.ok();
    }

    @LuaEvent("L2N_CloseMediaComponent")
    public final String handleCloseMediaComponent(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "handleCloseMediaComponent  == " + argument.getF440574c());
        JSONObject optJSONObject = new JSONObject(argument.getF440574c()).optJSONObject("PlayInfo");
        if (optJSONObject == null) {
            return argument.fail();
        }
        ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).L(VideoPlayInfo.INSTANCE.b(optJSONObject));
        return argument.ok();
    }

    @LuaEvent("L2N_OpenMediaList")
    public final String handleOpenMediaList(LuaArgument argument) {
        String vidUrl;
        TXVideoInfo e16;
        VideoMediaInfo mediaInfo;
        VideoVodInfo vodInfo;
        VideoVidInfo currentVidInfo;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "handleOpenMediaList  == " + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        JSONObject optJSONObject = jSONObject.optJSONObject("PlayInfo");
        if (optJSONObject == null) {
            return argument.fail();
        }
        final VideoPlayInfo b16 = VideoPlayInfo.INSTANCE.b(optJSONObject);
        int optInt = jSONObject.optInt("ListType", 1);
        final int optInt2 = jSONObject.optInt("MediaType", 0);
        if (optInt == 1) {
            vidUrl = ((zk3.a) vb3.a.f441346a.b(zk3.a.class)).a0().getCidUrl();
        } else {
            vidUrl = ((zk3.a) vb3.a.f441346a.b(zk3.a.class)).a0().getVidUrl();
        }
        final String str = vidUrl;
        final String cid = (optInt == 1 || (e16 = ((zk3.a) vb3.a.f441346a.b(zk3.a.class)).J0().e(b16)) == null || (mediaInfo = e16.getMediaInfo()) == null || (vodInfo = mediaInfo.getVodInfo()) == null || (currentVidInfo = vodInfo.getCurrentVidInfo()) == null) ? null : currentVidInfo.getCid();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.video.impl.plugin.b
            @Override // java.lang.Runnable
            public final void run() {
                e.f(str, optInt2, b16, cid, this);
            }
        });
        return argument.ok();
    }

    @LuaEvent("L2N_OwnerSwitchVid")
    public final String handleOwnerSwitchVid(LuaArgument argument) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "L2N_OwnerSwitchVid  == " + argument.getF440574c());
        JSONObject optJSONObject = new JSONObject(argument.getF440574c()).optJSONObject("PlayInfo");
        if (optJSONObject == null) {
            return argument.fail();
        }
        VideoPlayInfo b16 = VideoPlayInfo.INSTANCE.b(optJSONObject);
        TXVideoInfo e16 = ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().e(b16);
        if (e16 == null) {
            return argument.fail();
        }
        bl3.a aVar = bl3.a.f28625a;
        VideoVidInfo currentVidInfo = e16.getMediaInfo().getVodInfo().getCurrentVidInfo();
        if (currentVidInfo == null || (str = currentVidInfo.getCid()) == null) {
            str = "";
        }
        VideoVidInfo currentVidInfo2 = e16.getMediaInfo().getVodInfo().getCurrentVidInfo();
        if (currentVidInfo2 == null || (str2 = currentVidInfo2.getVid()) == null) {
            str2 = "";
        }
        aVar.f(b16, str, str2, e16.getMediaInfo().getPlayType(), new b(b16));
        return argument.ok();
    }

    @LuaEvent("L2N_PostSmallHomeEvent")
    public final String handlePostSmallHomeEvent(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "L2N_PostSmallHomeEvent  == " + argument.getF440574c());
        JSONObject jSONObject = new JSONObject(argument.getF440574c());
        String optString = jSONObject.optString("eventType");
        if (optString == null) {
            return argument.fail();
        }
        String optString2 = jSONObject.optString("eventData");
        if (optString2 == null) {
            optString2 = "";
        }
        if (Intrinsics.areEqual(optString, "ClickTV")) {
            h(optString2);
        } else if (Intrinsics.areEqual(optString, "ExitTv")) {
            d();
        } else {
            QLog.e("ZPlanTXVideoLuaPlugin", 1, "unSupport eventType " + optString);
        }
        return argument.ok();
    }

    @LuaEvent("L2N_QueryCurrentMediaInfo")
    public final String handleQueryCurrentMediaInfo(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "ZPlanTXVideoLuaPlugin :: L2N_QueryCurrentMediaInfo , arg == " + argument.getF440574c());
        JSONObject optJSONObject = new JSONObject(argument.getF440574c()).optJSONObject("PlayInfo");
        if (optJSONObject == null) {
            return argument.fail();
        }
        VideoPlayInfo b16 = VideoPlayInfo.INSTANCE.b(optJSONObject);
        TXVideoInfo e16 = ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().e(b16);
        if (e16 == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("PlayInfo", optJSONObject);
            jSONObject.put("MediaInfo", new JSONObject());
            QLog.e("ZPlanTXVideoLuaPlugin", 1, "ZPlanTXVideoLuaPlugin :: L2N_QueryCurrentMediaInfo , can not find videoInfo, playInfo == " + b16);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("MediaInfo", jSONObject.toString());
            String jSONObject3 = jSONObject2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "resultJson.toString()");
            return argument.ok(jSONObject3);
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("MediaInfo", e16.g());
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "ZPlanTXVideoLuaPlugin :: L2N_QueryCurrentMediaInfo , result == " + jSONObject4);
        String jSONObject5 = jSONObject4.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject5, "resultJson.toString()");
        return argument.ok(jSONObject5);
    }

    @LuaEvent("L2N_RemoveMediaComponent")
    public final String handleRemoveMediaComponent(LuaArgument argument) {
        Intrinsics.checkNotNullParameter(argument, "argument");
        QLog.i("ZPlanTXVideoLuaPlugin", 1, "ZPlanTXVideoLuaPlugin :: L2N_RemoveMediaComponent == " + argument.getF440574c());
        JSONObject optJSONObject = new JSONObject(argument.getF440574c()).optJSONObject("PlayInfo");
        if (optJSONObject == null) {
            return argument.fail();
        }
        ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).A(VideoPlayInfo.INSTANCE.b(optJSONObject));
        return argument.ok();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String baseUrl, int i3, VideoPlayInfo playInfo, String str, e this$0) {
        Intrinsics.checkNotNullParameter(baseUrl, "$baseUrl");
        Intrinsics.checkNotNullParameter(playInfo, "$playInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b.a.a(this$0.viewManager, com.tencent.mobileqq.zplan.video.api.bean.a.b(com.tencent.mobileqq.zplan.video.api.bean.a.f335855a, baseUrl, Integer.valueOf(i3), playInfo, str, this$0.g(this$0.viewManager.getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String()), false, 32, null), true, false, 4, null);
    }
}
