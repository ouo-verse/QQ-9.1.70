package com.tencent.mobileqq.qqlive.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0002J\u001e\u0010\r\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0002J\u001e\u0010\u000e\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0002J\u001e\u0010\u000f\u001a\u00020\u000b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0002J&\u0010\u0012\u001a\u00020\u00022\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J \u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0016JO\u0010\u001a\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0018\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/qqlive/webview/b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "nameSpace", "", "u", "url", "method", "t", "", "paramsMap", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "v", HippyTKDListViewAdapter.X, "map", "key", ReportConstant.COSTREPORT_PREFIX, "y", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", PushClientConstants.TAG_PKG_NAME, "", "args", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "d", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "Lcom/tencent/now/app/music/model/manager/MusicPlayMgr$b;", "e", "Lcom/tencent/now/app/music/model/manager/MusicPlayMgr$b;", "musicChangeListener", "<init>", "()V", "f", "a", "qq-live-accompany-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MusicPlayMgr.b musicChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/webview/b$a;", "", "", "METHOD_ADD_MUSIC", "Ljava/lang/String;", "METHOD_DELETE_MUSIC", "METHOD_JUMP_2_ROOM", "METHOD_ON_CUT_SONG", "QQ_LIVE_ACCOMPANY_JS_PLUGIN_NAME_SPACE", "TAG", "<init>", "()V", "qq-live-accompany-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.webview.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18368);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.musicChangeListener = new MusicPlayMgr.b() { // from class: com.tencent.mobileqq.qqlive.webview.a
            @Override // com.tencent.now.app.music.model.manager.MusicPlayMgr.b
            public final void a(MusicItem musicItem) {
                b.w(b.this, musicItem);
            }
        };
    }

    private final void q(Map<String, String> paramsMap) {
        String s16 = s(paramsMap, "musicItem");
        String s17 = s(paramsMap, "callback");
        MusicItem parse = MusicItem.parse(s16, s17);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(music, callbackId)");
        if (!com.tencent.falco.base.downloader.utils.a.a()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("result", new JSONObject());
            callJs(s17, jSONObject.toString());
            return;
        }
        MusicPlayMgr.o().f(parse);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("code", 0);
        JSONObject jSONObject3 = new JSONObject();
        Integer valueOf = Integer.valueOf(parse.songId);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(musicItem.songId)");
        jSONObject2.put("result", jSONObject3.put("song_id", valueOf.intValue()));
        callJs(s17, jSONObject2.toString());
    }

    private final void r(Map<String, String> paramsMap) {
        MusicPlayMgr.o().k(s(paramsMap, IOnlineStatusService.SONG_ID));
    }

    private final String s(Map<String, String> map, String key) {
        String str = map.get(key);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    private final boolean t(String url, String method) {
        try {
            Map<String, String> y16 = y(url);
            this.aegisLog.i("QQLiveAccompanyJsPlugin", "[handleAccompanyJs], paramsMap:" + y16);
            if (method != null) {
                switch (method.hashCode()) {
                    case -1830814824:
                        if (!method.equals("onCutSong")) {
                            break;
                        } else {
                            x(y16);
                            break;
                        }
                    case -1252408828:
                        if (!method.equals("addMusic")) {
                            break;
                        } else {
                            q(y16);
                            break;
                        }
                    case -1138406598:
                        if (!method.equals("deleteMusic")) {
                            break;
                        } else {
                            r(y16);
                            break;
                        }
                    case 642581695:
                        if (!method.equals("jump2Room")) {
                            break;
                        } else {
                            v(y16);
                            break;
                        }
                }
                return true;
            }
            this.aegisLog.e("QQLiveAccompanyJsPlugin", "unknown method:" + method);
            return true;
        } catch (Exception e16) {
            this.aegisLog.a("QQLiveAccompanyJsPlugin", "[handleAccompanyJs] method:" + method + ", e:" + e16.getMessage());
            return true;
        }
    }

    private final boolean u(String nameSpace) {
        boolean equals;
        equals = StringsKt__StringsJVMKt.equals(getNameSpace(), nameSpace, true);
        return equals;
    }

    private final void v(Map<String, String> paramsMap) {
        SimpleEventBus simpleEventBus;
        LiveWebDialogEvent liveWebDialogEvent;
        String str;
        if (!com.tencent.falco.base.downloader.utils.a.a()) {
            UIUtil.g("\u7f51\u7edc\u5f02\u5e38", false);
            return;
        }
        String s16 = s(paramsMap, "currentMusic");
        String s17 = s(paramsMap, "musicList");
        try {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray(s17);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    MusicItem musicItem = MusicItem.parse(jSONArray.getJSONObject(i3));
                    if (!musicItem.isEmpty()) {
                        Intrinsics.checkNotNullExpressionValue(musicItem, "musicItem");
                        arrayList.add(musicItem);
                    }
                }
                JSONObject jSONObject = new JSONObject(s16);
                if (jSONObject.has("song_id")) {
                    str = jSONObject.getString("song_id");
                } else {
                    str = null;
                }
                this.aegisLog.i("QQLiveAccompanyJsPlugin", "playList.size():" + arrayList.size() + ", currentSong:" + str);
                if (TextUtils.isEmpty(str)) {
                    if (arrayList.size() > 0) {
                        MusicPlayMgr.o().B(arrayList, 0);
                    }
                } else {
                    int size = arrayList.size();
                    int i16 = 0;
                    while (true) {
                        if (i16 < size) {
                            if (Intrinsics.areEqual(str, ((MusicItem) arrayList.get(i16)).songId)) {
                                break;
                            } else {
                                i16++;
                            }
                        } else {
                            i16 = -1;
                            break;
                        }
                    }
                    this.aegisLog.i("QQLiveAccompanyJsPlugin", "playList.size():" + arrayList.size() + ", startIndex:" + i16);
                    if (arrayList.size() > 0 && i16 >= 0) {
                        MusicPlayMgr.o().B(arrayList, i16);
                    }
                }
                simpleEventBus = SimpleEventBus.getInstance();
                liveWebDialogEvent = new LiveWebDialogEvent("hide", "", 0);
            } catch (Exception e16) {
                this.aegisLog.a("QQLiveAccompanyJsPlugin", "jump2Room error, e:" + e16);
                simpleEventBus = SimpleEventBus.getInstance();
                liveWebDialogEvent = new LiveWebDialogEvent("hide", "", 0);
            }
            simpleEventBus.dispatchEvent(liveWebDialogEvent);
        } catch (Throwable th5) {
            SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent("hide", "", 0));
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(b this$0, MusicItem musicItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (musicItem != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("callback", "_getCurrentMusic");
            this$0.x(hashMap);
        }
    }

    private final void x(Map<String, String> paramsMap) {
        if (MusicPlayMgr.o().n() == null) {
            this.aegisLog.e("QQLiveAccompanyJsPlugin", "onCutSong, currentPlaySongItem is null.");
            return;
        }
        String s16 = s(paramsMap, "callback");
        String str = MusicPlayMgr.o().n().songId;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            Integer valueOf = Integer.valueOf(str);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(songId)");
            jSONObject2.put(IOnlineStatusService.SONG_ID, valueOf.intValue());
        }
        jSONObject.put("result", jSONObject2);
        callJs(s16, jSONObject.toString());
    }

    private final Map<String, String> y(String url) {
        HashMap hashMap = new HashMap();
        if (url != null) {
            Uri parse = Uri.parse(url);
            for (String key : parse.getQueryParameterNames()) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                hashMap.put(key, parse.getQueryParameter(key));
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "music";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, listener, url, pkgName, method, args)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(args, "args");
        this.aegisLog.i("QQLiveAccompanyJsPlugin", "url:" + url + ", pkgName:" + pkgName + ", method:" + method);
        if (u(pkgName)) {
            return t(url, method);
        }
        return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onCreate();
            MusicPlayMgr.o().F(this.musicChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        MusicPlayMgr.o().Q();
        this.musicChangeListener = null;
    }
}
