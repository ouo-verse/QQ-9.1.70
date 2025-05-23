package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class TextHeaderView extends RelativeLayout implements com.tencent.mobileqq.qqgamepub.view.a, HippyViewBase {
    private Button C;
    private ImageView D;
    private String E;
    private HippyMap F;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f213476d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f213477e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f213478f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f213479h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f213480i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f213481m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f213482d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQGameMsgInfo f213483e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f213484f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f213485h;

        a(Context context, QQGameMsgInfo qQGameMsgInfo, int i3, String str) {
            this.f213482d = context;
            this.f213483e = qQGameMsgInfo;
            this.f213484f = i3;
            this.f213485h = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(TextHeaderView.this.E)) {
                if (!((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(TextHeaderView.this.E)) {
                    Intent intent = new Intent(this.f213482d, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", TextHeaderView.this.E);
                    this.f213482d.startActivity(intent);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(2, this.f213483e.gameAppId);
                hashMap.put(3, this.f213484f + "");
                hashMap.put(4, "20");
                hashMap.put(24, this.f213485h);
                hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205019", this.f213483e.gameAppId, "76901", "1", "160", hashMap);
                try {
                    ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(118, this.f213483e, this.f213484f);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f213487d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQGameMsgInfo f213488e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f213489f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f213490h;

        b(Context context, QQGameMsgInfo qQGameMsgInfo, int i3, String str) {
            this.f213487d = context;
            this.f213488e = qQGameMsgInfo;
            this.f213489f = i3;
            this.f213490h = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!TextUtils.isEmpty(TextHeaderView.this.E)) {
                if (!((IQQGamePreDownloadService) QRoute.api(IQQGamePreDownloadService.class)).interceptJumpHippy(TextHeaderView.this.E)) {
                    Intent intent = new Intent(this.f213487d, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", TextHeaderView.this.E);
                    this.f213487d.startActivity(intent);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(2, this.f213488e.gameAppId);
                hashMap.put(3, this.f213489f + "");
                hashMap.put(4, "20");
                hashMap.put(24, this.f213490h);
                hl0.a.c(((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", "205019", this.f213488e.gameAppId, "76901", "1", "160", hashMap);
                try {
                    ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).publicAccountTianshuReport(118, this.f213488e, this.f213489f);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public TextHeaderView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void b(QQGameMsgInfo qQGameMsgInfo, Context context, int i3, String str) {
        try {
            this.E = qQGameMsgInfo.url;
            this.f213476d = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BaseAIOUtils.f(355.0f, getResources()), -1);
            layoutParams.addRule(14);
            this.D = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(293.0f, getResources()));
            layoutParams2.topMargin = BaseAIOUtils.f(46.0f, getResources());
            this.D.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f213476d.addView(this.D, layoutParams2);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(283.0f, getResources()));
            layoutParams3.topMargin = BaseAIOUtils.f(46.0f, getResources());
            relativeLayout.setPadding(BaseAIOUtils.f(20.0f, getResources()), 0, BaseAIOUtils.f(20.0f, getResources()), 0);
            this.f213476d.addView(relativeLayout, layoutParams3);
            this.f213477e = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = BaseAIOUtils.f(60.0f, getResources());
            layoutParams4.addRule(10);
            layoutParams4.addRule(14);
            this.f213477e.setTextColor(-16777216);
            this.f213477e.setTextSize(18.0f);
            this.f213477e.setId(R.id.f165321cr4);
            relativeLayout.addView(this.f213477e, layoutParams4);
            this.f213478f = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.topMargin = BaseAIOUtils.f(6.0f, getResources());
            layoutParams5.addRule(14);
            layoutParams5.addRule(3, R.id.f165321cr4);
            this.f213478f.setTextSize(14.0f);
            this.f213478f.setTextColor(-7829368);
            relativeLayout.addView(this.f213478f, layoutParams5);
            this.f213479h = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams6.addRule(3, R.id.f165321cr4);
            layoutParams6.topMargin = BaseAIOUtils.f(56.0f, getResources());
            this.f213479h.setTextColor(-16777216);
            this.f213479h.setTextSize(14.0f);
            relativeLayout.addView(this.f213479h, layoutParams6);
            this.f213480i = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams7.topMargin = BaseAIOUtils.f(106.0f, getResources());
            layoutParams7.addRule(3, R.id.f165321cr4);
            this.f213480i.setTextSize(14.0f);
            this.f213480i.setTextColor(-7829368);
            relativeLayout.addView(this.f213480i, layoutParams7);
            this.C = new Button(getContext());
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(188.0f, getResources()), BaseAIOUtils.f(51.0f, getResources()));
            layoutParams8.topMargin = BaseAIOUtils.f(296.0f, getResources());
            layoutParams8.addRule(10);
            layoutParams8.addRule(14);
            this.C.setText(HardCodeUtil.qqStr(R.string.u2y));
            this.C.setTextColor(-1);
            this.C.setBackgroundResource(R.drawable.common_btn_blue);
            this.f213476d.addView(this.C, layoutParams8);
            this.f213481m = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(BaseAIOUtils.f(92.0f, getResources()), BaseAIOUtils.f(92.0f, getResources()));
            layoutParams9.addRule(10);
            layoutParams9.addRule(14);
            this.f213481m.setBackgroundColor(0);
            this.f213476d.addView(this.f213481m, layoutParams9);
            this.D.setBackgroundDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412143112_EarvNaW2y5.png"));
            this.f213477e.setText(qQGameMsgInfo.title);
            this.f213478f.setText(qQGameMsgInfo.dateTitle);
            this.f213479h.setText(qQGameMsgInfo.contentText);
            this.f213479h.setMaxLines(3);
            this.f213479h.setEllipsize(TextUtils.TruncateAt.END);
            this.f213480i.setText(qQGameMsgInfo.limitText);
            this.f213481m.setImageDrawable(URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190408192858_cRS59qwdjG.png"));
            this.C.setBackgroundDrawable(com.tencent.mobileqq.qqgamepub.data.b.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
            this.C.setOnClickListener(new a(context, qQGameMsgInfo, i3, str));
            this.f213476d.setOnClickListener(new b(context, qQGameMsgInfo, i3, str));
            addView(this.f213476d, layoutParams);
        } catch (Throwable th5) {
            QLog.e("TextHeaderView", 2, "textHeader parse error " + th5.toString());
        }
    }

    public void c(HippyArray hippyArray) {
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

    public void d() {
        b(((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getMsgInfoByHippyMap(this.F), BaseApplication.getContext(), ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getMsgPosByHippyMap(this.F), GamePubAccountHelper.s());
    }

    public void e() {
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
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
        this.F = hippyMap;
    }

    @Override // com.tencent.mobileqq.qqgamepub.view.a
    public void onDestory() {
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
