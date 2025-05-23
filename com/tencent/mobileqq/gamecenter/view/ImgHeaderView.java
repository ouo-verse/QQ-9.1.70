package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.g;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import nl0.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ImgHeaderView extends RelativeLayout implements com.tencent.mobileqq.qqgamepub.view.a, c, HippyViewBase {
    private boolean C;
    private boolean D;
    private QQGameMsgInfo E;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f213453d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f213454e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f213455f;

    /* renamed from: h, reason: collision with root package name */
    private String f213456h;

    /* renamed from: i, reason: collision with root package name */
    private Button f213457i;

    /* renamed from: m, reason: collision with root package name */
    private HippyMap f213458m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f213460d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQGameMsgInfo f213461e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f213462f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f213463h;

        a(Context context, QQGameMsgInfo qQGameMsgInfo, int i3, String str) {
            this.f213460d = context;
            this.f213461e = qQGameMsgInfo;
            this.f213462f = i3;
            this.f213463h = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ImgHeaderView imgHeaderView = ImgHeaderView.this;
            Context context = this.f213460d;
            QQGameMsgInfo qQGameMsgInfo = this.f213461e;
            imgHeaderView.i(context, qQGameMsgInfo.paMsgid, qQGameMsgInfo.gameAppId, this.f213462f, qQGameMsgInfo, this.f213463h);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f213465d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQGameMsgInfo f213466e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f213467f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f213468h;

        b(Context context, QQGameMsgInfo qQGameMsgInfo, int i3, String str) {
            this.f213465d = context;
            this.f213466e = qQGameMsgInfo;
            this.f213467f = i3;
            this.f213468h = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ImgHeaderView imgHeaderView = ImgHeaderView.this;
            Context context = this.f213465d;
            QQGameMsgInfo qQGameMsgInfo = this.f213466e;
            imgHeaderView.i(context, qQGameMsgInfo.paMsgid, qQGameMsgInfo.gameAppId, this.f213467f, qQGameMsgInfo, this.f213468h);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ImgHeaderView(Context context) {
        super(context);
        this.C = false;
        this.D = false;
    }

    private void d(QQGameMsgInfo qQGameMsgInfo) {
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(qQGameMsgInfo.url);
        if (argumentsFromURL != null) {
            if (argumentsFromURL.containsKey(LinkReportConstant$BizKey.AUTO_DOWNLOAD)) {
                this.C = argumentsFromURL.get(LinkReportConstant$BizKey.AUTO_DOWNLOAD).equals("1");
            }
            if (argumentsFromURL.containsKey("autolaunch")) {
                this.D = argumentsFromURL.get("autolaunch").equals("1");
            }
        }
        if (this.C || this.D) {
            String y16 = GamePubAccountHelper.y(qQGameMsgInfo.gameAppId);
            if (TextUtils.isEmpty(y16)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(qQGameMsgInfo.gameAppId);
                ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getApkDownloadInfo(WadlProxyConsts.APP_CHANNEL_GAMECENTER, arrayList);
                return;
            }
            j(y16);
        }
    }

    private void f(Context context) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.f213456h);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Context context, String str, String str2, int i3, QQGameMsgInfo qQGameMsgInfo, String str3) {
        if (!((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(this.f213456h)) {
            f(context);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(2, str);
        hashMap.put(3, i3 + "");
        hashMap.put(4, "20");
        hashMap.put(24, str3);
        hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205019", str2, "76901", "1", "160", hashMap);
        try {
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(118, qQGameMsgInfo, i3);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void j(String str) {
        final String str2;
        if (PackageUtil.checkAppInstalled(BaseApplication.getContext(), str).equals("0")) {
            str2 = "\u4e0b\u8f7d\u6e38\u620f";
        } else {
            str2 = "\u542f\u52a8\u6e38\u620f";
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.view.ImgHeaderView.3
            @Override // java.lang.Runnable
            public void run() {
                ImgHeaderView.this.f213457i.setText(str2);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void b(QQGameMsgInfo qQGameMsgInfo, Context context, int i3, String str) {
        this.E = qQGameMsgInfo;
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).addListener(this);
        try {
            String str2 = qQGameMsgInfo.coverUrl;
            String str3 = qQGameMsgInfo.title;
            this.f213456h = qQGameMsgInfo.url;
            if (GamePubAccountHelper.C()) {
                this.f213453d = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.ebc, (ViewGroup) this, false);
            } else {
                this.f213453d = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.f167989of, (ViewGroup) this, false);
            }
            this.f213455f = (ImageView) this.f213453d.findViewById(R.id.dga);
            this.f213455f.setImageDrawable(URLDrawable.getDrawable(str2));
            TextView textView = (TextView) this.f213453d.findViewById(R.id.jfb);
            this.f213454e = textView;
            textView.setText(str3);
            ImageView imageView = (ImageView) this.f213453d.findViewById(R.id.enc);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = new ColorDrawable(0);
            obtain.mLoadingDrawable = new ColorDrawable(-1);
            URLDrawable drawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412124557_I8OGtzphYZ.png", obtain);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageDrawable(drawable);
            Button button = (Button) this.f213453d.findViewById(R.id.f164972bh4);
            this.f213457i = button;
            button.setBackgroundDrawable(com.tencent.mobileqq.qqgamepub.data.b.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
            this.f213457i.setOnClickListener(new a(context, qQGameMsgInfo, i3, str));
            this.f213453d.setOnClickListener(new b(context, qQGameMsgInfo, i3, str));
            addView(this.f213453d);
            d(qQGameMsgInfo);
        } catch (Throwable th5) {
            QLog.e("ImgHeaderView", 1, "init imgHeader failed e=" + th5.toString());
        }
    }

    public void e(HippyArray hippyArray) {
        QQGameMsgInfo qQGameMsgInfo = new QQGameMsgInfo();
        qQGameMsgInfo.coverUrl = hippyArray.getString(0);
        qQGameMsgInfo.title = hippyArray.getString(1);
        qQGameMsgInfo.url = hippyArray.getString(2);
        qQGameMsgInfo.contentText = hippyArray.getString(3);
        qQGameMsgInfo.limitText = hippyArray.getString(4);
        qQGameMsgInfo.dateTitle = hippyArray.getString(5);
        qQGameMsgInfo.paMsgid = hippyArray.getString(6);
        qQGameMsgInfo.gameAppId = hippyArray.getString(7);
        qQGameMsgInfo.frienduin = hippyArray.getString(8);
        qQGameMsgInfo.uniseq = hippyArray.getLong(9);
        qQGameMsgInfo.advId = hippyArray.getString(10);
        qQGameMsgInfo.triggerInfo = hippyArray.getString(11);
        b(qQGameMsgInfo, BaseApplication.getContext(), hippyArray.getInt(12), GamePubAccountHelper.s());
    }

    public void g() {
        b(((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getMsgInfoByHippyMap(this.f213458m), BaseApplication.getContext(), ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getMsgPosByHippyMap(this.f213458m), GamePubAccountHelper.s());
    }

    @Override // nl0.c
    public HashSet<String> getFilterCmds() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(WadlProxyConsts.CMD_GET_APK_DOWNLOAD_INFO);
        return hashSet;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public void h() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.view.ImgHeaderView.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QLog.d("ImgHeaderView", 1, "ImgHeaderView heightDp=" + g.b(ImgHeaderView.this.getHeight(), BaseApplication.getContext().getResources()));
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }, 500L);
    }

    @Override // nl0.c
    public void onCmdRsp(Intent intent, String str, long j3, JSONObject jSONObject) {
        QQGameMsgInfo qQGameMsgInfo;
        if (WadlProxyConsts.CMD_GET_APK_DOWNLOAD_INFO.equals(str)) {
            try {
                JSONObject jSONObject2 = jSONObject.optJSONArray("v_appd_down_load_info").getJSONObject(0);
                String optString = jSONObject2.optString("pkg_name");
                String optString2 = jSONObject2.optString("appid");
                if (!TextUtils.isEmpty(optString2) && (qQGameMsgInfo = this.E) != null && qQGameMsgInfo.gameAppId.equals(optString2)) {
                    GamePubAccountHelper.Q(this.E.gameAppId, optString);
                    j(optString);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onDestory() {
        try {
            ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).removeListener(this);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (getChildAt(0) != null) {
            getChildAt(0).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildAt(0) != null) {
            getChildAt(0).measure(i3, i16);
        }
    }

    public void setSrc(HippyMap hippyMap) {
        this.f213458m = hippyMap;
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onPause() {
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onResume() {
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}
